/*     */ package org.a.b.b;
/*     */ 
/*     */ import java.util.Arrays;
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
/*     */ public final class k
/*     */ {
/*  30 */   private a a = null;
/*  31 */   private String b = null;
/*     */ 
/*     */   
/*     */   private k(a parama, String paramString) {
/*  35 */     b(parama);
/*  36 */     a(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a b() {
/*  45 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(a parama) {
/*  50 */     this.a = parama;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/*  59 */     return this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(String paramString) {
/*  64 */     this.b = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/*  73 */     return a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/*  82 */     return b().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/*  91 */     if (paramObject instanceof k) {
/*     */       
/*  93 */       paramObject = paramObject;
/*  94 */       return b().equals(paramObject.b());
/*     */     } 
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void a(a parama, String paramString) {
/* 101 */     k k1 = new k(parama, paramString);
/* 102 */     c.put(parama, k1);
/* 103 */     d.put(paramString, k1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static k a(a parama) {
/* 113 */     return c.get(parama);
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
/*     */   public static class a
/*     */   {
/* 132 */     private int[] a = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(int param1Int) {
/* 140 */       this(new int[] { param1Int });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(int param1Int1, int param1Int2) {
/* 150 */       this(new int[] { param1Int1, param1Int2 });
/*     */     }
/*     */ 
/*     */     
/*     */     private a(int[] param1ArrayOfint) {
/* 155 */       a(param1ArrayOfint);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int[] a() {
/* 164 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     private void a(int[] param1ArrayOfint) {
/* 169 */       this.a = param1ArrayOfint;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 178 */       return Arrays.toString(a());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 187 */       return Arrays.hashCode(a());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 196 */       if (param1Object instanceof a) {
/*     */         
/* 198 */         param1Object = param1Object;
/* 199 */         return Arrays.equals(a(), param1Object.a());
/*     */       } 
/* 201 */       return false;
/*     */     }
/*     */   }
/*     */   
/* 205 */   private static Map<a, k> c = new LinkedHashMap<a, k>(52);
/* 206 */   private static Map<String, k> d = new LinkedHashMap<String, k>(52);
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 211 */     a(new a(0), "version");
/* 212 */     a(new a(1), "Notice");
/* 213 */     a(new a(12, 0), "Copyright");
/* 214 */     a(new a(2), "FullName");
/* 215 */     a(new a(3), "FamilyName");
/* 216 */     a(new a(4), "Weight");
/* 217 */     a(new a(12, 1), "isFixedPitch");
/* 218 */     a(new a(12, 2), "ItalicAngle");
/* 219 */     a(new a(12, 3), "UnderlinePosition");
/* 220 */     a(new a(12, 4), "UnderlineThickness");
/* 221 */     a(new a(12, 5), "PaintType");
/* 222 */     a(new a(12, 6), "CharstringType");
/* 223 */     a(new a(12, 7), "FontMatrix");
/* 224 */     a(new a(13), "UniqueID");
/* 225 */     a(new a(5), "FontBBox");
/* 226 */     a(new a(12, 8), "StrokeWidth");
/* 227 */     a(new a(14), "XUID");
/* 228 */     a(new a(15), "charset");
/* 229 */     a(new a(16), "Encoding");
/* 230 */     a(new a(17), "CharStrings");
/* 231 */     a(new a(18), "Private");
/* 232 */     a(new a(12, 20), "SyntheticBase");
/* 233 */     a(new a(12, 21), "PostScript");
/* 234 */     a(new a(12, 22), "BaseFontName");
/* 235 */     a(new a(12, 23), "BaseFontBlend");
/* 236 */     a(new a(12, 30), "ROS");
/* 237 */     a(new a(12, 31), "CIDFontVersion");
/* 238 */     a(new a(12, 32), "CIDFontRevision");
/* 239 */     a(new a(12, 33), "CIDFontType");
/* 240 */     a(new a(12, 34), "CIDCount");
/* 241 */     a(new a(12, 35), "UIDBase");
/* 242 */     a(new a(12, 36), "FDArray");
/* 243 */     a(new a(12, 37), "FDSelect");
/* 244 */     a(new a(12, 38), "FontName");
/*     */ 
/*     */     
/* 247 */     a(new a(6), "BlueValues");
/* 248 */     a(new a(7), "OtherBlues");
/* 249 */     a(new a(8), "FamilyBlues");
/* 250 */     a(new a(9), "FamilyOtherBlues");
/* 251 */     a(new a(12, 9), "BlueScale");
/* 252 */     a(new a(12, 10), "BlueShift");
/* 253 */     a(new a(12, 11), "BlueFuzz");
/* 254 */     a(new a(10), "StdHW");
/* 255 */     a(new a(11), "StdVW");
/* 256 */     a(new a(12, 12), "StemSnapH");
/* 257 */     a(new a(12, 13), "StemSnapV");
/* 258 */     a(new a(12, 14), "ForceBold");
/* 259 */     a(new a(12, 15), "LanguageGroup");
/* 260 */     a(new a(12, 16), "ExpansionFactor");
/* 261 */     a(new a(12, 17), "initialRandomSeed");
/* 262 */     a(new a(19), "Subrs");
/* 263 */     a(new a(20), "defaultWidthX");
/* 264 */     a(new a(21), "nominalWidthX");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */