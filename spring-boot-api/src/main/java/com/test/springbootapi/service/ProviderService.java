package com.test.springbootapi.service;

import java.util.List;

import com.test.springbootapi.entity.Provider;
import com.test.springbootapi.exception.ProviderException;

public interface ProviderService {

	Provider createProvider(Provider provider) throws ProviderException;

	List<Provider> searchByName(String name, Integer offset, Integer limit) throws ProviderException;
}
