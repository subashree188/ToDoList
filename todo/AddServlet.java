import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/mysql";


		String USER = "subashree";
		String PASS = "eightdav";


		PrintWriter out = response.getWriter();
		String item = request.getParameter("todoItem"); //name attribute of input tag
		
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO ToDo VALUES(?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, item);

			pst.executeUpdate();
			pst.close();
			conn.close();
			
			out.println("<B>"+item+" Added Successfully!</B><br>");

			//RequestDispatcher rd = request.getRequestDispatcher("/todo.html");
			//rd.forward(request, response);
			
		} catch (SQLException sql) {
			sql.printStackTrace();
			out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
			out.println(e);
		}
	}
}
