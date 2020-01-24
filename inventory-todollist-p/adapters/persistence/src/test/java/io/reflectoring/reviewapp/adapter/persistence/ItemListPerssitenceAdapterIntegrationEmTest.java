package io.reflectoring.reviewapp.adapter.persistence;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;

import io.reflectoring.reviewapp.domain.Item;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AutoConfigurationPackage
@DataMongoTest
@Import(PersistenceEmbeConfiguration.class)
@RequiredArgsConstructor
public class ItemListPerssitenceAdapterIntegrationEmTest {
	
	
	@Autowired
	private ItemPersistenceAdapter itempersistenceAdapters;
	
	@Test
	public void prueba1() {
		
		Item item = itempersistenceAdapters.save(new Item(12l, "test title", "test data"));
		assertNotNull(item);
	}
}
