package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import help.nic.dao.complaintDao;
import help.nic.dao.hostelDao;

/**
 * Servlet implementation class studentcompview
 */
@WebServlet("/studentcompview")
public class studentcompview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentcompview() {
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
		out.print("<form action=studentcompsubmit method=post >");
		out.println("<center><table class='table table-bordered'>");
		out.println("<center><h3><i>Complaint Details</i></h3></center>");
		out.println("<tr><td><b><i>Enrollment No :</i></b></td><td><input class='form-control' type=text name=enrollmentno size=30></td></tr>");
		out.println("<tr><td><b><i>Complaint Type:</b></i></td><td>");
		try{
	          ResultSet rs=complaintDao.complaintDisplayall();
	          out.println("<select name=compid class='form-control'>");
	          out.println("<option>Complaint Type</option>");
	          while(rs.next())
	          {
	        	  out.print("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>");	
	          }
	        	 
	          out.println("</select>"); 	 
	         }catch(Exception e){}

			
			out.println("</td></tr>");
		
			out.println("<tr><td><b><i>Complaint Full Detail:</i></b></td><td><textarea class='form-control' name=compdes rows=4 cols=20></textarea>&nbsp;<i>maximum 100 characters</i></td></tr>");
		out.println("<tr><td><b><i>Date Of Complaint:</i></b></td><td><input class='form-control' type=date name=dateofcomp ></td></tr>");
	out.println("<input type=hidden name=action value='No Action'>");
	out.println("<input type=hidden name=sol value='Action Description'>");
	out.println("<input type=hidden name=feedback value='feedback'>");
		out.println("<tr><td><input class='btn btn-info' type=Submit></td><td><input class='btn btn-danger' type=reset></td></tr>");
		out.println("</form></table></center></html>");
    out.flush();
	}

}
