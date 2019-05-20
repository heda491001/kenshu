/*
 * Ｊａｖａ（基本）サンプルプログラム
 *
 * Copyright(C)  * Copyright(C) 株式会社ラーニングエージェンシー 2019-
 */
package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB接続用共通クラス
 * 当クラスでは、DB接続に必要な識別子の定義および、
 * Connectionオブジェクトを取得するためのメソッドを提供します。
 * @author H.ARIMACHI
 */
public class DBConnect {

	/** DB接続用：mysql用JDBCドライバ */
	private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	/** DB接続用：ホスト識別子 */
	private static final String HOST = "localhost:3306";
	/** DB接続用識別子：DB名 */
	private static final String DBNAME = "product_master";
	/** DB接続用識別子：DB接続ユーザ名 */
	private static final String USER = "yduser";
	/** DB接続用識別子：DB接続パスワード */
	private static final String PASSWORD = "yduser";
	/** DB接続用識別子：DB接続URL */
	private static final String URL = "jdbc:mysql://" + HOST + "/" + DBNAME + "";

	/**
	 * Connectionオブジェクト取得
	 * DBへの接続するためのConnectionオブジェクトを返却します。
	 *
	 * @return DB接続用のConnectionオブジェクト
	 */
	public static Connection getConnection() throws ProductException{

		Connection con = null;

		try {

			Class.forName(COM_MYSQL_JDBC_DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (SQLException e) {

			throw new ProductException("9000E", e);

		} catch (ClassNotFoundException e) {

			throw new ProductException("9000E", e);
		}

		return (con);

	}
}
