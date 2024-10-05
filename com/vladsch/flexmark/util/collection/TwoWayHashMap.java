/*    */ package com.vladsch.flexmark.util.collection;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TwoWayHashMap<F, S>
/*    */ {
/*  9 */   private HashMap<F, S> fToSMap = new HashMap<>();
/* 10 */   private HashMap<S, F> sToFMap = new HashMap<>();
/*    */   
/*    */   public void add(F paramF, S paramS) {
/* 13 */     this.fToSMap.put(paramF, paramS);
/* 14 */     this.sToFMap.put(paramS, paramF);
/*    */   }
/*    */   
/*    */   public S getSecond(F paramF) {
/* 18 */     return this.fToSMap.get(paramF);
/*    */   }
/*    */   
/*    */   public F getFirst(S paramS) {
/* 22 */     return this.sToFMap.get(paramS);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\TwoWayHashMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */