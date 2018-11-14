package team.yingyingmonster.ccbs.database.mapper.zhw;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Company;

@Repository
public interface ZhaoCompanyMapper {
    Integer addCompany(Company company);
    Company selectCompany(Long accountId);
}
