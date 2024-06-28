import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Register extends JFrame implements ActionListener {

    JLabel label, name,gender, phone, email, city, dob, country, password, cPassword, label2;
    JTextField name_ip, phone_ip, email_ip, city_ip, country_ip, password_ip;
    JPasswordField cPassword_ip;
    JDateChooser dateChooser;
    JButton login, register;
    JRadioButton male,female,other;


    Register(){

        label = new JLabel();
        label.setText("Sign up");
        label.setBounds(250, 10, 300, 50);
        label.setFont(new Font("OpenSans", Font.PLAIN, 28));
        this.add(label);

        name = new JLabel();
        name.setText("Name");
        name.setBounds(100, 90, 100, 50);
        name.setFont(new Font("Georgia", Font.PLAIN, 18));
        this.add(name);

        name_ip = new JTextField();
        name_ip.setBounds(200, 100, 250, 30);
        name_ip.setFont(new Font("Cambria",Font.PLAIN,20));
        this.add(name_ip);


        dob = new JLabel();
        dob.setText("DOB");
        dob.setBounds(100,140,100, 50);
        dob.setFont(new Font("Georgia", Font.PLAIN, 18));
        this.add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(200, 150, 250, 30);
        dateChooser.setFont(new Font("Cambria",Font.PLAIN,20));
        this.add(dateChooser);

        phone = new JLabel();
        phone.setText("Phone");
        phone.setBounds(100, 190, 100, 50);
        phone.setFont(new Font("Georgia", Font.PLAIN, 18));
        this.add(phone);

        phone_ip = new JTextField();
        phone_ip.setBounds(200, 200, 250, 30);
        phone_ip.setFont(new Font("Cambria",Font.PLAIN,20));
        this.add(phone_ip);

        email = new JLabel();
        email.setText("Email");
        email.setBounds(100, 240, 100, 50);
        email.setFont(new Font("Georgia", Font.PLAIN, 18));
        this.add(email);

        email_ip = new JTextField();
        email_ip.setBounds(200, 250, 250, 30);
        email_ip.setFont(new Font("Cambria",Font.PLAIN,20));
        this.add(email_ip);

        city = new JLabel();
        city.setText("City");
        city.setBounds(100, 290, 100, 50);
        city.setFont(new Font("Georgia", Font.PLAIN, 18));
        this.add(city);

        city_ip = new JTextField();
        city_ip.setBounds(200, 300, 250, 30);
        city_ip.setFont(new Font("Cambria",Font.PLAIN,20));
        this.add(city_ip);

        country = new JLabel();
        country.setText("State");
        country.setBounds(100, 340, 100, 50);
        country.setFont(new Font("Georgia", Font.PLAIN, 18));
        this.add(country);

        country_ip = new JTextField();
        country_ip.setBounds(200, 350, 250, 30);
        country_ip.setFont(new Font("Cambria",Font.PLAIN,20));
        this.add(country_ip);

        password = new JLabel();
        password.setText("Password");
        password.setBounds(100, 390, 100, 50);
        password.setFont(new Font("Georgia", Font.PLAIN, 18));
        this.add(password);

        password_ip = new JTextField();
        password_ip.setBounds(200, 400, 250, 30);
        password_ip.setFont(new Font("Cambria",Font.PLAIN,20));
        this.add(password_ip);


        cPassword = new JLabel();
        cPassword.setText("Confirm Password");
        cPassword.setBounds(100, 440, 150, 50);
        cPassword.setFont(new Font("Georgia", Font.PLAIN, 18));
        this.add(cPassword);

        cPassword_ip = new JPasswordField();
        cPassword_ip.setBounds(255, 450, 195, 30);
        cPassword_ip.setFont(new Font("Cambria",Font.PLAIN,20));
        this.add(cPassword_ip);



        label2 = new JLabel();
        label2.setText("Already had an account?");
        label2.setBounds(100,540,250,30);
        label2.setFont(new Font("MV Boli", Font.PLAIN, 20));
        this.add(label2);

        login = new JButton();
        login.setText("Log in");
        login.setBounds(350, 540, 100, 32);
        login.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        login.setBackground(Color.white);
        login.setForeground(Color.black);
        login.addActionListener(this);
        this.add(login);

        register = new JButton();
        register.setText("Register");
        register.setBounds(120, 630, 300, 40);
        register.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        register.setBackground(Color.white);
        register.setForeground(Color.black);
        register.addActionListener(this);
        this.add(register);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.getContentPane().setBackground(Color.yellow);
        this.setLocation(500,50);
        this.setResizable(false);
        this.setLayout(null);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String name = name_ip.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String number = phone.getText();
        String mail = email_ip.getText();
        String city = city_ip.getText();
        String country = country_ip.getText();
        String password = password_ip.getText();
        String cpassword = cPassword_ip.getText();

        if(e.getSource() == register){
            try {
                if(name.equals("")){
                    JOptionPane.showMessageDialog(null, "Name cant be Blank");
                } else if (!password.equals(cpassword)) {
                   JOptionPane.showMessageDialog(null, "Password does not match");
                } else {
                    Conn c1 = new Conn();
                    String q1 = "insert into register values('"+name+"', '"+dob+"' , " + " '"+number+"' " +
                            ", '"+mail+"', '"+city+"', '"+country+"','"+password+"', '"+cpassword+"')";

                    c1.statement.executeUpdate(q1);

                    System.out.println("Data added Successfully");
                    setVisible(false);
                    new Explore("").setVisible(true);
                }
            }
            catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        else{
            setVisible(false);
            new Student().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Register();
    }

}
