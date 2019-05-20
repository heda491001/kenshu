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
<body
	style="background-image: linear-gradient(-90deg, #5C9BA3, #FFEBF2);">
	<form action="/ProductMaster/ProductServlet" method="POST">
		<div style="width: 600px; margin-left: auto; margin-right: auto;">
			<table>
				<tr>
					<td><img alt="山田ギフト"
						src="${pageContext.request.contextPath}/img/yamada.jpg"
						style="width: 100px; height: 60px;"></td>
					<td><input style="background-color: #eeffee; font-size: 20px;"
						type="submit" name="c020_return" value="メイン画面に戻る" /></td>
					<td><input style="background-color: #ffccee; font-size: 20px;"
						type="submit" name="c020_logout" value="ログアウト" /></td>
				</tr>
			</table>
		</div>
		<div
			style="width: 500px; height: 400px; margin-left: auto; margin-right: auto; background-color: #eeeeff;">
			<h1>商品更新</h1>
			<div style="width: 400px; margin-left: auto; margin-right: auto;">
				<div style="color: red; height: 30px;">
					<%
						String message = (String) request.getAttribute("message");
						if (null != message && !("".equals(message))) {
							out.println(message);
						}
					%>
				</div>
				<table>
					<tr>
						<td>商品ID</td>
						<td><input type="text" name="c020_productID"
							value="<%=productInfoBean.getProductID()%>" /></td>
					</tr>
					<tr>
						<td>商品分類</td>
						<td><input type="text" name="c020_productType"
							value="<%=productInfoBean.getProductType()%>" /></td>
					</tr>
					<tr>
						<td>商品名</td>
						<td><input type="text" name="c020_productName"
							value="<%=productInfoBean.getProductName()%>" /></td>
					</tr>
					<tr>
						<td>価格</td>
						<td>
						<input type="text" name="c020_price"
							style="text-align: right"
							value="<%= String.format("%1$,3d",productInfoBean.getPrice())%>"/>円</td>
					</tr> 
					<tr>
						<td>商品説明</td>
						<td><textarea rows=3 name="c020_description"><%=productInfoBean.getDescription()%></textarea></td>
					</tr>
				</table>
			</div>
			<div
				style="width: 100px; margin-left: auto; margin-right: auto; margin-top: 50px; margin-bottom: 50px;">
				<input type="hidden" name="c020_keyID"
					value="<%=productInfoBean.getSearchKey()%>"> <input
					style="font-size: 20px;" type="submit" name="c020_update"
					value="更新実行" />
			</div>
		</div>
	</form>
</body>
</html>