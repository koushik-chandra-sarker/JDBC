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


public class FetchingData_2 {

    public static void main(String[] args) throws Exception {

        String url ="jdbc:mysql://127.0.0.1:3307/college";
        String username ="root";
        String password ="0000";
        String query = "select * from student";

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(url,username, password);

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        System.out.println("Id: "+"Username: "+"Gender");
        while (rs.next())
        {
            int id = rs.getInt(1);
            String  name = rs.getString(2);
            String  Gender= rs.getString(3);
            System.out.println(id+": "+name+": "+Gender);
        }

        st.close();
        con.close();
    }
}
