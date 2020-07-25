package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class allotmentview
 */
@WebServlet("/allotmentview")
public class allotmentview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allotmentview() {
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
		out.println("<script src='js/jquery-2.2.1.min.js'></script>");
	out.println("<script src='js/allotment.js'></script>");
		out.println("<a class='btn btn-info' href=allotmentdisplayall>List of all Allotments</a><br>");
		out.print("<form action=allotmentsubmit>");
		out.println("<table class='table table-bordered'>");
		out.println("<center><h3><i>Allotment Details</i></h3></center>");
		out.println("<tr><td><b><i>Hostel Id:</b></i></td><td><select class='form-control' name=hostelid id=hostelid></select></td></tr>");

		out.println("<tr><td><b><i>Room No:</b></i></td><td>");
		
 		out.println("<select name=roomno id=roomno class='form-control'>");
	 	out.println("<option>-Select-</option></select>");
	 
	out.println("</td></tr>");
		out.println("<tr><td><b><i>Enrollment No:</i></b></td><td><input class='form-control' type=text name=enrollmentno size=30></td></tr>");
		
		out.println("<tr><td><b><i>Allotment Date:</i></b></td><td><input class='form-control' type=date name=date></td></tr>");
		out.println("<tr><td><input class='btn btn-info' type=Submit></td><td><input class='btn btn-danger' type=reset></td></tr>");
		out.println("</form></table></html>");
		out.flush();
	}

}
