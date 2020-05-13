package co.yedam.app.dept.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.dept.model.DeptDAO;
import co.yedam.app.dept.model.DeptVO;

@WebServlet("/DeptInsert.do")
public class DeptInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeptInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/dept/deptInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); // 한글 출력되도록
		request.setCharacterEncoding("utf-8"); // GET방식은 setCharacterEncoding 할 필요없음
		
		String department_id = request.getParameter("department_id");
		String department_name = request.getParameter("department_name");
		String manager_id = request.getParameter("manager_id");
		String location_id = request.getParameter("location_id");
		
		DeptDAO dao = new DeptDAO();
		DeptVO vo = new DeptVO();
		
		vo.setDepartment_id(department_id);
		vo.setDepartment_name(department_name);
		vo.setLocation_id(location_id);
		vo.setManager_id(manager_id);
		
		dao.deptInsert(vo);
		
		
		String contextPath = getServletContext().getContextPath();
		response.sendRedirect(contextPath + "/DeptList.do");
		
	}

}
