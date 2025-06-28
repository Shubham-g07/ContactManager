<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Note Taker Application</title>

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
		<div class="text-center">
			<img class="mt-5" alt="notes_gif" src="img/leaves-6625_256.gif"
				style="max-width: 300px; color: white;"> <br> <br>
			<h2>Start taking your notes.</h2>
			<br> <a class="btn btn-primary" href="addNotes.jsp">Start</a>
		</div>

	</main>


	<%@include file="footer.jsp"%>

</body>
</html>