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
import help.nic.dao.studentcompDao;
import help.nic.model.compregister;

/**
 * Servlet implementation class studentcompdisplayall
 */
@WebServlet("/studentcompdisplayall")
public class studentcompdisplayall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentcompdisplayall() {
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
ResultSet rs=studentcompDao.studentcompdisplayall();

try{
	if(rs.next())
	{

out.println("<center><table class='table table-bordered' width=100%>");
out.println("<center><h3><b>List Of All Complaints</b></h3></center>");
out.println("<tr><th>Complaint Id</th><th>Complaint Type</th><th>Date Of Complaint</th><th>Action</th><th>Status</th></tr>");
do
{String cna=rs.getString(2).replace(" ","+");
String chna=rs.getString(4).replace(" ","+");
String compid=rs.getString(2);
compregister C=complaintDao.displaybyid(compid);
	out.println("<tr><td><center>"+rs.getString(2)+"</center></td><td><center>"+C.getComptype()+"</center></td><td><center>"+rs.getString(4)+"</center></td><td><center><a class='btn btn-info btn-xs' href=viewbycompid?enrollmentno="+rs.getString(1)+"&cna="+cna+"&chna="+chna+" >Accept/Reject</a></center></td><td><center>"+rs.getString(5)+"</center></td></tr>");
}while(rs.next());
	out.println("</table></center>");
	}
else
{out.println("<h3><font color=red>No Record</font></h3>");
}

	}

catch(Exception e){System.out.println(e);
}
out.println("</html>");

	}

}
