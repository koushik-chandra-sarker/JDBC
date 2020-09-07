import com.mysql.jdbc.JDBC4ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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


public class FetchingData_1 {

    public static void main(String[] args) throws Exception {

        String url ="jdbc:mysql://127.0.0.1:3307/college";
        String uname ="root";
        String password ="0000";
        String query = "select username from student where id =1";

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(url,uname, password);

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query);// for Fetching the data. DQL(Data Query language.
        while (rs.next())
        {
            String name = rs.getString("username");
            System.out.println(name);
        }

        st.close();
        con.close();
    }
}
