package team.yingyingmonster.ccbs.database.mapper.juergenie;

import team.yingyingmonster.ccbs.database.bean.Company;

public interface JuerCompanyMapper {
    Company selectCompanyByAccountId(Long accountid);
}
