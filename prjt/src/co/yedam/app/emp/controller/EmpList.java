package co.yedam.app.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.common.Paging;
import co.yedam.app.emp.EmpDAO;
import co.yedam.app.emp.EmpVO;

/**
 * Servlet implementation class EmpList
 */
@WebServlet("/EmpList.do")
public class EmpList extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EmpList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		
		String department_id = request.getParameter("department_id");
		String first_name = request.getParameter("first_name");
		//<*페이징 처리*>
		//현재페이지 파라미터 받기
		String strPage = request.getParameter("p"); //페이지 번호 받아옴.
		int p =1;				
	
		if(strPage != null && !strPage.isEmpty()) {
			p = Integer.parseInt(strPage);
		}
		//페이징 객체를 생성
		Paging paging = new Paging();
		paging.setPageUnit(5); //한페이지에 출력할 레코드 건수
		paging.setPageSize(5); //한페이지에 출력할 페이지 번호 수
		paging.setPage(p); //현재 페이지
		paging.setTotalRecord(dao.getCount(department_id, first_name)); //전체 레코드 건수 (조회 필수)!!!
		
		request.setAttribute("paging", paging);
		//목록 조회
		int start = paging.getFirst();
		int end = paging.getLast();
		
		List<EmpVO> list =  dao.selectAll(start, end, department_id, first_name);
		
		
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/emp/empList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
