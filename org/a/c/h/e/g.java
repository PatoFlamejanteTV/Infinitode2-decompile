/*    */ package org.a.c.h.e;
/*    */ 
/*    */ import java.lang.ref.SoftReference;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import org.a.b.b;
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
/*    */ public final class g
/*    */ {
/* 33 */   private final Map<i, SoftReference<b>> a = new ConcurrentHashMap<i, SoftReference<b>>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void a(i parami, b paramb) {
/* 41 */     this.a.put(parami, new SoftReference<b>(paramb));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final b a(i parami) {
/*    */     SoftReference<b> softReference;
/* 50 */     return ((softReference = this.a.get(parami)) != null) ? softReference.get() : null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */