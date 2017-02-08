package com.heartsun.repository;

import org.springframework.stereotype.Repository;

import com.heartsun.entity.Worker;

@Repository
public class WorkRepository extends BaseRepository<Worker> implements IWorkRepository {

	public Worker findByMobile(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	public Worker findById(Long id) {
		// TODO Auto-generated method stub
		return get(Worker.class, id);
	}

}
