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

/**
 * Servlet implementation class roomview
 */
@WebServlet("/roomview")
public class roomview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public roomview() {
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
		out.println("<a class='btn btn-info' href=roomdisplayall>List of all rooms</a><br>");
		out.print("<form action=roomsubmit method=post>");
		out.println("<table class='table table-bordered'>");
		out.println("<center><h3><i>Room Details</i></h3></center>");
		out.println("<tr><td><b><i>Hostel Name:</b></i></td><td>");
		try{
	          ResultSet rs=hostelDao.hostelDisplayall();
	          out.println("<select name=hostelid class='form-control'>");
	          out.println("<option>Hostels</option>");
	          while(rs.next())
	          {
	        	  out.print("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>");	
	          }
	        	 
	          out.println("</select>"); 	 
	         }catch(Exception e){}

			
			out.println("</td></tr>");
		out.println("<tr><td><b><i>Floor No:</i></b></td><td><input class='form-control' type=text name=floor size=30></td></tr>");
        out.println("<tr><td><b><i>Room No:</i></b></td><td><input class='form-control' type=text name=roomno size=30></td></tr>");
		out.println("<tr><td><b><i>Capacity:</i></b></td><td><input class='form-control' type=text name=capacity size=30></td></tr>");
		out.println("<tr><td><b><i>Status:</i></b></td><td><input class='form-control' type=text name=status size=30></td></tr>");
		out.println("<tr><td><input class='btn btn-info' type=Submit></td><td><input class='btn btn-danger' type=reset></td></tr>");
		out.println("</form></table></html>");
    out.flush();
		
	}

}
