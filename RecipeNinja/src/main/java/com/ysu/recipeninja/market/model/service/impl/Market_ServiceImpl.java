package com.ysu.recipeninja.market.model.service.impl;

import com.ysu.recipeninja.market.model.dao.Market_DAO;
import com.ysu.recipeninja.market.model.service.Market_Service;
import com.ysu.recipeninja.market.model.vo.Market_VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Market_ServiceImpl implements Market_Service {

    private final Market_DAO market_dao;

    @Autowired
    public Market_ServiceImpl(Market_DAO market_dao) {
        this.market_dao = market_dao;
    }

    @Override
    public Market_VO getBannerByBanner(String banner) {
        return market_dao.getBannerById(banner);
    }
}