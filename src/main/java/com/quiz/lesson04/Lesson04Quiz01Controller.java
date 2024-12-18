package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;

	// http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// /add-seller
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImage", required = false) String profileImage,
			@RequestParam(value = "temperature", required = false) Double temperature) {
		
		// DB insert
		sellerBO.addSeller(nickname, profileImage, temperature);
		
		// 결과 화면
		return "lesson04/afterAddSeller";
	}
	
	// 최근 가입자
	// /lesson04/quiz01/seller-info-view
	// /lesson04/quiz01/seller-info-view?id=3
	@GetMapping("/seller-info-view")
	public String sellerInfoView(
			@RequestParam(value = "id", required = false) Integer id,
			Model model) {
		
		// db 최신가입자 select
		Seller seller111 = sellerBO.getSeller(id);
		
		// model에 담기
		model.addAttribute("seller", seller111);
		
		// 화면
		return "lesson04/sellerInfo";
	}
}
