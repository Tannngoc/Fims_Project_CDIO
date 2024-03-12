package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.PaymentDetail;

public class PaymentDetailDAO implements DAOInterface<PaymentDetail>{

	public static PaymentDetailDAO getInstance() {
		return new PaymentDetailDAO();	
	}
	
	@Override
	public ArrayList<PaymentDetail> selectAll() {
			ArrayList<PaymentDetail> ketQua = new ArrayList<PaymentDetail>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM payment_details";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt(1);
				int amount = rs.getInt(2);
				int status = rs.getInt(3);
				Date time_payment = rs.getDate(4);
				int invoice_id = rs.getInt(5);
				int payment_method_id = rs.getInt(6);
				
								

				PaymentDetail ac = new PaymentDetail(id, amount, status,time_payment, invoice_id, payment_method_id);
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
	public PaymentDetail selectById(PaymentDetail t) {
		PaymentDetail ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM payment_details WHERE ID=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				int id = rs.getInt(1);
				int amount = rs.getInt(2);
				int status = rs.getInt(3);
				Date time_payment = rs.getDate(3);
				int invoice_id = rs.getInt(5);
				int payment_method_id = rs.getInt(5);
				
				ketQua = new PaymentDetail(id, amount, status, time_payment, invoice_id, payment_method_id);
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
	public int insert(PaymentDetail t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO PaymentDetail (1, 2, 3, 4, 5, 6) "+
					" VALUES (?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setInt(2, t.getAmount());
			st.setInt(3, t.getStatus());
			st.setDate(4, t.getTime_payment());
			st.setInt(5, t.getInvoice_id());
			st.setInt(6, t.getCustomer_payment_id());
			
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
	public int insertAll(ArrayList<PaymentDetail> arr) {
		int dem = 0;
		for (PaymentDetail paymentDetail : arr) {
			dem+=this.insert(paymentDetail);
		}	
		return dem;
	}

	@Override
	public int delete(PaymentDetail t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from payment_details "+
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
	public int deleteAll(ArrayList<PaymentDetail> arr) {
		int dem = 0;
		for (PaymentDetail paymentDetail : arr) {
			dem+=this.delete(paymentDetail);
		}
		return dem;
	}

	@Override
	public int update(PaymentDetail t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE payment_details "+
					 " SET " +
					 " ID=?"+
					 ", AMOUNT=?"+
					 ", STATUS_=?"+
					 " TIME_PAYMENT=?"+
					 " INVOICE_ID=?"+
					 ", PAYMENT_METHOD_ID=?"+
					 " WHERE ID=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setInt(2, t.getAmount());
			st.setInt(3, t.getStatus());
			st.setDate(4, t.getTime_payment());
			st.setInt(5, t.getInvoice_id());
			st.setInt(7, t.getCustomer_payment_id());
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
