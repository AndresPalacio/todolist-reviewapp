package io.reflectoring.reviewapp.integrationtest;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.reflectoring.reviewapp.adapter.persistence.ItemPersistenceAdapter;
import io.reflectoring.reviewapp.adapter.persistence.PersistenceAdapterConfiguration;
import io.reflectoring.reviewapp.domain.Item;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@ContextConfiguration(initializers = MongoDbContainerTest.MongoDbInitializer.class)
@Import(PersistenceAdapterConfiguration.class)
@ExtendWith(SpringExtension.class)
@Slf4j
public class MongoDbContainerTest {

	@Autowired
	private ItemPersistenceAdapter itempersistenceAdapters;

    private static MongoDbContainer mongoDbContainer;

    @BeforeAll
    public static void startContainerAndPublicPortIsAvailable() {
        mongoDbContainer = new MongoDbContainer();
        mongoDbContainer.start();
    }

	
	@Test
	public void prueba1() {
		
		Item item = itempersistenceAdapters.save(new Item(12l, "test title", "test data"));
		assertNotNull(item);
	}
    public static class MongoDbInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            log.info("Overrding Spring Properties for mongodb !!!!!!!!!");

            TestPropertyValues values = TestPropertyValues.of(
                    "spring.data.mongodb.host=" + mongoDbContainer.getContainerIpAddress(),
                    "spring.data.mongodb.port=" + mongoDbContainer.getPort()

            );
            values.applyTo(configurableApplicationContext);
        }
    }


}