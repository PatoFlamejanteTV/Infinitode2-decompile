package net.bytebuddy.implementation.bytecode.collection;

import java.util.List;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bytecode.StackManipulation;

public interface CollectionFactory {
  TypeDescription.Generic getComponentType();
  
  StackManipulation withValues(List<? extends StackManipulation> paramList);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\implementation\bytecode\collection\CollectionFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */