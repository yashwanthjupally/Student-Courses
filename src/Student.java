import javax.swing.*;
import java.awt.*;

public class Student extends JFrame{

    JLabel label, student_Id, student_password, label2;
    JTextField id, password;
    JButton login, newUser;

    Student(){

        label = new JLabel();
        label.setText("Student Management System");
        label.setBounds(150,5,300,30);
        label.setFont(new Font("Georgia", Font.PLAIN, 20));
        this.add(label);

        student_Id = new JLabel();
        student_Id.setText("Id");
        student_Id.setBounds(100, 70, 100, 50);
        student_Id.setFont(new Font("Georgia", Font.PLAIN, 18));
        this.add(student_Id);

        id = new JTextField();
        id.setBounds(200, 80, 250, 30);
        this.add(id);

        student_password = new JLabel();
        student_password.setText("Password");
        student_password.setBounds(100, 110, 100, 50);
        student_password.setFont(new Font("Georgia", Font.PLAIN, 18));
        this.add(student_password);

        password = new JTextField();
        password.setBounds(200, 120, 250, 30);
        this.add(password);

        login = new JButton();
        login.setText("Log in");
        login.setBounds(150, 170, 250, 40);
        login.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
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
        this.add(newUser);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setBackground(Color.white);
        this.setLocation(500,250);
        this.setResizable(false);
        this.setLayout(null);

        this.setVisible(true);

    }

    public static void main(String[] args) {

        new Student();
    }
}
