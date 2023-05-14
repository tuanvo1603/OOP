package hust.soict.dsai.lab01;
import java.util.Scanner;

public class DaysofaMonth {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your year: ");
		int year = scanner.nextInt();
		
		//Check valid year
		if(year < 1)
		{
			System.out.println("This year is invalid");
			System.exit(0);
		}
		
		System.out.println("Enter your month: ");
		String month = scanner.next();
		
		//Check leaf year
	if(year%4 == 0)
	{
		if(year%100 == 0)
		{
			if(year%400 == 0)
			{
				if( month.equals("1") ||month.equals("Jan.") || month.equals("Jan") ||month.equals("January")
						|| month.equals("3") || month.equals("Mar.") || month.equals("Mar") || month.equals("March")
						|| month.equals("5") || month.equals("May") 
						||month.equals("7") || month.equals("July")
						|| month.equals("8") || month.equals("Aug.") || month.equals("Aug") || month.equals("August")
						|| month.equals("10") || month.equals("Oct.") || month.equals("Oct") || month.equals("October")
						|| month.equals("12") || month.equals("Dec.") || month.equals("Dec") || month.equals("December"))
				{
					System.out.println("There are 31 days in this month");
				}else
					if( month.equals("2") || month.equals("Feb.") || month.equals("Feb") || month.equals("February"))
				{
					System.out.println("There are 29 days in this month");
				} else 
					if( month.equals("4") || month.equals("Apr.") || month.equals("Apr") || month.equals("April")
						|| month.equals("6") || month.equals("June")
						|| month.equals("9") || month.equals("Sep.") || month.equals("Sep") || month.equals("September")
						|| month.equals("11") || month.equals("Nov.") || month.equals("Nov") || month.equals("November"))
				{
					System.out.println("There are 30 days in this month");
				}else 
				{
					System.out.println("This month is invalid");
					System.exit(0);
				}
			}else {
				if( month.equals("1") ||month.equals("Jan.") || month.equals("Jan") ||month.equals("January")
						|| month.equals("3") || month.equals("Mar.") || month.equals("Mar") || month.equals("March")
						|| month.equals("5") || month.equals("May") 
						||month.equals("7") || month.equals("July")
						|| month.equals("8") || month.equals("Aug.") || month.equals("Aug") || month.equals("August")
						|| month.equals("10") || month.equals("Oct.") || month.equals("Oct") || month.equals("October")
						|| month.equals("12") || month.equals("Dec.") || month.equals("Dec") || month.equals("December"))
				{
					System.out.println("There are 31 days in this month");
				}else
					if( month.equals("2") || month.equals("Feb.") || month.equals("Feb") || month.equals("February"))
				{
					System.out.println("There are 28 days in this month");
				} else 
					if( month.equals("4") || month.equals("Apr.") || month.equals("Apr") || month.equals("April")
						|| month.equals("6") || month.equals("June")
						|| month.equals("9") || month.equals("Sep.") || month.equals("Sep") || month.equals("September")
						|| month.equals("11") || month.equals("Nov.") || month.equals("Nov") || month.equals("November"))
				{
					System.out.println("There are 30 days in this month");
				}else 
				{
					System.out.println("This month is invalid");
					System.exit(0);
				}
			}
		}
		
	//Other years	
	}else {
		if( month.equals("1") ||month.equals("Jan.") || month.equals("Jan") ||month.equals("January")
				|| month.equals("3") || month.equals("Mar.") || month.equals("Mar") || month.equals("March")
				|| month.equals("5") || month.equals("May") 
				||month.equals("7") || month.equals("July")
				|| month.equals("8") || month.equals("Aug.") || month.equals("Aug") || month.equals("August")
				|| month.equals("10") || month.equals("Oct.") || month.equals("Oct") || month.equals("October")
				|| month.equals("12") || month.equals("Dec.") || month.equals("Dec") || month.equals("December"))
		{
			System.out.println("There are 31 days in this month");
		}else
			if( month.equals("2") || month.equals("Feb.") || month.equals("Feb") || month.equals("February"))
		{
			System.out.println("There are 28 days in this month");
		} else 
			if( month.equals("4") || month.equals("Apr.") || month.equals("Apr") || month.equals("April")
				|| month.equals("6") || month.equals("June")
				|| month.equals("9") || month.equals("Sep.") || month.equals("Sep") || month.equals("September")
				|| month.equals("11") || month.equals("Nov.") || month.equals("Nov") || month.equals("November"))
		{
			System.out.println("There are 30 days in this month");
		}else 
		{
			System.out.println("This month is invalid");
			System.exit(0);
		}
	}
		
		
	}
}
