package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import help.nic.dao.hostelDao;
import help.nic.dao.studentcompDao;
import help.nic.model.hostel;
import help.nic.model.studentcomp;

/**
 * Servlet implementation class studentcompsubmit
 */
@WebServlet("/studentcompsubmit")
public class studentcompsubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentcompsubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		studentcomp SC=new studentcomp();
		SC.setEnrollmentno(request.getParameter("enrollmentno"));
		SC.setCompid(request.getParameter("compid"));
		SC.setCompdes(request.getParameter("compdes"));
		SC.setDateofcomp(request.getParameter("dateofcomp"));
		SC.setAction(request.getParameter("action"));
		SC.setSol(request.getParameter("sol"));
		SC.setFeedback(request.getParameter("feedback"));
		boolean st=studentcompDao.addnewrecord(SC);
		out.println("<html>");
		if(st){ out.println("<h4><font color=blue>record Submitted...<br><a href=studentcompview>Back</a></font></h4>");
		}
		else
		{
			out.println("<h4><font color=red>Failed!</font></h4>");	
		}
		out.println("</html>");
		out.flush();
		}
        		
		
	}


