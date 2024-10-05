/*     */ package org.b.a;
/*     */ 
/*     */ import java.util.EnumSet;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import org.b.a.a.b;
/*     */ import org.b.a.a.c;
/*     */ import org.b.a.a.d;
/*     */ import org.b.a.a.e;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */ {
/*     */   private final b a;
/*     */   private final b b;
/*     */   private final b c;
/*     */   
/*     */   private a(d paramd, e parame, c paramc) {
/*  22 */     this.a = (b)paramd;
/*  23 */     this.b = (b)parame;
/*  24 */     this.c = (b)paramc;
/*     */   }
/*     */   
/*     */   public static a a() {
/*  28 */     return new a((byte)0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Iterable<c> a(CharSequence paramCharSequence) {
/*  38 */     return new b(this, paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b a(char paramChar) {
/*  47 */     switch (paramChar) {
/*     */       case ':':
/*  49 */         return this.a;
/*     */       case '@':
/*  51 */         return this.c;
/*     */       case 'w':
/*  53 */         return this.b;
/*     */     } 
/*  55 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class a
/*     */   {
/*  63 */     private Set<d> a = EnumSet.allOf(d.class);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean b = true;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final a a(Set<d> param1Set) {
/*  74 */       if (param1Set == null) {
/*  75 */         throw new NullPointerException("linkTypes must not be null");
/*     */       }
/*  77 */       this.a = new HashSet<>(param1Set);
/*  78 */       return this;
/*     */     }
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
/*     */     public final a a() {
/*  95 */       d d = this.a.contains(d.a) ? new d() : null;
/*  96 */       e e = this.a.contains(d.c) ? new e() : null;
/*  97 */       c c = this.a.contains(d.b) ? new c(this.b) : null;
/*  98 */       return new a(d, e, c, (byte)0);
/*     */     }
/*     */     
/*     */     private a() {}
/*     */   }
/*     */   
/*     */   private class b implements Iterator<c> {
/*     */     private final CharSequence a;
/* 106 */     private c b = null;
/* 107 */     private int c = 0;
/* 108 */     private int d = 0;
/*     */     
/*     */     public b(a this$0, CharSequence param1CharSequence) {
/* 111 */       this.a = param1CharSequence;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean hasNext() {
/* 116 */       b();
/* 117 */       return (this.b != null);
/*     */     }
/*     */ 
/*     */     
/*     */     private c a() {
/* 122 */       if (hasNext()) {
/* 123 */         c c1 = this.b;
/* 124 */         this.b = null;
/* 125 */         return c1;
/*     */       } 
/* 127 */       throw new NoSuchElementException();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final void remove() {
/* 133 */       throw new UnsupportedOperationException("remove");
/*     */     }
/*     */     
/*     */     private void b() {
/* 137 */       if (this.b != null) {
/*     */         return;
/*     */       }
/*     */       
/* 141 */       int i = this.a.length();
/* 142 */       while (this.c < i) {
/*     */         b b1;
/* 144 */         if ((b1 = a.a(this.e, this.a.charAt(this.c))) != null) {
/*     */           c c1;
/* 146 */           if ((c1 = b1.a(this.a, this.c, this.d)) != null) {
/* 147 */             this.b = c1;
/* 148 */             this.c = c1.getEndIndex();
/* 149 */             this.d = this.c;
/*     */             return;
/*     */           } 
/* 152 */           this.c++;
/*     */           continue;
/*     */         } 
/* 155 */         this.c++;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\b\a\a.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */