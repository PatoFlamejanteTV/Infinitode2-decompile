/*     */ package org.a.b.h.a;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.net.URI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */ {
/*  33 */   private static final a a = c.a(b.class);
/*     */   
/*  35 */   private a b = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static a b() {
/*     */     String str;
/*  47 */     if ((str = System.getProperty("os.name")).startsWith("Windows"))
/*     */     {
/*  49 */       return new g();
/*     */     }
/*  51 */     if (str.startsWith("Mac"))
/*     */     {
/*  53 */       return new c();
/*     */     }
/*  55 */     if (str.startsWith("OS/400"))
/*     */     {
/*  57 */       return new e();
/*     */     }
/*     */ 
/*     */     
/*  61 */     return new f();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<URI> a() {
/*  72 */     if (this.b == null)
/*     */     {
/*  74 */       this.b = b();
/*     */     }
/*  76 */     List<File> list = this.b.a();
/*  77 */     ArrayList<URI> arrayList = new ArrayList();
/*  78 */     for (File file : list)
/*     */     {
/*  80 */       a(file, arrayList);
/*     */     }
/*  82 */     return arrayList;
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
/*     */   private void a(File paramFile, List<URI> paramList) {
/* 111 */     if (paramFile.isDirectory()) {
/*     */       File[] arrayOfFile;
/*     */       
/* 114 */       if ((arrayOfFile = paramFile.listFiles()) != null) {
/*     */         int i; byte b1;
/* 116 */         for (i = (arrayOfFile = arrayOfFile).length, b1 = 0; b1 < i; b1++) {
/*     */           File file;
/* 118 */           if ((file = arrayOfFile[b1]).isDirectory()) {
/*     */ 
/*     */             
/* 121 */             if (!file.getName().startsWith("."))
/*     */             {
/*     */ 
/*     */               
/* 125 */               a(file, paramList);
/*     */             }
/*     */           } else {
/*     */             
/* 129 */             if (a.a())
/*     */             {
/* 131 */               (new StringBuilder("checkFontfile check ")).append(file);
/*     */             }
/* 133 */             if (a(file)) {
/*     */               
/* 135 */               if (a.a())
/*     */               {
/* 137 */                 (new StringBuilder("checkFontfile found ")).append(file);
/*     */               }
/* 139 */               paramList.add(file.toURI());
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(File paramFile) {
/*     */     String str;
/* 156 */     if (((str = paramFile.getName().toLowerCase(Locale.US)).endsWith(".ttf") || str.endsWith(".otf") || str.endsWith(".pfb") || str.endsWith(".ttc")) && 
/*     */       
/* 158 */       !str.startsWith("fonts.")) return true; 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\h\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */