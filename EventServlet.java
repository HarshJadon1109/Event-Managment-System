import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            String eventName = request.getParameter("event_name");
            String eventDate = request.getParameter("event_date");
            String eventLocation = request.getParameter("event_location");
            String eventDescription = request.getParameter("event_description");

            try (Connection conn = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO Events (event_name, event_date, event_location, event_description) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, eventName);
                    stmt.setString(2, eventDate);
                    stmt.setString(3, eventLocation);
                    stmt.setString(4, eventDescription);
                    stmt.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            response.sendRedirect("events.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Event> events = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Events")) {

            while (rs.next()) {
                Event event = new Event(
                    rs.getInt("event_id"),
                    rs.getString("event_name"),
                    rs.getDate("event_date"),
                    rs.getString("event_location"),
                    rs.getString("event_description")
                );
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("events", events);
        RequestDispatcher dispatcher = request.getRequestDispatcher("events.jsp");
        dispatcher.forward(request, response);
    }
}

