package application;

import java.util.Date;

import entities.Order;
import entities.enums.OrderStatus;

public class Program {

	/* main method */
	public static void main(String[] args) {

		int id = generateId();

		Order order = new Order(id, new Date(), OrderStatus.PENDING_PAYMENT);
		order.printData();

		OrderStatus order_status_1 = OrderStatus.DELIVERED;
		OrderStatus order_status_2 = OrderStatus.valueOf("DELIVERED");

		System.out.println(order_status_1);
		System.out.println(order_status_2);
		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions section
	 */
	private static int generateId() {
		return (int) (Math.random() * 1000);
	}
}
