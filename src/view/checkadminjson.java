package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;



import help.nic.dao.adminDao;
import help.nic.model.admin;

/**
 * Servlet implementation class checkadminjson
 */
@WebServlet("/checkadminjson")
public class checkadminjson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkadminjson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		admin A=(admin)adminDao.checkpassword(request.getParameter("aid"),request.getParameter("pasword"));
		PrintWriter out=response.getWriter();
		
		if(A==null)
		{  JSONObject J=new  JSONObject();
		   try {
			J.put("message","Invalid Userid/Password");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    out.println(J);
       
	    out.flush();
		}
		else
		{
			HttpSession ses=request.getSession();
			ses.putValue("ADMINID",A.getAdminid());
			ses.putValue("ADMINNAME", A.getAdminname());
			ses.putValue("TIME",new java.util.Date());
			JSONObject J=new  JSONObject();
			   try {
				J.put("message","1");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("hi");
			}
			   out.println(J);
			    out.flush();
		}
	}

}
