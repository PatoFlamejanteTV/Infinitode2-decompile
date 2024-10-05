/*    */ package com.esotericsoftware.kryo.util;
/*    */ 
/*    */ import java.lang.reflect.TypeVariable;
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
/*    */ public final class NoGenerics
/*    */   implements Generics
/*    */ {
/* 27 */   public static final Generics INSTANCE = new NoGenerics();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void pushGenericType(Generics.GenericType paramGenericType) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void popGenericType() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Generics.GenericType[] nextGenericTypes() {
/* 43 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public final Class nextGenericClass() {
/* 48 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int pushTypeVariables(Generics.GenericsHierarchy paramGenericsHierarchy, Generics.GenericType[] paramArrayOfGenericType) {
/* 53 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final void popTypeVariables(int paramInt) {}
/*    */ 
/*    */   
/*    */   public final Class resolveTypeVariable(TypeVariable paramTypeVariable) {
/* 62 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int getGenericTypesSize() {
/* 67 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\NoGenerics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */