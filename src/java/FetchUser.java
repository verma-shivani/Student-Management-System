

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
public class FetchUser extends HttpServlet {

   protected void service(HttpServletRequest req,HttpServletResponse resp)
   {
       
       try 
       {
           
           resp.setContentType("text/html");
           PrintWriter out=resp.getWriter();
           
           
           out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">"); 
        out.println("<title>Glassfish HTML Testing</title>");
        out.println("<style>");     
        out.println("table {");        
        out.println("color:black;");
        out.println("background-color:#ccff90;");
        out.println("border: 1px solid black;");
        out.println("}");   
        
        out.println("body{");
        out.println("background-color:#33691e");
         out.println("}"); 
         
         
        out.println("div {");        
        out.println("color:white;");
 //       out.println("border: 1px solid black;");
//        out.println("width: 50%;");
//        out.println("height: 50%;");
        out.println("margin-top:10% ;");
        out.println("margin-bottom:50%;");
        out.println("margin-left:35% ;");
        out.println("text-align:center;");
        out.println("}");
        
        out.println("</style>");  
        out.println("</head>");
        out.println("<body>");
           
           
           JdbcUtils.connectDB();
           String qry="Select * from WebUser";
           ResultSet rs=JdbcUtils.fetch(qry);
           out.println("<div>");
           out.println("<table border='2' cellSpacing='2' cellPadding='5'>");
           out.println("<tr>");
           out.println("<th>id</th>");
           out.println("<th>name</th>");
           out.println("<th>phone</th>");
           out.println("<th>email</th>");
           out.println("<th>age</th>");
           out.println("</tr>");
           //out.println("<img src=https://cdn.pixabay.com/photo/2017/04/19/22/32/laptop-2243898_960_720.png>");
           while(rs.next())
           {
               out.println("<tr>");
               out.println("<td>"+rs.getInt("id")+"</td>");
               out.println("<td>"+rs.getString("name")+"</td>");
               out.println("<td>"+rs.getString("phone")+"</td>");
               out.println("<td>"+rs.getString("email")+"</td>");
               out.println("<td>"+rs.getString("age")+"</td>");
               out.println("<td><a href='DeleteUser?id="+rs.getInt("id")+"'>delete</a></td>");
                out.println("</tr>");
           }
           out.println("</div>");
           out.println("</body>");
           
       } 
       catch (IOException ex) 
       {
           Logger.getLogger(FetchUser.class.getName()).log(Level.SEVERE, null, ex);
       }
       catch(Exception e)
       {
           e.getCause();
       }
   }

    

}
