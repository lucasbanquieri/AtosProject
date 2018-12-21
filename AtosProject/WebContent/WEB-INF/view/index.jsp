<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Atos Project</title>
	</head>
	<body>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<!-- Filtrar por skill:
		<input type="checkbox" name="" value="Java">Java
		<input type="checkbox" name="" value="JavaEE">JavaEE
		<input type="checkbox" name="" value="Microservice">Microservice
		<input type="checkbox" name="" value="Rest">Rest
		<input type="checkbox" name="" value="SOA">SOA
		<input type="checkbox" name="" value="Oracle Soa Suite">Oracle Soa Suite
		<input type="checkbox" name="" value="Graphql">Graphql
		<input type="checkbox" name="" value="DevOps">DevOps
		<input type="checkbox" name="" value="Gestão de pessoas">Gestão de pessoas
		<input type="checkbox" name="" value="PMI">PMI
		<input type="checkbox" name="" value="Scrum">Scrum
		<input type="checkbox" name="" value="Agile">Agile<br>
		<button type="submit" id="filtro">Filtrar</button><br>
		<br> -->
		<table id="tableFunc" border="1">
			<thead>
				<th colspan="8" align="center">Funcionários Atos</th>
				<tr>
					<th>Name</th>
					<th>Role</th>
					<th>Salary</th>
					<th>Manager</th>
					<th>Gcm</th>
					<th align="center">Skills</th>
					<th align="center">Certifications</th>
					<th align="center">Projects</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="funcionario" items="${funcionarios}">
				<tr>
					<td>${funcionario.name}</td>
					<td>${funcionario.role}</td>
					<td align="center">${funcionario.salary}</td>
					<td>${funcionario.manager}</td>
					<td align="center">${funcionario.gcm}</td>
					<td>
						<c:forEach var="skills" items="${funcionario.skills}">
							<c:out value="${skills}"></c:out> <br>
						</c:forEach>
					</td>
					<td>
						<c:forEach var="certification" items="${funcionario.certification}">
							<c:out value="${certification}"></c:out> <br>
						</c:forEach>
					</td>
					<td>
						<c:forEach var="projects" items="${funcionario.projectList}">
							Name: <c:out value="${projects.name}"></c:out> <br>
							Customer: <c:out value="${projects.customer}"></c:out> <br>
							Value of Project: <c:out value="${projects.valueOfProject}"></c:out> <br>
							Start Date: <c:out value="${projects.dtBegin}"></c:out> <br>
							End Date: <c:out value="${projects.dtEnd}"></c:out> <br>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
		<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
		<script>
			/*$("#filtro").on("click", function(){
				$.post("index?filtros=" + $("#filtro").val(), function(resposta) {
					$("#alunos").html(resposta);
				})
			})*/
			
			$(document).ready(function(){
				$("#tableFunc").dataTable({
					"paging": false,
					"info": false
				});
			})
		</script>
	</body>
</html>