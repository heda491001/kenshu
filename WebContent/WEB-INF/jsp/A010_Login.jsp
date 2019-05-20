<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="userInfoBean" class="bean.UserInfoBean" scope="request" />
<!DOCTYPE html>
<%--
 * Java（基本）サンプルプログラム
 *
 * Copyright(C) 株式会社ラーニングエージェンシー 2019-
--%>
<html>
<head>
<title>商品マスタ管理システム</title>
</head>
<body style="background-image: linear-gradient(-90deg, #5C9BA3, #FFEBF2);">
	<div style="width:600px; margin-left:auto; margin-right:auto;">
		<img alt="山田ギフト" src="${pageContext.request.contextPath}/img/yamada.jpg" style="width:100px; height:60px;">
	</div>
	<div style="width:400px; height:200px; margin-left:auto; margin-right:auto; background-color:#eeeeff;">
		<h1>商品マスタ管理システム</h1>
		<form action="/ProductMaster/ProductServlet" method="POST">
			<div style="width: 300px; color: red; height:30px;">
				<% String message = (String)request.getAttribute("message");
					if (null != message && !("".equals(message))) {
						out.println(message);
					}
				%>
			</div>

			<div style="width: 300px;">
				<table>
					<tr>
						<td width="100px">ユーザID</td>
						<td width="100px">
							<input type="text" name="a010_userid" size="16" value="<%=userInfoBean.getUserID()%>" />
						</td>
					</tr>
					<tr>
						<td>パスワード</td>
						<td width="100px">
							<input type="password" name="a010_password" size="16" />
						</td>
					</tr>
				</table>
				<div style="width:100px; margin-left:auto; margin-right:auto;">
					<input style="background-color:#bbbbff; font-size:20px;" type="submit" name="a010_login" value="ログイン" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>