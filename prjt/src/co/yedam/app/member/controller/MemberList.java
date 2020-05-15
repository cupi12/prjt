package co.yedam.app.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.common.Paging;
import co.yedam.app.member.model.MemberDAO;
import co.yedam.app.member.model.MemberVO;

@WebServlet("/MemberList.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String regdt = request.getParameter("regdt");
	
	String strPage = request.getParameter("p");
	int p =1;
	
	MemberDAO dao = new MemberDAO();
	
	if(strPage != null && !strPage.isEmpty()) {
		p=Integer.parseInt(strPage);
	}
	Paging paging = new Paging();
	paging.setPageUnit(5); //한페이지에 출력할 레코드 건수
	paging.setPageSize(5); //한페이지에 출력할 페이지 번호 수
	paging.setPage(p); //현재 페이지
	paging.setTotalRecord(dao.getCount(id, name)); //전체 레코드 건수 (조회 필수)!!!
	
	request.setAttribute("paging", paging);
	//목록 조회
	int start = paging.getFirst();
	int end = paging.getLast();
	
	
	List<MemberVO> list =dao.getMemberList(start, end, id, name);
	
	request.setAttribute("list", list);
	request.getRequestDispatcher("/member/memberList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
