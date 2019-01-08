package com.wenr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wenr.model.Course;
import com.wenr.util.DBUtil;

public class CourseDao {
	
	public ArrayList<Course> getAllCourse() {
		
		ArrayList<Course> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from course";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				Course course = new Course();
				course.setCid(rs.getInt(1));
				course.setCname(rs.getString(2));
				course.setCredit(rs.getInt(3));
				list.add(course);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	// 通过课程名查询    模糊查询
	public ArrayList<Course> getCourseByName(String cname) {
		
		ArrayList<Course> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from course where cname like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+cname+"%");
			rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				Course course = new Course();
				course.setCid(rs.getInt(1));
				course.setCname(rs.getString(2));
				course.setCredit(rs.getInt(3));
				list.add(course);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	public Course getCourseById(int cid) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from course where cid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				Course course = new Course();
				course.setCid(rs.getInt(1));
				course.setCname(rs.getString(2));
				course.setCredit(rs.getInt(3));
				return course;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
	
	public void addCourse(Course course) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into course(cname, credit) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, course.getCname());
			pstmt.setInt(2, course.getCredit());
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void updateCourse(Course course) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "update course set cname=?,credit=? where cid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, course.getCname());
			pstmt.setInt(2, course.getCredit());
			pstmt.setInt(3, course.getCid());
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void deleteCourseById(int cid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from course where cid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
