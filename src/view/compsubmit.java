package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import help.nic.dao.complaintDao;
import help.nic.dao.hostelDao;
import help.nic.model.compregister;
import help.nic.model.hostel;

/**
 * Servlet implementation class compsubmit
 */
@WebServlet("/compsubmit")
public class compsubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public compsubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		compregister C=new compregister(); 
		C.setCompid(request.getParameter("compid"));
		C.setComptype(request.getParameter("comptype"));
		C.setCompdescription(request.getParameter("compdes"));
		boolean st=complaintDao.addnewrecord(C);
		out.println("<html>");
		if(st){ out.println("<h4><font color=blue>record Submitted...<br><a href=compview>Click Here to add more</a></font></h4>");
		}
		else
		{
			out.println("<h4><font color=red>Failed!</font></h4>");	
		}
		out.println("</html>");
		out.flush();
		}
		
		
	}


