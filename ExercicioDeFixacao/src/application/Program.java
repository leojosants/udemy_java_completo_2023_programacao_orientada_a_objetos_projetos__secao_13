package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);

		Scanner scanner = instantiateScanner();

		SimpleDateFormat simple_date_format = instantiateSimpleDateFormat();

		System.out.println("\nEntre com os dados do cliente");
		String client_name = requestClientName(scanner);
		String client_email = requestClientEmail(scanner);
		String client_bith_date_string = requestClientBithDateString(scanner);
		Date client_bith_date = simple_date_format.parse(client_bith_date_string);
		Client client = new Client(client_name, client_email, client_bith_date);

		System.out.println("\nEntre com os dados do pedido");
		String status = requestStatus(scanner);
		OrderStatus order_status = OrderStatus.valueOf(status);
		Order order = new Order(new Date(), order_status, client);
		int total_items = requestTotalItems(scanner);

		for (int i = 1; i <= total_items; i++) {
			System.out.printf("\n # %dº item %n", i);
			String product_name = requestProductName(scanner);
			double product_price = requestProductPrice(scanner);
			Product product = new Product(product_name, product_price);
			int product_quantity = requestProductQuantity(scanner);
			OrderItem order_item = new OrderItem(product_quantity, product.getPrice(), product);
			order.addItem(order_item);
		}

		System.out.println();
		System.out.println("Sumário do pedido:");
		displayData(order);

		scanner.close();
		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions section
	 */
	private static Scanner instantiateScanner() {
		Scanner scanner = new Scanner(System.in);
		return scanner;
	}

	private static SimpleDateFormat instantiateSimpleDateFormat() {
		SimpleDateFormat simple_date_format = new SimpleDateFormat("dd/MM/yyyy");
		return simple_date_format;
	}

	private static String requestClientName(Scanner scanner) {
		String client_name = "";

		System.out.print(" - Nome do cliente ......................................................................: ");
		client_name = scanner.nextLine().toUpperCase().trim();

		while (client_name.length() == 0) {
			System.out.print(
					" -> Nome do cliente não pode ser vazio ..................................................: ");
			client_name = scanner.nextLine().toUpperCase().trim();
		}

		return client_name;
	}

	private static String requestClientEmail(Scanner scanner) {
		String client_email = "";

		System.out.print(" - E-mail do cliente.....................................................................: ");
		client_email = scanner.nextLine().trim();

		while (client_email.length() == 0) {
			System.out.print(
					" -> E-mail do cliente não pode ser vazio ................................................: ");
			client_email = scanner.nextLine().trim();
		}

		return client_email;
	}

	private static String requestClientBithDateString(Scanner scanner) {
		String client_bith_date_string = "";

		System.out.print(" - Data de nascimento [DD/MM/AAAA] ......................................................: ");
		client_bith_date_string = scanner.nextLine().trim();

		while (client_bith_date_string.length() == 0) {
			System.out.print(
					" -> Data de nascimento [DD/MM/AAAA] não pode ser vazio ..................................: ");
			client_bith_date_string = scanner.nextLine().trim();
		}

		return client_bith_date_string;
	}

	private static String requestStatus(Scanner scanner) {
		String status = "";
		System.out.print(" - Status [PAGAMENTO_PENDENTE / PROCESSANDO / ENVIADO / ENTREGUE] .......................: ");
		status = scanner.nextLine().toUpperCase().trim();

		while ((status.length() == 0) || ((!status.equals("PAGAMENTO_PENDENTE")) && (!status.equals("PROCESSANDO"))
				&& (!status.equals("ENVIADO")) && (!status.equals("ENTREGUE")))) {
			System.out.print(" -> Status, informe somente [PAGAMENTO_PENDENTE / PROCESSANDO / ENVIADO / ENTREGUE] .....: ");
			status = scanner.nextLine().toUpperCase().trim();
		}

		return status;
	}

	private static int requestTotalItems(Scanner scanner) {
		int total_items = 0;

		System.out.print(" - Quantos itens para esse pedido? ......................................................: ");
		total_items = scanner.nextInt();
		scanner.nextLine(); // buffer

		while (total_items <= 0) {
			System.out.print(" -> Quantidade de itens para o pedido não pode ser menor ou igual a zero ................: ");
			total_items = scanner.nextInt();
			scanner.nextLine(); // buffer
		}

		return total_items;
	}
	
	private static String requestProductName(Scanner scanner) {
		String product_name = "";
		
		System.out.print(" - Nome do produto ......................................................................: ");
		product_name = scanner.nextLine().toUpperCase().trim();

		while (product_name.length() == 0) {
			System.out.print(" -> Nome do produto não pode ser vazio ..................................................: ");
			product_name = scanner.nextLine().toUpperCase().trim();
		}

		return product_name;
	}
	
	private static double requestProductPrice(Scanner scanner) {
		double product_price = 0.0;
			
		System.out.print(" - Preço do produto .....................................................................: R$ ");
		product_price = scanner.nextDouble();
		scanner.nextLine(); // buffer

		while (product_price <= 0.0) {
			System.out.print(" -> Preço do produto não pode ser menor ou igual a zero .................................: R$ ");
			product_price = scanner.nextDouble();
			scanner.nextLine(); // buffer
		}

		return product_price;
	}
	
	private static int requestProductQuantity(Scanner scanner) {
		int product_quantity = 0;

		System.out.print(" - Quantidade do produto ................................................................: ");
		product_quantity = scanner.nextInt();
		scanner.nextLine(); // buffer

		while (product_quantity <= 0) {
			System.out.print(" -> Quantidade de produto não pode ser menor ou igual a zero ............................: ");
			product_quantity = scanner.nextInt();
			scanner.nextLine(); // buffer
		}

		return product_quantity;
	}
	
	private static void displayData(Order order) {
		order.printOrder();
	}
}
