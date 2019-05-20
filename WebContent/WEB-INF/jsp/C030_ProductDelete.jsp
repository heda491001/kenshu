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
	<form action=/ProductMaster/ProductServlet method="POST">
		<div style="width: 600px; margin-left: auto; margin-right: auto;">
			<table>
				<tr>
					<td><img alt="山田ギフト"
						src="${pageContext.request.contextPath}/img/yamada.jpg"
						style="width: 100px; height: 60px;"></td>
					<td><input style="background-color: #eeffee; font-size: 20px;"
						type="submit" name="c030_return" value="メイン画面に戻る" /></td>
					<td><input style="background-color: #ffccee; font-size: 20px;"
						type="submit" name="c030_logout" value="ログアウト" /></td>
				</tr>
			</table>
		</div>
		<div
			style="width: 600px; height: 400px; margin-left: auto; margin-right: auto; background-color: #eeeeff;">
			<h1>商品削除</h1>
			<div style="width: 520px; margin-left: auto; margin-right: auto;">
				<div style="color: red; height: 30px;">
					<%
						String message = (String) request.getAttribute("message");
						if (null != message && !("".equals(message))) {
							out.println(message);
						}
					%>
				</div>
				<table>
					<tr style="text-align: left; background-color: #E5E5E5">
						<th>ID</th>
						<th>商品分類</th>
						<th>商品名</th>
						<th>価格</th>
						<th>登録日</th>
						<th>更新日</th>
					</tr>
					<tr style="text-align: left; background-color: #F5F5F5">
						<td><%=productInfoBean.getProductID()%></td>
						<td><%=productInfoBean.getProductType()%></td>
						<td><%=productInfoBean.getProductName()%></td>
						<td>
							<div align="right">
								<%=String.format("%1$,3d円", productInfoBean.getPrice())%>
							</div>
						</td>
						<td><%=productInfoBean.getInsertDate()%></td>
						<td><%=productInfoBean.getUpdateDate()%></td>
					</tr>
					<tr>
						<th colspan="6"
							style="text-align: left; background-color: #E5E5E5">商品説明</th>
					</tr>
					<tr>
						<td colspan="6" style="background-color: #F5F5F5"><textarea
								rows=3 cols=50><%=productInfoBean.getDescription()%></textarea></td>
					</tr>
				</table>
			</div>
			<div
				style="width: 100px; margin-left: auto; margin-right: auto; margin-top: 50px; margin-bottom: 50px;">
				<input type="hidden" name="c030_deleteinfo"
					value="<%=productInfoBean.getProductID()%>" /> <input
					style="background-color: #aaccff; font-size: 20px;" type="submit"
					name="c030_delete" value="削除実行" />
			</div>
		</div>
	</form>
</body>
</html>