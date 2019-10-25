package Online1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import Online.ConnectionManager;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update.do")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("lib");

		MongoCollection<Document> collection = db.getCollection("online");

	}

	/**
	 * @ see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("lib");

		MongoCollection<Document> collection = db.getCollection("online");

		String nametoup = request.getParameter("update");
		String newname = request.getParameter("nname");
		String newauthor = request.getParameter("author");
		String newprice = request.getParameter("price");
		collection.updateOne(Filters.eq("bname", nametoup), Updates.combine(Updates.set("bname", newname),
				Updates.set("aname", newauthor), Updates.set("price", newprice)));
		response.sendRedirect("update.jsp");
	}

}
