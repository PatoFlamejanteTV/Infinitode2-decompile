package com.a.a.c.a;

import com.a.a.a.s;
import com.a.a.c.k.s;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface b {
  a[] a() default {};
  
  b[] b() default {};
  
  boolean c() default false;
  
  public static @interface b {
    Class<? extends s> a();
    
    String b() default "";
    
    String c() default "";
    
    s.a d() default s.a.NON_NULL;
    
    boolean e() default false;
    
    Class<?> f() default Object.class;
  }
  
  public static @interface a {
    String a();
    
    String b() default "";
    
    String c() default "";
    
    s.a d() default s.a.NON_NULL;
    
    boolean e() default false;
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */