package co.yedam.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.board.model.BoardDAO;
import co.yedam.app.board.model.BoardVO;

@WebServlet("/BoardUpdate.do")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = (Integer.parseInt(request.getParameter("seq")));
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(seq);
		
		request.setAttribute("seq", vo);
		request.getRequestDispatcher("/board/boardUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String id = request.getParameter("id");
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(seq);
		vo.setSeq(seq);
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setId(id);				
				
		dao.getBoard(seq);
		doGet(request, response);
	}

}
