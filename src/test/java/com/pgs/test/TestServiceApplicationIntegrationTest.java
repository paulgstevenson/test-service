package com.pgs.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestServiceApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=9999")
public class TestServiceApplicationIntegrationTest {

	private RestTemplate restTemplate = new TestRestTemplate();
	private String base = "http://localhost:9999/";

	@Test
	public void health() {
		ResponseEntity<HealthStuff> entity =
				restTemplate.getForEntity(base+"health", HealthStuff.class);

		assertThat(entity.getStatusCode().is2xxSuccessful()).isTrue();
		assertThat(entity.getBody().getStatus()).isEqualTo("Jersey: Up and Running!");
	}
}
