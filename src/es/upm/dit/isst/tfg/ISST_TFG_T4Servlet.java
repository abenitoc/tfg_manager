package es.upm.dit.isst.tfg;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.tfg.dao.TFGDAO;
import es.upm.dit.isst.tfg.dao.TFGDAOImpl;
import es.upm.dit.isst.tfg.model.TFG;

public class ISST_TFG_T4Servlet extends HttpServlet {
	/**
	 * Método encargado de servir la página principal de gestión
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest req, HttpServletResponse resp)
 throws IOException, ServletException {
	resp.setContentType("text/html");
	TFGDAO tfgDao = TFGDAOImpl.getInstance();
	UserService userService = UserServiceFactory.getUserService();
	String url = userService.createLoginURL(req.getRequestURI());
	String urlLinktext = "Login";
	String user = "";
	
	if (req.getUserPrincipal() != null){
		user = req.getUserPrincipal().getName();
		
		url = userService.createLogoutURL(req.getRequestURI());
		urlLinktext = "Logout";
		List<TFG> tfgs = tfgDao.isATeacher(user);
		if (tfgs.size() != 0){
			req.setAttribute("tfgs", tfgs);
		}
	}
	
	
	
	req.getSession().setAttribute("user", user);
	req.getSession().setAttribute("url", url);
	req.getSession().setAttribute("urlLinktext", urlLinktext);
	
	resp.sendRedirect("/MostrarTFGView.jsp");

	}
}