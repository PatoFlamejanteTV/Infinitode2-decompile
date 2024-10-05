/*     */ package org.a.b.b;
/*     */ 
/*     */ import java.util.HashMap;
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
/*     */ 
/*     */ 
/*     */ public abstract class c
/*     */ {
/*     */   private final boolean a;
/*  32 */   private final Map<Integer, Integer> b = new HashMap<Integer, Integer>(250);
/*  33 */   private final Map<Integer, Integer> c = new HashMap<Integer, Integer>(250);
/*  34 */   private final Map<String, Integer> d = new HashMap<String, Integer>(250);
/*     */ 
/*     */   
/*  37 */   private final Map<Integer, Integer> e = new HashMap<Integer, Integer>();
/*  38 */   private final Map<Integer, String> f = new HashMap<Integer, String>(250);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   c(boolean paramBoolean) {
/*  47 */     this.a = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a() {
/*  57 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt1, int paramInt2, String paramString) {
/*  68 */     if (this.a)
/*     */     {
/*  70 */       throw new IllegalStateException("Not a Type 1-equivalent font");
/*     */     }
/*  72 */     this.b.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
/*  73 */     this.c.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
/*  74 */     this.d.put(paramString, Integer.valueOf(paramInt2));
/*  75 */     this.f.put(Integer.valueOf(paramInt1), paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt1, int paramInt2) {
/*  86 */     if (!this.a)
/*     */     {
/*  88 */       throw new IllegalStateException("Not a CIDFont");
/*     */     }
/*  90 */     this.b.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
/*  91 */     this.e.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int a(int paramInt) {
/* 102 */     if (this.a)
/*     */     {
/* 104 */       throw new IllegalStateException("Not a Type 1-equivalent font");
/*     */     }
/*     */     Integer integer;
/* 107 */     if ((integer = this.c.get(Integer.valueOf(paramInt))) == null)
/*     */     {
/* 109 */       return 0;
/*     */     }
/* 111 */     return integer.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int b(int paramInt) {
/* 122 */     if (this.a)
/*     */     {
/* 124 */       throw new IllegalStateException("Not a Type 1-equivalent font");
/*     */     }
/*     */     Integer integer;
/* 127 */     if ((integer = this.b.get(Integer.valueOf(paramInt))) == null)
/*     */     {
/* 129 */       return 0;
/*     */     }
/* 131 */     return integer.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int c(int paramInt) {
/* 142 */     if (!this.a)
/*     */     {
/* 144 */       throw new IllegalStateException("Not a CIDFont");
/*     */     }
/*     */     Integer integer;
/* 147 */     if ((integer = this.b.get(Integer.valueOf(paramInt))) == null)
/*     */     {
/* 149 */       return 0;
/*     */     }
/* 151 */     return integer.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int a(String paramString) {
/* 163 */     if (this.a)
/*     */     {
/* 165 */       throw new IllegalStateException("Not a Type 1-equivalent font");
/*     */     }
/*     */     Integer integer;
/* 168 */     if ((integer = this.d.get(paramString)) == null)
/*     */     {
/* 170 */       return 0;
/*     */     }
/* 172 */     return integer.intValue();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */