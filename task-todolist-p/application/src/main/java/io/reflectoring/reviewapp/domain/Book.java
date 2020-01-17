package io.reflectoring.reviewapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
public class Book {

  @Id
  private Long id;
  @Getter
  private String title;
  @Getter
  private Long authorId;

  // imagine some insanely complex business logic methods ...

}
