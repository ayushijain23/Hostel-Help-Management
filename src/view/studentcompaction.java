package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import help.nic.dao.dbHelper;
import help.nic.dao.hostelDao;
import help.nic.dao.studentDao;
import help.nic.dao.studentcompDao;
import help.nic.model.hostel;
import help.nic.model.studentcomp;

/**
 * Servlet implementation class studentcompaction
 */
@WebServlet("/studentcompaction")
public class studentcompaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentcompaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
String enrollmentno=request.getParameter("enrollmentno");
String compid=request.getParameter("compid");
String dateofcomp=request.getParameter("dateofcomp");

		String btn=request.getParameter("btn");
		 if(btn.equalsIgnoreCase("edit"))
		{studentcomp S=new studentcomp();
		S.setEnrollmentno(request.getParameter("enrollmentno"));
	S.setCompid(request.getParameter("compid"));
	S.setCompdes(request.getParameter("compdes"));
	S.setDateofcomp(request.getParameter("dateofcomp"));
		S.setAction(request.getParameter("action"));
		S.setSol(request.getParameter("sol"));
		S.setFeedback(request.getParameter("feedback"));
		studentcompDao.displaybythree(S, enrollmentno, compid, dateofcomp);
        
		}response.sendRedirect("studentcompdisplayall");
		
	}

}
