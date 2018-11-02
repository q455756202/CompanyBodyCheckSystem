package team.yingyingmonster.ccbs.database.mapper;

import team.yingyingmonster.ccbs.database.bean.Company;

import java.util.List;

public interface CompanyMapper {
    Company selectByPrimaryKey(Long companyid);
    int deleteByPrimaryKey(Long companyid);
    int insert(Company company);
    int insertSelective(Company companies);
    int updateByPrimaryKeySelective(Company companies);
    int updateByPrimaryKey(Company company);
}
