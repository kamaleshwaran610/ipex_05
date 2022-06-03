import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.color;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Gross_salary extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         
            String name=request.getParameter("Name");
             String empid=request.getParameter("empid");
              int sal=Integer.parseInt(request.getParameter("pay"));
               int  hra1=Integer.parseInt(request.getParameter("hra"));
               int da=sal/2;
                
               hra1+=da;
               int gross=hra1+sal;
              
               
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Employee Information </title>");            
            out.println("</head>");
            out.println("<body BGCOLOR= cyan >");
            out.println("<h1>" +" Employee Name:" + name+ "</h1>");
            out.println("<h1>" +" Employee id:" + empid+ "</h1>");
            out.println("<h1>" +" Employee Basic Pay:" + sal+ "</h1>");
            out.println("<h1>" +" Employee House allowance:" + hra1+ "</h1>");
            out.println("<h1>" +" Employee Gross Pay:" + gross+ "</h1>");
            out.println("</body>");
            out.println("</html>");
             
        }
    }
 @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
processRequest(request, response);
}

/**
*	Handles the HTTP <code>POST</code> method.
*
*	@param request servlet request
*	@param response servlet response
*	@throws ServletException if a servlet-specific error occurs
*	@throws IOException if an I/O error occurs
*/ @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException { processRequest(request, response);
}
@Override
public String getServletInfo() { return "Short description";
}// </editor-fold>

}
