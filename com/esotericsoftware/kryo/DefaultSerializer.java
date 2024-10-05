package com.esotericsoftware.kryo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface DefaultSerializer {
  Class<? extends Serializer> value() default Serializer.class;
  
  Class<? extends SerializerFactory> serializerFactory() default SerializerFactory.ReflectionSerializerFactory.class;
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\DefaultSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */