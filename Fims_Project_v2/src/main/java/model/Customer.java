package model;

import java.sql.Date;
import java.util.Objects;

public class Customer {
	private int id;
	private String name;
	private boolean gender;
	private Date birthdate;
	private String address;
	private String email;
	private int telephone;
	private Date created_at;
	private Date altered_at;
	private int account_id;
	
	public Customer() {
	}

	public Customer(int id, String name, boolean gender, Date birthdate, String address, String email, int telephone,
			Date created_at, Date altered_at, int account_id) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.address = address;
		this.email = email;
		this.telephone = telephone;
		this.created_at = created_at;
		this.altered_at = altered_at;
		this.account_id = account_id;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
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

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(account_id, address, altered_at, birthdate, created_at, email, id, name, gender, telephone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return account_id == other.account_id && Objects.equals(address, other.address)
				&& Objects.equals(altered_at, other.altered_at) && Objects.equals(birthdate, other.birthdate)
				&& Objects.equals(created_at, other.created_at) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(gender, other.gender) && telephone == other.telephone;
	}
	

	
}
