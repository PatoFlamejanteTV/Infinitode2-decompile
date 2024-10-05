/*      */ package org.a.c.f;
/*      */ 
/*      */ import com.a.a.a.am;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ import java.security.KeyStore;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Queue;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
/*      */ import java.util.Vector;
/*      */ import org.a.a.a.a;
/*      */ import org.a.a.a.c;
/*      */ import org.a.c.b.a;
/*      */ import org.a.c.b.d;
/*      */ import org.a.c.b.e;
/*      */ import org.a.c.b.g;
/*      */ import org.a.c.b.j;
/*      */ import org.a.c.b.k;
/*      */ import org.a.c.b.l;
/*      */ import org.a.c.b.m;
/*      */ import org.a.c.b.n;
/*      */ import org.a.c.b.p;
/*      */ import org.a.c.d.e;
/*      */ import org.a.c.h.c.a;
/*      */ import org.a.c.h.c.d;
/*      */ import org.a.c.h.c.f;
/*      */ import org.a.c.h.c.j;
/*      */ import org.a.c.h.c.k;
/*      */ import org.a.c.h.c.n;
/*      */ import org.a.c.i.a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class b
/*      */   extends a
/*      */ {
/*   80 */   private static final char[] f = new char[] { 'x', 'r', 'e', 'f' };
/*   81 */   private static final char[] g = new char[] { '/', 'X', 'R', 'e', 'f' };
/*   82 */   private static final char[] h = new char[] { 's', 't', 'a', 'r', 't', 'x', 'r', 'e', 'f' };
/*      */   
/*   84 */   private static final byte[] i = new byte[] { 101, 110, 100, 115, 116, 114, 101, 97, 109 };
/*      */   
/*   86 */   private static final byte[] j = new byte[] { 101, 110, 100, 111, 98, 106 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   93 */   private final byte[] k = new byte[2048];
/*      */   
/*      */   protected final e c;
/*      */   
/*      */   private j l;
/*   98 */   private InputStream m = null;
/*   99 */   private String n = "";
/*  100 */   private String o = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  122 */   private static char[] p = new char[] { '%', '%', 'E', 'O', 'F' };
/*      */ 
/*      */ 
/*      */   
/*  126 */   private static char[] q = new char[] { 'o', 'b', 'j' };
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  131 */   private static final char[] r = new char[] { 't', 'r', 'a', 'i', 'l', 'e', 'r' };
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  136 */   private static final char[] s = new char[] { '/', 'O', 'b', 'j', 'S', 't', 'm' };
/*      */ 
/*      */ 
/*      */   
/*      */   private long t;
/*      */ 
/*      */ 
/*      */   
/*      */   protected long d;
/*      */ 
/*      */   
/*      */   private boolean u = true;
/*      */ 
/*      */   
/*      */   protected boolean e = false;
/*      */ 
/*      */   
/*      */   private boolean v = false;
/*      */ 
/*      */   
/*  156 */   private Map<n, Long> w = null;
/*  157 */   private Long x = null;
/*  158 */   private List<Long> y = null;
/*  159 */   private List<Long> z = null;
/*  160 */   private d A = null;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  165 */   private k B = null;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  170 */   private int C = 2048;
/*      */   
/*  172 */   private static final a D = c.a(b.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  178 */   private l E = new l(); private final byte[] F; public final void e(int paramInt) { if (paramInt > 15)
/*      */       this.C = paramInt;  }
/*      */   protected final d p() { d d1 = null; boolean bool = false; try { long l1; if ((l1 = w()) > -1L) { d1 = a(l1); } else { bool = q(); }  }
/*      */     catch (IOException iOException) { if (q()) { bool = true; }
/*      */       else { throw iOException; }
/*      */        }
/*      */      if (d1 != null && d1.n(j.di) == null)
/*      */       bool = q();  if (bool) { d1 = D(); }
/*      */     else { G(); if (this.w != null && !this.w.isEmpty())
/*      */         A();  }
/*      */      return d1; }
/*      */   private d a(long paramLong) { this.c.a(paramLong); long l1 = Math.max(0L, E()); long l2; if ((l2 = c(l1)) > -1L)
/*      */       l1 = l2;  this.b.b(l1); long l3 = l1; HashSet<Long> hashSet = new HashSet(); while (l3 > 0L) { this.c.a(l3); l(); if (this.c.f() == 120) { if (!e(l3) || !F())
/*      */           throw new IOException("Expected trailer object at offset " + this.c.a());  d d2; if ((d2 = this.E.b()).o(j.eg)) { int i = d2.j(j.eg); if ((l2 = c(i)) > -1L && l2 != i) { (new StringBuilder("/XRefStm offset ")).append(i).append(" is incorrect, corrected to ").append(l2); i = (int)l2; d2.a(j.eg, i); }
/*      */            if (i > 0) { this.c.a(i); l(); try { a(l3, false); }
/*      */             catch (IOException iOException) { if (this.u) { (new StringBuilder("Failed to parse /XRefStm at offset ")).append(i); }
/*      */               else { throw iOException; }
/*      */                }
/*      */              }
/*      */           else if (this.u) { (new StringBuilder("Skipped XRef stream due to a corrupt offset:")).append(i); }
/*      */           else { throw new IOException("Skipped XRef stream due to a corrupt offset:" + i); }
/*      */            }
/*      */          if ((l3 = d2.k(j.cU)) > 0L)
/*      */           if ((l2 = c(l3)) > -1L && l2 != l3) { l3 = l2; d2.a(j.cU, l3); }
/*      */             }
/*      */       else if ((l3 = a(l3, true)) > 0L) { if ((l2 = c(l3)) > -1L && l2 != l3) { l3 = l2; d d2; (d2 = this.E.b()).a(j.cU, l3); }
/*      */          }
/*      */        if (hashSet.contains(Long.valueOf(l3)))
/*      */         throw new IOException("/Prev loop at offset " + l3);  hashSet.add(Long.valueOf(l3)); }
/*      */      this.E.a(l1); d d1 = this.E.c(); this.b.c(d1); this.b.b((l.a.b == this.E.a())); x(); this.b.a(this.E.d()); return d1; }
/*      */   private long a(long paramLong, boolean paramBoolean) { long l1 = m(); long l2 = this.b.i(); this.b.a(Math.max(l2, l1)); n(); a(q); d d1 = a(); p p = c(d1); a(p, paramLong, paramBoolean); p.close(); return d1.k(j.cU); }
/*  209 */   public b(e parame, String paramString1, InputStream paramInputStream, String paramString2) { super(new j(parame));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1086 */     this.F = new byte[8192]; this.c = parame; this.n = paramString1; this.o = paramString2; this.m = paramInputStream; } private long w() { long l1; try { int m; byte[] arrayOfByte = new byte[m = (this.d < this.C) ? (int)this.d : this.C]; l1 = this.d - m; this.c.a(l1); int n = 0; while (n < m) { int i1; if ((i1 = this.c.a(arrayOfByte, n, m - n)) <= 0)
/*      */           throw new IOException("No more bytes to read for trailing buffer, but expected: " + (m - n));  n += i1; }
/*      */        }
/*      */     finally { this.c.a(0L); }
/*      */      int i; if ((i = a(p, (byte[])SYNTHETIC_LOCAL_VARIABLE_1, SYNTHETIC_LOCAL_VARIABLE_1.length)) < 0)
/*      */       if (this.u) { i = SYNTHETIC_LOCAL_VARIABLE_1.length; (new StringBuilder("Missing end of file marker '")).append(new String(p)).append("'"); }
/*      */       else { throw new IOException("Missing end of file marker '" + new String(p) + "'"); }
/*      */         if ((i = a(h, (byte[])SYNTHETIC_LOCAL_VARIABLE_1, i)) < 0)
/*      */       throw new IOException("Missing 'startxref' marker.");  return l1 + i; }
/*      */   private static int a(char[] paramArrayOfchar, byte[] paramArrayOfbyte, int paramInt) { int i = paramArrayOfchar.length - 1; paramInt = paramInt; int m = i; char c = paramArrayOfchar[i]; while (--paramInt >= 0) { if (paramArrayOfbyte[paramInt] == c) {
/*      */         if (--m < 0)
/*      */           return paramInt;  c = paramArrayOfchar[m]; continue;
/*      */       }  if (m < i) {
/*      */         m = i; c = paramArrayOfchar[i];
/*      */       }  }
/*      */      return -1; }
/*      */   public final boolean q() { return this.u; }
/*      */   private static long a(m paramm) { return paramm.b() << 32L | paramm.d(); }
/* 1104 */   private p c(d paramd) { p p = this.b.a(paramd);
/*      */ 
/*      */     
/* 1107 */     g();
/*      */     
/* 1109 */     b();
/*      */ 
/*      */     
/*      */     l l1;
/*      */ 
/*      */     
/* 1115 */     if ((l1 = a(paramd.n(j.bX), paramd.b(j.dN))) == null)
/*      */     {
/* 1117 */       if (this.u) {
/*      */         
/* 1119 */         (new StringBuilder("The stream doesn't provide any stream length, using fallback readUntilEnd, at offset "))
/* 1120 */           .append(this.c.a());
/*      */       }
/*      */       else {
/*      */         
/* 1124 */         throw new IOException("Missing length for stream.");
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 1129 */     if (l1 != null && b(l1.b())) {
/*      */       
/* 1131 */       OutputStream outputStream = p.m();
/*      */       
/*      */       try {
/* 1134 */         a(outputStream, l1);
/*      */       }
/*      */       finally {
/*      */         
/* 1138 */         outputStream.close();
/*      */         
/* 1140 */         p.a(j.bX, (org.a.c.b.b)l1);
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 1145 */       OutputStream outputStream = p.m();
/*      */       
/*      */       try {
/* 1148 */         a(new c(outputStream));
/*      */       }
/*      */       finally {
/*      */         
/* 1152 */         outputStream.close();
/*      */         
/* 1154 */         if (l1 != null)
/*      */         {
/* 1156 */           p.a(j.bX, (org.a.c.b.b)l1);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     String str;
/* 1161 */     if ((str = g()).equals("endobj") && this.u) {
/*      */       
/* 1163 */       (new StringBuilder("stream ends with 'endobj' instead of 'endstream' at offset "))
/* 1164 */         .append(this.c.a());
/*      */       
/* 1166 */       this.c.b(j.length);
/*      */     }
/* 1168 */     else if (str.length() > 9 && this.u && str.substring(0, 9).equals("endstream")) {
/*      */       
/* 1170 */       (new StringBuilder("stream ends with '")).append(str).append("' instead of 'endstream' at offset ")
/* 1171 */         .append(this.c.a());
/*      */       
/* 1173 */       this.c.b((str.substring(9).getBytes(a.d)).length);
/*      */     }
/* 1175 */     else if (!str.equals("endstream")) {
/*      */       
/* 1177 */       throw new IOException("Error reading stream, expected='endstream' actual='" + str + "' at offset " + this.c
/*      */           
/* 1179 */           .a());
/*      */     } 
/*      */     
/* 1182 */     return p; }
/*      */ 
/*      */   
/*      */   private void a(Queue<org.a.c.b.b> paramQueue, Collection<org.a.c.b.b> paramCollection, Set<Long> paramSet) {
/*      */     for (org.a.c.b.b b1 : paramCollection)
/*      */       a(paramQueue, b1, paramSet); 
/*      */   }
/*      */   
/*      */   private void a(Queue<org.a.c.b.b> paramQueue, org.a.c.b.b paramb, Set<Long> paramSet) {
/*      */     if (paramb instanceof m) {
/*      */       long l1 = a((m)paramb);
/*      */       if (!paramSet.add(Long.valueOf(l1)))
/*      */         return; 
/*      */       paramQueue.add(paramb);
/*      */       return;
/*      */     } 
/*      */     if (paramb instanceof d || paramb instanceof a)
/*      */       paramQueue.add(paramb); 
/*      */   }
/*      */   
/* 1202 */   private void a(OutputStream paramOutputStream) { byte b1 = 0;
/* 1203 */     byte[] arrayOfByte = i;
/*      */ 
/*      */     
/*      */     int i;
/*      */ 
/*      */     
/* 1209 */     while ((i = this.c.a(this.k, b1, 2048 - b1)) > 0) {
/*      */       
/* 1211 */       i += b1;
/*      */       
/* 1213 */       int m = b1;
/*      */       
/*      */       int n;
/*      */       
/* 1217 */       for (n = i - 5; m < i; m++) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1223 */         int i1 = m + 5;
/* 1224 */         if (b1 == 0 && i1 < n) {
/*      */           byte b3;
/*      */           
/* 1227 */           if ((b3 = this.k[i1]) > 116 || b3 < 97) {
/*      */ 
/*      */ 
/*      */             
/* 1231 */             m = i1;
/*      */             
/*      */             continue;
/*      */           } 
/*      */         } 
/*      */         
/*      */         byte b2;
/*      */         
/* 1239 */         if ((b2 = this.k[m]) == arrayOfByte[b1]) {
/*      */           
/* 1241 */           if (++b1 == arrayOfByte.length) {
/*      */ 
/*      */             
/* 1244 */             m++;
/*      */ 
/*      */ 
/*      */             
/*      */             break;
/*      */           } 
/* 1250 */         } else if (b1 == 3 && b2 == j[b1]) {
/*      */ 
/*      */           
/* 1253 */           arrayOfByte = j;
/* 1254 */           b1++;
/*      */ 
/*      */ 
/*      */         
/*      */         }
/*      */         else {
/*      */ 
/*      */ 
/*      */           
/* 1263 */           b1 = (b2 == 101) ? 1 : ((b2 == 110 && b1 == 7) ? 2 : 0);
/*      */           
/* 1265 */           arrayOfByte = i;
/*      */         } 
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */ 
/*      */       
/* 1273 */       if ((n = Math.max(0, m - b1)) > 0)
/*      */       {
/* 1275 */         paramOutputStream.write(this.k, 0, n);
/*      */       }
/* 1277 */       if (b1 == arrayOfByte.length) {
/*      */ 
/*      */         
/* 1280 */         this.c.b(i - n);
/*      */ 
/*      */         
/*      */         break;
/*      */       } 
/*      */       
/* 1286 */       System.arraycopy(arrayOfByte, 0, this.k, 0, b1);
/*      */     } 
/*      */ 
/*      */     
/* 1290 */     paramOutputStream.flush(); }
/*      */   protected final void a(d paramd, j... paramVarArgs) { LinkedList<org.a.c.b.b> linkedList = new LinkedList(); TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>(); HashSet<Long> hashSet1 = new HashSet(); HashSet<Long> hashSet2 = new HashSet(); a(paramVarArgs, paramd, hashSet1); a(linkedList, paramd.h(), hashSet2); while (!linkedList.isEmpty() || !treeMap.isEmpty()) { org.a.c.b.b b1; while ((b1 = linkedList.poll()) != null) { if (b1 instanceof d) { a(linkedList, ((d)b1).h(), hashSet2); continue; }  if (b1 instanceof a) { for (org.a.c.b.b b2 : b1) a(linkedList, b2, hashSet2);  continue; }  if (b1 instanceof m) { m m; long l1 = a(m = (m)b1); n n = new n(m.b(), m.d()); if (!hashSet1.contains(Long.valueOf(l1))) { List<m> list; Long long_; if ((long_ = (Long)this.b.k().get(n)) == null && this.u && this.w != null) if ((long_ = this.w.get(n)) != null) { (new StringBuilder("Set missing ")).append(long_).append(" for object ").append(n); this.b.k().put(n, long_); }   if (long_ != null && long_.longValue() != 0L) { if (long_.longValue() > 0L) { treeMap.put(long_, Collections.singletonList(m)); continue; }  n n1 = new n((int)-long_.longValue(), 0); if ((long_ = (Long)this.b.k().get(n1)) == null || long_.longValue() <= 0L) if (this.u && this.w != null) { if ((long_ = this.w.get(n1)) != null) { (new StringBuilder("Set missing ")).append(long_).append(" for object ").append(n1); this.b.k().put(n1, long_); }  } else { String str = "Invalid object stream xref object reference for key '" + n + "': " + long_; if (!this.u || long_ != null) throw new IOException(str);  continue; }   if ((list = (List)treeMap.get(long_)) == null) { list = new ArrayList(); treeMap.put(long_, list); } else if (!(list instanceof ArrayList)) { throw new IOException(m + " cannot be assigned to offset " + long_ + ", this belongs to " + list.get(0)); }  list.add(m); continue; }  m m1; (m1 = this.b.a((n)list)).a((org.a.c.b.b)k.a); }  }  }  if (!treeMap.isEmpty()) for (m m : treeMap.remove(treeMap.firstKey())) { org.a.c.b.b b2; if ((b2 = a(m, false)) != null) { m.a(b2); a(linkedList, b2, hashSet2); hashSet1.add(Long.valueOf(a(m))); }  }   }  }
/*      */   private void a(j[] paramArrayOfj, d paramd, Set<Long> paramSet) { if (paramArrayOfj != null) { int i; byte b1; for (i = (paramArrayOfj = paramArrayOfj).length, b1 = 0; b1 < i; ) { j j1 = paramArrayOfj[b1]; org.a.c.b.b b2; if (b2 = paramd.n(j1) instanceof m) paramSet.add(Long.valueOf(a((m)b2)));  b1++; }  }  }
/*      */   private org.a.c.b.b a(m paramm, boolean paramBoolean) { return a(paramm.b(), paramm.d(), paramBoolean); }
/*      */   private org.a.c.b.b a(long paramLong, int paramInt, boolean paramBoolean) { n n = new n(paramLong, paramInt); m m; if ((m = this.b.a(n)).a() == null) { Long long_; if ((long_ = (Long)this.b.k().get(n)) == null && this.u && this.w != null) if ((long_ = this.w.get(n)) != null) { (new StringBuilder("Set missing offset ")).append(long_).append(" for object ").append(n); this.b.k().put(n, long_); }   if (paramBoolean && (long_ == null || long_.longValue() <= 0L)) throw new IOException("Object must be defined and must not be compressed object: " + n.b() + ":" + n.a());  if (long_ == null && this.u && this.w == null) { y(); if (this.w != null && !this.w.isEmpty()) { Map map = this.b.k(); Set<Map.Entry<n, Long>> set; for (Iterator<Map.Entry<n, Long>> iterator = (set = this.w.entrySet()).iterator(); iterator.hasNext(); ) { Map.Entry<n, ?> entry; n n1 = (entry = iterator.next()).getKey(); if (!map.containsKey(n1))
/* 1295 */               map.put(n1, entry.getValue());  }  long_ = (Long)map.get(n); }  }  if (long_ == null) { m.a((org.a.c.b.b)k.a); } else if (long_.longValue() > 0L) { a(long_, n, m); } else { f((int)-long_.longValue()); }  }  return m.a(); } private void a(OutputStream paramOutputStream, l paraml) { long l1 = paraml.b();
/* 1296 */     while (l1 > 0L)
/*      */     
/* 1298 */     { boolean bool = (l1 > 8192L) ? true : (int)l1;
/*      */       int i;
/* 1300 */       if ((i = this.c.a(this.F, 0, bool)) <= 0)
/*      */       {
/*      */         
/* 1303 */         throw new IOException("read error at offset " + this.c.a() + ": expected " + bool + " bytes, but read() returns " + i);
/*      */       }
/*      */       
/* 1306 */       paramOutputStream.write(this.F, 0, i);
/* 1307 */       l1 -= i; }  } private void a(Long paramLong, n paramn, m paramm) { p p; this.c.a(paramLong.longValue()); long l1 = m(); int i = n(); a(q); if (l1 != paramn.b() || i != paramn.a())
/*      */       throw new IOException("XREF for " + paramn.b() + ":" + paramn.a() + " points to wrong object: " + l1 + ":" + i + " at offset " + paramLong);  l(); org.a.c.b.b b1 = f(); String str; if ((str = g()).equals("stream")) { this.c.b((str.getBytes(a.d)).length); if (b1 instanceof d) { p = c((d)b1); if (this.B != null)
/*      */           this.B.a(p, paramn.b(), paramn.a());  p = p; } else { throw new IOException("Stream not preceded by dictionary (offset: " + paramLong + ")."); }  l(); if (!(str = h()).startsWith("endobj") && str.startsWith("endstream"))
/*      */         if ((str = str.substring(9).trim()).length() == 0)
/*      */           str = h();   } else if (this.B != null) { this.B.a((org.a.c.b.b)p, paramn.b(), paramn.a()); }  paramm.a((org.a.c.b.b)p); if (!str.startsWith("endobj")) { if (this.u) { (new StringBuilder("Object (")).append(l1).append(":").append(i).append(") at offset ").append(paramLong).append(" does not end with 'endobj' but with '").append(str).append("'"); return; }  throw new IOException("Object (" + l1 + ":" + i + ") at offset " + paramLong + " does not end with 'endobj' but with '" + str + "'"); }
/*      */      }
/* 1313 */   private boolean b(long paramLong) { boolean bool = true;
/*      */     
/*      */     long l1, l2;
/* 1316 */     if ((l2 = (l1 = this.c.a()) + paramLong) > this.d) {
/*      */       
/* 1318 */       bool = false;
/* 1319 */       (new StringBuilder("The end of the stream is out of range, using workaround to read the stream, stream start position: ")).append(l1).append(", length: ").append(paramLong).append(", expected end position: ").append(l2);
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/* 1325 */       this.c.a(l2);
/* 1326 */       l();
/* 1327 */       if (!a(i)) {
/*      */         
/* 1329 */         bool = false;
/* 1330 */         (new StringBuilder("The end of the stream doesn't point to the correct offset, using workaround to read the stream, stream start position: ")).append(l1).append(", length: ").append(paramLong).append(", expected end position: ").append(l2);
/*      */       } 
/*      */ 
/*      */       
/* 1334 */       this.c.a(l1);
/*      */     } 
/* 1336 */     return bool; } private void f(int paramInt) { org.a.c.b.b b1; if (b1 = a(paramInt, 0, true) instanceof p) { try { e e1 = new e((p)b1, this.b); } catch (IOException null) { if (this.u) { (new StringBuilder("object stream ")).append(paramInt).append(" could not be parsed due to an exception"); return; }  throw iOException; }  try { iOException.p(); } catch (IOException iOException) { if (this.u) { (new StringBuilder("Stop reading object stream ")).append(paramInt).append(" due to an exception"); return; }  throw iOException; }  for (m m : iOException.q()) { n n = new n(m); Long long_; if ((long_ = this.E.d().get(n)) != null && long_.longValue() == -paramInt) { m m1; (m1 = this.b.a(n)).a(m.a()); }
/*      */          }
/*      */        }
/*      */      }
/*      */   private l a(org.a.c.b.b paramb, j paramj) { l l1; if (paramb == null)
/*      */       return null;  if (paramb instanceof l) { l1 = (l)paramb; }
/*      */     else if (l1 instanceof m) { m m; org.a.c.b.b b1; if ((b1 = (m = (m)l1).a()) == null) { long l2 = this.c.a(); boolean bool = j.cv.equals(paramj); a(m, bool); this.c.a(l2); b1 = m.a(); }
/*      */        if (b1 == null)
/*      */         throw new IOException("Length object content was not read.");  if (k.a == b1) { (new StringBuilder("Length object (")).append(m.b()).append(" ").append(m.d()).append(") not found"); return null; }
/*      */        if (!(b1 instanceof l))
/*      */         throw new IOException("Wrong type of referenced length object " + m + ": " + b1.getClass().getSimpleName());  l1 = (l)b1; }
/*      */     else { throw new IOException("Wrong type of length object: " + l1.getClass().getSimpleName()); }
/*      */      return l1; }
/* 1349 */   private long c(long paramLong) { if (!this.u)
/*      */     {
/* 1351 */       return paramLong;
/*      */     }
/* 1353 */     this.c.a(paramLong);
/* 1354 */     l();
/* 1355 */     if (this.c.f() == 120 && b(f))
/*      */     {
/* 1357 */       return paramLong;
/*      */     }
/* 1359 */     if (paramLong > 0L) {
/*      */       
/* 1361 */       if (d(paramLong))
/*      */       {
/* 1363 */         return paramLong;
/*      */       }
/*      */ 
/*      */       
/* 1367 */       return b(paramLong, false);
/*      */     } 
/*      */ 
/*      */     
/* 1371 */     return -1L; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean d(long paramLong) {
/* 1384 */     if (!this.u || paramLong == 0L)
/*      */     {
/* 1386 */       return true;
/*      */     }
/*      */     
/* 1389 */     this.c.a(paramLong - 1L);
/*      */     
/*      */     int i;
/* 1392 */     if (c(i = this.c.b())) {
/*      */       
/* 1394 */       l();
/* 1395 */       if (k()) {
/*      */         
/*      */         try {
/*      */ 
/*      */           
/* 1400 */           m();
/* 1401 */           n();
/* 1402 */           a(q);
/*      */           
/* 1404 */           d d1 = a();
/* 1405 */           this.c.a(paramLong);
/* 1406 */           if ("XRef".equals(d1.g(j.dN)))
/*      */           {
/* 1408 */             return true;
/*      */           }
/*      */         }
/* 1411 */         catch (IOException iOException) {
/*      */ 
/*      */           
/* 1414 */           this.c.a(paramLong);
/*      */         } 
/*      */       }
/*      */     } 
/* 1418 */     return false;
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
/*      */   private long b(long paramLong, boolean paramBoolean) {
/* 1432 */     if (paramLong < 0L) {
/*      */       
/* 1434 */       (new StringBuilder("Invalid object offset ")).append(paramLong).append(" when searching for a xref table/stream");
/* 1435 */       return 0L;
/*      */     } 
/*      */     
/*      */     long l1;
/* 1439 */     if ((l1 = c(paramLong, false)) > -1L) {
/*      */       
/* 1441 */       (new StringBuilder("Fixed reference for xref table/stream ")).append(paramLong).append(" -> ").append(l1);
/* 1442 */       return l1;
/*      */     } 
/* 1444 */     (new StringBuilder("Can't find the object xref table/stream at offset ")).append(paramLong);
/* 1445 */     return 0L;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean a(Map<n, Long> paramMap) {
/* 1450 */     if (paramMap == null)
/*      */     {
/* 1452 */       return true;
/*      */     }
/* 1454 */     for (Iterator<Map.Entry> iterator = paramMap.entrySet().iterator(); iterator.hasNext(); ) {
/*      */       Map.Entry<n, ?> entry;
/* 1456 */       n n = (entry = iterator.next()).getKey();
/*      */       
/*      */       Long long_;
/*      */       
/* 1460 */       if ((long_ = (Long)entry.getValue()) != null && long_.longValue() >= 0L && 
/* 1461 */         !a(n, long_.longValue())) {
/*      */         
/* 1463 */         (new StringBuilder("Stop checking xref offsets as at least one (")).append(n).append(") couldn't be dereferenced");
/*      */         
/* 1465 */         return false;
/*      */       } 
/*      */     } 
/* 1468 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void x() {
/* 1479 */     if (!this.u) {
/*      */       return;
/*      */     }
/*      */     
/* 1483 */     Map<n, Long> map = this.E.d();
/* 1484 */     if (!a(map)) {
/*      */       
/* 1486 */       y();
/* 1487 */       if (this.w != null && !this.w.isEmpty()) {
/*      */ 
/*      */         
/* 1490 */         map.clear();
/* 1491 */         map.putAll(this.w);
/*      */       } 
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
/*      */   private boolean a(n paramn, long paramLong) {
/* 1507 */     if (paramLong < 6L)
/*      */     {
/* 1509 */       return false;
/*      */     }
/* 1511 */     boolean bool = false;
/*      */     
/*      */     try {
/* 1514 */       this.c.a(paramLong);
/*      */       
/* 1516 */       if (paramn.b() == m()) {
/*      */         int i;
/*      */         
/* 1519 */         if ((i = n()) == paramn.a())
/*      */         {
/*      */           
/* 1522 */           a(q);
/* 1523 */           bool = true;
/*      */         }
/* 1525 */         else if (this.u && i > paramn.a())
/*      */         {
/*      */           
/* 1528 */           a(q);
/* 1529 */           bool = true;
/* 1530 */           paramn.a(i);
/*      */         }
/*      */       
/*      */       } 
/* 1534 */     } catch (IOException iOException) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1539 */     return bool;
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
/*      */   private void y() {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield w : Ljava/util/Map;
/*      */     //   4: ifnonnull -> 489
/*      */     //   7: aload_0
/*      */     //   8: invokespecial z : ()V
/*      */     //   11: aload_0
/*      */     //   12: new java/util/HashMap
/*      */     //   15: dup
/*      */     //   16: invokespecial <init> : ()V
/*      */     //   19: putfield w : Ljava/util/Map;
/*      */     //   22: aload_0
/*      */     //   23: getfield c : Lorg/a/c/d/e;
/*      */     //   26: invokeinterface a : ()J
/*      */     //   31: lstore_1
/*      */     //   32: ldc2_w 6
/*      */     //   35: lstore_3
/*      */     //   36: ldc2_w -9223372036854775808
/*      */     //   39: lstore #5
/*      */     //   41: ldc -2147483648
/*      */     //   43: istore #7
/*      */     //   45: ldc2_w -9223372036854775808
/*      */     //   48: lstore #8
/*      */     //   50: ldc 'ndo'
/*      */     //   52: invokevirtual toCharArray : ()[C
/*      */     //   55: astore #10
/*      */     //   57: ldc 'bj'
/*      */     //   59: invokevirtual toCharArray : ()[C
/*      */     //   62: astore #11
/*      */     //   64: iconst_0
/*      */     //   65: istore #12
/*      */     //   67: aload_0
/*      */     //   68: getfield c : Lorg/a/c/d/e;
/*      */     //   71: lload_3
/*      */     //   72: invokeinterface a : (J)V
/*      */     //   77: aload_0
/*      */     //   78: getfield c : Lorg/a/c/d/e;
/*      */     //   81: invokeinterface b : ()I
/*      */     //   86: istore #13
/*      */     //   88: lload_3
/*      */     //   89: lconst_1
/*      */     //   90: ladd
/*      */     //   91: lstore_3
/*      */     //   92: iload #13
/*      */     //   94: invokestatic c : (I)Z
/*      */     //   97: ifeq -> 333
/*      */     //   100: aload_0
/*      */     //   101: getstatic org/a/c/f/b.q : [C
/*      */     //   104: invokespecial b : ([C)Z
/*      */     //   107: ifeq -> 333
/*      */     //   110: lload_3
/*      */     //   111: ldc2_w 2
/*      */     //   114: lsub
/*      */     //   115: lstore #14
/*      */     //   117: aload_0
/*      */     //   118: getfield c : Lorg/a/c/d/e;
/*      */     //   121: lload #14
/*      */     //   123: invokeinterface a : (J)V
/*      */     //   128: aload_0
/*      */     //   129: getfield c : Lorg/a/c/d/e;
/*      */     //   132: invokeinterface f : ()I
/*      */     //   137: dup
/*      */     //   138: istore #13
/*      */     //   140: invokestatic d : (I)Z
/*      */     //   143: ifeq -> 330
/*      */     //   146: iinc #13, -48
/*      */     //   149: lload #14
/*      */     //   151: lconst_1
/*      */     //   152: lsub
/*      */     //   153: lstore #14
/*      */     //   155: aload_0
/*      */     //   156: getfield c : Lorg/a/c/d/e;
/*      */     //   159: lload #14
/*      */     //   161: invokeinterface a : (J)V
/*      */     //   166: aload_0
/*      */     //   167: invokevirtual i : ()Z
/*      */     //   170: ifeq -> 330
/*      */     //   173: lload #14
/*      */     //   175: ldc2_w 6
/*      */     //   178: lcmp
/*      */     //   179: ifle -> 208
/*      */     //   182: aload_0
/*      */     //   183: invokevirtual i : ()Z
/*      */     //   186: ifeq -> 208
/*      */     //   189: aload_0
/*      */     //   190: getfield c : Lorg/a/c/d/e;
/*      */     //   193: lload #14
/*      */     //   195: lconst_1
/*      */     //   196: lsub
/*      */     //   197: dup2
/*      */     //   198: lstore #14
/*      */     //   200: invokeinterface a : (J)V
/*      */     //   205: goto -> 173
/*      */     //   208: iconst_0
/*      */     //   209: istore #16
/*      */     //   211: lload #14
/*      */     //   213: ldc2_w 6
/*      */     //   216: lcmp
/*      */     //   217: ifle -> 249
/*      */     //   220: aload_0
/*      */     //   221: invokevirtual k : ()Z
/*      */     //   224: ifeq -> 249
/*      */     //   227: aload_0
/*      */     //   228: getfield c : Lorg/a/c/d/e;
/*      */     //   231: lload #14
/*      */     //   233: lconst_1
/*      */     //   234: lsub
/*      */     //   235: dup2
/*      */     //   236: lstore #14
/*      */     //   238: invokeinterface a : (J)V
/*      */     //   243: iconst_1
/*      */     //   244: istore #16
/*      */     //   246: goto -> 211
/*      */     //   249: iload #16
/*      */     //   251: ifeq -> 330
/*      */     //   254: aload_0
/*      */     //   255: getfield c : Lorg/a/c/d/e;
/*      */     //   258: invokeinterface b : ()I
/*      */     //   263: pop
/*      */     //   264: aload_0
/*      */     //   265: invokevirtual m : ()J
/*      */     //   268: lstore #18
/*      */     //   270: lload #8
/*      */     //   272: lconst_0
/*      */     //   273: lcmp
/*      */     //   274: ifle -> 303
/*      */     //   277: aload_0
/*      */     //   278: getfield w : Ljava/util/Map;
/*      */     //   281: new org/a/c/b/n
/*      */     //   284: dup
/*      */     //   285: lload #5
/*      */     //   287: iload #7
/*      */     //   289: invokespecial <init> : (JI)V
/*      */     //   292: lload #8
/*      */     //   294: invokestatic valueOf : (J)Ljava/lang/Long;
/*      */     //   297: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   302: pop
/*      */     //   303: lload #18
/*      */     //   305: lstore #5
/*      */     //   307: iload #13
/*      */     //   309: istore #7
/*      */     //   311: lload #14
/*      */     //   313: lconst_1
/*      */     //   314: ladd
/*      */     //   315: lstore #8
/*      */     //   317: lload_3
/*      */     //   318: getstatic org/a/c/f/b.q : [C
/*      */     //   321: arraylength
/*      */     //   322: iconst_1
/*      */     //   323: isub
/*      */     //   324: i2l
/*      */     //   325: ladd
/*      */     //   326: lstore_3
/*      */     //   327: iconst_0
/*      */     //   328: istore #12
/*      */     //   330: goto -> 403
/*      */     //   333: iload #13
/*      */     //   335: bipush #101
/*      */     //   337: if_icmpne -> 403
/*      */     //   340: aload_0
/*      */     //   341: aload #10
/*      */     //   343: invokespecial b : ([C)Z
/*      */     //   346: ifeq -> 403
/*      */     //   349: lload_3
/*      */     //   350: aload #10
/*      */     //   352: arraylength
/*      */     //   353: i2l
/*      */     //   354: ladd
/*      */     //   355: lstore_3
/*      */     //   356: aload_0
/*      */     //   357: getfield c : Lorg/a/c/d/e;
/*      */     //   360: lload_3
/*      */     //   361: invokeinterface a : (J)V
/*      */     //   366: aload_0
/*      */     //   367: getfield c : Lorg/a/c/d/e;
/*      */     //   370: invokeinterface e : ()Z
/*      */     //   375: ifeq -> 384
/*      */     //   378: iconst_1
/*      */     //   379: istore #12
/*      */     //   381: goto -> 403
/*      */     //   384: aload_0
/*      */     //   385: aload #11
/*      */     //   387: invokespecial b : ([C)Z
/*      */     //   390: ifeq -> 403
/*      */     //   393: lload_3
/*      */     //   394: aload #11
/*      */     //   396: arraylength
/*      */     //   397: i2l
/*      */     //   398: ladd
/*      */     //   399: lstore_3
/*      */     //   400: iconst_1
/*      */     //   401: istore #12
/*      */     //   403: lload_3
/*      */     //   404: aload_0
/*      */     //   405: getfield x : Ljava/lang/Long;
/*      */     //   408: invokevirtual longValue : ()J
/*      */     //   411: lcmp
/*      */     //   412: ifge -> 427
/*      */     //   415: aload_0
/*      */     //   416: getfield c : Lorg/a/c/d/e;
/*      */     //   419: invokeinterface e : ()Z
/*      */     //   424: ifeq -> 67
/*      */     //   427: aload_0
/*      */     //   428: getfield x : Ljava/lang/Long;
/*      */     //   431: invokevirtual longValue : ()J
/*      */     //   434: ldc2_w 9223372036854775807
/*      */     //   437: lcmp
/*      */     //   438: iflt -> 446
/*      */     //   441: iload #12
/*      */     //   443: ifeq -> 479
/*      */     //   446: lload #8
/*      */     //   448: lconst_0
/*      */     //   449: lcmp
/*      */     //   450: ifle -> 479
/*      */     //   453: aload_0
/*      */     //   454: getfield w : Ljava/util/Map;
/*      */     //   457: new org/a/c/b/n
/*      */     //   460: dup
/*      */     //   461: lload #5
/*      */     //   463: iload #7
/*      */     //   465: invokespecial <init> : (JI)V
/*      */     //   468: lload #8
/*      */     //   470: invokestatic valueOf : (J)Ljava/lang/Long;
/*      */     //   473: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   478: pop
/*      */     //   479: aload_0
/*      */     //   480: getfield c : Lorg/a/c/d/e;
/*      */     //   483: lload_1
/*      */     //   484: invokeinterface a : (J)V
/*      */     //   489: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1549	-> 0
/*      */     //   #1551	-> 7
/*      */     //   #1552	-> 11
/*      */     //   #1553	-> 22
/*      */     //   #1554	-> 32
/*      */     //   #1555	-> 36
/*      */     //   #1556	-> 41
/*      */     //   #1557	-> 45
/*      */     //   #1558	-> 50
/*      */     //   #1559	-> 57
/*      */     //   #1560	-> 64
/*      */     //   #1563	-> 67
/*      */     //   #1564	-> 77
/*      */     //   #1565	-> 88
/*      */     //   #1566	-> 92
/*      */     //   #1568	-> 110
/*      */     //   #1569	-> 117
/*      */     //   #1570	-> 128
/*      */     //   #1572	-> 138
/*      */     //   #1574	-> 146
/*      */     //   #1575	-> 149
/*      */     //   #1576	-> 155
/*      */     //   #1577	-> 166
/*      */     //   #1579	-> 173
/*      */     //   #1581	-> 189
/*      */     //   #1583	-> 208
/*      */     //   #1584	-> 211
/*      */     //   #1586	-> 227
/*      */     //   #1587	-> 243
/*      */     //   #1589	-> 249
/*      */     //   #1591	-> 254
/*      */     //   #1592	-> 264
/*      */     //   #1593	-> 270
/*      */     //   #1596	-> 277
/*      */     //   #1598	-> 294
/*      */     //   #1597	-> 297
/*      */     //   #1600	-> 303
/*      */     //   #1601	-> 307
/*      */     //   #1602	-> 311
/*      */     //   #1603	-> 317
/*      */     //   #1604	-> 327
/*      */     //   #1608	-> 330
/*      */     //   #1612	-> 333
/*      */     //   #1614	-> 349
/*      */     //   #1615	-> 356
/*      */     //   #1616	-> 366
/*      */     //   #1618	-> 378
/*      */     //   #1619	-> 381
/*      */     //   #1621	-> 384
/*      */     //   #1623	-> 393
/*      */     //   #1624	-> 400
/*      */     //   #1629	-> 403
/*      */     //   #1630	-> 427
/*      */     //   #1635	-> 453
/*      */     //   #1636	-> 470
/*      */     //   #1635	-> 473
/*      */     //   #1639	-> 479
/*      */     //   #1641	-> 489
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
/*      */   private long c(long paramLong, boolean paramBoolean) {
/* 1652 */     long l1 = -1L;
/* 1653 */     long l2 = -1L;
/* 1654 */     long l3 = -1L;
/* 1655 */     if (!paramBoolean)
/*      */     {
/* 1657 */       B();
/*      */     }
/* 1659 */     C();
/* 1660 */     if (!paramBoolean && this.y != null)
/*      */     {
/*      */       
/* 1663 */       l2 = a(this.y, paramLong);
/*      */     }
/* 1665 */     if (this.z != null)
/*      */     {
/*      */       
/* 1668 */       l3 = a(this.z, paramLong);
/*      */     }
/*      */     
/* 1671 */     if (l2 > -1L && l3 > -1L) {
/*      */       
/* 1673 */       long l4 = paramLong - l2;
/* 1674 */       long l5 = paramLong - l3;
/* 1675 */       if (Math.abs(l4) > Math.abs(l5))
/*      */       {
/* 1677 */         l1 = l3;
/* 1678 */         this.z.remove(Long.valueOf(l3));
/*      */       }
/*      */       else
/*      */       {
/* 1682 */         l1 = l2;
/* 1683 */         this.y.remove(Long.valueOf(l2));
/*      */       }
/*      */     
/* 1686 */     } else if (l2 > -1L) {
/*      */       
/* 1688 */       l1 = l2;
/* 1689 */       this.y.remove(Long.valueOf(l2));
/*      */     }
/* 1691 */     else if (l3 > -1L) {
/*      */       
/* 1693 */       l1 = l3;
/* 1694 */       this.z.remove(Long.valueOf(l3));
/*      */     } 
/* 1696 */     return l1;
/*      */   }
/*      */ 
/*      */   
/*      */   private static long a(List<Long> paramList, long paramLong) {
/* 1701 */     long l1 = -1L;
/* 1702 */     Long long_ = null;
/* 1703 */     byte b1 = -1;
/* 1704 */     int i = paramList.size();
/*      */     
/* 1706 */     for (byte b2 = 0; b2 < i; b2++) {
/*      */       
/* 1708 */       long l2 = paramLong - ((Long)paramList.get(b2)).longValue();
/*      */       
/* 1710 */       if (long_ == null || 
/* 1711 */         Math.abs(long_.longValue()) > Math.abs(l2)) {
/*      */         
/* 1713 */         long_ = Long.valueOf(l2);
/* 1714 */         b1 = b2;
/*      */       } 
/*      */     } 
/* 1717 */     if (b1 >= 0)
/*      */     {
/* 1719 */       l1 = ((Long)paramList.get(b1)).longValue();
/*      */     }
/* 1721 */     return l1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean d(d paramd) {
/* 1731 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 1732 */     long l1 = this.c.a();
/* 1733 */     this.c.a(6L);
/* 1734 */     while (!this.c.e()) {
/*      */ 
/*      */       
/* 1737 */       if (b(r)) {
/*      */         
/* 1739 */         this.c.a(this.c.a() + r.length);
/*      */         
/*      */         try {
/* 1742 */           boolean bool = false;
/* 1743 */           int m = 0;
/* 1744 */           l();
/* 1745 */           d d1 = a();
/* 1746 */           StringBuilder stringBuilder = new StringBuilder();
/*      */           m m1;
/* 1748 */           if ((m1 = d1.c(j.di)) != null) {
/*      */             
/* 1750 */             long l2 = m1.b();
/* 1751 */             int n = m1.d();
/* 1752 */             stringBuilder.append(l2).append(" ");
/* 1753 */             stringBuilder.append(n).append(" ");
/* 1754 */             bool = true;
/*      */           } 
/*      */           m m2;
/* 1757 */           if ((m2 = d1.c(j.bI)) != null) {
/*      */             
/* 1759 */             long l2 = m2.b();
/* 1760 */             m = m2.d();
/* 1761 */             stringBuilder.append(l2).append(" ");
/* 1762 */             stringBuilder.append(m).append(" ");
/* 1763 */             m = 1;
/*      */           } 
/* 1765 */           if (bool && m != 0)
/*      */           {
/* 1767 */             hashMap.put(stringBuilder.toString(), d1);
/*      */           }
/*      */         }
/* 1770 */         catch (IOException iOException) {
/*      */           continue;
/*      */         } 
/*      */       } 
/*      */       
/* 1775 */       this.c.b();
/*      */     } 
/* 1777 */     this.c.a(l1);
/*      */     
/* 1779 */     int i = hashMap.size();
/* 1780 */     String str = null;
/* 1781 */     if (i > 0) {
/*      */       
/* 1783 */       String[] arrayOfString = new String[i];
/* 1784 */       hashMap.keySet().toArray((Object[])arrayOfString);
/* 1785 */       str = arrayOfString[0];
/* 1786 */       for (byte b1 = 1; b1 < i; b1++) {
/*      */         
/* 1788 */         if (str.equals(arrayOfString[b1]))
/*      */         {
/* 1790 */           hashMap.remove(arrayOfString[b1]);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1795 */     if (hashMap.size() == 1) {
/*      */       
/* 1797 */       boolean bool1 = false;
/* 1798 */       boolean bool2 = false;
/*      */       d d1;
/*      */       org.a.c.b.b b1;
/* 1801 */       if (b1 = (d1 = (d)hashMap.get(str)).n(j.di) instanceof m) {
/*      */         d d2;
/*      */ 
/*      */         
/* 1805 */         if ((d2 = b((m)b1)) != null && f(d2))
/*      */         {
/* 1807 */           bool1 = true;
/*      */         }
/*      */       } 
/*      */       org.a.c.b.b b2;
/* 1811 */       if (b2 = d1.n(j.bI) instanceof m) {
/*      */         d d2;
/*      */ 
/*      */         
/* 1815 */         if ((d2 = b((m)b2)) != null && g(d2))
/*      */         {
/* 1817 */           bool2 = true;
/*      */         }
/*      */       } 
/* 1820 */       if (bool1 && bool2) {
/*      */         
/* 1822 */         paramd.a(j.di, b1);
/* 1823 */         paramd.a(j.bI, b2);
/* 1824 */         if (d1.o(j.aS)) {
/*      */           org.a.c.b.b b3;
/*      */           
/* 1827 */           if (b3 = d1.n(j.aS) instanceof m) {
/*      */             d d2;
/*      */ 
/*      */ 
/*      */             
/* 1832 */             if ((d2 = b((m)b3)) != null)
/*      */             {
/* 1834 */               paramd.a(j.aS, b3);
/*      */             }
/*      */           } 
/*      */         } 
/* 1838 */         if (d1.o(j.bA)) {
/*      */           org.a.c.b.b b3;
/*      */           
/* 1841 */           if (b3 = d1.n(j.bA) instanceof a)
/*      */           {
/* 1843 */             paramd.a(j.bA, b3);
/*      */           }
/*      */         } 
/* 1846 */         return true;
/*      */       } 
/*      */     } 
/* 1849 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void z() {
/* 1859 */     if (this.x == null) {
/*      */       
/* 1861 */       long l1 = this.c.a();
/* 1862 */       this.c.a(6L);
/* 1863 */       while (!this.c.e()) {
/*      */ 
/*      */         
/* 1866 */         if (b(p)) {
/*      */           
/* 1868 */           long l2 = this.c.a();
/* 1869 */           this.c.a(l2 + 5L);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           try {
/* 1875 */             l();
/* 1876 */             if (!b(f))
/*      */             {
/* 1878 */               m();
/* 1879 */               n();
/*      */             }
/*      */           
/* 1882 */           } catch (IOException iOException) {
/*      */ 
/*      */             
/* 1885 */             this.x = Long.valueOf(l2);
/*      */           } 
/*      */         } 
/* 1888 */         this.c.b();
/*      */       } 
/* 1890 */       this.c.a(l1);
/*      */       
/* 1892 */       if (this.x == null)
/*      */       {
/* 1894 */         this.x = Long.valueOf(Long.MAX_VALUE);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void A() {
/* 1906 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 1907 */     long l1 = this.c.a();
/* 1908 */     this.c.a(6L);
/* 1909 */     char[] arrayOfChar = " obj".toCharArray();
/* 1910 */     while (!this.c.e()) {
/*      */ 
/*      */       
/* 1913 */       if (b(s)) {
/*      */         
/* 1915 */         long l2 = this.c.a();
/*      */         
/* 1917 */         long l3 = -1L;
/* 1918 */         boolean bool = false;
/* 1919 */         for (byte b1 = 1; b1 < 40 && !bool; b1++) {
/*      */           long l4;
/*      */           
/* 1922 */           if ((l4 = l2 - (b1 * 10)) > 0L) {
/*      */             
/* 1924 */             this.c.a(l4);
/* 1925 */             for (byte b2 = 0;; b2++);
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           continue;
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1971 */         this.c.a(l2 + s.length);
/*      */       } 
/* 1973 */       this.c.b();
/*      */     } 
/*      */     
/* 1976 */     for (Long long_1 : hashMap.keySet()) {
/*      */       Long long_2;
/*      */ 
/*      */       
/* 1980 */       if ((long_2 = this.w.get(hashMap.get(long_1))) == null) {
/*      */         
/* 1982 */         (new StringBuilder("Skipped incomplete object stream:")).append(hashMap.get(long_1)).append(" at ").append(long_1);
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/* 1987 */       if (long_1.equals(long_2)) {
/*      */         int m; byte[] arrayOfByte;
/* 1989 */         this.c.a(long_1.longValue());
/* 1990 */         long l2 = m();
/* 1991 */         int i = n();
/* 1992 */         a(q);
/*      */ 
/*      */         
/* 1995 */         p p = null;
/* 1996 */         g g = null;
/*      */ 
/*      */         
/*      */         try { d d1;
/* 2000 */           int n = (d1 = a()).j(j.aZ);
/* 2001 */           m = d1.j(j.co);
/*      */           
/* 2003 */           if (n == -1 || m == -1)
/*      */           
/*      */           { 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 2024 */             if (g != null)
/*      */             {
/* 2026 */               g.close();
/*      */             }
/* 2028 */             if (p != null)
/*      */             {
/* 2030 */               p.close(); }  continue; }  p = c(d1); if (this.B != null) this.B.a(p, l2, i);  g = p.k(); arrayOfByte = new byte[n]; g.read(arrayOfByte); } catch (IOException iOException) { (new StringBuilder("Skipped corrupt stream: (")).append(l2).append(" 0 at offset ").append(long_1); continue; } finally { if (g != null) g.close();  if (p != null) p.close();
/*      */            }
/*      */         
/* 2033 */         byte b1 = 0;
/*      */         
/* 2035 */         while (b1 < arrayOfByte.length && arrayOfByte[b1] == 32)
/*      */         {
/* 2037 */           b1++;
/*      */         }
/*      */ 
/*      */         
/*      */         String arrayOfString[], str;
/*      */         
/* 2043 */         if ((arrayOfString = (str = (str = new String(arrayOfByte, b1, arrayOfByte.length - b1, "ISO-8859-1")).replaceAll("\n", " ").replaceAll("  ", " ")).split(" ")).length < m << 1) {
/*      */           
/* 2045 */           (new StringBuilder("Skipped corrupt stream: (")).append(l2).append(" 0 at offset ").append(long_1);
/*      */           
/*      */           continue;
/*      */         } 
/* 2049 */         Map<n, Long> map = this.E.d();
/* 2050 */         for (byte b2 = 0; b2 < m; b2++) {
/*      */           try {
/*      */             Long long_;
/*      */             
/* 2054 */             long l3 = Long.parseLong(arrayOfString[b2 << 1]);
/* 2055 */             n n = new n(l3, 0);
/*      */             
/* 2057 */             if ((long_2 = this.w.get(n)) != null && long_2.longValue() < 0L) {
/*      */ 
/*      */               
/* 2060 */               n n1 = new n(Math.abs(long_2.longValue()), 0);
/* 2061 */               long_ = this.w.get(n1);
/*      */             } 
/* 2063 */             if (long_ == null || long_1.longValue() > long_.longValue())
/*      */             {
/* 2065 */               this.w.put(n, Long.valueOf(-l2));
/* 2066 */               map.put(n, Long.valueOf(-l2));
/*      */             }
/*      */           
/* 2069 */           } catch (NumberFormatException numberFormatException) {
/*      */             
/* 2071 */             (new StringBuilder("Skipped corrupt object key in stream: ")).append(l2);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 2076 */     this.c.a(l1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void B() {
/* 2086 */     if (this.y == null) {
/*      */ 
/*      */       
/* 2089 */       this.y = new Vector<Long>();
/* 2090 */       long l1 = this.c.a();
/* 2091 */       this.c.a(6L);
/*      */       
/* 2093 */       while (!this.c.e()) {
/*      */         
/* 2095 */         if (b(f)) {
/*      */           
/* 2097 */           long l2 = this.c.a();
/* 2098 */           this.c.a(l2 - 1L);
/*      */           
/* 2100 */           if (i())
/*      */           {
/* 2102 */             this.y.add(Long.valueOf(l2));
/*      */           }
/* 2104 */           this.c.a(l2 + 4L);
/*      */         } 
/* 2106 */         this.c.b();
/*      */       } 
/* 2108 */       this.c.a(l1);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void C() {
/* 2119 */     if (this.z == null) {
/*      */ 
/*      */       
/* 2122 */       this.z = new Vector<Long>();
/* 2123 */       long l1 = this.c.a();
/* 2124 */       this.c.a(6L);
/*      */       
/*      */       String str;
/* 2127 */       char[] arrayOfChar = (str = " obj").toCharArray();
/* 2128 */       while (!this.c.e()) {
/*      */         
/* 2130 */         if (b(g)) {
/*      */ 
/*      */           
/* 2133 */           long l2 = -1L;
/* 2134 */           long l3 = this.c.a();
/* 2135 */           boolean bool = false;
/* 2136 */           for (byte b1 = 1; b1 < 40 && !bool; b1++) {
/*      */             long l4;
/*      */             
/* 2139 */             if ((l4 = l3 - (b1 * 10)) > 0L) {
/*      */               
/* 2141 */               this.c.a(l4);
/* 2142 */               for (byte b2 = 0;; b2++);
/*      */             } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             continue;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2183 */           if (l2 > -1L)
/*      */           {
/* 2185 */             this.z.add(Long.valueOf(l2));
/*      */           }
/* 2187 */           this.c.a(l3 + 5L);
/*      */         } 
/* 2189 */         this.c.b();
/*      */       } 
/* 2191 */       this.c.a(l1);
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
/*      */   private d D() {
/*      */     d d1;
/* 2204 */     entry = null;
/* 2205 */     y();
/* 2206 */     if (this.w != null) {
/*      */ 
/*      */       
/* 2209 */       this.E.e();
/*      */       
/* 2211 */       this.E.a(0L, l.a.a);
/* 2212 */       for (Map.Entry<n, Long> entry : this.w.entrySet())
/*      */       {
/* 2214 */         this.E.a((n)entry.getKey(), ((Long)entry.getValue()).longValue());
/*      */       }
/* 2216 */       this.E.a(0L);
/* 2217 */       d1 = this.E.c();
/* 2218 */       t().c(d1);
/* 2219 */       boolean bool = false;
/* 2220 */       if (!d(d1))
/*      */       {
/*      */         
/* 2223 */         if (!e(d1)) {
/*      */ 
/*      */           
/* 2226 */           A();
/* 2227 */           bool = true;
/*      */           
/* 2229 */           e(d1);
/*      */         } 
/*      */       }
/*      */       
/* 2233 */       G();
/* 2234 */       if (!bool)
/*      */       {
/* 2236 */         A();
/*      */       }
/*      */     } 
/* 2239 */     this.v = true;
/* 2240 */     return d1;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean e(d paramd) {
/* 2245 */     boolean bool = false;
/* 2246 */     for (Map.Entry<n, Long> entry : this.w.entrySet()) {
/*      */       d d1;
/*      */       
/* 2249 */       if ((d1 = b((n)entry.getKey(), ((Long)entry.getValue()).longValue())) != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2254 */         if (f(d1)) {
/*      */           
/* 2256 */           paramd.a(j.di, (org.a.c.b.b)this.b.a((n)entry.getKey()));
/* 2257 */           bool = true;
/*      */           continue;
/*      */         } 
/* 2260 */         if (g(d1))
/*      */         {
/* 2262 */           paramd.a(j.bI, (org.a.c.b.b)this.b.a((n)entry.getKey()));
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2267 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   private d b(m paramm) {
/* 2272 */     n n = new n(paramm);
/*      */     Long long_;
/* 2274 */     if ((long_ = this.w.get(n)) != null)
/*      */     {
/* 2276 */       return b(n, long_.longValue());
/*      */     }
/* 2278 */     return null;
/*      */   }
/*      */   
/*      */   private d b(n paramn, long paramLong) {
/*      */     org.a.c.b.b b1;
/* 2283 */     d d1 = null;
/*      */     
/* 2285 */     if (paramLong < 0L) {
/*      */       m m;
/*      */       
/* 2288 */       if ((m = this.b.a(paramn)).a() == null)
/*      */       {
/* 2290 */         f((int)-paramLong);
/*      */       }
/*      */       
/* 2293 */       if (b1 = m.a() instanceof d)
/*      */       {
/* 2295 */         d1 = (d)b1;
/*      */       }
/*      */     }
/*      */     else {
/*      */       
/* 2300 */       this.c.a(paramLong);
/* 2301 */       m();
/* 2302 */       n();
/* 2303 */       a(q);
/* 2304 */       if (this.c.f() != 60)
/*      */       {
/* 2306 */         return null;
/*      */       }
/*      */       
/*      */       try {
/* 2310 */         d1 = a();
/*      */       }
/* 2312 */       catch (IOException iOException) {
/*      */         
/* 2314 */         (new StringBuilder("Skipped object ")).append(b1).append(", either it's corrupt or not a dictionary");
/*      */       } 
/*      */     } 
/*      */     
/* 2318 */     return d1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void a(d paramd) {
/* 2328 */     if (this.v && paramd != null) {
/*      */       org.a.c.b.b b1;
/*      */ 
/*      */       
/* 2332 */       if (b1 = paramd.a(j.cL) instanceof d)
/*      */       {
/* 2334 */         a((d)b1, new HashSet<m>());
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int a(d paramd, Set<m> paramSet) {
/* 2342 */     org.a.c.b.b b1 = paramd.a(j.bR);
/* 2343 */     int i = 0;
/* 2344 */     if (b1 instanceof a) {
/*      */       a a1;
/*      */       
/*      */       List<?> list;
/* 2348 */       for (Iterator<?> iterator = (list = (a1 = (a)b1).e()).iterator(); iterator.hasNext(); ) {
/*      */         org.a.c.b.b b2;
/* 2350 */         if (!(b2 = (org.a.c.b.b)iterator.next() instanceof m) || paramSet.contains(b2)) {
/*      */           
/* 2352 */           a1.b(b2);
/*      */           
/*      */           continue;
/*      */         } 
/*      */         m m;
/*      */         org.a.c.b.b b3;
/* 2358 */         if ((b3 = (m = (m)b2).a()) == null || b3.equals(k.a)) {
/*      */           
/* 2360 */           (new StringBuilder("Removed null object ")).append(b2).append(" from pages dictionary");
/* 2361 */           a1.b(b2); continue;
/*      */         } 
/* 2363 */         if (b3 instanceof d) {
/*      */           d d1;
/*      */           
/* 2366 */           j j1 = (d1 = (d)b3).b(j.dN);
/* 2367 */           if (j.cL.equals(j1)) {
/*      */ 
/*      */             
/* 2370 */             paramSet.add(m);
/* 2371 */             i += a(d1, paramSet); continue;
/*      */           } 
/* 2373 */           if (j.cK.equals(j1))
/*      */           {
/*      */             
/* 2376 */             i++;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 2382 */     paramd.a(j.ag, i);
/* 2383 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean f(d paramd) {
/* 2394 */     return j.N.equals(paramd.b(j.dN));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean g(d paramd) {
/* 2405 */     if (paramd.o(j.cN) || paramd.o(j.a) || paramd.o(j.ay))
/*      */     {
/* 2407 */       return false;
/*      */     }
/* 2409 */     if (!paramd.o(j.cn) && !paramd.o(j.dI) && 
/* 2410 */       !paramd.o(j.r) && 
/* 2411 */       !paramd.o(j.dD) && 
/* 2412 */       !paramd.o(j.bQ) && 
/* 2413 */       !paramd.o(j.ai) && 
/* 2414 */       !paramd.o(j.cW) && 
/* 2415 */       !paramd.o(j.ah))
/*      */     {
/* 2417 */       return false;
/*      */     }
/* 2419 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private long E() {
/* 2430 */     long l1 = -1L;
/* 2431 */     if (b(h)) {
/*      */       
/* 2433 */       g();
/* 2434 */       l();
/*      */       
/* 2436 */       l1 = o();
/*      */     } 
/* 2438 */     return l1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean a(byte[] paramArrayOfbyte) {
/*      */     boolean bool;
/* 2450 */     int i = 0;
/* 2451 */     if (this.c.f() == paramArrayOfbyte[0]) {
/*      */ 
/*      */       
/* 2454 */       byte[] arrayOfByte = new byte[i = paramArrayOfbyte.length];
/* 2455 */       int m = this.c.a(arrayOfByte, 0, i);
/* 2456 */       while (m < i) {
/*      */         int n;
/*      */         
/* 2459 */         if ((n = this.c.a(arrayOfByte, m, i - m)) >= 0)
/*      */         {
/*      */ 
/*      */           
/* 2463 */           m += n; } 
/*      */       } 
/* 2465 */       bool = Arrays.equals(paramArrayOfbyte, arrayOfByte);
/* 2466 */       this.c.b(m);
/*      */     } 
/* 2468 */     return bool;
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
/*      */   private boolean b(char[] paramArrayOfchar) {
/* 2480 */     boolean bool = true;
/* 2481 */     long l1 = this.c.a(); int i; byte b1;
/* 2482 */     for (i = (paramArrayOfchar = paramArrayOfchar).length, b1 = 0; b1 < i; ) { char c = paramArrayOfchar[b1];
/*      */       
/* 2484 */       if (this.c.b() != c) {
/*      */         
/* 2486 */         bool = false; break;
/*      */       } 
/*      */       b1++; }
/*      */     
/* 2490 */     this.c.a(l1);
/* 2491 */     return bool;
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
/*      */   private boolean F() {
/* 2503 */     this.t = this.c.a();
/*      */     
/* 2505 */     if (this.u) {
/*      */       
/* 2507 */       int i = this.c.f();
/* 2508 */       while (i != 116 && d(i)) {
/*      */         
/* 2510 */         if (this.c.a() == this.t)
/*      */         {
/*      */           
/* 2513 */           (new StringBuilder("Expected trailer object at offset ")).append(this.t).append(", keep trying");
/*      */         }
/*      */         
/* 2516 */         h();
/* 2517 */         i = this.c.f();
/*      */       } 
/*      */     } 
/* 2520 */     if (this.c.f() != 116)
/*      */     {
/* 2522 */       return false;
/*      */     }
/*      */     
/* 2525 */     long l1 = this.c.a();
/*      */     String str;
/* 2527 */     if (!(str = h()).trim().equals("trailer"))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2533 */       if (str.startsWith("trailer")) {
/*      */ 
/*      */         
/* 2536 */         byte b1 = 7;
/*      */         
/* 2538 */         this.c.a(l1 + b1);
/*      */       }
/*      */       else {
/*      */         
/* 2542 */         return false;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2549 */     l();
/*      */     
/* 2551 */     d d1 = a();
/* 2552 */     this.E.a(d1);
/*      */     
/* 2554 */     l();
/* 2555 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final boolean r() {
/* 2566 */     return a("%PDF-", "1.4");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final boolean s() {
/* 2577 */     return a("%FDF-", "1.0");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean a(String paramString1, String paramString2) {
/*      */     String str;
/* 2585 */     if (!(str = h()).contains(paramString1)) {
/*      */       
/* 2587 */       str = h();
/* 2588 */       while (!str.contains(paramString1)) {
/*      */ 
/*      */         
/* 2591 */         if (str.length() <= 0 || !Character.isDigit(str.charAt(0)))
/*      */         {
/*      */ 
/*      */           
/* 2595 */           str = h();
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2600 */     if (!str.contains(paramString1)) {
/*      */       
/* 2602 */       this.c.a(0L);
/* 2603 */       return false;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*      */     int i;
/*      */ 
/*      */     
/* 2611 */     if ((i = str.indexOf(paramString1)) > 0)
/*      */     {
/*      */       
/* 2614 */       str = str.substring(i, str.length());
/*      */     }
/*      */ 
/*      */     
/* 2618 */     if (str.startsWith(paramString1) && !str.matches(paramString1 + "\\d.\\d"))
/*      */     {
/* 2620 */       if (str.length() < paramString1.length() + 3) {
/*      */ 
/*      */         
/* 2623 */         str = paramString1 + paramString2;
/* 2624 */         (new StringBuilder("No version found, set to ")).append(paramString2).append(" as default.");
/*      */       }
/*      */       else {
/*      */         
/* 2628 */         paramString2 = str.substring(paramString1.length() + 3, str.length()) + "\n";
/* 2629 */         str = str.substring(0, paramString1.length() + 3);
/* 2630 */         this.c.b((paramString2.getBytes(a.d)).length);
/*      */       } 
/*      */     }
/* 2633 */     float f = -1.0F;
/*      */     
/*      */     try {
/*      */       String[] arrayOfString;
/* 2637 */       if ((arrayOfString = str.split("-")).length == 2)
/*      */       {
/* 2639 */         f = Float.parseFloat(arrayOfString[1]);
/*      */       }
/*      */     }
/* 2642 */     catch (NumberFormatException numberFormatException) {}
/*      */ 
/*      */ 
/*      */     
/* 2646 */     if (f < 0.0F)
/*      */     {
/* 2648 */       if (this.u) {
/*      */         
/* 2650 */         f = 1.7F;
/*      */       }
/*      */       else {
/*      */         
/* 2654 */         throw new IOException("Error getting header version: " + str);
/*      */       } 
/*      */     }
/* 2657 */     this.b.a(f);
/*      */     
/* 2659 */     this.c.a(0L);
/* 2660 */     return true;
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
/*      */   private boolean e(long paramLong) {
/* 2672 */     if (this.c.f() != 120)
/*      */     {
/* 2674 */       return false;
/*      */     }
/*      */     String str;
/* 2677 */     if (!(str = g()).trim().equals("xref"))
/*      */     {
/* 2679 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 2684 */     byte[] arrayOfByte = (str = g()).getBytes(a.d);
/* 2685 */     this.c.b(arrayOfByte.length);
/*      */ 
/*      */     
/* 2688 */     this.E.a(paramLong, l.a.a);
/*      */     
/* 2690 */     if (str.startsWith("trailer"))
/*      */     {
/*      */       
/* 2693 */       return false;
/*      */     }
/*      */     
/*      */     while (true) {
/*      */       int i;
/*      */       
/*      */       long l1;
/*      */       String str1, arrayOfString[];
/* 2701 */       if ((arrayOfString = (str1 = h()).split("\\s")).length != 2) {
/*      */         
/* 2703 */         (new StringBuilder("Unexpected XRefTable Entry: ")).append(str1);
/* 2704 */         return false;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/* 2710 */         l1 = Long.parseLong(arrayOfString[0]);
/*      */       }
/* 2712 */       catch (NumberFormatException numberFormatException) {
/*      */         
/* 2714 */         (new StringBuilder("XRefTable: invalid ID for the first object: ")).append(str1);
/* 2715 */         return false;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/* 2722 */         i = Integer.parseInt(arrayOfString[1]);
/*      */       }
/* 2724 */       catch (NumberFormatException numberFormatException) {
/*      */         
/* 2726 */         (new StringBuilder("XRefTable: invalid number of objects: ")).append(str1);
/* 2727 */         return false;
/*      */       } 
/*      */       
/* 2730 */       l();
/* 2731 */       for (byte b1 = 0; b1 < i;) {
/*      */         
/* 2733 */         if (!this.c.e() && !a((char)this.c.f()))
/*      */         {
/*      */ 
/*      */           
/* 2737 */           if (this.c.f() != 116) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 2744 */             if ((arrayOfString = (str1 = h()).split("\\s")).length < 3) {
/*      */               
/* 2746 */               (new StringBuilder("invalid xref line: ")).append(str1);
/*      */               
/*      */               break;
/*      */             } 
/*      */             
/* 2751 */             if (arrayOfString[arrayOfString.length - 1].equals("n")) {
/*      */               
/*      */               try
/*      */               {
/* 2755 */                 long l2 = Long.parseLong(arrayOfString[0]);
/* 2756 */                 int m = Integer.parseInt(arrayOfString[1]);
/* 2757 */                 n n = new n(l1, m);
/* 2758 */                 this.E.a(n, l2);
/*      */               }
/* 2760 */               catch (NumberFormatException numberFormatException)
/*      */               {
/* 2762 */                 throw new IOException(numberFormatException);
/*      */               }
/*      */             
/* 2765 */             } else if (!arrayOfString[2].equals("f")) {
/*      */               
/* 2767 */               throw new IOException("Corrupt XRefTable Entry - ObjID:" + l1);
/*      */             } 
/* 2769 */             l1++;
/* 2770 */             l(); b1++;
/*      */           }  } 
/* 2772 */       }  l();
/* 2773 */       if (k()) {
/*      */         continue;
/*      */       }
/*      */       break;
/*      */     } 
/* 2778 */     return true;
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
/*      */   private void a(p paramp, long paramLong, boolean paramBoolean) {
/* 2793 */     if (paramBoolean) {
/*      */       
/* 2795 */       this.E.a(paramLong, l.a.b);
/* 2796 */       this.E.a((d)paramp);
/*      */     } 
/*      */     i i;
/* 2799 */     (i = new i(paramp, this.b, this.E)).p();
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
/*      */   public final e t() {
/* 2812 */     if (this.b == null)
/*      */     {
/* 2814 */       throw new IOException("You must parse the document first before calling getDocument()");
/*      */     }
/* 2816 */     return this.b;
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
/*      */   public final d u() {
/* 2828 */     if (this.b == null)
/*      */     {
/* 2830 */       throw new IOException("You must parse the document first before calling getEncryption()");
/*      */     }
/*      */     
/* 2833 */     return this.A;
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
/*      */   public final j v() {
/* 2845 */     if (this.b == null)
/*      */     {
/* 2847 */       throw new IOException("You must parse the document first before calling getAccessPermission()");
/*      */     }
/*      */     
/* 2850 */     return this.l;
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
/*      */   protected final org.a.c.b.b b(d paramd) {
/* 2864 */     for (Iterator<org.a.c.b.b> iterator = paramd.h().iterator(); iterator.hasNext();) {
/*      */       
/* 2866 */       if (b1 = iterator.next() instanceof m) {
/*      */         
/* 2868 */         m m1 = (m)b1;
/* 2869 */         a(m1, false);
/*      */       } 
/*      */     } 
/*      */     
/*      */     m m;
/* 2874 */     if ((m = paramd.c(j.di)) == null)
/*      */     {
/* 2876 */       throw new IOException("Missing root object specification in trailer.");
/*      */     }
/* 2878 */     return m.a();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void G() {
/* 2889 */     if (this.A == null) {
/*      */       org.a.c.b.b b1;
/*      */       
/* 2892 */       if ((b1 = this.b.h().n(j.aS)) != null && !(b1 instanceof k)) {
/*      */         
/* 2894 */         if (b1 instanceof m) {
/*      */           
/* 2896 */           m m = (m)b1;
/* 2897 */           c(m);
/*      */         } 
/*      */         try {
/*      */           n n;
/* 2901 */           this.A = new d(this.b.d());
/*      */           
/* 2903 */           if (this.m != null) {
/*      */             KeyStore keyStore;
/*      */             
/* 2906 */             (keyStore = KeyStore.getInstance("PKCS12")).load(this.m, this.n.toCharArray());
/*      */             
/* 2908 */             f f = new f(keyStore, this.o, this.n);
/*      */           
/*      */           }
/*      */           else {
/*      */             
/* 2913 */             n = new n(this.n);
/*      */           } 
/*      */           
/* 2916 */           this.B = this.A.a();
/* 2917 */           this.B.a(this.A, this.b.e(), (a)n);
/*      */           
/* 2919 */           this.l = this.B.b();
/*      */         }
/* 2921 */         catch (IOException iOException) {
/*      */           
/* 2923 */           throw b1 = null;
/*      */         }
/* 2925 */         catch (Exception exception) {
/*      */           
/* 2927 */           throw new IOException("Error (" + exception.getClass().getSimpleName() + ") while creating security handler for decryption", exception);
/*      */         
/*      */         }
/*      */         finally {
/*      */           
/* 2932 */           if (this.m != null)
/*      */           {
/* 2934 */             am.a(this.m);
/*      */           }
/*      */         } 
/*      */       } 
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
/*      */   private void c(m paramm) {
/* 2950 */     a(paramm, true);
/* 2951 */     if (!(paramm.a() instanceof d))
/*      */     {
/*      */ 
/*      */       
/* 2955 */       throw new IOException("Dictionary object expected at offset " + this.c.a());
/*      */     }
/*      */     d d1;
/* 2958 */     for (Iterator<org.a.c.b.b> iterator = (d1 = (d)paramm.a()).h().iterator(); iterator.hasNext();) {
/*      */       
/* 2960 */       if (b1 = iterator.next() instanceof m) {
/*      */         m m1;
/*      */         
/* 2963 */         if ((m1 = (m)b1).a() == null)
/*      */         {
/* 2965 */           c(m1);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */