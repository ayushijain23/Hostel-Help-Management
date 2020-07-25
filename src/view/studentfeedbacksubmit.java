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
 * Servlet implementation class studentfeedbacksubmit
 */
@WebServlet("/studentfeedbacksubmit")
public class studentfeedbacksubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentfeedbacksubmit() {
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
		 if(btn.equalsIgnoreCase("Submit"))
		{studentcomp S=new studentcomp();
		S.setEnrollmentno(request.getParameter("enrollmentno"));
	S.setCompid(request.getParameter("compid"));
	S.setCompdes(request.getParameter("compdes"));
	S.setDateofcomp(request.getParameter("dateofcomp"));
		S.setAction(request.getParameter("action"));
		S.setSol(request.getParameter("sol"));
		S.setFeedback(request.getParameter("feedback"));
		studentcompDao.displaybythreeelements(S,enrollmentno,compid,dateofcomp);
	}
		 out.println("<html>feedback submitted<br>");
		 out.println("<a href=studentdashboard?enrollmentno="+enrollmentno+">Dashboard</a></html>");

}
}