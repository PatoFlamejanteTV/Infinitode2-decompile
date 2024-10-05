/*     */ package org.a.c.g;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.c;
/*     */ import org.a.c.b.f;
/*     */ import org.a.c.b.i;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.s;
/*     */ import org.a.c.i.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   private final OutputStream a;
/*  46 */   private static byte[] b = new byte[] { 32 };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   private static byte[] c = new byte[] { 10 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public d(OutputStream paramOutputStream) {
/*  60 */     this.a = paramOutputStream;
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
/*     */   public final void a(Object... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/*  93 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Object object = paramVarArgs[b];
/*     */       
/*  95 */       a(object); b++; }
/*     */     
/*  97 */     this.a.write("\n".getBytes(a.a));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(List<?> paramList) {
/* 108 */     for (Object object : paramList)
/*     */     {
/* 110 */       a(object);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(Object paramObject) {
/* 116 */     if (paramObject instanceof s) {
/*     */       
/* 118 */       b.a((s)paramObject, this.a);
/* 119 */       this.a.write(b); return;
/*     */     } 
/* 121 */     if (paramObject instanceof f) {
/*     */       
/* 123 */       ((f)paramObject).a(this.a);
/* 124 */       this.a.write(b); return;
/*     */     } 
/* 126 */     if (paramObject instanceof i) {
/*     */       
/* 128 */       ((i)paramObject).a(this.a);
/* 129 */       this.a.write(b); return;
/*     */     } 
/* 131 */     if (paramObject instanceof c) {
/*     */       
/* 133 */       ((c)paramObject).a(this.a);
/* 134 */       this.a.write(b); return;
/*     */     } 
/* 136 */     if (paramObject instanceof j) {
/*     */       
/* 138 */       ((j)paramObject).a(this.a);
/* 139 */       this.a.write(b); return;
/*     */     } 
/* 141 */     if (paramObject instanceof org.a.c.b.a) {
/*     */       
/* 143 */       paramObject = paramObject;
/* 144 */       this.a.write(b.c);
/* 145 */       for (byte b = 0; b < paramObject.b(); b++) {
/*     */         
/* 147 */         a(paramObject.b(b));
/* 148 */         this.a.write(b);
/*     */       } 
/*     */       
/* 151 */       this.a.write(b.d); return;
/*     */     } 
/* 153 */     if (paramObject instanceof org.a.c.b.d) {
/*     */       
/* 155 */       paramObject = paramObject;
/* 156 */       this.a.write(b.a);
/* 157 */       for (Iterator<Map.Entry> iterator = paramObject.e().iterator(); iterator.hasNext();) {
/*     */         
/* 159 */         if ((entry = iterator.next()).getValue() != null) {
/*     */           
/* 161 */           a(entry.getKey());
/* 162 */           this.a.write(b);
/* 163 */           a(entry.getValue());
/* 164 */           this.a.write(b);
/*     */         } 
/*     */       } 
/* 167 */       this.a.write(b.b);
/* 168 */       this.a.write(b); return;
/*     */     } 
/* 170 */     if (paramObject instanceof org.a.c.a.a.a) {
/*     */ 
/*     */       
/* 173 */       if ((paramObject = paramObject).a().equals("BI")) {
/*     */         
/* 175 */         this.a.write("BI".getBytes(a.d));
/*     */         org.a.c.b.d d1;
/* 177 */         for (j j : (d1 = paramObject.c()).d()) {
/*     */           
/* 179 */           b b = d1.a(j);
/* 180 */           j.a(this.a);
/* 181 */           this.a.write(b);
/* 182 */           a(b);
/* 183 */           this.a.write(c);
/*     */         } 
/* 185 */         this.a.write("ID".getBytes(a.d));
/* 186 */         this.a.write(c);
/* 187 */         this.a.write(paramObject.b());
/* 188 */         this.a.write(c);
/* 189 */         this.a.write("EI".getBytes(a.d));
/* 190 */         this.a.write(c);
/*     */       }
/*     */       else {
/*     */         
/* 194 */         this.a.write(paramObject.a().getBytes(a.d));
/* 195 */         this.a.write(c);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } else {
/* 200 */       throw new IOException("Error:Unknown type in content stream:" + paramObject);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */