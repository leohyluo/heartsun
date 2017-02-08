package com.heartsun.repository;

import com.heartsun.entity.Worker;

public interface IWorkRepository {

	Worker findByMobile(String mobile);
	
	Worker findById(Long id);
}
