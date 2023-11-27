package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Department department = new Department(null);
		
		Worker worker = new Worker(null, null, null, null);
		
		HourContract hour_contract = new HourContract(null, null, null);

		System.out.println("\n---------- Solicitando dados ----------");
		System.out.println("Entre com os dados do departamento");
		String department_name = requesteDepartmentName(scanner);
		department.setName(department_name);

		System.out.println("\nEntre com os dados do funcionário");
		String employee_name = requestEmployeeName(scanner);
		String level = requestLevel(scanner);
		double base_salary = requestBaseSalary(scanner);
		worker.setName(employee_name);
		worker.setLevel(WorkerLevel.valueOf(level));
		worker.setBaseSalary(base_salary);
		worker.setDepartment(department);
		
		System.out.println("\nEntre com os dados do contrato");
		int total_number_of_contracts = requestTotalNumberOfContracts(scanner);
		requestContractData(total_number_of_contracts, scanner, hour_contract, simpleDateFormat, worker);

		System.out.println("Entre com os dados para calcular a renda");
		String month_and_year_of_reference = requestMontAndYearhOfReference(scanner);
		int month = monthSplit(month_and_year_of_reference);
		int year = yearSplit(month_and_year_of_reference);
				
		System.out.println("\n---------- Exibindo dados ----------");
		displayData(worker, month_and_year_of_reference, month, year);
		
		scanner.close();
		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions section
	 */
	private static String requesteDepartmentName(Scanner scanner) {
		String department_name = "";

		do {
			System.out.print(" - Nome ......................................: ");
			department_name = scanner.nextLine().trim();

			while (department_name.length() == 0) {
				System.out.print(" -> campo 'Nome' não pode ser vazio ............................................: ");
				department_name = scanner.nextLine().trim();
			}
		} while (department_name.length() == 0);

		return department_name;
	}

	private static String requestEmployeeName(Scanner scanner) {
		String employeeName = "";

		do {
			System.out.print(" - Nome ......................................: ");
			employeeName = scanner.nextLine().trim();

			while (employeeName.length() == 0) {
				System.out.print(" -> campo 'Nome' não pode ser vazio ............................................: ");
				employeeName = scanner.nextLine().trim();
			}
		} while (employeeName.length() == 0);

		return employeeName;
	}

	private static String requestLevel(Scanner scanner) {
		String level = "";

		do {
			System.out.print(" - Nível [JUNIOR / MEDIO / SENIOR]............: ");
			level = scanner.nextLine().toUpperCase().trim();

			while ((level.length() == 0)
					|| ((!level.equals("JUNIOR")) && (!level.equals("MEDIO")) && (!level.equals("SENIOR")))) {
				while (level.length() == 0) {
					System.out.print(" -> campo 'nível' não pode ser vazio [JUNIOR / MEDIO / SENIOR] .................: ");
					level = scanner.nextLine().toUpperCase().trim();
				}

				while ((!level.equals("JUNIOR")) && (!level.equals("MEDIO")) && (!level.equals("SENIOR"))) {
					System.out.print(" -> campo 'nível' informe somente [JUNIOR / MEDIO / SENIOR] ....................: ");
					level = scanner.nextLine().toUpperCase().trim();

					while (level.length() == 0) {
						System.out.print(" -> campo 'nível' não pode ser vazio [JUNIOR / MEDIO / SENIOR] .................: ");
						level = scanner.nextLine().toUpperCase().trim();
					}
				}
			}
		} while ((level.equals(""))
				|| ((!level.equals("JUNIOR")) && (!level.equals("MEDIO")) && (!level.equals("SENIOR"))));

		return level;

	}

	private static double requestBaseSalary(Scanner scanner) {
		double base_salary = 0.0;

		do {
			System.out.print(" - Salário base ..............................: R$ ");
			base_salary = scanner.nextDouble();
			scanner.nextLine(); // buffer

			while (base_salary <= 0.0) {
				while (base_salary < 0.0) {
					System.out.print(" -> campo 'Salário base' não pode ser menor que 0.0 ............................: R$ ");
					base_salary = scanner.nextDouble();
					scanner.nextLine(); // buffer
				}

				while (base_salary == 0.0) {
					System.out.print(" -> campo 'Salário base' não pode ser igual a 0.0 ..............................: R$ ");
					base_salary = scanner.nextDouble();
					scanner.nextLine(); // buffer
				}
			}
		} while (base_salary <= 0.0);

		return base_salary;
	}

	private static int requestTotalNumberOfContracts(Scanner scanner) {
		int total_number_of_contracts = 0;

		do {
			System.out.print(" - Quantos contratos para este trabalhador? ..: ");
			total_number_of_contracts = scanner.nextInt();
			scanner.nextLine(); // buffer

			while (total_number_of_contracts <= 0) {
				while (total_number_of_contracts < 0) {
					total_number_of_contracts = scanner.nextInt();
					System.out.print(" -> campo 'Quantos contratos para este trabalhador?' não pode ser menor que 0 ..: ");
					scanner.nextLine(); // buffer
				}

				while (total_number_of_contracts == 0) {
					System.out.print(" -> campo 'Quantos contratos para este trabalhador?' não pode ser igual a 0 ....: ");
					total_number_of_contracts = scanner.nextInt();
					scanner.nextLine(); // buffer
				}
			}
		} while (total_number_of_contracts <= 0);

		return total_number_of_contracts;
	}

	private static void requestContractData(int total_number_of_contracts, Scanner scanner, HourContract hour_contract, SimpleDateFormat simpleDateFormat, Worker worker) throws ParseException {
		System.out.println();
		Date temporary_contract_date;
		String temporary_date = "";
		double temporary_value_per_hours = 0.0;
		int temporary_duration = 0;

		for(int i = 1; i <= total_number_of_contracts; i++) {
			System.out.printf(" # %dº contrato %n", i);	
			temporary_date = requestDate(scanner);
			temporary_value_per_hours = requestValuePerHours(scanner);
			temporary_duration = requestDuration(scanner);			
			temporary_contract_date = simpleDateFormat.parse(temporary_date);
			hour_contract.setDate(temporary_contract_date);
			hour_contract.setValuePerHour(temporary_value_per_hours);
			hour_contract.setHours(temporary_duration);
			worker.addContract(hour_contract);
			System.out.println();
		}
	}

	private static String requestDate(Scanner scanner) {
		String date = "";
		
		do {
			System.out.print(" - Data [DD/MM/AAAA] .........................: ");
			date = scanner.nextLine().trim();
			
			while(date.length() == 0) {
				System.out.print(" -> campo 'Data [DD/MM/AAAA]' não pode ser vazio ...............................: ");
				date = scanner.nextLine().trim();
			}
		} while(date.length() == 0);
		
		return date;
	}

	private static double requestValuePerHours(Scanner scanner) {
		double value_per_hours = 0.0;
		
		do {
			System.out.print(" - Valor por hora ............................: R$ ");
			value_per_hours = scanner.nextDouble();
			scanner.nextLine(); // buffer

			while (value_per_hours <= 0.0) {
				while (value_per_hours < 0.0) {
					System.out.print(" -> campo 'Valor por hora' não pode ser menor que 0.0 ..........................: R$ ");
					value_per_hours = scanner.nextDouble();
					scanner.nextLine(); // buffer
				}

				while (value_per_hours == 0.0) {
					System.out.print(" -> campo 'Valor por hora' não pode ser igual a 0.0 ............................: R$ ");
					value_per_hours = scanner.nextDouble();
					scanner.nextLine(); // buffer
				}
			}
		} while (value_per_hours <= 0.0);

		return value_per_hours;
	}

	private static int requestDuration(Scanner scanner) {
		int duration = 0;
		
		do {
			System.out.print(" - Duração [horas] ...........................: ");
			duration = scanner.nextInt();
			scanner.nextLine(); // buffer

			while (duration <= 0) {
				while (duration < 0) {
					System.out.print(" -> campo 'Duração [horas]' não pode ser menor que 0 ...........................: ");
					duration = scanner.nextInt();
					scanner.nextLine(); // buffer
				}

				while (duration == 0) {
					System.out.print(" -> campo 'Duração [horas]' não pode ser igual a 0 .............................: ");
					duration = scanner.nextInt();
					scanner.nextLine(); // buffer
				}
			}
		} while (duration <= 0);
		
		return duration;
	}

	private static String requestMontAndYearhOfReference(Scanner scanner) {
		String month;
		
		do {
			System.out.print(" - Mês e ano de referência [MM/AAAA] .........: ");
			month = scanner.nextLine().trim();
			
			while(month.length() == 0) {
				System.out.print(" -> campo 'Mês e ano de referência [MM/AAAA]' não pode ser vazio ...............: ");
				month = scanner.nextLine().trim();
			}
		} while(month.length() == 0);
		
		return month;
	}

	private static int monthSplit(String month_and_year_of_reference) {
		int month = Integer.parseInt(month_and_year_of_reference.substring(0, 2));
		return month;
	}
	
	private static int yearSplit(String month_and_year_of_reference) {
		int year = Integer.parseInt(month_and_year_of_reference.substring(3));
		return year;
	}

	private static void displayData(Worker worker, String month_and_year_of_reference, int month, int year) {
		System.out.printf(" - Nome .....................................: %s%n", worker.getName());
		System.out.printf(" - Departamento .............................: %s%n", worker.getDepartment().getName());
		System.out.printf(" - Renda para %s .......................: R$ %.2f%n", month_and_year_of_reference, worker.income(month, year));

	}
}
