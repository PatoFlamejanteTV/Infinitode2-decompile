package com.badlogic.gdx.ai.btree.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
@Documented
public @interface TaskConstraint {
  int minChildren() default 0;
  
  int maxChildren() default 2147483647;
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btree\annotation\TaskConstraint.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */