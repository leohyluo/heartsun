package com.heartsun.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heartsun.entity.Body;
import com.heartsun.repository.BaseRepository;
import com.heartsun.repository.BodyRepository;

@Service
public class BodyService extends AbstractService<Body> implements IBodyService {

	@Resource
	private BodyRepository bodyRepository;
	
	@Override
	public BaseRepository<Body> getRepository() {
		return bodyRepository;
	}

}
