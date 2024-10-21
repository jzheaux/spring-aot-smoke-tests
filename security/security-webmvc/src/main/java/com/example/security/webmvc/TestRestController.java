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

package com.example.security.webmvc;

import java.security.Principal;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rest", produces = MediaType.TEXT_PLAIN_VALUE)
public class TestRestController {

	@GetMapping("/anonymous")
	public String anonymous() {
		return "anonymous";
	}

	@GetMapping("/authorized")
	public String authorized(Principal principal) {
		return "authorized: " + principal.getName();
	}

	@GetMapping("/admin")
	public String admin(Principal principal) {
		return "admin: " + principal.getName();
	}

}
