<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Atos Project</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	</head>
	<body style="background-color: #DCDCDC">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>	
	<div>
		<div class="page-header" align="center">
			<h1>Funcionários Atos</h1>
		</div>
		<br>
		<!-- TABELA QUE CONTEM O INPUT DE PESQUISA -->
		<table align="center">
			<tbody>
				<tr id="filter_col5" data-column="5">
	                <td align="center">Skill Search: &nbsp</td>
	                <td align="center"><input style="border-radius: 5px" type="text" class="skill_filter" id="skill5_filter"></td>
	                <td align="center"><input type="checkbox" class="skill_filter" id="skill5_regex" checked="checked" hidden></td>
	                <td align="center"><input type="checkbox" class="skill_filter" id="skill5_smart" hidden></td>
            	</tr>
			</tbody>
		</table>
		<br>
		<!-- TABELA QUE SERA POPULADA COM OS DADOS RETORNADOS DA CONTROLLER -->
		<table id="tableFunc" class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Role</th>
					<th scope="col">Salary(R$)</th>
					<th scope="col">Manager</th>
					<th scope="col">Gcm</th>
					<th scope="col" style="text-align: center">Skills</th>
					<th scope="col" style="text-align: center">Certifications</th>
					<th scope="col" style="text-align: center">Projects</th>
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
							Value of Project: R$ <c:out value="${projects.valueOfProject}"></c:out> <br>
							Start Date: <c:out value="${projects.dtBegin}"></c:out> <br>
							End Date: <c:out value="${projects.dtEnd}"></c:out>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
		<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
		<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
		<script>			
			function filterColumn (i) {
			    $('#tableFunc').DataTable().column(i).search(
			        $('#skill'+i+'_filter').val().replace(" ", "|"),
			        $('#skill'+i+'_regex').prop('checked'),
			        $('#skill'+i+'_smart').prop('checked')
			    ).draw();
			}
			
			$(document).ready(function(){
				$('input.skill_filter').on('keyup click', function () {
					filterColumn( $(this).parents('tr').attr('data-column') );
			    } );
				
				$("#tableFunc").dataTable({
					"search": {
						"regex": true,
						"smart": false
					},
					"paging": false,
					"info": false,
					"dom": ''
				});
			})
		</script>
	</body>
</html>