package team.yingyingmonster.ccbs.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerBillMapper;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerUserCheckMapper;
import team.yingyingmonster.ccbs.json.JsonUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 15:49 2018/11/7
 * -
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-database.xml")
public class JuerGetNewIdTest {
    @Autowired
    private JuerUserCheckMapper juerUserCheckMapper;
    @Autowired
    private JuerBillMapper juerBillMapper;

    @Test
    @Transactional
    public void userCheckGetNewIdTest() {
        List<Long> ids = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            ids.add(juerUserCheckMapper.getNewId());
        }
        System.out.println(JsonUtil.beanToJson(ids, JsonUtil.TYPE.PRETTY_AND_SERIALIZE_NULL));
    }

    @Test
    @Transactional
    public void billGetNewIdTest() {
        List<Long> ids = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            ids.add(juerBillMapper.getNewId());
        }
        System.out.println(JsonUtil.beanToJson(ids, JsonUtil.TYPE.PRETTY_AND_SERIALIZE_NULL));
    }
}
