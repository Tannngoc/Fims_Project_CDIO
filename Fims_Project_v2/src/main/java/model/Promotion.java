package model;

import java.sql.Date;

public class Promotion {
	private int id;
	private String code;
	private float discount_percentage;
	private boolean is_one_time;
	private boolean status;
	private Date end_at;
	private Date created_at;
	private Date altered_at;
	private int admin_id;
	
	public Promotion() {
	}

	public Promotion(int id, String code, float discount_percentage, boolean is_one_time, boolean status, Date end_at, Date created_at,
			Date altered_at, int admin_id) {
		super();
		this.id = id;
		this.code = code;
		this.discount_percentage = discount_percentage;
		this.is_one_time = is_one_time;
		this.status = status;
		this.end_at = end_at;
		this.created_at = created_at;
		this.altered_at = altered_at;
		this.admin_id = admin_id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getDiscount_percentage() {
		return discount_percentage;
	}

	public void setDiscount_percentage(float discount_percentage) {
		this.discount_percentage = discount_percentage;
	}

	public boolean isIs_one_time() {
		return is_one_time;
	}

	public void setIs_one_time(boolean is_one_time) {
		this.is_one_time = is_one_time;
	}

	public Date getEnd_at() {
		return end_at;
	}

	public void setEnd_at(Date end_at) {
		this.end_at = end_at;
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

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	
	
	
}
