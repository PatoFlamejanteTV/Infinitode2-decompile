package com.a.a.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface n {
  String a() default "@id";
  
  Class<? extends al<?>> b();
  
  Class<? extends an> c() default aq.class;
  
  Class<?> d() default Object.class;
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */