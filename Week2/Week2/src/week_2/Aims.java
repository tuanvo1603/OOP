package week_2;

public class Aims {

	public static void main(String[] args) {
		Cart order1 = new Cart();

		DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		order1.addDVD(dvd1);

		DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		order1.addDVD(dvd2);

		DVD dvd3 = new DVD("Aladin", "Animation", 18.99f);
		order1.addDVD(dvd3);

		DVD dvd4 = new DVD("Mua");

		System.out.println("Total cost is: ");
		System.out.println(order1.totalCost());

		order1.removeDVD(dvd1);
		order1.removeDVD(dvd4);

		System.out.println("New total cost is: ");
		System.out.println(order1.totalCost());
	}

}
