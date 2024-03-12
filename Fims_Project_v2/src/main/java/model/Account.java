package model;

import java.sql.Date;
import java.util.Objects;

public class Account {
	private int id;
	private String username;
	private String password;
	private String avatar;
	private int role;
	private Date created_at;
	private Date altered_at;
	
	public Account() {
	}
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public Account(int id, String username, String password, String avatar, int role, Date created_at, Date altered_at) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.avatar = avatar;
		this.role = role;
		this.created_at = created_at;
		this.altered_at = altered_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
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

	@Override
	public int hashCode() {
		return Objects.hash(altered_at, avatar, created_at, id, password, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(altered_at, other.altered_at) && Objects.equals(avatar, other.avatar)
				&& Objects.equals(created_at, other.created_at) && id == other.id && password == other.password
				&& role == other.role && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", avatar=" + avatar
				+ ", role=" + role + ", created_at=" + created_at + ", altered_at=" + altered_at + "]";
	}
	
}
