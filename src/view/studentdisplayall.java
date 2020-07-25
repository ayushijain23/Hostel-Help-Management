package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import help.nic.dao.studentDao;

/**
 * Servlet implementation class studentdisplayall
 */
@WebServlet("/studentdisplayall")
public class studentdisplayall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentdisplayall() {
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
	ResultSet rs=studentDao.studentDisplayall();
	try{
		if(rs.next())
		{
	
	out.println("<center><table class='table table-bordered' width=100%>");
	out.println("<center><h3><b>List Of Registered Students</b></h3></center>");
	out.println("<tr><th>Enrollment No</th><th>Name Of Student</th><th>Branch</th><th>Semester</th><th>Photograph</th></tr>");
	do
	{
		out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td><img class='img-thumbnail' src=Pictures/"+rs.getString(9)+" width=30 height=30></td><td><a class='btn btn-danger' href=studentviewbyid?enrollmentno="+rs.getString(1)+">Edit/Delete</a></td></tr>");
	}while(rs.next());
		out.println("</table></center>");
		}
	else
	{out.println("<h3><font color=red>No Record</font></h3>");
	}
	out.print("</html>");
		}
	
	catch(Exception e){System.out.println(e);
	}
		}

}
