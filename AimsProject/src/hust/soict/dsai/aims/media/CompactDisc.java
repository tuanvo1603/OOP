package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks;
	
	public String getArtist() {
		return artist;
	}
	
	public CompactDisc() {
		super();
	}
	
	public CompactDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public void removeTrack(Track track) {
		for(int i=0; i<tracks.size(); i++) {
			if(track.getTitle().equals(tracks.get(i))) {
				tracks.remove(i);
				System.out.println("Successfully removed!");
				break;
			}
		}
		
		System.out.println("Track is not existed!");
	}
	
	public void addTrack(Track track) {
		for(int i=0; i<tracks.size(); i++) {
			if(track.equals(tracks.get(i))) {
				System.out.println("Track is existed!");
				break;
			}
			
			tracks.add(track);
			System.out.println("Successfully added!");
		}
	}
	
	public int getLength() {
		int sum = 0;
		for(int i=0; i<tracks.size(); i++) {
			sum = sum + tracks.get(i).getLength();
		}
		
		return sum;
	}

	@Override
	public void play() {
		for(int i=0; i<tracks.size(); i++) {
			tracks.get(i).play();
		}
		
	}

}
