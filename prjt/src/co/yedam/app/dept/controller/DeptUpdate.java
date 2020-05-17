package co.yedam.app.dept.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.dept.model.DeptDAO;
import co.yedam.app.dept.model.DeptVO;

@WebServlet("/DeptUpdate.do")
public class DeptUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String department_name = (String)request.getAttribute("department_name");
//		String manager_id = (String)request.getAttribute("manager_id");
//		String location_id = (String)request.getAttribute("location_id");
//		if(department_id == null) {
//			response.sendRedirect(request.getContextPath() + "/DeptList.do");
//			return;
//		}
		int seq = (Integer.parseInt(request.getParameter("seq")));
		if(seq== 0) {
			response.sendRedirect(request.getContextPath()+"/DeptUpdate.do");
		}
		String department_id = Integer.toString(seq);		
		
		
		DeptDAO dao = new DeptDAO();
		DeptVO vo = dao.getDept(department_id);
		
//		vo.setDepartment_id(department_id);
		request.setAttribute("vo", dao.getDept(department_id));
		request.getRequestDispatcher("dept/deptUpdate.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		
		
		DeptDAO dao = new DeptDAO();
		DeptVO vo = new DeptVO();
		
		dao.deptUpdate(vo);
		
		String contextPath = getServletContext().getContextPath();
		response.sendRedirect(contextPath + "/DeptList.do");
		
		
	}

}
