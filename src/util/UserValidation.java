/*
 * Java（基本）サンプルプログラム
 *
 * Copyright(C) 株式会社ラーニングエージェンシー 2019-
 */

package util;

import bean.UserInfoBean;
import common.ProductException;

/**
 * ユーザ情報用バリデーション
 *
 * @author N.INADA
 */
public class UserValidation {

	/**
	 * ユーザIDバリデーション
	 * @param uib    UserInfoBean型のオブジェクト
	 * @throws ProductException 入力チェックエラーが発生した場合
	 */
	public void idCheck(UserInfoBean uib) throws ProductException {

		String id = uib.getUserID();

		// ID入力値の存在をチェック
		if (id.equals("")) {
			throw new ProductException("1025W", new Exception());

		// IDの桁数をチェック
		} else if (id.length() > 5) {
			throw new ProductException("1026W", new Exception());

		// 文字タイプチェック（半角英数以外の場合false）
		} else if (id.matches("^[a-zA-Z0-9]*$") != true) {
			throw new ProductException("1027W", new Exception());
		}

	}
}
