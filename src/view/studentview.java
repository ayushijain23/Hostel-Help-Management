package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class studentview
 */
@WebServlet("/studentview")
public class studentview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentview() {
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
		out.println("<a class='btn btn-info' href=studentdisplayall>List of all students</a>");
		out.print("<form action=studentsubmit method=post enctype='multipart/form-data'>");
		out.println("<table class='table table-bordered'>");
		out.println("<center><h3><i>Student Registeration Form</i></h3></center>");
		out.println("<tr><td><b><i>Enrollment No:</i></b></td><td><input class='form-control' type=text name=enrollmentno size=30 ></td></tr>");
		out.println("<tr><td><b><i>Student Name:</i></b></td><td><input class='form-control' type=text name=sname size=30 placeholder=Student Name></td></tr>");
		out.println("<tr><td><b><i>Gender:</i></b></td><td><input type=radio name=gender value=male >Male&nbsp;&nbsp;<input type=radio name=gender value=female >Female</td></tr>");
		out.println("<tr><td><b><i>Father's Name:</i></b></td><td><input class='form-control' type=text name=fname size=30></td></tr>");
		out.println("<tr><td><b><i>Mother's Name:</i></b></td><td><input class='form-control' type=text name=mname size=30></td></tr>");
		out.println("<tr><td><b><i>Admission Year:</i></b></td><td><input class='form-control' type=date name=admissionyear></td></tr>");
		out.println("<tr><td><b><i>Branch:</i></b></td><td><input type=text class='form-control' name=branch size=30></td></tr>");
		out.println("<tr><td><b><i>Semester:</i></b></td><td><input type=text class='form-control' name=semester size=30></td></tr>");
		out.println("<tr><td><b><i>Photo:</i></b></td><td><input type=file class='form-control' name=photo size=10></td></tr>");
		out.println("<tr><td><b><i>Password:</i></b></td><td><input type=password class='form-control' name=pwd size=30></td></tr>");
		out.println("<tr><td><b><i>Student Email Id:</i></b></td><td><input class='form-control' type=email name=email size=30></td></tr>");
        out.println("<tr><td><b><i>Permanent Address:</i></b></td><td><input class='form-control' type=textarea name=address rows=3 cols=35></textarea></td></tr>");
		out.println("<tr><td><b><i>Student's Mobile:</i></b></td><td><input class='form-control' type=text name=smobile size=30></td></tr>");
		out.println("<tr><td><b><i>Father's Mobile:</i></b></td><td><input class='form-control' type=text name=fmobile size=30></td></tr>");
		out.println("<tr><td><input type=Submit class='btn btn-info'></td><td><input class='btn btn-danger' type=reset></td></tr>");
		out.println("</form></table></html>");
		out.flush();
	
	}

}
