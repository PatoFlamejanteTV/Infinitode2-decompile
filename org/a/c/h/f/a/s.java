/*     */ package org.a.c.h.f.a;
/*     */ 
/*     */ import java.awt.color.ICC_Profile;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.InputStream;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.a.c;
/*     */ import org.a.c.h.a.i;
/*     */ import org.a.c.h.b;
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
/*     */ public final class s
/*     */   implements c
/*     */ {
/*     */   private final d a;
/*     */   
/*     */   public s(b paramb, InputStream paramInputStream) {
/*  46 */     this.a = new d();
/*  47 */     this.a.a(j.dN, (b)j.cH);
/*  48 */     this.a.a(j.dn, (b)j.bv);
/*  49 */     i i = a(paramb, paramInputStream);
/*  50 */     this.a.a(j.az, (c)i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final b f() {
/*  61 */     return (b)this.a;
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
/*     */   public final void a(String paramString) {
/*  76 */     this.a.b(j.bI, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(String paramString) {
/*  86 */     this.a.b(j.cF, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void c(String paramString) {
/*  96 */     this.a.b(j.cG, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void d(String paramString) {
/* 106 */     this.a.b(j.df, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static i a(b paramb, InputStream paramInputStream) {
/* 112 */     ICC_Profile iCC_Profile = ICC_Profile.getInstance(paramInputStream);
/*     */     i i;
/* 114 */     (i = new i(paramb, new ByteArrayInputStream(iCC_Profile.getData()), j.bc)).a().a(j.co, iCC_Profile.getNumComponents());
/* 115 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */