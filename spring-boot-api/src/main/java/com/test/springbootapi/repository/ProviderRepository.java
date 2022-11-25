package com.test.springbootapi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.test.springbootapi.entity.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

	List<Provider> findAllByNameContaining(String name, Pageable pageable);

}
