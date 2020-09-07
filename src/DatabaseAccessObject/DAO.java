package DatabaseAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {

    public static void main(String[] args) {
        StudentDAO1 dao = new StudentDAO1(2);
        System.out.println(dao.getUname()+" : "+dao.getGender());
    }


}

class StudentDAO1{
    int id;
    String uname;
    String gender;

    public StudentDAO1(int id) {
        this.id = id;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/college","root","0000");
            Statement st = con.createStatement();
            String query = "SELECT username, gender from student where id ="+id;
            ResultSet rs = st.executeQuery(query);
            rs.next();
            uname = rs.getString(1);
            gender = rs.getString(2);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public String getUname() {
        return uname;
    }

    public String getGender() {
        return gender;
    }
}
