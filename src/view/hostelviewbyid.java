package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import help.nic.dao.hostelDao;
import help.nic.dao.studentDao;
import help.nic.model.hostel;
import help.nic.model.student;

/**
 * Servlet implementation class hostelviewbyid
 */
@WebServlet("/hostelviewbyid")
public class hostelviewbyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hostelviewbyid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String hostelid=request.getParameter("hostelid");
		hostel H=hostelDao.displaybyid(hostelid);
		if(H!=null){
			out.println("<html>"); 
			out.println("<link rel='stylesheet' type='text/css' href='home2/css/bootstrap.min.css'>");
			out.println("<form action=hosteleditdelete method=post enctype='multipart/form-data'>");
			out.println("<center><table class='table table-bordered'>");
			out.println("<center><h3><b>Hostels details</b></h3></center>");
			out.println("<tr><td><b><i>Hostel Id:</i></b></td><td><input type=text class='form-control' name=hostelid size=30 value='"+H.getHostelid()+"' readonly=true></td></tr>");
			out.println("<tr><td><b><i>Hostel Name:</i></b></td><td><input type=text class='form-control' name=hostelname size=30 value='"+H.getHostelname() +"'></td></tr>");
			out.println("<tr><td><b><i>Type:</i></b></td><td><input type=text class='form-control' name=type size=30 value='"+H.getType() +"'></td></tr>");
			out.println("<tr><td><b><i>Warden:</i></b></td><td><input type=text class='form-control' name=warden size=30 value='"+H.getWarden() +"'></td></tr>");
			out.println("<tr><td><b><i>Phone:</i></b></td><td><input type=text class='form-control' name=phone size=30 value='"+H.getPhone() +"'></td></tr>");
			out.println("<tr><td><b><i>Email Id:</i></b></td><td><input type=date class='form-control' name=email value='"+H.getEmail() +"'></td></tr>");
			out.println("<tr><td><b><i>Photograph:</i></b></td><td><input type=file class='form-control' name=photograph>&nbsp;&nbsp;&nbsp<img class='img-thumbnail' src='Pictures/"+H.getPhotograph()+"' width30 height=40></td></tr>");
			 out.println("<tr><td><input name=btn type=submit class='btn btn-info' value=edit></td><td><input class='btn btn-danger' name=btn type=submit value=delete></td></tr>");
			  out.println("</table></center></form></html>");
	}

}}
