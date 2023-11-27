package entities;

public class Comment {
	/*
	 * attributes section
	 */
	private String text;

	/*
	 * constructors section
	 */
	// constructor - default
	public Comment() {
	}

	// constructor - overload
	public Comment(String text) {
		this.text = text;
	}

	/*
	 * getters and setters section
	 */
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
