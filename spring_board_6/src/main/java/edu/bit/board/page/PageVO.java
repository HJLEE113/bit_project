package edu.bit.board.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class PageVO {

	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int total;// ��ü�� ���;� ���� ���� ����
	private Criteria cri;

	public PageVO(Criteria cri, int total) {
		// �ۼ�����ϰ���, ��ü ��ִ���
		this.cri = cri;
		this.total = total;

		this.endPage = (int) (Math.ceil(cri.getPageNum() / 7.0)) * 7;

		this.startPage = this.endPage - 6;

		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

		if (realEnd <= this.endPage) {
			this.endPage = realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}

	public String makeQuery(int page) {
		UriComponents uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("pageNum", page)
				.queryParam("amount", cri.getAmount()).build();
		return uriComponentsBuilder.toUriString();
	}

}
