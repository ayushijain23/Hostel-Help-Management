package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import help.nic.dao.hostelDao;
import help.nic.model.hostel;

/**
 * Servlet implementation class hostelsubmit
 */
@WebServlet("/hostelsubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class hostelsubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hostelsubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		hostel H=new hostel();
		H.setHostelid(request.getParameter("hostelid"));
		H.setHostelname(request.getParameter("hostelname"));
		H.setType(request.getParameter("type"));
		H.setWarden(request.getParameter("warden"));
		H.setPhone(request.getParameter("phone"));
		H.setEmail(request.getParameter("email"));
		try{
			Part part=request.getPart("photograph");
			String path="C:/Users/AYUSHI/workspace/Hostel Help Portal/WebContent/Pictures";
			FileUpload F=new FileUpload(part,path);
			H.setPhotograph(F.filename);
		}
		catch(Exception e){System.out.print(e);}
		boolean st=hostelDao.addnewrecord(H);
		out.println("<html>");
		if(st){ out.println("<h4><font color=blue>record Submitted...<br><a href=hostelview>Click Here to add more hostels</a></font></h4>");
		}
		else
		{
			out.println("<h4><font color=red>Failed!</font></h4>");	
		}
		out.println("</html>");
		out.flush();
		}
}
