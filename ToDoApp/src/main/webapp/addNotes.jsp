<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>

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
			<h3>Add your notes</h3>
		</div>

		<br>
		<!-- Add notes form -->
		<form action="SaveNoteServlet" method="post">
			<div class="mb-3">
				<label for="title" class="form-label"> Add title of your
					note </label> <input name="title" required type="text" class="form-control"
					id="title" aria-describedby="help" placeholder="Enter Title Here" />
				<div id="help" class="form-text">We'll never share your
					details with anyone else.</div>
			</div>

			<div class="mb-3">
				<label for="Desc" class="form-label"> Description </label>
				<textarea name="description" required class="form-control" id="Desc"
					placeholder="Enter description of note" style="height: 300px;"></textarea>
			</div>

			<div class="container text-center">
				<button type="submit" class="btn btn-primary ">Add Note</button>
			</div>
		</form>
	</main>

	<br>
	<%@include file="footer.jsp"%>



</body>
</html>