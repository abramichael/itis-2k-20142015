import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by ma on 01.10.14.
 */
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Helpers.current_user(request) != null) {
            HttpSession hs = request.getSession();
            Cookie cookie = Helpers.getUserCookie(request);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            hs.removeAttribute("current_user");
        }
        response.sendRedirect("/login");
    }
}
