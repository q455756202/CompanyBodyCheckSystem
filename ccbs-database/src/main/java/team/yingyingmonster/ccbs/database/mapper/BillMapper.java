package team.yingyingmonster.ccbs.database.mapper;

import team.yingyingmonster.ccbs.database.bean.Bill;

import java.util.List;

public interface BillMapper {
    Bill selectByPrimaryKey(Long billid);
    int deleteByPrimaryKey(Long billid);
    int insert(Bill bill);
    int insertSelective(Bill bills);
    int updateByPrimaryKeySelective(Bill bills);
    int updateByPrimaryKey(Bill bill);
}
