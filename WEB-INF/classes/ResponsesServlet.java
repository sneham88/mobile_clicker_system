import java.io.*;
import java.sql.*;
import jakarta.servlet.*;            // Tomcat 10
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
//import javax.servlet.*;            // Tomcat 9
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;

@WebServlet("/response")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)
public class ResponsesServlet extends HttpServlet {

   // The doGet() runs once per HTTP GET request to this servlet.
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
      // Set the MIME type for the response message
      response.setContentType("text/html");
      // Get a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
      // Print an HTML page as the output of the query
      out.println("<html>");
      out.println("<head><title>Query Response</title></head>");
      out.println("<body>");

      try (
         // Step 1: Allocate a database 'Connection' object
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/mobile_clicker_system?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
               "myuser", "xxxx");   // For MySQL
               // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"

         // Step 2: Allocate a 'Statement' object in the Connection
         Statement stmt = conn.createStatement();
      ) {
 
        /** // Step 3: Execute a SQL SELECT query
        String sqlStr = "select * from responses where response = "
        + "'" + request.getParameter("choice") + "'";   // Single-quote SQL string
**/
        // Step 4 of the database servlet
        // Assume that the URL is http://ip‐addr:port/mobile_clicker_system/select?choice=x
        // Assume that the questionNo is 8
        String choice = request.getParameter("choice");
        String sqlstr = "INSERT INTO responses (questionNo, choice) VALUES (1, '"
            + choice + "')";
        int count = stmt.executeUpdate(sqlstr);   // run the SQL statement
            
            } catch (SQLException ex) {
                // Handle any SQL errors
                ex.printStackTrace();
            } finally {
                out.println("</body></html>");
                out.close();
            }
        }
}
