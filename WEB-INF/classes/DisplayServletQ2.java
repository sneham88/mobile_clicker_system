import java.io.*;
import java.sql.*;
import jakarta.servlet.*;            // Tomcat 10
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
//import javax.servlet.*;            // Tomcat 9
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;

@WebServlet("/display2")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)
public class DisplayServletQ2 extends HttpServlet {

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
      out.println("<head><title>Response Statistics</title></head>");
      // Bootstrap CSS
      out.println("<link href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' rel='stylesheet'>");
      out.println("</head>");
      out.println("<body>");

      /** String questionNo = request.getParameter("questionNo");
      if (questionNo == null) {
          //questionNo = "1"; // default to question number 1 if the parameter is missing
      } else {
          try {
              int qNo = Integer.parseInt(questionNo);
              if (qNo < 1 || qNo > 5) {
                  questionNo = "1"; // default to question 1 if out of range
              }
          } catch (NumberFormatException e) {
              questionNo = "1"; // default to question 1 if not a number
          }
      } **/
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
        // Assume that the URL is http://ip‐addr:port/mobile_clicker_system/display
                
        String query = "SELECT choice, COUNT(*) AS count FROM responses WHERE questionNo=2 GROUP BY choice";
        ResultSet rs = stmt.executeQuery(query);

        // Print the results message passing the correct questionNo
        out.println("<h3>Results for Question 2" + ":" + "</h3>");

        String[] progressBarClasses = {"bg-primary", "bg-success", "bg-danger", "bg-warning"};
        int i = 0;
        int totalResponses = 50; // Example value, adjust as needed

        while (rs.next()) {
            String choice = rs.getString("choice");
            int count = rs.getInt("count");
            int progress = (count * 100) / totalResponses;

            // Ensures that the index does not exceed the number of defined classes
            String progressBarClass = progressBarClasses[i % progressBarClasses.length];

            out.println("<div class='row align-items-center my-1'>");
            out.println("<div class='col-1 text-right pr-0'>" + choice + "</div>"); 
            out.println("<div class='col-6 pl-1'>"); 
            out.println("<div class='progress'>");
            out.println("<div class='progress-bar " + progressBarClass + "' role='progressbar' style='width: " + progress + "%;' aria-valuenow='" + progress + "' aria-valuemin='0' aria-valuemax='100'>" + count + "</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            
            i++; // Increment to get the next class for the next progress bar
        }
           // Link to go back to the specific question page
           out.println("<a href='question2.html' class='btn btn-secondary mt-2'>Back</a>");
            
            } catch (SQLException ex) {
                // Handle any SQL errors
                ex.printStackTrace();
            } finally {
                out.println("</body></html>");
                out.close();  // Close the output writer
            }
        }

        // Add a new doPost() method
// The new doPost() runs the doGet() too
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response)
                   throws ServletException, IOException {
   doGet(request, response);  // Re-direct POST request to doGet()
}
    
    }