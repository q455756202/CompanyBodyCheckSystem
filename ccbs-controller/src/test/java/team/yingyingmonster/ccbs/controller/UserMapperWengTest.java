package team.yingyingmonster.ccbs.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import team.yingyingmonster.ccbs.database.bean.User;
import team.yingyingmonster.ccbs.database.mapper.wengguobao.UserMapperWeng;

/**
 * @author 翁国宝 <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 14:54 2018/11/2
 * - 用户表数据库操作测试
 **/

@Controller
public class UserMapperWengTest {
    @Autowired
    private UserMapperWeng userMapperWeng;

    @Test
    public void testSelect(){
        User user = userMapperWeng.selectUserByUserId(1l);
    }
}
