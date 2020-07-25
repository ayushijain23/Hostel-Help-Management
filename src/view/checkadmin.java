package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import help.nic.dao.adminDao;
import help.nic.model.admin;

/**
 * Servlet implementation class checkadmin
 */
@WebServlet("/checkadmin")
public class checkadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkadmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
				
				admin A=adminDao.checkpassword(request.getParameter("aid"),request.getParameter("pasword"));
				if(A==null)
				{ 
		        out.println("<html><font color=red size=10>Invalid Adminid/Password</font></html>");
			    out.flush();
				}
				else
				{HttpSession ses=request.getSession();
				ses.putValue("ADMINID",A.getAdminid());
				ses.putValue("ADMINNAME", A.getAdminname());
				ses.putValue("TIME",new java.util.Date());
					
				response.sendRedirect("Adminhome");
				}
			
			
			}
	}


