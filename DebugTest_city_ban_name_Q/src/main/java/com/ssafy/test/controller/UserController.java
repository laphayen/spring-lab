package com.ssafy.test.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.ssafy.test.dto.User;
import com.ssafy.test.model.service.UserService;
import com.ssafy.test.model.service.UserServiceImpl;



@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		userService = UserServiceImpl.getInstance();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action == null) {
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			return;
		}
		
		try {
			switch (action) {
			case "goLoginPage":
				request.getRequestDispatcher("/user/loginUser.jsp").forward(request, response);
				break;
			case "goUpdatePage":
				User user = (User) request.getSession().getAttribute("userInfo");
				request.setAttribute("user", userService.detail(user.getId()));
				request.getRequestDispatcher("/user/updateUser.jsp").forward(request, response);
				break;
			case "goRegistPage":
				request.getRequestDispatcher("/user/registUser.jsp").forward(request, response);
				break;
			case "goDetailPage":
				detail(request, response);
				break;
			case "login":
				login(request, response);
				break;
			case "logout":
				logout(request, response);
				break;
			case "register":
				register(request, response);
				break;
			case "update":
				update(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/error/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}



	private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		User user = new User();
		user.setId(id);
		user.setPw(pw);

		User userInfo = userService.login(user);

		if(userInfo!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", userInfo);

			String remember = request.getParameter("remember");
			if(remember!=null) {
				Cookie cookie = new Cookie("savedId", id);
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(60 * 60 * 24 * 365);
				response.addCookie(cookie);
			}else {
				Cookie cookie = new Cookie("savedId", id);
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("msg", "로그인 실패");
			request.getRequestDispatcher("/user/loginUser.jsp").forward(request, response);
		}
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath());
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		User user = new User();
		user.setId(request.getParameter("id"));
		user.setPw(request.getParameter("pw"));
		user.setName(request.getParameter("name"));
		user.setBirthdate(request.getParameter("birthdate"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		
		int cnt =userService.register(user);
		
		if(cnt!=0) {
			response.sendRedirect(request.getContextPath() + "/user?action=goLoginPage");
		}else {
			request.setAttribute("msg", "회원가입에 실패하였습니다.다시 시도해주세요.");
			request.getRequestDispatcher("/user?action=goRegistPage");
		}
		
		
	}
	
	private void detail(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		User userInfo = (User) request.getSession().getAttribute("userInfo");
		User user = userService.detail(userInfo.getId());
		
		if(userInfo!=null) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("/user/detailUser.jsp").forward(request, response);			
		}else {			
			throw new NullPointerException();
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		User user = new User();
		user.setId(request.getParameter("id"));
		user.setPw(request.getParameter("pw"));
		user.setName(request.getParameter("name"));
		user.setBirthdate(request.getParameter("birthdate"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		
		int cnt =userService.update(user);
		
		if(cnt!=0) {
			response.sendRedirect(request.getContextPath()+"/user?action=goDetailPage");
		}else {
			request.setAttribute("msg", "회원 정보 수정에 실패하였습니다. 다시 시도해주세요.");
			request.getRequestDispatcher("/user?action=goUpdatePage");
		}
	}
}
