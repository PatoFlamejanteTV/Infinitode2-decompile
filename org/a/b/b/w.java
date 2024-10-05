/*     */ package org.a.b.b;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.a.b.g.c;
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
/*     */ public class w
/*     */   extends t
/*     */ {
/*  34 */   private float c = 0.0F;
/*  35 */   private float d = 0.0F;
/*  36 */   private int e = 0;
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
/*     */   public w(c paramc, String paramString1, String paramString2, int paramInt1, List<Object> paramList, int paramInt2, int paramInt3) {
/*  53 */     super(paramc, paramString1, paramString2);
/*     */ 
/*     */     
/*  56 */     this.c = paramInt2;
/*  57 */     this.d = paramInt3;
/*  58 */     a(paramList);
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
/*     */   private void a(List<Object> paramList) {
/*  83 */     this.a = new ArrayList();
/*  84 */     this.e = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     x x;
/*     */ 
/*     */ 
/*     */     
/*  92 */     (x = new x(this)).a(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private List<Number> a(List<Number> paramList, q paramq) {
/*  98 */     this.b++;
/*  99 */     String str = q.b.get(paramq.a());
/*     */     
/* 101 */     if ("hstem".equals(str))
/*     */     
/* 103 */     { a(paramList, (paramList.size() % 2 != 0));
/*     */        }
/*     */     
/* 106 */     else if ("vstem".equals(str))
/*     */     
/* 108 */     { a(paramList, (paramList.size() % 2 != 0)); }
/*     */     else
/*     */     { int i;
/* 111 */       if ("vmoveto".equals(str))
/*     */       
/* 113 */       { paramList = a(paramList, (paramList.size() > 1));
/* 114 */         c(); }
/*     */       else
/*     */       
/* 117 */       { if ("rlineto".equals(str))
/*     */         
/* 119 */         { b(a(paramList, 2), paramq); }
/*     */         
/* 121 */         else if ("hlineto".equals(str))
/*     */         
/* 123 */         { b(paramList, true); }
/*     */         
/* 125 */         else if ("vlineto".equals(str))
/*     */         
/* 127 */         { b(paramList, false); }
/*     */         
/* 129 */         else if ("rrcurveto".equals(str))
/*     */         
/* 131 */         { b(a(paramList, 6), paramq); }
/*     */         
/* 133 */         else if ("endchar".equals(str))
/*     */         
/* 135 */         { paramList = a(paramList, (paramList.size() == 5 || paramList.size() == 1));
/* 136 */           d();
/* 137 */           if (paramList.size() == 4) {
/*     */ 
/*     */             
/* 140 */             paramList.add(0, Integer.valueOf(0));
/* 141 */             c(paramList, new q(12, 6));
/*     */           }
/*     */           else {
/*     */             
/* 145 */             c(paramList, paramq);
/*     */           }  }
/*     */         else
/* 148 */         { if ("rmoveto".equals(str))
/*     */           
/* 150 */           { paramList = a(paramList, (paramList.size() > 2));
/* 151 */             c();
/*     */              }
/*     */           
/* 154 */           else if ("hmoveto".equals(str))
/*     */           
/* 156 */           { paramList = a(paramList, (paramList.size() > 1));
/* 157 */             c(); }
/*     */           else
/*     */           
/* 160 */           { if ("vhcurveto".equals(str))
/*     */             
/* 162 */             { c(paramList, false); }
/*     */             
/* 164 */             else if ("hvcurveto".equals(str))
/*     */             
/* 166 */             { c(paramList, true); }
/*     */             else
/* 168 */             { List<Number> list; if ("hflex".equals(str))
/*     */               
/* 170 */               { List<Number> list1 = Arrays.asList(new Number[] { paramList.get(0), Integer.valueOf(0), paramList
/* 171 */                       .get(1), paramList.get(2), paramList.get(3), Integer.valueOf(0) });
/* 172 */                 list = Arrays.asList(new Number[] { paramList.get(4), Integer.valueOf(0), paramList
/* 173 */                       .get(5), Float.valueOf(-((Number)paramList.get(2)).floatValue()), paramList
/* 174 */                       .get(6), Integer.valueOf(0) });
/* 175 */                 b(Arrays.asList((List<Number>[])new List[] { list1, list }, ), new q(8)); }
/*     */               
/* 177 */               else if ("flex".equals(list))
/*     */               
/* 179 */               { List<Number> list1 = paramList.subList(0, 6);
/* 180 */                 list = paramList.subList(6, 12);
/* 181 */                 b(Arrays.asList((List<Number>[])new List[] { list1, list }, ), new q(8)); }
/*     */               
/* 183 */               else if ("hflex1".equals(list))
/*     */               
/* 185 */               { List<Number> list1 = Arrays.asList(new Number[] { paramList.get(0), paramList.get(1), paramList
/* 186 */                       .get(2), paramList.get(3), paramList.get(4), Integer.valueOf(0) });
/* 187 */                 list = Arrays.asList(new Number[] { paramList.get(5), Integer.valueOf(0), paramList
/* 188 */                       .get(6), paramList.get(7), paramList.get(8), Integer.valueOf(0) });
/* 189 */                 b(Arrays.asList((List<Number>[])new List[] { list1, list }, ), new q(8)); }
/*     */               else
/* 191 */               { int j; if ("flex1".equals(list))
/*     */                 
/* 193 */                 { i = 0;
/* 194 */                   j = 0;
/* 195 */                   for (byte b = 0; b < 5; b++) {
/*     */                     
/* 197 */                     i += ((Number)paramList.get(b << 1)).intValue();
/* 198 */                     j += ((Number)paramList.get((b << 1) + 1)).intValue();
/*     */                   } 
/* 200 */                   List<Number> list1 = paramList.subList(0, 6);
/* 201 */                   paramList = Arrays.asList(new Number[] { paramList.get(6), paramList.get(7), paramList.get(8), paramList
/* 202 */                         .get(9), (Math.abs(i) > Math.abs(j)) ? paramList.get(10) : Integer.valueOf(-i), 
/* 203 */                         (Math.abs(i) > Math.abs(j)) ? Integer.valueOf(-j) : paramList.get(10) });
/* 204 */                   b(Arrays.asList((List<Number>[])new List[] { list1, paramList }, ), new q(8)); }
/*     */                 
/* 206 */                 else if ("hstemhm".equals(j))
/*     */                 
/* 208 */                 { a(paramList, (paramList.size() % 2 != 0));
/*     */                    }
/*     */                 
/* 211 */                 else if ("hintmask".equals(j) || "cntrmask".equals(j))
/*     */                 
/*     */                 { 
/* 214 */                   if ((paramList = a(paramList, (paramList.size() % 2 != 0))).size() > 0);
/*     */ 
/*     */                   
/*     */                    }
/*     */                 
/* 219 */                 else if ("vstemhm".equals(j))
/*     */                 
/* 221 */                 { a(paramList, (paramList.size() % 2 != 0));
/*     */                    }
/*     */                 
/* 224 */                 else if ("rcurveline".equals(j))
/*     */                 
/* 226 */                 { if (paramList.size() >= 2)
/*     */                   {
/* 228 */                     b(a(paramList.subList(0, paramList.size() - 2), 6), new q(8));
/*     */                     
/* 230 */                     c(paramList.subList(paramList.size() - 2, paramList.size()), new q(5));
/*     */                   }
/*     */                    }
/*     */                 
/* 234 */                 else if ("rlinecurve".equals(j))
/*     */                 
/* 236 */                 { if (paramList.size() >= 6)
/*     */                   {
/* 238 */                     b(a(paramList.subList(0, paramList.size() - 6), 2), new q(5));
/*     */                     
/* 240 */                     c(paramList.subList(paramList.size() - 6, paramList.size()), new q(8));
/*     */                   }
/*     */                    }
/*     */                 
/* 244 */                 else if ("vvcurveto".equals(j))
/*     */                 
/* 246 */                 { d(paramList, false); }
/*     */                 else
/* 248 */                 { if ("hhcurveto".equals(j))
/*     */                   
/* 250 */                   { d(paramList, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                     
/* 256 */                     return null; }  c(paramList, i); }  }  }  return null; }  c(paramList, i); }  return null; }  c(paramList, i); }  return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private List<Number> a(List<Number> paramList, boolean paramBoolean) {
/* 261 */     if (this.a.isEmpty())
/*     */     {
/* 263 */       if (paramBoolean) {
/*     */         
/* 265 */         c(Arrays.asList(new Number[] { Float.valueOf(0.0F), Float.valueOf(((Number)paramList.get(0)).floatValue() + this.d) }, ), new q(13));
/*     */         
/* 267 */         paramList = paramList.subList(1, paramList.size());
/*     */       }
/*     */       else {
/*     */         
/* 271 */         c(Arrays.asList(new Number[] { Float.valueOf(0.0F), Float.valueOf(this.c) }, ), new q(13));
/*     */       } 
/*     */     }
/*     */     
/* 275 */     return paramList;
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
/*     */   private void c() {
/* 289 */     if (this.e > 0)
/*     */     {
/* 291 */       d();
/*     */     }
/* 293 */     this.e++;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void d() {
/* 299 */     q q1 = (this.e > 0) ? (q)this.a.get(this.a.size() - 1) : null;
/*     */ 
/*     */     
/* 302 */     q q2 = new q(9);
/* 303 */     if (q1 != null && !q2.equals(q1))
/*     */     {
/* 305 */       c(Collections.emptyList(), q2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(List<Number> paramList, boolean paramBoolean) {
/* 311 */     while (paramList.size() > 0) {
/*     */       
/* 313 */       c(paramList.subList(0, 1), new q(paramBoolean ? 6 : 7));
/*     */       
/* 315 */       paramList = paramList.subList(1, paramList.size());
/* 316 */       paramBoolean = !paramBoolean;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void c(List<Number> paramList, boolean paramBoolean) {
/* 322 */     while (paramList.size() >= 4) {
/*     */       
/* 324 */       boolean bool = (paramList.size() == 5) ? true : false;
/* 325 */       if (paramBoolean) {
/*     */         
/* 327 */         c(Arrays.asList(new Number[] { paramList.get(0), Integer.valueOf(0), paramList
/* 328 */                 .get(1), paramList.get(2), bool ? paramList.get(4) : 
/* 329 */                 Integer.valueOf(0), paramList.get(3) }, ), new q(8));
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 334 */         c(Arrays.asList(new Number[] { Integer.valueOf(0), paramList.get(0), paramList
/* 335 */                 .get(1), paramList.get(2), paramList.get(3), bool ? paramList
/* 336 */                 .get(4) : Integer.valueOf(0) }, ), new q(8));
/*     */       } 
/*     */       
/* 339 */       paramList = paramList.subList(bool ? 5 : 4, paramList.size());
/* 340 */       paramBoolean = !paramBoolean;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void d(List<Number> paramList, boolean paramBoolean) {
/* 346 */     while (paramList.size() >= 4) {
/*     */       
/* 348 */       boolean bool = (paramList.size() % 4 == 1) ? true : false;
/*     */       
/* 350 */       if (paramBoolean) {
/*     */         
/* 352 */         c(Arrays.asList(new Number[] { paramList.get(bool ? 1 : 0), bool ? paramList
/* 353 */                 .get(0) : Integer.valueOf(0), paramList
/* 354 */                 .get(bool ? 2 : 1), paramList
/* 355 */                 .get(bool ? 3 : 2), paramList.get(bool ? 4 : 3), 
/* 356 */                 Integer.valueOf(0) }, ), new q(8));
/*     */       }
/*     */       else {
/*     */         
/* 360 */         c(Arrays.asList(new Number[] { bool ? paramList.get(0) : Integer.valueOf(0), paramList.get(bool ? 1 : 0), paramList
/* 361 */                 .get(bool ? 2 : 1), paramList.get(bool ? 3 : 2), 
/* 362 */                 Integer.valueOf(0), paramList.get(bool ? 4 : 3) }, ), new q(8));
/*     */       } 
/*     */       
/* 365 */       paramList = paramList.subList(bool ? 5 : 4, paramList.size());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(List<List<Number>> paramList, q paramq) {
/* 371 */     for (List<Number> list : paramList)
/*     */     {
/* 373 */       c(list, paramq);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void c(List<Number> paramList, q paramq) {
/* 379 */     this.a.addAll(paramList);
/* 380 */     this.a.add(paramq);
/*     */   }
/*     */ 
/*     */   
/*     */   private static <E> List<List<E>> a(List<E> paramList, int paramInt) {
/* 385 */     ArrayList<List<E>> arrayList = new ArrayList();
/* 386 */     for (byte b = 0; b < paramList.size() / paramInt; b++)
/*     */     {
/* 388 */       arrayList.add(paramList.subList(b * paramInt, (b + 1) * paramInt));
/*     */     }
/* 390 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\b\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */