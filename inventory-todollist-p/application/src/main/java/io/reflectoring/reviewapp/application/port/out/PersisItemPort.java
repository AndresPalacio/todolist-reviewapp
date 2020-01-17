package io.reflectoring.reviewapp.application.port.out;

import io.reflectoring.reviewapp.domain.Item;

public interface PersisItemPort {

	Item save(Item item);
}
