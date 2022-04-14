package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet(urlPatterns = "/login")

public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		String pwd = req.getParameter("pwd");

		UserBean bean = new UserBean();
		bean.setLogin(login);
		bean.setPassword(pwd);

		UserModel model = new UserModel();
		try {
			UserBean bean1 = model.authenticate(bean);

			if (login.equals("") && pwd.equals("")) {
				RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");

				req.setAttribute("err1", "Login is Req...");

				req.setAttribute("err2", "Password is Req...");

				rd.forward(req, resp);

			} else if (login.equals("") || pwd.equals("")) {

				if (login.equals("")) {

					req.setAttribute("err1", "Login is Req...");

				}
				if (pwd.equals("")) {

					req.setAttribute("err2", "Password is Req...");

				}
				RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
				rd.forward(req, resp);

			} else {

				if (bean1 != null) {
					RequestDispatcher rd = req.getRequestDispatcher("WelcomeView.jsp");

					req.setAttribute("user", bean1.getName());

					rd.forward(req, resp);
				} else {

					RequestDispatcher rd = req.getRequestDispatcher("loginView.jsp");

					req.setAttribute("err", "Invalid User...");

					rd.forward(req, resp);

				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
