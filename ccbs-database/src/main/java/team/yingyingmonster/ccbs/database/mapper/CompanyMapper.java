package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Company;

import java.util.List;

@Repository
public interface CompanyMapper {
    Company selectByPrimaryKey(Long companyid);
    int deleteByPrimaryKey(Long companyid);
    int insert(Company company);
    int insertSelective(Company companies);
    int updateByPrimaryKeySelective(Company companies);
    int updateByPrimaryKey(Company company);
}
