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

		System.out.println("-> fim do programa");
	}

	/*
	 * functions section
	 */
	private static int generateId() {
		return (int) (Math.random() * 1000);
	}
}
