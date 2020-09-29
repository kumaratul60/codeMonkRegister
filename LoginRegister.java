package monk.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginRegister() {
		// super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClientDAO cd = new ClientDAOImpl();

		String userName = request.getParameter("username");
		String password = request.getParameter("password1");
		String submitType = request.getParameter("submit");

		Client c = new Client();
		c = cd.getClient(userName, password);
		// System.out.println(c.getName() + c.getPassword() + c.getUserName());

		if (submitType.equals("login") && c != null && c.getName() != null)

		// error java.lang.NullPointerException: Cannot invoke "String.equals(Object)"
		// because "submitType" is null
		// monk.login.LoginRegister.doPost(LoginRegister.java:33)

		{

			request.setAttribute("message", c.getName());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);

		} else if (submitType.equals("register")) {

			c.setName(request.getParameter("name"));
			c.setPassword(password);
			c.setUserName(userName);
			cd.insertClient(c);

			request.setAttribute("SuccessMessage", "Registration done , please login to continue  ");
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else {
			request.setAttribute("message", "Data Not Found, click on Register ");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
