package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DVD;

public class TestPassingParameter {
	public static void main(String[] args) {
		DVD jungleDVD = new DVD("jungle");
		DVD cinderellaDVD = new DVD("cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
//	public static void swap(Object o1, Object o2) {
//		Object tmp = o1;
//		o1 = o2;
//		o2 = tmp;
//	}
	
	public static void swap(DVD dvd1, DVD dvd2) {
        DVD temp = new DVD(dvd1.getTitle(), dvd1.getCategory(), dvd1.getDirector(), dvd1.getLength(), dvd1.getCost());

        dvd1.setTitle(dvd2.getTitle());
        dvd1.setCategory(dvd2.getCategory());
        dvd1.setDirector(dvd2.getDirector());
        dvd1.setLength(dvd2.getLength());
        dvd1.setCost(dvd2.getCost());

        dvd2.setTitle(temp.getTitle());
        dvd2.setCategory(temp.getCategory());
        dvd2.setDirector(temp.getDirector());
        dvd2.setLength(temp.getLength());
        dvd2.setCost(temp.getCost());
    }
	
	public static void changeTitle(DVD dvd, String title) {
		String oldTitle = dvd.getTitle();  //oldTitle = jungle
		dvd.setTitle(title);  //set title for jungle to cinderella
		dvd = new DVD(oldTitle);  //set jungleDVD equals to object with name "jungle"
	}
}
