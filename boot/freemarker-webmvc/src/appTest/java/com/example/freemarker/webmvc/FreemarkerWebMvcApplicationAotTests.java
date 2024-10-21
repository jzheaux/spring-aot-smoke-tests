/*
 * Copyright 2022-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.freemarker.webmvc;

import org.junit.jupiter.api.Test;

import org.springframework.aot.smoketest.support.junit.ApplicationTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationTest
class FreemarkerWebMvcApplicationAotTests {

	@Test
	void greetingIsRendered(WebTestClient client) {
		client.get()
			.uri("/greeting")
			.exchange()
			.expectStatus()
			.isOk()
			.expectBody()
			.consumeWith((result) -> assertThat(new String(result.getResponseBodyContent())).contains("Hello world"));
	}

	@Test
	void authorListIsRendered(WebTestClient client) {
		client.get()
			.uri("/authors")
			.exchange()
			.expectStatus()
			.isOk()
			.expectBody()
			.consumeWith(
					(result) -> assertThat(new String(result.getResponseBodyContent())).contains("<li>Brian Goetz</li>")
						.contains("<li>Joshua Bloch</li>"));
	}

}
