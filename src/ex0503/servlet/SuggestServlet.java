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

	private String words[] = { "자바 프로그래밍", "자바 스터디", "자바", "자습하자", "Ajax", "ajax프로그래밍", "ajax실습", "Ajax공부하자" };

	//첫 단어를 동일한 단어를 찾아주는 메소드
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

		/*//front 보낼 데이터 설정
		PrintWriter out = response.getWriter();
		//front로 데이터를 전송하기 위해서 text형식으로 변환한다.
		
		String data = list.size()+"|";
		out.print(data);
		for(int i=0; i<list.size(); i++) {
			if(i==(list.size()-1))
				out.print(list.get(i));
			else
				out.print(list.get(i)+",");
		}*/
	
		//---------------------------------------------------------------------------//
		//list를 Json으로 변환해서 보내기
		JSONArray jsonArr = JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
		out.println(jsonArr);
	
		
	}
}
