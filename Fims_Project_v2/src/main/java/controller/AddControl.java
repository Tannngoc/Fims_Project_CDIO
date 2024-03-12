package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductImage;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import database.ProductDAO;
import database.ProductImageDAO;

/**
 * Servlet implementation class AddControl
 */
public class AddControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String quantityString = request.getParameter("quantity");
        String priceString = request.getParameter("price");
        String description = request.getParameter("description");
        String modelString = request.getParameter("model");
        int quantity = Integer.parseInt(quantityString);
        int price = Integer.parseInt(priceString);
        int model = Integer.parseInt(modelString);
        
        ProductDAO pd = new ProductDAO();
        ProductImageDAO pid = new ProductImageDAO();
        
        // Tạo một danh sách các sản phẩm hiện có
        ArrayList<Product> listP = pd.selectAll();
        
        // Tạo một danh sách các hình ảnh sản phẩm hiện có
        ArrayList<ProductImage> listI = pid.selectAll();
        
        // Tạo một đối tượng Product mới với ID tự động tăng và các thông tin khác
        Product p = new Product(listP.size() + 1, name, null, null, null, 0, 0, null, 0, 0, null, null, 0, description, quantity, price, null, null, 1, model, 1);
        // Tạo một đối tượng ProductImage mới với ID tự động tăng, ID sản phẩm liên kết và URL hình ảnh
        ProductImage pi = new ProductImage(listI.size() + 1, p.getId(), p.getCompany_id(), image);
        // Chèn đối tượng Product mới vào cơ sở dữ liệu
        pd.insert(p);
        // Chèn đối tượng ProductImage mới vào cơ sở dữ liệu
        pid.insert(pi);
        // Chuyển hướng người dùng đến trang quản lý sản phẩm
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
