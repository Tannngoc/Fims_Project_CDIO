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
 * Servlet implementation class SearchControl
 */
public class SearchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String txtSearch = request.getParameter("txt");
		ProductDAO pd = new ProductDAO();
		ProductImageDAO pid = new ProductImageDAO();
		ArrayList<Product> list = pd.selectAllByName(txtSearch);
		ArrayList<ProductImage> listI = pid.selectAllByName(txtSearch);
		request.setAttribute("listP", list);
		request.setAttribute("listI", listI);
		request.setAttribute("txtV", txtSearch);
		request.getRequestDispatcher("GUI/list-product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
