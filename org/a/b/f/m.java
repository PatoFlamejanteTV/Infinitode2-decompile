/*     */ package org.a.b.f;
/*     */ 
/*     */ import java.awt.geom.GeneralPath;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Locale;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class m
/*     */ {
/*  42 */   private static final org.a.a.a.a a = c.a(m.class);
/*     */   
/*     */   private l b;
/*     */ 
/*     */   
/*     */   m(l paraml) {
/*  48 */     this.b = paraml;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final GeneralPath a() {
/*  57 */     a[] arrayOfA = a(this.b);
/*  58 */     return a(arrayOfA);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static a[] a(l paraml) {
/*  66 */     byte b1 = 0;
/*  67 */     int i = -1;
/*  68 */     a[] arrayOfA = new a[paraml.c()];
/*  69 */     for (byte b2 = 0; b2 < paraml.c(); b2++) {
/*     */       
/*  71 */       if (i == -1)
/*     */       {
/*  73 */         i = paraml.a(b1);
/*     */       }
/*     */       boolean bool;
/*  76 */       if (bool = (i == b2) ? true : false) {
/*     */         
/*  78 */         b1++;
/*  79 */         i = -1;
/*     */       } 
/*  81 */       arrayOfA[b2] = new a(paraml.c(b2), paraml.d(b2), 
/*  82 */           ((paraml.b(b2) & 0x1) != 0), bool);
/*     */     } 
/*  84 */     return arrayOfA;
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
/*     */   private GeneralPath a(a[] paramArrayOfa) {
/*  96 */     GeneralPath generalPath = new GeneralPath();
/*  97 */     int i = 0; byte b; int j;
/*  98 */     for (b = 0, j = paramArrayOfa.length; b < j; b++) {
/*     */       
/* 100 */       if (a.a(paramArrayOfa[b])) {
/*     */         
/* 102 */         a a1 = paramArrayOfa[i];
/* 103 */         a a2 = paramArrayOfa[b];
/* 104 */         ArrayList<a> arrayList = new ArrayList(); int k;
/* 105 */         for (k = i; k <= b; k++)
/*     */         {
/* 107 */           arrayList.add(paramArrayOfa[k]);
/*     */         }
/* 109 */         if (a.b(paramArrayOfa[i])) {
/*     */ 
/*     */           
/* 112 */           arrayList.add(a1);
/*     */         }
/* 114 */         else if (a.b(paramArrayOfa[b])) {
/*     */ 
/*     */           
/* 117 */           arrayList.add(0, a2);
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 122 */           a a3 = a(a1, a2);
/* 123 */           arrayList.add(0, a3);
/* 124 */           arrayList.add(a3);
/*     */         } 
/* 126 */         a(generalPath, arrayList.get(0));
/* 127 */         for (k = 1, i = arrayList.size(); k < i; k++) {
/*     */ 
/*     */           
/* 130 */           if (a.b(a1 = arrayList.get(k))) {
/*     */             
/* 132 */             b(generalPath, a1);
/*     */           }
/* 134 */           else if (a.b(arrayList.get(k + 1))) {
/*     */             
/* 136 */             a(generalPath, a1, arrayList.get(k + 1));
/* 137 */             k++;
/*     */           }
/*     */           else {
/*     */             
/* 141 */             a(generalPath, a1, a(a1, arrayList.get(k + 1)));
/*     */           } 
/*     */         } 
/* 144 */         generalPath.closePath();
/* 145 */         i = b + 1;
/*     */       } 
/*     */     } 
/* 148 */     return generalPath;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void a(GeneralPath paramGeneralPath, a parama) {
/* 153 */     paramGeneralPath.moveTo(a.c(parama), a.d(parama));
/* 154 */     if (a.a())
/*     */     {
/* 156 */       (new StringBuilder("moveTo: ")).append(String.format(Locale.US, "%d,%d", new Object[] { Integer.valueOf(a.c(parama)), Integer.valueOf(a.d(parama)) }));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static void b(GeneralPath paramGeneralPath, a parama) {
/* 162 */     paramGeneralPath.lineTo(a.c(parama), a.d(parama));
/* 163 */     if (a.a())
/*     */     {
/* 165 */       (new StringBuilder("lineTo: ")).append(String.format(Locale.US, "%d,%d", new Object[] { Integer.valueOf(a.c(parama)), Integer.valueOf(a.d(parama)) }));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static void a(GeneralPath paramGeneralPath, a parama1, a parama2) {
/* 171 */     paramGeneralPath.quadTo(a.c(parama1), a.d(parama1), a.c(parama2), a.d(parama2));
/* 172 */     if (a.a())
/*     */     {
/* 174 */       (new StringBuilder("quadTo: ")).append(String.format(Locale.US, "%d,%d %d,%d", new Object[] { Integer.valueOf(a.c(parama1)), Integer.valueOf(a.d(parama1)), 
/* 175 */               Integer.valueOf(a.c(parama2)), Integer.valueOf(a.d(parama2)) }));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static int a(int paramInt1, int paramInt2) {
/* 181 */     return paramInt1 + (paramInt2 - paramInt1) / 2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private a a(a parama1, a parama2) {
/* 187 */     return new a(a(a.c(parama1), a.c(parama2)), a(a.d(parama1), a.d(parama2)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class a
/*     */   {
/* 195 */     private int a = 0;
/* 196 */     private int b = 0;
/*     */     
/*     */     private boolean c = true;
/*     */     private boolean d = false;
/*     */     
/*     */     a(int param1Int1, int param1Int2, boolean param1Boolean1, boolean param1Boolean2) {
/* 202 */       this.a = param1Int1;
/* 203 */       this.b = param1Int2;
/* 204 */       this.c = param1Boolean1;
/* 205 */       this.d = param1Boolean2;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     a(int param1Int1, int param1Int2) {
/* 211 */       this(param1Int1, param1Int2, true, false);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 217 */       return String.format(Locale.US, "Point(%d,%d,%s,%s)", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), this.c ? "onCurve" : "", this.d ? "endOfContour" : "" });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */