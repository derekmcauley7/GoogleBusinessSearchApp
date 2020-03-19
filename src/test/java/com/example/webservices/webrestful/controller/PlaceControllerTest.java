package com.example.webservices.webrestful.controller;

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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(PlaceController.class)
public class PlaceControllerTest {
    
    @MockBean
    private PlaceController placeController;
    
    @Autowired
    WebApplicationContext webApplicationContext;
    
    @Test
    public void searchForSinglePlace() throws Exception {
    
	MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	mvc.perform(MockMvcRequestBuilders.get("/places")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
    }
    
    @Test
    public void getPlacesList() throws Exception {
	
	String uri = "/places";
	MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	
	int status = mvcResult.getResponse().getStatus();
	assertEquals(200, status);
	Place[] places = placeController.index().toArray(new Place[10]);
	assertTrue(places.length > 0);
    }
    
}
