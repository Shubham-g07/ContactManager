<%@page import="com.entities.note"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Note</title>
<%@include file="css_js_req.jsp"%>
<style type="text/css">
html, body {
	overflow-x: hidden;
	height: 100vh;
}
</style>
</head>
<body class="d-flex flex-column min-vh-100">

	<div class="fluidcontainer">
		<%@include file="navbar.jsp"%>
	</div>

	<main class="flex-fill">

		<%
		int noteId = Integer.parseInt(request.getParameter("note_id").trim());
		Session session2 = FactoryProvider.getFactory().openSession();
		note n = (note) session2.get(note.class, noteId);
		%>

		<form action="UpdateServlet" method="post">

			<input value="<%=n.getId()%>" name="noteId" type="hidden" />

			<div class="mb-3">
				<label for="title" class="form-label"> Add title of your
					note </label> <input name="title" required type="text" class="form-control"
					id="title" aria-describedby="help" placeholder="Enter Title Here"
					value="<%=n.getTitle()%>" />
				<div id="help" class="form-text">We'll never share your
					details with anyone else.</div>
			</div>

			<div class="mb-3">
				<label for="Desc" class="form-label"> Description </label>
				<textarea name="description" required class="form-control" id="Desc"
					placeholder="Enter description of note" style="height: 300px;"><%=n.getContent()%></textarea>
			</div>

			<div class="container text-center">
				<button type="submit" class="btn btn-success ">Save Note</button>
			</div>
		</form>
	</main>

	<%@include file="footer.jsp"%>

</body>
</html>