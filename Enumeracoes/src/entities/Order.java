package entities;

import java.util.Date;

import entities.enums.OrderStatus;

public class Order {
	/*
	 * attributes
	 */
	private Integer id;
	private Date moment;
	private OrderStatus status;

	/*
	 * constructor
	 */
	public Order() {
	}

	/*
	 *	constructor - overload
	 */
	public Order(Integer id, Date moment, OrderStatus status) {
		this.id = id;
		this.moment = moment;
		this.status = status;
	}

	/*
	 * getters and setters
	 */
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getMoment() {
		return this.moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return this.status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "\nPedido:\n" + 
	String.format("Id .......: %d%n", this.getId()) + 
	String.format("Momento ..: %s%n", this.getMoment())+
	String.format("Status ...: %s%n", this.getStatus());
	}	
	
	public void printData() {
		System.out.println(toString());
	}
}
