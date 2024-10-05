/*    */ package com.vladsch.flexmark.util.misc;
/*    */ 
/*    */ import java.util.Map;
/*    */ 
/*    */ public interface Paired<K, V> extends Map.Entry<K, V> {
/*    */   K getFirst();
/*    */   
/*    */   V getSecond();
/*    */   
/*    */   default K component1() {
/* 11 */     return getFirst();
/*    */   }
/*    */   
/*    */   default V component2() {
/* 15 */     return getSecond();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\misc\Paired.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */