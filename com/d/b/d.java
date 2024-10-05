/*    */ package com.d.b;
/*    */ 
/*    */ import com.d.i.a.r;
/*    */ import java.util.LinkedHashMap;
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
/*    */ final class d
/*    */   extends LinkedHashMap<String, r>
/*    */ {
/*    */   d(c paramc, int paramInt, float paramFloat, boolean paramBoolean) {
/* 55 */     super(16, 0.75F, true);
/*    */   }
/*    */   
/*    */   protected final boolean removeEldestEntry(Map.Entry<String, r> paramEntry) {
/* 59 */     return (size() > 16);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\b\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */