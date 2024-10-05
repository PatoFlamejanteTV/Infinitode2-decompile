package net.bytebuddy.utility.nullability;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NeverNull {
  @Documented
  @Target({ElementType.PACKAGE})
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface ByDefault {}
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\nullability\NeverNull.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */