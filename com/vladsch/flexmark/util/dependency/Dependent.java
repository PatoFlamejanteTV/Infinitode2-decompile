package com.vladsch.flexmark.util.dependency;

import java.util.Set;

public interface Dependent {
  Set<Class<?>> getAfterDependents();
  
  Set<Class<?>> getBeforeDependents();
  
  boolean affectsGlobalScope();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\dependency\Dependent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */