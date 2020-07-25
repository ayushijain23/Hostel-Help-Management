package help.nic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import help.nic.model.hostel;
import help.nic.model.room;

public class roomDao {
	static String provider="jdbc:mysql://localhost:3306/project";
	static String pwd="123";
	static String uid="root";
	public static boolean addnewrecord(room R)
	{try{Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="insert into room values('"+R.getHostelid()+"','"+R.getFloor()+"','"+R.getRoomno()+"','"+R.getCapacity()+"','"+R.getStatus()+"')";                                                                                                   
	boolean s=dbHelper.executeUpdate(query, cn);
	return(s);
	}
	catch(Exception e)
	{System.out.print(e);
	return(false);
	}
	
	}
	public static ResultSet roomDisplayall()
	{
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from room";
		ResultSet rs=dbHelper.executeQuery(query,cn);
		return(rs);
		}catch(Exception e)
		{
			System.out.println(e);
			return(null);
		}

	}
	public static room displaybyid(String roomno)
	{
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from room where roomno='"+roomno+"'";
		ResultSet rs=dbHelper.executeQuery(query,cn);
		if(rs.next())
		{room R=new room();
		R.setHostelid(rs.getString(1));
		R.setFloor(rs.getString(2));
		R.setRoomno(rs.getString(3));
		R.setCapacity(rs.getString(4));
		R.setStatus(rs.getString(5));
		return(R);
		}
		return(null);
		}catch(Exception e)
		{
			System.out.println(e);
			return(null);
		}
}
	public static boolean edit(room R)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="update room set hostelid='"+R.getHostelid()+"',floor='"+R.getFloor()+"',capacity='"+R.getCapacity()+"',status='"+R.getStatus()+"' where roomno='"+R.getRoomno()+"'";
	System.out.println(query);
	boolean st=dbHelper.executeUpdate(query,cn);
	return(st);}
	catch(Exception e){System.out.println(e);
	return(false);}
	}
	public static boolean deletebyid(String roomno)
	{	try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="delete from room where roomno='"+roomno+"'";
	boolean st=dbHelper.executeUpdate(query, cn);
	return(st);
}catch(Exception e)
{System.out.println(e);
return(false);}
}
	public static ResultSet displayroombyhostelname(String hostelname)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="select * from room where hostelid in(select hostelid from hostel where hostelname like '%"+hostelname+"%')";	
	ResultSet rs=dbHelper.executeQuery(query, cn);
	return(rs);}
	catch(Exception e){
		System.out.println(e);
		return null;
	}		
	}
	public static ResultSet displayroombyhostelid(String hostelid)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="select * from room where hostelid='"+hostelid+"'";
			ResultSet rs=dbHelper.executeQuery(query, cn);
			return (rs);
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
}

