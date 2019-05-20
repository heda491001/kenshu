/*
 * Java（基本）サンプルプログラム
 *
 * Copyright(C) 株式会社ラーニングエージェンシー 2019-
 */

package logic;

import bean.UserInfoBean;
import common.ProductException;
import dao.AuthDAO;
import util.UserValidation;

/**
 * ログインロジック
 *
 * @author N.INADA
 */
public class AuthLogic {

	/** 入力パスワード格納用変数 */
	private String password = "";

	/**
	 * ID・パスワード認証 入力されたID・パスワードと登録ID・パスワードが一致しているかを判断する
	 *
	 * @param uib UserInfoBean型のオブジェクト
	 * @throws ProductException 業務処理例外が発生した場合
	 */
	public void authLogic(UserInfoBean uib) throws ProductException {

		// 変数に入力されたパスワードの値を保存
		this.password = uib.getPassword();

		UserValidation check = new UserValidation();

		// IDの入力値をチェック
		check.idCheck(uib);

		AuthDAO DAO = new AuthDAO();

		// ユーザ情報の取得
		DAO.getUserInfo(uib);

		// 入力パスワードと登録パスワードが一致しない場合
		if (!this.password.equals(uib.getPassword())) {

				throw new ProductException("1011W");
		}

	}
}
