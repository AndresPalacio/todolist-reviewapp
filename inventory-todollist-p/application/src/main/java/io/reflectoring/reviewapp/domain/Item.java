package io.reflectoring.reviewapp.domain;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Item {

	@Id
	@Getter
	private long id;
	
	@Getter
	private String title;
	
	@Getter String data;

}
