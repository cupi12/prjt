package co.yedam.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import co.yedam.app.board.model.BoardDAO;
import co.yedam.app.board.model.BoardVO;

/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/BoardInsert.do")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public BoardInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/board/boardInsert.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); // 한글 출력되도록
		request.setCharacterEncoding("utf-8"); // GET방식은 setCharacterEncoding 할 필요없음
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String id = request.getParameter("id");
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setId(id);
		vo.setContents(contents);
		vo.setTitle(title);		
		
		dao.BoardInsert(vo);
		
		String contextPath = getServletContext().getContextPath();
		response.sendRedirect(contextPath + "/BoardList.do");
		
		
	}

}
