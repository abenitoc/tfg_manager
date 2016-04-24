package es.upm.dit.isst.tfg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class ISST_TFG_T4Servlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest req, HttpServletResponse resp)
 throws IOException, ServletException {
	resp.setContentType("text/html");
	UserService userService = UserServiceFactory.getUserService();
	String url = userService.createLoginURL(req.getRequestURI());
	String urlLinktext = "Login";
	String user = "";
	if (req.getUserPrincipal() != null){
		user = req.getUserPrincipal().getName();
		url = userService.createLogoutURL(req.getRequestURI());
		urlLinktext = "Logout";
	}
	
	req.getSession().setAttribute("user", user);
	req.getSession().setAttribute("url", url);
	req.getSession().setAttribute("urlLinktext", urlLinktext);
	
	resp.sendRedirect("/MostrarTFGView.jsp");

	}
}