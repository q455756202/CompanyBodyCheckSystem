package team.yingyingmonster.ccbs.service.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.yingyingmonster.ccbs.database.mapper.CompanyMapper;
import team.yingyingmonster.ccbs.service.servicebean.companychecksystem.JuerCompanyCheckEntity;
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

    /**
     * 获取团检报名用的实体，这个实体用于传输到前台，供前端进行数据操作。
     * @param companyEntity
     * @return
     */
    @Override
    public JuerCompanyCheckEntity getCompanyCheckEntity(Long companyid) {
        JuerCompanyCheckEntity entity = new JuerCompanyCheckEntity();

        return null;
    }
}
