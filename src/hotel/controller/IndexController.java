package hotel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.dao.GuestDAO;
import hotel.dao.RoomDAO;
import hotel.model.Guest;
import hotel.model.Room;
import hotel.util.DB;


@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			RoomDAO dao = new RoomDAO();
			GuestDAO dao1=new GuestDAO();
			List<Map<String, Object>> rooms = dao.getEmptyRoom_singal();
			List<Map<String, Object>> rooms1 = dao.getEmptyRoom_standard();
			List<Map<String, Object>> rooms2 = dao.getEmptyRoom_triple();
			List<Map<String, Object>> guests=dao1.getAllGuest();
			RequestDispatcher rd =
	                request.getRequestDispatcher("/index.jsp");
			request.setAttribute("rooms", rooms);
			request.setAttribute("rooms1", rooms1);
			request.setAttribute("rooms2", rooms2);
			request.setAttribute("guests",guests);
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
		if(method.equals("reserve")){
			Room room = new Room();
			
			String rno = (String) request.getParameter("Rno");
			String gno=(String) request.getParameter("Gno");
			String rin=(String) request.getParameter("Rin");
			String rout=(String) request.getParameter("Rout");
			room.setRno(rno);
			room.setGno(gno);
			room.setRin(rin);
			room.setRout(rout);
			
			RoomDAO dao;
			try {
				dao = new RoomDAO();
				dao.reserveRoom(room);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		String site = new String("http://localhost:8080/hotelRoom/checkout");
	    response.setStatus(response.SC_MOVED_TEMPORARILY);
	    response.setHeader("Location", site);
		
		
		
		doGet(request, response);
	}

}
