package team.yingyingmonster.ccbs.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerUserMapper;
import team.yingyingmonster.ccbs.json.JsonUtil;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 14:53 2018/11/12
 * -
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-database.xml")
@Transactional
@Rollback(true)
public class JuerUserMapperTest {
    @Autowired
    private JuerUserMapper juerUserMapper;

    @Test
    public void selectJuerUserByUserCheckIdTest() {
        System.out.println(JsonUtil.beanToJson(juerUserMapper.selectJuerUserByUsercheckid(230l), JsonUtil.TYPE.PRETTY_AND_SERIALIZE_NULL));
    }
}
