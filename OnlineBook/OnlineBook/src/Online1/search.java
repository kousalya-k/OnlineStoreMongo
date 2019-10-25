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
import com.mongodb.client.model.Filters;

import Online.Book;
import Online.ConnectionManager;

/**
 * Servlet implementation class search
 */
@WebServlet("/search.do")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Book> dataList;
	List<Book> List1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
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
		MongoCursor<Document> cursor = collection.find().iterator();
		dataList=new ArrayList<Book>();
		while (cursor.hasNext()) {
		Document d = (Document) cursor.next();

			Book zip = new Book(d.getString("bname"), d.getString("aname"), d.getString("price"));
			dataList.add(zip);
		}
		request.setAttribute("data", dataList);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("lib");
		List1=new ArrayList<Book>();

		MongoCollection<Document> collection = db.getCollection("online");
		String search = request.getParameter("search");
		MongoCursor<Document> cursor = collection.find(Filters.eq("bname",search)).iterator();
	
			Document d = (Document) cursor.next();

			Book zip = new Book(d.getString("bname"), d.getString("aname"), d.getString("price"));
			List1.add(zip);
			
			
		
		request.setAttribute("data", List1);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

}
