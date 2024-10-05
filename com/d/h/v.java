/*     */ package com.d.h;
/*     */ 
/*     */ import com.d.e.aa;
/*     */ import com.d.j.f;
/*     */ import com.d.l.c;
/*     */ import com.d.m.f;
/*     */ import com.d.m.l;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URI;
/*     */ import java.util.Locale;
/*     */ import java.util.logging.Level;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class v
/*     */   extends c
/*     */ {
/*     */   private aa b;
/*     */   private final m c;
/*     */   
/*     */   public v(m paramm) {
/*  44 */     this.c = paramm;
/*     */   }
/*     */   
/*     */   private static byte[] a(InputStream paramInputStream) {
/*  48 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(paramInputStream.available());
/*  49 */     byte[] arrayOfByte = new byte[10240];
/*     */     int i;
/*  51 */     while ((i = paramInputStream.read(arrayOfByte)) != -1) {
/*  52 */       byteArrayOutputStream.write(arrayOfByte, 0, i);
/*     */     }
/*  54 */     byteArrayOutputStream.close();
/*  55 */     return byteArrayOutputStream.toByteArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public final f b(String paramString) {
/*     */     String str;
/*  61 */     if ((str = f(paramString)) == null) {
/*  62 */       l.e(Level.INFO, "URI resolver rejected loading image at (" + paramString + ")");
/*  63 */       return new f(paramString, null);
/*     */     } 
/*     */     
/*     */     f f;
/*     */     
/*  68 */     if ((f = (f)this.a.get(str)) != null && f.d() instanceof i) {
/*     */       
/*  70 */       i i1 = (i)f.d();
/*  71 */       i i2 = new i(i1.c(), i1.f(), i1.a(), i1.b(), i1.g(), i1.e());
/*  72 */       return new f(f.e(), i2);
/*     */     } 
/*     */     
/*  75 */     if (f.a(str)) {
/*  76 */       f = h(str);
/*  77 */       this.c.a((i)f.d());
/*  78 */       this.a.put(str, f);
/*     */     } else {
/*     */       InputStream inputStream;
/*     */       
/*  82 */       if ((inputStream = g(str)) != null) {
/*     */         try {
/*     */           URI uRI;
/*  85 */           if ((uRI = new URI(paramString)).getPath() == null || 
/*     */             
/*  87 */             !uRI.getPath().toLowerCase(Locale.US).endsWith(".pdf")) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*  98 */             byte[] arrayOfByte = a(inputStream);
/*  99 */             i i = new i(arrayOfByte, paramString);
/* 100 */             a(i);
/* 101 */             this.c.a(i);
/* 102 */             f = new f(str, i);
/*     */           } 
/* 104 */           this.a.put(str, f);
/* 105 */         } catch (Exception exception) {
/* 106 */           l.a("Can't read image file; unexpected problem for URI '" + paramString + "'", exception);
/*     */         } finally {
/*     */ 
/*     */           
/*     */           try {
/* 111 */             inputStream.close();
/* 112 */           } catch (IOException iOException) {}
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 118 */       if (f != null) {
/* 119 */         f = new f(f.e(), f.d());
/*     */       } else {
/* 121 */         f = new f(paramString, null);
/*     */       } 
/*     */     } 
/* 124 */     return f;
/*     */   }
/*     */   
/*     */   private f h(String paramString) {
/*     */     try {
/* 129 */       byte[] arrayOfByte = f.c(paramString);
/* 130 */       i i = new i(arrayOfByte, paramString);
/* 131 */       a(i);
/* 132 */       return new f(null, i);
/* 133 */     } catch (Exception exception) {
/* 134 */       l.a("Can't read XHTML embedded image.", exception);
/*     */       
/* 136 */       return new f(null, null);
/*     */     } 
/*     */   }
/*     */   private void a(i parami) {
/*     */     float f;
/* 141 */     if ((f = this.b.s()) != 1.0F) {
/* 142 */       parami.a((int)(parami.a() * f), (int)(parami.b() * f));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(aa paramaa) {
/* 151 */     this.b = paramaa;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\v.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */