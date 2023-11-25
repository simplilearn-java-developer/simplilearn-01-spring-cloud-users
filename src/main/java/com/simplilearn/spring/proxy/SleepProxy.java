package com.simplilearn.spring.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.simplilearn.spring.bean.UserSleep;

@FeignClient(name="sleep-service")
public interface SleepProxy {

	@GetMapping("/sleep/{birth}")
	public UserSleep getSleepRecommendation(@PathVariable String birth);
}
