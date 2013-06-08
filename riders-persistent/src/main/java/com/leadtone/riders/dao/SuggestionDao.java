package com.leadtone.riders.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.leadtone.riders.entity.Suggestion;

public interface SuggestionDao extends PagingAndSortingRepository<Suggestion, Long> {

}
