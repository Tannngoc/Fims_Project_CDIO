package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cart;
import model.CartItems;
import model.Product;

public class ProductDAO implements DAOInterface<Product> {

	public static ProductDAO getInstance() {
		return new ProductDAO();
	}

	@Override
	public ArrayList<Product> selectAll() {
		ArrayList<Product> ketQua = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM products";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				String nameProduct = rs.getString(2);
				String screen = rs.getString(3);
				String operating_system = rs.getString(4);
				String color = rs.getString(5);
				int rear_camera = rs.getInt(6);
				int front_camera = rs.getInt(7);
				String chip = rs.getString(8);
				int ram = rs.getInt(9);
				int rom = rs.getInt(10);
				String sim = rs.getString(11);
				String connect = rs.getString(12);
				int battery = rs.getInt(13);
				String descripe = rs.getString(14);
				int quantity = rs.getInt(15);
				int cost = rs.getInt(16);
				Date created_at = rs.getDate(17);
				Date altered_at = rs.getDate(18);
				int category_id = rs.getInt(19);
				int company_id = rs.getInt(20);
				int admin_id = rs.getInt(21);

				Product products = new Product(id, nameProduct, screen, operating_system, color, rear_camera,
						front_camera, chip, ram, rom, sim, connect, battery, descripe, quantity, cost, created_at,
						altered_at, category_id, company_id, admin_id);
				ketQua.add(products);
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
	public Product selectById(Product t) {
		Product ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM products WHERE ID=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				String nameProduct = rs.getString(2);
				String screen = rs.getString(3);
				String operating_system = rs.getString(4);
				String color = rs.getString(5);
				int rear_camera = rs.getInt(6);
				int front_camera = rs.getInt(7);
				String chip = rs.getString(8);
				int ram = rs.getInt(9);
				int rom = rs.getInt(10);
				String sim = rs.getString(11);
				String connect = rs.getString(12);
				int battery = rs.getInt(13);
				String descripe = rs.getString(14);
				int quantity = rs.getInt(15);
				int cost = rs.getInt(16);
				Date created_at = rs.getDate(17);
				Date altered_at = rs.getDate(18);
				int category_id = rs.getInt(19);
				int company_id = rs.getInt(20);
				int admin_id = rs.getInt(21);

				Product ac = new Product(id, nameProduct, screen, operating_system, color, rear_camera, front_camera,
						chip, ram, rom, sim, connect, battery, descripe, quantity, cost, created_at, altered_at,
						category_id, company_id, admin_id);
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
	public int insert(Product t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO products (product_name, screen, operating_system, color, rear_camera, front_camera, chip, ram, rom, sim, connect, battery, pro_description, quantity, cost, created_at, altered_at, category_id, model_id, admin_id) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getNameProduct());
			st.setString(2, t.getScreen());
			st.setString(3, t.getOperating_system());
			st.setString(4, t.getColor());
			st.setInt(5, t.getRear_camera());
			st.setInt(6, t.getFront_camera());
			st.setString(7, t.getChip());
			st.setInt(8, t.getRam());
			st.setInt(9, t.getRom());
			st.setString(10, t.getSim());
			st.setString(11, t.getConect());
			st.setInt(12, t.getBattery());
			st.setString(13, t.getDescribe());
			st.setInt(14, t.getQuantity());
			st.setInt(15, t.getCost());
			st.setDate(16, t.getCreated_at());
			st.setDate(17, t.getAltered_at());
			st.setInt(18, t.getCategory_id());
			st.setInt(19, t.getCompany_id());
			st.setInt(20, t.getAdmin_id());
			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			System.out.println("Da xay ra loi");
		}

		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<Product> arr) {
		int dem = 0;
		for (Product product : arr) {
			dem += this.insert(product);
		}
		return dem;
	}

