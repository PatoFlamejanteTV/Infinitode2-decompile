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
/*    */ public final class h
/*    */   extends g
/*    */ {
/*    */   private h(l paraml, String paramString1, j paramj, Class<?> paramClass, String paramString2, Collection<Object> paramCollection) {
/* 24 */     super(paraml, paramString1, paramj, paramClass, paramString2, paramCollection);
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
/*    */   public static h a(l paraml, Object paramObject, String paramString, Collection<Object> paramCollection) {
/*    */     Class<?> clazz;
/* 53 */     if (paramObject instanceof Class) {
/* 54 */       clazz = (Class)paramObject;
/*    */     } else {
/* 56 */       clazz = paramObject.getClass();
/*    */     } 
/* 58 */     String str = String.format("Unrecognized field \"%s\" (class %s), not marked as ignorable", new Object[] { paramString, clazz
/* 59 */           .getName() });
/*    */     
/*    */     h h1;
/*    */     
/* 63 */     (h1 = new h(paraml, str, paraml.e(), clazz, paramString, paramCollection)).a(paramObject, paramString);
/* 64 */     return h1;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\d\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */