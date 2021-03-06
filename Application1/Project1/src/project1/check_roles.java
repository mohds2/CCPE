package project1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;


public class check_roles extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException,
                                                           IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.close();
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException,
                                                            IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        Access access = new Access();
        String user = (String)session.getAttribute("user-email");
        String method = "manage_roles";
        
        if(user == null){
            out.println("");
        }
        else if(!access.has_access(user, method)){
            out.println("");
        }
        else{
            out.println("<a href=\"manage_roles\">Manage Roles</a>");
        }
        
        out.close();
    }
}
