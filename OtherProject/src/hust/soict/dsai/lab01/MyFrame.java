package hust.soict.dsai.lab01;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame {
    public MyFrame() {
        // Set the size and location of the frame
        setSize(400, 400);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Set the title
        setTitle("My Frame");

        // Create a label
        JFrame f= new JFrame("Label Example");

        // Add the label to the frame
        add(f);

        // Set the frame to be visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}