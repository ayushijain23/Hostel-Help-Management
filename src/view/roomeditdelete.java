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
 * Servlet implementation class roomeditdelete
 */
@WebServlet("/roomeditdelete")
public class roomeditdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public roomeditdelete() {
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
			String roomno=request.getParameter("roomno");
		boolean st=roomDao.deletebyid(roomno);	
		}
		else if(btn.equalsIgnoreCase("edit"))
		{room R=new room();
		R.setHostelid(request.getParameter("hostelid"));
		R.setFloor(request.getParameter("floor"));
		R.setRoomno(request.getParameter("roomno"));
		R.setCapacity(request.getParameter("capacity"));
		R.setStatus(request.getParameter("status"));
		roomDao.edit(R);
	}
		response.sendRedirect("roomdisplayall");

}
}
