package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Account;
import model.Administrator;

public class AdministratorDAO implements DAOInterface<Administrator> {

	public static AdministratorDAO getInstance() {
		return new AdministratorDAO();
	}

	@Override
	public ArrayList<Administrator> selectAll() {
		ArrayList<Administrator> ketQua = new ArrayList<Administrator>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM administrator";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("ADMIN_ID");
				String name = rs.getString("ADMIN_NAME");
				boolean gender = rs.getBoolean("gender");
				Date birthdate = rs.getDate("BIRTHDATE");
				String email = rs.getString("EMAIL");
				int telephone = rs.getInt("TELEPHONE");
				Date created_at = rs.getDate("CREATED_AT");
				Date altered_at = rs.getDate("ALTERED_AT");
				int account_id = rs.getInt("ACCOUNT_ID");

				Administrator ad = new Administrator(id, name, gender, birthdate, email, telephone, created_at,
						altered_at, account_id);
				ketQua.add(ad);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public Administrator selectById(Administrator t) {
		Administrator ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM administrator WHERE ADMIN_ID=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("ADMIN_ID");
				String name = rs.getString("ADMIN_NAME");
				boolean gender = rs.getBoolean("gender");
				Date birthdate = rs.getDate("BIRTHDATE");
				String email = rs.getString("EMAIL");
				int telephone = rs.getInt("TELEPHONE");
				Date created_at = rs.getDate("CREATED_AT");
				Date altered_at = rs.getDate("ALTERED_AT");
				int account_id = rs.getInt("ACCOUNT_ID");

				ketQua = new Administrator(id, name, gender, birthdate, email, telephone, created_at, altered_at,
						account_id);
				break;
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insert(Administrator t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO administrator (ADMIN_ID, ADMIN_NAME, gender, BIRTHDATE, EMAIL,TELEPHONE, CREATED_AT, ALTERED_AT,ACCOUNT_ID) "
					+ " VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setString(2, t.getName());
			st.setBoolean(3, t.getgender());
			st.setDate(4, t.getBirthdate());
			st.setString(5, t.getEmail());
			st.setInt(6, t.getTelephone());
			st.setDate(7, t.getCreated_at());
			st.setDate(8, t.getAltered_at());

			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<Administrator> arr) {
		int dem = 0;
		for (Administrator administrator : arr) {
			dem += this.insert(administrator);
		}
		return dem;
	}

	@Override
	public int delete(Administrator t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from administrator " + " WHERE ADMIN_ID=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<Administrator> arr) {
		int dem = 0;
		for (Administrator administrator : arr) {
			dem += this.delete(administrator);
		}
		return dem;
	}

	@Override
	public int update(Administrator t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE administrator " + " SET " + " ADMIN_ID=?" + ", ADMIN_NAME=?" + ", gender=?" + " BIRTHDATE=?"
					+ ", EMAIL=?" + ", TELEPHONE=?" + " CREATED_AT=?" + ", ALTERED_AT=?" + ", ACCOUNT_ID=?"
					+ " WHERE ADMIN_ID=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setString(2, t.getName());
			st.setBoolean(3, t.getgender());
			st.setDate(4, t.getBirthdate());
			st.setString(5, t.getEmail());
			st.setInt(6, t.getTelephone());
			st.setDate(7, t.getCreated_at());
			st.setDate(8, t.getAltered_at());
			st.setInt(9, t.getAccount_id());

			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

}