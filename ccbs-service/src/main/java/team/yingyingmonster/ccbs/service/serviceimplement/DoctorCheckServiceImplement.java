package team.yingyingmonster.ccbs.service.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.yingyingmonster.ccbs.database.bean.Bill;
import team.yingyingmonster.ccbs.database.bean.ModelData;
import team.yingyingmonster.ccbs.database.mapper.BillMapper;
import team.yingyingmonster.ccbs.database.mapper.wengguobao.ModelDataMapperWeng;
import team.yingyingmonster.ccbs.service.serviceinterface.DoctorCheckService;

import java.util.List;

/**
 * @author 翁国宝 <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 9:21 2018/11/6
 * - 实现细项数据表批量插入同时更新对应账单状态
 **/

@Service
public class DoctorCheckServiceImplement implements DoctorCheckService {
    @Autowired
    private ModelDataMapperWeng modelDataMapperWeng;
    @Autowired
    private BillMapper billMapper;
    @Override
    public void insertModelDataAndChangeBill(List<ModelData> modelDatas, Long billid) throws Exception{
        Bill bill = new Bill();
        bill.setBillid(billid);
        bill.setBillstate((short)2);
        int a = modelDataMapperWeng.insertInBatch(modelDatas);
        int b = billMapper.updateByPrimaryKeySelective(bill);
        if (a==0 || b==0){
            throw new Exception();
        }
    }

}
