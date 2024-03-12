package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Promotion;
import model.Rating;

public class RatingDAO implements DAOInterface<Rating>{
	
	public static RatingDAO getInstance() {
		return new RatingDAO();
	}

	@Override
	public ArrayList<Rating> selectAll() {
		ArrayList<Rating> ketQua = new ArrayList<Rating>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM rating";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				int customer_id = rs.getInt(2);
				int mobile_id = rs.getInt(3);
				int rate_star = rs.getInt(4);
				String content = rs.getString(5);
				Date created_at = rs.getDate(6);
				Date altered_at = rs.getDate(7);				
								

				Rating ac = new Rating(id, customer_id, mobile_id, rate_star, content, created_at, altered_at);
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
	public Rating selectById(Rating t) {
		Rating	 ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM rating WHERE Rating_ID=?";
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
				int rate_star = rs.getInt(4);
				String content = rs.getString(5);
				Date created_at = rs.getDate(6);
				Date altered_at = rs.getDate(7);	
				
				ketQua = new Rating(id, customer_id, mobile_id, rate_star, content, created_at, altered_at);
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
	public int insert(Rating t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO rating (Rating_ID, CUSTOMER_ID, PRODUCT_ID, RATE_STAR, CONTENT, CREATED_AT, ALTERED_AT) "+
					" VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setInt(2, t.getCustomer_id());
			st.setInt(3, t.getProduct_id());
			st.setInt(4, t.getRate_star());
			st.setString(5, t.getContent());
			st.setDate(7, t.getCreated_at());
			st.setDate(8, t.getAltered_at());
			
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
	public int insertAll(ArrayList<Rating> arr) {
		int dem = 0;
		for (Rating rating : arr) {
			dem+=this.insert(rating);
		}	
		return dem;
	}

	@Override
	public int delete(Rating t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from rating "+
					 " WHERE RATING_ID=?";
			
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
	public int deleteAll(ArrayList<Rating> arr) {
		int dem = 0;	
		for (Rating rating: arr) {
			dem+=this.delete(rating);
		}
		return dem;
	}

	@Override
	public int update(Rating t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE rating "+
					 " SET " +
					 " RATING_ID=?"+
					 ", CUSTOMER_ID=?"+
					 ", PRODUCT_ID=?"+
					 " RATE_STAR=?"+
					 " CONTENT=?"+
					 " CRWATED_AT=?"+
					 " ALTERED_AT=?"+
					 " WHERE RATING_ID=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, t.getId());
			st.setInt(2, t.getCustomer_id());
			st.setInt(3, t.getProduct_id());
			st.setInt(4, t.getRate_star());
			st.setString(5, t.getContent());
			st.setDate(7, t.getCreated_at());
			st.setDate(8, t.getAltered_at());
			
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
