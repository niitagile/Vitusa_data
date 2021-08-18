package jdbc;


import java.sql.*;
import java.util.*;
public class InsertDemo {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement ps=null;
        Scanner s=new Scanner(System.in);
        System.out.print("Enter ID : ");
        int id=s.nextInt();
        System.out.print("Enter Name : ");
        String name=s.next();
        System.out.print("Enter english marks : ");
        int age=s.nextInt();
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.
                    getConnection("jdbc:oracle:thin:@localhost:1521:orcl", 
                    "hr", "hr");
            
            String str="Insert into student(rollno,stud_name, english) values(?,?,?)";
            ps=con.prepareStatement(str);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            int ans =ps.executeUpdate();
            if(ans>0)
            	System.out.println("Record inserted");
            
            //System.out.println("Record Inserted");
            
        } catch (Exception e) {
            System.out.println("Problem");
            e.printStackTrace();
        }
    }
}
