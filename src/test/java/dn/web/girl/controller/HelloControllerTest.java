package dn.web.girl.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Author: dengning
 * @Description: 测试类
 * @Date: Created in 16:16 2018/10/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void girlListTest() throws  Exception{
        //请求路径测试
//        mockMvc.perform(MockMvcRequestBuilders.get("/getGirls")).andExpect(MockMvcResultMatchers.status().isOk());

//        返回信息测试
        mockMvc.perform(MockMvcRequestBuilders.get("/getGirls"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("aaa"));
        ;
    }

}