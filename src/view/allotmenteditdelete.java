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
 * Servlet implementation class allotmenteditdelete
 */
@WebServlet("/allotmenteditdelete")
public class allotmenteditdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allotmenteditdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();

		String btn=request.getParameter("btn");
		if(btn.equalsIgnoreCase("delete")){
			String enrollmentno=request.getParameter("enrollmentno");
		boolean st=	allotmentDao.deletebyid(enrollmentno);
		}
		else if(btn.equalsIgnoreCase("edit"))
		{allotment A=new allotment();
		A.setEnrollmentno(request.getParameter("enrollmentno"));
		A.setAllotmentdate(request.getParameter("allotmentdate"));
		A.setRoomno(request.getParameter("roomno"));
		allotmentDao.edit(A);
		
	}response.sendRedirect("allotmentdisplayall");

}
}
