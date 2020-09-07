import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
/*
* import the Package ---> java.sql.*
* load and Register the Driver---->com.mySql.jdbc.Driver(for this we need to import mySqlConnector jar file)
* Establish the Connection-->
* Create the Statement
* Execute the Query
*Process Result
* Close
* */


public class Insert_2 {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url ="jdbc:mysql://127.0.0.1:3307/college";
        String username ="root";
        String password ="0000";
        int id = 7;
        String uname = "Niloy";
        String gender = "Male";

        String query = "insert into student value ("+id+",'"+uname+"','"+gender+"')";
        Connection con = DriverManager.getConnection(url,username, password);
        Statement st = con.createStatement();
        int count = st.executeUpdate(query); // Insert Data to Database
        System.out.println(count+ " Row/s Inserted.");

        st.close();
        con.close();
    }
}
