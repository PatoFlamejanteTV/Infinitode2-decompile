/*     */ package org.a.d.b;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.a.d.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class n
/*     */   extends c
/*     */ {
/*     */   private static boolean b(Object paramObject) {
/*  90 */     if (paramObject instanceof java.util.Calendar)
/*     */     {
/*  92 */       return true;
/*     */     }
/*  94 */     if (paramObject instanceof String) {
/*     */       
/*     */       try {
/*     */         
/*  98 */         a.a((String)paramObject);
/*  99 */         return true;
/*     */       }
/* 101 */       catch (IOException iOException) {
/*     */         
/* 103 */         return false;
/*     */       } 
/*     */     }
/* 106 */     return false;
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
/*     */   public final void a(Object paramObject) {
/* 118 */     if (!b(paramObject)) {
/*     */       
/* 120 */       if (paramObject == null)
/*     */       {
/* 122 */         throw new IllegalArgumentException("Value null is not allowed for the Date type");
/*     */       }
/*     */       
/* 125 */       throw new IllegalArgumentException("Value given is not allowed for the Date type: " + paramObject
/*     */           
/* 127 */           .getClass() + ", value: " + paramObject);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 132 */     if (paramObject instanceof String)
/*     */     {
/* 134 */       throw null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 139 */     throw null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/* 149 */     throw null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\d\b\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */