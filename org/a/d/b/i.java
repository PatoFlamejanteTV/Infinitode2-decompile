/*     */ package org.a.d.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class i
/*     */   extends c
/*     */ {
/*     */   public final void a(Object paramObject) {
/*  81 */     if (paramObject instanceof Boolean)
/*     */     {
/*  83 */       throw null;
/*     */     }
/*  85 */     if (paramObject instanceof String) {
/*     */ 
/*     */       
/*  88 */       String str = paramObject.toString().trim().toUpperCase();
/*  89 */       if ("TRUE".equals(str))
/*     */       {
/*  91 */         throw null;
/*     */       }
/*  93 */       if ("FALSE".equals(str))
/*     */       {
/*  95 */         throw null;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 100 */       throw new IllegalArgumentException("Not a valid boolean value : '" + paramObject + "'");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     throw new IllegalArgumentException("Value given is not allowed for the Boolean type.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/* 113 */     throw null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\d\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */