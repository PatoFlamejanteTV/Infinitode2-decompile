/*     */ package org.a.b.b;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class q
/*     */ {
/*  32 */   private a c = null;
/*     */ 
/*     */   
/*     */   public static final Map<a, String> a;
/*     */   
/*     */   public static final Map<a, String> b;
/*     */ 
/*     */   
/*     */   public q(int paramInt) {
/*  41 */     a(new a(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public q(int paramInt1, int paramInt2) {
/*  52 */     a(new a(paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public q(int[] paramArrayOfint) {
/*  62 */     a(new a(paramArrayOfint));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a a() {
/*  71 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(a parama) {
/*  76 */     this.c = parama;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/*     */     String str;
/*  86 */     if ((str = b.get(a())) == null)
/*     */     {
/*  88 */       str = a.get(a());
/*     */     }
/*  90 */     if (str == null)
/*     */     {
/*  92 */       return a().toString() + '|';
/*     */     }
/*  94 */     return str + '|';
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 103 */     return a().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 112 */     if (paramObject instanceof q) {
/*     */       
/* 114 */       paramObject = paramObject;
/* 115 */       return a().equals(paramObject.a());
/*     */     } 
/* 117 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class a
/*     */   {
/* 126 */     private int[] a = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(int param1Int) {
/* 135 */       a(new int[] { param1Int });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(int param1Int1, int param1Int2) {
/* 146 */       a(new int[] { param1Int1, param1Int2 });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(int[] param1ArrayOfint) {
/* 156 */       a(param1ArrayOfint);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int[] a() {
/* 166 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     private void a(int[] param1ArrayOfint) {
/* 171 */       this.a = param1ArrayOfint;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 180 */       return Arrays.toString(a());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 189 */       if (this.a[0] == 12 && this.a.length > 1)
/*     */       {
/* 191 */         return this.a[0] ^ this.a[1];
/*     */       }
/* 193 */       return this.a[0];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 202 */       if (param1Object instanceof a) {
/*     */         
/* 204 */         param1Object = param1Object;
/* 205 */         if (this.a[0] == 12 && ((a)param1Object).a[0] == 12) {
/*     */           
/* 207 */           if (this.a.length > 1 && ((a)param1Object).a.length > 1)
/*     */           {
/* 209 */             return (this.a[1] == ((a)param1Object).a[1]);
/*     */           }
/* 211 */           return (this.a.length == ((a)param1Object).a.length);
/*     */         } 
/* 213 */         return (this.a[0] == ((a)param1Object).a[0]);
/*     */       } 
/* 215 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*     */     LinkedHashMap<Object, Object> linkedHashMap;
/* 227 */     (linkedHashMap = new LinkedHashMap<Object, Object>(26)).put(new a(1), "hstem");
/* 228 */     linkedHashMap.put(new a(3), "vstem");
/* 229 */     linkedHashMap.put(new a(4), "vmoveto");
/* 230 */     linkedHashMap.put(new a(5), "rlineto");
/* 231 */     linkedHashMap.put(new a(6), "hlineto");
/* 232 */     linkedHashMap.put(new a(7), "vlineto");
/* 233 */     linkedHashMap.put(new a(8), "rrcurveto");
/* 234 */     linkedHashMap.put(new a(9), "closepath");
/* 235 */     linkedHashMap.put(new a(10), "callsubr");
/* 236 */     linkedHashMap.put(new a(11), "return");
/* 237 */     linkedHashMap.put(new a(12), "escape");
/* 238 */     linkedHashMap.put(new a(12, 0), "dotsection");
/* 239 */     linkedHashMap.put(new a(12, 1), "vstem3");
/* 240 */     linkedHashMap.put(new a(12, 2), "hstem3");
/* 241 */     linkedHashMap.put(new a(12, 6), "seac");
/* 242 */     linkedHashMap.put(new a(12, 7), "sbw");
/* 243 */     linkedHashMap.put(new a(12, 12), "div");
/* 244 */     linkedHashMap.put(new a(12, 16), "callothersubr");
/* 245 */     linkedHashMap.put(new a(12, 17), "pop");
/* 246 */     linkedHashMap.put(new a(12, 33), "setcurrentpoint");
/* 247 */     linkedHashMap.put(new a(13), "hsbw");
/* 248 */     linkedHashMap.put(new a(14), "endchar");
/* 249 */     linkedHashMap.put(new a(21), "rmoveto");
/* 250 */     linkedHashMap.put(new a(22), "hmoveto");
/* 251 */     linkedHashMap.put(new a(30), "vhcurveto");
/* 252 */     linkedHashMap.put(new a(31), "hvcurveto");
/*     */     
/* 254 */     a = Collections.unmodifiableMap(linkedHashMap);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 265 */     (linkedHashMap = new LinkedHashMap<Object, Object>(48)).put(new a(1), "hstem");
/* 266 */     linkedHashMap.put(new a(3), "vstem");
/* 267 */     linkedHashMap.put(new a(4), "vmoveto");
/* 268 */     linkedHashMap.put(new a(5), "rlineto");
/* 269 */     linkedHashMap.put(new a(6), "hlineto");
/* 270 */     linkedHashMap.put(new a(7), "vlineto");
/* 271 */     linkedHashMap.put(new a(8), "rrcurveto");
/* 272 */     linkedHashMap.put(new a(10), "callsubr");
/* 273 */     linkedHashMap.put(new a(11), "return");
/* 274 */     linkedHashMap.put(new a(12), "escape");
/* 275 */     linkedHashMap.put(new a(12, 3), "and");
/* 276 */     linkedHashMap.put(new a(12, 4), "or");
/* 277 */     linkedHashMap.put(new a(12, 5), "not");
/* 278 */     linkedHashMap.put(new a(12, 9), "abs");
/* 279 */     linkedHashMap.put(new a(12, 10), "add");
/* 280 */     linkedHashMap.put(new a(12, 11), "sub");
/* 281 */     linkedHashMap.put(new a(12, 12), "div");
/* 282 */     linkedHashMap.put(new a(12, 14), "neg");
/* 283 */     linkedHashMap.put(new a(12, 15), "eq");
/* 284 */     linkedHashMap.put(new a(12, 18), "drop");
/* 285 */     linkedHashMap.put(new a(12, 20), "put");
/* 286 */     linkedHashMap.put(new a(12, 21), "get");
/* 287 */     linkedHashMap.put(new a(12, 22), "ifelse");
/* 288 */     linkedHashMap.put(new a(12, 23), "random");
/* 289 */     linkedHashMap.put(new a(12, 24), "mul");
/* 290 */     linkedHashMap.put(new a(12, 26), "sqrt");
/* 291 */     linkedHashMap.put(new a(12, 27), "dup");
/* 292 */     linkedHashMap.put(new a(12, 28), "exch");
/* 293 */     linkedHashMap.put(new a(12, 29), "index");
/* 294 */     linkedHashMap.put(new a(12, 30), "roll");
/* 295 */     linkedHashMap.put(new a(12, 34), "hflex");
/* 296 */     linkedHashMap.put(new a(12, 35), "flex");
/* 297 */     linkedHashMap.put(new a(12, 36), "hflex1");
/* 298 */     linkedHashMap.put(new a(12, 37), "flex1");
/* 299 */     linkedHashMap.put(new a(14), "endchar");
/* 300 */     linkedHashMap.put(new a(18), "hstemhm");
/* 301 */     linkedHashMap.put(new a(19), "hintmask");
/* 302 */     linkedHashMap.put(new a(20), "cntrmask");
/* 303 */     linkedHashMap.put(new a(21), "rmoveto");
/* 304 */     linkedHashMap.put(new a(22), "hmoveto");
/* 305 */     linkedHashMap.put(new a(23), "vstemhm");
/* 306 */     linkedHashMap.put(new a(24), "rcurveline");
/* 307 */     linkedHashMap.put(new a(25), "rlinecurve");
/* 308 */     linkedHashMap.put(new a(26), "vvcurveto");
/* 309 */     linkedHashMap.put(new a(27), "hhcurveto");
/* 310 */     linkedHashMap.put(new a(28), "shortint");
/* 311 */     linkedHashMap.put(new a(29), "callgsubr");
/* 312 */     linkedHashMap.put(new a(30), "vhcurveto");
/* 313 */     linkedHashMap.put(new a(31), "hvcurveto");
/*     */     
/* 315 */     b = Collections.unmodifiableMap(linkedHashMap);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\b\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */