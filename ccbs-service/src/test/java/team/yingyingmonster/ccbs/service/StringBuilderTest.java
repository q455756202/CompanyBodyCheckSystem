package team.yingyingmonster.ccbs.service;

import org.junit.Test;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 10:41 2018/11/8
 * -
 **/
public class StringBuilderTest {
    @Test
    public void stringBuilderReplaceTest() {
        StringBuilder builder = new StringBuilder("1234567890");
        System.out.println(builder.length());
        System.out.println(builder.replace(builder.length()-1, builder.length(), ""));
    }

    @Test
    public void numberObjectEqualsTest() {
        Long i=1l, j=1l;
        System.out.println(i.equals(j));
        System.out.println(i==j);
    }
}
