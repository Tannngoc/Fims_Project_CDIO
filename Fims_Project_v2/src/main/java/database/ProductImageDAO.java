package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.PaymentDetail;
import model.Product;
import model.ProductImage;

public class ProductImageDAO implements DAOInterface<ProductImage>{
	
	public static ProductImageDAO getInstance() {
		return new ProductImageDAO();	
	}

	@Override
	public ArrayList<ProductImage> selectAll() {
		ArrayList<ProductImage> ketQua = new ArrayList<ProductImage>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM Product_Image";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				int product_id = rs.getInt(2);
				int model_id = rs.getInt(3);
				String image = rs.getString(4);						

				ProductImage ac = new ProductImage(id, product_id, model_id, image);
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
	public ProductImage selectById(ProductImage t) {
		ProductImage ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM Product_image WHERE IMAGE_ID=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				int id = rs.getInt(1);
				int product_id = rs.getInt(2);
				int model_id = rs.getInt(3);
				String image = rs.getString(4);	
				
				ketQua = new ProductImage(id, product_id, model_id, image);
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
	public int insert(ProductImage t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO Product_image (Product_Id, Model_Id, images) "+
					" VALUES (?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getProduct_id());
			st.setInt(2, t.getModel_id());
			st.setString(3, t.getImage());
			
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
	public int insertAll(ArrayList<ProductImage> arr) {
		int dem = 0;
		for (ProductImage productImage : arr) {
			dem+=this.insert(productImage);
		}	
		return dem;
	}

	@Override
	public int delete(ProductImage t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from Product_image "+
					 " WHERE IMAGE_ID=?";
			
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
	public int deleteAll(ArrayList<ProductImage> arr) {
		int dem = 0;
		for (ProductImage productImage : arr) {
			dem+=this.delete(productImage);
		}
		return dem;
	}

	@Override
	public int update(ProductImage t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE Product_image "+
					 " SET " +
					 " Image_ID=?"+
					 ", Product_ID=?"+
					 ", Model_id=?" +
					 ", IMAGE_=?"+
					 " WHERE ID=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setInt(2, t.getProduct_id());
			st.setString(3, t.getImage());
			
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
	public ArrayList<ProductImage> selectAllByModelId(String cid) {
		ArrayList<ProductImage> ketQua = new ArrayList<ProductImage>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM Product_Image where Model_Id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, cid);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				int product_id = rs.getInt(2);
				int model_id = rs.getInt(3);
				String image = rs.getString(4);		
				
				ProductImage pi = new ProductImage(id, product_id, model_id, image);
				ketQua.add(pi);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	public ProductImage selectByImageId(String p) {
		try {
		String sql = "select * from Product_Image where Image_id = ?";
		Connection con = JDBCUtil.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, p);
		
		System.out.println(sql);
		ResultSet rs = st.executeQuery();
		
		// Bước 4:
		while(rs.next()) {
			int id = rs.getInt(1);
			int product_id = rs.getInt(2);
			int model_id = rs.getInt(3);
			String image = rs.getString(4);	
			return new ProductImage(id, product_id, model_id, image);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<ProductImage> selectAllByName(String txtSearch) {
		ArrayList<ProductImage> ketQua = new ArrayList<ProductImage>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product_image where images like ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,"%" + txtSearch + "%");

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				int product_id = rs.getInt(2);
				int model_id = rs.getInt(3);
				String image = rs.getString(4);		
				
				ProductImage pi = new ProductImage(id, product_id, model_id, image);
				ketQua.add(pi);
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
		ProductImageDAO pid = new ProductImageDAO();
		System.out.println(pid.selectAllByName("iphone"));
	}

}
