package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import help.nic.dao.allotmentDao;
import help.nic.model.allotment;
import help.nic.model.hostel;

/**
 * Servlet implementation class allotmentsubmit
 */
@WebServlet("/allotmentsubmit")
public class allotmentsubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allotmentsubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		allotment A=new allotment();
		A.setEnrollmentno(request.getParameter("enrollmentno"));
		
		A.setAllotmentdate(request.getParameter("date"));
		A.setRoomno(request.getParameter("roomno"));
		boolean st=allotmentDao.addnewrecord(A);
		if(st){ out.println("<h4><font color=blue>record Submitted...<br><a href=allotmentview>Click Here to add more allotments</a></font></h4>");
		}
		else
		{
			out.println("<h4><font color=red>Failed!</font></h4></html>");	
		}
		out.flush();
		}
	}

