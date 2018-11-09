package team.yingyingmonster.ccbs.service.serviceinterface;

import team.yingyingmonster.ccbs.database.bean.Company;

public interface CompanyService {
    Long addCompany(String accountName,String accountPassword);
    Integer updateByPrimaryKeySelective(Company company);
}
