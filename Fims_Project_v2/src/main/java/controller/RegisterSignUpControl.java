package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;
import model.Customer;

import java.io.IOException;
import java.util.ArrayList;

import database.AccountDAO;
import database.CustomerDAO;

/**
 * Servlet implementation class RegisterSignUpControl
 */
public class RegisterSignUpControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterSignUpControl() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String username = request.getParameter("user_name");
        String password = request.getParameter("password");
        String repassword = request.getParameter("re-password");
        String email = request.getParameter("email");
        String dongYDieuKhoan = request.getParameter("dongYDieuKhoan");
        String error = "";
        
        AccountDAO accountDAO = new AccountDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        
        if(accountDAO.checkLogin(username)) {
            error = "Username was existed! Please re-input!";
        }
        
        if(password == null || !password.equals(repassword)) {
            error = "Password is not match";
        }
        
        request.setAttribute("error", error );
        
        if(error.length() > 0) {
            request.getRequestDispatcher("GUI/register.jsp").forward(request, response);
        } else {
            AccountDAO ad = new AccountDAO();
            ArrayList<Account> accs = ad.selectAll();
            int stt = accs.size() + 1;
            Account ac = new Account(stt, username, password, null, 1, null, null);
            int id_ac = ac.getId();
            Customer cu = new Customer(0, username, false, null, null, email, 0, null, null,id_ac);
            
            accountDAO.insert(ac);
            customerDAO.insert(cu);
            
            // Điều hướng đến trang đăng nhập
            response.sendRedirect("sign-in");
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
