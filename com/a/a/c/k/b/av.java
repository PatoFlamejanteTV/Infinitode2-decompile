/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.k.k;
/*     */ import com.a.a.c.o;
/*     */ import java.util.Objects;
/*     */ import java.util.UUID;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class av
/*     */   extends an<UUID>
/*     */   implements k
/*     */ {
/*  29 */   private static char[] a = "0123456789abcdef".toCharArray();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Boolean b;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public av() {
/*  40 */     this((Boolean)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private av(Boolean paramBoolean) {
/*  46 */     super(UUID.class);
/*  47 */     this.b = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(UUID paramUUID) {
/*  54 */     if (paramUUID.getLeastSignificantBits() == 0L && paramUUID
/*  55 */       .getMostSignificantBits() == 0L) {
/*  56 */       return true;
/*     */     }
/*  58 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final o<?> a(aa paramaa, c paramc) {
/*     */     Boolean bool;
/*  65 */     l.d d = a(paramaa, paramc, 
/*  66 */         a());
/*  67 */     paramc = null;
/*     */     
/*  69 */     if (d != null) {
/*     */       l.c c1;
/*  71 */       if ((c1 = d.c()) == l.c.i) {
/*  72 */         bool = Boolean.TRUE;
/*  73 */       } else if (c1 == l.c.h) {
/*  74 */         bool = Boolean.FALSE;
/*     */       } 
/*     */     } 
/*     */     
/*  78 */     if (!Objects.equals(bool, this.b)) {
/*  79 */       return new av(bool);
/*     */     }
/*  81 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(UUID paramUUID, h paramh) {
/*  89 */     if (a(paramh)) {
/*  90 */       paramh.a(b(paramUUID));
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/*  97 */     char[] arrayOfChar = new char[36];
/*     */     long l1;
/*  99 */     a((int)((l1 = paramUUID.getMostSignificantBits()) >> 32L), arrayOfChar, 0);
/* 100 */     arrayOfChar[8] = '-';
/*     */     int i;
/* 102 */     b((i = (int)l1) >>> 16, arrayOfChar, 9);
/* 103 */     arrayOfChar[13] = '-';
/* 104 */     b(i, arrayOfChar, 14);
/* 105 */     arrayOfChar[18] = '-';
/*     */     
/*     */     long l2;
/* 108 */     b((int)((l2 = paramUUID.getLeastSignificantBits()) >>> 48L), arrayOfChar, 19);
/* 109 */     arrayOfChar[23] = '-';
/* 110 */     b((int)(l2 >>> 32L), arrayOfChar, 24);
/* 111 */     a((int)l2, arrayOfChar, 28);
/*     */     
/* 113 */     paramh.a(arrayOfChar, 0, 36);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(h paramh) {
/* 119 */     if (this.b != null) {
/* 120 */       return this.b.booleanValue();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     return (!(paramh instanceof com.a.a.c.m.ac) && paramh.f());
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
/*     */   private static void a(int paramInt1, char[] paramArrayOfchar, int paramInt2) {
/* 140 */     b(paramInt1 >> 16, paramArrayOfchar, paramInt2);
/* 141 */     b(paramInt1, paramArrayOfchar, paramInt2 + 4);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void b(int paramInt1, char[] paramArrayOfchar, int paramInt2) {
/* 146 */     paramArrayOfchar[paramInt2] = a[paramInt1 >> 12 & 0xF];
/* 147 */     paramArrayOfchar[++paramInt2] = a[paramInt1 >> 8 & 0xF];
/* 148 */     paramArrayOfchar[++paramInt2] = a[paramInt1 >> 4 & 0xF];
/* 149 */     paramArrayOfchar[++paramInt2] = a[paramInt1 & 0xF];
/*     */   }
/*     */ 
/*     */   
/*     */   private static final byte[] b(UUID paramUUID) {
/* 154 */     byte[] arrayOfByte = new byte[16];
/* 155 */     long l1 = paramUUID.getMostSignificantBits();
/* 156 */     long l2 = paramUUID.getLeastSignificantBits();
/* 157 */     a((int)(l1 >> 32L), arrayOfByte, 0);
/* 158 */     a((int)l1, arrayOfByte, 4);
/* 159 */     a((int)(l2 >> 32L), arrayOfByte, 8);
/* 160 */     a((int)l2, arrayOfByte, 12);
/* 161 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final void a(int paramInt1, byte[] paramArrayOfbyte, int paramInt2) {
/* 166 */     paramArrayOfbyte[paramInt2] = (byte)(paramInt1 >> 24);
/* 167 */     paramArrayOfbyte[++paramInt2] = (byte)(paramInt1 >> 16);
/* 168 */     paramArrayOfbyte[++paramInt2] = (byte)(paramInt1 >> 8);
/* 169 */     paramArrayOfbyte[++paramInt2] = (byte)paramInt1;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\av.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */