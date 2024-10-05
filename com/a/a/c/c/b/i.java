/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.c.c.a.q;
/*     */ import com.a.a.c.c.s;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.c.x;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.m.a;
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class i<T>
/*     */   extends ae<T>
/*     */ {
/*     */   protected final j b;
/*     */   protected final s c;
/*     */   protected final boolean d;
/*     */   protected final Boolean e;
/*     */   
/*     */   protected i(j paramj, s params, Boolean paramBoolean) {
/*  52 */     super(paramj);
/*  53 */     this.b = paramj;
/*  54 */     this.e = paramBoolean;
/*  55 */     this.c = params;
/*  56 */     this.d = q.a(params);
/*     */   }
/*     */   
/*     */   protected i(j paramj) {
/*  60 */     this(paramj, (s)null, (Boolean)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected i(i<?> parami) {
/*  67 */     this(parami, parami.c, parami.e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected i(i<?> parami, s params, Boolean paramBoolean) {
/*  75 */     super(parami.b);
/*  76 */     this.b = parami.b;
/*  77 */     this.c = params;
/*  78 */     this.e = paramBoolean;
/*  79 */     this.d = q.a(params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j h() {
/*  89 */     return this.b;
/*     */   }
/*     */   
/*     */   public final Boolean a(f paramf) {
/*  93 */     return Boolean.TRUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final v a(String paramString) {
/*     */     k<Object> k;
/*  99 */     if ((k = g()) == null) {
/* 100 */       throw new IllegalArgumentException(String.format("Cannot handle managed/back reference '%s': type: container deserializer of type %s returned null for 'getContentDeserializer()'", new Object[] { paramString, 
/*     */               
/* 102 */               getClass().getName() }));
/*     */     }
/* 104 */     return k.a(paramString);
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
/*     */   public abstract k<Object> g();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a e() {
/* 133 */     return a.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object c(g paramg) {
/*     */     x x;
/* 139 */     if ((x = i()) == null || !x.l()) {
/* 140 */       j j1 = h();
/* 141 */       paramg.a(j1, 
/* 142 */           String.format("Cannot create empty instance of %s, no default Creator", new Object[] { j1 }));
/*     */     } 
/*     */     try {
/* 145 */       return x.a(paramg);
/* 146 */     } catch (IOException iOException) {
/* 147 */       return com.a.a.c.m.i.a(paramg, iOException);
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
/*     */   protected static <BOGUS> BOGUS a(g paramg, Throwable paramThrowable, Object paramObject, String paramString) {
/* 176 */     while (paramThrowable instanceof java.lang.reflect.InvocationTargetException && paramThrowable.getCause() != null) {
/* 177 */       paramThrowable = paramThrowable.getCause();
/*     */     }
/*     */     
/* 180 */     com.a.a.c.m.i.a(paramThrowable);
/*     */     
/* 182 */     if (paramg != null && !paramg.a(com.a.a.c.i.o)) {
/* 183 */       com.a.a.c.m.i.b(paramThrowable);
/*     */     }
/*     */     
/* 186 */     if (paramThrowable instanceof IOException && !(paramThrowable instanceof l)) {
/* 187 */       throw (IOException)paramThrowable;
/*     */     }
/*     */     
/* 190 */     throw l.a(paramThrowable, paramObject, 
/* 191 */         (String)com.a.a.c.m.i.a(paramString, "N/A"));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */