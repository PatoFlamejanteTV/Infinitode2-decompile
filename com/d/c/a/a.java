/*      */ package com.d.c.a;
/*      */ 
/*      */ import com.d.c.d.a.b;
/*      */ import com.d.c.d.a.c;
/*      */ import com.d.c.d.a.d;
/*      */ import com.d.c.d.a.e;
/*      */ import com.d.c.d.a.g;
/*      */ import com.d.c.d.a.h;
/*      */ import com.d.c.d.a.i;
/*      */ import com.d.c.d.a.j;
/*      */ import com.d.c.d.a.l;
/*      */ import com.d.c.d.a.m;
/*      */ import com.d.c.d.a.n;
/*      */ import com.d.c.d.a.o;
/*      */ import com.d.c.d.c;
/*      */ import com.d.c.d.j;
/*      */ import com.d.c.f.g;
/*      */ import com.d.m.l;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.TreeMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class a
/*      */   implements Comparable
/*      */ {
/*   62 */   private static final Integer bm = Integer.valueOf(0);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   67 */   private static final Integer bn = Integer.valueOf(1);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   72 */   private static final Integer bo = Integer.valueOf(2);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   77 */   private static final Integer bp = Integer.valueOf(3);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int bq;
/*      */ 
/*      */ 
/*      */   
/*      */   private final String br;
/*      */ 
/*      */ 
/*      */   
/*      */   private final String bs;
/*      */ 
/*      */ 
/*      */   
/*      */   private final boolean bt;
/*      */ 
/*      */ 
/*      */   
/*      */   private g bu;
/*      */ 
/*      */ 
/*      */   
/*      */   private final boolean bv;
/*      */ 
/*      */ 
/*      */   
/*      */   private final m bw;
/*      */ 
/*      */ 
/*      */   
/*      */   public final int a;
/*      */ 
/*      */ 
/*      */   
/*      */   private static final a[] bx;
/*      */ 
/*      */ 
/*      */   
/*  118 */   private static final Map by = new TreeMap<>();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  123 */   private static final Map bz = new TreeMap<>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  130 */   public static final a b = a("color", bm, "black", bo, (m)new l.ab());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  142 */   public static final a c = a("background-color", bm, "transparent", bp, (m)new l.b());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  154 */   public static final a d = a("background-image", bm, "none", bp, (m)new l.c());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  166 */   public static final a e = a("background-repeat", bm, "repeat", bp, (m)new l.e());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  178 */   public static final a f = a("background-attachment", bm, "scroll", bp, (m)new l.a());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  190 */   public static final a g = a("background-position", bm, "0% 0%", bp, (m)new l.d());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  199 */   public static final a h = a("background-size", bm, "auto auto", bp, (m)new l.f());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  211 */   public static final a i = a("border-collapse", bm, "separate", bo, (m)new l.l());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  223 */   public static final a j = a("-fs-border-spacing-horizontal", bm, "0", bp, (m)new l.ai());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  235 */   public static final a k = a("-fs-border-spacing-vertical", bm, "0", bp, (m)new l.aj());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  247 */   public static final a l = a("-fs-dynamic-auto-width", bm, "static", bp, (m)new l.al());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  259 */   public static final a m = a("-fs-font-subset", bm, "subset", bp, (m)new l.an());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  268 */   public static final a n = a("-fs-checkbox-style", bm, "check", bp, (m)new l.ak());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  280 */   public static final a o = a("-fs-keep-with-inline", bm, "auto", bp, (m)new l.ao());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  292 */   public static final a p = a("-fs-page-width", bm, "auto", bp, (m)new l.ay());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  304 */   public static final a q = a("-fs-page-height", bm, "auto", bp, (m)new l.av());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  316 */   public static final a r = a("-fs-page-sequence", bm, "auto", bp, (m)new l.ax());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*  328 */     a("-fs-pdf-font-embed", bm, "auto", bp, (m)new l.as());
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
/*  340 */   public static final a s = a("-fs-pdf-font-encoding", bm, "Cp1252", bp, (m)new l.at());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  352 */   public static final a t = a("-fs-page-orientation", bm, "auto", bp, (m)new l.aw());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  364 */   public static final a u = a("-fs-table-paginate", bm, "auto", bp, (m)new l.bb());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  376 */   public static final a v = a("-fs-text-decoration-extent", bm, "line", bp, (m)new l.bc());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*  388 */     a("-fs-fit-images-to-width", bm, "auto", bp, (m)new l.am());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  400 */     a("-fs-named-destination", bm, "none", bp, (m)new l.aq());
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
/*  413 */   public static final a w = a("-fs-page-break-min-height", bm, "0", bo, (m)new l.au());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  425 */   public static final a x = a("bottom", bm, "auto", bp, (m)new l.w());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  437 */   public static final a y = a("caption-side", bm, "top", bo, (m)new l.y());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  449 */   public static final a z = a("clear", bm, "none", bp, (m)new l.z());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*  461 */     a("clip", bm, "auto", bp, false, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  471 */   public static final a A = a("column-count", bm, "auto", bp, (m)new l.ac());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  480 */   public static final a B = a("column-gap", bm, "normal", bp, (m)new l.ad());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  492 */   public static final a C = a("content", bm, "normal", bp, (m)new e());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  504 */   public static final a D = a("counter-increment", bm, "none", bp, true, (m)new g.a());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  517 */   public static final a E = a("counter-reset", bm, "none", bp, true, (m)new g.b());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*  530 */     a("cursor", bm, "auto", bo, true, (m)new l.ae());
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
/*  543 */   public static final a F = a("direction", bm, "ltr", bo, true, (m)new l.af());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  556 */   public static final a G = a("display", bm, "inline", bp, (m)new l.ag());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  568 */   public static final a H = a("empty-cells", bm, "show", bo, (m)new l.ah());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  580 */   public static final a I = a("float", bm, "none", bp, (m)new l.bd());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  592 */   public static final a J = a("font-style", bm, "normal", bo, (m)new l.bg());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  604 */   public static final a K = a("font-variant", bm, "normal", bo, (m)new l.bh());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  616 */   public static final a L = a("font-weight", bm, "normal", bo, (m)new l.bi());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  628 */   public static final a M = a("font-size", bm, "medium", bo, (m)new l.bf());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  640 */   public static final a N = a("line-height", bm, "normal", bo, (m)new l.bz());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  653 */   public static final a O = a("font-family", bm, "serif", bo, (m)new l.be());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  665 */   public static final a P = a("-fs-table-cell-colspan", bm, "1", bp, (m)new l.az());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  677 */   public static final a Q = a("-fs-table-cell-rowspan", bm, "1", bp, (m)new l.ba());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  689 */   public static final a R = a("height", bm, "auto", bp, (m)new l.bo());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  701 */   public static final a S = a("left", bm, "auto", bp, (m)new l.bq());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  713 */   public static final a T = a("letter-spacing", bm, "normal", bo, true, (m)new l.by());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  726 */   public static final a U = a("list-style-type", bm, "disc", bo, (m)new l.cc());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  738 */   public static final a V = a("list-style-position", bm, "outside", bo, (m)new l.cb());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  750 */   public static final a W = a("list-style-image", bm, "none", bo, (m)new l.ca());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  762 */   public static final a X = a("max-height", bm, "none", bp, (m)new l.ch());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  774 */   public static final a Y = a("max-width", bm, "none", bp, (m)new l.ci());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  786 */   public static final a Z = a("min-height", bm, "0", bp, (m)new l.cj());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  799 */   public static final a aa = a("min-width", bm, "0", bp, (m)new l.ck());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  811 */   public static final a ab = a("orphans", bm, "2", bo, true, (m)new l.cm());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*  824 */     a("outline-color", bm, "black", bp, false, null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  837 */     a("outline-style", bm, "none", bp, false, null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  850 */     a("outline-width", bm, "medium", bp, false, null);
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
/*  863 */   public static final a ac = a("overflow", bm, "visible", bp, (m)new l.cn());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  875 */   public static final a ad = a("page", bm, "auto", bo, (m)new l.cs());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  887 */   public static final a ae = a("page-break-after", bm, "auto", bp, (m)new l.ct());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  899 */   public static final a af = a("page-break-before", bm, "auto", bp, (m)new l.cu());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  911 */   public static final a ag = a("page-break-inside", bm, "auto", bo, (m)new l.cv());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  923 */   public static final a ah = a("position", bm, "static", bp, (m)new l.cx());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  936 */   public static final a ai = a("quotes", bm, "none", bo, (m)new n());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  948 */   public static final a aj = a("right", bm, "auto", bp, (m)new l.cy());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  960 */   public static final a ak = a("src", bm, "none", bp, (m)new l.da());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  972 */   public static final a al = a("tab-size", bm, "8", bo, (m)new l.db());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  984 */   public static final a am = a("table-layout", bm, "auto", bp, (m)new l.dc());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  997 */   public static final a an = a("text-align", bm, "start", bo, (m)new l.dd());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1009 */   public static final a ao = a("text-decoration", bm, "none", bp, (m)new l.de());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1021 */   public static final a ap = a("text-indent", bm, "0", bo, (m)new l.df());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1033 */   public static final a aq = a("text-transform", bm, "none", bo, (m)new l.dg());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1045 */   public static final a ar = a("top", bm, "auto", bp, (m)new l.dh());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 1057 */     a("unicode-bidi", bm, "normal", bp, false, null);
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
/* 1070 */   public static final a as = a("vertical-align", bm, "baseline", bp, (m)new l.dm());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1082 */   public static final a at = a("visibility", bm, "visible", bo, (m)new l.dn());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1094 */   public static final a au = a("white-space", bm, "normal", bo, (m)new l.do());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1106 */   public static final a av = a("word-wrap", bm, "normal", bo, (m)new l.ds());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1118 */   public static final a aw = a("widows", bm, "2", bo, true, (m)new l.dp());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1131 */   public static final a ax = a("width", bm, "auto", bp, (m)new l.dq());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1143 */   public static final a ay = a("transform", bm, "none", bp, (m)new l.dl());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1152 */   public static final a az = a("-fs-transform-origin-x", bm, "50%", bp, (m)new l.dj());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1161 */   public static final a aA = a("-fs-transform-origin-y", bm, "50%", bp, (m)new l.dk());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 1175 */     a("word-spacing", bm, "normal", bo, true, (m)new l.dr());
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
/* 1188 */   public static final a aB = a("z-index", bm, "auto", bp, (m)new l.dt());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1200 */   public static final a aC = a("border-top-color", bm, "=color", bp, (m)new l.r());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1211 */   public static final a aD = a("border-right-color", bm, "=color", bp, (m)new l.m());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1222 */   public static final a aE = a("border-bottom-color", bm, "=color", bp, (m)new l.g());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1233 */   public static final a aF = a("border-left-color", bm, "=color", bp, (m)new l.m());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1245 */   public static final a aG = a("border-top-style", bm, "none", bp, (m)new l.u());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1256 */   public static final a aH = a("border-right-style", bm, "none", bp, (m)new l.p());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1267 */   public static final a aI = a("border-bottom-style", bm, "none", bp, (m)new l.j());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1278 */   public static final a aJ = a("border-left-style", bm, "none", bp, (m)new l.n());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1290 */   public static final a aK = a("border-top-width", bm, "medium", bp, (m)new l.v());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1301 */   public static final a aL = a("border-right-width", bm, "medium", bp, (m)new l.q());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1312 */   public static final a aM = a("border-bottom-width", bm, "medium", bp, (m)new l.k());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1323 */   public static final a aN = a("border-left-width", bm, "medium", bp, (m)new l.o());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1335 */   public static final a aO = a("border-top-left-radius", bm, "0 0", bp, true, (m)new l.s());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1348 */   public static final a aP = a("border-top-right-radius", bm, "0 0", bp, true, (m)new l.t());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1361 */   public static final a aQ = a("border-bottom-right-radius", bm, "0 0", bp, true, (m)new l.i());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1374 */   public static final a aR = a("border-bottom-left-radius", bm, "0 0", bp, true, (m)new l.h());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1387 */   public static final a aS = a("margin-top", bm, "0", bp, (m)new l.cg());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1398 */   public static final a aT = a("margin-right", bm, "0", bp, (m)new l.cf());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1409 */   public static final a aU = a("margin-bottom", bm, "0", bp, (m)new l.cd());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1420 */   public static final a aV = a("margin-left", bm, "0", bp, (m)new l.ce());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1432 */   public static final a aW = a("padding-top", bm, "0", bp, (m)new l.cr());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1443 */   public static final a aX = a("padding-right", bm, "0", bp, (m)new l.cq());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1454 */   public static final a aY = a("padding-bottom", bm, "0", bp, (m)new l.co());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1465 */   public static final a aZ = a("padding-left", bm, "0", bp, (m)new l.cp());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1477 */   public static final a ba = a("image-rendering", bm, "auto", bo, (m)new l.bp());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1486 */   public static final a bb = a("box-sizing", bm, "content-box", bp, (m)new l.x());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1498 */   public static final a bc = a("-fs-max-overflow-pages", bm, "0", bp, (m)new l.ap());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1511 */   public static final a bd = a("-fs-overflow-pages-direction", bm, "ltr", bp, (m)new l.ar());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1524 */   public static final a be = a("background", bn, "transparent none repeat scroll 0% 0%", bp, (m)new b());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 1537 */     a("border-radius", bn, "0px", bp, true, (m)new j.b());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1550 */     a("border-width", bn, "medium", bp, (m)new j.d());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1562 */     a("border-style", bn, "none", bp, (m)new j.c());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1574 */     a("border", bn, "medium none black", bp, (m)new c.a());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1585 */     a("border-top", bn, "medium none black", bp, (m)new c.f());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1596 */     a("border-right", bn, "medium none black", bp, (m)new c.d());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1607 */     a("border-bottom", bn, "medium none black", bp, (m)new c.b());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1618 */     a("border-left", bn, "medium none black", bp, (m)new c.c());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1630 */     a("border-color", bn, "black", bp, (m)new j.a());
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
/* 1642 */   public static final a bf = a("border-spacing", bn, "0", bo, (m)new d());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1654 */   public static final a bg = a("font", bn, "", bo, (m)new h());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1666 */   public static final a bh = a("list-style", bn, "disc outside none", bo, (m)new i());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1678 */   public static final a bi = a("margin", bn, "0", bp, (m)new j.e());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 1690 */     a("outline", bn, "invert none medium", bp, false, null);
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
/* 1703 */   public static final a bj = a("padding", bn, "0", bp, (m)new j.g());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/* 1716 */     a("size", bn, "auto", bp, (m)new o());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1728 */     a("transform-origin", bn, "50% 50%", bp, (m)new l.di());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1736 */   public static final a bk = new a(aS, aT, aU, aV);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1743 */   public static final a bl = new a(aW, aX, aY, aZ);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, m paramm) {
/* 1782 */     this.br = paramString1;
/* 1783 */     this.a = bq++;
/* 1784 */     this.bs = paramString2;
/* 1785 */     this.bt = paramBoolean1;
/* 1786 */     this.bv = paramBoolean2;
/* 1787 */     this.bw = paramm;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String toString() {
/* 1797 */     return this.br;
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
/*      */   public static int a() {
/* 1815 */     return bz.size();
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
/*      */   public static boolean a(a parama) {
/* 1845 */     return parama.bt;
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
/*      */   public static String b(a parama) {
/* 1858 */     return parama.bs;
/*      */   }
/*      */   
/*      */   public static g c(a parama) {
/* 1862 */     return parama.bu;
/*      */   }
/*      */   
/*      */   public static boolean d(a parama) {
/* 1866 */     return parama.bv;
/*      */   }
/*      */   
/*      */   public static m e(a parama) {
/* 1870 */     return parama.bw;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static a a(String paramString) {
/* 1881 */     return (a)by.get(paramString);
/*      */   }
/*      */   
/*      */   public static a a(int paramInt) {
/* 1885 */     return bx[paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static synchronized a a(String paramString1, Object paramObject1, String paramString2, Object paramObject2, m paramm) {
/* 1895 */     return a(paramString1, paramObject1, paramString2, paramObject2, true, paramm);
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
/*      */   private static synchronized a a(String paramString1, Object paramObject1, String paramString2, Object paramObject2, boolean paramBoolean, m paramm) {
/* 1917 */     a a1 = new a(paramString1, paramString2, (paramObject2 == bo), paramBoolean, paramm);
/*      */ 
/*      */     
/* 1920 */     by.put(paramString1, a1);
/*      */     
/* 1922 */     if (paramObject1 == bm) {
/* 1923 */       bz.put(paramString1, a1);
/*      */     }
/*      */     
/* 1926 */     return a1;
/*      */   }
/*      */   
/*      */   static {
/* 1930 */     Iterator<a> iterator1 = by.values().iterator();
/* 1931 */     bx = new a[by.size()];
/* 1932 */     while (iterator1.hasNext()) {
/* 1933 */       a a1 = iterator1.next();
/* 1934 */       bx[a1.a] = a1;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1939 */     c c = new c(new b());
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1944 */     for (Iterator<a> iterator2 = bz.values().iterator(); iterator2.hasNext();) {
/*      */       
/* 1946 */       if ((a1 = iterator2.next()).bs.charAt(0) != '=' && a1.bv) {
/*      */         j j;
/*      */ 
/*      */         
/* 1950 */         if ((j = c.a(a1, 0, a1.bs)) == null) {
/* 1951 */           l.c("Unable to derive initial value for " + a1); continue;
/*      */         } 
/* 1953 */         a1.bu = com.a.a.b.c.a.a(null, a1, j);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int compareTo(Object paramObject) {
/* 1964 */     if (paramObject == null) throw new NullPointerException(); 
/* 1965 */     return this.a - ((a)paramObject).a;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean equals(Object paramObject) {
/* 1971 */     if (this == paramObject) return true; 
/* 1972 */     if (!(paramObject instanceof a)) return false;
/*      */     
/* 1974 */     paramObject = paramObject;
/*      */     
/* 1976 */     return (this.a == ((a)paramObject).a);
/*      */   }
/*      */   
/*      */   public final int hashCode() {
/* 1980 */     return this.a;
/*      */   }
/*      */   
/*      */   public static class a {
/*      */     public final a a;
/*      */     public final a b;
/*      */     public final a c;
/*      */     public final a d;
/*      */     
/*      */     public a(a param1a1, a param1a2, a param1a3, a param1a4) {
/* 1990 */       this.a = param1a1;
/* 1991 */       this.b = param1a2;
/* 1992 */       this.c = param1a3;
/* 1993 */       this.d = param1a4;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */