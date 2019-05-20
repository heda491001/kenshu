/*
 * Java（基本）サンプルプログラム
 *
 * Copyright(C) 株式会社ラーニングエージェンシー 2019-
 */

package logic;

import java.util.ArrayList;

import bean.ProductInfoBean;
import common.ProductException;
import dao.FindProductDAO;

/**
 * 商品照会ロジック
 *
 * @author N.INADA
 */
public class ReferLogic {

	/**
	 * 商品照会メソッド（商品ＩＤ指定）
	 *
	 * @param pib ProductInfoBean型のオブジェクト
	 * @throws ProductException 業務処理例外
	 */
	public void productInfoSearch(ProductInfoBean pib) throws ProductException {
		// 照会用キー値
		String key = "";

		key = pib.getProductID();


	    FindProductDAO DAO = new FindProductDAO();

		// 商品IDをキーに商品情報を照会
		DAO.getProductInfo(pib , key);

	}

	/**
	 * 商品照会メソッド（全件取得用）
	 *
	 * @param pibList ProductInfoBean配列
	 * @throws ProductException 業務処理例外
	 */
	public void productInfoSearch(ArrayList<ProductInfoBean> pibList) throws ProductException {
		// 照会用キー値
		String key = "";

	    FindProductDAO DAO = new FindProductDAO();

		// 商品IDをキーに商品情報を照会
		DAO.getProductInfo(pibList, key);
	}
}
