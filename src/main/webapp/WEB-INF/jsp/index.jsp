<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<title>Jobs | Get Hired</title>

	<link rel="stylesheet" href="static/css/bootstrap.min.css">
	<link rel="stylesheet" href="static/css/style.css">  
	
</head>

<body>
	<div role="navigation">
		<div class="navbar navbar-default">
			<a href="/" class="navbar-brand">JOBS</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav" style="float:right;">
					<li><a href="post-job">Post New Job</a></li>
					<li><a href="jobs">All Jobs</a></li>
					<li>
						<form class="form-horizontal" method="GET" action="search-results">
							<input type="text" name="title" class="form-control" placeholder="job title"/>
							<input type="submit" class="btn btn-primary" value="Search"/>
						</form>
					</li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Jobs - We Hire<sup><b>1.0</b></sup></h1>
				</div>
			</div>
		</c:when>
			
		<c:when test="${mode == 'MODE_JOBS'}">
			<div class="container" id="jobDiv">
				<h3>Open Vacancies</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Job ID</th>
								<th>Job Title</th>
								<th>Posted On</th>
								<th></th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="job" items="${joblist}">
							<tr>
								<td>${job.id}</td>
								<td>${job.title}</td>
								<td><fmt:formatDate pattern="yyyy-mm-dd HH:mm:ss" value="${job.postedOn}"/></td>
								<td><a href="view-job?id=${job.id}">
									<span class="glyphicon glyphicon-briefcase"></span></a></td>
								<td><a href="update-job?id=${job.id}">
									<span class="glyphicon glyphicon-pencil"></span></a></td>
								<td><a href="delete-job?id=${job.id}">
									<span class="glyphicon glyphicon-trash"></span></a></td>
							</tr>
						</c:forEach>
							
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
			<div class="container">
				<h3>Manage Job</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-job">
					<input type="hidden" name="id" value="${job.id}">
					<div class="form-group">
						<label class="control-label col-md-3">Title</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="title" value="${job.title}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Category</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="category" value="${job.category}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Location</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="location" value="${job.location}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Description</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="desc" value="${job.desc}"/>
						</div>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save"/>
					</div>
				</form>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_VIEW'}">
			<h1>${job.title}</h1>
			<p>${job.category}</p>
			<p>${job.location}</p>
			<p>${job.desc}</p>
		</c:when>
	</c:choose>
</body>
</html>