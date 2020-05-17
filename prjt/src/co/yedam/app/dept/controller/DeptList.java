package co.yedam.app.dept.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.common.Paging;
import co.yedam.app.dept.model.DeptDAO;
import co.yedam.app.dept.model.DeptVO;

/**
 * Servlet implementation class DeptList
 */
@WebServlet("/DeptList.do")
public class DeptList extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String department_id = request.getParameter("department_id");
		DeptDAO dao = new DeptDAO();		
		
		String strPage = request.getParameter("p");
		int p=1;
		
		if(strPage != null && !strPage.isEmpty()) {
			p = Integer.parseInt(strPage);
		}
		Paging paging = new Paging();
		paging.setPage(p);
		paging.setPageUnit(5);
		paging.setPageSize(5);
		paging.setTotalRecord(dao.getCount(department_id));
		request.setAttribute("paging", paging);
		
		int start = paging.getFirst();
		int end = paging.getLast();
		
		List<DeptVO> deptList = dao.selectAll();
		
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/dept/deptList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
