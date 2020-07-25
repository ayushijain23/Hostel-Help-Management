package help.nic.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import help.nic.dao.studentDao;
import help.nic.model.student;

/**
 * Servlet implementation class studentcheckpwd
 */
@WebServlet("/studentcheckpwd")
public class studentcheckpwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentcheckpwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		student S=studentDao.checkpassword(request.getParameter("enrollmentno"), request.getParameter("password"));
		if(S==null)
		{
		out.println("<html><font color=red size=10>Invalid Adminid/Password</font></html>");
		
	    out.flush();
		}
		else{
			HttpSession ses=request.getSession();
			ses.putValue("STUDENTID",S.getEnrollmentno());
			ses.putValue("STUDENTNAME", S.getName());
			ses.putValue("LTIME",new java.util.Date());
			out.println("<html>");
			
			
		    			
		    			 out.println("<html lang='en'>");
		    			 out.println("<link rel='stylesheet' type='text/css' href='home2/css/bootstrap.min.css'>");
		    			 out.println("<link rel='stylesheet' type='text/css' href='home2/css/font-awesome.min.css' media='all'>");
		    			 out.println("<link rel='stylesheet' type='text/css' href='home2/css/simple-line-icons.css' media='all'>");
		    			 out.println("<link rel='stylesheet' type='text/css' href='home2/css/owl.carousel.css'>");
		    			 out.println("<link rel='stylesheet' type='text/css' href='home2/css/owl.theme.css'>");
		    			 out.println("<link rel='stylesheet' type='text/css' href='home2/css/jquery.bxslider.css'>");
		    			 out.println("<link rel='stylesheet' type='text/css' href='home2/css/jquery.mobile-menu.css'>");
		    			 out.println("<link rel='stylesheet' type='text/css' href='home2/css/style.css' media='all'>");
		    			 out.println("<link rel='stylesheet' type='text/css' href='home2/css/revslider.css' >");
		    			 out.println("<!-- Google Fonts -->");
		    			 out.println("<link href='https://fonts.googleapis.com/css?family=Open+Sans:700,600,800,400' rel='stylesheet' type='text/css'>");
		    			 out.println("<link href='https://fonts.googleapis.com/css?family=Poppins:400,300,500,600,700' rel='stylesheet' type='text/css'>");
		    			 out.println("</head>");
		    			 out.println("<body class='category-page' style='background-image:url(star.png);'>");
		    			 out.println("<div id='page'> ");
		    			 out.println("  <header>");
		    			 out.println("    <div class='header-container'>");
		    			 out.println("      <div class='container'>");
		    			 out.println("        <div class='row'>");
		    			 out.println("          <div class='col-lg-2 col-md-2 col-sm-3 col-xs-12 logo-block'> ");
		    			 out.println("            <!-- Header Logo -->");
		    			 out.println("            <div class='logo'> <a title='Magento Commerce' href='#'><img src='home2/images/logo.png'> </a> </div>");
		    			 out.println("            <!-- End Header Logo --> ");
		    			 out.println("          </div>");
		    			 out.println("        </div>");
		    			 out.println("      </div>");
		    			 out.println("    </div>");
		    			 out.println("  </header>");
		    			 out.println("  <nav>");
		    			 out.println("    <div class='container'>");
		    			 out.println("      <div class='mm-toggle-wrap'>");
		    			 out.println("        <div class='mm-toggle'><i class='fa fa-align-justify'></i><span class='mm-label'>Menu</span> </div>");
		    			 out.println("      </div>");
		    			 out.println("      <div class='nav-inner'> ");
		    			 out.println("        <!-- BEGIN NAV -->");
		    			    out.println("        <ul id='nav' class='hidden-xs'>");
		    		         //  out.println("          <li class='level0 parent drop-menu' id='nav-home'><a href='AdminLogin' class='level-top'><span>Admin Login</span></a></li>");
		    		           out.println("          <li class='level0 nav-6 level-top drop-menu'> <a class='level-top' href='Adminlogin'> <span>Admin Login</span> </a></li>");
		    		           out.println("          <li class='mega-menu'> <a class='level-top active' href='studentlogin'><span>Student Login</span></a></li>");
		    		      //     out.println("          <li class='mega-menu'> <a class='level-top' href='AboutUs.jsp'><span>About Us</span></a> </li>");
		    		           out.println("        </ul>");
		    			 out.println("        <!--nav-->");
		    			 out.println("        <div class='top-cart-contain'> ");
		    			 out.println("          <!-- Top Cart -->");
		    			 out.println("          <div class='mini-cart'>");
		    			 HttpSession ss=request.getSession();
		 		        String n="<center><p><b><i>Enrollment No:"+ss.getValue("STUDENTID").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ss.getValue("STUDENTNAME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ss.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=studentlogout>Logout</a></i></b></p></center>";
		 		        out.println(n);
		 		       ResultSet rs=studentDao.studentbyid(request.getParameter("enrollmentno"));
		 		        try{
		 		    		if(rs.next())
		 		    		{ out.println("            <div>");
		    			 out.println("            </div>");
		    			 out.println("          </div>");
		    			 out.println("          <!-- Top Cart -->");
		    			 out.println("        </div>");
		    			 out.println("      </div>");
		    			 out.println("    </div>");
		    			 out.println("  </nav>");
		    			 out.println("");
		    				
		    			 out.println(" <!-- Main Container -->");
		    			 out.println("  <section class='main-container col2-left-layout bounceInUp animated'>");
		    			 out.println("    <div class='container'>");
		    			 out.println("      <div class='row'>");
		    			 out.println("        <div class='col-sm-9 col-sm-push-3'>");
		    			 out.println("          <article class='col-main'>");
		    			 out.println("            <div class='category-products'>");
		    			 out.println(" <iframe frameborder=0 style='background-image:url(star.png);' width=950 height=890 name=mw></iframe>");
		    			 out.println("            </div>");
		    			 out.println("          </article>");
		    			 out.println("        </div>");
		    			 out.println("        <div class='col-left sidebar col-sm-3 col-xs-12 col-sm-pull-9'>");
		    			 out.println("          <aside class='col-left sidebar'>");
		    			 out.println("            <div class='side-nav-categories'>");
		    			 out.println("              <div class='block-title'>");
		    					 
		    			 out.println("<b><h3><center> Welcome:"+rs.getString(2)+"</center></h3></b><br>");
		    			 out.println("</div>");
		    			 out.println("              <div class='box-content box-category'>");
		    			 out.println("                <ul>");
		    				out.println("<b>&nbsp;&nbsp;&nbsp;<a href=studenthome?enrollmentno="+rs.getString(1)+" target=mw>Student Profile</a></b><br><b>&nbsp;&nbsp;&nbsp;<a target=mw href=studentdashboard?enrollmentno="+rs.getString(1)+">Dashboard</a></b><b><br>&nbsp;&nbsp;&nbsp;<a target=mw href=studentcompview>File a Complain</a></b><br>&nbsp;&nbsp;&nbsp;<b><a href=studentlogout>Logout</b></a>");
		    			     	// out.println("                  <li> <a href=# >Search</a> <span class='subDropdown minus'></span></li>");
		    			 out.println("                </ul>");
		    			 out.println("              </div>");
		    			 out.println("            </div>");
		    			 out.println("          </aside>");
		    			 out.println("        </div>");
		    			 out.println("      </div>");
		    			 out.println("    </div>");
		    			 out.println("  </section>");
		    			 out.println("<footer class='footer'> ");
		    			 out.println("    <div class='footer-middle'>");
		    			 out.println("      <div class='container'>");
		    			 out.println("        <div class='row'>");
		    			 out.println("        </div>");
		    			 out.println("      </div>");
		    			 out.println("    </div>");
		    			 out.println("  </footer> ");
		    			 out.println("</div>");
		    			 out.println("<script type='text/javascript' src='home2/js/jquery.min.js'></script> ");
		    			 out.println("<script type='text/javascript' src='home2/js/bootstrap.min.js'></script>  ");
		    			 out.println("<script type='text/javascript' src='home2/js/common.js'></script> ");
		    			 out.println("<script type='text/javascript' src='home2/js/owl.carousel.min.js'></script> ");
		    			 out.println("<script type='text/javascript' src='home2/js/jquery.mobile-menu.min.js'></script> ");
		    			 out.println("</body>");
		    			 out.println("</html>");
		    			
				
		    	}	
		        }
				catch(Exception e)
		        {System.out.println(e);
		        }
		        out.println("</html>");
		}
			
		}
	}



