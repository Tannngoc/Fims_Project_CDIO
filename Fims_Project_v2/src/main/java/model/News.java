package model;

import java.sql.Date;

public class News {
	private int id;
	private String title;
	private String content;
	private String avatar;
	private Date create_at;
	private Date altered_at;
	private int admin_id;
	
	public News() {}
	
	public News(int id, String title, String content, String avatar, Date create_at, Date altered_at, int admin_id) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.avatar = avatar;
		this.create_at = create_at;
		this.altered_at = altered_at;
		this.admin_id = admin_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
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
