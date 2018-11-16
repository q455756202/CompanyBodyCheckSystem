package team.yingyingmonster.ccbs.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import team.yingyingmonster.ccbs.database.bean.Combo;
import team.yingyingmonster.ccbs.database.bean.User;
import team.yingyingmonster.ccbs.database.bean.juergenie.JuerCombo;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerComboMapper;
import team.yingyingmonster.ccbs.json.JsonUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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

    @Test
    public void selectAllPriceByComboListTest() {
        List<Combo> list = new LinkedList<>();
        for (long i = 0; i < 10; i++) {
            Combo combo = new Combo();
            combo.setComboid(i);
            list.add(combo);
        }
        System.out.println(juerComboMapper.selectAllPriceByComboList(list));
    }

    @Test
    public void selectAllPriceByJuerComboListTest() {
        List<JuerCombo> list = new LinkedList<>();
        for (long i = 0; i < 10; i++) {
            JuerCombo juerCombo = new JuerCombo();
            juerCombo.setComboid(i);
            int size = new Random().nextInt(10);
            for (long j = 0; j < size; j++) {
                User user = new User();
                user.setUserid(j);
                juerCombo.getUserList().add(user);
            }
            list.add(juerCombo);
        }
        System.out.println(juerComboMapper.selectAllPriceByJuerComboList(list));
    }
}
