package team.yingyingmonster.ccbs.database.mapper.wengguobao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Bill;

import java.util.List;

@Repository
public interface BillMapperWeng {
    List<Bill> selectByDeptIdAndUserId(@Param("deptId")Long deptid,@Param("userId")Long userid);
}
