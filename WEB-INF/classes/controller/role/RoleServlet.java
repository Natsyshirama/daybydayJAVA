package controller.role;

import model.role.Role;
import model.role.RoleDAO;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


public class RoleServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 try {   
	RoleDAO dao = new RoleDAO();
	
	List<Role> roles =dao.getRole();
	request.setAttribute("roles",roles);
	request.getRequestDispatcher("/role/role.jsp").forward(request, response);
}catch (Exception e) {
              e.printStackTrace();
              request.setAttribute("message", "Erreur lors recuperation valeur: " + e.getMessage());
              request.getRequestDispatcher("/role/role.jsp").forward(request, response);
        }
	}
}