package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {

	public static void main(String[] args) {
		
        String driver = "com.mysql.cj.jdbc.Driver";
        
       String url = "jdbc:mysql://localhost:3306/test?&useSSL=false&serverTimezone=UTC";
        
       String username = "root";
        
        String password = "";
        
        Connection conn = null;
      
        try{
            Class.forName(driver);
            
            conn=DriverManager.getConnection(url,username,password);
            if(!conn.isClosed())
            System.out.println("Access to DataBase Successfully£¡");
             
            Statement Statement=conn.createStatement();
            
            String sql="select * from student" ;
            
            ResultSet rs=Statement.executeQuery(sql);
             System.out.println("-------------------------------");
             System.out.println("Results:");  
             System.out.println("-------------------------------");  
             System.out.println("ID" + "\t" + "First"+"\t"+"Last");  
             System.out.println("-------------------------------");  
             String id=null;
             String fname=null;
             String lname=null;
             while(rs.next()){
                
                 id=rs.getString("StudentID");
                 
                fname=rs.getString("FirstName");
                
                lname=rs.getString("LastName");
                
                System.out.println(id+"\t"+fname+"\t"+lname);
             }
             rs.close();
             conn.close();
         }
         catch(ClassNotFoundException e){
             
        System.out.println("Failed to access database£¡");
        e.printStackTrace();
         }
        catch(SQLException e1){
        
         e1.printStackTrace();
        }
        catch(Exception e2){
        e2.printStackTrace();
        }
        finally{
             System.out.println("-------------------------------");  
            System.out.println("Get Data Successfully£¡");
        }
		

	}

}
