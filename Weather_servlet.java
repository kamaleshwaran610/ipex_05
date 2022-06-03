import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class report extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String res=request.getParameter("city");
            int temp=0;
            String s=""; 
            if(res .equals("madurai"))
            {
                temp=100;
                s="sunny";
                
            }
            else if(res .equals("chennai"))
            {
                temp=101;
                s="very hot";
            }
            else if(res .equals("coimbatore"))
            {
                temp=90;
                s="cloudy";
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet report</title>");            
            out.println("</head>");
            out.println("<body style= \"background-image: url('rainbow.jpg');background-size:cover;background-repeat: no-repeat \">");
            //out.println("<h1 > "+"Temperature:"+ temp +"<br>"+ s + "</h1>+<img src=\"sun.jfif\"  width=\"200\" height=\"200\">");
           //response.getWriter().write(s);
             //{
              //   out.println("<img src="+ url('sun.jfif') +" height=50% width=50% >");
             //}
             if(temp>=100)
             {
                 out.println("<h1 > "+"Temperature:"+ temp +"<br>"+ s + "</h1>+<img src=\"sun.jfif\"  width=\"200\" height=\"200\">");
             }
             else if(temp<100)
             {
                 out.println("<h1 > "+"Temperature:"+ temp +"<br>"+ s + "</h1>+<img src=\"cloudy.jfif\"  width=\"200\" height=\"200\">");
             }
            
            out.println("</body>");
            out.println("</html>");
        }
    }
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
processRequest(request, response);
}
@Override
public String getServletInfo() { return "Short description";
}// </editor-fold>
}

 
