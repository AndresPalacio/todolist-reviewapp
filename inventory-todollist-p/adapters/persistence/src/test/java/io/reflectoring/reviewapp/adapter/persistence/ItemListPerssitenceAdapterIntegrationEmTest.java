package io.reflectoring.reviewapp.adapter.persistence;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;

import io.reflectoring.reviewapp.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@Profile("test")
@AutoConfigurationPackage
@DataMongoTest
@Import(PersistenceEmbeConfiguration.class)
@RequiredArgsConstructor
@ActiveProfiles("test")
public class ItemListPerssitenceAdapterIntegrationEmTest {
	
	
	@Autowired
	private ItemPersistenceAdapter itempersistenceAdapters;

	@Test
	public void prueba1() {
		
		Item item = itempersistenceAdapters.save(new Item(12l, "test title", "test data"));
		assertNotNull(item);
	}
}
