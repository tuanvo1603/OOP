package hust.soict.dsai.aims.media;

import java.util.ArrayList;
public class CompactDisc extends Media implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	private int cdID = 1;
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	public CompactDisc(String title, String category, float cost, String artist, ArrayList<Track> tracks) {
		this.setTitle(title);
        this.setCategory(category); 
        this.setCost(cost);
        this.setId(cdID);
        cdID++;
        this.artist = artist;
        this.tracks = tracks;
	}
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
		}
	}
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
		}
	}
	public int getLength() {
		int length = 0;
		for(Track track : tracks) {
			length += track.getLength();
		}
		return length;
	}
	@Override
	public void play() {
		for(Track track : tracks) {
			track.play();
		}	
	}
	@Override
	public String toString() {
		System.out.println("CD");
		return this.artist + " " + this.getCategory() + " "+this.getTitle();
	}
	

}
 