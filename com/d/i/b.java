/*     */ package com.d.i;
/*     */ 
/*     */ import com.d.c.f.c;
/*     */ import com.d.e.ac;
/*     */ import com.d.e.v;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.w3c.dom.Element;
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
/*     */ public final class b
/*     */   extends c
/*     */ {
/*     */   private List<q> a;
/*     */   
/*     */   public b(Element paramElement) {
/*  43 */     a(paramElement);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void b(v paramv) {
/*  48 */     a(paramv, 0, m(paramv), true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int d_() {
/*  53 */     return Y().d_();
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
/*     */   public final List<q> f() {
/*  67 */     return this.a;
/*     */   }
/*     */   
/*     */   public final void a(List<q> paramList) {
/*  71 */     this.a = paramList;
/*     */   }
/*     */   
/*     */   private static boolean a(ac paramac) {
/*     */     c c1;
/*  76 */     if ((c1 = paramac.a()).C() || c1.A() || c1.B() || c1.P()) return true;  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean n() {
/*  81 */     return G().stream().allMatch(b::a);
/*     */   }
/*     */   
/*     */   public final void a(int paramInt) {
/*  85 */     for (Iterator<ac> iterator = G().iterator(); iterator.hasNext();) {
/*  86 */       if (ac = iterator.next() instanceof c && (
/*     */         
/*  88 */         ac = ac).K()) {
/*  89 */         ac.L().a(paramInt);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean k() {
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a_(v paramv) {
/* 102 */     a(paramv, U().a());
/*     */   }
/*     */ 
/*     */   
/*     */   public final c c() {
/* 107 */     throw new IllegalArgumentException("cannot be copied");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\i\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */