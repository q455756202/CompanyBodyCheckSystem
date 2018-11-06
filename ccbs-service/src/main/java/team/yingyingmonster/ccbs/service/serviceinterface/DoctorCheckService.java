package team.yingyingmonster.ccbs.service.serviceinterface;

import team.yingyingmonster.ccbs.database.bean.ModelData;

import java.util.List;

public interface DoctorCheckService {
    public void insertModelDataAndChangeBill(List<ModelData> modelDatas,Long billid)throws Exception;
}
