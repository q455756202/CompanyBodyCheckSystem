package team.yingyingmonster.ccbs.database.mapper.juergenie;

import team.yingyingmonster.ccbs.database.bean.Bill;

import java.util.List;

public interface JuerBillMapper {
    Long getNewId();
    int insertBatch(List<Bill> list);
}
