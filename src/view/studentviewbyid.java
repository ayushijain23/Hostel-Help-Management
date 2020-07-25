package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import help.nic.dao.studentDao;
import help.nic.model.student;

/**
 * Servlet implementation class studentviewbyid
 */
@WebServlet("/studentviewbyid")
public class studentviewbyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentviewbyid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String enrollmentno=request.getParameter("enrollmentno");
		student S=studentDao.displaybyid(enrollmentno);
		if(S!=null){
			out.println("<html>"); 
			out.println("<link rel='stylesheet' type='text/css' href='home2/css/bootstrap.min.css'>");
			out.println("<form action=studenteditdelete method=post enctype='multipart/form-data'>");
			out.println("<center><table class='table table-bordered'>");
			out.println("<caption><h3><b>Student details</b></h3></caption>");
			out.println("<tr><td><b><i>Enrollment No:</i></b></td><td><input class='form-control' type=text name=enrollmentno size=30 value='"+S.getEnrollmentno()+"' readonly=true></td></tr>");
			out.println("<tr><td><b><i>Student Name:</i></b></td><td><input class='form-control' type=text name=sname size=30 value='"+S.getName() +"'></td></tr>");
			out.println("<tr><td><b><i>Gender:</i></b></td><td><input type=radio name=gender value='"+S.getGender()+"' >Male&nbsp;&nbsp;<input type=radio name=gender value='"+S.getGender()+"' >Female</td></tr>");
			out.println("<tr><td><b><i>Father's Name:</i></b></td><td><input class='form-control' type=text name=fname size=30 value='"+S.getFname() +"'></td></tr>");
			out.println("<tr><td><b><i>Mother's Name:</i></b></td><td><input class='form-control' type=text name=mname size=30 value='"+S.getMname() +"'></td></tr>");
			out.println("<tr><td><b><i>Admission Year:</i></b></td><td><input class='form-control' type=date name=admissionyear value='"+S.getAdmissionyear() +"'></td></tr>");
			out.println("<tr><td><b><i>Branch:</i></b></td><td><input type=text class='form-control' name=branch size=30 value='"+S.getBranch() +"'></td></tr>");
			out.println("<tr><td><b><i>Semester:</i></b></td><td><input type=text class='form-control' name=semester size=30 value='"+S.getSemester() +"'></td></tr>");
			out.println("<tr><td><b><i>Photo:</i></b></td><td><input type=file class='form-control' name=photo>&nbsp;&nbsp;&nbsp<img class='img-thumbnail' src='Pictures/"+S.getPhoto()+"' width30 height=40></td></tr>");
			out.println("<tr><td><b><i>Password:</i></b></td><td><input class='form-control' type=password name=pwd size=30 value='"+S.getPassword()+"'></td></tr>");
			out.println("<tr><td><b><i>Student Email Id:</i></b></td><td><input class='form-control' type=text name=email size=30 value='"+S.getEmail() +"'></td></tr>");
	        out.println("<tr><td><b><i>Permanent Address:</i></b></td><td><input class='form-control' type=textarea name=address rows=3 cols=35>"+S.getAddress()+"</textarea></td></tr>");
			out.println("<tr><td><b><i>Student's Mobile:</i></b></td><td><input class='form-control' type=text name=smobile size=30 value='"+S.getMobile() +"'></td></tr>");
			out.println("<tr><td><b><i>Father's Mobile:</i></b></td><td><input class='form-control' type=text name=fmobile size=30 value='"+S.getFmobileno()+"'></td></tr>");
		       out.println("<tr><td><input name=btn type=submit class='btn btn-info' value=edit></td><td><input class='btn btn-danger' name=btn type=submit value=delete></td></tr>");
			  out.println("</table></center></form></html>");
		}
	}

}
