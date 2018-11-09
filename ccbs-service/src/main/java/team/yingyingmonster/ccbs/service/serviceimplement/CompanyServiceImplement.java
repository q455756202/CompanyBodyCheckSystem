package team.yingyingmonster.ccbs.service.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import team.yingyingmonster.ccbs.database.bean.Company;
import team.yingyingmonster.ccbs.database.mapper.dingli.DingCompanyMapper;
import team.yingyingmonster.ccbs.service.serviceinterface.CompanyService;

/**
 * @author DingLi <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 17:11 2018/11/6
 * -
 **/

public class CompanyServiceImplement implements CompanyService {

    @Autowired
    private DingCompanyMapper dingCompanyMapper;
    @Override
    public Long addCompany(String accountName, String accountPassword) {
        return null;
    }

    @Override
    public Integer updateByPrimaryKeySelective(Company company) {
        return dingCompanyMapper.updateByPrimaryKeySelective(company);
    }
}
