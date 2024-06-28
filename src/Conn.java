import java.sql.*;



public class Conn {

    String url = "jdbc:mysql:///studentcourses";
    String username = "root";
    String password = "jupally123";

    Connection conn;
    Statement statement;

    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            statement = conn.createStatement();

        }
        catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
