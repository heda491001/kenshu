/*
 * Java（基本）サンプルプログラム
 *
 * Copyright(C) 株式会社ラーニングエージェンシー 2019-
 */

package logic;

import bean.ProductInfoBean;
import common.ProductException;
import dao.DeleteDAO;

/**
 * 商品削除ロジック
 *
 * @author N.INADA
 */
public class DeleteLogic {

	/**
	 * 商品削除処理
	 *
	 * @param pib ProductInfoBean型のオブジェクト
	 * @throws ProductException 業務処理例外が発生した場合
	 */
	public void deleteProduct(ProductInfoBean pib) throws ProductException {

		DeleteDAO DAO = new DeleteDAO();

		// 削除処理用DAO実行
		DAO.deleteDAO(pib);

		// Beanを初期化
		pib.reset();

	}
}
