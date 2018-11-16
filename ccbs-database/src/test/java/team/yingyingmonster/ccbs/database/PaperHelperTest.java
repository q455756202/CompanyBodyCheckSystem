package team.yingyingmonster.ccbs.database;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import team.yingyingmonster.ccbs.database.bean.Account;
import team.yingyingmonster.ccbs.database.bean.Menu;
import team.yingyingmonster.ccbs.database.mapper.AccountMapper;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerMenuMapper;
import team.yingyingmonster.ccbs.json.JsonUtil;

import java.util.List;

/**
 * @author 翁国宝 <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 15:10 2018/11/6
 * - 测试分页
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-database.xml")
public class PaperHelperTest {
    @Autowired
    private JuerMenuMapper juerMenuMapper;

    @Test
    public void paperHelperTest(){
        PageHelper.startPage(1,5);
        List<Menu> menus = juerMenuMapper.selectAllMenu();
        System.out.println(JsonUtil.beanToJson(menus, JsonUtil.TYPE.PRETTY_AND_SERIALIZE_NULL));
        PageInfo<Menu> menuPageInfo = new PageInfo<>(menus);
        System.out.print(menuPageInfo);
    }
}
