import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ma on 29.09.14.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (!username.equals("") && !password.equals("")) {
            response.sendRedirect("/feed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = new PrintWriter(response.getOutputStream());
        pw.println("<form action='/login' method='POST'>");
        pw.println("<input type='text' name='username'/>");
        pw.println("<input type='password' name='password'/>");
        pw.println("<input type='submit' value='send' /></form>");
        pw.close();
    }
}
