package entities;

public class OrderItem {
	/*
	 * attributes section
	 */
	private Integer quantity;
	private Double price;
	private Product product;

	/*
	 * constructors section
	 */
	// constructor - overload
	public OrderItem(Integer quantity, Double price, Product product) {
		this.setQuantity(quantity);
		this.setPrice(price);
		this.setProduct(product);
	}

	/*
	 * getters and setters section
	 */
	public Integer getQuantity() {
		return quantity;
	}

	private void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	private void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	private void setProduct(Product product) {
		this.product = product;
	}

	/*
	 * methods section
	 */
	public Double subTotal() {
		return this.getPrice() * this.getQuantity();
	}

	@Override
	public String toString() {
		StringBuilder string_builder = new StringBuilder();
		
		string_builder.append(this.getProduct().getName().concat(", R$ "));
		string_builder.append(String.format("%.2f", this.getPrice()));
		string_builder.append(", Quantidade: ");
		string_builder.append(this.getQuantity());
		string_builder.append(", Subtotal: R$ ");
		string_builder.append(String.format("%.2f", this.subTotal()));
		
		return string_builder.toString();
	}
}
