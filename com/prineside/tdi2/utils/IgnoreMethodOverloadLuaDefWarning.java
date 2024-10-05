package com.prineside.tdi2.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreMethodOverloadLuaDefWarning {}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\IgnoreMethodOverloadLuaDefWarning.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */