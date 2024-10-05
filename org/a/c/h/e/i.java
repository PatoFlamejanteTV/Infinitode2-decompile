/*     */ package org.a.c.h.e;
/*     */ 
/*     */ import org.a.b.b;
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
/*     */ public abstract class i
/*     */ {
/*     */   public abstract String a();
/*     */   
/*     */   public abstract h b();
/*     */   
/*     */   public abstract b c();
/*     */   
/*     */   public abstract b d();
/*     */   
/*     */   public abstract int e();
/*     */   
/*     */   public abstract int f();
/*     */   
/*     */   final int k() {
/*     */     int j;
/*  66 */     switch (j = f()) {
/*     */       case -1:
/*  68 */         return 0;
/*  69 */       case 0: return 0;
/*  70 */       case 100: return 2;
/*  71 */       case 200: return 3;
/*  72 */       case 300: return 4;
/*  73 */       case 400: return 5;
/*  74 */       case 500: return 6;
/*  75 */       case 600: return 7;
/*  76 */       case 700: return 8;
/*  77 */       case 800: return 9;
/*  78 */       case 900: return 10;
/*  79 */     }  return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int g();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int h();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final long l() {
/*  98 */     long l1 = g() & 0xFFFFFFFFL;
/*     */     long l2;
/* 100 */     return (l2 = h() & 0xFFFFFFFFL) << 32L | l1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int i();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract z j();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 119 */     return a() + " (" + b() + ", mac: 0x" + 
/* 120 */       Integer.toHexString(i()) + ", os/2: 0x" + 
/* 121 */       Integer.toHexString(e()) + ", cid: " + 
/* 122 */       c() + ")";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */