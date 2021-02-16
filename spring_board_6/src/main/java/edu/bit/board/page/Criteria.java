package edu.bit.board.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Criteria {
	private int pageNum;//페이지 넘버
	private int amount;//한번에 보여지는 글 수 

	public Criteria() {
		this(1, 10);

	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
