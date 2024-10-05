/*    */ package com.a.a.c.c.b;
/*    */ 
/*    */ import com.a.a.b.c.d;
/*    */ import com.a.a.b.j;
/*    */ import com.a.a.c.c.m;
/*    */ import com.a.a.c.c.v;
/*    */ import com.a.a.c.c.x;
/*    */ import com.a.a.c.f;
/*    */ import com.a.a.c.g;
/*    */ import com.a.a.c.j;
/*    */ import com.a.a.c.v;
/*    */ import com.a.a.c.w;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class s
/*    */   extends x.a
/*    */ {
/*    */   public s() {
/* 25 */     super(j.class);
/*    */   }
/*    */   
/*    */   public final boolean o() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public final v[] a(f paramf) {
/* 33 */     j j1 = paramf.b(int.class);
/* 34 */     j j2 = paramf.b(long.class);
/* 35 */     return new v[] {
/*    */ 
/*    */         
/* 38 */         (v)a("sourceRef", paramf.b(Object.class), 0), 
/* 39 */         (v)a("byteOffset", j2, 1), 
/* 40 */         (v)a("charOffset", j2, 2), 
/* 41 */         (v)a("lineNr", j1, 3), 
/* 42 */         (v)a("columnNr", j1, 4)
/*    */       };
/*    */   }
/*    */   
/*    */   private static m a(String paramString, j paramj, int paramInt) {
/* 47 */     return m.a(w.a(paramString), paramj, null, null, null, null, paramInt, null, v.a);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Object a(g paramg, Object[] paramArrayOfObject) {
/* 56 */     d d = d.a(paramArrayOfObject[0]);
/* 57 */     return new j(d, a(paramArrayOfObject[1]), a(paramArrayOfObject[2]), 
/* 58 */         b(paramArrayOfObject[3]), b(paramArrayOfObject[4]));
/*    */   }
/*    */   
/*    */   private static final long a(Object paramObject) {
/* 62 */     return (paramObject == null) ? 0L : ((Number)paramObject).longValue();
/*    */   }
/*    */   
/*    */   private static final int b(Object paramObject) {
/* 66 */     return (paramObject == null) ? 0 : ((Number)paramObject).intValue();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */