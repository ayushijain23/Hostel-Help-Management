package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class hostelview
 */
@WebServlet("/hostelview")
public class hostelview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hostelview() {
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
		out.println("<a class='btn btn-info' href=hosteldisplayall>List of all Hostels</a><br>");
		out.print("<form action=hostelsubmit method=post enctype='multipart/form-data'>");
		out.println("<table class='table table-bordered'>");
		out.println("<center><h3><i>Hostel Details</i></h3></center>");
		out.println("<tr><td><b><i>Hostel Id :</i></b></td><td><input class='form-control' type=text name=hostelid size=30></td></tr>");
		out.println("<tr><td><b><i>Hostel Name:</i></b></td><td><input class='form-control' type=text name=hostelname size=30></td></tr>");
		out.println("<tr><td><b><i>Type :</i></b></td><td><input type=radio name=type value=male>Male&nbsp;&nbsp;&nbsp;<input type=radio name=type value=female>Female</td></tr>");
		out.println("<tr><td><b><i>Name Of Warden:</i></b></td><td><input class='form-control' type=text name=warden size=30></td></tr>");
		out.println("<tr><td><b><i>Phone No:</i></b></td><td><input class='form-control' type=text name=phone size=30></td></tr>");
		out.println("<tr><td><b><i>Email Id:</i></b></td><td><input class='form-control' type=email name=email size=30></td></tr>");
		out.println("<tr><td><b><i>Photograph Of Warden:</i></b></td><td><input class='form-control' type=file name=photograph size=20></td></tr><br>");
		out.println("<tr><td><input type=Submit class='btn btn-info'></td><td><input class='btn btn-danger' type=reset></td></tr>");
		out.println("</form></table></html>");
    out.flush();
	}
}
