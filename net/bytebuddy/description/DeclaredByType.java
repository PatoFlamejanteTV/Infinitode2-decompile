package net.bytebuddy.description;

import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface DeclaredByType {
  @MaybeNull
  TypeDefinition getDeclaringType();
  
  public static interface WithMandatoryDeclaration extends DeclaredByType {
    TypeDefinition getDeclaringType();
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\description\DeclaredByType.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */