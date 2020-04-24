package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Project;
import utility.ConnectionManager;

public class ProjectDao {
	private static final String SELECT_ALL_PROJECTS = "SELECT * FROM PROJECT";
	private static final String SELECT_PROJECT_BY_ID = "select * from project where project_id=?";
	private static final String DELETE_PROJECT_BY_ID = "delete from project where PROJECT_ID=?";
	private static final String ADD_PROJECT = "INSERT INTO PROJECT VALUES (hr_seq.nextval,?,?,?,?)";
	private static final String UPDATE_PROJECT_BY_ID = "update project set project_name=?,project_manager=?,budget=?,status=? where project_id=?";
	
	public List<Project> selectAllProjects() throws ClassNotFoundException, IOException, SQLException{
		Project project = null;
		List<Project> projectsList = new ArrayList<Project>();
		System.out.println("List all projects");
		try 
			(Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL_PROJECTS);){
		//	System.out.println(ps); // executing upto here
			
			ResultSet rs= ps.executeQuery();	
			while(rs.next()){
				System.out.println("getting into loop");
				int projectId = rs.getInt("project_id");
				String projectName = rs.getString("project_name");
				String projectManager = rs.getString("PROJECT_MANAGER");
				String budget = rs.getString(4);
				String status = rs.getString(5);
				project = new Project();
				project.setProjectId(projectId);
				project.setProjectName(projectName);
				project.setProjectManager(projectManager);
				project.setBudget(budget);
				project.setStatus(status);
				
				projectsList.add(project);
				
				
			}
		}
			catch (Exception e) {
				System.out.println(e);
			}
			
		System.out.println("Projects List Returned");
		return projectsList;
		
		
	}
	
	public List<Project> selectProjectById(int id) {
		Project project = null;
		List<Project> projectsList = new ArrayList<Project>();
		Connection conn = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_PROJECT_BY_ID);
			System.out.println("Insider id = "+id);
			ps.setInt(1, id);
//			System.out.println(SELECT_PROJECT_BY_ID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int projectId = rs.getInt(1);
				String projectName = rs.getString("project_name");
				String projectManager = rs.getString("PROJECT_MANAGER");
				String budget = rs.getString(4);
				String status = rs.getString(5);
				
				project = new Project();
				project.setProjectId(projectId);
				project.setProjectName(projectName);
				project.setProjectManager(projectManager);
				project.setBudget(budget);
				project.setStatus(status);
				projectsList.add(project);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return projectsList;
		
	}
	
	public boolean deleteProject(int id) {
		System.out.println(id);
		boolean rowDeleted = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(DELETE_PROJECT_BY_ID);
			ps.setInt(1, id);
			System.out.println(ps);
			rowDeleted = ps.executeUpdate() > 0;
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return rowDeleted;
	}
	
	public void insertProject(Project project) {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(ADD_PROJECT);
			System.out.println(project.getProjectName());
			ps.setString(1, project.getProjectName());
			ps.setString(2, project.getProjectManager());
//			ps.setDate(3, java.sql.Date.valueOf(blog.getPostedOn()));
			ps.setString(3, project.getBudget());
			ps.setString(4, project.getStatus());
			System.out.println(ps);
			ps.executeUpdate();
			ConnectionManager.getConnection().commit();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void updateProject(int id) {
		
	}

}
