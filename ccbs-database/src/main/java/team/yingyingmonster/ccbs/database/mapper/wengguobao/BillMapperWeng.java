package team.yingyingmonster.ccbs.database.mapper.wengguobao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Bill;

import java.util.List;

@Repository
public interface BillMapperWeng {
    List<Bill> selectByDeptIdAndUserId(@Param("deptid") Long deptid, @Param("userid") Long userid);
    List<Bill> selectByDeptIdAndUserIdAndUserCheckId(@Param("deptid") Long deptid, @Param("userid") Long userid, @Param("usercheckid")Long usercheckid);
    int addAllSummaryBill(Bill bill);
    List<Bill> selectAllUserByDeptId(Long Deptid);
}
