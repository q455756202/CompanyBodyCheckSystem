package team.yingyingmonster.ccbs.database.mapper.wengguobao;

import team.yingyingmonster.ccbs.database.bean.ModelData;

import java.util.List;

public interface ModelDataMapperWeng {
    int insertInBatch(List<ModelData> modelDatas);
}
