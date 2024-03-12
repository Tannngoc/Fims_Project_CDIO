package model;

public class InvoiceDetail {
	private int id;
	private int invoice_id;
	private int product_id;
	private int quantity;
	private int toltal_cost;
	
	public InvoiceDetail() {
	}

	public InvoiceDetail(int id, int invoice_id, int product_id, int quantity, int toltal_cost) {
		super();
		this.id = id;
		this.invoice_id = invoice_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.toltal_cost = toltal_cost;
	}

	public int getToltal_cost() {
		return toltal_cost;
	}

	public void setToltal_cost(int toltal_cost) {
		this.toltal_cost = toltal_cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
