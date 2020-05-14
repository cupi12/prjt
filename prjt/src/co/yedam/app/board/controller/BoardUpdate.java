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
//		String seq = (String)request.getParameter("seq");
		if(seq == 0) {
			response.sendRedirect(request.getContextPath() + "/BoardUpdate.do");
		}
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(seq);
		
		vo.setSeq(seq);
		request.setAttribute("vo", dao.getBoard(seq));
		request.getRequestDispatcher("/board/boardUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8"); 		
		
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
				
		dao.BoardUpdate(vo);
	}

}
