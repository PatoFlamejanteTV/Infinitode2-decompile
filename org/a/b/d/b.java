/*    */ package org.a.b.d;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public abstract class b
/*    */ {
/* 33 */   private Map<Integer, String> a = new HashMap<Integer, String>(250);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 38 */   private Map<String, Integer> b = new HashMap<String, Integer>(250);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final void b(int paramInt, String paramString) {
/* 48 */     this.a.put(Integer.valueOf(paramInt), paramString);
/* 49 */     this.b.put(paramString, Integer.valueOf(paramInt));
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
/*    */   public String a(int paramInt) {
/*    */     String str;
/* 73 */     if ((str = this.a.get(Integer.valueOf(paramInt))) != null)
/*    */     {
/* 75 */       return str;
/*    */     }
/* 77 */     return ".notdef";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Map<Integer, String> b() {
/* 87 */     return Collections.unmodifiableMap(this.a);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */