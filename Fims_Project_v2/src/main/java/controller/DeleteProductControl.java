package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductImage;

import java.io.IOException;
import java.util.ArrayList;

import database.ProductDAO;
import database.ProductImageDAO;

/**
 * Servlet implementation class DeleteProductControl
 */
public class DeleteProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String pid = request.getParameter("pid");
		int productId = Integer.parseInt(pid);
		ProductDAO pd = new ProductDAO();
		Product p = new Product();
		ProductImageDAO imaged = new ProductImageDAO();
		ProductImage pi = new ProductImage();
		p.setId(productId);
		pi.setId(productId);
		pd.delete(p);
		imaged.delete(pi);
		request.getRequestDispatcher("manageProduct").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
