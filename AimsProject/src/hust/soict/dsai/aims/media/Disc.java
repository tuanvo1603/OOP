package hust.soict.dsai.aims.media;

public class Disc extends Media {
	private float length;
	private String director;
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Disc() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return this.getCategory() + " " + this.getTitle();
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}

}
