package model;

import java.sql.Date;

public class Product {
	private int id;
	private String nameProduct;
	private String screen;
	private String operating_system;
	private String color;
	private int rear_camera;
	private int front_camera;
	private String chip;
	private int ram;
	private int rom;
	private String sim;
	private	String conect;
	private int battery;
	private String describe;
	private int quantity;
	private int cost;
	private Date created_at;
	private Date altered_at;
	private int category_id;
	private int company_id;
	private int admin_id;
	
	public Product() {
	}

	public Product(int id,String nameProduct, String screen, String operating_system, String color, int rear_camera,
			int front_camera, String chip, int ram, int rom, String sim, String conect, int battery, String describe,
			int quantity, int cost, Date created_at, Date altered_at, int category_id, int company_id, int admin_id) {
		super();
		this.id = id;
		this.nameProduct = nameProduct;
		this.screen = screen;
		this.operating_system = operating_system;
		this.color = color;
		this.rear_camera = rear_camera;
		this.front_camera = front_camera;
		this.chip = chip;
		this.ram = ram;
		this.rom = rom;
		this.sim = sim;
		this.conect = conect;
		this.battery = battery;
		this.describe = describe;
		this.quantity = quantity;
		this.cost = cost;
		this.created_at = created_at;
		this.altered_at = altered_at;
		this.category_id = category_id;
		this.company_id = company_id;
		this.admin_id = admin_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getOperating_system() {
		return operating_system;
	}

	public void setOperating_system(String operating_system) {
		this.operating_system = operating_system;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getRear_camera() {
		return rear_camera;
	}

	public void setRear_camera(int rear_camera) {
		this.rear_camera = rear_camera;
	}

	public int getFront_camera() {
		return front_camera;
	}

	public void setFront_camera(int front_camera) {
		this.front_camera = front_camera;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getRom() {
		return rom;
	}

	public void setRom(int rom) {
		this.rom = rom;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getConect() {
		return conect;
	}

	public void setConect(String conect) {
		this.conect = conect;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
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

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nameProduct=" + nameProduct + ", screen=" + screen + ", operating_system="
				+ operating_system + ", color=" + color + ", rear_camera=" + rear_camera + ", front_camera="
				+ front_camera + ", chip=" + chip + ", ram=" + ram + ", rom=" + rom + ", sim=" + sim + ", conect="
				+ conect + ", battery=" + battery + ", describe=" + describe + ", quantity=" + quantity + ", cost="
				+ cost + ", created_at=" + created_at + ", altered_at=" + altered_at + ", category_id=" + category_id
				+ ", company_id=" + company_id + ", admin_id=" + admin_id + "]";
	}
	
	
}
