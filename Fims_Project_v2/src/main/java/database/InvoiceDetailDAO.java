package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.InvoiceDetail;

public class InvoiceDetailDAO implements DAOInterface<InvoiceDetail>{

	public static InvoiceDetailDAO getInstance() {
		return new InvoiceDetailDAO();	
	}
	
	@Override
	public ArrayList<InvoiceDetail> selectAll() {
		ArrayList<InvoiceDetail> ketQua = new ArrayList<InvoiceDetail>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM invoice_details";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				int invoice_id = rs.getInt(2);
				int product_id = rs.getInt(3);
				int quantity = rs.getInt(4);
				int toltal_cost = rs.getInt(5);

				InvoiceDetail ac = new InvoiceDetail(id, invoice_id, product_id, quantity, toltal_cost);
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
	public InvoiceDetail selectById(InvoiceDetail t) {
		InvoiceDetail ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM invoice_details WHERE ID=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				int id = rs.getInt(1);
				int invoice_id = rs.getInt(2);
				int product_id = rs.getInt(3);
				int quantity = rs.getInt(4);
				int toltal_cost = rs.getInt(5);
				
				ketQua = new InvoiceDetail(id, invoice_id, product_id, quantity,toltal_cost);
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
	public int insert(InvoiceDetail t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO cart_items (1, 2, 3, 4, 5) "+
					" VALUES (?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setInt(2, t.getInvoice_id());
			st.setInt(3, t.getProduct_id());
			st.setInt(4, t.getQuantity());
			st.setInt(5, t.getToltal_cost());
			
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
	public int insertAll(ArrayList<InvoiceDetail> arr) {
		int dem = 0;
		for (InvoiceDetail invoiceDetail : arr) {
			dem+=this.insert(invoiceDetail);
		}
		return dem;
	}

	@Override
	public int delete(InvoiceDetail t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from invoice_details "+
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
	public int deleteAll(ArrayList<InvoiceDetail> arr) {
		int dem = 0;
		for (InvoiceDetail invoiceDetail : arr) {
			dem+=this.delete(invoiceDetail);
		}
		return dem;	
	}

	@Override
	public int update(InvoiceDetail t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE invoice_details"+
					 " SET " +
					 " ID=?"+
					 ", INVOICE_ID =?"+
					 ", MOBILE_ID=?"+
					 " QUANTITY=?"+
					 " TOLTAL_COST=?"+
					 " WHERE ID=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setInt(2, t.getInvoice_id());
			st.setInt(3, t.getProduct_id());
			st.setInt(4, t.getQuantity());
			st.setInt(5, t.getToltal_cost());
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
