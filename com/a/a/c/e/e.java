/*    */ package com.a.a.c.e;
/*    */ 
/*    */ import com.a.a.b.l;
/*    */ import com.a.a.b.o;
/*    */ import com.a.a.c.c.b.ai;
/*    */ import com.a.a.c.g;
/*    */ import java.io.File;
/*    */ import java.net.URI;
/*    */ import java.net.URISyntaxException;
/*    */ import java.nio.file.FileSystemNotFoundException;
/*    */ import java.nio.file.Path;
/*    */ import java.nio.file.Paths;
/*    */ import java.nio.file.spi.FileSystemProvider;
/*    */ import java.util.Iterator;
/*    */ import java.util.ServiceLoader;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class e
/*    */   extends ai<Path>
/*    */ {
/*    */   private static final boolean a;
/*    */   
/*    */   static {
/* 29 */     boolean bool = false; File[] arrayOfFile; int i; byte b;
/* 30 */     for (i = (arrayOfFile = File.listRoots()).length, b = 0; b < i; ) {
/*    */       File file; String str;
/* 32 */       if ((str = (file = arrayOfFile[b]).getPath()).length() >= 2 && Character.isLetter(str.charAt(0)) && str.charAt(1) == ':') {
/* 33 */         bool = true; break;
/*    */       } 
/*    */       b++;
/*    */     } 
/* 37 */     a = bool;
/*    */   }
/*    */   public e() {
/* 40 */     super(Path.class);
/*    */   }
/*    */   private Path c(l paraml, g paramg) {
/*    */     URI uRI;
/* 44 */     if (!paraml.a(o.h)) {
/* 45 */       return (Path)paramg.a(Path.class, paraml);
/*    */     }
/*    */ 
/*    */     
/*    */     String str;
/*    */ 
/*    */     
/* 52 */     if ((str = paraml.w()).indexOf(':') < 0) {
/* 53 */       return Paths.get(str, new String[0]);
/*    */     }
/*    */     
/* 56 */     if (a && 
/* 57 */       str.length() >= 2 && Character.isLetter(str.charAt(0)) && str.charAt(1) == ':') {
/* 58 */       return Paths.get(str, new String[0]);
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 64 */       uRI = new URI(str);
/* 65 */     } catch (URISyntaxException uRISyntaxException) {
/* 66 */       return (Path)paramg.a(a(), str, uRISyntaxException);
/*    */     } 
/*    */     try {
/* 69 */       return Paths.get(uRI);
/* 70 */     } catch (FileSystemNotFoundException fileSystemNotFoundException) {
/*    */       try {
/* 72 */         String str1 = uRI.getScheme();
/*    */         
/* 74 */         for (Iterator<FileSystemProvider> iterator = ServiceLoader.<FileSystemProvider>load(FileSystemProvider.class).iterator(); iterator.hasNext();) {
/* 75 */           if ((fileSystemProvider = iterator.next()).getScheme().equalsIgnoreCase(str1)) {
/* 76 */             return fileSystemProvider.getPath(uRI);
/*    */           }
/*    */         } 
/* 79 */         return (Path)paramg.a(a(), str, fileSystemNotFoundException);
/* 80 */       } catch (Throwable throwable2) {
/* 81 */         Throwable throwable1; (throwable1 = null).addSuppressed(fileSystemNotFoundException);
/* 82 */         return (Path)paramg.a(a(), str, throwable1);
/*    */       } 
/* 84 */     } catch (Throwable throwable) {
/* 85 */       return (Path)paramg.a(a(), str, throwable);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\e\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */