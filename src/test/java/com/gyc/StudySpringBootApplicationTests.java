package com.gyc;

import com.gyc.constants.HttpResultConstants;
import com.gyc.controller.HelloWorldController;
import com.gyc.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = MockServletContext.class)
public class StudySpringBootApplicationTests {

    private MockMvc helloWorldMvc;
    private MockMvc userMvc;

    @Test
    public void contextLoads() {
    }

    @Before
    public void setUp() throws Exception {
        helloWorldMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
        userMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void getIndex() throws Exception {
        helloWorldMvc.perform(get("/index").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hello world")));
    }

    @Test
    public void testUserController() throws Exception {
        RequestBuilder request = null;
        // 测试获取用户列表
        request = get("/user/");
        userMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
        // 测试添加用户
        request = post("/user/")
                .param("id", "1")
                .param("name", "巫妖王");
        userMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(HttpResultConstants.SUCCESS)));
        // 测试根据id获取用户
        request = get("/user/1");
        System.out.println(userMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());
        // 测试更新用户
        request = post("/user/1")
                .param("name", "金馆长");
        userMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(HttpResultConstants.SUCCESS)));
        // 查看更新是否成功
        request = get("/user/1");
        System.out.println(userMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());
        // 查看一共有几个用户
        request = get("/user/");
        System.out.println(userMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());
        // 测试删除用户
        request = delete("/user/1");
        userMvc.perform(request)
                .andExpect(content().string(equalTo(HttpResultConstants.SUCCESS)));
        // 查看是否删除成功
        request = get("/user/");
        System.out.println(userMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());

    }

}
