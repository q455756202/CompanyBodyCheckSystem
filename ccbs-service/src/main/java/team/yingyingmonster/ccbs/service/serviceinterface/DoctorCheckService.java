package team.yingyingmonster.ccbs.service.serviceinterface;

import team.yingyingmonster.ccbs.database.bean.Bill;
import team.yingyingmonster.ccbs.database.bean.ModelData;
import team.yingyingmonster.ccbs.database.bean.Report;

import java.util.List;

public interface DoctorCheckService {
    public void insertModelDataAndChangeBill(List<ModelData> modelDatas,Long billid,Long doctorid)throws Exception;
    public void insertSummaryAllReport(Bill bill, Report report)throws Exception;
}
