package team.yingyingmonster.ccbs.service.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import team.yingyingmonster.ccbs.database.bean.Teamform;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerTeamformMapper;
import team.yingyingmonster.ccbs.service.serviceinterface.GuideShowService;

import java.util.List;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 9:58 2018/11/9
 * -
 **/
public class GuideShowServiceImplement implements GuideShowService {
    @Autowired
    private JuerTeamformMapper juerTeamformMapper;

    @Override
    public List<Teamform> getTeamformList(Long companyid) {
        return juerTeamformMapper.selectTeamformByCompanyId(companyid);
    }
}
