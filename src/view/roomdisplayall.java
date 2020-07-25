package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import help.nic.dao.hostelDao;
import help.nic.dao.roomDao;

/**
 * Servlet implementation class roomdisplayall
 */
@WebServlet("/roomdisplayall")
public class roomdisplayall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public roomdisplayall() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<link rel='stylesheet' type='text/css' href='home2/css/bootstrap.min.css'>");
	ResultSet rs=roomDao.roomDisplayall();
	try{
		if(rs.next())
		{
	
	out.println("<center><table class='table table-bordered' width=100%>");
	out.println("<center><h3><b>List Of Available Rooms</b></h3></center>");
	out.println("<tr><th>Room No</th><th>Floor No</th><th>Hostel Id</th><th>Capacity</th><th>Status</th></tr>");
	do
	{
		out.println("<tr><td>"+rs.getString(3)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td><a class='btn btn-danger' href=roomviewbyid?roomno="+rs.getString(3)+">Edit/Delete</a></td></tr>");
	}while(rs.next());
		out.println("</table></center>");
		}
	else
	{out.println("<h3><font color=red>No record </font></h3>");
	}
	out.print("</html>");
		}
	
	catch(Exception e){System.out.println(e);
	}
		}
	}


