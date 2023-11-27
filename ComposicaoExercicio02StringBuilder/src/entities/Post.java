package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	/*
	 * attributes section
	 */
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private String title;
	private String content;
	private Integer likes;
	private List<Comment> comments = new ArrayList<>(); // association

	/*
	 * constructors section
	 */
	// constructor - default
	public Post() {
	}

	// constructor - overload
	public Post(Date moment, String title, String content, Integer likes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	/*
	 * getters and setters section
	 */
	public Date getMoment() {
		return this.moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public Integer getLikes() {
		return this.likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void addComment(Comment comment) {
		this.getComments().add(comment);
	}

	public void removeComment(Comment comment) {
		this.getComments().remove(comment);
	}

	/*
	 * methods section
	 */
	@Override
	public String toString() {
		StringBuilder string_builder = new StringBuilder();
		string_builder.append("\nPostagem \n");
		string_builder.append(" - " + this.getTitle().concat("\n"));
		string_builder.append(" - " + this.getLikes() + " likes - ");
		string_builder.append(simpleDateFormat.format(this.getMoment()).concat("\n"));
		string_builder.append(" - " + this.getContent().concat("\n"));
		string_builder.append("Coments: \n");

		for (Comment comment : comments) {
			string_builder.append(" - " + comment.getText().concat("\n"));
		}

		return string_builder.toString();
	}

	public void displayPost() {
		System.out.print(toString());
	}
}
