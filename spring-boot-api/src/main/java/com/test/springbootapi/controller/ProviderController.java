package com.test.springbootapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.springbootapi.entity.Provider;
import com.test.springbootapi.exception.ProviderException;
import com.test.springbootapi.service.ProviderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class ProviderController {

	private ProviderService providerService;

	public ProviderController(ProviderService providerService) {
		this.providerService = providerService;
	}

	@PostMapping("/provider")
	public ResponseEntity<Provider> createProvider(@RequestBody @Valid Provider provider) throws ProviderException {
		Provider providerResponse = providerService.createProvider(provider);
		return new ResponseEntity<Provider>(providerResponse, HttpStatus.CREATED);
	}

	@GetMapping("/provider")
	public ResponseEntity<List<Provider>> serachProviderByName(@RequestParam("name") String name,
			@RequestParam("offset") Integer Offset, @RequestParam("limit") Integer limit) throws ProviderException {

		List<Provider> providersList = providerService.searchByName(name, Offset, limit);
		return new ResponseEntity<>(providersList, HttpStatus.OK);
	}
}
