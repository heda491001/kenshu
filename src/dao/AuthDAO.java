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

import bean.UserInfoBean;
import common.DBConnect;
import common.ProductException;

/**
 * ユーザ情報照会用クラス
 *
 * @author H.ARIMACHI
 */
public class AuthDAO {

	/**
	 * ユーザ情報検索メソッド 入力されたユーザIDと一致するユーザ情報を取得する。
	 *
	 * @param uib UserInfoBean型のオブジェクト
	 * @throws ProductException DB接続エラー、SQLExceptionが発生した場合
	 */
	public void getUserInfo(UserInfoBean uib) throws ProductException {

		Connection con = null;
		try {

			// DBに接続
			con = DBConnect.getConnection();

			// SELECT文を準備
			String sql = "SELECT user_id, user_name, password FROM yd_user WHERE user_id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			// 検索キーを設定
			pstmt.setString(1, uib.getUserID());
			// SQLを実行し、結果をrsに格納
			ResultSet rs = pstmt.executeQuery();
			boolean isExists = rs.next();

			// 一致するIDが存在していればユーザ名、パスワードを取得
			if (isExists) {
				// ユーザ名をBeanに格納
				uib.setUserName(rs.getString("user_name"));
				// パスワードをBeanに格納
				uib.setPassword(rs.getString("password"));

				// 存在しない場合はエラーとする
			} else {

				throw new ProductException("1001W");
			}
		} catch (SQLException e) {

			throw new ProductException("1002W", e);

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
