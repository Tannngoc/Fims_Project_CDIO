package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Administrator;
import model.Customer;

public class CustomerDAO implements DAOInterface<Customer> {

	public static CustomerDAO getInstance() {
		return new CustomerDAO();
	}

	@Override
	public ArrayList<Customer> selectAll() {
		ArrayList<Customer> ketQua = new ArrayList<Customer>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM customer";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				boolean gender = rs.getBoolean(3);
				Date birthdate = rs.getDate(4);
				String address = rs.getString(5);
				String email = rs.getString(6);
				int telephone = rs.getInt(7);
				Date created_at = rs.getDate(8);
				Date altered_at = rs.getDate(9);
				int account_id = rs.getInt(10);

				Customer ac = new Customer(id, name, gender, birthdate, address, email, telephone, created_at, altered_at,
						account_id);
				ketQua.add(ac);
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
	public Customer selectById(Customer t) {
		Customer ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM customer WHERE customer_ID=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				boolean gender = rs.getBoolean(3);
				Date birthdate = rs.getDate(4);
				String address = rs.getString(5);
				String email = rs.getString(6);
				int telephone = rs.getInt(7);
				Date created_at = rs.getDate(8);
				Date altered_at = rs.getDate(9);
				int account_id = rs.getInt(10);

				ketQua = new Customer(id, name, gender, birthdate, address, email, telephone, created_at, altered_at,
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
	public int insert(Customer t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO customer (CUSTOMER_ID, CUSTOMER_NAME, GENDER, BIRTHDATE, ADDRESS, EMAIL,TELEPHONE, CREATED_AT, ALTERED_AT,ACCOUNT_ID) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setString(2, t.getName());
			st.setBoolean(3, t.getGender());
			st.setDate(4, t.getBirthdate());
			st.setString(5, t.getAddress());
			st.setString(6, t.getEmail());
			st.setInt(7, t.getTelephone());
			st.setDate(8, t.getCreated_at());
			st.setDate(9, t.getAltered_at());
			st.setInt(10, t.getAccount_id());

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
	public int insertAll(ArrayList<Customer> arr) {
		int dem = 0;
		for (Customer customer : arr) {
			dem += this.insert(customer);
		}
		return dem;
	}

	@Override
	public int delete(Customer t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from customer " + " WHERE CUSTOMER_ID=?";

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
	public int deleteAll(ArrayList<Customer> arr) {
		int dem = 0;
		for (Customer customer : arr) {
			dem += this.delete(customer);
		}
		return dem;
	}

	@Override
	public int update(Customer t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE customer " + " SET " + " CUSTOMER_ID=?" + ", CUSTOMER_NAME=?" + ", GENDER=?" + ", BIRTHDATE=?" + ", ADDRESS=?"+", EMAIL=?"
					+ ", TELEPHONE=?" + " CREATED_AT=?" + ", ALTERED_AT=?" + ", ACCOUNT_ID=?" + " WHERE ID=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setString(2, t.getName());
			st.setBoolean(3, t.getGender());
			st.setDate(4, t.getBirthdate());
			st.setString(5, t.getAddress());
			st.setString(6, t.getEmail());
			st.setInt(7, t.getTelephone());
			st.setDate(8, t.getCreated_at());
			st.setDate(9, t.getAltered_at());
			st.setInt(10, t.getAccount_id());

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
	
	public Customer selectByAccId(Customer t) {
		Customer ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM customer WHERE ACCOUNT_ID=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				boolean gender = rs.getBoolean(3);
				Date birthdate = rs.getDate(4);
				String address = rs.getString(5);
				String email = rs.getString(6);
				int telephone = rs.getInt(7);
				Date created_at = rs.getDate(8);
				Date altered_at = rs.getDate(9);
				int account_id = rs.getInt(10);

				ketQua = new Customer(id, name, gender, birthdate, address, email, telephone, created_at, altered_at,
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
}
