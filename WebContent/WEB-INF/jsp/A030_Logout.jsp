<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div style="width:400px; margin-left:auto; margin-right:auto; background-color:#eeeeff;">
		<h1>ログアウトしました</h1>
		<h1>お疲れ様でした</h1>
		<form action="/ProductMaster/ProductServlet" method="POST">
			<div style="width: 200px; text-align: right;">
				<input style="background-color:#eeffee; font-size:20px;" type="submit" name="a030_back" value="ログイン画面に戻る" />
			</div>
		</form>
	</div>
</body>
</html>