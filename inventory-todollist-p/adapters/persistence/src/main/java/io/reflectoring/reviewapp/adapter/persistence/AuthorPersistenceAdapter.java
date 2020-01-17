package io.reflectoring.reviewapp.adapter.persistence;

import io.reflectoring.reviewapp.application.port.out.FindAuthorByIdPort;
import io.reflectoring.reviewapp.domain.Author;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class AuthorPersistenceAdapter implements FindAuthorByIdPort {

  @Autowired
  private AuthorRepository authorRepository;

  @Override
  public Author findAuthorById(Long authorId) {
    return authorRepository.findById(authorId)
            .orElseThrow(() -> new AuthorNotFoundException(authorId));
  }


}
