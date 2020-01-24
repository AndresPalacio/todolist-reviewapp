package io.reflectoring.reviewapp.adapter.persistence;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;

import io.reflectoring.reviewapp.domain.Item;

@AutoConfigurationPackage
@DataMongoTest
@Import(PersistenceAdapterConfiguration.class)
public class ItemListPerssitenceAdapterIntegrationEmTest {
	@Mock
	private ItemRepository itempersistenceAdapter;
	
	@Autowired
	private ItemPersistenceAdapter itempersistenceAdapters;
	
	@BeforeEach
	public void setMock() {
		when(itempersistenceAdapter.save(new Item(12l, "tes", "test data"))).thenReturn(new Item(12L, "test title","test data"));
	}	
	
	@Test
	public void prueba() {
		
		
	}
	
	
	@Test
	public void prueba1() {
		
		Item item = itempersistenceAdapters.save(new Item(12l, "test title", "test data"));
		assertNotNull(item);
	}
}
