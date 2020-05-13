package co.yedam.app.dept.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.dept.model.DeptDAO;
import co.yedam.app.dept.model.DeptVO;

/**
 * Servlet implementation class DeptList
 */
@WebServlet("/DeptList.do")
public class DeptList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeptList() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptDAO dao = new DeptDAO();
		List<DeptVO> deptList = dao.selectAll();
		
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/dept/deptList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
