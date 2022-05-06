/*
 * Copyright 2002-2022 the original author or authors.
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

package org.springframework.web.service.invoker;

import org.springframework.core.MethodParameter;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.CookieValue;

/**
 * {@link HttpServiceArgumentResolver} for {@link CookieValue @CookieValue}
 * annotated arguments.
 *
 * <p>The argument may be:
 * <ul>
 * <li>{@code Map<String, ?>} or
 * {@link org.springframework.util.MultiValueMap MultiValueMap&lt;String, ?&gt;} with
 * multiple cookies and value(s).
 * <li>{@code Collection} or an array of cookie values.
 * <li>An individual cookie value.
 * </ul>
 *
 * <p>Individual cookie values may be Strings or Objects to be converted to
 * String values through the configured {@link ConversionService}.
 *
 * <p>If the value is required but {@code null}, {@link IllegalArgumentException}
 * is raised. The value is not required if:
 * <ul>
 * <li>{@link CookieValue#required()} is set to {@code false}
 * <li>{@link CookieValue#defaultValue()} provides a fallback value
 * <li>The argument is declared as {@link java.util.Optional}
 * </ul>
 *
 * @author Rossen Stoyanchev
 * @since 6.0
 */
public class CookieValueArgumentResolver extends AbstractNamedValueArgumentResolver {


	public CookieValueArgumentResolver(ConversionService conversionService) {
		super(conversionService);
	}


	@Override
	protected NamedValueInfo createNamedValueInfo(MethodParameter parameter) {
		CookieValue annot = parameter.getParameterAnnotation(CookieValue.class);
		return (annot == null ? null :
				new NamedValueInfo(annot.name(), annot.required(), annot.defaultValue(), "cookie value", true));
	}

	@Override
	protected void addRequestValue(String name, String value, HttpRequestValues.Builder requestValues) {
		requestValues.addCookie(name, value);
	}

}
