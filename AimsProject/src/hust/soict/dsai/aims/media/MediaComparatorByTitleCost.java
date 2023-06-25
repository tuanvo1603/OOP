package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

	@Override
	public int compare(Media o1, Media o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}

}
