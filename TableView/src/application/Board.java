package application;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Board {
	
	private int no;
	@NonNull  String title;
	@NonNull private String writer;
	@NonNull private String content;
	private Date createdAt;
	private Date updatedAt;
	private int view;
}
