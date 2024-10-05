package com.a.a.c.a;

import com.a.a.c.c.x;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface i {
  Class<? extends x> a();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\a\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */