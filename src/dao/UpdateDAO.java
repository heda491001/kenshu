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
 * 商品情報更新
 *
 * @author H.ARIMACHI
 */
public class UpdateDAO {

	/**
	 * 商品情報更新メソッド
	 *
	 * @param pib  ProductInfoBean型のオブジェクト
	 * @throws ProductException DB接続エラー、SQLExceptionが発生した場合
	 */
	public void updateDAO(ProductInfoBean pib) throws ProductException {

		Connection con = null;

		try {
			// DBに接続
			con = DBConnect.getConnection();

			//	オートコミットモードの解除
			con.setAutoCommit(false);

			// SQLの準備
			String confirm = "SELECT prd_id, prd_type, prd_name, price, description, insert_date, update_date FROM yd_product_info WHERE prd_id = ?";
			String sql = "Update yd_product_info set prd_id = ?, prd_type = ?, prd_name = ?,"
					+ "price =?, description = ?, update_date = cast(now() as date) " + "WHERE prd_id = ?";

			// 		更新する商品が存在しているか、商品IDで検索して確認
			PreparedStatement pstmt = con.prepareStatement(confirm);
			pstmt.setString(1, pib.getSearchKey());
			ResultSet rs = pstmt.executeQuery();

			boolean isExists = rs.next();
			// 	商品が存在していれば、更新処理へ進む。
			if (isExists) {

				//	 変更後のIDが、すでに存在する他の商品と被っていないことをチェックする
				pstmt.setString(1, pib.getProductID());
				rs = pstmt.executeQuery();
				isExists = rs.next();

				// IDが未変更の場合、または変更後IDが現存する他の商品IDと被っていない場合、更新処理へ進む。
				if (pib.getSearchKey().equals(pib.getProductID()) || isExists == false) {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, pib.getProductID());
					pstmt.setString(2, pib.getProductType());
					pstmt.setString(3, pib.getProductName());
					pib.setPrice(Integer.valueOf(pib.getPriceString()));
					pstmt.setInt(4, pib.getPrice());
					pstmt.setString(5, pib.getDescription());
					pstmt.setString(6, pib.getSearchKey());
					pstmt.executeUpdate();
					con.commit();

				} else {

					throw new ProductException("1012W");
				}

			} else {
				// 	商品情報をリセット
				pib.reset();
				// 	登録がない場合はエラーメッセージをセット
				throw new ProductException("1010W");
			}
			//	 エラーが発生した場合
		} catch (SQLException e) {
			if(con != null){
				try{
					con.rollback();
				}catch(SQLException e2){
				}
			}
			throw new ProductException("1005W", e);

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