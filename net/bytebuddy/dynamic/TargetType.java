/*    */ package net.bytebuddy.dynamic;
/*    */ 
/*    */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*    */ import net.bytebuddy.description.type.TypeDescription;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class TargetType
/*    */ {
/* 30 */   public static final TypeDescription DESCRIPTION = TypeDescription.ForLoadedType.of(TargetType.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SuppressFBWarnings(value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"}, justification = "Assuming component type for array type.")
/*    */   public static TypeDescription resolve(TypeDescription paramTypeDescription1, TypeDescription paramTypeDescription2) {
/* 42 */     byte b = 0;
/* 43 */     TypeDescription typeDescription = paramTypeDescription1;
/* 44 */     while (typeDescription.isArray()) {
/* 45 */       typeDescription = typeDescription.getComponentType();
/* 46 */       b++;
/*    */     } 
/* 48 */     if (typeDescription.represents(TargetType.class))
/* 49 */       return TypeDescription.ArrayProjection.of(paramTypeDescription2, b);  return paramTypeDescription1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private TargetType() {
/* 57 */     throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\dynamic\TargetType.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */