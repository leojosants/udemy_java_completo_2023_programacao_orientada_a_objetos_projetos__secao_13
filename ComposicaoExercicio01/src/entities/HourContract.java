package entities;

import java.util.Date;

public class HourContract {
	/*
	 * attributes section
	 */
	private Date date;
	private Double value_per_hour;
	private Integer hours;

	/*
	 * constructors section
	 */
	// constructor - default
	public HourContract() {
	}

	// constructor - overload
	public HourContract(Date date, Double value_per_hour, Integer hours) {
		this.date = date;
		this.value_per_hour = value_per_hour;
		this.hours = hours;
	}

	/*
	 * getters and setters section
	 */
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return this.value_per_hour;
	}

	public void setValuePerHour(Double value_per_hour) {
		this.value_per_hour = value_per_hour;
	}

	public Integer getHours() {
		return this.hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	/*
	 * methods section
	 */
	public Double totalValue() {
		return this.getHours() * this.getValuePerHour();
	}
}
