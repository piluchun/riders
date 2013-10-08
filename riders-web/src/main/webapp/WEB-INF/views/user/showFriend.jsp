<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>车队列表</title>
</head>

<body>
		<table id="contentTable" class="table table-striped table-bordered table-condensed">
			<c:if test="${ empty user.friendList}">
				<thead><tr><td cols="4"><font color="red" align="center">	sorry,您目前还没有添加任何朋友        </font></td></tr></thead></c:if>
			<c:if test="${!empty user.friendList}">
			<thead><tr><th>头像</th><th>用户名</th><th>昵称</th><th>性别</th><th>年龄</th><th>删除好友</th></tr></thead>
				<tbody>
					<c:forEach items="${user.friendList }" var="user">
						<tr>
							<td><img src="${user.picture }" width=60 height=50/></td>
							<td>${user.email}</td>
							<td>${user.nickname}</td>
							<td>
								<c:if test="${user.sex=='1'}">男</c:if>
								<c:if test="${user.sex=='0'}">女</c:if>
							</td>
							<td>
								<c:if test="${!empty user.age}">${user.age }</c:if>
										<c:if test="${empty user.age}">不详</c:if>	
							</td>
							<td><a href="${ctx }/user/deleteFriend?uid=${user.uid}">删除好友</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</c:if>
		</table>
</body>
</html>
