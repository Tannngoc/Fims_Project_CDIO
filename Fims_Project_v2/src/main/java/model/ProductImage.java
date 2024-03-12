package model;

public class ProductImage {
	private int id;
	private int product_id;
	private int model_id;
	private String image;
	
	public ProductImage() {
		
	}

	public ProductImage(int id, int product_id, int model_id, String image) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.model_id = model_id;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getModel_id() {
		return model_id;
	}

	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", product_id=" + product_id + ", model_id=" + model_id + ", image=" + image
				+ "]";
	}
	
	
	
}
