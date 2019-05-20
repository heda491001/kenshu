/*
 * Java（基本）サンプルプログラム
 *
 * Copyright(C)  * Copyright(C) 株式会社ラーニングエージェンシー 2019-
 */
package bean;

/**
 * ユーザ情報格納用Bean
 *
 * @author N.INADA
 */

public class UserInfoBean {

	/** ユーザID */
	private String userID = "";
	/** ユーザ名 */
	private String userName = "";
	/** パスワード */
	private String password = "";

	/**
	 * ユーザ情報リセット
	 *
	 */
	public void reset() {
		this.userID = "";
		this.password = "";
	}

	/**
	 * ユーザID取得
	 *
	 * @return userID : ユーザID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * ユーザID設定
	 *
	 * @param id : ユーザID
	 */
	public void setUserID(String id) {
		this.userID = id;
	}

	/**
	 * ユーザ名取得
	 *
	 * @return userName : ユーザ名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * ユーザ名設定
	 *
	 * @param userName : ユーザ名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * ユーザパスワード取得
	 *
	 * @return password : ユーザパスワード
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * ユーザパスワード設定
	 *
	 * @param pass : ユーザパスワード
	 */
	public void setPassword(String pass) {
		this.password = pass;
	}
}