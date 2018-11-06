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
 * - create: 12:05 2018/11/5
 * -
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:spring-controller.xml")
public class CompanyCheckActionTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @Before
    public void start() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getCompanyEntityTest() throws Exception {
        // 构建请求参数。
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("userId", "10000");
        map.add("userCode", "123456");

        String result = mvc.perform(get(new URI("/company-check/get-company-entity"))
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .params(map))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        System.out.println("\nprint reuslt: \n" + result);
    }
}
