/*
 * Ｊａｖａ（基本）サンプルプログラム
 *
 * Copyright(C) 株式会社ラーニングエージェンシー 2019-
 */
package common;

import java.util.HashMap;

/**
 * メッセージ定義クラス
 * 画面表示用メッセージを定義し、それを取得するためのメソッドを提供します
 *
 * @author N.INADA
 */
public class Message {


	/** メッセージ格納用HashMap Key：メッセージID、Value：メッセージ */
	final HashMap<String, String> m_messageMap;

	/**
	 * コンストラクタ
	 * m_messageMapを初期化します。
	 * m_messageMap = Key：メッセージID、Value：メッセージ
	 */
	public Message() {
		m_messageMap = new HashMap<String, String>();
		m_messageMap.clear();

		m_messageMap.put("1001W", "登録のないIDです。正しいユーザーIDを入力してください。");
		m_messageMap.put("1002W", "ログイン認証に失敗しました。");
		m_messageMap.put("1003W", "すでに登録のある商品IDです。");
		m_messageMap.put("1004W", "商品登録に失敗しました。");
		m_messageMap.put("1005W", "商品更新に失敗しました。");
		m_messageMap.put("1006W", "商品削除に失敗しました。");
		m_messageMap.put("1007W", "商品照会に失敗しました。");
		m_messageMap.put("1008W", "削除する商品が存在しません。もう一度メイン画面からやり直して下さい。");
		m_messageMap.put("1009W", "登録のない商品IDです。正しいIDを入力してください。");
		m_messageMap.put("1010W", "更新する商品が存在しません。もう一度メイン画面からやり直して下さい。");
		m_messageMap.put("1011W", "パスワードが誤っています。正しいパスワードを入力してください。");
		m_messageMap.put("1012W", "すでに登録のある商品IDです。");
		m_messageMap.put("1013W", "商品ＩＤを入力してください。");
		m_messageMap.put("1014W", "商品ＩＤは8桁で入力してください。");
		m_messageMap.put("1015W", "商品ＩＤは半角英数字で入力してください。");
		m_messageMap.put("1016W", "商品分類を入力してください。");
		m_messageMap.put("1017W", "商品分類は10文字以内で入力してください。");
		m_messageMap.put("1018W", "商品分類は全角文字で入力してください。");
		m_messageMap.put("1019W", "商品名を入力してください。");
		m_messageMap.put("1020W", "商品名は50文字以内で入力してください。");
		m_messageMap.put("1021W", "商品価格を入力してください。");
		m_messageMap.put("1022W", "商品価格は9桁以内で入力してください。");
		m_messageMap.put("1023W", "商品価格は半角数字で入力してください。");
		m_messageMap.put("1024W", "商品説明は200文字以内で入力してください。");
		m_messageMap.put("1025W", "ユーザＩＤを入力してください。");
		m_messageMap.put("1026W", "ユーザＩＤは5桁以内で入力してください。");
		m_messageMap.put("1027W", "ユーザＩＤは半角英数字で入力してください。");
		m_messageMap.put("9000E", "システムエラーが発生しました。");
	}


	/**
	 * メッセージの取得メソッド
	 * 引数のメッセージＩＤに該当するメッセージを返却します。
	 *
	 * @param messageID メッセージＩＤ
	 * @return 引数のメッセージIDに該当するメッセージ
	 */
	public String getMessage(String messageID) {
		return m_messageMap.get(messageID);
	}
}
