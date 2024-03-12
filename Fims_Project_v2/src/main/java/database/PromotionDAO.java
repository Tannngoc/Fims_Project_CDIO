package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Promotion;

public class PromotionDAO implements DAOInterface<Promotion>{

	
	public static PromotionDAO getInstance() {
		return new PromotionDAO();
	}
	
	@Override
	public ArrayList<Promotion> selectAll() {
		ArrayList<Promotion> ketQua = new ArrayList<Promotion>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM promotion";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				String code = rs.getString(2);
				float discount_percentage = rs.getInt(3);
				boolean is_one_time = rs.getBoolean(4);
				boolean status = rs.getBoolean(5);
				Date end_at = rs.getDate(6);
				Date created_at = rs.getDate(7);
				Date altered_at = rs.getDate(8);
				int admin_id = rs.getInt(9);
				
								
				Promotion ac = new Promotion(id, code, discount_percentage,is_one_time, status, end_at, created_at, altered_at, admin_id);
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
	public Promotion selectById(Promotion t) {
		Promotion ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM promotion WHERE promotion_ID=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				int id = rs.getInt(1);
				String code = rs.getString(2);
				float discount_percentage = rs.getInt(3);
				boolean is_one_time = rs.getBoolean(4);
				boolean status = rs.getBoolean(5);
				Date end_at = rs.getDate(6);
				Date created_at = rs.getDate(7);
				Date altered_at = rs.getDate(8);
				int admin_id = rs.getInt(9);
				
				ketQua = new  Promotion(id, code, discount_percentage,is_one_time, status, end_at, created_at, altered_at, admin_id);
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
	public int insert(Promotion t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO promotion (1, 2, 3, 4, 5, 6,7 ,8, 9) "+
					" VALUES (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setString(2, t.getCode());
			st.setFloat(3, t.getDiscount_percentage());
			st.setBoolean(4, t.isIs_one_time());
			st.setBoolean(5, t.isStatus());
			st.setDate(6, t.getEnd_at());
			st.setDate(7, t.getCreated_at());
			st.setDate(8, t.getAltered_at());
			st.setInt(9	, t.getAdmin_id());
			
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
	public int insertAll(ArrayList<Promotion> arr) {
		int dem = 0;
		for (Promotion promotion : arr) {
			dem+=this.insert(promotion);
		}	
		return dem;
	}

	@Override
	public int delete(Promotion t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from promotion "+
					 " WHERE Promotion_ID=?";
			
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
	public int deleteAll(ArrayList<Promotion> arr) {
		int dem = 0;	
		for (Promotion promotion : arr) {
			dem+=this.delete(promotion);
		}
		return dem;
	}

	@Override
	public int update(Promotion t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE promotion "+
					 " SET " +
					 " promotion_ID=?"+
					 ", promotion_CODE=?"+
					 ", DISCOUNT_PERCENTAGE=?"+
					 " IS_ONE_TIME=?"+
					 " promotion_STATUS=?"+
					 ", END_AT=?"+
					 " CRWATED_AT=?"+
					 " ALTERED_AT=?"+
					 ", ADMIN_ID=?"+
					 " WHERE ID=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, t.getId());
			st.setString(2, t.getCode());
			st.setFloat(3, t.getDiscount_percentage());
			st.setBoolean(4, t.isIs_one_time());
			st.setBoolean(5, t.isStatus());
			st.setDate(6, t.getEnd_at());
			st.setDate(7, t.getCreated_at());
			st.setDate(8, t.getAltered_at());
			st.setInt(9	, t.getAdmin_id());
			
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
