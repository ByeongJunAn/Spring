package com.keduit.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
		
	private int pageNum;
	private int amount;
	
	private String type; // T(제목), C(내용), W(작성자), TC, TW,TCW
	private String keyword; //사용자가 입력한 내용
	
	public Criteria() {
		this(1,10);
	}

	public Criteria(int i, int j) {
		
		this.pageNum = i;
		this.amount= j;
	}
	
	public String[] getTypeArr() {
		return type==null ? new String[] {}:type.split("");
	}
}


