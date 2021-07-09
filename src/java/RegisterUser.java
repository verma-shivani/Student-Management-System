

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterUser extends HttpServlet {

   
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
        //for h2 heading
        out.println("h2 {");        
        out.println("color:white;");
        out.println("background-color:blue;");
        out.println("}");  
        //for div conatainer
        out.println("div {");        
        out.println("color:white;");
        out.println("background-color:blue;");
        out.println("border: 1px solid black;");
        out.println("width: 50%;");
        out.println("height: 50%;");
        out.println("margin-top:50% ;");
        out.println("margin-bottom:50%;");
        out.println("margin-left:30% ;");
        out.println("text-align:center;");
        out.println("}");
        
        out.println("</style>");  
        out.println("</head>");
        out.println("<body>");
          int id=Integer.parseInt(req.getParameter("id"));
          String name=req.getParameter("name");
          String  phone=req.getParameter("phone");
          String emailid=req.getParameter("emailid");
          int age=Integer.parseInt(req.getParameter("age"));
          
          /*Code for Database Connectivity*/
          JdbcUtils.connectDB();
          
          String qry="insert into WebUser values(' "+id+"','"+name+"','"+phone+"','"+emailid+"','"+age+"')";
          int rs=JdbcUtils.insert(qry);
          
          if(rs>0)
          {
              out.println("<div>");
              out.println("<h2>User Registered</h2>");
              out.println("</div>");
          }
          else
          {
              out.println("<h2>User Registration failed !!</h2>");
          }
          out.println("</body>");
          
      }
      catch(Exception e)
      {
          System.out.println(e.getMessage());
      }
    }      
    

    

}
