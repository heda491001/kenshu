/*
 * Java（基本）サンプルプログラム
 *
 * Copyright(C) 株式会社ラーニングエージェンシー 2019-
 */

package logic;

import bean.ProductInfoBean;
import common.ProductException;
import dao.UpdateDAO;
import util.ProductValidation;

/**
 * 商品情報更新ロジック
 *
 * @author N.INADA
 */
public class UpdateLogic {

	/**
	 * 商品情報更新メソッド
	 *
	 * @param pib ProductInfoBean型のオブジェクト
	 * @throws ProductException 業務処理例外が発生した場合
	 */
	public void updateProduct(ProductInfoBean pib) throws ProductException {

		ProductValidation check = new ProductValidation();

		// ID入力値チェック
		check.checkProductID(pib, pib.getProductID());
		// 分類入力値チェック
		check.checkProductType(pib);
		// 商品名入力値チェック
		check.checkProductName(pib);
		// 価格入力値チェック
		check.checkPrice(pib);
		// 商品説明入力値チェック
		check.checkDescription(pib);


		UpdateDAO DAO = new UpdateDAO();

		// 更新処理用DAOの実行
		DAO.updateDAO(pib);

		//Beanを初期化
		pib.reset();
	}
}
