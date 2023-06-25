package hust.soict.dsai.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Track() {
		
	}
	public Track(String title, int length) {
		this.length = length;
		this.title = title;
	}
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	public boolean equals(Object obj) {
		if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Track other = (Track) obj;

        if (!this.title.equals(other.title) && this.length != other.length) {
            return false;
        }
        return true;
    }

}
