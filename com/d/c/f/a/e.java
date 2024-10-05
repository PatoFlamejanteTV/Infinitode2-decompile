/*     */ package com.d.c.f.a;
/*     */ 
/*     */ import com.d.c.a.a;
/*     */ import com.d.c.a.f;
/*     */ import com.d.c.d.j;
/*     */ import com.d.c.f.c;
/*     */ import com.d.c.f.d;
/*     */ import com.d.c.f.e;
/*     */ import com.d.c.g.a;
/*     */ import com.d.m.l;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class e
/*     */   extends e
/*     */ {
/*     */   private float a;
/*     */   private c b;
/*     */   private short c;
/*     */   
/*     */   public e(c paramc, a parama, j paramj) {
/*  53 */     super(parama, paramj.a(), paramj.d(), paramj.d());
/*     */     
/*  55 */     this.b = paramc;
/*  56 */     this.a = paramj.f();
/*  57 */     this.c = paramj.a();
/*     */   }
/*     */   
/*     */   public final float b() {
/*  61 */     return this.a;
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
/*     */   public final float a(a parama, float paramFloat, d paramd) {
/*  77 */     return a(j(), parama, 
/*     */         
/*  79 */         a(), this.a, this.c, paramFloat, paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean g() {
/*  87 */     return f.b(i());
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
/*     */   public static float a(c paramc, a parama, String paramString, float paramFloat1, short paramShort, float paramFloat2, d paramd) {
/* 103 */     float f2, f1 = Float.MIN_VALUE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     switch (paramShort) {
/*     */       case 5:
/* 111 */         f1 = paramFloat1 * paramd.b();
/*     */         break;
/*     */       case 8:
/* 114 */         f1 = paramFloat1 * 2.54F * 10.0F / paramd.a();
/*     */         break;
/*     */       case 6:
/* 117 */         f1 = paramFloat1 * 10.0F / paramd.a();
/*     */         break;
/*     */       case 7:
/* 120 */         f1 = paramFloat1 / paramd.a();
/*     */         break;
/*     */       case 9:
/* 123 */         f1 = paramFloat1 * 0.013888889F * 2.54F * 10.0F / paramd.a();
/*     */         break;
/*     */       case 10:
/* 126 */         f1 = paramFloat1 * 12.0F * 0.013888889F * 2.54F * 10.0F / paramd.a();
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 3:
/* 134 */         if (parama == a.M) {
/* 135 */           a a1 = paramc.a().b(paramd);
/*     */           
/* 137 */           f1 = paramFloat1 * a1.a; break;
/*     */         } 
/* 139 */         f1 = paramFloat1 * (paramc.b(paramd)).a;
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 4:
/* 148 */         if (parama == a.M) {
/* 149 */           a a1 = paramc.a().b(paramd);
/* 150 */           f2 = paramd.b(a1);
/*     */         } else {
/* 152 */           a a1 = paramc.b(paramd);
/* 153 */           f2 = paramd.b(a1);
/*     */         } 
/* 155 */         f1 = paramFloat1 * f2;
/*     */         break;
/*     */ 
/*     */       
/*     */       case 2:
/* 160 */         if (parama == a.as) {
/* 161 */           paramFloat2 = paramc.a().c(paramd);
/* 162 */         } else if (parama == a.M) {
/*     */           
/* 164 */           a a1 = paramc.a().b(paramd);
/* 165 */           paramFloat2 = paramd.a(a1);
/* 166 */         } else if (parama == a.N) {
/* 167 */           a a1 = paramc.b(paramd);
/* 168 */           paramFloat2 = paramd.a(a1);
/*     */         } 
/* 170 */         f1 = paramFloat1 / 100.0F * paramFloat2;
/*     */         break;
/*     */       
/*     */       case 1:
/* 174 */         f1 = paramFloat1;
/*     */         break;
/*     */       
/*     */       default:
/* 178 */         l.c(Level.WARNING, "Asked to convert " + parama + " from relative to absolute,  don't recognize the datatype '" + 
/*     */ 
/*     */             
/* 181 */             f.a(paramShort) + "' " + paramShort + "(" + paramString + ")");
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 186 */     if (l.b()) {
/* 187 */       if (parama == a.M) {
/* 188 */         l.c(Level.FINEST, parama + ", relative= " + paramFloat1 + " (" + paramString + "), absolute= " + f1);
/*     */       }
/*     */       else {
/*     */         
/* 192 */         l.c(Level.FINEST, parama + ", relative= " + paramFloat1 + " (" + paramString + "), absolute= " + f1 + " using base=" + paramFloat2);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     double d1;
/*     */ 
/*     */     
/* 200 */     return f1 = (float)(d1 = Math.round(f1));
/*     */   }
/*     */   
/*     */   private c j() {
/* 204 */     return this.b;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\f\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */