package help.nic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import help.nic.model.allotment;
import help.nic.model.hostel;

public class allotmentDao {
	static String provider="jdbc:mysql://localhost:3306/project";
	static String pwd="123";
	static String uid="root";
	public static boolean addnewrecord(allotment A)
	{try{Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="insert into allotment values('"+A.getEnrollmentno()+"','"+A.getAllotmentdate()+"','"+A.getRoomno()+"')";                                                                                                   
	boolean s=dbHelper.executeUpdate(query, cn);
	return(s);
	}
	catch(Exception e)
	{System.out.print(e);
	return(false);
	}
	
	}
	public static allotment displaybyid(String enrollmentno)
	{
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from allotment where enrollmentno='"+enrollmentno+"'";
		ResultSet rs=dbHelper.executeQuery(query,cn);
		if(rs.next())
		{allotment A=new allotment();
		A.setEnrollmentno(rs.getString(1));
		A.setAllotmentdate(rs.getString(2));
		A.setRoomno(rs.getString(3));
		return(A);}
		return(null);
		}catch(Exception e)
		{
			System.out.println(e);
			return(null);
		}
}
	public static boolean deletebyid(String enrollmentno)
	{	try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="delete from allotment where enrollmentno='"+enrollmentno+"'";
	boolean st=dbHelper.executeUpdate(query, cn);
	return(st);
}catch(Exception e)
{System.out.println(e);
return(false);}
}
	public static boolean edit(allotment A)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="update allotment set allotmentdate='"+A.getAllotmentdate()+"',roomno='"+A.getRoomno()+"' where enrollmentno='"+A.getEnrollmentno()+"'";
	System.out.println(query);
	boolean st=dbHelper.executeUpdate(query,cn);
	return(st);}
	catch(Exception e){System.out.println(e);
	return(false);}
	}
	public static ResultSet allotmentDisplayall()
	{
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from allotment";
		ResultSet rs=dbHelper.executeQuery(query,cn);
		return(rs);
		}catch(Exception e)
		{
			System.out.println(e);
			return(null);
		}

	}
}
