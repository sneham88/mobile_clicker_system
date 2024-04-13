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
      out.println("<head>");
      out.println("<head><title>Query Response</title></head>");
      // Bootstrap CSS
      out.println("<link href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' rel='stylesheet'>");
      out.println("</head>");
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
 

        // Step 3 & 4 of the database servlet
        // Assume that the URL is http://ip‐addr:port/mobile_clicker_system/response?choice=x
        String questionNo = request.getParameter("questionNo");
        String choice = request.getParameter("choice");
        String sqlstr = "INSERT INTO responses (questionNo, choice) VALUES ('" + questionNo + "', '"
            + choice + "')";
        int count = stmt.executeUpdate(sqlstr);   // run the SQL statement

        // Print the confirmation message including the SQL statement
        out.println("<p>Thank you for your response. Your SQL statement is:</p>");
        out.println("<pre>" + sqlstr + "</pre>");
        // Add the button that links to /display
        out.println("<a href='/mobile_clicker_system/display' class='btn btn-primary'>See Statistics</a>");
                // Add the button to go back to question1.html
        out.println("<a href='question1.html' class='btn btn-secondary mt-2'>Back</a>");

            
            } catch (SQLException ex) {
                // Handle any SQL errors
                ex.printStackTrace();
            } finally {
                out.println("</body></html>");
                out.close();  // Close the output writer
            }
        }
}
