package com.leadtone.riders.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.leadtone.riders.entity.Activity;

public interface ActivityDao extends PagingAndSortingRepository<Activity, Long> {

}
