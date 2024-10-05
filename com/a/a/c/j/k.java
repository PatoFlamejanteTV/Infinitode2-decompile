/*     */ package com.a.a.c.j;
/*     */ 
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.m;
/*     */ import com.a.a.c.n;
/*     */ import com.a.a.c.u;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class k
/*     */ {
/*     */   private static final com.a.a.c.h.a a;
/*  24 */   private static final u b = (a = new com.a.a.c.h.a()).a(); static {
/*  25 */     a.a()
/*  26 */       .a();
/*     */     
/*  28 */     a.a(m.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String a(b paramb) {
/*     */     try {
/*  34 */       return b.a(b(paramb));
/*  35 */     } catch (IOException iOException) {
/*  36 */       throw new RuntimeException(iOException);
/*     */     } 
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
/*     */   private static n b(b paramb) {
/*  59 */     return (n)new b(paramb);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class b
/*     */     extends n.a
/*     */   {
/*     */     private b a;
/*     */ 
/*     */ 
/*     */     
/*     */     private aa b;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b(b param1b) {
/*  79 */       this.a = param1b;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void a(h param1h, aa param1aa) {
/*  84 */       this.b = param1aa;
/*  85 */       a(param1h, this.a);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(h param1h, aa param1aa, i param1i) {
/*  93 */       a(param1h, param1aa);
/*     */     }
/*     */ 
/*     */     
/*     */     private void a(h param1h, m param1m) {
/*  98 */       if (param1m instanceof r) {
/*  99 */         param1m.a(); param1h.d(this);
/* 100 */         a(param1h, new k.a(), param1m.n()); return;
/* 101 */       }  if (param1m instanceof a) {
/* 102 */         param1h.a(this, param1m.a());
/* 103 */         a(param1h, new k.a(), param1m.m()); return;
/*     */       } 
/* 105 */       param1m.a(param1h, this.b);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void a(h param1h, k.a param1a, Iterator<?> param1Iterator) {
/* 113 */       param1Iterator = param1Iterator;
/*     */       
/*     */       do {
/* 116 */         while (param1Iterator.hasNext()) {
/*     */           Object object;
/*     */ 
/*     */ 
/*     */           
/* 121 */           if (object = param1Iterator.next() instanceof java.util.Map.Entry) {
/*     */             
/* 123 */             object = object;
/* 124 */             param1h.a((String)object.getKey());
/* 125 */             object = object.getValue();
/*     */           } else {
/* 127 */             object = object;
/*     */           } 
/* 129 */           if (object instanceof r) {
/* 130 */             param1a.a(param1Iterator);
/* 131 */             param1Iterator = object.n();
/* 132 */             object.a(); param1h.d(object); continue;
/* 133 */           }  if (object instanceof a) {
/* 134 */             param1a.a(param1Iterator);
/* 135 */             param1Iterator = object.m();
/* 136 */             param1h.a(object, object.a()); continue;
/*     */           } 
/* 138 */           object.a(param1h, this.b);
/*     */         } 
/*     */         
/* 141 */         if (param1h.a().b()) {
/* 142 */           param1h.h();
/*     */         } else {
/* 144 */           param1h.j();
/*     */         }
/*     */       
/* 147 */       } while ((param1Iterator = param1a.a()) != null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class a
/*     */   {
/*     */     private Iterator<?>[] a;
/*     */ 
/*     */ 
/*     */     
/*     */     private int b;
/*     */ 
/*     */     
/*     */     private int c;
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(Iterator<?> param1Iterator) {
/* 168 */       if (this.b < this.c) {
/* 169 */         this.a[this.b++] = param1Iterator;
/*     */         return;
/*     */       } 
/* 172 */       if (this.a == null) {
/* 173 */         this.c = 10;
/* 174 */         this.a = (Iterator<?>[])new Iterator[this.c];
/*     */       } else {
/*     */         
/* 177 */         this.c += Math.min(4000, Math.max(20, this.c >> 1));
/* 178 */         this.a = (Iterator<?>[])Arrays.<Iterator>copyOf((Iterator[])this.a, this.c);
/*     */       } 
/* 180 */       this.a[this.b++] = param1Iterator;
/*     */     }
/*     */     
/*     */     public final Iterator<?> a() {
/* 184 */       if (this.b == 0) {
/* 185 */         return null;
/*     */       }
/*     */ 
/*     */       
/* 189 */       return this.a[--this.b];
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\j\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */