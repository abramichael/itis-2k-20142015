import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ma on 01.10.14.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //какая-то валидация
        if (!username.isEmpty() && !password.isEmpty()) {
            Cookie cookie = new Cookie("user", username);
            cookie.setMaxAge(3600);
            cookie.setPath("/");
            response.addCookie(cookie);
            HttpSession hs = request.getSession();
            hs.setAttribute("current_user", username);
            response.sendRedirect("/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie userCookie = Helpers.getUserCookie(request);
        if (userCookie != null) {
            HttpSession hs = request.getSession();
            hs.setAttribute("current_user", userCookie.getValue());
        }

        if (Helpers.current_user(request) != null) {
            response.sendRedirect("/");
        }
        else {
            response.setContentType("text/html");
            PrintWriter pw = new PrintWriter(response.getOutputStream());
            pw.println("<form action='/login' method='POST'>");
            pw.println("<input type='text' name='username' /><br/>");
            pw.println("<input type='password' name='password' /><br/>");
            pw.println("<input type='submit' value='login' />");
            pw.println("</form>");
            pw.close();
        }
    }
}
