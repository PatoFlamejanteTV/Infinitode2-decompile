package net.bytebuddy.utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface Invoker {
  Object newInstance(Constructor<?> paramConstructor, Object[] paramArrayOfObject);
  
  @MaybeNull
  Object invoke(Method paramMethod, @MaybeNull Object paramObject, @MaybeNull Object[] paramArrayOfObject);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\Invoker.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */