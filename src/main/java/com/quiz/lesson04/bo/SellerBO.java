package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	
	@Autowired
	private SellerMapper sellerMapper;

	// i: 파라미터3
	// o: X
	public void addSeller(String nickname, 
			String profileImage, Double temperature) {
		
		sellerMapper.insertSeller(nickname, profileImage, temperature);
	}
	
	// i: id or null
	// o: Seller
	public Seller getSeller(Integer id) {
		if (id == null) {
			return sellerMapper.selectLatestSeller();
		} 
		
		return sellerMapper.selectSellerById(id);
	}
}






