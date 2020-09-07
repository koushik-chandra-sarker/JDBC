package DatabaseAccessObject;

import java.sql.*;
import java.util.Queue;
//perfect method
public class JdbcDAO {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
      /*  Student s1 = dao.getStudent(2);
        System.out.println(s1.id+ " : "+s1.uname+ " : "+ s1.gender);*/
       /* Student s2 = new Student();
        s2.id = 9;
        s2.uname = "pronoy";
        s2.gender = "Male";
        dao.connection();
        dao.AddStudent(s2);*/
       dao.connection();
       dao.RemoveStudent(8);



    }

}

class StudentDAO{
    Connection con = null;
    public void connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/college","root","0000");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student getStudent( int id){

        try {
            String query = "SELECT username, gender from student where id ="+id;
            Student s = new Student();
            s.id = id;

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String name = rs.getString(1);
            String gen = rs.getString(2);
            s.uname = name;
            s.gender = gen;

            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    public void AddStudent(Student s){
        String query = "insert into student value(?,?,?)";

        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);
            pst.setInt(1,s.id);
            pst.setString(2,s.uname);
            pst.setString(3,s.gender);
            int count = pst.executeUpdate();
            System.out.println(count+ " Row/s Inserted.");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void RemoveStudent(int id){

        String query = "Delete from Student where id="+id;
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);
            int count = pst.executeUpdate();
            System.out.println(count+ " Row/s Inserted.");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


class Student {
    int id;
    String uname;
    String gender;
}
