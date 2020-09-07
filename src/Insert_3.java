import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/*
* import the Package ---> java.sql.*
* load and Register the Driver---->com.mySql.jdbc.Driver(for this we need to import mySqlConnector jar file)
* Establish the Connection-->
* Create the Statement
* Execute the Query
*Process Result
* Close
* */


public class Insert_3 {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String url ="jdbc:mysql://127.0.0.1:3307/college";
        String username ="root";
        String password ="0000";

        int id = 8;
        String uname = "Adrika";
        String gender = "Female";

        // Best method for inserting data
        String query = "insert into student value (?,?,?)";
        Connection con = DriverManager.getConnection(url,username, password);
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1,id);
        st.setString(2,uname);
        st.setString(3,gender);
                int count = st.executeUpdate();
        System.out.println(count+ " Row/s Inserted.");

        st.close();
        con.close();
    }
}
