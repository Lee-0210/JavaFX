package application.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.CheckBox;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *  (DTO)
 *  게시글 정보		
 *  				Java			DB
 *  - 게시글 번호		no				no	
 *  - 제목			title			title
 *  - 작성자			writer			writer
 *  - 내용			content			content
 *  - 등록일자			createdAt			red_date
 *  - 수정일자			updatedAt			updated_at
 */
public class Board {

	private int no;
	private String title;
	private String writer;
	private String content;
	private String createdAt;
	private String updatedAt;
	private CheckBox cbDelete;
	
	// 날짜포맷
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public Board() {
		this("(제목없음)", "(작성자없음)", "");
	}
	
	
	public Board(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.updatedAt = dtf.format(LocalDateTime.now());
		this.createdAt = dtf.format(LocalDateTime.now());
		this.cbDelete = new CheckBox();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public CheckBox getCbDelete() {
		return cbDelete;
	}

	public void setCbDelete(CheckBox cbDelete) {
		this.cbDelete = cbDelete;
	}

	public DateTimeFormatter getDtf() {
		return dtf;
	}

	public void setDtf(DateTimeFormatter dtf) {
		this.dtf = dtf;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
}