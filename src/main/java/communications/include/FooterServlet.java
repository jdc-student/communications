package communications.include;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/footer")
public class FooterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String FOOTER = """
			</body>
			</html>
			""";
	private static final String HOME ="<a href='index.html'>Home</a>";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append(HOME).append(FOOTER);
	}
}
