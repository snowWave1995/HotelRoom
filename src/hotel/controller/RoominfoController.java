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

import hotel.dao.GuestDAO;
import hotel.dao.RoomDAO;
import hotel.dao.WaiterDAO;
import hotel.model.Guest;
import hotel.model.Room;

/**
 * Servlet implementation class RoominfoController
 */
@WebServlet("/roominfo")
public class RoominfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RoominfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			RoomDAO dao = new RoomDAO();
			WaiterDAO dao1=new WaiterDAO();
			List<Map<String, Object>> rooms = dao.getAllRoom();
			List<Map<String, Object>> waiters=dao1.getAllWaiter();
			RequestDispatcher rd =
	                request.getRequestDispatcher("/roominfo.jsp");
			request.setAttribute("rooms", rooms);
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
			Room room = new Room();
			String rno = (String) request.getParameter("Rno");
			String rtype = (String) request.getParameter("Rtype");
			String rprice = (String) request.getParameter("Rprice");
			String rfloor = (String) request.getParameter("Rfloor");
			String rdri = (String) request.getParameter("Rdri");
			String rsno = (String) request.getParameter("RSno");
			room.setRno(rno);
			room.setRtype(rtype);
			room.setRprice(rprice);
			room.setRfloor(rfloor);
			room.setRdri(rdri);
			room.setRsno(rsno);
			
			
			RoomDAO dao;
			try {
				dao = new RoomDAO();
				dao.addRoom(room);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(method.equals("delete"))
		{
			Room room=new Room();
			String rno=(String)request.getParameter("Rno");
			room.setRno(rno);
			RoomDAO dao;
			try{
				dao=new RoomDAO();
				dao.deleteRoom(room);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}else if(method.equals("updata"))
		{
			Room room=new Room();
			String rno=(String)request.getParameter("Rno");
			String rtype=(String) request.getParameter("Rtype");
			String rprice=(String) request.getParameter("Rprice");
			String rsno=(String) request.getParameter("RSno");
			room.setRno(rno);
			room.setRtype(rtype);
			room.setRprice(rprice);
			room.setRsno(rsno);
			RoomDAO dao;
			try{
				dao=new RoomDAO();
				dao.updataRoom(room);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		String site = new String("http://localhost:8080/hotelRoom/roominfo");
	    response.setStatus(response.SC_MOVED_TEMPORARILY);
	    response.setHeader("Location", site);
		
		
		doGet(request, response);
	}

}
