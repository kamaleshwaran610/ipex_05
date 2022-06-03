/*
*	To change this license header, choose License Headers in Project Properties.
*	To change this template file, choose Tools | Templates
*	and open the template in the editor.
*/
package Lab_Ex_5;

import java.io.IOException; import java.io.PrintWriter; import java.util.HashMap;
import javax.servlet.ServletException; import javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Ex_3_book_servlet", urlPatterns = {"/Ex_3_book_servlet"}) public class Ex_3_book_servlet extends HttpServlet {
HashMap<String,Ex_3_Book> map=new HashMap<>();
Ex_3_Book book;
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
int copies=Integer.parseInt(request.getParameter("copies")); try(PrintWriter out = response.getWriter()){
if(copies<=book.stock)
{
book.stock-=copies; out.println("<center><h2>"+"Order Details"+ "</h2>");
out.println("<table border=2 width='300px' height='300px' style='cell-padding:2%; text-align:center;background-color:#98FB98;font-size:large;'><tr><td>
colspan='2'>Receipt</td>");
out.println("<tr><td>Title</td><td>"+book.title+"</td>"); out.println("<tr><td>Author</td><td>"+book.author+"</td>"); out.println("<tr><td>Price per book</td><td>"+book.price+"</td>"); out.println("<tr><td><b>Total
cost</b></td><td><b>"+(copies*book.price)+"</b></td></table></center>");
}
 
else
{
out.println("<center><div style='border:5px solid red;width:450px;height:250px;background-color:#ffcccb;text-align:center;'>");
out.println("<p style='color:red;font-size:xx-large;'>Sorry, the requested number of copies
is not available:( !! </p>");
out.println("<button style='border-radius:2%;background-color:white;' onclick=location.href='http://localhost:8080/IP_LAB_EXERCISES/Lab_5_Book.html>Back to home page</button>");
out.println("</div></center>");
}
}
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
book=new Ex_3_Book("Dr.A.P.J.Abdul Kalaam","My Journey",1000.00,"GG Publisher",40); map.put(book.title, book);

book=new Ex_3_Book("Dr.Bibek Debroy","Making of New India",750.00,"TR Publisher",23); map.put(book.title, book);

book=new Ex_3_Book("Dr.Krishna Saksena","Whispers of Time",870.50,"MJ Publisher",26); map.put(book.title, book);

//get details
String bName=request.getParameter("bookname"); String author=request.getParameter("author");
try (PrintWriter out = response.getWriter()) { out.println("<!DOCTYPE html>"); out.println("<html>"); out.println("<head>"); out.println("<title>Book Servlet</title>"); out.println("</head>"); out.println("<body>");
if(map.containsKey(bName))
{
book=map.get(bName);
if(book.author.equals(author))
{
out.println("<center><h3>"+"Book Details"+ "</h3>");
out.println("<table border=2 width='400px' height='3400px' style='cell-padding:2%;text- align:center;background-color:shkyblue;font- size:16px;'><tr><td>Title</td><td>"+book.title+"</td>");
 
out.println("<tr><td>Author</td><td>"+book.author+"</td>"); out.println("<tr><td>Price</td><td>"+book.price+"</td>");
out.println("<tr><td><b>Stock available</b></td><td><b>"+book.stock+"</b></td></table><br>"); out.println("<form method='get' action='http://localhost:8080/IP_LAB_EXERCISES/Ex_3_book_servlet'>");
out.println("Enter number of copies of book:<input type='number' autofocus name='copies'><br><br>");
out.println("<input type='submit' value='Get copies'></center>");
}
else
{
out.println("<center><div style='border:5px solid red;width:450px;height:250px;background- color:#ffcccb;text-align:center;'>");
out.println("<p style='color:red;font-size:xx-large;'>Sorry, the requested book is not available:( !!
</p>");
out.println("<button style='border-radius:2%;background-color:white;' onclick=location.href='http://localhost:8080/IP_LAB_EXERCISES/Lab_5_Book.html'>Back to home page</button>");
out.println("</div></center>");
}
}
else
{
out.println("<center><div style='border:5px solid red;width:450px;height:250px;background- color:#ffcccb;text-align:center;'>");
out.println("<p style='color:red;font-size:xx-large;'>Sorry, the requested book is not available:( !!
</p>");
out.println("<button style='border-radius:2%;background-color:white;' onclick=location.href='http://localhost:8080/IP_LAB_EXERCISES/Lab_5_Book.html'>Back to home page</button>");
out.println("</div></center>");
}
out.println("</body>"); out.println("</html>");
}
}
@Override
public String getServletInfo() { return "Short description";
}// </editor-fold>
}
 
