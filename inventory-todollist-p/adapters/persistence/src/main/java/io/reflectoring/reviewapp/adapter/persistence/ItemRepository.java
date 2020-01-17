package io.reflectoring.reviewapp.adapter.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.reflectoring.reviewapp.domain.Item;

public interface ItemRepository extends MongoRepository<Item,Long>{

}
