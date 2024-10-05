/*     */ package com.d.c.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  78 */   public static final k a = new k(1, "S", "whitespace");
/*  79 */   public static final k b = new k(2, "CDO", "<!--");
/*  80 */   public static final k c = new k(3, "CDC", "-->");
/*  81 */   public static final k d = new k(4, "INCLUDES", "an attribute word match");
/*  82 */   public static final k e = new k(5, "DASHMATCH", "an attribute hyphen match");
/*  83 */   public static final k f = new k(6, "PREFIXMATCH", "an attribute prefix match");
/*  84 */   public static final k g = new k(7, "SUFFIXMATCH", "an attribute suffix match");
/*  85 */   public static final k h = new k(8, "SUBSTRINGMATCH", "an attribute substring match");
/*  86 */   public static final k i = new k(9, "LBRACE", "a {");
/*  87 */   public static final k j = new k(10, "PLUS", "a +");
/*  88 */   public static final k k = new k(11, "GREATER", "a >");
/*  89 */   public static final k l = new k(12, "COMMA", "a comma");
/*  90 */   public static final k m = new k(13, "STRING", "a string");
/*  91 */   public static final k n = new k(14, "INVALID", "an unclosed string");
/*  92 */   public static final k o = new k(15, "IDENT", "an identifier");
/*  93 */   public static final k p = new k(16, "HASH", "a hex color");
/*  94 */   public static final k q = new k(17, "IMPORT_SYM", "@import");
/*  95 */   public static final k r = new k(18, "PAGE_SYM", "@page");
/*  96 */   public static final k s = new k(19, "MEDIA_SYM", "@media");
/*  97 */   public static final k t = new k(20, "CHARSET_SYM", "@charset");
/*  98 */   public static final k u = new k(21, "NAMESPACE_SYM", "@namespace,");
/*  99 */   public static final k v = new k(22, "FONT_FACE_SYM", "@font-face");
/* 100 */   public static final k w = new k(23, "AT_RULE", "at rule");
/* 101 */   public static final k x = new k(24, "IMPORTANT_SYM", "!important");
/* 102 */   public static final k y = new k(25, "EMS", "an em value");
/* 103 */   public static final k z = new k(26, "EXS", "an ex value");
/* 104 */   public static final k A = new k(27, "PX", "a pixel value");
/* 105 */   public static final k B = new k(28, "CM", "a centimeter value");
/* 106 */   public static final k C = new k(29, "MM", "a millimeter value");
/* 107 */   public static final k D = new k(30, "IN", "an inch value");
/* 108 */   public static final k E = new k(31, "PT", "a point value");
/* 109 */   public static final k F = new k(32, "PC", "a pica value");
/* 110 */   public static final k G = new k(33, "ANGLE", "an angle value");
/* 111 */   public static final k H = new k(34, "TIME", "a time value");
/* 112 */   public static final k I = new k(35, "FREQ", "a freq value");
/* 113 */   public static final k J = new k(36, "DIMENSION", "a dimension");
/* 114 */   public static final k K = new k(37, "PERCENTAGE", "a percentage");
/* 115 */   public static final k L = new k(38, "NUMBER", "a number");
/* 116 */   public static final k M = new k(39, "URI", "a URI");
/* 117 */   public static final k N = new k(40, "FUNCTION", "function");
/*     */   
/* 119 */   public static final k O = new k(42, "RBRACE", "}");
/* 120 */   public static final k P = new k(43, "SEMICOLON", ";");
/* 121 */   public static final k Q = new k(44, "VIRGULE", "/");
/* 122 */   public static final k R = new k(45, "COLON", ":");
/* 123 */   public static final k S = new k(46, "MINUS", "-");
/* 124 */   public static final k T = new k(47, "RPAREN", ")");
/* 125 */   public static final k U = new k(48, "LBRACKET", "[");
/* 126 */   public static final k V = new k(49, "RBRACKET", "]");
/* 127 */   public static final k W = new k(50, "PERIOD", ".");
/* 128 */   public static final k X = new k(51, "EQUALS", "=");
/* 129 */   public static final k Y = new k(52, "ASTERISK", "*");
/* 130 */   public static final k Z = new k(53, "VERTICAL_BAR", "|");
/* 131 */   public static final k aa = new k(54, "EOF", "end of file");
/*     */   
/*     */   private final int ab;
/*     */   
/*     */   private final String ac;
/*     */   private final String ad;
/*     */   
/*     */   private k(int paramInt, String paramString1, String paramString2) {
/* 139 */     this.ab = paramInt;
/* 140 */     this.ac = paramString1;
/* 141 */     this.ad = paramString2;
/*     */   }
/*     */   
/*     */   public final int a() {
/* 145 */     return this.ab;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String b() {
/* 153 */     return this.ad;
/*     */   }
/*     */   
/*     */   public final String toString() {
/* 157 */     return this.ac;
/*     */   }
/*     */   
/*     */   public static k a(String paramString) {
/* 161 */     return new k(41, "OTHER", paramString + " (other)");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */