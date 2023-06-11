package hust.soict.dsai.aims.media;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class TestMedia extends Media{

	public static void main(String[] args) {
		ArrayList<Media> mediae = new ArrayList<Media>();
		
		CompactDisc cd = new CompactDisc();
		DVD dvd = new DVD("tuan");
		Book book = new Book();
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		
		for(Media m: mediae) {
			System.out.println(m.toString());
		}
		
		List<Media> collection = new ArrayList<>();

		Collections.sort(collection, Media.Compare_By_Title_Cost);


	}

}
