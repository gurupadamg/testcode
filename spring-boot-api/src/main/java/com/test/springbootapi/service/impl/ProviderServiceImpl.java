package com.test.springbootapi.service.impl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.test.springbootapi.entity.Provider;
import com.test.springbootapi.exception.ProviderException;
import com.test.springbootapi.repository.ProviderRepository;
import com.test.springbootapi.service.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService {

	private ProviderRepository providerRepository;

	public ProviderServiceImpl(ProviderRepository providerRepository) {
		this.providerRepository = providerRepository;
	}

	@Override
	public Provider createProvider(Provider provider) throws ProviderException {
		try {
			return providerRepository.save(provider);

		} catch (Exception e) {
			throw new ProviderException("Exception wile inserting provider details in DB");
		}
	}

	@Override
	public List<Provider> searchByName(String name, Integer offset, Integer limit) throws ProviderException {
		Pageable page = PageRequest.of(offset, limit);
		List<Provider> providersList = providerRepository.findAllByNameContaining(name, page);
		return providersList;
	}

}
