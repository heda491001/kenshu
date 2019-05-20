/*
 * Java（基本）サンプルプログラム
 *
 * Copyright(C) 株式会社ラーニングエージェンシー 2019-
 */


package bean;

/**
 * 商品情報格納用Bean
 *
 * @author N.INADA
 */
public class ProductInfoBean{

	/** 商品ID */
	private String productID;
	/** 商品分類 */
	private String productType;
	/** 商品名 */
	private String productName;
	/** 商品価格 */
	private int price;
	/** 商品価格(文字列) 登録時の入力チェック時に使用 */
	private String priceString;
	/** 商品説明 */
	private String description;
	/** 登録日 */
	private String insertDate;
	/** 更新日 */
	private String updateDate;


	/** 検索キー */
	private String searchKey;

	/**
	 * 商品情報リセット
	 */
	public void reset(){
		this.productID = "";
		this.productType = "";
		this.productName = "";
		this.price = 0;
		this.priceString = "";
		this.description = "";
		this.insertDate = "";
		this.updateDate = "";
		this.searchKey = "";
	}


	/**
	 * 商品ID取得
	 * @return productID: 商品ID
	 */
    public String getProductID(){
        return productID;
    }

	/**
	 * 商品ID設定
	 * @param id : 商品ID
	 */
    public void setProductID(String id){
    	this.productID = id;
    }

	/**
	 * 商品分類取得
	 * @return producyType : 商品分類
	 */
    public String getProductType(){
        return productType;
    }

	/**
	 * 商品分類設定
	 * @param type : 商品分類
	 */
    public void setProductType(String type){
    	this.productType = type;
    }

	/**
	 * 商品名取得
	 * @return productName : 商品名
	 */
    public String getProductName(){
        return productName;
    }

	/**
	 * 商品名設定
	 * @param name :商品名
	 */
    public void setProductName(String name){
    	this.productName = name;
    }

	/**
	 * 商品価格取得
	 * @return price : 商品価格
	 */
    public int getPrice(){
        return price;
    }

	/**
	 * 商品価格設定
	 * @param price : 商品価格
	 */
    public void setPrice(int price){
    	this.price = price;
    }

	/**
	 * 商品価格取得
	 * @return priceString : 商品価格(文字列)
	 */
    public String getPriceString(){
        return priceString;
    }

	/**
	 * 商品価格設定
	 * @param priceString : 商品価格(文字列)
	 */
    public void setPriceString(String priceString){
    	this.priceString = priceString;
    }

	/**
	 * 商品説明取得
	 * @return description : 商品説明
	 */
    public String getDescription(){
        return description;
    }

	/**
	 * 商品説明設定
	 * @param dsp : 商品説明
	 */
    public void setDescription(String dsp){
    	this.description = dsp;
    }

	/**
	 * 商品登録日取得
	 * @return insertDate : 登録日
	 */
    public String getInsertDate(){
        return insertDate;
    }

	/**
	 * 商品登録日設定
	 * @param date : 登録日
	 */
    public void setInsertDate(String date){
    	this.insertDate = date;
    }

	/**
	 * 商品更新日取得
	 * @return updateDate : 更新日
	 */
    public String getUpdateDate(){
        return updateDate;
    }

	/**
	 * 商品更新日設定
	 * @param date : 更新日
	 */
    public void setUpdateDate(String date){
    	this.updateDate = date;
    }

	/**
	 * 商品検索キー取得
	 * @return searchKey : 商品ID
	 */
    public String getSearchKey(){
        return searchKey;
    }

	/**
	 * 商品検索キー設定
	 * @param key : 商品ID
	 */
    public void setSearchKey(String key){
    	this.searchKey = key;
    }
}
