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
import hotel.model.Room;

/**
 * Servlet implementation class CheckoutController
 */
@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			RoomDAO dao = new RoomDAO();
			List<Map<String, Object>> rooms = dao.getNotEmptyRoom();

			RequestDispatcher rd =
	                request.getRequestDispatcher("/checkout.jsp");
			request.setAttribute("rooms", rooms);
	        rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("type");
		if(method.equals("checkout")){
			Room room = new Room();
			
			String rno = (String) request.getParameter("Rno");
			
			room.setRno(rno);
			
			
			RoomDAO dao;
			try {
				dao = new RoomDAO();
				dao.checkoutRoom(room);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		String site = new String("http://localhost:8080/hotelRoom/index");
	    response.setStatus(response.SC_MOVED_TEMPORARILY);
	    response.setHeader("Location", site);
		
		doGet(request, response);
	}

}
