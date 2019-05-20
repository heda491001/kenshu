/*
 * Java（基本）サンプルプログラム
 *
 * Copyright(C) 株式会社ラーニングエージェンシー 2019-
 */

package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ProductInfoBean;
import bean.UserInfoBean;
import common.Message;
import common.ProductException;
import logic.AuthLogic;
import logic.DeleteLogic;
import logic.FindProductLogic;
import logic.ReferLogic;
import logic.RegistLogic;
import logic.UpdateLogic;

/**
 * 商品マスタ管理システムのサーブレット
 *
 * @author H.ARIMACHI
 */
public class ProductServlet extends HttpServlet {

	/** シリアルバージョンＩＤ */
	private static final long serialVersionUID = 1L;

	/** JSPのHomeディレクトリ */
	private final String JSP_HOME = "/WEB-INF/jsp/";
	/** ログイン画面用のパス */
	private final String A010_LOGIN = JSP_HOME + "A010_Login.jsp";
	/** メイン画面用のパス */
	private final String A020_MAIN = JSP_HOME + "A020_Main.jsp";
	/** ログアウト画面用のパス */
	private final String A030_LOGOUT = JSP_HOME + "A030_Logout.jsp";
	/** 商品登録画面用のパス */
	private final String C010_PRODUCT_REGIST = JSP_HOME + "C010_ProductRegist.jsp";
	/** 商品登録完了画面用のパス */
	private final String C015_PRODUCT_REGIST_COMPLETE = JSP_HOME + "C015_ProductRegistComplete.jsp";
	/** 商品更新画面用のパス */
	private final String C020_PRODUCT_UPDATE = JSP_HOME + "C020_ProductUpdate.jsp";
	/** 商品更新完了画面用のパス */
	private final String C025_PRODUCT_UPDATE_COMPLETE = JSP_HOME + "C025_ProductUpdateComplete.jsp";
	/** 商品削除画面用のパス */
	private final String C030_PRODUCT_DELETE = JSP_HOME + "C030_ProductDelete.jsp";
	/** 商品削除完了画面用のパス */
	private final String C035_PRODUCT_DELETE_COMPLETE = JSP_HOME + "C035_ProductDeleteComplete.jsp";
	/** 商品一覧画面用のパス */
	private final String C040_PRODUCT_REFER = JSP_HOME + "C040_ProductRefer.jsp";

