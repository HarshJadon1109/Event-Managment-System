<%@ page import="java.util.List" %>
<%@ page import="yourpackage.Event" %>
<html>
<head>
    <title>Event List</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h2>Events</h2>
    <ul>
        <c:forEach var="event" items="${events}">
            <li>${event.eventName} - ${event.eventDate} - ${event.eventLocation}</li>
        </c:forEach>
    </ul>
</body>
</html>

