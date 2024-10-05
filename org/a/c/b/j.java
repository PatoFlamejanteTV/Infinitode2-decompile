/*     */ package org.a.c.b;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.a.c.i.a;
/*     */ import org.a.c.i.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class j
/*     */   extends b
/*     */   implements Comparable<j>
/*     */ {
/*  36 */   private static Map<String, j> eh = new ConcurrentHashMap<String, j>(8192);
/*     */ 
/*     */ 
/*     */   
/*  40 */   private static Map<String, j> ei = new HashMap<String, j>(768);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   public static final j a = new j("A");
/*  48 */   public static final j b = new j("AA");
/*     */   
/*  50 */   public static final j c = new j("AcroForm");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   public static final j d = new j("AESV2");
/*  57 */   public static final j e = new j("AESV3");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   public static final j f = new j("Alt");
/*     */   
/*  64 */   public static final j g = new j("Alternate");
/*  65 */   public static final j h = new j("Annot");
/*  66 */   public static final j i = new j("Annots");
/*     */ 
/*     */ 
/*     */   
/*  70 */   public static final j j = new j("AP");
/*     */ 
/*     */ 
/*     */   
/*  74 */   public static final j k = new j("Artifact");
/*  75 */   public static final j l = new j("AS");
/*  76 */   public static final j m = new j("Ascent");
/*  77 */   public static final j n = new j("ASCIIHexDecode");
/*  78 */   public static final j o = new j("AHx");
/*  79 */   public static final j p = new j("ASCII85Decode");
/*  80 */   public static final j q = new j("A85");
/*     */   
/*  82 */   public static final j r = new j("Author");
/*  83 */   public static final j s = new j("AvgWidth");
/*     */ 
/*     */   
/*  86 */   public static final j t = new j("Background");
/*  87 */   public static final j u = new j("BaseEncoding");
/*  88 */   public static final j v = new j("BaseFont");
/*     */   
/*  90 */   public static final j w = new j("BBox");
/*  91 */   public static final j x = new j("BC");
/*     */ 
/*     */   
/*  94 */   public static final j y = new j("BG");
/*  95 */   public static final j z = new j("BitsPerComponent");
/*     */ 
/*     */   
/*  98 */   public static final j A = new j("BitsPerSample");
/*  99 */   public static final j B = new j("BlackIs1");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 104 */   public static final j C = new j("Bounds");
/* 105 */   public static final j D = new j("BPC");
/* 106 */   public static final j E = new j("BS");
/*     */   
/* 108 */   public static final j F = new j("Btn");
/* 109 */   public static final j G = new j("ByteRange");
/*     */ 
/*     */   
/* 112 */   public static final j H = new j("C0");
/* 113 */   public static final j I = new j("C1");
/* 114 */   public static final j J = new j("CA");
/*     */   
/* 116 */   public static final j K = new j("CalGray");
/* 117 */   public static final j L = new j("CalRGB");
/*     */   
/* 119 */   public static final j M = new j("CapHeight");
/* 120 */   public static final j N = new j("Catalog");
/* 121 */   public static final j O = new j("CCITTFaxDecode");
/* 122 */   public static final j P = new j("CCF");
/*     */ 
/*     */   
/* 125 */   public static final j Q = new j("CF");
/* 126 */   public static final j R = new j("CFM");
/*     */   
/* 128 */   public static final j S = new j("Ch");
/* 129 */   public static final j T = new j("CharProcs");
/* 130 */   public static final j U = new j("CharSet");
/*     */   
/* 132 */   public static final j V = new j("CIDFontType0");
/* 133 */   public static final j W = new j("CIDFontType2");
/* 134 */   public static final j X = new j("CIDToGIDMap");
/* 135 */   public static final j Y = new j("CIDSet");
/* 136 */   public static final j Z = new j("CIDSystemInfo");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 148 */   public static final j aa = new j("Colorants");
/* 149 */   public static final j ab = new j("Colors");
/* 150 */   public static final j ac = new j("ColorSpace");
/* 151 */   public static final j ad = new j("Columns");
/*     */   
/* 153 */   public static final j ae = new j("Components");
/*     */   
/* 155 */   public static final j af = new j("Contents");
/*     */   
/* 157 */   public static final j ag = new j("Count");
/*     */   
/* 159 */   public static final j ah = new j("CreationDate");
/* 160 */   public static final j ai = new j("Creator");
/* 161 */   public static final j aj = new j("CropBox");
/* 162 */   public static final j ak = new j("Crypt");
/* 163 */   public static final j al = new j("CS");
/*     */   
/* 165 */   public static final j am = new j("D");
/* 166 */   public static final j an = new j("DA");
/*     */ 
/*     */   
/* 169 */   public static final j ao = new j("DCTDecode");
/* 170 */   public static final j ap = new j("DCT");
/* 171 */   public static final j aq = new j("Decode");
/* 172 */   public static final j ar = new j("DecodeParms");
/*     */   
/* 174 */   public static final j as = new j("DefaultCMYK");
/* 175 */   public static final j at = new j("DefaultCryptFilter");
/* 176 */   public static final j au = new j("DefaultGray");
/* 177 */   public static final j av = new j("DefaultRGB");
/*     */   
/* 179 */   public static final j aw = new j("DescendantFonts");
/* 180 */   public static final j ax = new j("Descent");
/* 181 */   public static final j ay = new j("Dest");
/* 182 */   public static final j az = new j("DestOutputProfile");
/*     */   
/* 184 */   public static final j aA = new j("DeviceCMYK");
/* 185 */   public static final j aB = new j("DeviceGray");
/* 186 */   public static final j aC = new j("DeviceN");
/* 187 */   public static final j aD = new j("DeviceRGB");
/*     */ 
/*     */   
/* 190 */   public static final j aE = new j("Differences");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 198 */   public static final j aF = new j("DisplayDocTitle");
/*     */ 
/*     */ 
/*     */   
/* 202 */   public static final j aG = new j("DocChecksum");
/* 203 */   public static final j aH = new j("DocTimeStamp");
/*     */ 
/*     */   
/* 206 */   public static final j aI = new j("Domain");
/*     */   
/* 208 */   public static final j aJ = new j("DP");
/* 209 */   public static final j aK = new j("DR");
/*     */ 
/*     */ 
/*     */   
/* 213 */   public static final j aL = new j("DV");
/* 214 */   public static final j aM = new j("DW");
/* 215 */   public static final j aN = new j("DW2");
/*     */ 
/*     */   
/* 218 */   public static final j aO = new j("EarlyChange");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 223 */   public static final j aP = new j("Encode");
/* 224 */   public static final j aQ = new j("EncodedByteAlign");
/* 225 */   public static final j aR = new j("Encoding");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 230 */   public static final j aS = new j("Encrypt");
/* 231 */   public static final j aT = new j("EncryptMetadata");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 239 */   public static final j aU = new j("F");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 244 */   public static final j aV = new j("Ff");
/* 245 */   public static final j aW = new j("Fields");
/* 246 */   public static final j aX = new j("Filespec");
/* 247 */   public static final j aY = new j("Filter");
/* 248 */   public static final j aZ = new j("First");
/* 249 */   public static final j ba = new j("FirstChar");
/*     */ 
/*     */   
/* 252 */   public static final j bb = new j("Flags");
/* 253 */   public static final j bc = new j("FlateDecode");
/* 254 */   public static final j bd = new j("Fl");
/*     */   
/* 256 */   public static final j be = new j("Font");
/* 257 */   public static final j bf = new j("FontBBox");
/* 258 */   public static final j bg = new j("FontDescriptor");
/* 259 */   public static final j bh = new j("FontFamily");
/* 260 */   public static final j bi = new j("FontFile");
/* 261 */   public static final j bj = new j("FontFile2");
/* 262 */   public static final j bk = new j("FontFile3");
/* 263 */   public static final j bl = new j("FontMatrix");
/* 264 */   public static final j bm = new j("FontName");
/*     */   
/* 266 */   public static final j bn = new j("FontWeight");
/* 267 */   public static final j bo = new j("Form");
/* 268 */   public static final j bp = new j("FormType");
/*     */   
/* 270 */   public static final j bq = new j("FT");
/* 271 */   public static final j br = new j("Function");
/* 272 */   public static final j bs = new j("FunctionType");
/* 273 */   public static final j bt = new j("Functions");
/*     */ 
/*     */   
/* 276 */   public static final j bu = new j("Gamma");
/*     */   
/* 278 */   public static final j bv = new j("GTS_PDFA1");
/*     */   
/* 280 */   public static final j bw = new j("H");
/*     */   
/* 282 */   public static final j bx = new j("Height");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 289 */   public static final j by = new j("I");
/*     */   
/* 291 */   public static final j bz = new j("ICCBased");
/* 292 */   public static final j bA = new j("ID");
/*     */   
/* 294 */   public static final j bB = new j("Identity");
/* 295 */   public static final j bC = new j("Identity-H");
/* 296 */   public static final j bD = new j("Identity-V");
/*     */ 
/*     */   
/* 299 */   public static final j bE = new j("Image");
/* 300 */   public static final j bF = new j("ImageMask");
/* 301 */   public static final j bG = new j("Index");
/* 302 */   public static final j bH = new j("Indexed");
/* 303 */   public static final j bI = new j("Info");
/*     */   
/* 305 */   public static final j bJ = new j("Interpolate");
/*     */   
/* 307 */   public static final j bK = new j("ItalicAngle");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 312 */   public static final j bL = new j("JBIG2Decode");
/* 313 */   public static final j bM = new j("JBIG2Globals");
/* 314 */   public static final j bN = new j("JPXDecode");
/* 315 */   public static final j bO = new j("JS");
/*     */   
/* 317 */   public static final j bP = new j("K");
/* 318 */   public static final j bQ = new j("Keywords");
/*     */   
/* 320 */   public static final j bR = new j("Kids");
/*     */   
/* 322 */   public static final j bS = new j("L");
/* 323 */   public static final j bT = new j("Lab");
/* 324 */   public static final j bU = new j("Lang");
/* 325 */   public static final j bV = new j("Last");
/* 326 */   public static final j bW = new j("LastChar");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 332 */   public static final j bX = new j("Length");
/* 333 */   public static final j bY = new j("Length1");
/* 334 */   public static final j bZ = new j("Length2");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 344 */   public static final j ca = new j("LZWDecode");
/* 345 */   public static final j cb = new j("LZW");
/*     */ 
/*     */ 
/*     */   
/* 349 */   public static final j cc = new j("MacExpertEncoding");
/* 350 */   public static final j cd = new j("MacRomanEncoding");
/* 351 */   public static final j ce = new j("MarkInfo");
/*     */   
/* 353 */   public static final j cf = new j("Matrix");
/*     */   
/* 355 */   public static final j cg = new j("MaxLen");
/*     */   
/* 357 */   public static final j ch = new j("MCID");
/*     */   
/* 359 */   public static final j ci = new j("MediaBox");
/*     */   
/* 361 */   public static final j cj = new j("Metadata");
/* 362 */   public static final j ck = new j("MissingWidth");
/*     */   
/* 364 */   public static final j cl = new j("MK");
/*     */   
/* 366 */   public static final j cm = new j("MMType1");
/* 367 */   public static final j cn = new j("ModDate");
/*     */ 
/*     */   
/* 370 */   public static final j co = new j("N");
/* 371 */   public static final j cp = new j("Name");
/*     */ 
/*     */   
/* 374 */   public static final j cq = new j("NeedAppearances");
/*     */   
/* 376 */   public static final j cr = new j("Next");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 382 */   public static final j cs = new j("Nums");
/*     */   
/* 384 */   public static final j ct = new j("O");
/* 385 */   public static final j cu = new j("Obj");
/* 386 */   public static final j cv = new j("ObjStm");
/*     */   
/* 388 */   public static final j cw = new j("OCG");
/* 389 */   public static final j cx = new j("OCGs");
/* 390 */   public static final j cy = new j("OCMD");
/* 391 */   public static final j cz = new j("OCProperties");
/* 392 */   public static final j cA = new j("OE");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 403 */   public static final j cB = new j("Off");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 411 */   public static final j cC = new j("Opt");
/*     */   
/* 413 */   public static final j cD = new j("Ordering");
/*     */   
/* 415 */   public static final j cE = new j("Outlines");
/* 416 */   public static final j cF = new j("OutputCondition");
/* 417 */   public static final j cG = new j("OutputConditionIdentifier");
/*     */   
/* 419 */   public static final j cH = new j("OutputIntent");
/* 420 */   public static final j cI = new j("OutputIntents");
/*     */ 
/*     */   
/* 423 */   public static final j cJ = new j("P");
/* 424 */   public static final j cK = new j("Page");
/*     */ 
/*     */ 
/*     */   
/* 428 */   public static final j cL = new j("Pages");
/*     */   
/* 430 */   public static final j cM = new j("Panose");
/*     */   
/* 432 */   public static final j cN = new j("Parent");
/* 433 */   public static final j cO = new j("ParentTree");
/* 434 */   public static final j cP = new j("ParentTreeNextKey");
/*     */   
/* 436 */   public static final j cQ = new j("Pattern");
/*     */ 
/*     */   
/* 439 */   public static final j cR = new j("Perms");
/* 440 */   public static final j cS = new j("Pg");
/*     */   
/* 442 */   public static final j cT = new j("Predictor");
/* 443 */   public static final j cU = new j("Prev");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 448 */   public static final j cV = new j("Process");
/* 449 */   public static final j cW = new j("Producer");
/*     */   
/* 451 */   public static final j cX = new j("Properties");
/*     */ 
/*     */ 
/*     */   
/* 455 */   public static final j cY = new j("Q");
/* 456 */   public static final j cZ = new j("QuadPoints");
/*     */   
/* 458 */   public static final j da = new j("R");
/* 459 */   public static final j db = new j("Range");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 465 */   public static final j dc = new j("Recipients");
/* 466 */   public static final j dd = new j("Rect");
/* 467 */   public static final j de = new j("Registry");
/* 468 */   public static final j df = new j("RegistryName");
/*     */   
/* 470 */   public static final j dg = new j("Resources");
/*     */ 
/*     */   
/* 473 */   public static final j dh = new j("RoleMap");
/* 474 */   public static final j di = new j("Root");
/* 475 */   public static final j dj = new j("Rotate");
/* 476 */   public static final j dk = new j("Rows");
/* 477 */   public static final j dl = new j("RunLengthDecode");
/* 478 */   public static final j dm = new j("RL");
/*     */ 
/*     */   
/* 481 */   public static final j dn = new j("S");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 486 */   public static final j do = new j("SE");
/* 487 */   public static final j dp = new j("Separation");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 492 */   public static final j dq = new j("Sig");
/*     */   
/* 494 */   public static final j dr = new j("Size");
/*     */   
/* 496 */   public static final j ds = new j("SMask");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 503 */   public static final j dt = new j("StandardEncoding");
/*     */ 
/*     */ 
/*     */   
/* 507 */   public static final j du = new j("StdCF");
/*     */   
/* 509 */   public static final j dv = new j("StemV");
/* 510 */   public static final j dw = new j("StmF");
/* 511 */   public static final j dx = new j("StrF");
/*     */   
/* 513 */   public static final j dy = new j("StructParent");
/* 514 */   public static final j dz = new j("StructParents");
/* 515 */   public static final j dA = new j("StructTreeRoot");
/* 516 */   public static final j dB = new j("Style");
/* 517 */   public static final j dC = new j("SubFilter");
/*     */   
/* 519 */   public static final j dD = new j("Subject");
/*     */   
/* 521 */   public static final j dE = new j("Subtype");
/* 522 */   public static final j dF = new j("Supplement");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 529 */   public static final j dG = new j("T");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 534 */   public static final j dH = new j("TI");
/*     */ 
/*     */   
/* 537 */   public static final j dI = new j("Title");
/*     */ 
/*     */   
/* 540 */   public static final j dJ = new j("ToUnicode");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 548 */   public static final j dK = new j("TrueType");
/*     */   
/* 550 */   public static final j dL = new j("TU");
/*     */   
/* 552 */   public static final j dM = new j("Tx");
/* 553 */   public static final j dN = new j("Type");
/* 554 */   public static final j dO = new j("Type0");
/* 555 */   public static final j dP = new j("Type1");
/* 556 */   public static final j dQ = new j("Type3");
/*     */   
/* 558 */   public static final j dR = new j("U");
/* 559 */   public static final j dS = new j("UE");
/*     */ 
/*     */ 
/*     */   
/* 563 */   public static final j dT = new j("URI");
/*     */ 
/*     */ 
/*     */   
/* 567 */   public static final j dU = new j("V");
/*     */ 
/*     */   
/* 570 */   public static final j dV = new j("Version");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 576 */   public static final j dW = new j("ViewerPreferences");
/*     */ 
/*     */ 
/*     */   
/* 580 */   public static final j dX = new j("W");
/* 581 */   public static final j dY = new j("W2");
/* 582 */   public static final j dZ = new j("WhitePoint");
/*     */   
/* 584 */   public static final j ea = new j("Width");
/* 585 */   public static final j eb = new j("Widths");
/* 586 */   public static final j ec = new j("WinAnsiEncoding");
/*     */ 
/*     */ 
/*     */   
/* 590 */   public static final j ed = new j("XHeight");
/* 591 */   public static final j ee = new j("XObject");
/* 592 */   public static final j ef = new j("XRef");
/* 593 */   public static final j eg = new j("XRefStm");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String ej;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int ek;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static j a(String paramString) {
/* 614 */     j j1 = null;
/* 615 */     if (paramString != null)
/*     */     {
/*     */ 
/*     */       
/* 619 */       if ((j1 = ei.get(paramString)) == null)
/*     */       {
/*     */ 
/*     */         
/* 623 */         if ((j1 = eh.get(paramString)) == null)
/*     */         {
/*     */           
/* 626 */           j1 = new j(paramString, false);
/*     */         }
/*     */       }
/*     */     }
/* 630 */     return j1;
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
/*     */   private j(String paramString, boolean paramBoolean) {
/* 642 */     this.ej = paramString;
/* 643 */     if (paramBoolean) {
/*     */       
/* 645 */       ei.put(paramString, this);
/*     */     }
/*     */     else {
/*     */       
/* 649 */       eh.put(paramString, this);
/*     */     } 
/* 651 */     this.ek = this.ej.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j(String paramString) {
/* 661 */     this(paramString, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/* 671 */     return this.ej;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 677 */     return "COSName{" + this.ej + "}";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 683 */     return (paramObject instanceof j && this.ej.equals(((j)paramObject).ej));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 689 */     return this.ek;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(j paramj) {
/* 695 */     return this.ej.compareTo(paramj.ej);
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
/*     */   public final Object a(u paramu) {
/* 710 */     return paramu.a(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(OutputStream paramOutputStream) {
/* 721 */     paramOutputStream.write(47); byte[] arrayOfByte; int i;
/*     */     byte b1;
/* 723 */     for (i = (arrayOfByte = arrayOfByte = a().getBytes(a.f)).length, b1 = 0; b1 < i; ) {
/*     */       byte b2;
/*     */       
/*     */       int k;
/*     */       
/* 728 */       if (((k = (b2 = arrayOfByte[b1]) & 0xFF) >= 65 && k <= 90) || (k >= 97 && k <= 122) || (k >= 48 && k <= 57) || k == 43 || k == 45 || k == 95 || k == 64 || k == 42 || k == 36 || k == 59 || k == 46) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 740 */         paramOutputStream.write(k);
/*     */       }
/*     */       else {
/*     */         
/* 744 */         paramOutputStream.write(35);
/* 745 */         c.a(b2, paramOutputStream);
/*     */       } 
/*     */       b1++;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */