package help.nic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import help.nic.model.admin;
import help.nic.model.compregister;
import help.nic.model.hostel;
import help.nic.model.room;

public class complaintDao {
	static	String provider="jdbc:mysql://localhost:3306/project";
	static String uid="root";
	static String Pwd="123";
	public static boolean addnewrecord(compregister C)
	{try{Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,Pwd);
	String query="insert into comp values('"+C.getCompid()+"','"+C.getComptype()+"','"+C.getCompdescription()+"')";                                                                                                   
	boolean s=dbHelper.executeUpdate(query, cn);
	return(s);
	}
	catch(Exception e)
	{System.out.print(e);
	return(false);
	}
	
	}
	public static compregister displaybyid(String compid)
	{
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,Pwd);
		String query="select * from comp where compid='"+compid+"'";
		ResultSet rs=dbHelper.executeQuery(query,cn);
		if(rs.next())
		{compregister CC=new compregister();
		CC.setCompid(rs.getString(1));
		CC.setComptype(rs.getString(2));
		CC.setCompdescription(rs.getString(3));
		return(CC);}
		return(null);
		}catch(Exception e)
		{
			System.out.println(e);
			return(null);
		}
	}
	public static ResultSet complaintDisplayall()
	{
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,Pwd);
		String query="select * from comp";
		ResultSet rs=dbHelper.executeQuery(query,cn);
		return(rs);
		}catch(Exception e)
		{
			System.out.println(e);
			return(null);
		}
}
}
