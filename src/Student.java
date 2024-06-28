import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student extends JFrame implements ActionListener {

    JLabel label, student_email, student_password, label2;
    JTextField email;
    JPasswordField password;
    JButton login, newUser;

    Student(){

        label = new JLabel();
        label.setText("Student Management System");
        label.setBounds(150,5,300,30);
        label.setFont(new Font("Georgia", Font.PLAIN, 20));
        this.add(label);

        student_email = new JLabel();
        student_email.setText("Email");
        student_email.setBounds(100, 70, 100, 50);
        student_email.setFont(new Font("Georgia", Font.PLAIN, 18));
        this.add(student_email);

        email = new JTextField();
        email.setBounds(200, 80, 250, 30);
        email.setFont(new Font("Cambria",Font.PLAIN,20));
        this.add(email);

        student_password = new JLabel();
        student_password.setText("Password");
        student_password.setBounds(100, 110, 100, 50);
        student_password.setFont(new Font("Georgia", Font.PLAIN, 18));
        this.add(student_password);

        password = new JPasswordField();
        password.setBounds(200, 120, 250, 30);
        password.setFont(new Font("Cambria",Font.PLAIN,20));
        this.add(password);


        login = new JButton();
        login.setText("Log in");
        login.setBounds(150, 170, 250, 40);
        login.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        login.addActionListener(this);
        this.add(login);

        label2 = new JLabel();
        label2.setText("new user?");
        label2.setBounds(230,230,250,30);
        label2.setFont(new Font("MV Boli", Font.PLAIN, 20));
        this.add(label2);

        newUser = new JButton();
        newUser.setText("Register");
        newUser.setBounds(150, 260, 250, 40);
        newUser.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        newUser.setBackground(Color.white);
        newUser.setForeground(Color.black);
        newUser.addActionListener(this);
        this.add(newUser);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.getContentPane().setBackground(Color.white);
        this.setLocation(500,250);
        this.setResizable(false);
        this.setLayout(null);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == login) {
                Conn conn = new Conn();
                String mailText = email.getText();
                String passwordText = password.getText();

                // Print input values for debugging
                System.out.println("Input Email: " + mailText);
                System.out.println("Input Password: " + passwordText);

                String query = "SELECT * FROM register WHERE mail = '" + mailText + "' AND cpassword = '" + passwordText + "'";

                // Print SQL query for debugging
                System.out.println("SQL Query: " + query);

                ResultSet set = conn.statement.executeQuery(query);

                if (set.next()) {
                    // Print database values for debugging
                    System.out.println("DB Email: " + set.getString("mail"));
                    System.out.println("DB Password: " + set.getString("cpassword"));

                    String name = set.getString("name");

                    setVisible(false);
                    new Explore(name).setVisible(true);
                }

                else {
                    System.out.println("No matching entry found in the database");
                    JOptionPane.showMessageDialog(null, "Incorrect Id or Password");
                }

            }
            else {
                setVisible(false);
                new Register().setVisible(true);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {

        new Student();
    }


}
