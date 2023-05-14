package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public class TwoNumbers {
	public static void main(String[] args) {
		String strNum1, strNum2;
		
		strNum1 = JOptionPane.showInputDialog(null,"Please inpt the first number: ","Input the first number",JOptionPane.INFORMATION_MESSAGE);
		
		strNum2 = JOptionPane.showInputDialog(null,"Please input the second number: ","Input the second number",JOptionPane.INFORMATION_MESSAGE);
		
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		double sum = num1 +num2;
		double difference = num1- num2;
		double product = num1*num2;
		double quotient = num1/num2;
	
		JOptionPane.showMessageDialog(null, "The sum of the double number is: " + sum);
		
		JOptionPane.showMessageDialog(null, "The difference of the double number is: " + difference);
		
		JOptionPane.showMessageDialog(null, "The product of the double number is: " + product);
		
		JOptionPane.showMessageDialog(null, "The quotient of the double number is: " + quotient);

	}
}