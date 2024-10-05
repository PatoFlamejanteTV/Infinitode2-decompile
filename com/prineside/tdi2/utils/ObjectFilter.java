package com.prineside.tdi2.utils;

@REGS(classOnly = true)
@FunctionalInterface
public interface ObjectFilter<T> {
  boolean test(T paramT);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\ObjectFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */