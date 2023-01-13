package com.keduit.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private Long bno;
	private Date tododate;
	private String Content;
	private Date regdate;
	private Date updatedate;
}
