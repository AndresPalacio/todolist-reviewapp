package io.reflectoring.reviewapp.adapter.persistence;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import io.reflectoring.reviewapp.domain.Item;

public interface ItemRepository extends MongoRepository<Item,Long>{

	  @Query("select b.* from Item b where b.title = :title")
	  Optional<Item> findByTitle(@Param("title") String title);
}
