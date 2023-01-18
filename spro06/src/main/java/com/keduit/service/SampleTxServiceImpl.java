package com.keduit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keduit.mapper.Sample1Mapper;
import com.keduit.mapper.Sample2Mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class SampleTxServiceImpl implements SampleTxService {
	
	@Setter(onMethod_ = @Autowired)
	private Sample1Mapper mapper1;
	
	@Setter(onMethod_ = @Autowired)
	private Sample2Mapper mapper2;
	
	@Transactional
	@Override
	public void addData(String value) {
		
		log.info("mapper1.......");
		mapper1.insertCol1(value);
		
		log.info("mapper2.......");
		mapper2.insertCol2(value);
		
		log.info("end...........");
		
	}
	
}
