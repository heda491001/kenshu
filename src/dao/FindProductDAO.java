/*
 * Java（基本）サンプルプログラム
 *
 * Copyright(C) 株式会社ラーニングエージェンシー 2019-
 */

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ProductInfoBean;
import common.DBConnect;
import common.ProductException;

/**
 * 商品照会クラス
 * 当クラスでは、商品情報を取得するためのメソッドを提供します。
 *
 * @author H.ARIMACHI
 */
public class FindProductDAO {

	/**
	 * 商品情報照会処理（１データ専用）
	 * 商品情報テーブルより、引数で指定されたkeyIDに該当する商品情報を取得し、
	 * ProductInfoBeanに対象の商品情報を格納します。
	 *
	 * @param pib  ProductInfoBean型のオブジェクト
	 * @param keyID : 入力された商品ID
	 * @throws ProductException DB接続エラー、SQLExceptionが発生した場合
	 */
	public void getProductInfo(ProductInfoBean pib, String keyID) throws ProductException {

		Connection con = null;

		try {
			// DBに接続
			con = DBConnect.getConnection();

			// SQLの準備
			String sql = "SELECT prd_id, prd_type, prd_name, price, description, insert_date, update_date FROM yd_product_info WHERE prd_id = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyID);
			ResultSet rs = pstmt.executeQuery();

			// 一致する商品IDが存在していればidとpassを取得し、trueをセット。
			boolean isExists = rs.next();
			if (isExists) {
				pib.setProductID(rs.getString("prd_id"));
				pib.setProductType(rs.getString("prd_type"));
				pib.setProductName(rs.getString("prd_name"));

				// 価格
				pib.setPrice(rs.getInt("price"));
				pib.setPriceString(String.valueOf(pib.getPrice()));
				// 商品説明
				String description = rs.getString("description");
				if ( description== null ) {
					pib.setDescription("");
				} else {
					pib.setDescription(description);
				}

				// 登録日
				Date insertDate = rs.getDate("insert_date");
				if ( insertDate == null ) {
					pib.setInsertDate("");
				} else {
					pib.setInsertDate(insertDate.toString());
				}

				// 更新日
				Date update_date = rs.getDate("update_date");
				if ( update_date == null ) {
					pib.setUpdateDate("");
				} else {
					pib.setUpdateDate(update_date.toString());
				}

			// IDと一致する商品が存在しない場合
			} else {
				throw new ProductException("1009W");
			}
		} catch (SQLException e) {
			throw new ProductException("1007W", e);
		} finally {
			// DBの切断
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new ProductException("9000E", e);
				}
			}
		}
	}

	/**
	 * 商品情報照会処理（全件照会用）
	 * 商品情報テーブルより、全商品情報を取得し、
	 * ProductInfoBeanに対象の商品情報を格納します。
	 *
	 * @param pibList  ProductInfoBean配列
	 * @param keyID : 入力された商品ID
	 * @throws ProductException DB接続エラー、SQLExceptionが発生した場合
	 */
	public void getProductInfo(ArrayList<ProductInfoBean> pibList, String keyID) throws ProductException {

		Connection con = null;

		try {
			// DBに接続
			con = DBConnect.getConnection();

			// SQLの準備
			String sql = "SELECT prd_id, prd_type, prd_name, price, description, insert_date, update_date FROM yd_product_info";

			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			// 一致する商品IDが存在していればidとpassを取得し、trueをセット。
			while ( rs.next() ) {

				ProductInfoBean pib = new ProductInfoBean();

				// 商品ID
				pib.setProductID(rs.getString("prd_id"));
				// 商品分類
				pib.setProductType(rs.getString("prd_type"));
				// 商品名
				pib.setProductName(rs.getString("prd_name"));
				// 価格
				pib.setPrice(rs.getInt("price"));
				pib.setPriceString(String.valueOf(pib.getPrice()));
				// 商品説明
				String description = rs.getString("description");
				if ( description== null ) {
					pib.setDescription("");
				} else {
					pib.setDescription(description);
				}

				// 登録日
				Date insertDate = rs.getDate("insert_date");
				if ( insertDate == null ) {
					pib.setInsertDate("");
				} else {
					pib.setInsertDate(insertDate.toString());
				}

				// 更新日
				Date update_date = rs.getDate("update_date");
				if ( update_date == null ) {
					pib.setUpdateDate("");
				} else {
					pib.setUpdateDate(update_date.toString());
				}

				pibList.add(pib);
			}
		} catch (SQLException e) {
			throw new ProductException("1007W", e);
		} finally {
			// DBの切断
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new ProductException("9000E", e);
				}
			}
		}
	}
}
