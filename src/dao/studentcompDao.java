package help.nic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import help.nic.model.hostel;
import help.nic.model.room;
import help.nic.model.studentcomp;

public class studentcompDao {

	static String provider="jdbc:mysql://localhost:3306/project";
	static String pwd="123";
	static String uid="root";
	
		
		public static boolean addnewrecord(studentcomp SC)
		{try{Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="insert into studentcomp values('"+SC.getEnrollmentno()+"','"+SC.getCompid()+"','"+SC.getCompdes()+"','"+SC.getDateofcomp()+"','"+SC.getAction()+"','"+SC.getSol()+"','"+SC.getFeedback()+"')";                                                                                                   
		boolean s=dbHelper.executeUpdate(query, cn);
		return(s);
		}
		catch(Exception e)
		{System.out.print(e);
		return(false);
		}
		
		}
		public static studentcomp viewbythree(String enrollmentno,String compid,String dateofcomp)
		{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from studentcomp where enrollmentno='"+enrollmentno+"' and compid='"+compid+"' and dateofcomp='"+dateofcomp+"'";
		System.out.println(query);
		ResultSet rs=dbHelper.executeQuery(query,cn);
		if(rs.next())
		{studentcomp S=new studentcomp();
		S.setEnrollmentno(rs.getString(1));
		S.setCompid(rs.getString(2));
		S.setCompdes(rs.getString(3));
	S.setDateofcomp(rs.getString(4));
		S.setAction(rs.getString(5));
		S.setSol(rs.getString(6));
		S.setFeedback(rs.getString(7));
		return(S);
		}
		return(null);
		}catch(Exception e)
		{
			System.out.println(e);
			return(null);
		}
		}
		public static boolean edit(studentcomp S)
		{try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="update studentcomp set compid='"+S.getCompid()+"',compdes='"+S.getCompdes()+"',dateofcomp='"+S.getDateofcomp()+"',action='"+S.getAction()+"',sol='"+S.getSol()+"',feedback='"+S.getFeedback()+"' where enrollmentno='"+S.getEnrollmentno()+"'";
		System.out.println(query);
		boolean st=dbHelper.executeUpdate(query,cn);
		return(st);}
		catch(Exception e){System.out.println(e);
		return(false);}
		}
		public static ResultSet studentcompdisplayall()
		{
			try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="select * from studentcomp";
			ResultSet rs=dbHelper.executeQuery(query,cn);
			return(rs);
			}catch(Exception e)
			{
				System.out.println(e);
				return(null);
			}

		}
		public static ResultSet studentcompdisplayfeedback()
		{
			try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="select * from studentcomp where (feedback!='null' and action!='Rejected')";
			ResultSet rs=dbHelper.executeQuery(query,cn);
			return(rs);
			}catch(Exception e)
			{
				System.out.println(e);
				return(null);
			}

		}
		public static ResultSet displaybyenrollmentno(String enrollmentno)
		{
			try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="select * from studentcomp where enrollmentno='"+enrollmentno+"'";
			ResultSet rs=dbHelper.executeQuery(query,cn);
			return(rs);
			}catch(Exception e)
			{
				System.out.println(e);
				return(null);
			}

	}

		public static boolean displaybythree(studentcomp S,String enrollmentno,String compid,String dateofcomp)
		{
			try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="update studentcomp set action='"+S.getAction()+"',sol='"+S.getSol()+"' where (enrollmentno='"+enrollmentno+"'and compid='"+compid+"' and dateofcomp='"+dateofcomp+"')";
			boolean st=dbHelper.executeUpdate(query, cn);
			return(st);}
			catch(Exception e)
			{System.out.println(e);
			return(false);}
			}
		public static boolean displaybythreeelements(studentcomp S,String enrollmentno,String compid,String dateofcomp)
		{
			try{ Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="update studentcomp set feedback='"+S.getFeedback()+"' where (enrollmentno='"+enrollmentno+"'and compid='"+compid+"' and dateofcomp='"+dateofcomp+"')";
			boolean st=dbHelper.executeUpdate(query, cn);
			return(st);}
			catch(Exception e)
			{System.out.println(e);
			return(false);}
			}
	}

		

