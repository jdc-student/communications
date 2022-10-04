package communications;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Include Message (Relative path) from ServletRequest
		var header=req.getRequestDispatcher("./header");
		header.include(req, resp);
		
		//Include Message (Named Dispatcher) from Servlet Context
		var context = getServletContext();
		//Named Dispatcher
		var message = context.getNamedDispatcher("IncludeMessage");
		//Include Via Named Dispatcher
		message.include(req, resp);
		//Own Servlet Message
		resp.getWriter().append("<h2>").append("Own Servlet Message...").append("</h2>");
		
		var footer = context.getRequestDispatcher("/footer");
		footer.include(req, resp);
	}

}
