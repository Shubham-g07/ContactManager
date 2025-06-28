<%@page import="org.hibernate.type.StringNVarcharType"%>
<%@page import="org.hibernate.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.entities.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ALL Notes</title>
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
	<br>

	<main class="flex-fill">
		<div class="text-center">
			<h1 class="text-uppercase">All notes</h1>
		</div>

		<div class="row">
			<div class="col-12">

				<%
				Session s = FactoryProvider.getFactory().openSession();
				Query q = s.createQuery("from note");
				List<note> list = q.list();

				for (note n : list) {
				%>

				<div class="card mt-3">
					<div class="card-body px-5"
						style="display: flex; text-align: center; justify-content: space-between;">
						<img class="card-img-top m-4" style="max-width: 100px;"
							alt="noteIcon" src="img/sticky-notes.png" />
						<div style="flex: 1;">
							<h5 class="card-title">
								<%=n.getTitle()%>
							</h5>
							<p class="card-text">
								<%=n.getContent()%>
							</p>
							<div class="container text-center">
								<a href="DeleteServlet?note_id=<%=n.getId()%>"
									class="btn btn-danger">Delete</a> <a
									href="edit.jsp?note_id=<%=n.getId()%>"
									class="btn btn-primary">Edit</a>
							</div>
						</div>
					</div>
				</div>


				<%
				}

				s.close();
				%>

			</div>

		</div>
		</div>
	</main>

	<br>
	<%@include file="footer.jsp"%>

</body>
</html>