	@Override
	public int delete(Product t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from products " + " WHERE ID=?";

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
	public int deleteAll(ArrayList<Product> arr) {
		int dem = 0;
		for (Product product : arr) {
			dem += this.delete(product);
		}
		return dem;
	}

	@Override
	public int update(Product t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE products " + " SET " + " ID=?" + " NAMEPRODUCT=?" + ", SCREEN=?"
					+ ", OPERATING_SYSTEM=?" + " COLOR=?" + " REAR_CAMERA=?" + ", FRONT_CAMERA=?" + " CHIP=?"
					+ ", RAM=?" + ", ROM=?" + " SIM=?" + " CONNECT_=?" + ", BATTERY=?" + " DESCRIPE=?" + ", QUANTITY=?"
					+ ", COST=?" + " CREATED_AT=?" + " ALTERED_AT=?" + ", CATEGORY_ID=?" + " COMPANY_ID=?"
					+ ", ADMIN_ID=?" + " WHERE ID=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setString(2, t.getNameProduct());
			st.setString(3, t.getScreen());
			st.setString(4, t.getOperating_system());
			st.setString(5, t.getColor());
			st.setInt(6, t.getRear_camera());
			st.setInt(7, t.getFront_camera());
			st.setString(8, t.getChip());
			st.setInt(9, t.getRam());
			st.setInt(10, t.getRom());
			st.setString(11, t.getSim());
			st.setString(12, t.getConect());
			st.setInt(13, t.getBattery());
			st.setString(14, t.getDescribe());
			st.setInt(15, t.getQuantity());
			st.setInt(16, t.getCost());
			st.setDate(17, t.getCreated_at());
			st.setDate(18, t.getAltered_at());
			st.setInt(19, t.getCategory_id());
			st.setInt(20, t.getCompany_id());
			st.setInt(21, t.getAdmin_id());
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

	public ArrayList<Product> selectIphone() {
		ArrayList<Product> ketQua = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM products WHERE Model_ID = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, 1); // Assuming category_id for iPhones is 1, adjust this value according to your
								// database design

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				String nameProduct = rs.getString(2);
				String screen = rs.getString(3);
				String operating_system = rs.getString(4);
				String color = rs.getString(5);
				int rear_camera = rs.getInt(6);
				int front_camera = rs.getInt(7);
				String chip = rs.getString(8);
				int ram = rs.getInt(9);
				int rom = rs.getInt(10);
				String sim = rs.getString(11);
				String connect = rs.getString(12);
				int battery = rs.getInt(13);
				String descripe = rs.getString(14);
				int quantity = rs.getInt(15);
				int cost = rs.getInt(16);
				Date created_at = rs.getDate(17);
				Date altered_at = rs.getDate(18);
				int category_id = rs.getInt(19);
				int company_id = rs.getInt(20);
				int admin_id = rs.getInt(21);

				Product product = new Product(id, nameProduct, screen, operating_system, color, rear_camera,
						front_camera, chip, ram, rom, sim, connect, battery, descripe, quantity, cost, created_at,
						altered_at, category_id, company_id, admin_id);
				ketQua.add(product);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public ArrayList<Product> selectAllByModelId(String cid) {
		ArrayList<Product> ketQua = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM products where Model_Id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, cid);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				String nameProduct = rs.getString(2);
				String screen = rs.getString(3);
				String operating_system = rs.getString(4);
				String color = rs.getString(5);
				int rear_camera = rs.getInt(6);
				int front_camera = rs.getInt(7);
				String chip = rs.getString(8);
				int ram = rs.getInt(9);
				int rom = rs.getInt(10);
				String sim = rs.getString(11);
				String connect = rs.getString(12);
				int battery = rs.getInt(13);
				String descripe = rs.getString(14);
				int quantity = rs.getInt(15);
				int cost = rs.getInt(16);
				Date created_at = rs.getDate(17);
				Date altered_at = rs.getDate(18);
				int category_id = rs.getInt(19);
				int company_id = rs.getInt(20);
				int admin_id = rs.getInt(21);

				Product products = new Product(id, nameProduct, screen, operating_system, color, rear_camera,
						front_camera, chip, ram, rom, sim, connect, battery, descripe, quantity, cost, created_at,
						altered_at, category_id, company_id, admin_id);
				ketQua.add(products);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public Product selectByProductId(String p) {
		try {
			String sql = "select * from Products where product_id = ?";
			Connection con = JDBCUtil.getConnection();
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, p);

			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				String nameProduct = rs.getString(2);
				String screen = rs.getString(3);
				String operating_system = rs.getString(4);
				String color = rs.getString(5);
				int rear_camera = rs.getInt(6);
				int front_camera = rs.getInt(7);
				String chip = rs.getString(8);
				int ram = rs.getInt(9);
				int rom = rs.getInt(10);
				String sim = rs.getString(11);
				String connect = rs.getString(12);
				int battery = rs.getInt(13);
				String descripe = rs.getString(14);
				int quantity = rs.getInt(15);
				int cost = rs.getInt(16);
				Date created_at = rs.getDate(17);
				Date altered_at = rs.getDate(18);
				int category_id = rs.getInt(19);
				int company_id = rs.getInt(20);
				int admin_id = rs.getInt(21);

				return new Product(id, nameProduct, screen, operating_system, color, rear_camera, front_camera, chip,
						ram, rom, sim, connect, battery, descripe, quantity, cost, created_at, altered_at, category_id,
						company_id, admin_id);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Product> selectAllByName(String txtSearch) {
		ArrayList<Product> ketQua = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM products where product_name like ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + txtSearch + "%");

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				String nameProduct = rs.getString(2);
				String screen = rs.getString(3);
				String operating_system = rs.getString(4);
				String color = rs.getString(5);
				int rear_camera = rs.getInt(6);
				int front_camera = rs.getInt(7);
				String chip = rs.getString(8);
				int ram = rs.getInt(9);
				int rom = rs.getInt(10);
				String sim = rs.getString(11);
				String connect = rs.getString(12);
				int battery = rs.getInt(13);
				String descripe = rs.getString(14);
				int quantity = rs.getInt(15);
				int cost = rs.getInt(16);
				Date created_at = rs.getDate(17);
				Date altered_at = rs.getDate(18);
				int category_id = rs.getInt(19);
				int company_id = rs.getInt(20);
				int admin_id = rs.getInt(21);

				Product products = new Product(id, nameProduct, screen, operating_system, color, rear_camera,
						front_camera, chip, ram, rom, sim, connect, battery, descripe, quantity, cost, created_at,
						altered_at, category_id, company_id, admin_id);
				ketQua.add(products);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public ArrayList<CartItems> getCartProducts(ArrayList<CartItems> cartList) {
	    ArrayList<CartItems> products = new ArrayList<>();
	    try {
	        if (cartList.size() > 0) {
	            Connection con = JDBCUtil.getConnection();
	            String sql = "SELECT * FROM Products WHERE product_id = ?";
	            PreparedStatement st = con.prepareStatement(sql);
	            
	            for (CartItems c : cartList) {
	                st.setInt(1, c.getId()); // Thiết lập giá trị tham số
	                
	                ResultSet rs = st.executeQuery();
	                while (rs.next()) {
	                    CartItems row = new CartItems();
	                    row.setId(rs.getInt("id"));
	                    row.setNameProduct(rs.getString("name"));
	                    row.setCost(rs.getInt("price"));
	                    row.setQuantity(c.getQuantity()); // Sử dụng số lượng từ cartList
	                    products.add(row);
	                }
	            }
	            
	            JDBCUtil.closeConnection(con);
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        e.printStackTrace();
	    }
	    return products;
	}

}
