package team.yingyingmonster.ccbs.service.serviceinterface;

import team.yingyingmonster.ccbs.database.bean.Teamform;

import java.util.List;

public interface GuideShowService {
    List<Teamform> getTeamformList(Long companyid);
}
