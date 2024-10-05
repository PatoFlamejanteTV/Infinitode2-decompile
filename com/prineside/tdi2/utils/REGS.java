package com.prineside.tdi2.utils;

import com.esotericsoftware.kryo.Serializer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface REGS {
  int arrayLevels() default 0;
  
  Class<? extends Serializer> serializer() default com.prineside.tdi2.serializers.GameStateSerializer.class;
  
  boolean classOnly() default false;
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\REGS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */