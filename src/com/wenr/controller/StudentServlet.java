package com.wenr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wenr.dao.CourseDao;
import com.wenr.model.Course;
import com.wenr.dao.StudentDao;
import com.wenr.model.Student;

public class StudentServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public StudentServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 亲测这个东西要写在前面   否则不管用！！= =   中文乱码实在太恶心了……
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getParameter("action");
		String path = request.getContextPath();		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		
		if ("delete".equals(action)) {
			// 删除学生的某一门课程  如果出成绩则不可以删除  否则可以删除
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>学生登录</TITLE></HEAD>");
			out.println("  <BODY>");
			StudentDao studentDao = new StudentDao();
			Student student = (Student)session.getAttribute("student");
	    	int cid = Integer.parseInt(request.getParameter("cid"));
	    	if (studentDao.deleteCourse(student, cid)) {
	    		// 删除成功
	    		out.println("<h1>删除成功！</h1>");
	    	} else {
	    		// 删除失败
	    		out.println("<h1>删除失败，已出成绩课程不可以删除！</h1>");
	    	}
	    	out.println("<a href=\"" + path +  "/studentSelected.jsp\">返回</a>");
	    	out.println("  </BODY>");
			out.println("</HTML>"); 
		}
		
		else if ("lookup".equals(action)) {
			String courseName = "";
			if (request.getParameter("course") != null) {
				courseName = request.getParameter("course");
			}
			courseName = courseName.trim();
			ArrayList<Course> list = new ArrayList<>();
			CourseDao dao = new CourseDao();
			if ("".equals(courseName)) {
				list = dao.getAllCourse();
			} else {
				list = dao.getCourseByName(courseName);
			}
			request.setAttribute("courseList", list);
			request.setAttribute("course", courseName);
			// 这里本来想用response.sendRedirect(location); 蓝儿发现并不可以传递值
			// 请求转发就是到另一个页面去处理  所以这里就是请求转发比较合适（我猜……
			request.getRequestDispatcher("../studentSearchCourse.jsp").forward(request, response);
		}
		
		else if ("select".equals(action)) {
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>学生登录</TITLE></HEAD>");
			out.println("  <BODY>");    	
			int cid = Integer.parseInt(request.getParameter("cid"));
	  		Student student = (Student)session.getAttribute("student");
	  		StudentDao studentDao = new StudentDao();
	  		if (studentDao.addCourse(student, cid)) {
	  			// 如果此同学没有选过该门课 选课成功
	  			out.println("<h1>选课成功！</h1>");
	  		} else {
	  			// 选课失败
	  			out.println("<h1>选课失败，请勿重复选择！</h1>");
	  		}
	  		// 搜索到哪页  选课之后依然回到哪页 
	  		String param = "";
	  		if (request.getParameter("cutpage") != null) param = "&cutpage=" + request.getParameter("cutpage");
	  		out.println("<a href=\"" + path +  "/servlet/StudentServlet?action=lookup" + param + "\">返回</a>");
	  		out.println("  </BODY>");
			out.println("</HTML>"); 
		}
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
