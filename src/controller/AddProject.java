package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProjectDao;
import model.Project;

/**
 * Servlet implementation class AddProject
 */
@WebServlet("/addProject")
public class AddProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Getting into add project");
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addProject.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String projectName= request.getParameter("projectName");
		String projectManager = request.getParameter("managerName");
		String budget = request.getParameter("budget");
		String status = request.getParameter("status");
		
		System.out.println(projectName+" "+projectManager+" "+budget+" "+status);
		
		Project project = new Project();
		project.setProjectName(projectName);
		project.setProjectManager(projectManager);
		project.setBudget(budget);
		project.setStatus(status);
		
		ProjectDao projectDao=new ProjectDao();
		
		projectDao.insertProject(project);
		response.sendRedirect("allProjects");
		
		
	}

}
