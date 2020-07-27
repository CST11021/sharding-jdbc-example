package com.cxytiandi.sharding.controller;

import com.cxytiandi.sharding.po.LouDong;
import com.cxytiandi.sharding.repository.LouDongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LouDongController {

	@Autowired
	private LouDongRepository louDongRepository;
	
	@GetMapping("/lds")
	public Object list() {
		return louDongRepository.list();
	}
	
	@GetMapping("/ld/add-{value}")
	public Object add(@PathVariable("value") String value) {
		LouDong louDong = new LouDong();
		louDong.setId(value);
		louDong.setCity(value);
		louDong.setRegion(value);
		louDong.setName(value);
		louDong.setLdNum(value);
		louDong.setUnitNum(value);
		louDongRepository.addLouDong(louDong);
		return "success";
	}

}
