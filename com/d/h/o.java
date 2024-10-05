/*     */ package com.d.h;
/*     */ 
/*     */ import com.a.a.b.c.a;
/*     */ import com.d.c.a.a;
/*     */ import com.d.e.aa;
/*     */ import com.d.i.ab;
/*     */ import com.d.i.f;
/*     */ import com.d.m.a;
/*     */ import com.d.m.l;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.logging.Level;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.b;
/*     */ import org.a.c.h.e;
/*     */ import org.a.c.h.e.ae;
/*     */ import org.a.c.h.e.u;
/*     */ import org.a.c.h.g.b.q;
/*     */ import org.a.c.h.g.e.d;
/*     */ import org.a.c.h.j;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class o
/*     */ {
/*  38 */   private final Map<Element, h> a = new HashMap<>();
/*     */ 
/*     */   
/*  41 */   private final List<h.b> b = new ArrayList<>();
/*     */ 
/*     */   
/*  44 */   private final Set<Element> c = new HashSet<>();
/*     */ 
/*     */   
/*  47 */   private final Map<u, String> d = new HashMap<>();
/*     */ 
/*     */ 
/*     */   
/*  51 */   private final Map<h.a, q> e = new EnumMap<>(h.a.class);
/*     */   
/*     */   private q f;
/*     */   
/*     */   private q g;
/*     */   
/*     */   private q h;
/*     */   
/*     */   private j i;
/*     */   
/*     */   public final q a(h.a parama) {
/*  62 */     return this.e.get(parama);
/*     */   }
/*     */   
/*     */   public final q a() {
/*  66 */     return this.f;
/*     */   }
/*     */   
/*     */   public final q b() {
/*  70 */     return this.g;
/*     */   }
/*     */   
/*     */   public final q c() {
/*  74 */     return this.h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(f paramf, m paramm) {
/*  81 */     if (!this.a.containsKey(paramf.ai())) {
/*  82 */       h h = h.a(paramf.ai(), this, paramm);
/*  83 */       this.a.put(paramf.ai(), h);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(f paramf, e parame, AffineTransform paramAffineTransform, ab paramab, float paramFloat) {
/*  91 */     if (!this.c.contains(paramf.ai())) {
/*  92 */       this.b.add(new h.b(paramf, parame, new AffineTransform(paramAffineTransform), paramab, paramFloat));
/*  93 */       this.c.add(paramf.ai());
/*     */     } 
/*     */   }
/*     */   private String a(aa paramaa, h.b paramb) {
/*     */     String str;
/*  98 */     u u = ((f.b)((b)paramaa.a(paramb.a.a().h())).b().get(0)).c();
/*     */ 
/*     */     
/* 101 */     if (!this.d.containsKey(u)) {
/* 102 */       str = "OpenHTMLFont" + this.d.size();
/* 103 */       this.d.put(u, str);
/*     */     } else {
/* 105 */       str = this.d.get(u);
/*     */     } 
/*     */     
/* 108 */     return str;
/*     */   }
/*     */   
/*     */   private void a(b paramb, h.b paramb1) {
/* 112 */     h.a a = h.a.a(paramb1.a.a().e(a.n));
/*     */     
/* 114 */     if (!this.e.containsKey(a)) {
/* 115 */       q q1 = h.a(a, paramb, this.i);
/* 116 */       this.e.put(a, q1);
/*     */     } 
/*     */     
/* 119 */     if (this.f == null) {
/* 120 */       this.f = h.a("q\nQ\n", paramb, this.i);
/*     */     }
/*     */   }
/*     */   
/*     */   private void a(b paramb) {
/* 125 */     if (this.g == null) {
/* 126 */       this.g = h.a("q\nQ\n", paramb, this.i);
/*     */     }
/*     */     
/* 129 */     if (this.h == null) {
/* 130 */       this.h = h.a(h.a.a, paramb, this.i);
/*     */     }
/*     */   }
/*     */   
/*     */   private void d() {
/* 135 */     if (this.i == null) {
/* 136 */       this.i = new j();
/* 137 */       this.i.a(j.a("OpenHTMLZap"), (u)ae.r);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void a(aa paramaa, b paramb, f paramf) {
/* 142 */     for (h.b b1 : this.b) {
/* 143 */       h h = a(b1.a.ai());
/* 144 */       String str = null;
/*     */       
/* 146 */       if (!a.a(b1.a.ai().getAttribute("type"), (Object[])new String[] { "checkbox", "radio", "hidden" })) {
/*     */         
/* 148 */         str = a(paramaa, b1);
/* 149 */       } else if (b1.a.ai().getAttribute("type").equals("checkbox")) {
/* 150 */         d();
/* 151 */         a(paramb, b1);
/* 152 */       } else if (b1.a.ai().getAttribute("type").equals("radio")) {
/* 153 */         d();
/* 154 */         a(paramb);
/*     */       } 
/*     */       
/* 157 */       if (h != null) {
/* 158 */         h.a(b1, str);
/*     */       }
/*     */     } 
/*     */     
/* 162 */     j j1 = new j();
/* 163 */     for (Map.Entry<u, String> entry : this.d.entrySet()) {
/* 164 */       j1.a(j.a((String)entry.getValue()), (u)entry.getKey());
/*     */     }
/*     */     
/* 167 */     if (this.a.size() != 0) {
/* 168 */       int i = 0;
/*     */       
/*     */       d d;
/* 171 */       (d = new d(paramb)).a(Boolean.TRUE);
/* 172 */       d.a(j1);
/*     */       
/* 174 */       paramb.c().a(d);
/*     */       
/* 176 */       for (h h : this.a.values()) {
/*     */         try {
/* 178 */           i = 1 + h.a(d, i, paramf);
/* 179 */         } catch (IOException iOException) {
/* 180 */           throw new w.a("processControls", iOException);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private h a(Node paramNode) {
/*     */     Element element;
/* 192 */     if ((element = a.a(paramNode, "form")) != null && this.a
/* 193 */       .containsKey(element)) {
/* 194 */       return this.a.get(element);
/*     */     }
/*     */     
/* 197 */     l.d(Level.WARNING, "Found form control (" + paramNode
/* 198 */         .getNodeName() + ") with no enclosing form. Ignoring.");
/* 199 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\h\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */