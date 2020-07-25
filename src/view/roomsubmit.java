package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import help.nic.dao.roomDao;
import help.nic.model.hostel;
import help.nic.model.room;

/**
 * Servlet implementation class roomsubmit
 */
@WebServlet("/roomsubmit")
public class roomsubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public roomsubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		room R=new room();
	R.setHostelid(request.getParameter("hostelid"));
	R.setFloor(request.getParameter("floor"));
	R.setRoomno(request.getParameter("roomno"));
	R.setCapacity(request.getParameter("capacity"));
	R.setStatus(request.getParameter("status"));
	boolean st=roomDao.addnewrecord(R);
	out.println("<html>");
	if(st){ out.println("<h4><font color=blue>record Submitted...<br><a href=roomview>Click Here to add more rooms</a></font></h4>");
	}
	else
	{
		out.println("<h4><font color=red>Failed!</font></h4>");	
	}
	out.println("</html>");
	out.flush();
	}
}
