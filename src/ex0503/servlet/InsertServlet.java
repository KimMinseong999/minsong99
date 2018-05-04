package ex0503.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex0503.dao.CustomerDAO;
import ex0503.dao.CustomerDAOImpl;
import ex0503.dto.CustomerDTO;


@WebServlet("/insertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age =Integer.parseInt(request.getParameter("age"));
		String phone = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		CustomerDAO dao = new CustomerDAOImpl();
		int result = dao.insert(new CustomerDTO(id, name, age, phone, addr));
		PrintWriter out = response.getWriter();
		out.print(result);
	}
}
