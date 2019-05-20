/*
 * Java（基本）サンプルプログラム
 *
 * Copyright(C) 株式会社ラーニングエージェンシー 2019-
 */

package logic;

import bean.ProductInfoBean;
import common.ProductException;
import dao.FindProductDAO;
import util.ProductValidation;

/**
 * 商品照会ロジック（１データ専用）
 *
 * @author N.INADA
 */
public class FindProductLogic {


	/**
	 * 商品存在確認・照会メソッド（１データ専用）
	 *
	 * @param pib ProductInfoBean型のオブジェクト
	 * @throws ProductException 業務処理例外
	 */
	public void productInfoCheck(ProductInfoBean pib) throws ProductException {

		// 検索用キー値
		String key = "";

		// 入力元チェック
		//商品IDテキストボックスの値をキーにする。
		if (pib.getProductID() != null) {

			key = pib.getProductID();

		} else if (pib.getSearchKey() != null) {

			key = pib.getSearchKey();
		}


		ProductValidation check = new ProductValidation();

		// 入力チェック実行
		check.checkProductID(pib, key);

		// メイン画面に表示する値を設定
		if (pib.getProductID() == null) {

			pib.setProductID("");

		} else if (pib.getSearchKey() == null) {

			pib.setSearchKey("");
		}


		FindProductDAO DAO = new FindProductDAO();

		// 商品IDをキーに商品情報を照会
		DAO.getProductInfo(pib , key);

		// 商品説明が未記入（null）の場合は空白にリセット
		if (pib.getDescription() == null) {

			pib.setDescription("");
		}

		// 更新日時が未記入（null）の場合は空白にリセット
		if (pib.getUpdateDate() == null) {

			pib.setUpdateDate("-");
		}

	}
}
