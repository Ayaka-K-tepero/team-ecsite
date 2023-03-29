package jp.co.internous.plum.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.plum.model.domain.MstCategory;
import jp.co.internous.plum.model.domain.MstProduct;
import jp.co.internous.plum.model.form.SearchForm;
import jp.co.internous.plum.model.mapper.MstCategoryMapper;
import jp.co.internous.plum.model.mapper.MstProductMapper;
import jp.co.internous.plum.model.session.LoginSession;

@Controller
@RequestMapping("/plum")
public class IndexController {

	@Autowired
	private MstCategoryMapper CategoryMapper;

	@Autowired
	private MstProductMapper ProductMapper;

	@Autowired
	private LoginSession loginSession;

	@RequestMapping("/")
	public String index(Model m) {

		// index.html（トップページ）の表示
		// 検索機能はsearchItemメソッドにて

		// 未ログイン状態かつ仮ユーザーIDを保持していない場合
		// 仮ユーザーID＝負の9桁のランダムな数字を作成し、セッションに保持する
		if (!loginSession.isLogined() && loginSession.getTmpUserId() == 0) {
			int tmpUserId = new Random().nextInt(1_000_000_000);
			tmpUserId *= -1;
			loginSession.setTmpUserId(tmpUserId);
		}

		// カテゴリ選択

		// カテゴリ選択の表示に必要な情報は、category_name
		// mst_categoryの情報を全て取得
		List<MstCategory> categories = CategoryMapper.findAll();

		// カテゴリ選択表示
		m.addAttribute("categories", categories);

		// 商品表示機能

		// 商品表示に必要な情報
		List<MstProduct> products = ProductMapper.findAll();
		m.addAttribute("products", products);

		// ヘッダーでSession情報が必要
		m.addAttribute("loginSession", loginSession);

		// 初期表示で必要
		m.addAttribute("selected", 0);

		return "index";
	}

	// 検索した内容はSearchItemにて処理
	@RequestMapping("/searchItem")
	public String searchItem(SearchForm f, Model m) {

		// 検索機能に関する処理→つまり検索ボタンを押した時の処理

		// null→この後定義するため
		List<MstProduct> products = null;

		// カテゴリ選択表示取得
		List<MstCategory> categories = CategoryMapper.findAll();

		// 検索ワード変換
		// 全角スペースを半角スペース、スペース2個以上を1個に修正、先頭と末尾のスペース削除
		String keywords = f.getKeywords().replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();

		// カテゴリ未選択時と、カテゴリ・商品名どちらも指定して検索時と条件作成
		if (f.getCategory() == 0) {
			// カテゴリ未選択の場合
			products = ProductMapper.findByProductName(keywords.split(" "));
		} else {
			// カテゴリも商品名も指定した場合
			products = ProductMapper.findByCategoryIdAndProductName(f.getCategory(), keywords.split(" "));
		}

		// 検索ワード変換
		m.addAttribute("keywords", keywords);

		// 商品情報
		m.addAttribute("products", products);

		// カテゴリ選択
		m.addAttribute("categories", categories);

		// 選択したカテゴリの取得用
		m.addAttribute("selected", f.getCategory());

		// ヘッダーで使用するログインセッション
		m.addAttribute("loginSession", loginSession);

		return "index";
	}

}
