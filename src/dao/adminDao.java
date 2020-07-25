package help.nic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import help.nic.model.admin;

public class adminDao 
{

	static	String provider="jdbc:mysql://localhost:3306/project";
	static String uid="root";
	static String Pwd="123";
	public static admin checkpassword(String aid,String password)
	{try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,Pwd);
		  String query="select * from admin where adminid='"+aid+"' and password='"+password+"'";
		  System.out.println(query);
		  ResultSet rs=dbHelper.executeQuery(query, cn);
		  if(rs.next())
		  {admin A=new admin();
		   A.setAdminid(rs.getString(1));
		   A.setAdminname(rs.getString(2));
		   A.setPassword(rs.getString(3));
		   return(A);
		     
		  }
		  else{
		  return(null);}
		  
		}catch(Exception e){
			System.out.println(e);
			return null;
		 }
		}
}
