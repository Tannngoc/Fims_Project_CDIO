package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.PaymentMethod;
public class PaymentMethodDAO implements DAOInterface<PaymentMethod>{

	public static AdministratorDAO getInstance() {
		return new AdministratorDAO();	
	}
	
	@Override
	public ArrayList<PaymentMethod> selectAll() {
		ArrayList<PaymentMethod> ketQua = new ArrayList<PaymentMethod>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM customers_payment";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				int id = rs.getInt("ID");
				String payment_type = rs.getString("PAYMENT_TYPE");
				String provider = rs.getString("PROVIDER_");
				Date expiration_date = rs.getDate("EXPIRATION_");
				String card_number = rs.getString("CARD_NUMBER");
				int security_code = rs.getInt("SECURITY_CODE");
				String bank_account = rs.getString("BANK_ACCOUNT");
				String bank_name = rs.getString("BANK_NAME");
				int customer_id = rs.getInt("CUSTOMER_ID");
				

				PaymentMethod ad = new PaymentMethod(id, payment_type, provider, expiration_date, card_number,security_code, bank_account, bank_name,customer_id);
				ketQua.add(ad);
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
	public PaymentMethod selectById(PaymentMethod t) {
		PaymentMethod ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM PaymentMethod WHERE ID=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				int id = rs.getInt("ID");
				String payment_type = rs.getString("PAYMENT_TYPE");
				String provider = rs.getString("PROVIDER_");
				Date expiration_date = rs.getDate("EXPIRATION_");
				String card_number = rs.getString("CARD_NUMBER");
				int security_code = rs.getInt("SECURITY_CODE");
				String bank_account = rs.getString("BANK_ACCOUNT");
				String bank_name = rs.getString("BANK_NAME");
				int customer_id = rs.getInt("CUSTOMER_ID");
				
				ketQua = new PaymentMethod(id, payment_type, provider, expiration_date, card_number,security_code, bank_account, bank_name,customer_id);
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
	public int insert(PaymentMethod t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO administrator (ID, PAYMENT_TYPE, PROVIDER_, EXPIRATION_, CARD_NUMBER,SECURITY_CODE, BANK_ACCOUNT, BANK_NAME,CUSTOMER_ID) "+
					" VALUES (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setString(2, t.getPayment_type());
			st.setString(3, t.getProvider());
			st.setDate(4, t.getExpiration_date());
			st.setString(5, t.getCard_number());
			st.setInt(6, t.getSecurity_code());
			st.setString(7, t.getBank_account_name());
			st.setString(8, t.getBank_name());
			st.setInt(9, t.getCustomer_id());
			
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
	public int insertAll(ArrayList<PaymentMethod> arr) {
		int dem = 0;
		for (PaymentMethod PaymentMethod : arr) {
			dem+=this.insert(PaymentMethod);
		}	
		return dem;
	}

	@Override
	public int delete(PaymentMethod t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from customers_payment "+
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
	public int deleteAll(ArrayList<PaymentMethod> arr) {
		int dem = 0;
		for (PaymentMethod PaymentMethod : arr) {
			dem+=this.delete(PaymentMethod);
		}
		return dem;
	}

	@Override
	public int update(PaymentMethod t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE administrator "+
					 " SET " +
					 " ID=?"+
					 ", PAYMENT_TYPE =?"+
					 ", PROVIDER_ =?"+
					 " EXPIRATION_ =?"+ 
					 ", CARD_NUMBER =?"+
					 ", SECURITY_CODE =?"+
					 " BANK_ACCOUNT =?"+
					 ", BANK_NAME =?"+
					 ", CUSTOMER_ID=?"+
					 " WHERE ID=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, t.getId());
			st.setString(2, t.getPayment_type());
			st.setString(3, t.getProvider());
			st.setDate(4, t.getExpiration_date());
			st.setString(5, t.getCard_number());
			st.setInt(6, t.getSecurity_code());
			st.setString(7, t.getBank_account_name());
			st.setString(8, t.getBank_name());
			st.setInt(9, t.getCustomer_id());
			
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
