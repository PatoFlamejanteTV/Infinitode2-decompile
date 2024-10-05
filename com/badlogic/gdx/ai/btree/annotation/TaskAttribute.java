package com.badlogic.gdx.ai.btree.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface TaskAttribute {
  String name() default "";
  
  boolean required() default false;
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\annotation\TaskAttribute.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */