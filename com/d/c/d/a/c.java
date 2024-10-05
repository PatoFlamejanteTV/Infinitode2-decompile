/*      */ package com.d.c.d.a;
/*      */ 
/*      */ import com.d.a.c;
/*      */ import com.d.c.d.g;
/*      */ import com.d.c.d.h;
/*      */ import com.d.c.d.j;
/*      */ import com.d.i.v;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class c
/*      */   implements c
/*      */ {
/*      */   static abstract class e
/*      */     extends a
/*      */   {
/*      */     private e() {}
/*      */     
/*      */     private static void a(List<v> param1List, com.d.c.a.a[] param1ArrayOfa, com.d.c.d.d param1d, int param1Int, boolean param1Boolean) {
/*   39 */       for (byte b = 0; b < param1ArrayOfa.length; b++) {
/*   40 */         param1List.add(new v(param1ArrayOfa[b], param1d, param1Boolean, param1Int));
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public List a(com.d.c.a.a param1a, List<com.d.c.d.d> param1List, int param1Int, boolean param1Boolean1, boolean param1Boolean2) {
/*      */       com.d.c.d.d d;
/*   47 */       com.d.c.a.a[][] arrayOfA = a();
/*      */       
/*   49 */       ArrayList arrayList = new ArrayList(3);
/*      */       
/*   51 */       if (param1List.size() == 1 && ((com.d.c.d.d)param1List
/*   52 */         .get(0)).e() == 0) {
/*   53 */         d = param1List.get(0);
/*   54 */         a(arrayList, arrayOfA[0], d, param1Int, param1Boolean1);
/*   55 */         a(arrayList, arrayOfA[1], d, param1Int, param1Boolean1);
/*   56 */         a(arrayList, arrayOfA[2], d, param1Int, param1Boolean1);
/*      */         
/*   58 */         return arrayList;
/*      */       } 
/*   60 */       a((com.d.c.a.a)d, 1, 3, param1List.size());
/*   61 */       boolean bool1 = false;
/*   62 */       boolean bool2 = false;
/*   63 */       boolean bool3 = false;
/*      */       
/*   65 */       for (Iterator<com.d.c.d.d> iterator = param1List.iterator(); iterator.hasNext(); ) {
/*      */         com.d.c.d.d d1;
/*   67 */         a(d1 = iterator.next(), false);
/*   68 */         boolean bool = false;
/*      */         com.d.c.d.d d2;
/*   70 */         if ((d2 = d(d1)) != null) {
/*   71 */           if (bool3) {
/*   72 */             throw new com.d.c.d.b("A border width cannot be set twice", -1);
/*      */           }
/*   74 */           bool3 = true;
/*   75 */           bool = true;
/*   76 */           a(arrayList, arrayOfA[0], d2, param1Int, param1Boolean1);
/*      */         } 
/*      */         
/*   79 */         if (c(d1)) {
/*   80 */           if (bool1) {
/*   81 */             throw new com.d.c.d.b("A border style cannot be set twice", -1);
/*      */           }
/*   83 */           bool1 = true;
/*   84 */           bool = true;
/*   85 */           a(arrayList, arrayOfA[1], d1, param1Int, param1Boolean1);
/*      */         } 
/*      */ 
/*      */         
/*   89 */         if ((d2 = e(d1)) != null) {
/*   90 */           if (bool2) {
/*   91 */             throw new com.d.c.d.b("A border color cannot be set twice", -1);
/*      */           }
/*   93 */           bool2 = true;
/*   94 */           bool = true;
/*   95 */           a(arrayList, arrayOfA[2], d2, param1Int, param1Boolean1);
/*      */         } 
/*      */         
/*   98 */         if (!bool) {
/*   99 */           throw new com.d.c.d.b(d1.d() + " is not a border width, style, or color", -1);
/*      */         }
/*      */       } 
/*      */       
/*  103 */       if (!bool3) {
/*  104 */         a(arrayList, arrayOfA[0], (com.d.c.d.d)new j(com.d.c.a.c.L), param1Int, param1Boolean1);
/*      */       }
/*      */       
/*  107 */       if (!bool1) {
/*  108 */         a(arrayList, arrayOfA[1], (com.d.c.d.d)new j(com.d.c.a.c.L), param1Int, param1Boolean1);
/*      */       }
/*      */       
/*  111 */       if (!bool2) {
/*  112 */         a(arrayList, arrayOfA[2], (com.d.c.d.d)new j(com.d.c.a.c.L), param1Int, param1Boolean1);
/*      */       }
/*      */       
/*  115 */       return arrayList;
/*      */     }
/*      */ 
/*      */     
/*      */     private static boolean c(com.d.c.d.d param1d) {
/*  120 */       if (param1d.a() != 21) {
/*  121 */         return false;
/*      */       }
/*      */       
/*      */       com.d.c.a.c c;
/*  125 */       if ((c = com.d.c.a.c.b(param1d.d())) == null) {
/*  126 */         return false;
/*      */       }
/*      */       
/*  129 */       return l.a.get(c.a);
/*      */     }
/*      */     
/*      */     private com.d.c.d.d d(com.d.c.d.d param1d) {
/*      */       short s;
/*  134 */       if ((s = param1d.a()) != 21 && !a(param1d)) {
/*  135 */         return null;
/*      */       }
/*      */       
/*  138 */       if (a(param1d)) {
/*  139 */         return param1d;
/*      */       }
/*      */       com.d.c.a.c c;
/*  142 */       if ((c = com.d.c.a.c.b(param1d.c())) == null) {
/*  143 */         return null;
/*      */       }
/*      */       
/*  146 */       if (l.b.get(c.a)) {
/*  147 */         return (com.d.c.d.d)f.b(c.toString());
/*      */       }
/*  149 */       return null;
/*      */     }
/*      */     
/*      */     protected abstract com.d.c.a.a[][] a();
/*      */     
/*      */     private static com.d.c.d.d e(com.d.c.d.d param1d) {
/*      */       short s;
/*  156 */       if ((s = param1d.a()) != 21 && s != 25) {
/*  157 */         return null;
/*      */       }
/*      */       
/*  160 */       if (s == 25) {
/*  161 */         return param1d;
/*      */       }
/*      */       h h;
/*  164 */       if ((h = f.a(param1d.c())) != null) {
/*  165 */         return (com.d.c.d.d)new j((g)h);
/*      */       }
/*      */       
/*      */       com.d.c.a.c c;
/*  169 */       if ((c = com.d.c.a.c.b(param1d.d())) == null || c != com.d.c.a.c.bj) {
/*  170 */         return null;
/*      */       }
/*      */       
/*  173 */       return param1d;
/*      */     } }
/*      */   
/*      */   public static class f extends e {
/*      */     public f() {
/*  178 */       super((byte)0);
/*      */     } protected final com.d.c.a.a[][] a() {
/*  180 */       return new com.d.c.a.a[][] { { com.d.c.a.a.aK }, { com.d.c.a.a.aG }, { com.d.c.a.a.aC } };
/*      */     }
/*      */   }
/*      */   
/*      */   public static class d
/*      */     extends e {
/*      */     public d() {
/*  187 */       super((byte)0);
/*      */     } protected final com.d.c.a.a[][] a() {
/*  189 */       return new com.d.c.a.a[][] { { com.d.c.a.a.aL }, { com.d.c.a.a.aH }, { com.d.c.a.a.aD } };
/*      */     }
/*      */   }
/*      */   
/*      */   public static class b
/*      */     extends e {
/*      */     public b() {
/*  196 */       super((byte)0);
/*      */     } protected final com.d.c.a.a[][] a() {
/*  198 */       return new com.d.c.a.a[][] { { com.d.c.a.a.aM }, { com.d.c.a.a.aI }, { com.d.c.a.a.aE } };
/*      */     }
/*      */   }
/*      */   
/*      */   public static class c
/*      */     extends e {
/*      */     public c() {
/*  205 */       super((byte)0);
/*      */     } protected final com.d.c.a.a[][] a() {
/*  207 */       return new com.d.c.a.a[][] { { com.d.c.a.a.aN }, { com.d.c.a.a.aJ }, { com.d.c.a.a.aF } };
/*      */     }
/*      */   }
/*      */   
/*      */   public static class a
/*      */     extends e {
/*      */     public a() {
/*  214 */       super((byte)0);
/*      */     } protected final com.d.c.a.a[][] a() {
/*  216 */       return new com.d.c.a.a[][] { { com.d.c.a.a.aK, com.d.c.a.a.aL, com.d.c.a.a.aM, com.d.c.a.a.aN }, { com.d.c.a.a.aG, com.d.c.a.a.aH, com.d.c.a.a.aI, com.d.c.a.a.aJ }, { com.d.c.a.a.aC, com.d.c.a.a.aD, com.d.c.a.a.aE, com.d.c.a.a.aF } };
/*      */     }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public com.d.a.b a() {
/* 1006 */     return (com.d.a.b)new com.d.a.e();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */