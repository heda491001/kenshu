/*
 * Java（基本）サンプルプログラム
 *
 * Copyright(C) 株式会社ラーニングエージェンシー 2019-
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.ProductInfoBean;
import common.DBConnect;
import common.ProductException;

/**
 * 商品情報登録クラス
 * 当クラスでは、商品情報を商品情報テーブルに登録するためのメソッドを提供します。
 *
 * @author H.ARIMACHI
 */
public class RegistDAO {

	/**
	 * 商品登録メソッド
	 *
	 * @param pib  ProductInfoBean型のオブジェクト
	 * @throws ProductException DB接続エラー、SQLExceptionが発生した場合
	 */

	public void addProduct(ProductInfoBean pib) throws ProductException {

		Connection con = null;

		try {
			// 	DBに接続
			con = DBConnect.getConnection();

			//	オートコミットモードの解除
			con.setAutoCommit(false);

			// SQLの準備
			String confirm = "SELECT prd_id, prd_type, prd_name, price, description, insert_date, update_date FROM yd_product_info WHERE prd_id = ?";
			String sql = "INSERT INTO yd_product_info (prd_id, prd_type, prd_name, price, description, insert_date, update_date) VALUES(?,?,?,?,?,cast(now() as date),null)";

			//	 入力された商品IDと一致するIDがすでに登録されていないか確認する
			PreparedStatement pstmt = con.prepareStatement(confirm);
			//	オートコミットモードの解除
			con.setAutoCommit(false);

			pstmt.setString(1, pib.getProductID());
			ResultSet rs = pstmt.executeQuery();

			// 	一致する商品IDが存在していなければ、商品情報を登録する
			boolean isExists = rs.next();
			if (isExists == false) {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, pib.getProductID());
				pstmt.setString(2, pib.getProductType());
				pstmt.setString(3, pib.getProductName());
				pib.setPrice(Integer.valueOf(pib.getPriceString()));
				pstmt.setInt(4, pib.getPrice());
				pstmt.setString(5, pib.getDescription());
				pstmt.executeUpdate();
				con.commit();
			} else {

				throw new ProductException("1003W");
			}

		} catch (SQLException e) {
			if(con != null){
				try{
					con.rollback();
				}catch(SQLException e2){
				}
			}
			throw new ProductException("1004W", e);

		} finally {

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
