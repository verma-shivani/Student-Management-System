


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteUser extends HttpServlet {

    protected void service(HttpServletRequest req,HttpServletResponse resp)
   {
       
       try 
       {
         int id=Integer.parseInt(req.getParameter("id"));
         JdbcUtils.connectDB();
         String qry="delete from WebUser where id="+id;
         int deletedRows=JdbcUtils.delete(qry);
         System.out.println(deletedRows);
         if(deletedRows>0)
         {
             resp.sendRedirect("FetchUser");
         }
          JdbcUtils.close(); 
           
       } 
       catch(Exception e)
       {
           e.getCause();
       }
   }
}
