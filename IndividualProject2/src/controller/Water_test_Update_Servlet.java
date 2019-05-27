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

@WebServlet("/update.do")
public class Water_test_Update_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsg = new HashMap<String, String>();
		// 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
		// session物件來存放共用資料。
		HttpSession session = request.getSession();
		request.setAttribute("MsgMapU", errorMsg); // 顯示錯誤訊息
		// 接收使用者輸入的資料
		String name = request.getParameter("name");
		String observatory = request.getParameter("observatory");
		String testdate = request.getParameter("testdate");
		String level = request.getParameter("level");
		String rpi = request.getParameter("rpi");
		String Do = request.getParameter("Do");
		String ammonia = request.getParameter("ammonia");
		String ss = request.getParameter("ss");
		// 驗證使用者輸入資料的格式正確
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = true;
		boolean flag4 = true;
		boolean flag5 = true;
		if (name == null || name.trim().length() == 0) {
			flag1 = false;
			errorMsg.put("errorName", "河川名欄必須輸入");
		}
		if (observatory == null || observatory.trim().length() == 0) {
			flag2 = false;
			errorMsg.put("errorObservatory", "觀測站欄必須輸入");
		}
		if (testdate == null || testdate.trim().length() == 0) {
			flag3 = false;
			errorMsg.put("errorTestdate", "觀測時間欄必須輸入");
		}
		if (level == null || level.trim().length() == 0) {
			flag4 = false;
			errorMsg.put("errorLevel", "汙染程度欄必須輸入");
		}
		double dRPI = -1;
		if (rpi != null && rpi.trim().length() > 0) {
			try {
				dRPI = Double.parseDouble(rpi.trim());
			} catch (NumberFormatException e) {
				errorMsg.put("errorRpi", "汙染等級欄必須為數值");
			}
		}
		double dDO = -1;
		if (Do != null && Do.trim().length() > 0) {
			try {
				dDO = Double.parseDouble(Do.trim());
			} catch (NumberFormatException e) {
				errorMsg.put("errorDo", "溶氧量欄必須為數值");
			}
		}
		if (ammonia == null || ammonia.trim().length() == 0) {
			flag5 = false;
			errorMsg.put("errorAmmonia", "含氨量欄必須輸入");
		}
		double dSS = -1;
		if (ss != null && ss.trim().length() > 0) {
			try {
				dSS = Double.parseDouble(ss.trim());
			} catch (NumberFormatException e) {
				errorMsg.put("errorSS", "懸浮粒子欄必須為數值");
			}
		}
		// 進行 更新功能
		Water_testService is = new Water_testService();
		try {
			if (flag1 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true) {
				Water_testBean wt = new Water_testBean(name, observatory, testdate, level, rpi, Do, ammonia, ss);
				is.update(wt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 挑選適當的網頁
		request.setAttribute("userIdKey", observatory);
		request.setAttribute("userIdKey3", "修改");
		if (errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
			rd.forward(request, response);
			return;
		} else {
			// 導向原來輸入資料的畫面，並顯示錯誤訊息
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
