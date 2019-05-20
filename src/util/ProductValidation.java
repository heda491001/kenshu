/*
 * Java（基本）サンプルプログラム
 *
 * Copyright(C) 株式会社ラーニングエージェンシー 2019-
 */

package util;

import java.util.regex.Pattern;

import bean.ProductInfoBean;
import common.ProductException;

/**
 * 商品情報用バリデーション
 *
 * @author N.INADA
 */
public class ProductValidation {

	/**
	 * 商品IDバリデーション
	 *
	 * @param pib
	 *            ProductInfoBean型のオブジェクト
	 * @param id
	 *            商品ID
	 * @throws ProductException
	 *             入力チェックエラーが発生した場合
	 */
	public void checkProductID(ProductInfoBean pib, String id)
			throws ProductException {
		// 入力値の存在をチェック
		if (id.equals("")) {
			throw new ProductException("1013W", new Exception());
			// IDの桁数をチェック
		} else if (id.length() != 8) {
			throw new ProductException("1014W", new Exception());
		}
		// 文字タイプチェック
		else if (id.matches("^[a-zA-Z0-9]*$") != true) {
			throw new ProductException("1015W", new Exception());
		}

	}

	/**
	 * 商品分類バリデーション
	 *
	 * @param pib
	 *            ProductInfoBean型のオブジェクト
	 * @throws ProductException
	 *             入力チェックエラーが発生した場合
	 */
	public void checkProductType(ProductInfoBean pib) throws ProductException {
		String type = pib.getProductType();

		// 入力値の存在をチェック
		if (type.equals("")) {
			throw new ProductException("1016W", new Exception());
			// 文字数をチェック
		} else if (10 < type.length()) {
			throw new ProductException("1017W", new Exception());
		}
		// 文字タイプチェック（全角文字以外の場合false）
		else if (type.matches("^[^ -~｡-ﾟ]+$") != true) {
			throw new ProductException("1018W", new Exception());
		}

	}

	/**
	 * 商品名
	 *
	 * @param pib
	 *            ProductInfoBean型のオブジェクト
	 * @throws ProductException
	 *             入力チェックエラーが発生した場合
	 */
	public void checkProductName(ProductInfoBean pib) throws ProductException {
		String name = pib.getProductName();

		// 入力値の存在をチェック
		if (name.equals("")) {
			throw new ProductException("1019W", new Exception());
			// 文字数をチェック
		} else if (50 < name.length()) {
			throw new ProductException("1020W", new Exception());
		}

	}

	/**
	 * 商品価格バリデーション
	 *
	 * @param pib
	 *            ProductInfoBean型のオブジェクト
	 * @throws ProductException
	 *             入力チェックエラーが発生した場合
	 */
	public void checkPrice(ProductInfoBean pib) throws ProductException {
		String price = pib.getPriceString();
		// 入力値にコンマがあれば取り除く
		if (price.indexOf(",") != -1) {
			price = Pattern.compile(",").matcher(price).replaceAll("");
			pib.setPriceString(price);
		}
		// 入力値の存在をチェック
		if (price.equals("")) {
			throw new ProductException("1021W", new Exception());
			// 価格の桁数をチェック
		} else if (9 < price.length()) {
			throw new ProductException("1022W", new Exception());
			// 文字タイプチェック
		} else if (price.matches("^[0-9]*$") != true) {
			throw new ProductException("1023W", new Exception());
		}
	}

	/**
	 * 商品説明バリデーション
	 *
	 * @param pib
	 *            ProductInfoBean型のオブジェクト
	 * @throws ProductException
	 *             入力チェックエラーが発生した場合
	 */
	public void checkDescription(ProductInfoBean pib) throws ProductException {
		String description = pib.getDescription();

		// 入力値がある場合
		if (!(description.equals(""))) {
			if (200 < description.length()) {
				throw new ProductException("1024W", new Exception());
			}

		}
	}
}
