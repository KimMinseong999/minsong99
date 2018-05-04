package ex0503.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SuggestServlet
 */
@WebServlet("/suggestServlet")
public class SuggestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String words[] = { "�ڹ� ���α׷���", "�ڹ� ���͵�", "�ڹ�", "�ڽ�����", "Ajax", "ajax���α׷���", "ajax�ǽ�", "Ajax��������" };

	//ù �ܾ ������ �ܾ ã���ִ� �޼ҵ�
	private List<String> search(String keyWord){
		List<String> list = new ArrayList<>();
		for(String word : words) {
			if(word.toUpperCase().startsWith(keyWord.toUpperCase())) {
				list.add(word);
			}
		}
		
		return list;
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String keyWord = request.getParameter("keyWord");
		List<String> list = this.search(keyWord);

		/*//front ���� ������ ����
		PrintWriter out = response.getWriter();
		//front�� �����͸� �����ϱ� ���ؼ� text�������� ��ȯ�Ѵ�.
		
		String data = list.size()+"|";
		out.print(data);
		for(int i=0; i<list.size(); i++) {
			if(i==(list.size()-1))
				out.print(list.get(i));
			else
				out.print(list.get(i)+",");
		}*/
	
		//---------------------------------------------------------------------------//
		//list�� Json���� ��ȯ�ؼ� ������
		JSONArray jsonArr = JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
		out.println(jsonArr);
	
		
	}
}
