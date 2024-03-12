package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Product;
import model.ProductImage;

import java.io.IOException;
import java.util.ArrayList;

import database.ProductDAO;
import database.ProductImageDAO;

/**
 * Servlet implementation class ListProductControl
 */
public class ListProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		ProductDAO pd = new ProductDAO();
		ProductImageDAO pid = new ProductImageDAO();
		ArrayList<Product> listP = pd.selectAll();
		ArrayList<ProductImage> listI = pid.selectAll();
		request.setAttribute("listP", listP);
		request.setAttribute("listI", listI);
		request.getRequestDispatcher("/GUI/list-product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
