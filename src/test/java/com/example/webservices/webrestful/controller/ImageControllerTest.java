package com.example.webservices.webrestful.controller;

import com.example.webservices.webrestful.bean.Image;
import com.example.webservices.webrestful.bean.Place;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ImageController.class)
public class ImageControllerTest {
    
    @MockBean
    private ImageController imageController;
    
    @Autowired
    WebApplicationContext webApplicationContext;
    
    @Test
    public void searchForSingleImage() {
    
        Image createdImage = new Image("www.s3.com/images","123211","232313");
	Map<String, String> body = new HashMap<>();
	body.put("url", "www.s3.com/images");
	body.put("placesId", "123211");
	body.put("userId", "232313");
 
	given(imageController.create(body)).willReturn(createdImage);
 
	assert imageController.create(body) == createdImage;
    }
    
    @Test
    public void getAllImagesList() throws Exception {
	
	String uri = "/images";
	MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	
	int status = mvcResult.getResponse().getStatus();
	assertEquals(200, status);
	Image[] images = imageController.index().toArray(new Image[10]);
	assertTrue(images.length > 0);
    }
    
    @Test
    public void getAllImagesListForBusiness() throws Exception {
	
	String uri = "/allImages/1111";
	MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	
	int status = mvcResult.getResponse().getStatus();
	assertEquals(200, status);
	Image[] images = imageController.index().toArray(new Image[10]);
	assertTrue(images.length > 0);
    }
    
}