	/**
	 * doGetメソッド セッションスコープの存在を確認し、存在しない場合はログイン画面へ、存在する場合はdoService（アクションメソッド）へと遷移する。
	 * セッションが存在した場合はdoServiceメソッドへと遷移する。
	 *
	 * @param request  クライアントが Servlet へ要求したリクエスト内容を含む HttpServletRequest オブジェクト
	 * @param response Servlet がクライアントに返すレスポンス内容を含む HttpServletResponse オブジェクト
	 * @throws IOException      Servlet が GET リクエストを処理している間に入出力エラーが発生した場合
	 * @throws ServletException GET に相当するリクエストが処理できない場合
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// リクエストボディに含まれる文字コードをUTF-8に設定
		request.setCharacterEncoding("UTF-8");

		// セッション取得
		HttpSession session = request.getSession(false);

		// セッションが存在しない場合
		if (null == session || null == session.getAttribute("userID")) {

			UserInfoBean uib = new UserInfoBean();

			// ユーザ情報を初期化
			uib.reset();

			// リクエストにBeanオブジェクトを属性追加する
			request.setAttribute("userInfoBean", uib);

			// 遷移先にログイン画面を指定
			RequestDispatcher dispatcher = request.getRequestDispatcher(A010_LOGIN);

			// ログイン画面に遷移
			dispatcher.forward(request, response);

			// セッションが存在した場合
		} else {

			// doServiceへ委譲
			this.doService(request, response);
		}
	}

	/**
	 * doPostメソッド セッションスコープが存在するか確認し、存在しない場合は、ログイン画面からの要求であった場合のみdoService（アクションメソッド
	 * ）へと遷移する。 セッションが存在した場合はdoServiceメソッドへと遷移する。
	 *
	 * @param request  クライアントが Servlet へ要求したリクエスト内容を含む HttpServletRequest オブジェクト
	 * @param response Servlet がクライアントに返すレスポンス内容を含む HttpServletResponse オブジェクト
	 * @throws IOException      Servlet が POST リクエストを処理している間に入出力エラーが発生した場合
	 * @throws ServletException POST に相当するリクエストが処理できない場合
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// リクエストボディに含まれる文字コードをUTF-8に設定
		request.setCharacterEncoding("UTF-8");

		// セッション取得
		HttpSession session = request.getSession(false);

		// セッションが存在しない場合
		if (session == null || session.getAttribute("userID") == null) {

			// ログインボタン押下ではない場合
			if (request.getParameter("a010_login") == null) {
				
				UserInfoBean uib = new UserInfoBean();

				// ユーザ情報を初期化
				uib.reset();

				// リクエストにBeanオブジェクトを属性追加する
				request.setAttribute("userInfoBean", uib);

				// 遷移先にログイン画面を指定
				RequestDispatcher dispatcher = request.getRequestDispatcher(A010_LOGIN);

				// ログイン画面に遷移
				dispatcher.forward(request, response);

				// ログインボタンが押下された場合
			} else {

				// ログイン処理を行うため、doServiceメソッドへと遷移
				this.doService(request, response);
			}

			// セッションが存在した場合
		} else {

			// doServiceへ委譲
			this.doService(request, response);
		}
	}

	/**
	 * dpGet,doPostより委譲されたコントローラ処理の実装メソッド
	 * request.getParameterNamesでformから送信されたリクエストを元に、実行アクションを判断し、
	 * 該当するビジネスロジック処理を実行する。 また処理結果に従い、画面遷移処理を行う。
	 *
	 * @param request  クライアントが Servlet へ要求したリクエスト内容を含む HttpServletRequest オブジェクト
	 * @param response Servlet がクライアントに返すレスポンス内容を含む HttpServletResponse オブジェクト
	 * @throws IOException      Servlet が POST/GET リクエストを処理している間に入出力エラーが発生した場合
	 * @throws ServletException POST/GET に相当するリクエストが処理できない場合
	 */
	public void doService(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// 遷移元画面ID格納用変数
		String previous_view = A010_LOGIN;
		// 商品情報用Bean
		ProductInfoBean pib = new ProductInfoBean();
		// 商品情報全件用リスト
		ArrayList<ProductInfoBean> pibList = new ArrayList<ProductInfoBean>();
		// ユーザ情報用Bean
		UserInfoBean uib = new UserInfoBean();

		// requestにBeanオブジェクトを属性追加する
		request.setAttribute("productInfoBean", pib);
		// requestにBeanオブジェクトのリストを属性追加する
		request.setAttribute("pibList", pibList);
		// requestにBeanオブジェクトを属性追加する
		request.setAttribute("userInfoBean", uib);

		// RequestDispatcherオブジェクトを作成し、初期化する
		RequestDispatcher dispatcher = null;

		try {
			// ログインボタン押下時
			if (request.getParameter("a010_login") != null) {
				// BeanにユーザIDを格納
				uib.setUserID(request.getParameter("a010_userid"));
				// Beanにパスワードを格納
				uib.setPassword(request.getParameter("a010_password"));
				// 遷移元の画面IDを変数へ格納
				previous_view = A010_LOGIN;

				AuthLogic authLogic = new AuthLogic();
				// 認証ロジックの実行
				authLogic.authLogic(uib);
				// Beanの各変数を初期化
				pib.reset();
				// セッションを作成
				HttpSession session = request.getSession(true);
				// sessionにユーザID属性を追加
				session.setAttribute("userID", uib.getUserID());
				// sessionにユーザ名属性を追加
				session.setAttribute("userName", uib.getUserName());
				// 遷移先にメイン画面を指定する
				dispatcher = request.getRequestDispatcher(A020_MAIN);

				// メイン画面にて削除ボタン押下時
			} else if (request.getParameter("a020_delete") != null) {
				// 商品IDの値をBeanに格納
				pib.setProductID(request.getParameter("a020_productID"));
				// 遷移元の画面IDを変数へ格納
				previous_view = A020_MAIN;

				FindProductLogic findProductLogic = new FindProductLogic();

				// 商品存在確認ロジックの実行
				findProductLogic.productInfoCheck(pib);
				// 遷移先に商品削除画面を指定
				dispatcher = request.getRequestDispatcher(C030_PRODUCT_DELETE);

				// 商品削除画面にて削除実行ボタン押下時
			} else if (request.getParameter("c030_delete") != null) {
				// 商品のIDの値をBeanへ格納
				pib.setProductID(request.getParameter("c030_deleteinfo"));
				// 遷移元の画面IDを変数へ格納
				previous_view = C030_PRODUCT_DELETE;

				// 商品削除処理
				DeleteLogic delete = new DeleteLogic();

				// 商品削除ロジックの実行
				delete.deleteProduct(pib);
				// 遷移先に商品削除完了画面を指定
				dispatcher = request.getRequestDispatcher(C035_PRODUCT_DELETE_COMPLETE);

				// メイン画面にて更新ボタン押下時
			} else if (request.getParameter("a020_update") != null) {
				// 商品IDの値をBeanに格納
				pib.setProductID(request.getParameter("a020_productID"));
				// 遷移元の画面IDを変数へ格納
				previous_view = A020_MAIN;
				// 商品存在確認処理
				FindProductLogic findProductLogic = new FindProductLogic();

				// 商品存在確認ロジックの実行
				findProductLogic.productInfoCheck(pib);
				// 遷移先に商品更新画面を指定
				pib.setSearchKey(pib.getProductID());
				dispatcher = request.getRequestDispatcher(C020_PRODUCT_UPDATE);

				// メイン画面にて照会ボタン押下時
			} else if (request.getParameter("a020_refer") != null) {
				// 照会キーの値をBeanに格納
				pib.setProductID(request.getParameter("a020_productID"));
				// 遷移元の画面IDを変数へ格納
				previous_view = A020_MAIN;

				ReferLogic referLogic = new ReferLogic();
				// 商品照会ロジックの実行
				if ("".equals(pib.getProductID())) {
					referLogic.productInfoSearch(pibList);
				} else {
					referLogic.productInfoSearch(pib);
					pibList.add(pib);
				}

				// 遷移先に商品一覧画面を指定
				pib.setSearchKey(pib.getProductID());
				dispatcher = request.getRequestDispatcher(C040_PRODUCT_REFER);

				// 商品更新画面にて更新実行ボタン押下時
			} else if (request.getParameter("c020_update") != null) {
				// 入力された各商品情報をBeanへ格納
				pib.setProductID(request.getParameter("c020_productID"));
				pib.setProductType(request.getParameter("c020_productType"));
				pib.setProductName(request.getParameter("c020_productName"));
				pib.setPriceString(request.getParameter("c020_price"));
				pib.setDescription(request.getParameter("c020_description"));
				pib.setSearchKey(request.getParameter("c020_keyID"));
				// 遷移元の画面IDを変数へ格納
				previous_view = C020_PRODUCT_UPDATE;

				UpdateLogic update = new UpdateLogic();

				// 商品更新ロジックの実行
				update.updateProduct(pib);
				// 遷移先に商品更新完了画面を指定
				dispatcher = request.getRequestDispatcher(C025_PRODUCT_UPDATE_COMPLETE);

				// メイン画面にて登録ボタン押下時
			} else if (request.getParameter("a020_regist") != null) {
				pib.reset();

				// 遷移先に商品登録画面を指定
				dispatcher = request.getRequestDispatcher(C010_PRODUCT_REGIST);

				// 商品登録画面にて登録実行ボタン押下時
			} else if (request.getParameter("c010_regist") != null) {
				// 入力された各商品情報をBeanへ格納
				pib.setProductID(request.getParameter("c010_productID"));
				pib.setProductType(request.getParameter("c010_productType"));
				pib.setProductName(request.getParameter("c010_productName"));
				pib.setPriceString(request.getParameter("c010_price"));
				pib.setDescription(request.getParameter("c010_description"));
				// 遷移元の画面IDを変数へ格納
				previous_view = C010_PRODUCT_REGIST;

				RegistLogic regist = new RegistLogic();
				// 商品登録ロジックの実行
				regist.addProduct(pib);
				// 遷移先に商品登録完了画面を指定
				dispatcher = request.getRequestDispatcher(C015_PRODUCT_REGIST_COMPLETE);

				// ログアウトボタン押下時
			} else if (request.getParameter("a020_logout") != null || request.getParameter("c010_logout") != null
					|| request.getParameter("c015_logout") != null || request.getParameter("c020_logout") != null
					|| request.getParameter("c025_logout") != null || request.getParameter("c030_logout") != null
					|| request.getParameter("c035_logout") != null || request.getParameter("c040_logout") != null) {
				HttpSession session = request.getSession(false);
				// ユーザIDセッションを削除
				session.removeAttribute("userID");
				// ユーザ名セッションを削除
				session.removeAttribute("userName");
				// センションを破棄
				session.invalidate();
				// 遷移先にログアウト画面を指定
				dispatcher = request.getRequestDispatcher(A030_LOGOUT);
				// メイン画面に戻るが押下された場合
			} else if (request.getParameter("c010_return") != null || request.getParameter("c015_return") != null
					|| request.getParameter("c020_return") != null || request.getParameter("c025_return") != null
					|| request.getParameter("c030_return") != null || request.getParameter("c035_return") != null
					|| request.getParameter("c040_return") != null) {
				// メイン画面用エラーメッセージ初期化処理
				pib.reset();
				// 遷移先にメイン画面を指定
				dispatcher = request.getRequestDispatcher(A020_MAIN);
				// 上記以外の場合（想定外のリクエストの場合）
			} else {
				HttpSession session = request.getSession(false);

				// ユーザIDセッションを削除
				session.removeAttribute("userID");
				// ユーザ名セッションを削除
				session.removeAttribute("userName");
				// セッションを破棄
				session.invalidate();
				// ユーザ情報を初期化
				uib.reset();
				// リクエストにBeanオブジェクトを属性追加する
				request.setAttribute("userInfoBean", uib);
				// 遷移先にログイン画面を指定
				dispatcher = request.getRequestDispatcher(A010_LOGIN);
			}

			// フォワード
			dispatcher.forward(request, response);

		} catch (ProductException e) {
			// リクエストにBeanオブジェクトを属性追加する
			request.setAttribute("message", e.getMessage());
			request.setAttribute("userInfoBean", uib);
			request.setAttribute("productInfoBean", pib);

			// 遷移先に遷移元を指定
			dispatcher = request.getRequestDispatcher(previous_view);

			// 指定先にフォワードする
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// e.printStackTrace();

			// システムエラーメッセージセット
			request.setAttribute("message", new Message().getMessage("9000E"));
		} finally {
		}
	}
}
