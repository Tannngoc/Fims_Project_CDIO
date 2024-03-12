package model;

import java.sql.Date;

public class Invoice {
	private int id;
	private int toltal;
	private float discount_percentage;
	private Date created_at;
	private Date altered_at;
	private int customer_id;
	
	public Invoice() {
	}

	public Invoice(int id, int toltal, float discount_percentage, Date created_at, Date altered_at, int customer_id) {
		super();
		this.id = id;
		this.toltal = toltal;
		this.discount_percentage = discount_percentage;
		this.created_at = created_at;
		this.altered_at = altered_at;
		this.customer_id = customer_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getToltal() {
		return toltal;
	}

	public void setToltal(int toltal) {
		this.toltal = toltal;
	}

	public float getDiscount_percentage() {
		return discount_percentage;
	}

	public void setDiscount_percentage(float discount_percentage) {
		this.discount_percentage = discount_percentage;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getAltered_at() {
		return altered_at;
	}

	public void setAltered_at(Date altered_at) {
		this.altered_at = altered_at;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	
	
}	
