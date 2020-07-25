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
import help.nic.dao.studentDao;
import help.nic.model.hostel;

/**
 * Servlet implementation class hosteleditdelete
 */
@WebServlet("/hosteleditdelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class hosteleditdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hosteleditdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();

		String btn=request.getParameter("btn");
		if(btn.equalsIgnoreCase("delete")){
			String hostelid=request.getParameter("hostelid");
		boolean st=hostelDao.deletebyid(hostelid);	
		}
		else if(btn.equalsIgnoreCase("edit"))
		{hostel H=new hostel();
		H.setHostelid(request.getParameter("hostelid"));
		H.setHostelname(request.getParameter("hostelname"));
		H.setType(request.getParameter("type"));
		H.setWarden(request.getParameter("warden"));
		H.setPhone(request.getParameter("phone"));
        H.setEmail(request.getParameter("email"));
        H.setPhotograph("");
        if(request.getPart("photograph").getSize()>0)
        {try{
        Part part=request.getPart("photograph");
        String path="C:/Users/AYUSHI/workspace/Hostel Help Portal/WebContent/Pictures";
        FileUpload F=new FileUpload(part,path);
        H.setPhotograph(F.filename);
        }catch(Exception e){System.out.println(e);
        }
        }
        hostelDao.edit(H);
}
		response.sendRedirect("hosteldisplayall");
	}

}
