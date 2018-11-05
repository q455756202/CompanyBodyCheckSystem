package team.yingyingmonster.ccbs.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 11:14 2018/11/2
 * -
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:spring-mvc.xml")
public class ActionTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @Before
    public void start() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void loginTest() throws Exception {
        // 构建请求参数。
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("userId", "10000");
        map.add("userCode", "123456");
        // 发起请求，并将结果存入 result 中。URI 既是要测试的 action 的路径。
        String result = mvc.perform(get(new URI("/entry/login.mvc"))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .params(map))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        System.out.println("\nprint reuslt: \n" + result);
    }
}