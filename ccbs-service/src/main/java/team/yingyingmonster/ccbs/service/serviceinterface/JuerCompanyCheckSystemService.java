package team.yingyingmonster.ccbs.service.serviceinterface;

import team.yingyingmonster.ccbs.database.bean.Check;
import team.yingyingmonster.ccbs.database.bean.juergenie.JuerCombo;
import team.yingyingmonster.ccbs.database.bean.juergenie.JuerCompanyCheckEntity;

import java.util.List;

public interface JuerCompanyCheckSystemService {
    JuerCompanyCheckEntity getCompanyCheckEntity(Long accountid);
    boolean registerCompanyCheck(JuerCompanyCheckEntity juerCompanyCheckEntity) throws Exception;
    JuerCombo addCustomCombo(List<Check> checkList) throws Exception;
}
