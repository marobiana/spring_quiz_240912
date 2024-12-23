package com.quiz.weatherhistory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {

	// 날씨 목록 화면
	@GetMapping("/weather-list-view")
	public String weatherListView() {
		return "weatherHistory/weatherList";
	}
	
	// 날씨 입력 화면
}
