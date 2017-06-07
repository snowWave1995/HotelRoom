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
import hotel.model.Guest;
import hotel.util.DB;


/**
 * Servlet implementation class GuestController
 */
@WebServlet("/guest")
public class GuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			GuestDAO dao = new GuestDAO();
			List<Map<String, Object>> guests = dao.getAllGuest();

			RequestDispatcher rd =
	                request.getRequestDispatcher("/guest.jsp");
			request.setAttribute("guests", guests);
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
		if(method.equals("add")){
			Guest guest = new Guest();
			
			String gno = (String) request.getParameter("Gno");
			String gname = (String) request.getParameter("Gname");
			String gsex = (String) request.getParameter("Gsex");
			String gtel = (String) request.getParameter("Gtel");
			String gid = (String) request.getParameter("Gid");
			String gaddress = (String) request.getParameter("Gaddress");
			guest.setGno(gno);
			guest.setGname(gname);
			guest.setGsex(gsex);
			guest.setGtel(gtel);
			guest.setGid(gid);
			guest.setGaddress(gaddress);
			
			
			
			GuestDAO dao;
			try {
				dao = new GuestDAO();
				dao.addGuest(guest);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(method.equals("delete")){
			Guest guest=new Guest();
			String gno=(String) request.getParameter("Gno");
			guest.setGno(gno);
			
			GuestDAO dao;
			try{
				dao=new GuestDAO();
				dao.deleteGuest(guest);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(method.equals("updata")){
			Guest guest =new Guest();
			String gno=(String) request.getParameter("Gno");
			String gtel=(String) request.getParameter("Gtel");
			guest.setGno(gno);
			guest.setGtel(gtel);
			
			GuestDAO dao;
			try{
				dao=new GuestDAO();
				dao.updataGuest(guest);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		String site = new String("http://localhost:8080/hotelRoom/guest");
	    response.setStatus(response.SC_MOVED_TEMPORARILY);
	    response.setHeader("Location", site);
		
		doGet(request, response);
	}

}
