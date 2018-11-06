package team.yingyingmonster.ccbs.database.mapper.wengguobao;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Doctor;

@Repository
public interface DoctorMapperWeng {
    Doctor selectDeptByAccountId(Long AccountId);
}
