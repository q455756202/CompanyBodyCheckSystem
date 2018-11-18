package team.yingyingmonster.ccbs.service.serviceinterface;

import team.yingyingmonster.ccbs.database.bean.*;
import team.yingyingmonster.ccbs.database.bean.juergenie.JuerCombo;
import team.yingyingmonster.ccbs.database.bean.juergenie.JuerCompanyCheckEntity;
import team.yingyingmonster.ccbs.database.bean.juergenie.JuerUser;

import java.util.List;

public interface JuerCompanyCheckSystemService {
    JuerCompanyCheckEntity getCompanyCheckEntity(Long accountid);
    boolean registerCompanyCheck(Account account, JuerCompanyCheckEntity juerCompanyCheckEntity) throws Exception;
    Double getCompanyCheckPrice(List<JuerCombo> comboList);
    JuerCombo addCustomCombo(List<Check> checkList) throws Exception;
    List<JuerUser> getJuerUser(Long companyid);
    List<JuerUser> getJuerUsersByTeamformId(Long teamformid);
    byte[] getUserQrcodeByteArray(UserCheck user);
}
