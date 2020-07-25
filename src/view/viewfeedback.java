package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import help.nic.dao.studentcompDao;
import help.nic.model.studentcomp;

/**
 * Servlet implementation class viewfeedback
 */
@WebServlet("/viewfeedback")
public class viewfeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewfeedback() {
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
		String enrollmentno=request.getParameter("enrollmentno");
		String compid=request.getParameter("cna");
		String dateofcomp=request.getParameter("chna");
	studentcomp S=studentcompDao.viewbythree(enrollmentno, compid, dateofcomp);
if(S!=null)
{
		 
			
			out.println("<center><table class='table table-bordered'>");
			out.println("<center><h3><b> Details</b></h3></center>");
			out.println("<input type=hidden name=enrollmentno value='"+S.getEnrollmentno()+"' ");
			out.println("<tr><td><b><i>Complaint Id:</i></b></td><td><input class='form-control' type=text name=compid size=20 value='"+S.getCompid()+"' readonly=true></td></tr>");
			out.println("<tr><td><b><i>Complaint description:</i></b></td><td><textarea class='form-control' name=compdes rows=3 cols=40 readonly=true>"+S.getCompdes()+"</textarea></td></tr>");
			out.println("<tr><td><b><i>date Of Complaint:</i></b></td><td><input class='form-control' type=date name=dateofcomp value='"+S.getDateofcomp()+"'  readonly=true></td></tr>");

			out.println("<tr><td><b><i>Action:</i></b></td><td><input class='form-control' type=text value='"+S.getAction()+"' readonly=true</td></tr>");
			out.println("<tr><td><b><i>Action Description:</i></b></td><td><textarea class='form-control' name=sol  rows=3 cols=40  readonly=true>"+S.getSol()+"</textarea></td></tr><br>");
			out.println("<tr><td><b><i>Feedback:</i></b></td><td><textarea class='form-control' name=feedback  rows=3 cols=40 readonly=true>"+S.getFeedback()+"</textarea></td></tr><br>");

}
	}
}
