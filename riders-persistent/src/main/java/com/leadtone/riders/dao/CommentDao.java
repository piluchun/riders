package com.leadtone.riders.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.leadtone.riders.entity.Comment;

public interface CommentDao extends PagingAndSortingRepository<Comment, Long> {

}
