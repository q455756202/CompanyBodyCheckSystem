package team.yingyingmonster.ccbs.service.serviceinterface;

import team.yingyingmonster.ccbs.database.bean.juergenie.JuerCompanyCheckEntity;

public interface JuerCompanyCheckSystemService {
    JuerCompanyCheckEntity getCompanyCheckEntity(Long accountid);
    boolean registerCompanyCheck(JuerCompanyCheckEntity juerCompanyCheckEntity) throws Exception;
}
