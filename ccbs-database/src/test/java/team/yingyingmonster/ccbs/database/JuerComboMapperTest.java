package team.yingyingmonster.ccbs.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerComboMapper;
import team.yingyingmonster.ccbs.json.JsonUtil;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 14:18 2018/11/4
 * -
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-database.xml")
public class JuerComboMapperTest {
    @Autowired
    private JuerComboMapper juerComboMapper;

    @Test
    public void selectAllComboTest() {
        System.out.println(JsonUtil.beanToJson(juerComboMapper.selectAllCombo(), JsonUtil.TYPE.PRETTY_AND_SERIALIZE_NULL));
    }
}
