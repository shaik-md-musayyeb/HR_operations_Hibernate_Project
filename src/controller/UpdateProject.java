package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProjectDao;
import model.Project;

/**
 * Servlet implementation class UpdateProject
 */
@WebServlet("/updateProject")
public class UpdateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id+" record would be selected");
		
		List<Project> projectAsList = new ArrayList<>();
		ProjectDao projectDao = new ProjectDao();
		projectAsList = projectDao.selectProjectById(id);
	
//
		for(Project p : projectAsList){
			System.out.println("Inside for loop "+p.getProjectManager()+" "+p.getProjectId()+" "+p.getProjectName());
		}
		request.setAttribute("project", projectAsList);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/projectUpdate.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("project updation, modification");
		System.out.println(request.getParameter("id")+" would be updated");
		response.sendRedirect("allProjects");
	}

}
