package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	// input: id  
	// output: RealEstate or null
	public RealEstate selectRealEstateById(int id);
	
	// i: rentPrice(int)
	// o: List<RealEstate>
	public List<RealEstate> selectRealEstateByRentPrice(int rentPrice124314);
	
	// i: area(int), price(int)
	// o: List<RealEstate>
	public List<RealEstate> selectRealEstateListByAreaPrice(
			// 하나의 맵이 된다 @Param이 맵으로 만들어줌
			@Param("area") int area11341324134, 
			@Param("price") int price141341424234);
	
	// i: RealEstate
	// o: int
	public int insertRealEstate(RealEstate realEstate);
	
	// realtorId 
//	address : 썅떼빌리버 오피스텔 814호
//	area : 45
//	type : 월세
//	price : 100000
//	rentPrice : 120
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") Integer rentPrice);
	
	public int updateRealEstateById(
			@Param("id") int id, 
			@Param("type") String type, 
			@Param("price") int price);
}





