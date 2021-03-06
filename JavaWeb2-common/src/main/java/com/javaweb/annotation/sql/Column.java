package com.javaweb.annotation.sql;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

	String name();
	
	boolean pk() default false;//是否是主键
	
	boolean keyGenerate() default false;//是否主键自增
	
}
