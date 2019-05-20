/*
 * Ｊａｖａ（基本）サンプルプログラム
 *
 * Copyright(C) 株式会社ラーニングエージェンシー 2019-
 */
package common;


/**
 * 商品マスタ管理システム共通例外クラス
 * 当システムの例外処理を扱うクラス
 *
 * @author N.INADA
 */
public class ProductException extends Exception {

	/** メッセージID */
	private String m_messageID = "";

	/** 元の例外処理 */
	private Exception m_exceptionType;

	/** Messageクラス（メッセージ定義クラス） */
	private Message m_message;


	/**
	 * メッセージIDにより初期化されたオブジェクトを返却します。
	 *
	 * @param messageID メッセージID
	 */
	public ProductException(String messageID) {
		this.m_messageID = messageID;

		m_message = new Message();
	}

	/**
	 * メッセージID、例外オブジェクトにより初期化されたオブジェクトを返却します。
	 *
	 * @param messageID メッセージID
	 * @param exceptionType Excceptionオブジェクト
	 */
	public ProductException(String messageID, Exception exceptionType) {
		this.m_messageID = messageID;
		this.m_exceptionType = exceptionType;

		m_message = new Message();
	}

	/**
	 * メッセージの取得
	 * 当例外を新規に生成する際に設定されたメッセージＩＤに従い
	 * 該当するメッセージを返却します。
	 * 該当するメッセージが存在しない場合には、nullを返却します。
	 *
	 * @return 当クラス生成時に設定された例外オブジェクト
	 */
	public String getMessage() {
		return m_message.getMessage(m_messageID);
	}

	/**
	 * 元の例外オブジェクトの取得
	 * 当例外を新規に生成する際に、元の例外オブジェクトが設定されている場合
	 * 当メソッドは、その例外オブジェクトを返却します。
	 * 指定されていない場合には、nullを返却します。
	 * @return 当クラス生成時に設定された例外オブジェクト
	 */
	public Exception getExceptionType() {
		return this.m_exceptionType;
	}
}
