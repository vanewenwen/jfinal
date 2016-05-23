<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户集合</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<a href="${base}/user/toAdd" class="btn btn-primary btn-sm"> 新增用户</a>
				<table class="table table-striped table-bordered table-hover table-condensed">
					<c:forEach var="user" items="${studentList}">
						<tr class="active">
							<td><c:out value="${user.id}" default="" />
							</td>
							<td>${user.name}</td>
							<td>${user.age}</td>
							<td>&nbsp;&nbsp;<a href="${base}/user/del/${user.id}">删除</a>
								&nbsp;&nbsp;<a href="${base}/user/toUpd/${user.id}">修改</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</body>
</html>