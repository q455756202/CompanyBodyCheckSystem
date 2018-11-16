package team.yingyingmonster.ccbs.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import team.yingyingmonster.ccbs.database.bean.Bill;
import team.yingyingmonster.ccbs.database.mapper.juergenie.JuerBillMapper;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 11:27 2018/11/16
 * -
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-database.xml")
public class JuerBillMapperTest {
    @Autowired
    private JuerBillMapper juerBillMapper;

    @Test
    public void selectAllPriceByBillListTest() {
        List<Bill> billList = new LinkedList<>();
        for (long i = 0; i < 10; i++) {
            Bill bill = new Bill();
            bill.setCheckid(i);
            billList.add(bill);
        }
        System.out.println(juerBillMapper.selectAllPriceByBillList(billList));
    }
}
