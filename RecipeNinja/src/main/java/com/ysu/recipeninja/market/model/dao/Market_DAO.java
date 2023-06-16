package com.ysu.recipeninja.market.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ysu.recipeninja.market.model.vo.Market_VO;

@Mapper
public interface Market_DAO {
    @Select("SELECT * FROM banner WHERE banner = #{banner}")
    Market_VO getBannerById(String banner);
}