import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ma on 01.10.14.
 */
public class FeedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = Helpers.current_user(request);
        if (username != null) {
            response.setContentType("text/html");
            PrintWriter pw = new PrintWriter(response.getOutputStream());
            pw.println("<h3>Welcome, " + username  + "</h3>");
            pw.println("<h1>Recent updates</h1>");
            pw.println("<a href='/logout'>Log out</a>");
            pw.close();
        }
        else {
            response.sendRedirect("/login");
        }
    }
}
