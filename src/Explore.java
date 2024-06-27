import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Explore extends JFrame implements ActionListener{


    JButton label, course, course_Completion, profile, logout, explore;
    String name;
    boolean areButtonsVisible;
    JTextField search;
    JPanel panel;



    Explore(String name){

        name = this.name;
        areButtonsVisible = false;

        label = new JButton();
        label.setText("Y");
        label.setBounds(1400, 10, 50, 50);
        label.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        label.setBackground(new Color(0,0,0, 65));
        label.setForeground(Color.white);
        label.addActionListener(this);
        this.add(label);

        course = new JButton();
        course.setText("My Courses");
        course.setBounds(1300, 60, 150, 40);
        course.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        course.setBackground(new Color(202, 252, 120));
        course.setForeground(Color.black);
        course.addActionListener(this);
        course.setVisible(false);
        this.add(course);

        course_Completion = new JButton();
        course_Completion.setText("Progress");
        course_Completion.setBounds(1300, 100, 150, 40);
        course_Completion.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        course_Completion.setBackground(new Color(202, 252, 120));
        course_Completion.setForeground(Color.black);
        course_Completion.addActionListener(this);
        course_Completion.setVisible(false);
        this.add(course_Completion);

        profile = new JButton();
        profile.setText("Update");
        profile.setBounds(1300, 140, 150, 40);
        profile.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        profile.setBackground(new Color(202, 252, 120));
        profile.setForeground(Color.black);
        profile.addActionListener(this);
        profile.setVisible(false);
        this.add(profile);

        logout = new JButton();
        logout.setText("Logs");
        logout.setBounds(1300, 180, 150, 40);
        logout.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        logout.setBackground(new Color(202, 252, 120));
        logout.setForeground(Color.black);
        logout.addActionListener(this);
        logout.setVisible(false);
        this.add(logout);


        explore = new JButton();
        explore.setText("Explore");
        explore.setBounds(250, 10, 120, 50);
        explore.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        explore.setFocusPainted(false);
        explore.setBackground(new Color(202, 252, 120));
        explore.setForeground(Color.black);
        explore.addActionListener(this);
        this.add(explore);

        search = new JTextField();
        search.setBounds(500, 10, 500, 50);
        search.setFont(new Font("Sans Serif",Font.PLAIN,20));
        this.add(search);

        panel = new JPanel();
        panel.setBounds(100, 60, 800, 600);
        panel.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        panel.setBackground(new Color(255, 255, 255, 80));
        panel.setForeground(Color.black);
        this.add(panel);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500, 800);
        this.getContentPane().setBackground(new Color(202, 252, 120));
        this.setLocation(30,30);
        this.setResizable(false);
        this.setLayout(null);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == label) {
            areButtonsVisible = !areButtonsVisible;
            label.setBackground(areButtonsVisible ? new Color(202, 252, 120) : new Color(0, 0, 0, 65));
            label.setForeground(areButtonsVisible ? Color.black : Color.white);

            course.setVisible(areButtonsVisible);
            course_Completion.setVisible(areButtonsVisible);
            profile.setVisible(areButtonsVisible);
            logout.setVisible(areButtonsVisible);
        }
    }



    public static void main(String[] args) {
        new Explore("");
    }


}
