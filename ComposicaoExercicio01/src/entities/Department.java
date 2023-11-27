package entities;

public class Department {
	/*
	 * attribute
	 */
	private String name;

	/*
	 * constructor - default
	 */
	public Department() {

	}

	/*
	 * constructor - overload
	 */
	public Department(String name) {
		this.name = name;
	}

	/*
	 * getters and setters
	 */
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
