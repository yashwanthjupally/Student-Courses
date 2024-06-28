import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Explore extends JFrame implements ActionListener {


    JButton label, course, course_Completion, profile, logout, explore,
            cs, phy, chem, math, bio, engg, art, eco;

    boolean areButtonsVisible;
    JTextField search;
    JPanel panel, video;
    JLabel backgroundLabel, subjects;
    String name;

    Explore(String name) {

        areButtonsVisible = false;

        this.name = name;
        label = new JButton();
        label.setText(String.valueOf(name.charAt(0)));
        label.setBounds(1400, 10, 50, 50);
        this.styleButton(label);

        course = new JButton();
        course.setText("My Courses");
        course.setBounds(1250, 60, 200, 40);
        course.setVisible(false);
        this.styleButton(course);
        this.addHoverEffect(course);

        course_Completion = new JButton();
        course_Completion.setText("Progress");
        course_Completion.setBounds(1250, 100, 200, 40);
        course_Completion.setVisible(false);
        this.styleButton(course_Completion);
        this.addHoverEffect(course_Completion);

        profile = new JButton();
        profile.setText("Update Profile");
        profile.setBounds(1250, 140, 200, 40);
        profile.setVisible(false);
        this.styleButton(profile);
        this.addHoverEffect(profile);

        logout = new JButton();
        logout.setText("Log Out");
        logout.setBounds(1250, 180, 200, 40);
        logout.setVisible(false);
        this.styleButton(logout);
        this.addHoverEffect(logout);

        explore = new JButton();
        explore.setText("Explore");
        explore.setBounds(250, 10, 120, 50);
        explore.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.styleButton(explore);

        search = new JTextField();
        search.setBounds(500, 10, 500, 50);
        search.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        this.add(search);

        panel = new JPanel();
        panel.setBounds(100, 60, 800, 600);
        panel.setBackground(new Color(255, 255, 255, 80));
        panel.setVisible(false);
        this.add(panel);

        subjects = new JLabel("Subjects");
        subjects.setBounds(120,120,120,40);
        subjects.setFont(new Font("Sans Serif", Font.PLAIN, 30));
        subjects.setVisible(true);
        panel.add(subjects);

        cs = createSubjectButton("Computer Science", 150, 150, "https://cs50.harvard.edu/college/2024/fall/");
        phy = createSubjectButton("Engineering", 550, 150, "https://www.edx.org/learn/engineering");
        chem = createSubjectButton("Physics", 150, 250, "https://youtu.be/wWnfJ0-xXRE?si=NWCce3a4RP4WKClx");
        math = createSubjectButton("Math", 550, 250, "https://www.edx.org/learn/math");
        bio = createSubjectButton("Biology", 150, 350, "https://www.bozemanscience.com/");
        engg = createSubjectButton("Chemistry", 550, 350, "https://www.edx.org/learn/chemistry");
        art = createSubjectButton("Arts", 150, 450, "https://www.edx.org/learn/arts");
        eco = createSubjectButton("Economics", 550, 450, "https://www.youtube.com/@ehowfinance/playlists");


        video = new JPanel();
        video.setBounds(410, 190, 430, 300);
        video.setBackground(new Color(255, 255, 255, 20));
        video.setVisible(true);
        this.add(video);

        video.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e){
                try {
                    URI uri = new URI("https://ocw.mit.edu/courses/6-100l-introduction-to" +
                            "-cs-and-programming-using-python-fall-2022/resources/6100l-lecture-1-version-2_mp4/");
                    Desktop.getDesktop().browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    ex.printStackTrace();
                }
            }

        });


        setLayout(null);
        ImageIcon icon = new ImageIcon("edu.jpg");
        Image img = icon.getImage().getScaledInstance(1500, 800, Image.SCALE_SMOOTH); // Scale the image
        ImageIcon scaledIcon = new ImageIcon(img);
        backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(0, 60, 1500, 800); // Set bounds to fit the JFrame size
        backgroundLabel.setVisible(true);
        this.add(backgroundLabel);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500, 800);
        this.getContentPane().setBackground(new Color(202, 252, 120));
        this.setLocation(30, 30);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);

    }

    private JButton createSubjectButton(String text, int x, int y, String url) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 300, 80);
        stylesubject(button);
        button.setVisible(false); // Initially hide subject buttons

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebpage(url);
            }
        });
        this.add(button);
        return button;
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setForeground(Color.black);
        button.addActionListener(this);
        this.addHoverEffect(button);
        this.add(button);

    }

    private void stylesubject(JButton button) {
        button.setFont(new Font("Sans Serif", Font.BOLD, 25));
        button.setFocusPainted(false);
        button.setBackground(new Color(190, 13, 220));
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        button.setVisible(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(button);
    }

    public static void openWebpage(String urlString) {
        try {
            URI uri = new URI(urlString);
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(uri);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == label) {
            areButtonsVisible = !areButtonsVisible;
            course.setVisible(areButtonsVisible);
            course_Completion.setVisible(areButtonsVisible);
            profile.setVisible(areButtonsVisible);
            logout.setVisible(areButtonsVisible);
        }

        else if (e.getSource() == explore) {
            panel.setVisible(!panel.isVisible());
            areButtonsVisible = !areButtonsVisible;

            cs.setVisible(areButtonsVisible);
            engg.setVisible(areButtonsVisible);
            phy.setVisible(areButtonsVisible);
            math.setVisible(areButtonsVisible);
            bio.setVisible(areButtonsVisible);
            chem.setVisible(areButtonsVisible);
            art.setVisible(areButtonsVisible);
            eco.setVisible(areButtonsVisible);
        }

        else if (e.getSource() == logout) {
          label.setText("?");
        }


    }


    private void addHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(233, 233, 10));
                button.setOpaque(true);
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(0, 0, 0, 0));  // Return to transparent background
                button.setOpaque(false);
            }
        });
    }
}
