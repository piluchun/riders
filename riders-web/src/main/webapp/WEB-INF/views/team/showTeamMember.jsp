<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>邀请好友</title>
	<script>
		$(document).ready(function() {
			$("#deleteUser").bind("click",function(){
				var tid = $("#tid").val();
				var uids = "";
				var uidArray = $("input[type='checkbox']");
				for(var i=0;i<uidArray.length;i++){
					if(uidArray[i].checked){
						uids += uidArray[i].value +","
					}
				}
				if(uids.charAt(uids.length-1)==","){
					uids = uids.substring(0,uids.length-1);
				}
				 window.location.href="${ctx}/team/deleteTeamMember?tid="+tid+"&uids="+uids+"&time="+new Date();
			});
		});
	</script>
</head>

<body>
	<form id="inputForm"  class="form-horizontal">
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
	<input type="hidden" id="tid" value="${team.tid }"/>
	<c:if test="${empty list }">
		<tr><td>该车队还没有骑友参加， 快去邀请吧！</td></tr>
	</c:if>
	<c:if test="${!empty list }">
	<thead><tr><th>车队${team.teamname }队员列表----队长：${team.leader.nickname }</th></tr></thead>
	<thead><tr><th>头像</th><th>用户</th><th>昵称</th><th>性别</th><th>年龄</th><c:if test="${team.leader.uid == uid}"><th>选择</th></c:if></tr></thead>	
	 	<c:forEach items="${team.teamMembers}" var = "user">
			<tr>
				<td><img src="${user.picture }" width=60 height=50/></td>
				<td>${user.email }</td>
				<td>${user.nickname }</td>
				<td>
					<c:if test="${user.sex=='1'}">男</c:if>
					<c:if test="${user.sex=='0'}">女</c:if>
				</td>
				<td>
					<c:if test="${!empty user.age}">${user.age }</c:if>
					<c:if test="${empty user.age}">不详</c:if>	
				</td>
				<c:if test="${team.leader.uid == uid}">
					<td>
						<input  type="checkbox" value="${user.uid }" onclick="formname.uid.checked=!this.checked"/>
					</td>
				</c:if>
			</tr>
		</c:forEach>
		<c:if test="${team.leader.uid == uid}">
		 	<tr>
		 		<td   colspan="6"><input type="button" id="deleteUser"  value="剔除队友"></td>
		 	</tr>
	 	</c:if>
	 </c:if>
	</table>
	</form>
</body>
</html>
