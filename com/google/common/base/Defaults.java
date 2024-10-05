/*    */ package com.google.common.base;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ElementTypesAreNonnullByDefault
/*    */ public final class Defaults
/*    */ {
/* 33 */   private static final Double DOUBLE_DEFAULT = Double.valueOf(0.0D);
/* 34 */   private static final Float FLOAT_DEFAULT = Float.valueOf(0.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> T defaultValue(Class<T> paramClass) {
/* 44 */     Preconditions.checkNotNull(paramClass);
/* 45 */     if (paramClass.isPrimitive()) {
/* 46 */       if (paramClass == boolean.class)
/* 47 */         return (T)Boolean.FALSE; 
/* 48 */       if (paramClass == char.class)
/* 49 */         return (T)Character.valueOf(false); 
/* 50 */       if (paramClass == byte.class)
/* 51 */         return (T)Byte.valueOf((byte)0); 
/* 52 */       if (paramClass == short.class)
/* 53 */         return (T)Short.valueOf((short)0); 
/* 54 */       if (paramClass == int.class)
/* 55 */         return (T)Integer.valueOf(0); 
/* 56 */       if (paramClass == long.class)
/* 57 */         return (T)Long.valueOf(0L); 
/* 58 */       if (paramClass == float.class)
/* 59 */         return (T)FLOAT_DEFAULT; 
/* 60 */       if (paramClass == double.class) {
/* 61 */         return (T)DOUBLE_DEFAULT;
/*    */       }
/*    */     } 
/* 64 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Defaults.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */