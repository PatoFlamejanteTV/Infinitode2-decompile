/*     */ package org.a.c.c;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.i.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class d
/*     */   extends l
/*     */ {
/*  35 */   private static final a a = c.a(d.class);
/*     */   
/*  37 */   private static final int[] b = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k a(InputStream paramInputStream, OutputStream paramOutputStream, org.a.c.b.d paramd, int paramInt) {
/*  71 */     while ((paramInt = paramInputStream.read()) != -1) {
/*     */ 
/*     */       
/*  74 */       while (a(paramInt))
/*     */       {
/*  76 */         paramInt = paramInputStream.read();
/*     */       }
/*  78 */       if (paramInt != -1 && !b(paramInt)) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  83 */         if (b[paramInt] == -1)
/*     */         {
/*  85 */           (new StringBuilder("Invalid hex, int: ")).append(paramInt).append(" char: ").append((char)paramInt);
/*     */         }
/*  87 */         paramInt = b[paramInt] << 4;
/*     */         
/*     */         int i;
/*  90 */         if ((i = paramInputStream.read()) == -1 || b(i)) {
/*     */ 
/*     */           
/*  93 */           paramOutputStream.write(paramInt);
/*     */           break;
/*     */         } 
/*  96 */         if (i >= 0) {
/*     */           
/*  98 */           if (b[i] == -1)
/*     */           {
/* 100 */             (new StringBuilder("Invalid hex, int: ")).append(i).append(" char: ").append((char)i);
/*     */           }
/* 102 */           paramInt += b[i];
/*     */         } 
/* 104 */         paramOutputStream.write(paramInt);
/*     */       } 
/* 106 */     }  paramOutputStream.flush();
/* 107 */     return new k(paramd);
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
/*     */   private static boolean a(int paramInt) {
/* 119 */     return (paramInt == 0 || paramInt == 9 || paramInt == 10 || paramInt == 12 || paramInt == 13 || paramInt == 32);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean b(int paramInt) {
/* 124 */     return (paramInt == 62);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(InputStream paramInputStream, OutputStream paramOutputStream, org.a.c.b.d paramd) {
/*     */     int i;
/* 132 */     while ((i = paramInputStream.read()) != -1)
/*     */     {
/* 134 */       c.a((byte)i, paramOutputStream);
/*     */     }
/* 136 */     paramOutputStream.flush();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */