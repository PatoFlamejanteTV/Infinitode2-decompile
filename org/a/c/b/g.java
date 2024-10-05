/*     */ package org.a.c.b;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.FilterInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import org.a.c.c.j;
/*     */ import org.a.c.c.k;
/*     */ import org.a.c.c.l;
/*     */ import org.a.c.d.d;
/*     */ import org.a.c.d.e;
/*     */ import org.a.c.d.f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class g
/*     */   extends FilterInputStream
/*     */ {
/*     */   private final List<k> a;
/*     */   
/*     */   static g a(List<l> paramList, d paramd, InputStream paramInputStream, org.a.c.d.g paramg, j paramj) {
/*  64 */     ArrayList<k> arrayList = new ArrayList();
/*  65 */     InputStream inputStream = paramInputStream;
/*  66 */     if (paramList.isEmpty()) {
/*     */       
/*  68 */       inputStream = paramInputStream;
/*     */     } else {
/*     */       HashSet<l> hashSet;
/*     */ 
/*     */       
/*  73 */       if ((hashSet = new HashSet<l>(paramList)).size() != paramList.size())
/*     */       {
/*  75 */         throw new IOException("Duplicate");
/*     */       }
/*     */       
/*  78 */       for (byte b = 0; b < paramList.size(); b++) {
/*     */         h h;
/*  80 */         if (paramg != null) {
/*     */ 
/*     */           
/*  83 */           e e = paramg.d();
/*  84 */           k k = ((l)paramList.get(b)).a(inputStream, (OutputStream)new d((f)e), paramd, b, paramj);
/*  85 */           arrayList.add(k);
/*  86 */           h = new h(e, e);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  98 */           ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  99 */           k k = ((l)paramList.get(b)).a((InputStream)h, byteArrayOutputStream, paramd, b, paramj);
/* 100 */           arrayList.add(k);
/* 101 */           inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
/*     */         } 
/*     */       } 
/*     */     } 
/* 105 */     return new g(inputStream, arrayList);
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
/*     */   private g(InputStream paramInputStream, List<k> paramList) {
/* 118 */     super(paramInputStream);
/* 119 */     this.a = paramList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k a() {
/* 129 */     if (this.a.isEmpty())
/*     */     {
/* 131 */       return k.a;
/*     */     }
/*     */ 
/*     */     
/* 135 */     return this.a.get(this.a.size() - 1);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */