package help.nic.dao;

import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.ResultSet;

import help.nic.model.hostel;
import help.nic.model.student;


public class hostelDao {
	static String provider="jdbc:mysql://localhost:3306/project";
	static String pwd="123";
	static String uid="root";
	public static boolean addnewrecord(hostel H)
	{try{Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="insert into hostel values('"+H.getHostelid()+"','"+H.getHostelname()+"','"+H.getType()+"','"+H.getWarden()+"','"+H.getPhone()+"','"+H.getEmail()+"','"+H.getPhotograph()+"')";                                                                                                   
	boolean s=dbHelper.executeUpdate(query, cn);
	return(s);
	}
	catch(Exception e)
	{System.out.print(e);
	return(false);
	}
	
	}
	public static ResultSet hostelDisplayall()
	{
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from hostel";
		ResultSet rs=dbHelper.executeQuery(query,cn);
		
		return(rs);
		}catch(Exception e)
		{
			System.out.println(e);
			return(null);
		}

	}
	public static hostel displaybyid(String hostelid)
	{
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from hostel where hostelid='"+hostelid+"'";
		ResultSet rs=dbHelper.executeQuery(query,cn);
		if(rs.next())
		{hostel H=new hostel();
		H.setHostelid(rs.getString(1));
		H.setHostelname(rs.getString(2));
		H.setType(rs.getString(3));
		H.setWarden(rs.getString(4));
		H.setPhone(rs.getString(5));
		H.setEmail(rs.getString(6));
		H.setPhotograph(rs.getString(7));
		return(H);}
		return(null);
		}catch(Exception e)
		{
			System.out.println(e);
			return(null);
		}
}
	public static boolean edit(hostel H)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="update hostel set hostelname='"+H.getHostelname()+"',type='"+H.getType()+"',warden='"+H.getWarden()+"',phone='"+H.getPhone()+"',email='"+H.getEmail() +"',photograph='"+H.getPhotograph()+"' where hostelid='"+H.getHostelid()+"'";
	System.out.println(query);
	boolean st=dbHelper.executeUpdate(query,cn);
	if(H.getPhotograph().length()>0)
	{query="update hostel set photograph='"+H.getPhotograph()+"' where hostelid='"+H.getHostelid()+"'";
	 st=dbHelper.executeUpdate(query,cn);
	}return(st);}
	catch(Exception e){System.out.println(e);
	return(false);}
	}
	public static boolean deletebyid(String hostelid)
	{	try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="delete from hostel where hostelid='"+hostelid+"'";
	boolean st=dbHelper.executeUpdate(query, cn);
	return(st);
}catch(Exception e)
{System.out.println(e);
return(false);}
}
	
}
