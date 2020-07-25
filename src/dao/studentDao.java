package help.nic.dao;

import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.http.Part;

import org.softech.FileUpload;



import help.nic.model.student;

public class studentDao {
	static String provider="jdbc:mysql://localhost:3306/project";
	static String pwd="123";
	static String uid="root";
	public static boolean addnewrecord(student S)
	{try{Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="insert into student values('"+S.getEnrollmentno()+"','"+S.getName()+"','"+S.getGender()+"','"+S.getFname()+"','"+S.getMname()+"','"+S.getAdmissionyear()+"','"+S.getBranch()+"','"+S.getSemester()+"','"+S.getPhoto()+"','"+S.getPassword()+"','"+S.getEmail()+"','"+S.getAddress()+"','"+S.getMobile()+"','" +S.getFmobileno()+"')";                                                                                                   
	boolean s=dbHelper.executeUpdate(query, cn);
	return(s);
	}
	catch(Exception e)
	{System.out.print(e);
	return(false);
	}
	
	}
	public static ResultSet studentDisplayall()
	{
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from student";
		ResultSet rs=dbHelper.executeQuery(query,cn);
		return(rs);
		}catch(Exception e)
		{
			System.out.println(e);
			return(null);
		}
		}
	public static ResultSet studentbyid(String enrollmentno)
	{
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from student where enrollmentno='"+enrollmentno+"'";
		ResultSet rs=dbHelper.executeQuery(query,cn);
		return(rs);
		}catch(Exception e)
		{
			System.out.println(e);
			return(null);
		}
	}
	public static student displaybyid(String enrollmentno)
	{
		try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from student where enrollmentno='"+enrollmentno+"'";
		ResultSet rs=dbHelper.executeQuery(query,cn);
		if(rs.next())
		{student S=new student();
		S.setEnrollmentno(rs.getString(1));
		S.setName(rs.getString(2));
		S.setGender(rs.getString(3));
		S.setFname(rs.getString(4));
		S.setMname(rs.getString(5));
		S.setAdmissionyear(rs.getString(6));
		S.setBranch(rs.getString(7));
		S.setSemester(rs.getString(8));
		S.setPhoto(rs.getString(9));
		S.setPassword(rs.getString(10));
		S.setEmail(rs.getString(11));
		S.setAddress(rs.getString(12));
		S.setMobile(rs.getString(13));
		S.setFmobileno(rs.getString(14));
		return(S);
		}
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
	String query="delete from student where enrollmentno='"+enrollmentno+"'";
	boolean st=dbHelper.executeUpdate(query, cn);
	return(st);
}catch(Exception e)
{System.out.println(e);
return(false);}
}
	public static boolean edit(student S)
	{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,uid,pwd);
	String query="update student set name='"+S.getName()+"',gender='"+S.getGender()+"',fname='"+S.getFname() +"',mname='"+S.getMname() +"',admissionyear='"+S.getAdmissionyear() +"',branch='"+S.getBranch() +"',semester='"+S.getSemester() +"',password='"+S.getPassword() +"',email='"+S.getEmail() +"',address='"+ S.getAddress()+"',mobile='"+S.getMobile() +"',fmobile='"+S.getFmobileno() +"' where enrollmentno='"+S.getEnrollmentno()+"'";
	System.out.println(query);
	boolean st=dbHelper.executeUpdate(query,cn);
	if(S.getPhoto().length()>0)
	{query="update student set photo='"+S.getPhoto()+"' where enrollmentno='"+S.getEnrollmentno()+"'";
	 st=dbHelper.executeUpdate(query,cn);
	}return(st);}
	catch(Exception e){System.out.println(e);
	return(false);}
	}
	public static student checkpassword(String enrollmentno,String password)
	{try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		  String query="select * from student where enrollmentno='"+enrollmentno+"' and password='"+password+"'";
		  System.out.println(query);
		  ResultSet rs=dbHelper.executeQuery(query, cn);
		  if(rs.next())
		  {student S=new student();
			S.setEnrollmentno(rs.getString(1));
			S.setName(rs.getString(2));
			S.setGender(rs.getString(3));
			S.setFname(rs.getString(4));
			S.setMname(rs.getString(5));
			S.setAdmissionyear(rs.getString(6));
			S.setBranch(rs.getString(7));
			S.setSemester(rs.getString(8));
			S.setPhoto(rs.getString(9));
			S.setPassword(rs.getString(10));
			S.setEmail(rs.getString(11));
			S.setAddress(rs.getString(12));
			S.setMobile(rs.getString(13));
			S.setFmobileno(rs.getString(14));
			return(S);
		  
		     
		  }
		  else{
		  return(null);}
		  
		}catch(Exception e){
			System.out.println(e);
			return null;
		 }
		}
	}		

