package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import help.nic.dao.dbHelper;
import help.nic.dao.hostelDao;

/**
 * Servlet implementation class FetchHostelByJSON
 */
@WebServlet("/FetchHostelByJSON")
public class FetchHostelByJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchHostelByJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try{
		 ResultSet rs=hostelDao.hostelDisplayall();
		 ArrayList<JSONObject>json=dbHelper.getFormattedResult(rs);
		   out.println(json);
		}catch(Exception e)
		{
		out.println(e);	
		}
		}
	}


