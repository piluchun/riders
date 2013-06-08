package com.leadtone.riders.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.leadtone.riders.entity.Line;

public interface LineDao extends PagingAndSortingRepository<Line, Long> {

}
