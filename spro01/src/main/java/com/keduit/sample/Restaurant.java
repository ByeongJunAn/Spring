package com.keduit.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	
	@Setter(onMethod_ = @Autowired)
	// onMethod=@_({AnnotationGHoHere})) 자바 1.8 이전 표현법
	private Chef chef;
	

}
