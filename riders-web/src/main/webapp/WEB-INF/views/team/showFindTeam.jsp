<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>查找车队结果</title>
</head>

<body>
		<table id="contentTable" class="table table-striped table-bordered table-condensed">
			<c:if test="${ empty team}">
				<thead><tr><td cols="3"><font color="red" align="center">	sorry,您查找的车队不存在         </font></td></tr></thead>
			</c:if>
			<c:if test="${!empty team}">
			<thead><tr><th>车队名</th><th>车队队长</th><th>车队申明</th><th>建队时间</th><th colspan="2">加入车队</th></tr></thead>
				<tbody>
					<tr>
						<td>${team.teamname}</td>
						<td>${team.leader.email}</td>
						<td>${team.declaration}</td>
						<td>
							<fmt:formatDate pattern='yyyy-MM-dd HH:mm:ss' value='${team.ctime}'></fmt:formatDate>
						</td>
						<td colspan="2"><a href="${ctx }/team/applyAddTeam?tid=${team.tid }">加入车队</a></td>
					</tr>
					<c:if test="${empty team.teamMembers}">
						<thead><tr><th colspan="6">该车队成员还没有任何成员</th></tr></thead>
					</c:if>
					<c:if test="${!empty team.teamMembers}">
						<thead><tr><th colspan="6"><font color="green">${team.teamname }</font>车队成员</th></tr></thead>
						<thead><tr><th>头像</th><th>用户</th><th  colspan="2">昵称</th><th>性别</th><th>年龄</th></tr></thead>
						<c:forEach items="${team.teamMembers}" var = "user">
							<tr>
								<td><img src="${user.picture }" width=60 height=50/></td>
								<td>${user.email }</td>
								<td colspan="2">${user.nickname }</td>
								<td>
									<c:if test="${user.sex=='1'}">男</c:if>
									<c:if test="${user.sex=='0'}">女</c:if>
								</td>
								<td >
									<c:if test="${!empty user.age}">${user.age }</c:if>
									<c:if test="${empty user.age}">不详</c:if>	
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</c:if>
		</table>
</body>
</html>
