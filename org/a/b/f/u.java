/*     */ package org.a.b.f;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Comparator;
/*     */ import org.a.a.a.c;
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
/*     */ 
/*     */ public class u
/*     */ {
/*  33 */   private static final org.a.a.a.a a = c.a(u.class);
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
/*     */   private a b;
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
/*     */   public final void a(ak paramak, int paramInt) {
/*  68 */     if (paramInt == 0) {
/*     */       
/*  70 */       a(paramak); return;
/*     */     } 
/*  72 */     if (paramInt != 1)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  78 */       throw new IllegalStateException();
/*     */     }
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
/*     */   private void a(ak paramak) {
/*     */     int i;
/* 183 */     if ((i = paramak.c()) != 0) {
/*     */       
/* 185 */       (new StringBuilder("Unsupported kerning sub-table version: ")).append(i);
/*     */       
/*     */       return;
/*     */     } 
/* 189 */     if ((i = paramak.c()) < 6)
/*     */     {
/* 191 */       throw new IOException("Kerning sub-table too short, got " + i + " bytes, expect 6 or more.");
/*     */     }
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
/* 208 */     if ((i = a(i = paramak.c(), 65280, 8)) == 0) {
/*     */       
/* 210 */       b(paramak); return;
/*     */     } 
/* 212 */     if (i != 2)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 218 */       (new StringBuilder("Skipped kerning subtable due to an unsupported kerning subtable version: ")).append(i);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(ak paramak) {
/* 224 */     this.b = new b((byte)0);
/* 225 */     this.b.a(paramak);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int a(int paramInt1, int paramInt2, int paramInt3) {
/* 245 */     return (paramInt1 & paramInt2) >> paramInt3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class b
/*     */     implements Comparator<int[]>, a
/*     */   {
/*     */     private int[][] a;
/*     */ 
/*     */ 
/*     */     
/*     */     private b() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(ak param1ak) {
/* 263 */       int i = param1ak.c();
/* 264 */       param1ak.c();
/* 265 */       param1ak.c();
/* 266 */       param1ak.c();
/* 267 */       this.a = new int[i][3];
/* 268 */       for (byte b1 = 0; b1 < i; b1++) {
/*     */         
/* 270 */         int j = param1ak.c();
/* 271 */         int k = param1ak.c();
/* 272 */         short s = param1ak.d();
/* 273 */         this.a[b1][0] = j;
/* 274 */         this.a[b1][1] = k;
/* 275 */         this.a[b1][2] = s;
/*     */       } 
/*     */     }
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
/*     */     private static int a(int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
/* 294 */       if (!b && param1ArrayOfint1 == null) throw new AssertionError(); 
/* 295 */       if (!b && param1ArrayOfint1.length < 2) throw new AssertionError(); 
/* 296 */       if (!b && param1ArrayOfint2 == null) throw new AssertionError(); 
/* 297 */       if (!b && param1ArrayOfint2.length < 2) throw new AssertionError(); 
/* 298 */       int k = param1ArrayOfint1[0];
/* 299 */       int m = param1ArrayOfint2[0];
/* 300 */       if (k < m)
/*     */       {
/* 302 */         return -1;
/*     */       }
/* 304 */       if (k > m)
/*     */       {
/* 306 */         return 1;
/*     */       }
/*     */ 
/*     */       
/* 310 */       int i = param1ArrayOfint1[1];
/* 311 */       int j = param1ArrayOfint2[1];
/* 312 */       if (i < j)
/*     */       {
/* 314 */         return -1;
/*     */       }
/* 316 */       if (i > j)
/*     */       {
/* 318 */         return 1;
/*     */       }
/*     */ 
/*     */       
/* 322 */       return 0;
/*     */     }
/*     */   }
/*     */   
/*     */   private static interface a {
/*     */     void a(ak param1ak);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */