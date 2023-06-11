package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	public int id;
	public String title;
	public String category;
	public float cost;
	public static final Comparator<Media> Compare_By_Title_Cost = new MediaComparatorTitleCost();
	public static final Comparator<Media> Compare_By_Cost_Title = new MediaComparatorCostTitle();

	
	public Media() {
		}
	@Override
	public boolean equals(Object o) {
		Media media = (Media) o;
		if(this.title.equals(media.title)) return true;
		else return false;
	}
	
	}

