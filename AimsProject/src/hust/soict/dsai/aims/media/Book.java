package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	private static int bookID = 1;
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(String title, String category, String director, float cost, List<String> authors) {
		this.setTitle(title);
        this.setCategory(category); 
        this.setId(bookID);
        this.setCost(cost);
        this.authors = authors;
        bookID++;
	}
	public void addAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			authors.add(authorName);
		}
	}
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
		}
	}
	@Override
	public String toString() {
		return authors.toString();
	}
	@Override
	public void play() {
	}
	

}
