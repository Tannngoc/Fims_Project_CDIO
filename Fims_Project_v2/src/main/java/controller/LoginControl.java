package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

import java.io.IOException;

import database.AccountDAO;

/**
 * Servlet implementation class LoginControl
 */
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=UTF-8");
        String username  = request.getParameter("username");
        String password = request.getParameter("password");
        

        Account ac = new Account();
        ac.setUsername(username);
        ac.setPassword(password);
        
        AccountDAO acd = new AccountDAO();
        Account account = acd.selectByUsernameAndPassWord(ac);
        if(account != null) {
            HttpSession session = request.getSession();
            request.getSession().setAttribute("auth", account);
            int role_id = account.getRole();
            int acc_id = account.getId();
            session.setAttribute("role_id", role_id);
            Cookie roleCookie = new Cookie("role_id", String.valueOf(role_id));
            Cookie accCookie = new Cookie("acc_id", String.valueOf(acc_id));
            roleCookie.setMaxAge(3600); // Thời gian sống của cookie, tính theo giây (ở đây là 1 giờ)
            response.addCookie(roleCookie);
            response.addCookie(accCookie);
            if(role_id == 1) {
            	request.getRequestDispatcher("GUI/admin.jsp").forward(request, response);
            } else if(role_id == 2) {
            	response.sendRedirect("GUI/index.jsp");
            }
        } else {
            // Hiển thị dòng báo lỗi chỉ khi đăng nhập sai
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                request.setAttribute("baoLoi", "Username or password incorrect!");
            }
            request.getRequestDispatcher("GUI/sign-in.jsp").forward(request, response);
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
