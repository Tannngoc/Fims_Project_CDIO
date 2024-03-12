package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.News;

public class NewsDAO implements DAOInterface<News>{

	public static NewsDAO getInstance() {
		return new NewsDAO();	
	}
	
	@Override
	public ArrayList<News> selectAll() {
		ArrayList<News> ketQua = new ArrayList<News>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM news";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String avatar = rs.getString(4);
				Date created_at = rs.getDate(5);
				Date altered_at = rs.getDate(6);
				int admin_id = rs.getInt(7);
								

				News ac = new News(id, title, content, avatar, created_at, altered_at, admin_id);
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
	public News selectById(News t) {
		News ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM news WHERE News_ID=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String avatar = rs.getString(4);
				Date created_at = rs.getDate(5);
				Date altered_at = rs.getDate(6);
				int admin_id = rs.getInt(7);
				
				ketQua = new News(id, title, content, avatar, created_at, altered_at, admin_id);
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
	public int insert(News t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO news (NEWS_ID, TITLE, CONTENT, AVATAR, CREATED_AT, ALTERED_AT,ADMIN_ID) "+
					" VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setString(2, t.getTitle());
			st.setString(3, t.getContent());
			st.setString(4, t.getAvatar());
			st.setDate(5, t.getCreate_at());
			st.setDate(6, t.getAltered_at());
			st.setInt(7, t.getAdmin_id());
			
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
	public int insertAll(ArrayList<News> arr) {
		int dem = 0;
		for (News news : arr) {
			dem+=this.insert(news);
		}	
		return dem;
	}

	@Override
	public int delete(News t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from news "+
					 " WHERE News_Id=?";
			
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
	public int deleteAll(ArrayList<News> arr) {
		int dem = 0;
		for (News news : arr) {
			dem+=this.delete(news);
		}
		return dem;
	}

	@Override
	public int update(News t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE news "+
					 " SET " +
					 " New_ID=?"+
					 ", TITLE=?"+
					 ", CONTENT=?"+
					 " AVATAR=?"+
					 " CREATED_AT=?"+
					 ", ALTERED_AT=?"+
					 ", ADMIN_ID=?"+
					 " WHERE New_ID=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setString(2, t.getTitle());
			st.setString(3, t.getContent());
			st.setString(4, t.getAvatar());
			st.setDate(5, t.getCreate_at());
			st.setDate(6, t.getAltered_at());
			st.setInt(7, t.getAdmin_id());
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
