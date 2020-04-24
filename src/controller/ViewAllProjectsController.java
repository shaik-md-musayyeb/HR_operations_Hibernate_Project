package controller;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class ViewAllProjectsController
 */
@WebServlet("/allProjects")
public class ViewAllProjectsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ViewAllProjectsController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Getting all projcts");
		ProjectDao projectDao = new ProjectDao();
		List<Project> allProjects = new ArrayList<>();
		try {
			allProjects = projectDao.selectAllProjects();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Project project : allProjects) {
			System.out.println(project.getProjectName());
		}
		request.setAttribute("allProjects", allProjects);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/projectsView.jsp");
		rd.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
