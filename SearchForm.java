package jp.co.internous.plum.model.form;

import java.io.Serializable;

public class SearchForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//商品名（検索ワード）→keywords、カテゴリ→category
	
	private String keywords;
	private int category;
	
	
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	
	

}
