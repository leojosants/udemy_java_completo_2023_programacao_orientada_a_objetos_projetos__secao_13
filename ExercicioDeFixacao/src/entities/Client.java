package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	/*
	 * attributes section
	 */
	private static final SimpleDateFormat simple_date_format = new SimpleDateFormat("dd/MM/yyyy");
	private String name;
	private String email;
	private Date birth_date;

	/*
	 * constructors section
	 */
	// constructor - overload
	public Client(String name, String email, Date birth_date) {
		this.setName(name);
		this.setEmail(email);
		this.setBirthDate(birth_date);
	}

	/*
	 * getters and setters section
	 */
	public String getName() {
		return this.name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return this.birth_date;
	}

	private void setBirthDate(Date birth_date) {
		this.birth_date = birth_date;
	}

	/*
	 * methods section
	 */
	@Override
	public String toString() {
		return String.format("%s", this.getName()) + String.format("%s", simple_date_format.format(this.getBirthDate()))
				+ String.format("%s", this.getEmail());
	}

	public void printData() {
		System.out.println(toString());
	}
}
