package io.reflectoring.reviewapp.adapter.persistence;

import io.reflectoring.reviewapp.application.port.out.PersisItemPort;
import io.reflectoring.reviewapp.common.PersistenceAdapter;
import io.reflectoring.reviewapp.domain.Item;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class ItemPersistenceAdapter implements PersisItemPort {

	private final ItemRepository itemrepository;
	
	@Override
	public Item save(Item item) {
		return itemrepository.save(item);
	}

}
