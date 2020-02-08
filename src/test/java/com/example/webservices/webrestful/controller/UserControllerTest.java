package com.example.webservices.webrestful.controller;

import com.example.webservices.webrestful.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.BDDMockito.given;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    private UserController userController;

    @Test
    public void getUser() {

        User mockUser = new User("ARO4lZuX12hP4WYJpBQLeA", "Derek McAuley", false);

        given(userController.show("ARO4lZuX12hP4WYJpBQLeA")).willReturn(mockUser);

        assert userController.show("ARO4lZuX12hP4WYJpBQLeA") == mockUser;

    }

}
