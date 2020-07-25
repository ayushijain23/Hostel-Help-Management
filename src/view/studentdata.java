package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import help.nic.dao.studentDao;
import help.nic.model.student;

/**
 * Servlet implementation class studentdata
 */
@WebServlet("/studentdata")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class studentdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		

		String btn=request.getParameter("btn");
		
	 if(btn.equalsIgnoreCase("edit"))
		{
			student S=new student();
			S.setEnrollmentno(request.getParameter("enrollmentno"));
			S.setName(request.getParameter("sname"));
			S.setGender(request.getParameter("gender"));
			S.setFname(request.getParameter("fname"));
			S.setMname(request.getParameter("mname"));
			S.setAdmissionyear(request.getParameter("admissionyear"));
			S.setBranch(request.getParameter("branch"));
			S.setSemester(request.getParameter("semester"));
			S.setPassword(request.getParameter("pwd"));
			S.setEmail(request.getParameter("email"));
			S.setAddress(request.getParameter("address"));
			S.setMobile(request.getParameter("smobile"));
			S.setFmobileno(request.getParameter("fmobile"));
			S.setPhoto("");
			if(request.getPart("photo").getSize()>0)
			{try{
				Part part=request.getPart("photo");
				String path="C:/Users/AYUSHI/workspace/Hostel Help Portal/WebContent/Pictures";
				FileUpload F=new FileUpload(part,path);
			    S.setPhoto(F.filename);
			
			}catch(Exception e){System.out.print(e);}
		}
	
			
       studentDao.edit(S);
		 
		}
		response.sendRedirect("student");}

	

}

