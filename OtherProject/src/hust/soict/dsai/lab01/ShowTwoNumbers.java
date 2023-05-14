package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public interface ShowTwoNumbers {
	public static void main(String[] args) {
		String strNum15 = null, strNum25 = null;
		
		double num1 = Double.parseDouble(strNum15);
		double num2 = Double.parseDouble(strNum25);
		
		strNum15 = JOptionPane.showInputDialog(null,"Please inpt the first number: ","Input the first number",JOptionPane.INFORMATION_MESSAGE);
		
		strNum25 = JOptionPane.showInputDialog(null,"Please input the second number: ","Input the second number",JOptionPane.INFORMATION_MESSAGE);
		
		JOptionPane.showMessageDialog(null, "The sum of the double number is: " + num1 + num2);
		if(num1 > num2)
		JOptionPane.showMessageDialog(null, "The difference of the double number is: " + num1 + num2);
//		else
//			JOptionPane.showMessageDialog(null, "The difference of the double number is: " + num2 - num1);
		
		
		System.exit(0);
	}
}
