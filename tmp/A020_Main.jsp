<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="userInfoBean" class="bean.UserInfoBean" scope="request" />
<jsp:useBean id="productInfoBean" class="bean.ProductInfoBean"
	scope="request" />
<%@ page session="true"%>
<!DOCTYPE html>
<%--
 * Java（基本）サンプルプログラム
 *
 * Copyright(C) 株式会社ラーニングエージェンシー 2019-
--%>

<html>
<head>
<title>商品マスタ管理システム</title>
<script src="/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function() {
	$("#select").click(
			test('a020_refer=&a020_productID=')
			);
});
</script>
<script type="text/javascript">
	function test2(args) {
		$.ajax({
			url : "/ProductMaster/ProductServlet",
			data : args,
			datatype : "html",
			type : "POST",
			success : function(result) {
				document.getElementById("test").innerHTML = result;
			}
		});
	};
	function test(args) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("test").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("POST", "/ProductMaster/ProductServlet", true);
		xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlhttp.send(args);
	}
</script>
</head>
<body
	style="background-image: linear-gradient(-90deg, #5C9BA3, #FFEBF2);">

	
	<form action="/ProductMaster/ProductServlet" method="POST">
		<div style="width: 600px; margin-left: auto; margin-right: auto;">
			<table>
				<tr>
					<td colspan=2>
						<%
							String userName = (String) session.getAttribute("userName");
							if (!"".equals(userName)) {
								out.println("ようこそ" + userName + "さん");
							}
						%>
					</td>
				</tr>
				<tr>
					<td><img alt="山田ギフト"
						src="${pageContext.request.contextPath}/img/yamada.jpg"
						style="width: 100px; height: 60px;"></td>
					<td><input style="background-color: #ffccee; font-size: 18px;"
						type="submit" name="a020_logout" value="ログアウト" /></td>
				</tr>
			</table>
		</div>
		
			
	<input type="button" value="全件照会" onclick="test2('a020_refer=&a020_productID=')">
	<input type="button" id="select" name="select" value="照会">
	<input type="button" value="削除" onclick="test('a020_refer=&a020_productID=')">
	<input type="button" value="更新" onclick="test('a020_refer=&a020_productID=')">
	<input type="button" value="登録" onclick="test('a020_regist')">
	
	<div id='test'></div>
	
		<div style="width: 600px; height: 400px; margin-left: auto; margin-right: auto; background-color: #eeeeff;">
			<h1>商品マスタ管理メイン</h1>
			<div style="width: 500px; margin-left: auto; margin-right: auto;">
				<div style="color: red; height: 30px;">
					<%
						String message = (String) request.getAttribute("message");
						if (null != message && !("".equals(message))) {
							out.println(message);
						}
					%>
				</div>
				<div style="margin-top: 10px;">既存商品のメンテナンス</div>
				<div
					style="background-color: #ddeeff; margin-bottom: 50px; width: 500px;">
					<table>
						<tr>
							<td>商品ID</td>
							<td bgcolor="#eeeeff"><input type="text"
								name="a020_productID"
								value="<%=productInfoBean.getProductID()%>" /></td>
							<td bgcolor="#eeeeff"><input
								style="background-color: #aaccff; font-size: 20px;"
								type="submit" name="a020_delete" value="削除" /> <input
								style="background-color: #aaccff; font-size: 20px;"
								type="submit" name="a020_update" value="更新" /> <input
								style="background-color: #aaccff; font-size: 20px;"
								type="submit" name="a020_refer" value="照会" />
							</td>
						</tr>
						<tr>
							<td/>
							<td style="font-size: 15px;">未入力照会は全件表示</td>
						</tr>
					</table>

			</div>
				<div style="margin-top: 50px;">新規商品</div>
				<div
					style="background-color: #eeffff; margin-bottom: 50px; width: 500px;">
					<div style="width: 100px; margin-left: auto; margin-right: auto;">
						<input style="background-color: #aaccff; font-size: 20px;"
							type="submit" name="a020_regist" value="登録" />
					</div>
				</div>
			</div>
		</div>
	</form>
	

</body>
</html>