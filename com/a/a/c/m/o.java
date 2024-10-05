/*    */ package com.a.a.c.m;
/*    */ 
/*    */ import com.a.a.c.m.a.e;
/*    */ import java.io.Serializable;
/*    */ import java.util.Map;
/*    */ import java.util.function.BiConsumer;
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
/*    */ public final class o<K, V>
/*    */   implements q<K, V>, Serializable
/*    */ {
/*    */   private transient e<K, V> a;
/*    */   
/*    */   public o(int paramInt1, int paramInt2) {
/* 36 */     this
/*    */ 
/*    */ 
/*    */       
/* 40 */       .a = (new e.b()).a(paramInt1).a(paramInt2).b(4).a();
/*    */   }
/*    */ 
/*    */   
/*    */   public final V a(K paramK, V paramV) {
/* 45 */     return (V)this.a.put(paramK, paramV);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final V b(K paramK, V paramV) {
/* 53 */     return (V)this.a.putIfAbsent(paramK, paramV);
/*    */   }
/*    */ 
/*    */   
/*    */   public final V a(Object paramObject) {
/* 58 */     return (V)this.a.get(paramObject);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final int a() {
/* 64 */     return this.a.size();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void a(BiConsumer<K, V> paramBiConsumer) {
/* 73 */     for (Map.Entry entry : this.a.entrySet())
/* 74 */       paramBiConsumer.accept((K)entry.getKey(), (V)entry.getValue()); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */