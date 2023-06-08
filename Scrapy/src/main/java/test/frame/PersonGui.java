package test.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PersonGui extends JFrame {

    private Person person;

    private JLabel nameLabel;
    private JLabel companyLabel;
    private JLabel companyIdLabel;

    public PersonGui(final Person person) {
        this.person = person;

        // Initialize components
        this.nameLabel = new JLabel(person.getDisplayName());
        this.companyLabel = new JLabel(generateCompanyLink());
        this.companyIdLabel = new JLabel("ID: " + person.getCompany().getId());

        // Set up layout
        this.setLayout(new GridLayout(3, 1));
        this.add(nameLabel);
        this.add(companyLabel);
        this.add(companyIdLabel);

        // Add action listener to companyLabel component
        this.companyLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CompanyGui cg = new CompanyGui(person.getCompany());
            }
        });

        // Set up window properties
        this.setTitle("Person");
        this.setSize(300, 100);
        this.setLocationRelativeTo(null); // center the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private String generateCompanyLink() {
        String link = "<html><u style=\"color: blue; cursor:pointer;\">"
                + person.getCompany().getName() + "</u></html>";
        return link;
    }

    public static void main(String[] args) {
        // Create a sample company object
        Company company = new Company("Acme Corporation", "123456");

        // Create a sample person object
        Person person = new Person("John Smith", company);

        // Create a GUI for the person
        PersonGui gui = new PersonGui(person);
    }

    class CompanyGui extends JFrame {

        private Company company;

        private JLabel nameLabel;
        private JLabel idLabel;

        public CompanyGui(Company company) {
            this.company = company;

            // Initialize components
            this.nameLabel = new JLabel(company.getName());
            this.idLabel = new JLabel("ID: " + company.getId());

            // Set up layout
            this.setLayout(new GridLayout(2, 1));
            this.add(nameLabel);
            this.add(idLabel);

            // Set up window properties
            this.setTitle("Company");
            this.setSize(200, 70);
            this.setLocationRelativeTo(null); // center the window
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(true);
        }
    }
}

class Person {
    private String displayName;
    private Company company;

    public Person(String displayName, Company company) {
        this.displayName = displayName;
        this.company = company;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Company getCompany() {
        return company;
    }
}

class Company {
    private String name;
    private String id;

    public Company(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
