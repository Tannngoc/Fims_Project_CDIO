package model;

import java.sql.Date;

public class Rating {
	private int id;
	private int customer_id;
	private int product_id;
	private int rate_star;
	private String content;
	private Date created_at;
	private Date altered_at;
	
	public Rating() {
	}

	public Rating(int id, int customer_id, int product_id, int rate_star, String content, Date created_at,
			Date altered_at) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.rate_star = rate_star;
		this.content = content;
		this.created_at = created_at;
		this.altered_at = altered_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getRate_star() {
		return rate_star;
	}

	public void setRate_star(int rate_star) {
		this.rate_star = rate_star;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	
	
}
