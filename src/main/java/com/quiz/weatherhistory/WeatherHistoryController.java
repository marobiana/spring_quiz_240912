package com.quiz.weatherhistory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weatherhistory.bo.WeatherHistoryBO;
import com.quiz.weatherhistory.domain.WeatherHistory;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;

	// 날씨 목록 화면
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		// db select
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		
		// model 담기
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		
		return "weatherHistory/weatherList";
	}
	
	// 날씨 입력 화면
}
