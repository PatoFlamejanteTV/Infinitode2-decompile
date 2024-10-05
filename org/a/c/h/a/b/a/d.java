/*     */ package org.a.c.h.a.b.a;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Stack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class d
/*     */ {
/*  29 */   private final List<Object> a = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(String paramString) {
/*  37 */     this.a.add(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(int paramInt) {
/*  46 */     this.a.add(Integer.valueOf(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(float paramFloat) {
/*  55 */     this.a.add(Float.valueOf(paramFloat));
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
/*     */   public final void a(d paramd) {
/*  73 */     this.a.add(paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(a parama) {
/*  82 */     Stack<Object> stack = parama.a();
/*  83 */     for (Iterator<Object> iterator = this.a.iterator(); iterator.hasNext(); ) {
/*     */       String str;
/*  85 */       if (str = (String)iterator.next() instanceof String) {
/*     */         
/*  87 */         str = str;
/*     */         f f;
/*  89 */         if ((f = parama.b().a(str)) != null) {
/*     */           
/*  91 */           f.a(parama);
/*     */           
/*     */           continue;
/*     */         } 
/*  95 */         throw new UnsupportedOperationException("Unknown operator or name: " + str);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 100 */       stack.push(str);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 105 */     while (!stack.isEmpty() && stack.peek() instanceof d) {
/*     */       d d1;
/*     */       
/* 108 */       (d1 = (d)stack.pop()).a(parama);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\a\b\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */