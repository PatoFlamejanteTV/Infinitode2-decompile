/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.c.c.u;
/*     */ import com.a.a.c.c.v;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class x
/*     */ {
/*     */   public final x a;
/*     */   public final Object b;
/*     */   
/*     */   protected x(x paramx, Object paramObject) {
/*  23 */     this.a = paramx;
/*  24 */     this.b = paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void a(Object paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class c
/*     */     extends x
/*     */   {
/*     */     private v c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public c(x param1x, Object param1Object, v param1v) {
/*  52 */       super(param1x, param1Object);
/*  53 */       this.c = param1v;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(Object param1Object) {
/*  60 */       this.c.a(param1Object, this.b);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class a
/*     */     extends x
/*     */   {
/*     */     private u c;
/*     */ 
/*     */ 
/*     */     
/*     */     private String d;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(x param1x, Object param1Object, u param1u, String param1String) {
/*  80 */       super(param1x, param1Object);
/*  81 */       this.c = param1u;
/*  82 */       this.d = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(Object param1Object) {
/*  89 */       this.c.a(param1Object, this.d, this.b);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class b
/*     */     extends x
/*     */   {
/*     */     private Object c;
/*     */ 
/*     */ 
/*     */     
/*     */     public b(x param1x, Object param1Object1, Object param1Object2) {
/* 104 */       super(param1x, param1Object1);
/* 105 */       this.c = param1Object2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(Object param1Object) {
/* 113 */       ((Map<Object, Object>)param1Object).put(this.c, this.b);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */