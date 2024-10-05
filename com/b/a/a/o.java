/*      */ package com.b.a.a;
/*      */ 
/*      */ import com.a.a.a.am;
/*      */ import com.b.a.c.i;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.StringTokenizer;
/*      */ import org.a.c.c.t;
/*      */ import org.a.c.h.e.l;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class o
/*      */ {
/*      */   public static final class a
/*      */   {
/*      */     private final InputStream a;
/*      */     
/*      */     public static boolean a(char param1Char) {
/*   52 */       if ((param1Char = (char)(param1Char - 44032)) < '⮤' && param1Char % 28 == 0) return true;  return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static int a(int param1Int, Appendable param1Appendable) {
/*      */       try {
/*   68 */         int i = (param1Int = param1Int - 44032) % 28;
/*   69 */         param1Int /= 28;
/*   70 */         param1Appendable.append((char)(4352 + param1Int / 21));
/*   71 */         param1Appendable.append((char)(4449 + param1Int % 21));
/*   72 */         if (i == 0) {
/*   73 */           return 2;
/*      */         }
/*   75 */         param1Appendable.append((char)(i + 4519));
/*   76 */         return 3;
/*      */       }
/*   78 */       catch (IOException iOException) {
/*      */         
/*   80 */         throw new com.b.a.d.c(iOException);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public a(InputStream param1InputStream) {
/* 1300 */       this.a = param1InputStream;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public l a(boolean param1Boolean) {
/* 1327 */       return b(true);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private l b(boolean param1Boolean) {
/* 1338 */       l l = new l();
/* 1339 */       String str = h();
/* 1340 */       if (!"StartFontMetrics".equals(str))
/*      */       {
/* 1342 */         throw new IOException("Error: The AFM file should start with StartFontMetrics and not '" + str + "'");
/*      */       }
/*      */       
/* 1345 */       f();
/*      */       
/* 1347 */       boolean bool = false;
/* 1348 */       while (!"EndFontMetrics".equals(str = h())) {
/*      */         org.a.b.h.a a1; float[] arrayOfFloat; int i;
/* 1350 */         if ("FontName".equals(str)) {
/*      */           
/* 1352 */           l.c(g()); continue;
/*      */         } 
/* 1354 */         if ("FullName".equals(str)) {
/*      */           
/* 1356 */           g(); continue;
/*      */         } 
/* 1358 */         if ("FamilyName".equals(str)) {
/*      */           
/* 1360 */           l.d(g()); continue;
/*      */         } 
/* 1362 */         if ("Weight".equals(str)) {
/*      */           
/* 1364 */           g(); continue;
/*      */         } 
/* 1366 */         if ("FontBBox".equals(str)) {
/*      */ 
/*      */           
/* 1369 */           (a1 = new org.a.b.h.a()).a(f());
/* 1370 */           a1.b(f());
/* 1371 */           a1.c(f());
/* 1372 */           a1.d(f());
/* 1373 */           l.a(a1); continue;
/*      */         } 
/* 1375 */         if ("Version".equals(a1)) {
/*      */           
/* 1377 */           g(); continue;
/*      */         } 
/* 1379 */         if ("Notice".equals(a1)) {
/*      */           
/* 1381 */           g(); continue;
/*      */         } 
/* 1383 */         if ("EncodingScheme".equals(a1)) {
/*      */           
/* 1385 */           l.e(g()); continue;
/*      */         } 
/* 1387 */         if ("MappingScheme".equals(a1)) {
/*      */           
/* 1389 */           e(); continue;
/*      */         } 
/* 1391 */         if ("EscChar".equals(a1)) {
/*      */           
/* 1393 */           e(); continue;
/*      */         } 
/* 1395 */         if ("CharacterSet".equals(a1)) {
/*      */           
/* 1397 */           l.f(g()); continue;
/*      */         } 
/* 1399 */         if ("Characters".equals(a1)) {
/*      */           
/* 1401 */           e(); continue;
/*      */         } 
/* 1403 */         if ("IsBaseFont".equals(a1)) {
/*      */           
/* 1405 */           d(); continue;
/*      */         } 
/* 1407 */         if ("VVector".equals(a1)) {
/*      */ 
/*      */           
/* 1410 */           (arrayOfFloat = new float[2])[0] = f();
/* 1411 */           arrayOfFloat[1] = f();
/*      */           continue;
/*      */         } 
/* 1414 */         if ("IsFixedV".equals(arrayOfFloat)) {
/*      */           
/* 1416 */           d(); continue;
/*      */         } 
/* 1418 */         if ("CapHeight".equals(arrayOfFloat)) {
/*      */           
/* 1420 */           l.a(f()); continue;
/*      */         } 
/* 1422 */         if ("XHeight".equals(arrayOfFloat)) {
/*      */           
/* 1424 */           l.b(f()); continue;
/*      */         } 
/* 1426 */         if ("Ascender".equals(arrayOfFloat)) {
/*      */           
/* 1428 */           l.c(f()); continue;
/*      */         } 
/* 1430 */         if ("Descender".equals(arrayOfFloat)) {
/*      */           
/* 1432 */           l.d(f()); continue;
/*      */         } 
/* 1434 */         if ("StdHW".equals(arrayOfFloat)) {
/*      */           
/* 1436 */           f(); continue;
/*      */         } 
/* 1438 */         if ("StdVW".equals(arrayOfFloat)) {
/*      */           
/* 1440 */           f(); continue;
/*      */         } 
/* 1442 */         if ("Comment".equals(arrayOfFloat)) {
/*      */           
/* 1444 */           l.b(g()); continue;
/*      */         } 
/* 1446 */         if ("UnderlinePosition".equals(arrayOfFloat)) {
/*      */           
/* 1448 */           f(); continue;
/*      */         } 
/* 1450 */         if ("UnderlineThickness".equals(arrayOfFloat)) {
/*      */           
/* 1452 */           f(); continue;
/*      */         } 
/* 1454 */         if ("ItalicAngle".equals(arrayOfFloat)) {
/*      */           
/* 1456 */           l.e(f()); continue;
/*      */         } 
/* 1458 */         if ("CharWidth".equals(arrayOfFloat)) {
/*      */ 
/*      */           
/* 1461 */           (arrayOfFloat = new float[2])[0] = f();
/* 1462 */           arrayOfFloat[1] = f();
/*      */           continue;
/*      */         } 
/* 1465 */         if ("IsFixedPitch".equals(arrayOfFloat)) {
/*      */           
/* 1467 */           d(); continue;
/*      */         } 
/* 1469 */         if ("StartCharMetrics".equals(arrayOfFloat)) {
/*      */           
/* 1471 */           i = e();
/* 1472 */           ArrayList<o.d> arrayList = new ArrayList(i);
/* 1473 */           for (byte b = 0; b < i; b++) {
/*      */             
/* 1475 */             o.d d = c();
/* 1476 */             arrayList.add(d);
/*      */           } 
/*      */           String str1;
/* 1479 */           if (!(str1 = h()).equals("EndCharMetrics"))
/*      */           {
/* 1481 */             throw new IOException("Error: Expected 'EndCharMetrics' actual '" + str1 + "'");
/*      */           }
/*      */           
/* 1484 */           bool = true;
/* 1485 */           l.a(arrayList); continue;
/*      */         } 
/* 1487 */         if (!param1Boolean && "StartComposites".equals(i)) {
/*      */           
/* 1489 */           i = e();
/* 1490 */           for (byte b = 0; b < i; b++) {
/*      */             
/* 1492 */             com.b.a.b.a a2 = b();
/* 1493 */             l.a(a2);
/*      */           } 
/*      */           String str1;
/* 1496 */           if (!(str1 = h()).equals("EndComposites"))
/*      */           {
/* 1498 */             throw new IOException("Error: Expected 'EndComposites' actual '" + str1 + "'");
/*      */           }
/*      */           continue;
/*      */         } 
/* 1502 */         if (!param1Boolean && "StartKernData".equals(i)) {
/*      */           
/* 1504 */           a(l);
/*      */           
/*      */           continue;
/*      */         } 
/* 1508 */         if (!param1Boolean || !bool)
/*      */         {
/*      */ 
/*      */           
/* 1512 */           throw new IOException("Unknown AFM key '" + i + "'");
/*      */         }
/*      */       } 
/* 1515 */       return l;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void a(l param1l) {
/*      */       String str;
/* 1528 */       while (!(str = h()).equals("EndKernData")) {
/*      */         int i;
/* 1530 */         if ("StartTrackKern".equals(str)) {
/*      */           
/* 1532 */           i = e();
/* 1533 */           for (byte b = 0; b < i; b++) {
/*      */             
/* 1535 */             org.a.b.a.b b1 = new org.a.b.a.b();
/* 1536 */             e();
/* 1537 */             f();
/* 1538 */             f();
/* 1539 */             f();
/* 1540 */             f();
/* 1541 */             param1l.a(b1);
/*      */           } 
/*      */           String str1;
/* 1544 */           if (!(str1 = h()).equals("EndTrackKern"))
/*      */           {
/* 1546 */             throw new IOException("Error: Expected 'EndTrackKern' actual '" + str1 + "'");
/*      */           }
/*      */           continue;
/*      */         } 
/* 1550 */         if ("StartKernPairs".equals(i)) {
/*      */           
/* 1552 */           i = e();
/* 1553 */           for (byte b = 0; b < i; b++) {
/*      */             
/* 1555 */             org.a.c.h.g.e.c c = a();
/* 1556 */             param1l.a(c);
/*      */           } 
/*      */           String str1;
/* 1559 */           if (!(str1 = h()).equals("EndKernPairs"))
/*      */           {
/* 1561 */             throw new IOException("Error: Expected 'EndKernPairs' actual '" + str1 + "'");
/*      */           }
/*      */           continue;
/*      */         } 
/* 1565 */         if ("StartKernPairs0".equals(i)) {
/*      */           
/* 1567 */           i = e();
/* 1568 */           for (byte b = 0; b < i; b++) {
/*      */             
/* 1570 */             org.a.c.h.g.e.c c = a();
/* 1571 */             param1l.b(c);
/*      */           } 
/*      */           String str1;
/* 1574 */           if (!(str1 = h()).equals("EndKernPairs"))
/*      */           {
/* 1576 */             throw new IOException("Error: Expected 'EndKernPairs' actual '" + str1 + "'");
/*      */           }
/*      */           continue;
/*      */         } 
/* 1580 */         if ("StartKernPairs1".equals(i)) {
/*      */           
/* 1582 */           i = e();
/* 1583 */           for (byte b = 0; b < i; b++) {
/*      */             
/* 1585 */             org.a.c.h.g.e.c c = a();
/* 1586 */             param1l.c(c);
/*      */           } 
/*      */           String str1;
/* 1589 */           if (!(str1 = h()).equals("EndKernPairs"))
/*      */           {
/* 1591 */             throw new IOException("Error: Expected 'EndKernPairs' actual '" + str1 + "'");
/*      */           }
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/* 1597 */         throw new IOException("Unknown kerning data type '" + i + "'");
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private org.a.c.h.g.e.c a() {
/* 1611 */       org.a.c.h.g.e.c c = new org.a.c.h.g.e.c();
/* 1612 */       String str = h();
/* 1613 */       if ("KP".equals(str)) {
/*      */         
/* 1615 */         h();
/* 1616 */         h();
/* 1617 */         f();
/* 1618 */         f();
/*      */       }
/* 1620 */       else if ("KPH".equals(str)) {
/*      */         
/* 1622 */         a(h());
/* 1623 */         a(h());
/* 1624 */         f();
/* 1625 */         f();
/*      */       }
/* 1627 */       else if ("KPX".equals(str)) {
/*      */         
/* 1629 */         h();
/* 1630 */         h();
/* 1631 */         f();
/*      */       
/*      */       }
/* 1634 */       else if ("KPY".equals(str)) {
/*      */         
/* 1636 */         h();
/* 1637 */         h();
/*      */         
/* 1639 */         f();
/*      */       }
/*      */       else {
/*      */         
/* 1643 */         throw new IOException("Error expected kern pair command actual='" + str + "'");
/*      */       } 
/* 1645 */       return c;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static String a(String param1String) {
/* 1659 */       if (param1String.length() < 2)
/*      */       {
/* 1661 */         throw new IOException("Error: Expected hex string of length >= 2 not='" + param1String);
/*      */       }
/* 1663 */       if (param1String.charAt(0) != '<' || param1String
/* 1664 */         .charAt(param1String.length() - 1) != '>')
/*      */       {
/* 1666 */         throw new IOException("String should be enclosed by angle brackets '" + param1String + "'");
/*      */       }
/*      */       
/* 1669 */       byte[] arrayOfByte = new byte[(param1String = param1String.substring(1, param1String.length() - 1)).length() / 2];
/* 1670 */       for (byte b = 0; b < param1String.length(); b += 2) {
/*      */         
/* 1672 */         String str = Character.toString(param1String.charAt(b)) + param1String.charAt(b + 1);
/*      */         
/*      */         try {
/* 1675 */           arrayOfByte[b / 2] = (byte)Integer.parseInt(str, 16);
/*      */         }
/* 1677 */         catch (NumberFormatException numberFormatException) {
/*      */           
/* 1679 */           throw new IOException("Error parsing AFM file:" + numberFormatException);
/*      */         } 
/*      */       } 
/* 1682 */       return new String(arrayOfByte, org.a.b.h.b.a);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private com.b.a.b.a b() {
/*      */       int i;
/* 1694 */       com.b.a.b.a a1 = new com.b.a.b.a();
/* 1695 */       String str1 = g();
/*      */       
/*      */       StringTokenizer stringTokenizer;
/*      */       
/*      */       String str2;
/* 1700 */       if (!(str2 = (stringTokenizer = new StringTokenizer(str1, " ;")).nextToken()).equals("CC"))
/*      */       {
/* 1702 */         throw new IOException("Expected 'CC' actual='" + str2 + "'");
/*      */       }
/* 1704 */       stringTokenizer.nextToken();
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/* 1710 */         i = Integer.parseInt(stringTokenizer.nextToken());
/*      */       }
/* 1712 */       catch (NumberFormatException numberFormatException1) {
/*      */         
/* 1714 */         throw new IOException("Error parsing AFM document:" + numberFormatException1);
/*      */       } 
/* 1716 */       for (byte b = 0; b < i; b++) {
/*      */         
/* 1718 */         t t = new t();
/*      */         String str;
/* 1720 */         if (!(str = stringTokenizer.nextToken()).equals("PCC"))
/*      */         {
/* 1722 */           throw new IOException("Expected 'PCC' actual='" + str + "'");
/*      */         }
/* 1724 */         stringTokenizer.nextToken();
/*      */         
/*      */         try {
/* 1727 */           Integer.parseInt(stringTokenizer.nextToken());
/* 1728 */           Integer.parseInt(stringTokenizer.nextToken());
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1733 */           a1.a(t);
/*      */         }
/* 1735 */         catch (NumberFormatException numberFormatException) {
/*      */           
/* 1737 */           throw new IOException("Error parsing AFM document:" + numberFormatException);
/*      */         } 
/*      */       } 
/* 1740 */       return (com.b.a.b.a)numberFormatException;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private o.d c() {
/* 1752 */       o.d d = new o.d();
/* 1753 */       String str = g();
/* 1754 */       StringTokenizer stringTokenizer = new StringTokenizer(str);
/*      */       
/*      */       try {
/* 1757 */         while (stringTokenizer.hasMoreTokens()) {
/*      */           float[] arrayOfFloat; org.a.b.h.a a2; org.a.b.a.a a1;
/*      */           String str1;
/* 1760 */           if ((str1 = stringTokenizer.nextToken()).equals("C")) {
/*      */             
/* 1762 */             str1 = stringTokenizer.nextToken();
/* 1763 */             d.b(Integer.parseInt(str1));
/* 1764 */             a(stringTokenizer); continue;
/*      */           } 
/* 1766 */           if (str1.equals("CH")) {
/*      */ 
/*      */ 
/*      */             
/* 1770 */             str1 = stringTokenizer.nextToken();
/* 1771 */             d.b(Integer.parseInt(str1, 16));
/* 1772 */             a(stringTokenizer); continue;
/*      */           } 
/* 1774 */           if (str1.equals("WX")) {
/*      */             
/* 1776 */             d.a(Float.parseFloat(stringTokenizer.nextToken()));
/* 1777 */             a(stringTokenizer); continue;
/*      */           } 
/* 1779 */           if (str1.equals("W0X")) {
/*      */             
/* 1781 */             Float.parseFloat(stringTokenizer.nextToken());
/* 1782 */             a(stringTokenizer); continue;
/*      */           } 
/* 1784 */           if (str1.equals("W1X")) {
/*      */             
/* 1786 */             Float.parseFloat(stringTokenizer.nextToken());
/* 1787 */             a(stringTokenizer); continue;
/*      */           } 
/* 1789 */           if (str1.equals("WY")) {
/*      */             
/* 1791 */             Float.parseFloat(stringTokenizer.nextToken());
/* 1792 */             a(stringTokenizer); continue;
/*      */           } 
/* 1794 */           if (str1.equals("W0Y")) {
/*      */             
/* 1796 */             Float.parseFloat(stringTokenizer.nextToken());
/* 1797 */             a(stringTokenizer); continue;
/*      */           } 
/* 1799 */           if (str1.equals("W1Y")) {
/*      */             
/* 1801 */             Float.parseFloat(stringTokenizer.nextToken());
/* 1802 */             a(stringTokenizer); continue;
/*      */           } 
/* 1804 */           if (str1.equals("W")) {
/*      */ 
/*      */             
/* 1807 */             (arrayOfFloat = new float[2])[0] = Float.parseFloat(stringTokenizer.nextToken());
/* 1808 */             arrayOfFloat[1] = Float.parseFloat(stringTokenizer.nextToken());
/*      */             
/* 1810 */             a(stringTokenizer); continue;
/*      */           } 
/* 1812 */           if (arrayOfFloat.equals("W0")) {
/*      */ 
/*      */             
/* 1815 */             (arrayOfFloat = new float[2])[0] = Float.parseFloat(stringTokenizer.nextToken());
/* 1816 */             arrayOfFloat[1] = Float.parseFloat(stringTokenizer.nextToken());
/*      */             
/* 1818 */             a(stringTokenizer); continue;
/*      */           } 
/* 1820 */           if (arrayOfFloat.equals("W1")) {
/*      */ 
/*      */             
/* 1823 */             (arrayOfFloat = new float[2])[0] = Float.parseFloat(stringTokenizer.nextToken());
/* 1824 */             arrayOfFloat[1] = Float.parseFloat(stringTokenizer.nextToken());
/*      */             
/* 1826 */             a(stringTokenizer); continue;
/*      */           } 
/* 1828 */           if (arrayOfFloat.equals("VV")) {
/*      */ 
/*      */             
/* 1831 */             (arrayOfFloat = new float[2])[0] = Float.parseFloat(stringTokenizer.nextToken());
/* 1832 */             arrayOfFloat[1] = Float.parseFloat(stringTokenizer.nextToken());
/*      */             
/* 1834 */             a(stringTokenizer); continue;
/*      */           } 
/* 1836 */           if (arrayOfFloat.equals("N")) {
/*      */             
/* 1838 */             d.a(stringTokenizer.nextToken());
/* 1839 */             a(stringTokenizer); continue;
/*      */           } 
/* 1841 */           if (arrayOfFloat.equals("B")) {
/*      */ 
/*      */             
/* 1844 */             (a2 = new org.a.b.h.a()).a(Float.parseFloat(stringTokenizer.nextToken()));
/* 1845 */             a2.b(Float.parseFloat(stringTokenizer.nextToken()));
/* 1846 */             a2.c(Float.parseFloat(stringTokenizer.nextToken()));
/* 1847 */             a2.d(Float.parseFloat(stringTokenizer.nextToken()));
/*      */             
/* 1849 */             a(stringTokenizer); continue;
/*      */           } 
/* 1851 */           if (a2.equals("L")) {
/*      */             
/* 1853 */             a1 = new org.a.b.a.a();
/* 1854 */             stringTokenizer.nextToken();
/* 1855 */             stringTokenizer.nextToken();
/* 1856 */             d.a(a1);
/* 1857 */             a(stringTokenizer);
/*      */             
/*      */             continue;
/*      */           } 
/* 1861 */           throw new IOException("Unknown CharMetrics command '" + a1 + "'");
/*      */         }
/*      */       
/*      */       }
/* 1865 */       catch (NumberFormatException numberFormatException) {
/*      */         
/* 1867 */         throw new IOException("Error: Corrupt AFM document:" + numberFormatException);
/*      */       } 
/* 1869 */       return d;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static void a(StringTokenizer param1StringTokenizer) {
/* 1881 */       if (param1StringTokenizer.hasMoreTokens()) {
/*      */         
/* 1883 */         String str = param1StringTokenizer.nextToken();
/* 1884 */         if (!";".equals(str))
/*      */         {
/* 1886 */           throw new IOException("Error: Expected semicolon in stream actual='" + str + "'");
/*      */         }
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/* 1892 */       throw new IOException("CharMetrics is missing a semicolon after a command");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean d() {
/*      */       String str;
/* 1904 */       return Boolean.valueOf(str = h()).booleanValue();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int e() {
/* 1914 */       String str = h();
/*      */       
/*      */       try {
/* 1917 */         return Integer.parseInt(str);
/*      */       }
/* 1919 */       catch (NumberFormatException numberFormatException) {
/*      */         
/* 1921 */         throw new IOException("Error parsing AFM document:" + numberFormatException);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private float f() {
/*      */       String str;
/* 1933 */       return Float.parseFloat(str = h());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private String g() {
/* 1944 */       StringBuilder stringBuilder = new StringBuilder(60);
/* 1945 */       int i = this.a.read();
/* 1946 */       while (b(i))
/*      */       {
/* 1948 */         i = this.a.read();
/*      */       }
/*      */       
/* 1951 */       stringBuilder.append((char)i);
/*      */ 
/*      */       
/* 1954 */       i = this.a.read();
/* 1955 */       while (i != -1 && !a(i)) {
/*      */         
/* 1957 */         stringBuilder.append((char)i);
/* 1958 */         i = this.a.read();
/*      */       } 
/* 1960 */       return stringBuilder.toString();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private String h() {
/* 1973 */       StringBuilder stringBuilder = new StringBuilder(24);
/* 1974 */       int i = this.a.read();
/* 1975 */       while (b(i))
/*      */       {
/* 1977 */         i = this.a.read();
/*      */       }
/*      */       
/* 1980 */       stringBuilder.append((char)i);
/*      */ 
/*      */       
/* 1983 */       i = this.a.read();
/* 1984 */       while (i != -1 && !b(i)) {
/*      */         
/* 1986 */         stringBuilder.append((char)i);
/* 1987 */         i = this.a.read();
/*      */       } 
/* 1989 */       return stringBuilder.toString();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static boolean a(int param1Int) {
/* 2001 */       return (param1Int == 13 || param1Int == 10);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static boolean b(int param1Int)
/*      */     {
/* 2014 */       return (param1Int == 32 || param1Int == 9 || param1Int == 13 || param1Int == 10); } } public static final class c implements Appendable { private final o a; private final Appendable b; private final StringBuilder c; private final boolean d; private int e; private int f; private int g; private int h; public c(o param1o, Appendable param1Appendable, int param1Int) { this.a = param1o; this.b = param1Appendable; if (this.b instanceof StringBuilder) { this.d = true; this.c = (StringBuilder)param1Appendable; this.c.ensureCapacity(5); this.e = 0; if (this.c.length() == 0) { this.f = 0; return; }  d(); this.f = f(); if (this.f > 1) do {  } while (f() > 1);  this.e = this.h; return; }  this.d = false; this.c = new StringBuilder(); this.e = 0; this.f = 0; } public final int a() { return this.c.length(); } public final StringBuilder b() { return this.c; } public final void a(char param1Char) { this.c.setCharAt(this.c.length() - 1, param1Char); } public final void a(int param1Int1, int param1Int2) { if (this.f <= param1Int2 || param1Int2 == 0) { this.c.appendCodePoint(param1Int1); this.f = param1Int2; if (param1Int2 <= 1) { this.e = this.c.length(); return; }  } else { b(param1Int1, param1Int2); }  } public final void a(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3, int param1Int4) { if (param1Int1 == param1Int2) return;  if (this.f <= param1Int3 || param1Int3 == 0) { if (param1Int4 <= 1) { this.e = this.c.length() + param1Int2 - param1Int1; } else if (param1Int3 <= 1) { this.e = this.c.length() + 1; }  this.c.append(param1CharSequence, param1Int1, param1Int2); this.f = param1Int4; return; }  int i = Character.codePointAt(param1CharSequence, param1Int1); param1Int1 += Character.charCount(i); b(i, param1Int3); while (param1Int1 < param1Int2) { i = Character.codePointAt(param1CharSequence, param1Int1); if ((param1Int1 = param1Int1 + Character.charCount(i)) < param1Int2) { param1Int3 = o.f(this.a.a(i)); } else { param1Int3 = param1Int4; }  a(i, param1Int3); }  } public final c b(char param1Char) { this.c.append(param1Char); this.f = 0; this.e = this.c.length(); return this; } private c a(CharSequence param1CharSequence) { if (param1CharSequence.length() != 0) { this.c.append(param1CharSequence); this.f = 0; this.e = this.c.length(); }  return this; } public final c a(CharSequence param1CharSequence, int param1Int1, int param1Int2) { if (param1Int1 != param1Int2) { this.c.append(param1CharSequence, param1Int1, param1Int2); this.f = 0; this.e = this.c.length(); }  return this; } public final void c() { if (this.d) { this.e = this.c.length(); } else { try { this.b.append(this.c); this.c.setLength(0); this.e = 0; } catch (IOException iOException) { throw new com.b.a.d.c(iOException); }  }  this.f = 0; } public final c b(CharSequence param1CharSequence, int param1Int1, int param1Int2) { if (this.d) { this.c.append(param1CharSequence, param1Int1, param1Int2); this.e = this.c.length(); } else { try { this.b.append(this.c).append(param1CharSequence, param1Int1, param1Int2); this.c.setLength(0); this.e = 0; } catch (IOException iOException) { throw new com.b.a.d.c(iOException); }  }  this.f = 0; return this; } public final void a(int param1Int) { int i = this.c.length(); this.c.delete(i - param1Int, i); this.f = 0; this.e = this.c.length(); } private void b(int param1Int1, int param1Int2) { d(); e(); do {  } while (f() > param1Int2); if (param1Int1 <= 65535) { this.c.insert(this.h, (char)param1Int1); if (param1Int2 <= 1) { this.e = this.h + 1; return; }  } else { this.c.insert(this.h, Character.toChars(param1Int1)); if (param1Int2 <= 1) this.e = this.h + 2;  }  } private void d() { this.g = this.c.length(); } private void e() { this.h = this.g; this.g = this.c.offsetByCodePoints(this.g, -1); } private int f() { this.h = this.g; if (this.e >= this.g) return 0;  int i = this.c.codePointBefore(this.g); this.g -= Character.charCount(i); if (i < 768) return 0;  return o.f(this.a.a(i)); } } public static final class d { private int a; private float b; private String c; private List<org.a.b.a.a> d; public static boolean a(int param1Int) { return ((param1Int & 0x400) == 0); } public static boolean a(CharSequence param1CharSequence1, CharSequence param1CharSequence2) { if (param1CharSequence1 == param1CharSequence2) return true;  int i; if ((i = param1CharSequence1.length()) != param1CharSequence2.length()) return false;  for (byte b = 0; b < i; b++) { if (param1CharSequence1.charAt(b) != param1CharSequence2.charAt(b)) return false;  }  return true; } public d() { this.d = new ArrayList<org.a.b.a.a>(); } public int a() { return this.a; } public void b(int param1Int) { this.a = param1Int; } public void a(org.a.b.a.a param1a) { this.d.add(param1a); } public String b() { return this.c; } public void a(String param1String) { this.c = param1String; } public float c() { return this.b; } public void a(float param1Float) { this.b = param1Float; } } static final class b implements f.a { private b() {} public final boolean a(byte[] param1ArrayOfbyte) { return (param1ArrayOfbyte[0] == 2); } } private static final b a = new b((byte)0); private int b; private int c; private int d; private int e; private int f; private int g; private x h; private String i; private void a(c paramc, int paramInt, boolean paramBoolean) { StringBuilder stringBuilder = paramc.b(); if ((paramInt = paramInt) == stringBuilder.length()) return;  int j = -1; int i = -1; boolean bool = false; int k = 0; while (true) { int m = stringBuilder.codePointAt(paramInt); paramInt += Character.charCount(m); int n, i1 = f(n = a(m)); if (n(n) && j >= 0 && (k < i1 || k == 0)) { if (q(n)) { if (m < 4519) if ((n = (char)(stringBuilder.charAt(i) - 4352)) < 19) { j = paramInt - 1; m = (char)(44032 + (n * 21 + m - 4449) * 28); char c1; if (paramInt != stringBuilder.length() && (c1 = (char)(stringBuilder.charAt(paramInt) - 4519)) < '\034') { paramInt++; m = (char)(m + c1); }  stringBuilder.setCharAt(i, m); stringBuilder.delete(j, paramInt); paramInt = j; }   if (paramInt != stringBuilder.length()) { j = -1; continue; }  break; }  int i2; if ((i2 = a(this.i, j, m)) >= 0) { n = i2 >> 1; j = paramInt - Character.charCount(m); stringBuilder.delete(j, paramInt); paramInt = j; if (bool) { if (n > 65535) { stringBuilder.setCharAt(i, am.b(n)); stringBuilder.setCharAt(i + 1, am.c(n)); } else { stringBuilder.setCharAt(i, (char)m); stringBuilder.deleteCharAt(i + 1); bool = false; paramInt--; }  } else if (n > 65535) { bool = true; stringBuilder.setCharAt(i, am.b(n)); stringBuilder.insert(i + 1, am.c(n)); paramInt++; } else { stringBuilder.setCharAt(i, (char)n); }  if (paramInt != stringBuilder.length()) { if ((i2 & 0x1) != 0) { j = x(a(n)); continue; }  j = -1;
/*      */             
/*      */             continue; }
/*      */ 
/*      */           
/*      */           break; }
/*      */          }
/*      */ 
/*      */       
/* 2023 */       k = i1;
/* 2024 */       if (paramInt != stringBuilder.length()) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2029 */         if (i1 == 0) {
/*      */           
/* 2031 */           if ((j = w(n)) >= 0) {
/*      */             
/* 2033 */             if (m <= 65535) {
/* 2034 */               bool = false;
/* 2035 */               i = paramInt - 1; continue;
/*      */             } 
/* 2037 */             bool = true;
/* 2038 */             i = paramInt - 2;
/*      */           }  continue;
/*      */         } 
/* 2041 */         if (paramBoolean)
/*      */         {
/* 2043 */           j = -1; }  continue;
/*      */       }  break; }
/*      */     
/* 2046 */     paramc.c(); }
/*      */   private String j;
/*      */   private byte[] k;
/*      */   private int[] l;
/*      */   private y m;
/*      */   private ArrayList<i> n;
/*      */   private o a(ByteBuffer paramByteBuffer) { try { f.a(paramByteBuffer, 1316121906, a); int j; if ((j = paramByteBuffer.getInt() / 4) <= 13) throw new com.b.a.d.c("Normalizer2 data: not enough indexes");  int[] arrayOfInt; (arrayOfInt = new int[j])[0] = j << 2; int k; for (k = 1; k < j; k++) arrayOfInt[k] = paramByteBuffer.getInt();  this.b = arrayOfInt[8]; this.c = arrayOfInt[9]; this.d = arrayOfInt[10]; this.e = arrayOfInt[11]; this.f = arrayOfInt[12]; this.g = arrayOfInt[13]; k = arrayOfInt[0]; j = arrayOfInt[1]; this.h = x.b(paramByteBuffer); int m; if ((m = this.h.b()) > j - k) throw new com.b.a.d.c("Normalizer2 data: not enough bytes for normTrie");  f.a(paramByteBuffer, j - k - m); k = j; if ((j = ((j = arrayOfInt[2]) - k) / 2) != 0) { this.i = f.a(paramByteBuffer, j, 0); this.j = this.i.substring(65024 - this.g); }  this.k = new byte[256]; paramByteBuffer.get(this.k); this.l = new int[384]; int i = 0; for (j = 0; j < 384; i >>= 1) { if ((j & 0xFF) == 0) i = this.k[j >> 8];  if ((i & 0x1) != 0) { for (byte b1 = 0; b1 < 32; b1++, j++) this.l[j] = m(j) & 0xFF;  } else { j += 32; }  }  return this; } catch (IOException iOException) { throw new com.b.a.d.c(iOException); }  }
/*      */   public final o a(String paramString) { return a(f.b(paramString)); }
/*      */   public final synchronized o a() { if (this.m == null) { v v = new v(0, 0); this.n = new ArrayList<i>(); Iterator<s.a> iterator = this.h.iterator(); s.a a; while (iterator.hasNext() && !(a = iterator.next()).d) { int i; if ((i = a.c) != 0 && (this.d > i || i >= this.e)) for (int j = a.a; j <= a.b; j++) { int k = v.a(j), m = k; if (i >= this.g) { m |= Integer.MIN_VALUE; if (i < 65024) m |= 0x40000000;  } else if (i < this.d) { m |= 0x40000000; } else { int n = j; int i1 = i; while (this.f <= i1 && i1 < this.g) { n = a(n, i1); i1 = a(n); }  if (this.d <= i1 && i1 < this.f) { char c; int i2 = (c = this.j.charAt(i1)) & 0x1F; if ((c & 0x80) != 0 && j == n && (this.j.charAt(i1 - 1) & 0xFF) != 0) m |= Integer.MIN_VALUE;  if (i2 != 0) { i1++; int i3 = i1 + i2; n = this.j.codePointAt(i1); a(v, j, n); if (i1 >= this.e) while ((i1 += Character.charCount(n)) < i3) { n = this.j.codePointAt(i1); if (((i2 = v.a(n)) & Integer.MIN_VALUE) == 0) v.d(n, i2 | Integer.MIN_VALUE);  }   }  } else { a(v, j, n); }  }  if (m != k) v.d(j, m);  }   }  this.m = v.b(); }  return this; }
/*      */   public final int a(int paramInt) { return this.h.a(paramInt); }
/*      */   public final int b(int paramInt) { if (paramInt < this.e || 65281 <= paramInt) return 1;  if (this.g <= paramInt)
/*      */       return 2;  return 0; }
/*      */   public final boolean c(int paramInt) { return (this.e <= paramInt && paramInt < this.g); }
/*      */   public final boolean d(int paramInt) { return (paramInt < this.d || this.g <= paramInt); }
/*      */   public final int e(int paramInt) { if (paramInt >= 65024)
/*      */       return paramInt & 0xFF;  if (paramInt < this.e || this.f <= paramInt)
/*      */       return 0;  return v(paramInt); }
/*      */   public static int f(int paramInt) { return (paramInt >= 65024) ? (paramInt & 0xFF) : 0; }
/*      */   public final int g(int paramInt) { if (paramInt < 0)
/*      */       return 0;  if (paramInt < 384)
/*      */       return this.l[paramInt];  if (paramInt <= 65535 && !l(paramInt))
/*      */       return 0;  return m(paramInt); }
/*      */   private boolean l(int paramInt) { byte b1; if ((b1 = this.k[paramInt >> 8]) == 0)
/*      */       return false;  return ((b1 >> (paramInt >> 5 & 0x7) & 0x1) != 0); }
/*      */   private int m(int paramInt) { int i; while (true) { if ((i = a(paramInt)) <= this.d)
/*      */         return 0;  if (i >= 65024)
/*      */         return (i = i & 0xFF) | i << 8;  if (i >= this.g)
/*      */         return 0;  if (u(i)) { paramInt = a(paramInt, i); continue; }  break; }  if (((paramInt = this.j.charAt(i)) & 0x1F) == 0)
/*      */       return 511;  int j = paramInt >> 8; if ((paramInt & 0x80) != 0)
/*      */       j |= this.j.charAt(i - 1) & 0xFF00;  return j; }
/*      */   public final String h(int paramInt) { int i = -1; int j; while (paramInt >= this.b && !d(j = a(paramInt))) { if (r(j)) { StringBuilder stringBuilder = new StringBuilder(); a.a(paramInt, stringBuilder); return stringBuilder.toString(); }  if (u(j)) { i = paramInt = a(paramInt, j); continue; }  i = this.j.charAt(j++) & 0x1F; return this.j.substring(j, j + i); }  if (i < 0)
/*      */       return null;  return am.d(i); }
/*      */   public final boolean i(int paramInt) { return (this.m.a(paramInt) >= 0); }
/*      */   public final boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, c paramc) { // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield c : I
/*      */     //   4: istore #4
/*      */     //   6: iconst_0
/*      */     //   7: istore #5
/*      */     //   9: iconst_0
/*      */     //   10: istore #8
/*      */     //   12: iconst_0
/*      */     //   13: istore #9
/*      */     //   15: iload_2
/*      */     //   16: istore #7
/*      */     //   18: iload_2
/*      */     //   19: iload_3
/*      */     //   20: if_icmpeq -> 183
/*      */     //   23: aload_1
/*      */     //   24: iload_2
/*      */     //   25: invokeinterface charAt : (I)C
/*      */     //   30: dup
/*      */     //   31: istore #8
/*      */     //   33: iload #4
/*      */     //   35: if_icmplt -> 58
/*      */     //   38: aload_0
/*      */     //   39: dup
/*      */     //   40: getfield h : Lcom/b/a/a/x;
/*      */     //   43: iload #8
/*      */     //   45: i2c
/*      */     //   46: invokevirtual a : (C)I
/*      */     //   49: dup
/*      */     //   50: istore #9
/*      */     //   52: invokespecial s : (I)Z
/*      */     //   55: ifeq -> 64
/*      */     //   58: iinc #2, 1
/*      */     //   61: goto -> 18
/*      */     //   64: iload #8
/*      */     //   66: i2c
/*      */     //   67: invokestatic a : (C)Z
/*      */     //   70: ifeq -> 183
/*      */     //   73: iload #8
/*      */     //   75: invokestatic a : (I)Z
/*      */     //   78: ifeq -> 119
/*      */     //   81: iload_2
/*      */     //   82: iconst_1
/*      */     //   83: iadd
/*      */     //   84: iload_3
/*      */     //   85: if_icmpeq -> 156
/*      */     //   88: aload_1
/*      */     //   89: iload_2
/*      */     //   90: iconst_1
/*      */     //   91: iadd
/*      */     //   92: invokeinterface charAt : (I)C
/*      */     //   97: dup
/*      */     //   98: istore #10
/*      */     //   100: invokestatic isLowSurrogate : (C)Z
/*      */     //   103: ifeq -> 156
/*      */     //   106: iload #8
/*      */     //   108: i2c
/*      */     //   109: iload #10
/*      */     //   111: invokestatic toCodePoint : (CC)I
/*      */     //   114: istore #8
/*      */     //   116: goto -> 156
/*      */     //   119: iload #7
/*      */     //   121: iload_2
/*      */     //   122: if_icmpge -> 156
/*      */     //   125: aload_1
/*      */     //   126: iload_2
/*      */     //   127: iconst_1
/*      */     //   128: isub
/*      */     //   129: invokeinterface charAt : (I)C
/*      */     //   134: dup
/*      */     //   135: istore #10
/*      */     //   137: invokestatic isHighSurrogate : (C)Z
/*      */     //   140: ifeq -> 156
/*      */     //   143: iinc #2, -1
/*      */     //   146: iload #10
/*      */     //   148: iload #8
/*      */     //   150: i2c
/*      */     //   151: invokestatic toCodePoint : (CC)I
/*      */     //   154: istore #8
/*      */     //   156: aload_0
/*      */     //   157: dup
/*      */     //   158: iload #8
/*      */     //   160: invokevirtual a : (I)I
/*      */     //   163: dup
/*      */     //   164: istore #9
/*      */     //   166: invokespecial s : (I)Z
/*      */     //   169: ifeq -> 183
/*      */     //   172: iload_2
/*      */     //   173: iload #8
/*      */     //   175: invokestatic charCount : (I)I
/*      */     //   178: iadd
/*      */     //   179: istore_2
/*      */     //   180: goto -> 18
/*      */     //   183: iload_2
/*      */     //   184: iload #7
/*      */     //   186: if_icmpeq -> 279
/*      */     //   189: iload_2
/*      */     //   190: iload_3
/*      */     //   191: if_icmpne -> 207
/*      */     //   194: aload #6
/*      */     //   196: aload_1
/*      */     //   197: iload #7
/*      */     //   199: iload_2
/*      */     //   200: invokevirtual b : (Ljava/lang/CharSequence;II)Lcom/b/a/a/o$c;
/*      */     //   203: pop
/*      */     //   204: goto -> 562
/*      */     //   207: iload_2
/*      */     //   208: iconst_1
/*      */     //   209: isub
/*      */     //   210: istore #5
/*      */     //   212: aload_1
/*      */     //   213: iload #5
/*      */     //   215: invokeinterface charAt : (I)C
/*      */     //   220: invokestatic isLowSurrogate : (C)Z
/*      */     //   223: ifeq -> 252
/*      */     //   226: iload #7
/*      */     //   228: iload #5
/*      */     //   230: if_icmpge -> 252
/*      */     //   233: aload_1
/*      */     //   234: iload #5
/*      */     //   236: iconst_1
/*      */     //   237: isub
/*      */     //   238: invokeinterface charAt : (I)C
/*      */     //   243: invokestatic isHighSurrogate : (C)Z
/*      */     //   246: ifeq -> 252
/*      */     //   249: iinc #5, -1
/*      */     //   252: aload #6
/*      */     //   254: aload_1
/*      */     //   255: iload #7
/*      */     //   257: iload #5
/*      */     //   259: invokevirtual b : (Ljava/lang/CharSequence;II)Lcom/b/a/a/o$c;
/*      */     //   262: pop
/*      */     //   263: aload #6
/*      */     //   265: aload_1
/*      */     //   266: iload #5
/*      */     //   268: iload_2
/*      */     //   269: invokevirtual a : (Ljava/lang/CharSequence;II)Lcom/b/a/a/o$c;
/*      */     //   272: pop
/*      */     //   273: iload_2
/*      */     //   274: istore #7
/*      */     //   276: goto -> 284
/*      */     //   279: iload_2
/*      */     //   280: iload_3
/*      */     //   281: if_icmpeq -> 562
/*      */     //   284: iload_2
/*      */     //   285: iload #8
/*      */     //   287: invokestatic charCount : (I)I
/*      */     //   290: iadd
/*      */     //   291: istore_2
/*      */     //   292: iload #9
/*      */     //   294: invokestatic q : (I)Z
/*      */     //   297: ifeq -> 467
/*      */     //   300: iload #5
/*      */     //   302: iload #7
/*      */     //   304: if_icmpeq -> 467
/*      */     //   307: aload_1
/*      */     //   308: iload #7
/*      */     //   310: iconst_1
/*      */     //   311: isub
/*      */     //   312: invokeinterface charAt : (I)C
/*      */     //   317: istore #10
/*      */     //   319: iconst_0
/*      */     //   320: istore #11
/*      */     //   322: iload #8
/*      */     //   324: sipush #4519
/*      */     //   327: if_icmpge -> 421
/*      */     //   330: iload #10
/*      */     //   332: sipush #4352
/*      */     //   335: isub
/*      */     //   336: i2c
/*      */     //   337: dup
/*      */     //   338: istore #10
/*      */     //   340: bipush #19
/*      */     //   342: if_icmpge -> 450
/*      */     //   345: ldc 44032
/*      */     //   347: iload #10
/*      */     //   349: bipush #21
/*      */     //   351: imul
/*      */     //   352: iload #8
/*      */     //   354: sipush #4449
/*      */     //   357: isub
/*      */     //   358: iadd
/*      */     //   359: bipush #28
/*      */     //   361: imul
/*      */     //   362: iadd
/*      */     //   363: i2c
/*      */     //   364: istore #10
/*      */     //   366: iload_2
/*      */     //   367: iload_3
/*      */     //   368: if_icmpeq -> 415
/*      */     //   371: aload_1
/*      */     //   372: iload_2
/*      */     //   373: invokeinterface charAt : (I)C
/*      */     //   378: sipush #4519
/*      */     //   381: isub
/*      */     //   382: i2c
/*      */     //   383: dup
/*      */     //   384: istore #11
/*      */     //   386: bipush #28
/*      */     //   388: if_icmpge -> 415
/*      */     //   391: iinc #2, 1
/*      */     //   394: iload #10
/*      */     //   396: iload #11
/*      */     //   398: iadd
/*      */     //   399: i2c
/*      */     //   400: istore #10
/*      */     //   402: iload_2
/*      */     //   403: istore #5
/*      */     //   405: aload #6
/*      */     //   407: iload #10
/*      */     //   409: invokevirtual a : (C)V
/*      */     //   412: goto -> 15
/*      */     //   415: iconst_1
/*      */     //   416: istore #11
/*      */     //   418: goto -> 450
/*      */     //   421: iload #10
/*      */     //   423: invokestatic a : (C)Z
/*      */     //   426: ifeq -> 450
/*      */     //   429: aload #6
/*      */     //   431: iload #10
/*      */     //   433: iload #8
/*      */     //   435: iadd
/*      */     //   436: sipush #4519
/*      */     //   439: isub
/*      */     //   440: i2c
/*      */     //   441: invokevirtual a : (C)V
/*      */     //   444: iload_2
/*      */     //   445: istore #5
/*      */     //   447: goto -> 15
/*      */     //   450: iload #11
/*      */     //   452: ifne -> 467
/*      */     //   455: aload #6
/*      */     //   457: iload #8
/*      */     //   459: i2c
/*      */     //   460: invokevirtual b : (C)Lcom/b/a/a/o$c;
/*      */     //   463: pop
/*      */     //   464: goto -> 15
/*      */     //   467: iload #9
/*      */     //   469: ldc 65281
/*      */     //   471: if_icmplt -> 494
/*      */     //   474: iload #9
/*      */     //   476: sipush #255
/*      */     //   479: iand
/*      */     //   480: istore #10
/*      */     //   482: aload #6
/*      */     //   484: iload #8
/*      */     //   486: iload #10
/*      */     //   488: invokevirtual a : (II)V
/*      */     //   491: goto -> 15
/*      */     //   494: aload_0
/*      */     //   495: iload #8
/*      */     //   497: iload #9
/*      */     //   499: invokespecial b : (II)Z
/*      */     //   502: ifeq -> 512
/*      */     //   505: iload #7
/*      */     //   507: istore #5
/*      */     //   509: goto -> 522
/*      */     //   512: aload #6
/*      */     //   514: iload #7
/*      */     //   516: iload #5
/*      */     //   518: isub
/*      */     //   519: invokevirtual a : (I)V
/*      */     //   522: aload_0
/*      */     //   523: aload_1
/*      */     //   524: iload_2
/*      */     //   525: iload_3
/*      */     //   526: invokespecial a : (Ljava/lang/CharSequence;II)I
/*      */     //   529: istore_2
/*      */     //   530: aload #6
/*      */     //   532: invokevirtual a : ()I
/*      */     //   535: istore #10
/*      */     //   537: aload_0
/*      */     //   538: aload_1
/*      */     //   539: iload #5
/*      */     //   541: iload_2
/*      */     //   542: aload #6
/*      */     //   544: invokevirtual a : (Ljava/lang/CharSequence;IILcom/b/a/a/o$c;)V
/*      */     //   547: aload_0
/*      */     //   548: aload #6
/*      */     //   550: iload #10
/*      */     //   552: iconst_0
/*      */     //   553: invokespecial a : (Lcom/b/a/a/o$c;IZ)V
/*      */     //   556: iload_2
/*      */     //   557: istore #5
/*      */     //   559: goto -> 15
/*      */     //   562: iconst_1
/*      */     //   563: ireturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1054	-> 0
/*      */     //   #1068	-> 6
/*      */     //   #1070	-> 9
/*      */     //   #1071	-> 12
/*      */     //   #1078	-> 15
/*      */     //   #1079	-> 23
/*      */     //   #1080	-> 46
/*      */     //   #1082	-> 58
/*      */     //   #1083	-> 64
/*      */     //   #1087	-> 73
/*      */     //   #1088	-> 81
/*      */     //   #1089	-> 106
/*      */     //   #1092	-> 119
/*      */     //   #1093	-> 143
/*      */     //   #1094	-> 146
/*      */     //   #1097	-> 156
/*      */     //   #1098	-> 172
/*      */     //   #1105	-> 183
/*      */     //   #1106	-> 189
/*      */     //   #1108	-> 194
/*      */     //   #1113	-> 207
/*      */     //   #1114	-> 212
/*      */     //   #1115	-> 238
/*      */     //   #1117	-> 249
/*      */     //   #1122	-> 252
/*      */     //   #1123	-> 263
/*      */     //   #1128	-> 273
/*      */     //   #1129	-> 279
/*      */     //   #1133	-> 284
/*      */     //   #1141	-> 292
/*      */     //   #1142	-> 307
/*      */     //   #1143	-> 319
/*      */     //   #1144	-> 322
/*      */     //   #1146	-> 330
/*      */     //   #1147	-> 338
/*      */     //   #1151	-> 345
/*      */     //   #1156	-> 366
/*      */     //   #1157	-> 391
/*      */     //   #1158	-> 394
/*      */     //   #1159	-> 402
/*      */     //   #1160	-> 405
/*      */     //   #1161	-> 412
/*      */     //   #1172	-> 415
/*      */     //   #1173	-> 418
/*      */     //   #1174	-> 421
/*      */     //   #1180	-> 429
/*      */     //   #1181	-> 444
/*      */     //   #1182	-> 447
/*      */     //   #1184	-> 450
/*      */     //   #1187	-> 455
/*      */     //   #1216	-> 467
/*      */     //   #1217	-> 474
/*      */     //   #1235	-> 482
/*      */     //   #1236	-> 491
/*      */     //   #1262	-> 494
/*      */     //   #1263	-> 505
/*      */     //   #1265	-> 512
/*      */     //   #1270	-> 522
/*      */     //   #1273	-> 530
/*      */     //   #1274	-> 537
/*      */     //   #1275	-> 547
/*      */     //   #1285	-> 556
/*      */     //   #1286	-> 559
/*      */     //   #1287	-> 562 }
/*      */   public final boolean j(int paramInt) { return t(a(paramInt)); }
/*      */   public final boolean a(int paramInt, boolean paramBoolean1, boolean paramBoolean2) { int i; while (true) { if (p(i = a(paramInt)))
/*      */         return true;  if (i <= this.d)
/*      */         return (r(i) && !a.a((char)paramInt));  if (i >= this.e)
/*      */         return false;  if (u(i)) { paramInt = a(paramInt, i); continue; }  break; }  if (((paramInt = this.j.charAt(i)) & 0x20) == 0 && (!paramBoolean1 || paramInt <= 511))
/*      */       return true;  return false; }
/*      */   public final boolean k(int paramInt) { return (g(paramInt) <= 1); }
/*      */   private boolean n(int paramInt) { return (this.g <= paramInt && paramInt <= 65280); }
/*      */   private boolean o(int paramInt) { return (paramInt >= this.g); }
/*      */   private static boolean p(int paramInt) { return (paramInt == 0); }
/*      */   private static boolean q(int paramInt) { return (paramInt == 65280); }
/*      */   private boolean r(int paramInt) { return (paramInt == this.d); }
/*      */   private boolean s(int paramInt) { return (paramInt < this.e); }
/*      */   private boolean t(int paramInt) { return (paramInt < this.d || paramInt == 65280 || (this.g <= paramInt && paramInt <= 65024)); }
/*      */   private boolean u(int paramInt) { return (paramInt >= this.f); }
/*      */   private int v(int paramInt) { if ((this.j.charAt(paramInt) & 0x80) != 0)
/*      */       return this.j.charAt(paramInt - 1) & 0xFF;  return 0; }
/*      */   private int a(int paramInt1, int paramInt2) { return paramInt1 + paramInt2 - this.g - 64 - 1; } private int w(int paramInt) { if (paramInt == 0 || 65024 <= paramInt)
/*      */       return -1;  if ((paramInt -= this.g) < 0)
/*      */       paramInt += 65024;  return paramInt; } private int x(int paramInt) { char c = this.j.charAt(paramInt); return 65024 - this.g + paramInt + 1 + (c & 0x1F); } private void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, c paramc) { while (paramInt1 < paramInt2) { int i = Character.codePointAt(paramCharSequence, paramInt1); paramInt1 += Character.charCount(i); a(i, a(i), paramc); }  } private void a(int paramInt1, int paramInt2, c paramc) { while (true) { if (d(paramInt2)) { paramc.a(paramInt1, f(paramInt2)); return; }  if (r(paramInt2)) { a.a(paramInt1, paramc); return; }  if (u(paramInt2)) { paramInt1 = a(paramInt1, paramInt2); paramInt2 = a(paramInt1); continue; }  break; }  int i = (paramInt1 = this.j.charAt(paramInt2)) & 0x1F; int j = paramInt1 >> 8; if ((paramInt1 & 0x80) != 0) { paramInt1 = this.j.charAt(paramInt2 - 1) >> 8; } else { paramInt1 = 0; }  paramInt2++; paramc.a(this.j, paramInt2, paramInt2 + i, paramInt1, j); } private static int a(String paramString, int paramInt1, int paramInt2) { if (paramInt2 < 13312) { int i = paramInt2 << 1; while (i > (paramInt2 = paramString.charAt(paramInt1)))
/*      */         paramInt1 += 2 + (paramInt2 & 0x1);  if (i == (paramInt2 & 0x7FFE)) { if ((paramInt2 & 0x1) != 0)
/*      */           return paramString.charAt(paramInt1 + 1) << 16 | paramString.charAt(paramInt1 + 2);  return paramString.charAt(paramInt1 + 1); }  } else { int i = 13312 + (paramInt2 >> 9 & 0xFFFFFFFE); int j = paramInt2 << 6 & 0xFFFF; while (true) { while (i > (paramInt2 = paramString.charAt(paramInt1)))
/*      */           paramInt1 += 2 + (paramInt2 & 0x1);  if (i == (paramInt2 & 0x7FFE)) { char c; if (j > (c = paramString.charAt(paramInt1 + 1))) { if ((paramInt2 & 0x8000) == 0) { paramInt1 += 3; continue; }  break; }  if (j == (c & 0xFFC0))
/* 2103 */             return (c & 0xFFFF003F) << 16 | paramString.charAt(paramInt1 + 2);  }  break; }  }  return -1; } private boolean b(int paramInt1, int paramInt2) { while (true) { if (s(paramInt2))
/* 2104 */         return true; 
/* 2105 */       if (o(paramInt2))
/* 2106 */         return false; 
/* 2107 */       if (u(paramInt2)) {
/* 2108 */         paramInt1 = a(paramInt1, paramInt2);
/* 2109 */         paramInt2 = a(paramInt1); continue;
/*      */       } 
/*      */       break; }
/*      */     
/* 2113 */     if (((paramInt1 = this.j.charAt(paramInt2)) & 0x1F) == 0) {
/* 2114 */       return false;
/*      */     }
/* 2116 */     if ((paramInt1 & 0x80) != 0 && (this.j.charAt(paramInt2 - 1) & 0xFF00) != 0) {
/* 2117 */       return false;
/*      */     }
/* 2119 */     return s(a(Character.codePointAt(this.j, paramInt2 + 1))); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int a(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 2136 */     while (paramInt1 < paramInt2) {
/* 2137 */       int i = Character.codePointAt(paramCharSequence, paramInt1);
/* 2138 */       int j = this.h.a(i);
/* 2139 */       if (!b(i, j))
/*      */       {
/*      */         
/* 2142 */         paramInt1 += Character.charCount(i); } 
/*      */     } 
/* 2144 */     return paramInt1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(v paramv, int paramInt1, int paramInt2) {
/*      */     i i;
/*      */     int j;
/* 2170 */     if (((j = paramv.a(paramInt2)) & 0x3FFFFF) == 0 && paramInt1 != 0) {
/*      */ 
/*      */       
/* 2173 */       paramv.d(paramInt2, j | paramInt1);
/*      */       
/*      */       return;
/*      */     } 
/* 2177 */     if ((j & 0x200000) == 0) {
/* 2178 */       int k = j & 0x1FFFFF;
/* 2179 */       j = j & 0xFFE00000 | 0x200000 | this.n.size();
/* 2180 */       paramv.d(paramInt2, j);
/* 2181 */       this.n.add(i = new i());
/* 2182 */       if (k != 0) {
/* 2183 */         i.a(k);
/*      */       }
/*      */     } else {
/* 2186 */       i = this.n.get(j & 0x1FFFFF);
/*      */     } 
/* 2188 */     i.a(paramInt1);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\b\a\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */