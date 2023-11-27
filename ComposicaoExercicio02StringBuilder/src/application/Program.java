package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Comment;
import entities.Post;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Comment comment_1 = new Comment(null);
		Comment comment_2 = new Comment(null);
		Comment comment_3 = new Comment(null);
		Comment comment_4 = new Comment(null);
		
		Post post_1 = new Post(null, null, null, null);
		Post post_2 = new Post(null, null, null, null);

		comment_1.setText("Tenha uma ótima viagem!");
		comment_2.setText("Uau, isso é incrível!");
		comment_3.setText("Boa noite!");
		comment_4.setText("Que a força esteja com você!");
		
		post_1.setMoment(simpleDateFormat.parse("21/06/2018 13:05:44"));
		post_1.setTitle("Viajando para Nova Zelândia");
		post_1.setContent("Vou visitar esse país maravilhoso!");
		post_1.setLikes(12);
		post_1.addComment(comment_1);
		post_1.addComment(comment_2);
		post_1.displayPost(); 
		
		post_2.setMoment(simpleDateFormat.parse("28/07/2018 23:14:19"));
		post_2.setTitle("Boa noite pessoal");
		post_2.setContent("Vejo vocês amanhã.");
		post_2.setLikes(5);
		post_2.addComment(comment_3);
		post_2.addComment(comment_4);
		post_2.displayPost();

		System.out.println("\n-> fim do programa");
	}

}
