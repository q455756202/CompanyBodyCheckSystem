package team.yingyingmonster.ccbs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import team.yingyingmonster.ccbs.json.JsonUtil;
import team.yingyingmonster.ccbs.service.serviceinterface.JuerCompanyCheckSystemService;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 9:36 2018/11/14
 * -
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-service.xml")
public class JuerCompanyCheckSystemServiceImplementTest {
    @Autowired
    private JuerCompanyCheckSystemService juerCompanyCheckSystemService;

    @Test
    public void getJuerUserListByTeamformidTest() {
        System.out.println(JsonUtil.beanToJson(juerCompanyCheckSystemService.getJuerUsersByTeamformId(1L), JsonUtil.TYPE.PRETTY_AND_SERIALIZE_NULL));
    }
}
