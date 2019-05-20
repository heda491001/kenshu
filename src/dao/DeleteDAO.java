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
 * 商品情報削除用クラス
 *
 * @author H.ARIMACHI
 */
public class DeleteDAO {

	/**
	 * 商品情報削除処理
	 * 商品情報テーブルから引数で設定されたProductInfoBean内の商品ＩＤに
	 * 該当するデータを削除します。
	 *
	 * @param pib  ProductInfoBean型のオブジェクト
	 * @throws ProductException DB接続エラー、SQLExceptionが発生した場合
	 */
	public void deleteDAO(ProductInfoBean pib) throws ProductException {

		Connection con = null;

		try {

			//	DBに接続
			con = DBConnect.getConnection();

			//	オートコミットモードの解除
			con.setAutoCommit(false);

			// 	SQLの準備
			String confirm = "SELECT prd_id, prd_type, prd_name, price, description, insert_date, update_date FROM yd_product_info WHERE prd_id = ?";
			String sql = "DELETE FROM yd_product_info WHERE prd_id = ?";

			//	削除する商品が存在するか、商品IDで検索して確認
			PreparedStatement pstmt = con.prepareStatement(confirm);
			pstmt.setString(1, pib.getProductID());
			ResultSet rs = pstmt.executeQuery();

			//	一致する商品IDが存在していれば、商品情報を削除する
			boolean isExists = rs.next();
			if (isExists) {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, pib.getProductID());
				pstmt.executeUpdate();

				con.commit();

			} else {

				throw new ProductException("1008W");
			}

		} catch (SQLException e) {
			if(con != null){
				try{
					con.rollback();
				}catch(SQLException e2){
				}
			}
			throw new ProductException("1006W", e);

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
