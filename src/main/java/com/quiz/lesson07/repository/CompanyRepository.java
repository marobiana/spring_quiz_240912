package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
	// Spring data JPA
	// public CompanyEntity save(CompanyEntity ce);
	// public Optional<CompanyEntity> findById(int id);
}
