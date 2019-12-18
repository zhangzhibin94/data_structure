/*
 * Copyright 2002-2018 the original author or authors.
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

package com.zzb.spring;


import com.sun.istack.internal.Nullable;
import com.zzb.spring.spring.ZAutowired;

import java.lang.annotation.Annotation;

/**
 *
 */
public class ClassPathResource  {

	private  String path;
	@ZAutowired
	private ClassLoader classLoader;
	private Class<?> clazz;

	public ClassPathResource(String path) {
		this(path, (ClassLoader) null);
	}

	public ClassPathResource(String path, @Nullable ClassLoader classLoader) {
		try {
			Class<?> a = Class.forName("a");
			ZAutowired annotation = a.getAnnotation(ZAutowired.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
