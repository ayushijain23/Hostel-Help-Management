package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mainview
 */
@WebServlet("/mainview")
public class mainview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mainview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html><body background=Pictures/hostel.png size 100% height=100% position=absolute >");
		out.println("<table>");
		out.println("<tr><td><a href=Adminlogin><img src=Pictures/adminpic.png width=200 height=200></a></td></tr>");
		out.println("<tr><td><a href=studentlogin><img src=Pictures/student-login.png width=200 height=200></a></td></tr>");
		out.println("</table></body></html>");
				
	}

}
