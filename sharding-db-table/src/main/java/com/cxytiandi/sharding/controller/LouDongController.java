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
	
	@GetMapping("/ld/add-{id}")
	public Object add(@PathVariable("id") String id) {
		LouDong louDong = new LouDong();
		louDong.setId(id);
		louDong.setCity(id);
		louDong.setRegion(id);
		louDong.setName(id);
		louDong.setLdNum(id);
		louDong.setUnitNum(id);
		louDongRepository.addLouDong(louDong);
		return "success";
	}

}
