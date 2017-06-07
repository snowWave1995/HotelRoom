package hotel.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.dao.RoomDAO;
import hotel.dao.WaiterDAO;
import hotel.model.Room;
import hotel.model.Waiter;

/**
 * Servlet implementation class WaiterController
 */
@WebServlet("/waiter")
public class WaiterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WaiterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			WaiterDAO dao = new WaiterDAO();
			List<Map<String, Object>> waiters = dao.getAllWaiter();

			RequestDispatcher rd =
	                request.getRequestDispatcher("/waiter.jsp");
			request.setAttribute("waiters", waiters);
	        rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("type");
		
		if(method.equals("add")){
			Waiter waiter = new Waiter();
			
			String wno = (String) request.getParameter("Wno");
			String wname=(String) request.getParameter("Wname");
			String wsex=(String) request.getParameter("Wsex");
			String wtel=(String) request.getParameter("Wtel");
			
			waiter.setWno(wno);
			waiter.setWname(wname);
			waiter.setWsex(wsex);
			waiter.setWtel(wtel);
			
			WaiterDAO dao;
			try {
				dao = new WaiterDAO();
				dao.addWaiter(waiter);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		    
		}
		else if(method.equals("delete"))
		{
			Waiter waiter = new Waiter();
			
			String wno=(String) request.getParameter("Wno");
			waiter.setWno(wno);
			
			WaiterDAO dao;
			try{
				dao =new WaiterDAO();
				dao.deleteWaiter(waiter);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}else if(method.equals("updata")){
			Waiter waiter = new Waiter();
			
			String wno=(String) request.getParameter("Wno");
			String wtel=(String) request.getParameter("Wtel");
			
			waiter.setWno(wno);
			waiter.setWtel(wtel);
			
			WaiterDAO dao;
			try{
				dao=new WaiterDAO();
				dao.updataWaiter(waiter);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		  // 要重定向的新位置
	    String site = new String("http://localhost:8080/hotelRoom/waiter");
	    response.setStatus(response.SC_MOVED_TEMPORARILY);
	    response.setHeader("Location", site);    
		
		doGet(request, response);
	}
}


