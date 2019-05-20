<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="productInfoBean" class="bean.ProductInfoBean" scope="request" />
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
						<input style="background-color:#eeffee; font-size:20px;" type="submit" name="c010_return" value="メイン画面に戻る" />
					</td>
					<td>
						<input style="background-color:#ffccee; font-size:20px;" type="submit" name="c010_logout" value="ログアウト" />
					</td>
				</tr>
			</table>
		</div>
		<div style="width:500px; height:400px; margin-left:auto; margin-right:auto; background-color:#eeeeff;">
			<h1>商品登録</h1>
			<div style="color: red; height:30px;">
				<% String message = (String)request.getAttribute("message");
					if (null != message && !("".equals(message))) {
						out.println(message);
					}
				%>
			</div>
			<div style="width: 400px; margin-left:auto; margin-right:auto;">
				<table>
					<tr>
						<td>商品ID</td>
						<td><input type="text" name="c010_productID" value="<%= productInfoBean.getProductID() %>"/></td>
					</tr>
					<tr>
						<td>商品分類</td>
						<td><input type="text" name="c010_productType" value="<%= productInfoBean.getProductType() %>" /></td>
					</tr>
					<tr>
						<td>商品名</td>
						<td><input type="text" name="c010_productName" value="<%= productInfoBean.getProductName() %>" /></td>
					</tr>
					<tr>
						<td>価格</td>
						<td><input type="text" name="c010_price" value="<%= productInfoBean.getPriceString() %>" />円</td>
					</tr>
					<tr>
						<td>商品説明</td>
						<td><textarea name="c010_description" rows=3 ><%= productInfoBean.getDescription() %></textarea></td>
					</tr>
				</table>
			</div>
			<div style="width:100px; margin-left:auto; margin-right:auto; margin-top:50px; margin-bottom:50px;">
				<input style="background-color:#aaccff; font-size:20px;" type="submit" name="c010_regist" value="登録実行" />
			</div>
		</div>
	</form>
</body>
</html>