/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.pivotal.spring.cloud.service.config.client.context;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import io.pivotal.spring.cloud.service.config.PlainTextConfigClient;
import io.pivotal.spring.cloud.service.config.PlainTextConfigClientAutoConfiguration;

/**
 * @author Daniel Lavoie
 */
@RunWith(SpringRunner.class)
@Import(PlainTextConfigClientAutoConfiguration.class)
@SpringBootTest(classes = DisabledPlainTextConfigClientTest.class)
@ActiveProfiles("integration-test")
public class DisabledPlainTextConfigClientTest {

	@Autowired(required = false)
	private PlainTextConfigClient plainTextConfigClient;

	@Autowired
	private Environment environment;

	@Test
	public void configClientBeanShouldNotBeInjected() {
		Assert.assertNotNull("Spring container is not initialized.", environment);
		Assert.assertNull(plainTextConfigClient);
	}
}
