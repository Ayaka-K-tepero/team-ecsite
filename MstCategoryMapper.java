package jp.co.internous.plum.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.plum.model.domain.MstCategory;

@Mapper
public interface MstCategoryMapper {

	// mst_categoryテーブルから情報取得
	@Select("SELECT * FROM mst_category ")
	List<MstCategory> findAll();

}
