package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorTitleCost implements Comparator<Media>{

	@Override
	public int compare(Media o1, Media o2) {
		if(o1.title.compareTo(o2.title) > 0)
			return 1;
		else if(o1.title.compareTo(o2.title) < 0)
			return -1;
		else if(Float.compare(o1.cost, o2.cost) > 0)
			return 1;
		else if(Float.compare(o1.cost, o2.cost) < 0)
			return -1;
		else return 0;
	}

}
