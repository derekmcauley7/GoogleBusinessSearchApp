package com.example.webservices.webrestful.controller;

import com.example.webservices.webrestful.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    private UserController userController;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    public void getSingleUser() {

        User mockUser = new User("AR4lZuX12hP4WYJ", "Derek McAuley", false);

        given(userController.show("AR4lZuX12hP4WYJ")).willReturn(mockUser);

        assert userController.show("AR4lZuX12hP4WYJ") == mockUser;

    }

    @Test
    public void getUserList() throws Exception {

        String uri = "/users";
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        User[] users = userController.index().toArray(new User[10]);
        assertTrue(users.length > 0);
    }


    @Test
    public void createUser(){
        User returnedUser = new User("AR4lZuX12hP4WYJ", "Derek McAuley", false);
        Map<String, String> body = new HashMap<>();
        body.put("id", "1");
        body.put("name", "Bob Dylan");
        body.put("banned", "false");

        given(userController.create(body)).willReturn(returnedUser);

        assert userController.create(body) == returnedUser;
    }

}
