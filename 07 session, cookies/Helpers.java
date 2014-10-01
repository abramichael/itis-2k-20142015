import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ma on 01.10.14.
 */
public class Helpers {
    public static String current_user(HttpServletRequest req) {
        HttpSession hs = req.getSession();
        return (String) hs.getAttribute("current_user");
    }
    public static Cookie getUserCookie(HttpServletRequest req) {
        Cookie [] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) {
                return cookie;
            }
        }
        return null;
    }
}
