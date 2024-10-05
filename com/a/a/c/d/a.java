/*    */ package com.a.a.c.d;
/*    */ 
/*    */ import com.a.a.b.j;
/*    */ import com.a.a.b.l;
/*    */ import java.util.Collection;
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
/*    */ public final class a
/*    */   extends g
/*    */ {
/*    */   private a(l paraml, String paramString1, j paramj, Class<?> paramClass, String paramString2, Collection<Object> paramCollection) {
/* 28 */     super(paraml, paramString1, paramj, paramClass, paramString2, paramCollection);
/*    */   }
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
/*    */   public static a a(l paraml, Object paramObject, String paramString, Collection<Object> paramCollection) {
/*    */     Class<?> clazz;
/* 57 */     if (paramObject instanceof Class) {
/* 58 */       clazz = (Class)paramObject;
/*    */     } else {
/* 60 */       clazz = paramObject.getClass();
/*    */     } 
/* 62 */     String str = String.format("Ignored field \"%s\" (class %s) encountered; mapper configured not to allow this", new Object[] { paramString, clazz
/* 63 */           .getName() });
/*    */     
/*    */     a a1;
/*    */     
/* 67 */     (a1 = new a(paraml, str, paraml.e(), clazz, paramString, paramCollection)).a(paramObject, paramString);
/* 68 */     return a1;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\d\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */