package model;

import java.sql.Date;

public class PaymentDetail {
	private int id;
	private int amount;
	private int status;
	private Date time_payment;
	private int invoice_id;
	private int customer_payment_id;
	
	public PaymentDetail() {
	}

	public PaymentDetail(int id, int amount, int status, Date time_payment, int invoice_id, int customer_payment_id) {
		super();
		this.id = id;
		this.amount = amount;
		this.status = status;
		this.time_payment = time_payment;
		this.invoice_id = invoice_id;
		this.customer_payment_id = customer_payment_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getTime_payment() {
		return time_payment;
	}

	public void setTime_payment(Date time_payment) {
		this.time_payment = time_payment;
	}

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public int getCustomer_payment_id() {
		return customer_payment_id;
	}

	public void setCustomer_payment_id(int customer_payment_id) {
		this.customer_payment_id = customer_payment_id;
	}
	
	
	
}
