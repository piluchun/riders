package com.leadtone.riders.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.leadtone.riders.entity.Report;

public interface ReportDao extends PagingAndSortingRepository<Report, Long> {

}
