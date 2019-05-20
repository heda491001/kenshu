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
	<form action="/ProductMaster/ProductServlet" method="POST">
		<div style="width:600px; margin-left:auto; margin-right:auto;">
			<table>
				<tr>
					<td>
						<img alt="山田ギフト" src="${pageContext.request.contextPath}/img/yamada.jpg" style="width:100px; height:60px;">
					</td>
					<td>
						<input style="background-color:#eeffee; font-size:20px;" type="submit" name="c035_return" value="メイン画面に戻る" />
					</td>
					<td>
						<input style="background-color:#aaccff; font-size:20px;" type="submit" name="c035_logout" value="ログアウト" />
					</td>
				</tr>
			</table>
		</div>
		<div style="width:400px; margin-left:auto; margin-right:auto; background-color:#eeeeff;">
			<h1>商品情報を削除しました</h1>
		</div>
	</form>
</body>
</html>