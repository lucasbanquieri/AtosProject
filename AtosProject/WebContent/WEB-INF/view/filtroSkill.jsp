<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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