package com.demo.portal.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import(value = TestRegistrar.class)
@Import(value = TestImportSelector.class)
public class ConfigB {
}
