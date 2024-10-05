/*    */ package com.a.a.c.f;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class m
/*    */   implements Iterable<k>
/*    */ {
/*    */   private Map<z, k> a;
/*    */   
/*    */   public m() {}
/*    */   
/*    */   public m(Map<z, k> paramMap) {
/* 22 */     this.a = paramMap;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final k a(String paramString, Class<?>[] paramArrayOfClass) {
/* 31 */     if (this.a == null) {
/* 32 */       return null;
/*    */     }
/* 34 */     return this.a.get(new z(paramString, paramArrayOfClass));
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
/*    */   public final Iterator<k> iterator() {
/* 54 */     if (this.a == null) {
/* 55 */       return Collections.emptyIterator();
/*    */     }
/* 57 */     return this.a.values().iterator();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */