/*     */ package org.a.c.e;
/*     */ 
/*     */ import com.a.a.a.am;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.m;
/*     */ import org.a.c.b.p;
/*     */ import org.a.c.h.a.c;
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
/*     */ public final class b
/*     */ {
/*     */   private final org.a.c.h.b a;
/*  47 */   private final Map<Object, org.a.c.b.b> b = new HashMap<Object, org.a.c.b.b>();
/*  48 */   private final Set<org.a.c.b.b> c = new HashSet<org.a.c.b.b>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b(org.a.c.h.b paramb) {
/*  56 */     this.a = paramb;
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
/*     */   public final org.a.c.b.b a(Object paramObject) {
/*  77 */     if (paramObject == null)
/*     */     {
/*  79 */       return null;
/*     */     }
/*     */     
/*  82 */     if ((b1 = this.b.get(paramObject)) != null)
/*     */     {
/*     */       
/*  85 */       return b1;
/*     */     }
/*  87 */     if (paramObject instanceof org.a.c.b.b && this.c.contains(paramObject))
/*     */     {
/*     */       
/*  90 */       return (org.a.c.b.b)paramObject;
/*     */     }
/*  92 */     if (paramObject instanceof List) {
/*     */       
/*  94 */       a a2 = new a();
/*     */       List<?> list;
/*  96 */       for (org.a.c.b.b b1 : list = (List)paramObject)
/*     */       {
/*  98 */         a2.a(a(b1));
/*     */       }
/* 100 */       a a1 = a2;
/*     */     }
/* 102 */     else if (paramObject instanceof c && !(paramObject instanceof org.a.c.b.b)) {
/*     */       
/* 104 */       b1 = a(((c)paramObject).f());
/*     */     }
/* 106 */     else if (paramObject instanceof m) {
/*     */       
/* 108 */       m m = (m)paramObject;
/* 109 */       b1 = a(m.a());
/*     */     }
/* 111 */     else if (paramObject instanceof a) {
/*     */       
/* 113 */       a a2 = new a();
/* 114 */       a a3 = (a)paramObject;
/* 115 */       for (byte b2 = 0; b2 < a3.b(); b2++)
/*     */       {
/* 117 */         a2.a(a(a3.b(b2)));
/*     */       }
/* 119 */       a a1 = a2;
/*     */     }
/* 121 */     else if (paramObject instanceof p) {
/*     */       
/* 123 */       p p2 = (p)paramObject;
/*     */       p p3;
/* 125 */       OutputStream outputStream = (p3 = this.a.a().a()).m();
/*     */       InputStream inputStream;
/* 127 */       am.a(inputStream = p2.j(), outputStream);
/* 128 */       inputStream.close();
/* 129 */       outputStream.close();
/* 130 */       this.b.put(paramObject, p3);
/* 131 */       for (Map.Entry entry : p2.e())
/*     */       {
/* 133 */         p3.a((j)entry.getKey(), a(entry.getValue()));
/*     */       }
/* 135 */       p p1 = p3;
/*     */     }
/* 137 */     else if (paramObject instanceof d) {
/*     */       
/* 139 */       d d2 = (d)paramObject;
/* 140 */       d d1 = new d();
/* 141 */       this.b.put(paramObject, d1);
/* 142 */       for (Map.Entry entry : d2.e())
/*     */       {
/* 144 */         d1.a((j)entry
/* 145 */             .getKey(), 
/* 146 */             a(entry.getValue()));
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 151 */       b1 = (org.a.c.b.b)paramObject;
/*     */     } 
/* 153 */     this.b.put(paramObject, b1);
/* 154 */     this.c.add(b1);
/* 155 */     return b1;
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
/*     */   public final void a(c paramc1, c paramc2) {
/* 168 */     if (paramc1 == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     org.a.c.b.b b1;
/* 173 */     if ((b1 = this.b.get(paramc1)) != null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 179 */     if (!(paramc1 instanceof org.a.c.b.b)) {
/*     */       
/* 181 */       a((c)paramc1.f(), (c)paramc2.f());
/*     */     }
/* 183 */     else if (paramc1 instanceof m) {
/*     */       
/* 185 */       if (paramc2 instanceof m)
/*     */       {
/* 187 */         a((c)((m)paramc1).a(), (c)((m)paramc2).a());
/*     */       }
/* 189 */       else if (paramc2 instanceof d || paramc2 instanceof a)
/*     */       {
/* 191 */         a((c)((m)paramc1).a(), paramc2);
/*     */       }
/*     */     
/* 194 */     } else if (paramc1 instanceof a) {
/*     */       
/* 196 */       a a = (a)paramc1;
/* 197 */       for (byte b2 = 0; b2 < a.b(); b2++)
/*     */       {
/* 199 */         ((a)paramc2).a(a(a.b(b2))); } 
/*     */     } else {
/*     */       p p;
/* 202 */       if (paramc1 instanceof p) {
/*     */ 
/*     */         
/* 205 */         p p1 = (p)paramc1;
/*     */         p p2;
/* 207 */         OutputStream outputStream = (p2 = this.a.a().a()).a(p1.o());
/* 208 */         am.a((InputStream)p1.k(), outputStream);
/* 209 */         outputStream.close();
/* 210 */         this.b.put(paramc1, p2);
/* 211 */         for (Map.Entry entry : p1.e())
/*     */         {
/* 213 */           p2.a((j)entry
/* 214 */               .getKey(), 
/* 215 */               a(entry.getValue()));
/*     */         }
/* 217 */         p = p2;
/*     */       }
/* 219 */       else if (paramc1 instanceof d) {
/*     */         
/* 221 */         d d = (d)paramc1;
/* 222 */         this.b.put(paramc1, p);
/* 223 */         for (Iterator<Map.Entry> iterator = d.e().iterator(); iterator.hasNext(); ) {
/*     */           Map.Entry<j, ?> entry;
/* 225 */           j j = (entry = iterator.next()).getKey();
/* 226 */           org.a.c.b.b b2 = (org.a.c.b.b)entry.getValue();
/* 227 */           if (((d)paramc2).n(j) != null) {
/*     */             
/* 229 */             a((c)b2, (c)((d)paramc2).n(j));
/*     */             
/*     */             continue;
/*     */           } 
/* 233 */           ((d)paramc2).a(j, a(b2));
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 239 */         b1 = (org.a.c.b.b)paramc1;
/*     */       } 
/* 241 */     }  this.b.put(paramc1, b1);
/* 242 */     this.c.add(b1);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */