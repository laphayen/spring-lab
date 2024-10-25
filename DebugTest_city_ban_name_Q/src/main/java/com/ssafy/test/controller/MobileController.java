package com.ssafy.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.ssafy.test.dto.Mobile;
import com.ssafy.test.dto.User;
import com.ssafy.test.model.service.MobileService;
import com.ssafy.test.model.service.MobileServiceImpl;

@WebServlet(urlPatterns = { "", "/mobile" })
public class MobileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MobileService mobileService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		mobileService = MobileServiceImpl.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		

		if (action == null) {
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			return;
		}
		
		try {
			switch (action) {
			case "goRegistPage":
				request.getRequestDispatcher("/mobile/registMobile.jsp").forward(request, response);
				break;
			case "goUpdatePage":
				goUpdatePage(request, response);
				break;
			case "list":
				list(request, response);
				break;
			case "detail":
				detail(request, response);
				break;
			case "regist":
				regist(request, response);
				break;
			case "update":
				update(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			default:
				response.sendRedirect(request.getContextPath());
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "무언가 잘 못 되었습니다.");
			request.getRequestDispatcher("/error/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

	private void detail(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String code = request.getParameter("code");

		Mobile mobile = mobileService.selectByCode(code);
		if (mobile == null || mobile.getCode() == null || mobile.getCompany() == null || mobile.getModel() == null) {
			request.setAttribute("msg", "상세 정보 불러오기에 실패하였습니다.");
			request.getRequestDispatcher("/error/error.jsp").forward(request, response);
		} else {
			request.setAttribute("mobile", mobile);
			request.getRequestDispatcher("/mobile/detailMobile.jsp").forward(request, response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		List<Mobile> mobileList = mobileService.selectAll();
		if (mobileList != null && mobileList.size() != 0) {
			request.setAttribute("mobileList", mobileList);
			request.getRequestDispatcher("/mobile/listMobile.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "핸드폰 목록 조회에 실패하였습니다.");
			request.getRequestDispatcher("/error/error.jsp").forward(request, response);
		}

	}

	private void regist(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {
		User user = (User) request.getSession().getAttribute("userInfo");
		String code = request.getParameter("code");
		String model = request.getParameter("model");
		int price = Integer.parseInt(request.getParameter("price"));
		String company = request.getParameter("company");
		Mobile mobile = new Mobile();
		mobile.setCode(code);
		mobile.setModel(model);
		mobile.setPrice(price);
		mobile.setCompany(company);
		mobile.setUserId(user.getId());

		int cnt = mobileService.insert(mobile);

		if (cnt == 1) {
			response.sendRedirect(request.getContextPath() + "/mobile?action=list");
		} else {
			response.sendRedirect(request.getContextPath() + "/mobile?action=goRegistPage");
		}
	}

	private void goUpdatePage(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String code = request.getParameter("code");
		Mobile mobile = mobileService.selectByCode(code);
		if (validateUser(request, response)) {
			if (mobile != null) {
				request.setAttribute("mobile", mobile);
				request.getRequestDispatcher("/mobile/updateMobile.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "핸드폰 정보 불러오기 실패");
				request.getRequestDispatcher("/mobile?action=list").forward(request, response);
			}
		} else {
			request.setAttribute("msg", "동록한 사용자만 수정할 수 있습니다.");
			request.getRequestDispatcher("/mobile?action=list").forward(request, response);
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String code = request.getParameter("code");
		String model = request.getParameter("model");
		int price = Integer.parseInt(request.getParameter("price"));
		String company = request.getParameter("company");

		Mobile mobile = new Mobile();
		mobile.setCode(code);
		mobile.setModel(model);
		mobile.setPrice(price);
		mobile.setCompany(company);

		int cnt = mobileService.update(mobile);

		if (cnt == 1) {
			response.sendRedirect(request.getContextPath() + "/mobile?action=list");
		} else {
			request.setAttribute("msg", "핸드폰 수정 실패");
			request.getRequestDispatcher("/mobile?action=list").forward(request, response);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String code = request.getParameter("code");
		if (validateUser(request, response)) {
			int cnt = mobileService.delete(code);
			if (cnt == 1)
				request.setAttribute("msg", "핸드폰 정보 삭제 성공");
			else
				request.setAttribute("msg", "핸드폰 정보 삭제 실패");
			request.getRequestDispatcher("/mobile?action=list").forward(request, response);
		} else {
			request.setAttribute("msg", "등록한 사용자만 삭제할 수 있습니다.");
			request.getRequestDispatcher("/mobile?action=list").forward(request, response);
		}

	}

	private boolean validateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		User loginUser = (User) request.getSession().getAttribute("userInfo");
		Mobile mobile = mobileService.selectByCode(request.getParameter("code"));
		if (loginUser != null && loginUser.getId().equals(mobile.getUserId()))
			return true;
		return false;
	}

}
