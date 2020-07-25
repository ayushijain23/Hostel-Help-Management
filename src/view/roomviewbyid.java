package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import help.nic.dao.hostelDao;
import help.nic.dao.roomDao;
import help.nic.model.hostel;
import help.nic.model.room;

/**
 * Servlet implementation class roomviewbyid
 */
@WebServlet("/roomviewbyid")
public class roomviewbyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public roomviewbyid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String roomno=request.getParameter("roomno");
		room R=roomDao.displaybyid(roomno);
		if(R!=null){
			out.println("<html>"); 
			out.println("<link rel='stylesheet' type='text/css' href='home2/css/bootstrap.min.css'>");
			out.println("<form action=roomeditdelete method=post>");
			out.println("<center><table class='table table-bordered'>");
			out.println("<center><h3><b>Room details</b></h3></center>");
			out.println("<tr><td><b><i>Room No:</i></b></td><td><input class='form-control' type=text name=roomno size=30 value='"+R.getRoomno()+"' readonly=true></td></tr>");
			out.println("<tr><td><b><i>Floor No:</i></b></td><td><input class='form-control' type=text name=floor size=30 value='"+R.getFloor() +"'></td></tr>");
			out.println("<tr><td><b><i>Hostel Id:</i></b></td><td><input class='form-control' type=text name=hostelid size=30 value='"+R.getHostelid() +"'></td></tr>");
			out.println("<tr><td><b><i>Capacity:</i></b></td><td><input  class='form-control'type=text name=capacity size=30 value='"+R.getCapacity() +"'></td></tr>");
			out.println("<tr><td><b><i>Status:</i></b></td><td><input class='form-control' type=text name=status size=30 value='"+R.getStatus()+"'></td></tr>");
			 out.println("<tr><td><input name=btn type=submit class='btn btn-success' value=edit></td><td><input name=btn class='btn btn-danger' type=submit value=delete></td></tr>");
			  out.println("</table></center></form></html>");	
	}
	}
}
