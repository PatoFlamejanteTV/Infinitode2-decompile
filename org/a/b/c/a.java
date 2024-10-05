/*     */ package org.a.b.c;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ public class a
/*     */ {
/*  35 */   private static final org.a.a.a.a a = c.a(a.class);
/*     */ 
/*     */   
/*  38 */   private String b = null;
/*     */ 
/*     */ 
/*     */   
/*  42 */   private String c = null;
/*  43 */   private String d = null;
/*     */ 
/*     */   
/*  46 */   private int e = 4;
/*     */   
/*     */   private int f;
/*     */   
/*  50 */   private final List<d> g = new ArrayList<d>();
/*     */ 
/*     */   
/*  53 */   private final Map<Integer, String> h = new HashMap<Integer, String>();
/*     */ 
/*     */   
/*  56 */   private final Map<Integer, Integer> i = new HashMap<Integer, Integer>();
/*  57 */   private final List<c> j = new ArrayList<c>();
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
/*     */   public final boolean a() {
/*  76 */     return (!this.i.isEmpty() || !this.j.isEmpty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b() {
/*  86 */     return !this.h.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a(int paramInt) {
/*  97 */     return this.h.get(Integer.valueOf(paramInt));
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
/*     */   public final int a(InputStream paramInputStream) {
/* 110 */     byte[] arrayOfByte = new byte[this.f];
/* 111 */     paramInputStream.read(arrayOfByte, 0, this.e);
/* 112 */     for (int i = this.e - 1; i < this.f; i++) {
/*     */       
/* 114 */       int j = i + 1;
/* 115 */       for (Iterator<d> iterator = this.g.iterator(); iterator.hasNext();) {
/*     */         
/* 117 */         if ((d = iterator.next()).a(arrayOfByte, j))
/*     */         {
/* 119 */           return a(arrayOfByte, j);
/*     */         }
/*     */       } 
/* 122 */       if (j < this.f)
/*     */       {
/* 124 */         arrayOfByte[j] = (byte)paramInputStream.read();
/*     */       }
/*     */     } 
/* 127 */     String str = "";
/* 128 */     for (byte b = 0; b < this.f; b++) {
/*     */       
/* 130 */       str = str + String.format("0x%02X (%04o) ", new Object[] { Byte.valueOf(arrayOfByte[b]), Byte.valueOf(arrayOfByte[b]) });
/*     */     } 
/* 132 */     (new StringBuilder("Invalid character code sequence ")).append(str).append("in CMap ").append(this.b);
/* 133 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int a(byte[] paramArrayOfbyte, int paramInt) {
/* 141 */     int i = 0;
/* 142 */     for (byte b = 0; b < paramInt; b++)
/*     */     {
/*     */       
/* 145 */       i = (i = i << 8) | paramArrayOfbyte[b] & 0xFF;
/*     */     }
/* 147 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b(int paramInt) {
/*     */     Integer integer;
/* 159 */     if ((integer = this.i.get(Integer.valueOf(paramInt))) != null)
/*     */     {
/* 161 */       return integer.intValue();
/*     */     }
/* 163 */     for (Iterator<c> iterator = this.j.iterator(); iterator.hasNext();) {
/*     */ 
/*     */       
/* 166 */       if ((i = (c = iterator.next()).a((char)paramInt)) != -1)
/*     */       {
/* 168 */         return i;
/*     */       }
/*     */     } 
/* 171 */     return 0;
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
/*     */   private static int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 183 */     paramInt1 = 0;
/* 184 */     for (byte b = 0; b < paramInt2; b++)
/*     */     {
/*     */       
/* 187 */       paramInt1 = (paramInt1 = paramInt1 << 8) | (paramArrayOfbyte[b + 0] + 256) % 256;
/*     */     }
/* 189 */     return paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(byte[] paramArrayOfbyte, String paramString) {
/* 200 */     int i = a(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/* 201 */     this.h.put(Integer.valueOf(i), paramString);
/*     */ 
/*     */     
/* 204 */     " ".equals(paramString);
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
/*     */   final void a(int paramInt1, int paramInt2) {
/* 218 */     this.i.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
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
/*     */   final void a(char paramChar1, char paramChar2, int paramInt) {
/* 231 */     c c = null;
/* 232 */     if (!this.j.isEmpty())
/*     */     {
/* 234 */       c = this.j.get(this.j.size() - 1);
/*     */     }
/* 236 */     if (c == null || !c.a(paramChar1, paramChar2, paramInt))
/*     */     {
/* 238 */       this.j.add(new c(paramChar1, paramChar2, paramInt));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(d paramd) {
/* 249 */     this.g.add(paramd);
/* 250 */     this.f = Math.max(this.f, paramd.a());
/* 251 */     this.e = Math.min(this.e, paramd.a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(a parama) {
/* 262 */     for (d d : parama.g)
/*     */     {
/* 264 */       a(d);
/*     */     }
/* 266 */     this.h.putAll(parama.h);
/* 267 */     this.i.putAll(parama.i);
/* 268 */     this.j.addAll(parama.j);
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
/*     */   
/*     */   public final String c() {
/* 300 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(String paramString) {
/* 310 */     this.b = paramString;
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
/*     */   public final String d() {
/* 360 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(String paramString) {
/* 370 */     this.c = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String e() {
/* 380 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void c(String paramString) {
/* 390 */     this.d = paramString;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 426 */     return this.b;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */