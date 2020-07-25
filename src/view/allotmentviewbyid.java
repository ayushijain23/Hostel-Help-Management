package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import help.nic.dao.allotmentDao;
import help.nic.dao.hostelDao;
import help.nic.model.allotment;
import help.nic.model.hostel;

/**
 * Servlet implementation class allotmentviewbyid
 */
@WebServlet("/allotmentviewbyid")
public class allotmentviewbyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allotmentviewbyid() {
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
		allotment A=allotmentDao.displaybyid(enrollmentno);
		if(A!=null){
			out.println("<html>"); 
			out.println("<link rel='stylesheet' type='text/css' href='home2/css/bootstrap.min.css'>");
			out.println("<form action=allotmenteditdelete method=post>");
			out.println("<center><table class='table table-bordered'>");
			out.println("<center><h3><b>Allotment details</b></h3></center>");
			out.println("<tr><td><b><i>Enrollment No:</i></b></td><td><input class='form-control' type=text name=enrollmentno size=30 value='"+A.getEnrollmentno()+"' readonly=true></td></tr>");
			out.println("<tr><td><b><i>Allotment Date:</i></b></td><td><input class='form-control' type=text name=allotmentdate size=30 value='"+A.getAllotmentdate()+"'></td></tr>");
			out.println("<tr><td><b><i>Room No:</i></b></td><td><input type=text class='form-control' name=roomno size=30 value='"+A.getRoomno()+"'></td></tr>");
		    out.println("<tr><td><input name=btn type=submit class='btn btn-info' value=edit></td><td><input class='btn btn-danger' name=btn type=submit value=delete></td></tr>");
			  out.println("</table></center></form></html>");
	}
	}

}
