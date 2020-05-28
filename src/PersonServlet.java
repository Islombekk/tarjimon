import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class PersonServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String requestUrl = request.getRequestURI();
		String originalWord = requestUrl.substring("/Translater/people/".length());

		Person person = DataStore.getInstance().getPerson(originalWord);

		if (person != null) {
			String json = "{\n";
			json += "\"originalWord\": " + JSONObject.quote(person.getOriginalWord()) + ",\n";
			json += "\"translatedWord\": " + JSONObject.quote(person.getTranslatedWord()) + ",\n";
			// json += "\"birthYear\": " + person.getBirthYear() + "\n";
			json += "}";
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			// response.getOutputStream().println(json);
		} else {
			// That person wasn't found, so return an empty JSON object. We could also
			// return an error.
			response.getOutputStream().println("{}");
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String name = request.getParameter("name");
		String about = request.getParameter("about");
		int birthYear = Integer.parseInt(request.getParameter("birthYear"));

		DataStore.getInstance().putPerson(new Person(name, about, birthYear));
	}
}
