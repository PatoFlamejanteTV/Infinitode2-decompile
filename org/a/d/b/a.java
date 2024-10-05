/*     */ package org.a.d.b;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.a.d.b;
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
/*     */ public abstract class a
/*     */   extends b
/*     */ {
/*     */   private final m a;
/*     */   private final Map<String, String> b;
/*     */   
/*     */   public a(b paramb, String paramString) {
/*  39 */     super(paramb, paramString);
/*  40 */     this.a = new m();
/*  41 */     this.b = new HashMap<String, String>();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void c(String paramString1, String paramString2) {
/*  46 */     this.b.put(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Map<String, String> b() {
/*  56 */     return this.b;
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
/*     */   public final void a(b paramb) {
/*  75 */     this.a.a(paramb.e());
/*     */     
/*  77 */     this.a.a(paramb);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(b paramb) {
/*  88 */     this.a.b(paramb);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final m c() {
/*  99 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public final List<b> d() {
/* 104 */     return this.a.a();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\d\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */