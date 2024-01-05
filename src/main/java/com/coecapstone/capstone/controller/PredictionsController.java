package com.coecapstone.capstone.controller;

import com.coecapstone.capstone.model.Prediction;
import com.coecapstone.capstone.model.Result;
import com.coecapstone.capstone.service.ApiCallService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/predictions")
public class PredictionsController {

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private ApiCallService api;

  @GetMapping
  public ModelAndView getPrediction(
    @RequestParam("quota") int quota,
    @RequestParam("category") String cat
  ) throws JsonMappingException, JsonProcessingException {
    ModelAndView mav = new ModelAndView("predictions");

    cat = cat.toUpperCase();

    String prediction_json = api.fetchDataFromApi(
      String.format(
        "https://flask-service.up.railway.app/api/get-prediction/%d/%s",
        quota,
        cat
      )
    );

    TypeReference<Prediction> typeReference = new TypeReference<Prediction>() {};
    Prediction prediction = objectMapper.readValue(
      prediction_json,
      typeReference
    );

    mav.addObject("prediction", prediction);

    return mav;
  }
}
