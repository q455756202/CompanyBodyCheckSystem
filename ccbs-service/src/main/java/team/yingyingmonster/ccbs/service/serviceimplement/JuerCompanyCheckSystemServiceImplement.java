package team.yingyingmonster.ccbs.service.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.yingyingmonster.ccbs.database.bean.User;
import team.yingyingmonster.ccbs.database.mapper.CompanyMapper;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerComboMapper;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerUserMapper;
import team.yingyingmonster.ccbs.database.bean.juergenie.JuerCompanyCheckEntity;
import team.yingyingmonster.ccbs.service.serviceinterface.JuerCompanyCheckSystemService;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 16:36 2018/11/4
 * - 提供团检报名的服务。
 **/
@Service
public class JuerCompanyCheckSystemServiceImplement implements JuerCompanyCheckSystemService {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private JuerComboMapper juerComboMapper;
    @Autowired
    private JuerUserMapper juerUserMapper;

    /**
     * 获取团检报名用的实体，这个实体用于传输到前台，供前端进行数据操作。
     * @param companyEntity
     * @return
     */
    @Override
    public JuerCompanyCheckEntity getCompanyCheckEntity(Long companyid) {
        JuerCompanyCheckEntity entity = new JuerCompanyCheckEntity();
        entity.setCompany(companyMapper.selectByPrimaryKey(companyid));
        entity.setComboList(juerComboMapper.selectAllJuerCombo());
        User condition = new User();
        condition.setCompanyid(companyid);
        entity.setUserList(juerUserMapper.selectUsersByCondition(condition));
        return entity;
    }
}
