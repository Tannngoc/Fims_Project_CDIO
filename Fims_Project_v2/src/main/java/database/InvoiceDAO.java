package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Invoice;

public class InvoiceDAO implements DAOInterface<Invoice>{

	public static InvoiceDAO getInstance() {
		return new InvoiceDAO();	
	}
	
	@Override
	public ArrayList<Invoice> selectAll() {
		ArrayList<Invoice> ketQua = new ArrayList<Invoice>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM invoice";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				int total = rs.getInt(2);
				float discount_percentage = rs.getFloat(3);
				Date created_at = rs.getDate(4);
				Date altered_at = rs.getDate(5);
				int customer_id = rs.getInt(6);				

				Invoice ac = new Invoice(id, customer_id, discount_percentage, created_at, altered_at, customer_id);
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
	public Invoice selectById(Invoice t) {
		Invoice ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM invoice WHERE INVOICE_ID=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				int id = rs.getInt(1);
				int total = rs.getInt(2);
				float discount_percentage = rs.getFloat(3);
				Date created_at = rs.getDate(4);
				Date altered_at = rs.getDate(5);
				int customer_id = rs.getInt(6);				

				ketQua = new Invoice(id, customer_id, discount_percentage, created_at, altered_at, customer_id);
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
	public int insert(Invoice t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO invoice (INVOICE_ID, TOTAL, Discount_Percentage, Created_at, Altered_at , CUSTOMER_ID) "+
					" VALUES (?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setInt(2, t.getToltal());
			st.setFloat(3, t.getDiscount_percentage());
			st.setDate(4,t.getCreated_at());
			st.setDate(5, t.getAltered_at());
			st.setInt(6, t.getCustomer_id());
			
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
	public int insertAll(ArrayList<Invoice> arr) {
		int dem = 0;
		for (Invoice invoice : arr) {
			dem+=this.insert(invoice);
		}
		return dem;
	}

	@Override
	public int delete(Invoice t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from invoice "+
					 " WHERE INVOICE_ID=?";
			
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
	public int deleteAll(ArrayList<Invoice> arr) {
		int dem = 0;
		for (Invoice invoice : arr) {
			dem+=this.delete(invoice);
		}
		return dem;	
	}

	@Override
	public int update(Invoice t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE invoice "+
					 " SET " +
					 " INVOICE_ID=?"+
					 ", TOLTAL =?"+
					 " Discount_Percentage=?"+
					 ", Created_at =?"+
					 " Altered_at?"+
					 ", CUSTOMER_ID =?"+
					 " WHERE INVOICE_ID=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setInt(2, t.getToltal());
			st.setFloat(3, t.getDiscount_percentage());
			st.setDate(4,t.getCreated_at());
			st.setDate(5, t.getAltered_at());
			st.setInt(6, t.getCustomer_id());
			
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
