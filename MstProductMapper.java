package jp.co.internous.plum.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.plum.model.domain.MstProduct;

@Mapper
public interface MstProductMapper {

	// 商品表示に使う情報→html側で表示情報選択
	@Select("SELECT * FROM mst_product")
	List<MstProduct> findAll();

	// 商品名のみで検索するときに使う情報
	List<MstProduct> findByProductName(@Param("keywords") String[] keywords);

	// 商品名とカテゴリで検索する際に使う情報
	List<MstProduct> findByCategoryIdAndProductName(@Param("category") int category,
			@Param("keywords") String[] keywords);

	// カテゴリのみで検索はMstCategoryMapperでやってるので不要

	// MstProductControllerに渡す情報
	@Select("SELECT * FROM mst_product WHERE id = #{id}")
	MstProduct findById(int id);

}
