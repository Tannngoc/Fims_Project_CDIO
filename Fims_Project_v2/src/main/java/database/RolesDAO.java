package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Promotion;
import model.Roles;

public class RolesDAO implements DAOInterface<Roles>{
	
	public static RolesDAO getInstance() {
		return new RolesDAO();
	}

	@Override
	public ArrayList<Roles> selectAll() {
		ArrayList<Roles> ketQua = new ArrayList<Roles>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM roles";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);			
								

				Roles ac = new Roles(id, name);
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
	public Roles selectById(Roles t) {
		Roles ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM roles WHERE ROLE_ID=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				
				ketQua = new Roles(id, name);
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
	public int insert(Roles t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO roles (ROLE_ID, NAME_ROLE) "+
					" VALUES (?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setString(2, t.getName());
			
			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<Roles> arr) {
		int dem = 0;
		for (Roles roles: arr) {
			dem+=this.insert(roles);
		}	
		return dem;
	}

	@Override
	public int delete(Roles t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from roles	 "+
					 " WHERE ID=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<Roles> arr) {
		int dem = 0;	
		for (Roles roles: arr) {
			dem+=this.delete(roles);
		}
		return dem;
	}

	@Override
	public int update(Roles t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE roles "+
					 " SET " +
					 " ROLE_ID=?"+
					 ", NAME_ROLE=?"+
					 " WHERE ID=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, t.getId());
			st.setString(2, t.getName());
			
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

}
