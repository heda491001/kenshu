<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.ProductInfoBean"%>
<!DOCTYPE html>
<%--
 * Java（基本）サンプルプログラム
 *
 * Copyright(C) 株式会社ラーニングエージェンシー 2019-
--%>
<div
	style="width: 1200px; margin-left: auto; margin-right: auto; background-color: #eeeeff;">
	<table>
		<tr>
			<td>
				<h1>商品一覧</h1>
			</td>
			<td>
				<%
						List<ProductInfoBean> pibList = (ArrayList<ProductInfoBean>)request.getAttribute("pibList");

						boolean isExistsList = true;
						if ( 0 >= pibList.size() ) {
							isExistsList = false;
						}
						else if ( 1 >= pibList.size() ) {
							ProductInfoBean bean = pibList.get(0);
							String key = bean.getSearchKey();
							//out.println("<div style='width:300px; margin-left:100px; margin-right:auto;'>検索キー：" + key + "</div>");
						}
					%>
			</td>
		</tr>
	</table>
	<table>
		<colgroup width="100px;" />
		<colgroup width="100px;" />
		<colgroup width="300px;" />
		<colgroup width="100px;" />
		<colgroup width="400px;" />
		<colgroup width="100px;" />
		<colgroup width="100px;" />
		<tr style="text-align: left; background-color: #E5E5E5">
			<th>ID</th>
			<th>商品分類</th>
			<th>商品名</th>
			<th>価格</th>
			<th>商品説明</th>
			<th>登録日</th>
			<th>更新日</th>
		</tr>
		<%
				if ( true == isExistsList ) {
					for ( int i = 0; i < pibList.size(); i++ ) {
						out.println(
							"<tr style='text-align: left;background-color:#F5F5F5'>"
							+ "<td>" + pibList.get(i).getProductID() + "</td>"
							+ "<td>" + pibList.get(i).getProductType() + "</td>"
							+ "<td>" + pibList.get(i).getProductName() + "</td>"
							+ "<td>"
							+ "<div align = right>"
							+ String.format("%1$,3d",pibList.get(i).getPrice())
							+ "</div>"
							+ "</td>"
							+ "<td>" + pibList.get(i).getDescription() + "</td>"
							+ "<td>" + pibList.get(i).getInsertDate() + "</td>"
							+ "<td>" + pibList.get(i).getUpdateDate() + "</td>"
							+ "</tr>"
						);
					}
				}
			%>
	</table>
</div>
