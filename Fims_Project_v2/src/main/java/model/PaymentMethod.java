package model;

import java.sql.Date;

public class PaymentMethod {
	private int id;
	private String payment_type;
	private String provider;
	private Date expiration_date;
	private String card_number;
	private int security_code;
	private String bank_account_name;
	private String bank_name;
	private int customer_id;
	
	public PaymentMethod() {
	}

	public PaymentMethod(int id, String payment_type, String provider, Date expiration_date, String card_number,
			int security_code, String bank_account_name, String bank_name, int customer_id) {
		super();
		this.id = id;
		this.payment_type = payment_type;
		this.provider = provider;
		this.expiration_date = expiration_date;
		this.card_number = card_number;
		this.security_code = security_code;
		this.bank_account_name = bank_account_name;
		this.bank_name = bank_name;
		this.customer_id = customer_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getName() {
		return payment_type;
	}

	public void setName(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public int getSecurity_code() {
		return security_code;
	}

	public void setSecurity_code(int security_code) {
		this.security_code = security_code;
	}

	public String getBank_account_name() {
		return bank_account_name;
	}

	public void setBank_account_name(String bank_account_name) {
		this.bank_account_name = bank_account_name;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	
	
}
