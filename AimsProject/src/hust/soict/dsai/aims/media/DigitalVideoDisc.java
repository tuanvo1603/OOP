package hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc  implements Playable {
    private static int nbDigitalVideoDiscs = 0;
	private String director;

    public String getDirector() {
        return director;
    }
	public void setDirector(String director) {
		this.director = director;
	}
	public DigitalVideoDisc(String title) {
        this.setTitle(title); 
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }
//    public DigitalVideoDisc(String category) {
//        this.category = category;
//    }
    public DigitalVideoDisc(String title, String category, float cost) {
        this.setTitle(title);
        this.setCategory(category); 
        this.setCost(cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category,String director, float cost) {
        this.setTitle(title);
        this.setCategory(category); 
        this.director = director;
        this.setCost(cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    	this.setTitle(title);
        this.setCategory(category); 
        this.director = director;
        this.setCost(cost);
        this.setLength(length);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	public String toString() {
		System.out.println("DVD");
		return this.getTitle()+ " " +this.getCategory()+
				" " + this.getCost() + " " + this.getDirector() + " " + this.getLength();
	}


}