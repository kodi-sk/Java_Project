<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import="models.Company"
     import="models.userDao"
     import="java.util.*"  
 %>        
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="./static/main.css" />
		<title>Student</title>
	</head>
	<body>
		<div class="table-title">
			<h3>Data Table</h3>
		</div>
		<form>
		<table class="table-fill">
		<thead>
			<tr>
				<th class="text-left">Name</th>
				<th class="text-left">Package</th>
				<th class="text-left">Apply</th>
			</tr>
		</thead>
		<tbody class="table-hover">
				<%ArrayList<Company> currentCompany=new ArrayList<Company>(); %>
				<% currentCompany = userDao.show();%>
				<% for(Company b: currentCompany) {%>
	    		<tr>
					<td class="text-left"><%= b.getCname() %></td>
					<td class="text-,left"><%= b.getCpackage() %></td>
					<td class="text-,left"><%= b.getCount() %></td>
					<td class="text-,left"> <button onclick=<% userDao.IncCount(b); %> > Apply </button> </td>
				</tr>
				<%}%>
		</tbody>
		</table>
		</form>
	</body>
</html>
