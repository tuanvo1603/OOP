package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

	private List<String> authors = new ArrayList<String>();
	public Book() {
		
	}
	
	public Book(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public void addAuthor(String authorName) {
		for(int i=0; i<authors.size(); i++) {
			if(authorName == authors.get(i)) {
				System.out.println("Author is existed!");
				break;
			}
		}
		
		authors.add(authorName);
		System.out.println("Successfully added!");
	}
	
	public void removeAuthor(String authorName) {
		for(int i=0; i<authors.size(); i++) {
			if(authorName == authors.get(i)) {
				authors.remove(i);
				System.out.println("Successfully removed!");
				break;
			}
			
			System.out.println("Author is not existed!");
		}
	}
	
	

}
