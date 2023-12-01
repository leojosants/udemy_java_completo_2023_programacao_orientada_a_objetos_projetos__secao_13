package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	/*
	 * attributes section
	 */
	private static final SimpleDateFormat simple_date_format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> order_list = new ArrayList<>();

	/*
	 * constructs section
	 */
	// constructor - overload
	public Order(Date moment, OrderStatus status, Client client) {
		this.setMoment(moment);
		this.setStatus(status);
		this.setClient(client);
	}

	/*
	 * getters and setters section
	 */
	public Date getMoment() {
		return this.moment;
	}

	private void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return this.status;
	}

	private void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return this.client;
	}

	private void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrder_list() {
		return this.order_list;
	}

	/*
	 * methods section
	 */
	public void addItem(OrderItem item) {
		this.getOrder_list().add(item);
	}

	public void removeItem(OrderItem item) {
		this.getOrder_list().remove(item);
	}

	public Double total() {
		double sum = 0.0;

		for (OrderItem order_item : order_list) {
			sum += order_item.subTotal();
		}

		return sum;
	}

	@Override
	public String toString() {
		StringBuilder string_builder = new StringBuilder();
		string_builder.append(" Momento do pedido ..: ");
		string_builder.append(simple_date_format.format(this.getMoment()).concat("\n"));
		string_builder.append(" Status do pedido ...: ");
		string_builder.append(this.getStatus() + "\n");
		string_builder.append(String.format(" Nome do cliente ....: %s%n", this.getClient().getName()));
		string_builder.append("\n Itens do pedido: \n");

		for (OrderItem order_item : order_list) {
			string_builder.append(String.format("  Nome ..............: %s%n", order_item.getProduct().getName()));
			string_builder.append(String.format("  Preço .............: R$ %.2f%n", order_item.getProduct().getPrice()));
			string_builder.append(String.format("  Quantidade ........: %dUN%n", order_item.getQuantity()));
			string_builder.append(String.format("  Subtotal ..........: R$ %.2f%n", order_item.subTotal()));
			string_builder.append("\n");
		}

		string_builder.append("  Preço total .......: R$ ");
		string_builder.append(String.format("%.2f", this.total()));

		return string_builder.toString();
	}

	public void printOrder() {
		System.out.println(toString());
	}
}
