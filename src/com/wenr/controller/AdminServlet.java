package com.wenr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wenr.dao.CourseDao;
import com.wenr.dao.StudentDao;
import com.wenr.model.Course;
import com.wenr.model.Student;

public class AdminServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AdminServlet() {
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
		doPost(request,response);
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getParameter("action");
		String path = request.getContextPath();		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		CourseDao courseDao = new CourseDao();
		
		if ("delete".equals(action)) {
			// 删除课程
			courseDao.deleteCourseById(Integer.parseInt(request.getParameter("cid")));
	  		response.sendRedirect("../adminSearchCourse.jsp");
		} else if ("update".equals(action)) {
			// 更新课程
			Course course = new Course();
			course.setCid(Integer.parseInt(request.getParameter("cid")));
			course.setCname(request.getParameter("cname"));
			course.setCredit(Integer.parseInt(request.getParameter("credit")));
			courseDao.updateCourse(course);
	  		response.sendRedirect("../adminSearchCourse.jsp");
		} else if ("addStudent".equals(action)) {
			Student student = new Student();
			StudentDao studentDao = new StudentDao();
		  	student.setSpwd(request.getParameter("spwd"));
		  	student.setSname(request.getParameter("sname"));
			studentDao.addStudent(student);
			response.sendRedirect("../adminAddStudent.jsp"); 
		} else if ("addCourse".equals(action)) {
			Course course = new Course();
			course.setCredit(Integer.parseInt(request.getParameter("credit")));
		  	course.setCname(request.getParameter("cname"));
			courseDao.addCourse(course);
			response.sendRedirect("../adminAddCourse.jsp");
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
