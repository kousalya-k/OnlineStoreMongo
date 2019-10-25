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
import com.mongodb.client.model.Updates;

import Online.Book;
import Online.ConnectionManager;

/**
 * Servlet implementation class addreview
 */
@WebServlet("/addrev.do")
public class addreview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Book> dataList;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addreview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("lib");
//
		MongoCollection<Document> collection = db.getCollection("online");
		dataList=new ArrayList<Book>();
//		String review=request.getParameter("review");
		// document.append("review", review);
		//collection.insertOne(document);
		//collection.set("review",review );
		
		String bookName = request.getParameter("bookName");
		MongoCursor<Document> cursor = collection.find(Filters.eq("bname",bookName)).iterator();
		if(cursor.hasNext()) {
			Document d = (Document) cursor.next();
			Book b = new Book(d.getString("bname"),d.getString("aname"),d.getString("price"));
			//request.getSession().setAttribute("book",b);
			dataList.add(b);
		}
		 String review=request.getParameter("review");
			//Book b = (Book) request.getSession().getAttribute("book");
			//b.setReview(request.getParameter("review"));
			collection.updateOne(Filters.eq("bname", bookName), Updates.combine(Updates.set("review", review)));
					
			//response.sendRedirect("addreview.jsp");
		request.setAttribute("data", dataList);
		request.getRequestDispatcher("addreview.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("lib");

		MongoCollection<Document> collection = db.getCollection("online");
		
		String bookName = request.getParameter("bookName");
		MongoCursor<Document> cursor = collection.find(Filters.eq("bname",bookName)).iterator();
		if(cursor.hasNext()) {
			Document d = (Document) cursor.next();
			Book b = new Book(d.getString("bname"),d.getString("aname"),d.getString("price"));
			//request.getSession().setAttribute("book",b);
			
		}
     String review=request.getParameter("review");
		//Book b = (Book) request.getSession().getAttribute("book");
		//b.setReview(request.getParameter("review"));
		collection.updateOne(Filters.eq("bname", bookName), Updates.combine(Updates.set("review", review)));
				
		response.sendRedirect("addreview.jsp");*/
	}

}
