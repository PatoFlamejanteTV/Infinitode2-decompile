/*     */ package com.d.c.a;
/*     */ 
/*     */ import com.d.c.d.g;
/*     */ import com.d.c.f.d;
/*     */ import com.d.c.f.g;
/*     */ import com.d.h.w;
/*     */ import java.util.HashMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class c
/*     */   implements g
/*     */ {
/*  56 */   private static int ca = 0;
/*     */ 
/*     */   
/*     */   private final String cb;
/*     */ 
/*     */   
/*     */   public final int a;
/*     */ 
/*     */   
/*  65 */   public static final c b = c("absolute");
/*  66 */   public static final c c = c("always");
/*  67 */   public static final c d = c("armenian");
/*  68 */   public static final c e = c("auto");
/*  69 */   public static final c f = c("avoid");
/*  70 */   public static final c g = c("baseline"); static {
/*  71 */     c("blink");
/*  72 */   } public static final c h = c("block");
/*  73 */   public static final c i = c("bold");
/*  74 */   public static final c j = c("bolder");
/*  75 */   public static final c k = c("both");
/*  76 */   public static final c l = c("bottom");
/*  77 */   public static final c m = c("capitalize");
/*  78 */   public static final c n = c("center");
/*  79 */   public static final c o = c("circle"); static {
/*  80 */     c("cjk-ideographic");
/*  81 */   } public static final c p = c("close-quote");
/*  82 */   public static final c q = c("collapse"); static {
/*  83 */     c("compact");
/*  84 */   } public static final c r = c("contain");
/*  85 */   public static final c s = c("cover");
/*  86 */   public static final c t = c("create");
/*  87 */   public static final c u = c("dashed");
/*  88 */   public static final c v = c("decimal");
/*  89 */   public static final c w = c("decimal-leading-zero");
/*  90 */   public static final c x = c("disc");
/*  91 */   public static final c y = c("dotted");
/*  92 */   public static final c z = c("double");
/*  93 */   public static final c A = c("dynamic");
/*  94 */   public static final c B = c("fixed");
/*  95 */   public static final c C = c("100");
/*  96 */   public static final c D = c("200");
/*  97 */   public static final c E = c("300");
/*  98 */   public static final c F = c("400");
/*  99 */   public static final c G = c("500");
/* 100 */   public static final c H = c("600");
/* 101 */   public static final c I = c("700");
/* 102 */   public static final c J = c("800");
/* 103 */   public static final c K = c("900"); static {
/* 104 */     c("-fs-content-placeholder");
/* 105 */   } public static final c L = c("-fs-initial-value");
/* 106 */   public static final c M = c("-fs-table-paginate-repeated-visible");
/* 107 */   public static final c N = c("georgian");
/* 108 */   public static final c O = c("groove"); static {
/* 109 */     c("hebrew");
/* 110 */   } public static final c P = c("hidden");
/* 111 */   public static final c Q = c("hide"); static {
/* 112 */     c("hiragana");
/* 113 */     c("hiragana-iroha");
/* 114 */     c("inherit");
/* 115 */   } public static final c R = c("inline");
/* 116 */   public static final c S = c("inline-block");
/* 117 */   public static final c T = c("inline-table");
/* 118 */   public static final c U = c("inset");
/* 119 */   public static final c V = c("inside");
/* 120 */   public static final c W = c("italic");
/* 121 */   public static final c X = c("justify"); static {
/* 122 */     c("katakana");
/* 123 */     c("katakana-iroha");
/* 124 */   } public static final c Y = c("keep");
/* 125 */   public static final c Z = c("landscape");
/* 126 */   public static final c aa = c("left");
/* 127 */   public static final c ab = c("lighter");
/* 128 */   public static final c ac = c("line");
/* 129 */   public static final c ad = c("line-through");
/* 130 */   public static final c ae = c("list-item");
/* 131 */   public static final c af = c("lower-alpha");
/* 132 */   public static final c ag = c("lower-greek");
/* 133 */   public static final c ah = c("lower-latin");
/* 134 */   public static final c ai = c("lower-roman");
/* 135 */   public static final c aj = c("lowercase");
/* 136 */   public static final c ak = c("ltr"); static {
/* 137 */     c("marker");
/* 138 */   } public static final c al = c("middle");
/* 139 */   public static final c am = c("no-close-quote");
/* 140 */   public static final c an = c("no-open-quote");
/* 141 */   public static final c ao = c("no-repeat");
/* 142 */   public static final c ap = c("none");
/* 143 */   public static final c aq = c("normal");
/* 144 */   public static final c ar = c("nowrap");
/* 145 */   public static final c as = c("break-word");
/* 146 */   public static final c at = c("oblique");
/* 147 */   public static final c au = c("open-quote");
/* 148 */   public static final c av = c("outset");
/* 149 */   public static final c aw = c("outside");
/* 150 */   public static final c ax = c("overline");
/* 151 */   public static final c ay = c("paginate");
/* 152 */   public static final c az = c("pointer");
/* 153 */   public static final c aA = c("portrait");
/* 154 */   public static final c aB = c("pre");
/* 155 */   public static final c aC = c("pre-line");
/* 156 */   public static final c aD = c("pre-wrap");
/* 157 */   public static final c aE = c("relative");
/* 158 */   public static final c aF = c("repeat");
/* 159 */   public static final c aG = c("repeat-x");
/* 160 */   public static final c aH = c("repeat-y");
/* 161 */   public static final c aI = c("ridge");
/* 162 */   public static final c aJ = c("right");
/* 163 */   public static final c aK = c("rtl");
/* 164 */   public static final c aL = c("run-in");
/* 165 */   public static final c aM = c("scroll");
/* 166 */   public static final c aN = c("separate");
/* 167 */   public static final c aO = c("show");
/* 168 */   public static final c aP = c("small-caps");
/* 169 */   public static final c aQ = c("solid");
/* 170 */   public static final c aR = c("square");
/* 171 */   public static final c aS = c("static");
/* 172 */   public static final c aT = c("sub");
/* 173 */   public static final c aU = c("super");
/* 174 */   public static final c aV = c("table");
/* 175 */   public static final c aW = c("table-caption");
/* 176 */   public static final c aX = c("table-cell");
/* 177 */   public static final c aY = c("table-column");
/* 178 */   public static final c aZ = c("table-column-group");
/* 179 */   public static final c ba = c("table-footer-group");
/* 180 */   public static final c bb = c("table-header-group");
/* 181 */   public static final c bc = c("table-row");
/* 182 */   public static final c bd = c("table-row-group");
/* 183 */   public static final c be = c("text-bottom");
/* 184 */   public static final c bf = c("text-top");
/* 185 */   public static final c bg = c("thick");
/* 186 */   public static final c bh = c("thin");
/* 187 */   public static final c bi = c("top");
/* 188 */   public static final c bj = c("transparent");
/* 189 */   public static final c bk = c("underline");
/* 190 */   public static final c bl = c("upper-alpha");
/* 191 */   public static final c bm = c("upper-latin");
/* 192 */   public static final c bn = c("upper-roman");
/* 193 */   public static final c bo = c("uppercase");
/* 194 */   public static final c bp = c("visible");
/* 195 */   public static final c bq = c("crosshair");
/* 196 */   public static final c br = c("default");
/* 197 */   public static final c bs = c("embed");
/* 198 */   public static final c bt = c("e-resize");
/* 199 */   public static final c bu = c("help");
/* 200 */   public static final c bv = c("large");
/* 201 */   public static final c bw = c("larger");
/* 202 */   public static final c bx = c("medium");
/* 203 */   public static final c by = c("move");
/* 204 */   public static final c bz = c("n-resize");
/* 205 */   public static final c bA = c("ne-resize");
/* 206 */   public static final c bB = c("nw-resize");
/* 207 */   public static final c bC = c("progress");
/* 208 */   public static final c bD = c("s-resize");
/* 209 */   public static final c bE = c("se-resize");
/* 210 */   public static final c bF = c("small");
/* 211 */   public static final c bG = c("smaller");
/* 212 */   public static final c bH = c("start");
/* 213 */   public static final c bI = c("sw-resize");
/* 214 */   public static final c bJ = c("text");
/* 215 */   public static final c bK = c("w-resize");
/* 216 */   public static final c bL = c("wait");
/* 217 */   public static final c bM = c("x-large");
/* 218 */   public static final c bN = c("x-small");
/* 219 */   public static final c bO = c("xx-large");
/* 220 */   public static final c bP = c("xx-small");
/*     */   
/* 222 */   public static final c bQ = c("complete-font");
/* 223 */   public static final c bR = c("subset");
/*     */   
/* 225 */   public static final c bS = c("diamond");
/* 226 */   public static final c bT = c("star");
/* 227 */   public static final c bU = c("check");
/* 228 */   public static final c bV = c("cross");
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 233 */     c("matrix");
/* 234 */     c("translate");
/* 235 */     c("translateX");
/* 236 */     c("translateY");
/* 237 */     c("scale");
/* 238 */     c("scaleX");
/* 239 */     c("scaleY");
/* 240 */     c("rotate");
/* 241 */     c("skew");
/* 242 */     c("skewX");
/* 243 */     c("skewY");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 248 */   public static final c bW = c("pixelated");
/* 249 */   public static final c bX = c("crisp-edges");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 254 */   public static final c bY = c("border-box");
/* 255 */   public static final c bZ = c("content-box");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<String, c> cc;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private c(String paramString) {
/* 269 */     this.cb = paramString;
/* 270 */     this.a = ca++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 280 */     return this.cb;
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
/*     */   public static c a(String paramString) {
/*     */     c c1;
/* 294 */     if ((c1 = cc.get(paramString)) == null) {
/* 295 */       throw new w.a("Ident named " + paramString + " has no IdentValue instance assigned to it.");
/*     */     }
/* 297 */     return c1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static c b(String paramString) {
/* 308 */     return cc.get(paramString);
/*     */   }
/*     */   
/*     */   public static int a() {
/* 312 */     return cc.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final synchronized c c(String paramString) {
/* 322 */     if (cc == null) {
/* 323 */       cc = new HashMap<>();
/*     */     }
/* 325 */     c c1 = new c(paramString);
/* 326 */     cc.put(paramString, c1);
/* 327 */     return c1;
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
/*     */   public final float b() {
/* 344 */     throw new w.a("Ident value is never a float; wrong class used for derived value.");
/*     */   }
/*     */   
/*     */   public final g c() {
/* 348 */     throw new w.a("Ident value is never a color; wrong class used for derived value.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float a(a parama, float paramFloat, d paramd) {
/* 354 */     throw new w.a("Ident value (" + toString() + ") is never a length; wrong class used for derived value.");
/*     */   }
/*     */   
/*     */   public final String d() {
/* 358 */     return toString();
/*     */   }
/*     */   
/*     */   public final String[] e() {
/* 362 */     throw new w.a("Ident value is never a string array; wrong class used for derived value.");
/*     */   }
/*     */   
/*     */   public final c f() {
/* 366 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean g() {
/* 371 */     throw new w.a("Ident value is never an absolute unit; wrong class used for derived value; this ident value is a " + 
/* 372 */         d());
/*     */   }
/*     */   
/*     */   public final boolean h() {
/* 376 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */