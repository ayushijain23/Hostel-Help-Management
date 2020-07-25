package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class compview
 */
@WebServlet("/compview")
public class compview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public compview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		
		out.print("<form action=compsubmit method=post >");
		out.println("<table>");
		out.println("<caption><h3><i>Complaint register</i></h3></caption>");
		out.println("<tr><td><b><i>Complaint Id :</i></b></td><td><input type=text name=compid size=30></td></tr>");
		out.println("<tr><td><b><i>Complaint Type:</i></b></td><td><input type=text name=comptype size=30></td></tr>");
	
		out.println("<tr><td><b><i>Complaint Description:</i></b></td><td><textarea name=compdes rows=3 cols=30></textarea></td></tr>");
		out.println("<tr><td><input type=Submit></td><td><input type=reset></td></tr>");
		out.println("</form></table></html>");
    out.flush();
	}

}
