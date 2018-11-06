package team.yingyingmonster.ccbs.database.mapper.wengguobao;

import team.yingyingmonster.ccbs.database.bean.Model;

import java.util.List;

public interface ModelMapperWeng {
    List<Model> selectByCheckId(Long checkId);
}
