package com.coecapstone.capstone.controller;

import com.coecapstone.capstone.model.Result;
import com.coecapstone.capstone.service.ApiCallService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class IndexController {

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private ApiCallService api;

  @GetMapping
  public ModelAndView getIndex()
    throws JsonMappingException, JsonProcessingException {
    ModelAndView mav = new ModelAndView("index");
    String result_json = api.fetchDataFromApi(
      String.format("http://127.0.0.1:5000")
    );

    String difference_json = api.fetchDataFromApi(
      "http://127.0.0.1:5000/api/get-difference"
    );

    TypeReference<List<Result>> typeReference = new TypeReference<List<Result>>() {};
    List<Result> results = objectMapper.readValue(result_json, typeReference);
    
    mav.addObject("results", results);
    return mav;
  }
}
