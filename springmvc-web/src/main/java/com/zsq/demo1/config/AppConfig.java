package com.zsq.demo1.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan("com.zsq.demo1.controller")
public class AppConfig {
}
