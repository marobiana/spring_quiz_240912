package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {
	// JPQL => Entity에 조회하는 개념
	public List<RecruitEntity> findByCompanyId(int companyId22);
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int salaryStart, int salaryEnd);
	
	// quiz02 7번 - native query => SQL로 직접 쿼리문 수행하는 개념
	// 마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순
	@Query(value = "select * from recruit "
			+ "where deadline > :deadline "
			+ "and salary >= :salary "
			+ "and type = :type "
			+ "order by salary desc", nativeQuery = true)
	public List<RecruitEntity> findByDeadlineAndType(
			@Param("deadline") String deadline, 
			@Param("salary") int salary, 
			@Param("type") String type);
}








