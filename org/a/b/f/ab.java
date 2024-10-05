/*     */ package org.a.b.f;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.InputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ab
/*     */   extends al
/*     */ {
/*     */   public ab() {}
/*     */   
/*     */   public ab(boolean paramBoolean) {
/*  44 */     this(true, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ab(boolean paramBoolean1, boolean paramBoolean2) {
/*  55 */     super(paramBoolean1, paramBoolean2);
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
/*     */   public final ad a(File paramFile) {
/*  67 */     return (ad)super.b(paramFile);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final ad a(InputStream paramInputStream) {
/*  73 */     return (ad)super.b(paramInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ad c(ak paramak) {
/*  79 */     return (ad)super.b(paramak);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static ad d(ak paramak) {
/*  85 */     return new ad(paramak);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final an a(ap paramap, String paramString) {
/*  93 */     if (paramString.equals("BASE") || paramString.equals("GDEF") || paramString.equals("GPOS") || paramString
/*  94 */       .equals("GSUB") || paramString.equals("JSTF"))
/*     */     {
/*  96 */       return new ac(paramap);
/*     */     }
/*  98 */     if (paramString.equals("CFF "))
/*     */     {
/* 100 */       return new b(paramap);
/*     */     }
/*     */ 
/*     */     
/* 104 */     return super.a(paramap, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean a() {
/* 111 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */