/*     */ package com.a.a.c;
/*     */ 
/*     */ import com.a.a.a.p;
/*     */ import com.a.a.b.d;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.j;
/*     */ import com.a.a.c.m.i;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
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
/*     */ public class l
/*     */   extends e
/*     */ {
/*     */   private LinkedList<a> b;
/*     */   private transient Closeable c;
/*     */   
/*     */   public static class a
/*     */     implements Serializable
/*     */   {
/*     */     private transient Object a;
/*     */     private String b;
/*  69 */     private int c = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected a() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(Object param1Object, String param1String) {
/*  89 */       this.a = param1Object;
/*  90 */       if (param1String == null) {
/*  91 */         throw new NullPointerException("Cannot pass null fieldName");
/*     */       }
/*  93 */       this.b = param1String;
/*     */     }
/*     */     
/*     */     public a(Object param1Object, int param1Int) {
/*  97 */       this.a = param1Object;
/*  98 */       this.c = param1Int;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String a() {
/* 122 */       if (this.d == null) {
/* 123 */         StringBuilder stringBuilder = new StringBuilder();
/*     */         
/* 125 */         if (this.a == null) {
/* 126 */           stringBuilder.append("UNKNOWN");
/*     */         } else {
/* 128 */           Class<?> clazz = (this.a instanceof Class) ? (Class)this.a : this.a.getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 133 */           byte b = 0;
/* 134 */           while (clazz.isArray()) {
/* 135 */             clazz = clazz.getComponentType();
/* 136 */             b++;
/*     */           } 
/* 138 */           stringBuilder.append(clazz.getName());
/* 139 */           while (--b >= 0) {
/* 140 */             stringBuilder.append("[]");
/*     */           }
/*     */         } 
/* 143 */         stringBuilder.append('[');
/* 144 */         if (this.b != null) {
/* 145 */           stringBuilder.append('"');
/* 146 */           stringBuilder.append(this.b);
/* 147 */           stringBuilder.append('"');
/* 148 */         } else if (this.c >= 0) {
/* 149 */           stringBuilder.append(this.c);
/*     */         } else {
/* 151 */           stringBuilder.append('?');
/*     */         } 
/* 153 */         stringBuilder.append(']');
/* 154 */         this.d = stringBuilder.toString();
/*     */       } 
/* 156 */       return this.d;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 161 */       return a();
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
/*     */   public l(Closeable paramCloseable, String paramString) {
/* 233 */     super(paramString);
/* 234 */     this.c = paramCloseable;
/* 235 */     if (paramCloseable instanceof com.a.a.b.l)
/*     */     {
/*     */ 
/*     */       
/* 239 */       this.a = ((com.a.a.b.l)paramCloseable).f();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public l(Closeable paramCloseable, String paramString, Throwable paramThrowable) {
/* 247 */     super(paramString, paramThrowable);
/* 248 */     this.c = paramCloseable;
/*     */     
/* 250 */     if (paramThrowable instanceof d) {
/* 251 */       this.a = ((d)paramThrowable).a(); return;
/* 252 */     }  if (paramCloseable instanceof com.a.a.b.l) {
/* 253 */       this.a = ((com.a.a.b.l)paramCloseable).f();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public l(Closeable paramCloseable, String paramString, j paramj) {
/* 261 */     super(paramString, paramj);
/* 262 */     this.c = paramCloseable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static l a(com.a.a.b.l paraml, String paramString) {
/* 269 */     return new l((Closeable)paraml, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static l a(com.a.a.b.l paraml, String paramString, Throwable paramThrowable) {
/* 276 */     return new l((Closeable)paraml, paramString, paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static l a(h paramh, String paramString) {
/* 283 */     return new l((Closeable)paramh, paramString, (Throwable)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static l a(h paramh, String paramString, Throwable paramThrowable) {
/* 290 */     return new l((Closeable)paramh, paramString, paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static l a(g paramg, String paramString) {
/* 297 */     return new l((Closeable)a(paramg), paramString);
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
/*     */   private static com.a.a.b.l a(g paramg) {
/* 309 */     return (paramg == null) ? null : paramg.j();
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
/*     */   public static l a(IOException paramIOException) {
/* 345 */     return new l(null, 
/* 346 */         String.format("Unexpected IOException (of type %s): %s", new Object[] {
/* 347 */             paramIOException.getClass().getName(), 
/* 348 */             i.g(paramIOException)
/*     */           }));
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
/*     */   public static l a(Throwable paramThrowable, Object paramObject, String paramString) {
/* 361 */     return a(paramThrowable, new a(paramObject, paramString));
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
/*     */   public static l a(Throwable paramThrowable, Object paramObject, int paramInt) {
/* 373 */     return a(paramThrowable, new a(paramObject, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static l a(Throwable paramThrowable, a parama) {
/*     */     l l1;
/* 385 */     if (paramThrowable instanceof l) {
/* 386 */       l1 = (l)paramThrowable;
/*     */     } else {
/*     */       String str;
/*     */ 
/*     */       
/* 391 */       if ((str = i.g((Throwable)l1)) == null || str.isEmpty()) {
/* 392 */         str = "(was " + l1.getClass().getName() + ")";
/*     */       }
/*     */       
/* 395 */       Closeable closeable = null; Object object;
/* 396 */       if (l1 instanceof d && 
/*     */         
/* 398 */         object = ((d)l1).c() instanceof Closeable) {
/* 399 */         closeable = (Closeable)object;
/*     */       }
/*     */       
/* 402 */       l1 = new l(closeable, str, (Throwable)l1);
/*     */     } 
/* 404 */     l1.a(parama);
/* 405 */     return l1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final l a(Throwable paramThrowable) {
/* 412 */     initCause(paramThrowable);
/* 413 */     return this;
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
/*     */   private StringBuilder a(StringBuilder paramStringBuilder) {
/* 445 */     b(paramStringBuilder);
/* 446 */     return paramStringBuilder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject, String paramString) {
/* 455 */     a(new a(paramObject, paramString));
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
/*     */   private void a(a parama) {
/* 469 */     if (this.b == null) {
/* 470 */       this.b = new LinkedList<>();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 476 */     if (this.b.size() < 1000) {
/* 477 */       this.b.addFirst(parama);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @p
/*     */   public final Object c() {
/* 489 */     return this.c;
/*     */   }
/*     */   
/*     */   public String getLocalizedMessage() {
/* 493 */     return d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessage() {
/* 502 */     return d();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String d() {
/* 508 */     String str = super.getMessage();
/* 509 */     if (this.b == null) {
/* 510 */       return str;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     StringBuilder stringBuilder;
/*     */ 
/*     */     
/* 518 */     (stringBuilder = (str == null) ? new StringBuilder() : new StringBuilder(str)).append(" (through reference chain: ");
/*     */     
/* 520 */     (stringBuilder = a(stringBuilder)).append(')');
/* 521 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 527 */     return getClass().getName() + ": " + getMessage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(StringBuilder paramStringBuilder) {
/* 538 */     if (this.b == null) {
/*     */       return;
/*     */     }
/* 541 */     Iterator<a> iterator = this.b.iterator();
/* 542 */     while (iterator.hasNext()) {
/* 543 */       paramStringBuilder.append(((a)iterator.next()).toString());
/* 544 */       if (iterator.hasNext())
/* 545 */         paramStringBuilder.append("->"); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */