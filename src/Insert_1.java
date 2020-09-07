import java.sql.*;
/*
* import the Package ---> java.sql.*
* load and Register the Driver---->com.mySql.jdbc.Driver(for this we need to import mySqlConnector jar file)
* Establish the Connection-->
* Create the Statement
* Execute the Query
*Process Result
* Close
* */


public class Insert_1 {

    public static void main(String[] args) throws Exception {

        String url ="jdbc:mysql://127.0.0.1:3307/college";
        String username ="root";
        String password ="0000";
        //String query = "insert into student value (3, 'Shejuti', 'Female')";
        //or
        int id = 6;
        String uname = "Fahmida";
        String gender = "Female";
/*
        String query = "insert into student value ("+id+",'"+uname+"','"+gender+"')";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,username, password);
        Statement st = con.createStatement();
        int count = st.executeUpdate(query); // Insert Data to Database
        System.out.println(count+ " Row/s Inserted.");*/


        // Best method for inserting data
        String query = "insert into student value (?,?,?)";
        Class.forName("com.mysql.jdbc.Driver");
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
