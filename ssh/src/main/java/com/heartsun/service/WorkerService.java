package com.heartsun.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heartsun.entity.Worker;
import com.heartsun.repository.IWorkRepository;

@Service
@Transactional
public class WorkerService implements IWorkerService {

	@Resource
	private IWorkRepository workRepository;
	
	public Worker findById(Long id) {
		// TODO Auto-generated method stub
		return workRepository.findById(id);
	}

}
