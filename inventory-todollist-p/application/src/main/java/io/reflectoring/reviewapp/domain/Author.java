package io.reflectoring.reviewapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
public class Author {

  @Id
  @Getter
  private Long id;
  @Getter
  private String name;

  // imagine some insanely complex business logic methods ...

}
