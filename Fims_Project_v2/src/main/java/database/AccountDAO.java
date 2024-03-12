package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Account;

public class AccountDAO implements DAOInterface<Account>{
	
	public static AccountDAO getInstance() {
		return new AccountDAO();
	}
	@Override
	public ArrayList<Account> selectAll() {
		ArrayList<Account> ketQua = new ArrayList<Account>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM accounts";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String avatar = rs.getString(4);
				int role = rs.getInt(5);
				Date created_at = rs.getDate(6);
				Date altered_at = rs.getDate(7);
				

				Account ac = new Account(id, username, password, avatar, role, created_at, altered_at);
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
	public Account selectById(Account t) {
		Account ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM accounts WHERE ACCOUNT_ID=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				int id = rs.getInt("ACCOUNT_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD_ACC");
				String avatar = rs.getString("AVATAR");
				int role = rs.getInt("ROLE_ID");
				Date created_at = rs.getDate("CREATED_AT");
				Date altered_at = rs.getDate("ALTERED_AT");
				
				ketQua = new Account(id, username, password, avatar, role, created_at, altered_at);
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
	
	public Account selectByUsernameAndPassWord(Account t) {
		Account ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM accounts WHERE USERNAME=? AND PASSWORD_ACC=? ";
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, t.getUsername());
			st.setString(2, t.getPassword());
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("ACCOUNT_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD_ACC");
				String avatar = rs.getString("AVATAR");
				int role = rs.getInt("ROLE_ID");
				Date created_at = rs.getDate("CREATED_AT");
				Date altered_at = rs.getDate("ALTERED_AT");
				
				ketQua = new Account(id, username, password, avatar, role, created_at, altered_at);
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
	public int insert(Account t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO accounts (USERNAME, PASSWORD_ACC, AVATAR, ROLE_ID, CREATED_AT, ALTERED_AT) "+
					" VALUES (?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUsername());
			st.setString(2, t.getPassword());
			st.setString(3, t.getAvatar());
			st.setInt(4, t.getRole());
			st.setDate(5, t.getCreated_at());
			st.setDate(6, t.getAltered_at());
			
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
	public int insertAll(ArrayList<Account> arr) {
		int dem = 0;
		for (Account account : arr) {
			dem+=this.insert(account);
		}
		return dem;
	}
	
	@Override
	public int delete(Account t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from accounts "+
					 " WHERE ACCOUT_ID=?";
			
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
	public int deleteAll(ArrayList<Account> arr) {
		int dem = 0;
		for (Account account : arr) {
			dem+=this.delete(account);
		}
		return dem;	
	}
	@Override
	public int update(Account t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE accounts "+
					 " SET " +
					 " ACCOUNT_ID=?"+
					 ", USERNAME =?"+
					 ", PASSWORD_ACC=?"+
					 " AVATAR=?"+
					 ", ROLES=?"+
					 ", CREATED_AT=?"+
					 ", ALTERED_AT=?"+
					 " WHERE ACCOUNT_ID=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setString(2, t.getUsername());
			st.setString(3, t.getPassword());
			st.setString(4, t.getAvatar());
			st.setInt(2, t.getRole());
			st.setDate(3, t.getCreated_at());
			st.setDate(4, t.getAltered_at());
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
	public Boolean checkLogin(String username) {
		boolean ketQua = false;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM accounts WHERE USERNAME=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(2,username);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				ketQua = true;
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	 public static void main(String[] args) {
	        // Tạo một đối tượng Account để truy vấn
		 	AccountDAO ac = new AccountDAO();
	        Account accountToQuery = new Account();
	        accountToQuery = ac.selectByUsernameAndPassWord(new Account(0, "user1", "password1", null, 0, null, null));
	        System.out.println(accountToQuery);
	        
	        
//	        Account tg = accountDAO.selectById(new Account(2, null, null, null, 0, null, null));
//			System.out.println(tg);
//	        System.out.println(accountDAO.selectAll().toString());
	    }
}
