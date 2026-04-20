package com.app.aop.aspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

// Target: 어디에 붙일수 어노테이션 ?
@Target({ElementType.METHOD})
// Retention : 어느 시점에 실행이 될 것인가(주입)
@Retention()
public @interface LogStatus {;}
