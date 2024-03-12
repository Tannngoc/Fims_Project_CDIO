package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
	
import model.Cart;

public class CartDAO implements DAOInterface<Cart>{
	
	public static AdministratorDAO getInstance() {
		return new AdministratorDAO();	
	}
	
	@Override
	public ArrayList<Cart> selectAll() {
		ArrayList<Cart> ketQua = new ArrayList<Cart>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM cart";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("CARD_ID");
				int customer_id = rs.getInt("CUTOMER_ID");
				int mobile_id = rs.getInt("MOBILE_ID");
				int quantity = rs.getInt("QUANTITY");
								

				Cart ac = new Cart(id, customer_id, mobile_id, quantity);
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
	public Cart selectById(Cart t) {
		Cart ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM cart_items WHERE CARD_ID=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				int id = rs.getInt(1);
				int customer_id = rs.getInt(2);
				int mobile_id = rs.getInt(3);
				int quantity = rs.getInt(4);
				
				ketQua = new Cart(id, customer_id, mobile_id, quantity);
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
	
	public ArrayList<Cart> selectAllByCusId(int cus_id) {
		ArrayList<Cart> ketQua = new ArrayList<Cart>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM cart_items WHERE CUSTOMER_ID=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cus_id);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("CARD_ID");
				int customer_id = rs.getInt("CUTOMER_ID");
				int mobile_id = rs.getInt("MOBILE_ID");
				int quantity = rs.getInt("QUANTITY");
								

				Cart ac = new Cart(id, customer_id, mobile_id, quantity);
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
	public int insert(Cart t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO cart(CARD_ID, CUSTOMER_NAME, PRODUCT_ID, QUANTITY) "+
					" VALUES (?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setInt(2, t.getCustomer_id());
			st.setInt(3, t.getProduct_id());
			st.setInt(4, t.getQuantity());
			
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
	public int insertAll(ArrayList<Cart> arr) {
		int dem = 0;
		for (Cart cartItem : arr) {
			dem+=this.insert(cartItem);
		}
		return dem;
	}

	@Override
	public int delete(Cart t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from cart "+ " WHERE CARD_ID=?";
			
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
	public int deleteAll(ArrayList<Cart> arr) {
		int dem = 0;
		for (Cart cartItems : arr) {
			dem+=this.delete(cartItems);
		}
		return dem;	
	}

	@Override
	public int update(Cart t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE cart" +
					 " SET " +
					 " CARD_ID=?"+
					 ", CUSTOMER_ID =?"+
					 ", MOBILE_ID=?"+
					 " QUANTITY=?"+
					 " WHERE CARD_ID=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setInt(2, t.getCustomer_id());
			st.setInt(3, t.getProduct_id());
			st.setInt(4, t.getQuantity());
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
