package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	/*
	 * attributes section
	 */
	private String name;
	private WorkerLevel level;
	private Double base_salary;
	private Department department; // association
	private List<HourContract> contracts = new ArrayList<>(); // association

	/*
	 * constructors section
	 */
	// constructor - default
	public Worker() {
	}

	// constructor - overload
	public Worker(String name, WorkerLevel level, Double base_salary, Department department) {
		this.name = name;
		this.level = level;
		this.base_salary = base_salary;
		this.department = department;
	}

	/*
	 * getters and setters section
	 */
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return this.level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return this.base_salary;
	}

	public void setBaseSalary(Double base_salary) {
		this.base_salary = base_salary;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return this.contracts;
	}

	/*
	 * methods section
	 */
	public void addContract(HourContract contract) {
		this.contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		this.contracts.remove(contract);
	}

	public double income(int month, int year) {
		double sum = this.getBaseSalary();
		int year_contract;
		int month_contract;
		Calendar calendar = Calendar.getInstance();

		for (HourContract contract : contracts) {
			calendar.setTime(contract.getDate());
			year_contract = calendar.get(Calendar.YEAR);
			month_contract = 1 + calendar.get(Calendar.MONTH);

			if ((year == year_contract) && (month == month_contract)) {
				sum += contract.totalValue();
			}
		}
		
		return sum;
	}

}
