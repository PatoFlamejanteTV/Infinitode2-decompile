package com.prineside.tdi2.utils;

@FunctionalInterface
@REGS(classOnly = true)
public interface ObjectSupplier<T> {
  T get();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\ObjectSupplier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */