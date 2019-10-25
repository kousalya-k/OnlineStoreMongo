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

import Online.ConnectionManager;
import Online.Book;

/**
 * Servlet implementation class viewservlet
 */
@WebServlet("/view.do")
public class viewservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       List<Book>dataList=new ArrayList<Book>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("lib");

		MongoCollection<Document> collection = db.getCollection("online");
		MongoCursor<Document> cursor = collection.find().iterator();
		while (cursor.hasNext()) {
			Document d = (Document) cursor.next();

			Book zip = new Book(d.getString("bname"), d.getString("aname"), d.getString("price"));
			dataList.add(zip);
		}
		request.setAttribute("data", dataList);
		request.getRequestDispatcher("view.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
