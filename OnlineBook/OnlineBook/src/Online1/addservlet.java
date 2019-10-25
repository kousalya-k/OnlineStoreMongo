package Online1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import Online.Book;
import Online.ConnectionManager;

/**
 * Servlet implementation class addservlet
 */
@WebServlet("/addservlet.do")
public class addservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   List<Book>dataList=new ArrayList<Book>();
	    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("lib");

		MongoCollection<Document> collection = db.getCollection("online");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("lib");

		MongoCollection<Document> collection = db.getCollection("online");

		String bname = request.getParameter("bname");
		String aname = request.getParameter("aname");
		String price = request.getParameter("price");
		Document document = new Document("bname", bname).append("aname", aname).append("price", price);
		collection.insertOne(document);
		
		response.sendRedirect("add.jsp");
			}

}
