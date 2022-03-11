package com.wanxi.service.impl;

import com.wanxi.dao.TeamDao;
import com.wanxi.dao.impl.TeamImpl;
import com.wanxi.model.TeamModel;
import com.wanxi.service.TeamService;

import java.util.List;

public class TeamServiceImpl implements TeamService {
    @Override
    public List<TeamModel> getTeamModelList() {
        TeamDao teamDao = new TeamImpl();
        return teamDao.getTeamModelList();
    }
}
