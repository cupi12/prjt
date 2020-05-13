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
       
    public DeptUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String department_id = (String)request.getSession().getAttribute("department_id");
		
		String department_name = (String)request.getSession().getAttribute("department_name");
		String manager_id = (String)request.getSession().getAttribute("manager_id");
		String location_id = (String)request.getSession().getAttribute("location_id");
//		if(department_id == null) {
//			response.sendRedirect(request.getContextPath() + "/DeptList.do");
//			return;
//		}
		DeptDAO dao = new DeptDAO();
		DeptVO vo = new DeptVO();
		
		
		request.setAttribute("dept", vo);
		request.getRequestDispatcher("dept/deptUpdate.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
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
		dao.deptUpdate(vo);
		
		String contextPath = getServletContext().getContextPath();
		response.sendRedirect(contextPath + "/DeptList.do");
		
		
	}

}
