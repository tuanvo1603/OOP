package hust.soict.globalict.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

//import hust.soict.globalict.swing.AWTAccumulator.TFInputListener;

public class SwingAcculator extends JFrame{
	private TextField tfInput;
	private TextField tfOutput;
	private int sum = 0;
	
	public SwingAcculator() {
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2, 2));
		
		cp.add(new Label("Enter an Interger: "));
		
		tfInput = new TextField(10);
		cp.add(tfInput);
		tfInput.addActionListener(new TFInputListener());
		
		cp.add(new Label("the Accumulated Sum is: "));
		
		tfOutput = new TextField(10);
		tfInput.setEditable(false);
		cp.add(tfOutput);
		
		setTitle("AWT Accumulator");
		setSize(350, 120);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingAcculator();
	}
	
	private class TFInputListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			int numberIn = Integer.parseInt(tfInput.getText());
			sum += numberIn;
			tfInput.setText("");
			tfOutput.setText(sum + "");
			
		}
	}
}
