package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Water_testBean;
import service.Water_testService;

@WebServlet("/findByObv.do")
public class Water_test_findByObv_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsg = new HashMap<String, String>();
		// 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
		// session物件來存放共用資料。
		HttpSession session = request.getSession();
		request.setAttribute("MsgMapF", errorMsg); // 顯示錯誤訊息
		// 接收使用者輸入的資料
		String observatory = request.getParameter("observatory");
		// 驗證使用者輸入資料的格式正確
		boolean flag1 = true;
		if (observatory == null || observatory.trim().length() == 0) {
			flag1 = false;
			errorMsg.put("errorObservatory", "觀測站欄必須輸入");
		}
		// 進行 查詢功能
		Water_testService is = new Water_testService();
		if (flag1 == true) {
			try {
				Water_testBean obvBean = is.findByObservatory(observatory);
				request.setAttribute("findbyObvKey", obvBean);
				RequestDispatcher rd = request.getRequestDispatcher("Find.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else {
			// 導向原來輸入資料的畫面，並顯示錯誤訊息
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
			
		}

	}
}
