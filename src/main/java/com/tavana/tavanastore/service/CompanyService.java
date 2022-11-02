package com.tavana.tavanastore.service;

import com.tavana.tavanastore.dto.CompanytDTO;

public interface CompanyService {

    CompanytDTO save(CompanytDTO companytDTO);

    CompanytDTO update(CompanytDTO companytDTO);

    void delete(Long id);

    CompanytDTO findById(Long id);
}
