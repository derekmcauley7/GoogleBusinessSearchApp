package com.example.webservices.webrestful.controller;

import com.example.webservices.webrestful.Review;
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

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {
    
    @MockBean
    private ReviewController reviewController;
    
    @Autowired
    WebApplicationContext webApplicationContext;
    
    @Test
    public void createASingleReview() {
	
	Review createdReview = new Review("1111", "5", "1234", "User Name", "2020-03-01",  "5", "5", "5",
		"5", "5", "5", "no", "yes",
		"yes", "yes","no",
		"5", "yes", "Test Comment!!!");
	Map<String, String> body = new HashMap<>();
	body.put("placesId", "1111");
	body.put("userId", "1234");
	body.put("userName", "User Name");
	body.put("entrance", "5");
	body.put("toilet", "5");
	body.put("cleanliness", "5");
	body.put("areAllAreasAccessible", "5");
	body.put("easeOfMovement", "5");
	body.put("seatingSuitability", "5");
	body.put("lift", "no");
	body.put("stairs", "yes");
	body.put("fullWheelchairAccessibleManual", "yes");
	body.put("fullWheelchairAccessibleElectric", "yes");
	body.put("keyRequiredFromStaff", "no");
	body.put("serviceCounter", "yes");
	body.put("tableService", "yes");
	body.put("content", "Test Comment!!!");
	
	given(reviewController.create(body)).willReturn(createdReview);
	
	assert reviewController.create(body) == createdReview;
    }
    
    @Test
    public void getAllReviewsList() throws Exception {

	String uri = "/review";
	MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

	int status = mvcResult.getResponse().getStatus();
	assertEquals(200, status);
	Image[] images = reviewController.index().toArray(new Image[10]);
	assertTrue(images.length > 0);
    }

    @Test
    public void getAllReviewsForBusiness() throws Exception {

	String uri = "/review";
	MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		.param("placesId", "1111")
		.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

	int status = mvcResult.getResponse().getStatus();
	assertEquals(200, status);
	Image[] images = reviewController.index().toArray(new Image[10]);
	assertTrue(images.length > 0);
    }

}
