package com.wanxi.dao.impl;

import com.wanxi.dao.TeamDao;
import com.wanxi.model.TeamModel;
import com.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeamImpl implements TeamDao {
    @Override
    public List<TeamModel> getTeamModelList() {
//        String sql="select * from lv_shi_team left join lv_shi_teamid on lv_shi_team.team_id=lv_shi_teamid.id ";
        String sql="SELECT p.*,c.name teamTypeName FROM lv_shi_team p left join lv_shi_teamid c on  p.team_id=c.id";
        List<TeamModel> list = new ArrayList<>();
        ResultSet resultSet = JDBC.getRs(sql);
        try{
            while (resultSet.next()){
                TeamModel teamModel = new TeamModel();
                teamModel.setImg_href(resultSet.getString("img_href"));
                teamModel.setName(resultSet.getString("name"));
//                teamModel.setPeo(resultSet.getString("peo"));
                teamModel.setPeo(resultSet.getString("teamTypeName"));
                teamModel.setContent(resultSet.getString("content"));
                list.add(teamModel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
