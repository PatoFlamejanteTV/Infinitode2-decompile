/*      */ package com.a.a.c.g;
/*      */ 
/*      */ import com.a.a.a.i;
/*      */ import com.a.a.c.aa;
/*      */ import com.a.a.c.b.q;
/*      */ import com.a.a.c.f;
/*      */ import com.a.a.c.f.f;
/*      */ import com.a.a.c.g;
/*      */ import com.a.a.c.j;
/*      */ import com.a.a.c.k.a.l;
/*      */ import com.a.a.c.k.q;
/*      */ import com.a.a.c.m.i;
/*      */ import com.a.a.c.m.n;
/*      */ import com.a.a.c.m.o;
/*      */ import com.a.a.c.m.w;
/*      */ import com.a.a.c.o;
/*      */ import java.lang.reflect.Method;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.concurrent.atomic.AtomicReference;
/*      */ 
/*      */ public class a {
/*      */   private final o<n, o<Object>> a;
/*      */   private final AtomicReference<l> b;
/*      */   
/*      */   public static String[] a(Class<?> paramClass) {
/*   28 */     return c.a().a(paramClass);
/*      */   }
/*      */ 
/*      */   
/*      */   public static f a(g paramg, com.a.a.c.b paramb, List<String> paramList) {
/*   33 */     return (new a(paramg, paramb))
/*   34 */       .a(paramList);
/*      */   }
/*      */   
/*      */   static class c
/*      */   {
/*      */     private final Method a;
/*      */     private final Method b;
/*      */     private final Method c;
/*      */     private static final c d;
/*      */     private static final RuntimeException e;
/*      */     
/*      */     static {
/*   46 */       RuntimeException runtimeException = null;
/*   47 */       c c1 = null;
/*      */       try {
/*   49 */         c1 = new c();
/*   50 */       } catch (RuntimeException runtimeException1) {
/*   51 */         runtimeException = runtimeException = null;
/*      */       } 
/*   53 */       d = c1;
/*   54 */       e = runtimeException;
/*      */     }
/*      */     
/*      */     private c() {
/*      */       try {
/*   59 */         this.a = Class.class.getMethod("getRecordComponents", new Class[0]);
/*   60 */         Class<?> clazz = Class.forName("java.lang.reflect.RecordComponent");
/*   61 */         this.b = clazz.getMethod("getName", new Class[0]);
/*   62 */         this.c = clazz.getMethod("getType", new Class[0]); return;
/*   63 */       } catch (Exception exception) {
/*   64 */         throw new RuntimeException(String.format("Failed to access Methods needed to support `java.lang.Record`: (%s) %s", new Object[] { exception
/*      */                 
/*   66 */                 .getClass().getName(), exception.getMessage() }), exception);
/*      */       } 
/*      */     }
/*      */     
/*      */     public static c a() {
/*   71 */       if (e != null) {
/*   72 */         throw e;
/*      */       }
/*   74 */       return d;
/*      */     }
/*      */ 
/*      */     
/*      */     public final String[] a(Class<?> param1Class) {
/*      */       Object[] arrayOfObject;
/*   80 */       if ((arrayOfObject = c(param1Class)) == null)
/*      */       {
/*   82 */         return null;
/*      */       }
/*   84 */       String[] arrayOfString = new String[arrayOfObject.length];
/*   85 */       for (byte b = 0; b < arrayOfObject.length; b++) {
/*      */         try {
/*   87 */           arrayOfString[b] = (String)this.b.invoke(arrayOfObject[b], new Object[0]);
/*   88 */         } catch (Exception exception) {
/*   89 */           throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", new Object[] {
/*      */                   
/*   91 */                   Integer.valueOf(b), Integer.valueOf(arrayOfObject.length), i.g(param1Class) }), exception);
/*      */         } 
/*      */       } 
/*   94 */       return (String[])exception;
/*      */     }
/*      */ 
/*      */     
/*      */     public final a.b[] b(Class<?> param1Class) {
/*      */       Object[] arrayOfObject;
/*  100 */       if ((arrayOfObject = c(param1Class)) == null)
/*      */       {
/*  102 */         return null;
/*      */       }
/*  104 */       a.b[] arrayOfB = new a.b[arrayOfObject.length];
/*  105 */       for (byte b = 0; b < arrayOfObject.length; b++) {
/*      */         String str; Class<?> clazz;
/*      */         try {
/*  108 */           str = (String)this.b.invoke(arrayOfObject[b], new Object[0]);
/*  109 */         } catch (Exception exception1) {
/*  110 */           throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", new Object[] {
/*      */                   
/*  112 */                   Integer.valueOf(b), Integer.valueOf(arrayOfObject.length), i.g(param1Class)
/*      */                 }), exception1);
/*      */         } 
/*      */         try {
/*  116 */           clazz = (Class)this.c.invoke(arrayOfObject[b], new Object[0]);
/*  117 */         } catch (Exception exception) {
/*  118 */           throw new IllegalArgumentException(String.format("Failed to access type of field #%d (of %d) of Record type %s", new Object[] {
/*      */                   
/*  120 */                   Integer.valueOf(b), Integer.valueOf(arrayOfObject.length), i.g(param1Class) }), exception);
/*      */         } 
/*  122 */         exception[b] = (Exception)new a.b(clazz, str);
/*      */       } 
/*  124 */       return (a.b[])exception;
/*      */     }
/*      */ 
/*      */     
/*      */     private Object[] c(Class<?> param1Class) {
/*      */       try {
/*  130 */         return (Object[])this.a.invoke(param1Class, new Object[0]);
/*  131 */       } catch (Exception exception2) {
/*  132 */         Exception exception1; if (w.a(exception1 = null)) {
/*  133 */           return null;
/*      */         }
/*  135 */         throw new IllegalArgumentException("Failed to access RecordComponents of type " + 
/*  136 */             i.g(param1Class));
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   static class b
/*      */   {
/*      */     public final Class<?> a;
/*      */     public final String b;
/*      */     
/*      */     public b(Class<?> param1Class, String param1String) {
/*  147 */       this.a = param1Class;
/*  148 */       this.b = param1String;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static class a
/*      */   {
/*      */     private com.a.a.c.b a;
/*      */     private f b;
/*      */     private com.a.a.c.a c;
/*      */     private List<f> d;
/*      */     private f e;
/*      */     private a.b[] f;
/*      */     
/*      */     a(g param1g, com.a.a.c.b param1b) {
/*  163 */       this.a = param1b;
/*      */       
/*  165 */       this.c = param1g.f();
/*  166 */       this.b = param1g.c();
/*      */       
/*  168 */       this.f = a.c.a().b(param1b.b());
/*  169 */       if (this.f == null) {
/*      */         
/*  171 */         this.d = param1b.k();
/*  172 */         this.e = null; return;
/*      */       } 
/*  174 */       int i = this.f.length;
/*      */ 
/*      */ 
/*      */       
/*  178 */       f f1 = null;
/*      */ 
/*      */       
/*  181 */       if (i == 0) {
/*  182 */         f1 = param1b.o();
/*  183 */         this.d = Collections.singletonList(f1);
/*      */       } else {
/*  185 */         this.d = param1b.k();
/*      */         Iterator<f> iterator;
/*  187 */         label25: for (iterator = this.d.iterator(); iterator.hasNext();) {
/*  188 */           if ((f2 = iterator.next()).f() == i) {
/*      */ 
/*      */             
/*  191 */             for (byte b1 = 0; b1 < i; ) {
/*  192 */               if (f2.a(b1).equals((this.f[b1]).a)) {
/*      */                 b1++; continue;
/*      */               }  continue label25;
/*      */             } 
/*  196 */             f1 = f2; break;
/*      */           } 
/*      */         } 
/*      */       } 
/*  200 */       if (f1 == null) {
/*  201 */         throw new IllegalArgumentException("Failed to find the canonical Record constructor of type " + 
/*  202 */             i.b(this.a.a()));
/*      */       }
/*  204 */       this.e = f1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final f a(List<String> param1List) {
/*  213 */       for (f f1 : this.d) {
/*  214 */         i.a a1 = this.c.a((q)this.b, (com.a.a.c.f.b)f1);
/*  215 */         if (a1 != null && i.a.d != a1) {
/*      */ 
/*      */ 
/*      */           
/*  219 */           if (i.a.b == a1) {
/*  220 */             return null;
/*      */           }
/*  222 */           if (f1 != this.e) {
/*  223 */             return null;
/*      */           }
/*      */         } 
/*      */       } 
/*  227 */       if (this.f == null)
/*      */       {
/*  229 */         return null;
/*      */       }
/*      */       a.b[] arrayOfB;
/*      */       int i;
/*      */       byte b1;
/*  234 */       for (i = (arrayOfB = this.f).length, b1 = 0; b1 < i; ) { a.b b2 = arrayOfB[b1];
/*  235 */         param1List.add(b2.b); b1++; }
/*      */       
/*  237 */       return this.e;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public a() {
/* 1047 */     this(4000);
/*      */   }
/*      */   
/*      */   private a(int paramInt) {
/* 1051 */     paramInt = Math.min(64, 1000);
/* 1052 */     this.a = new o(paramInt, 4000);
/* 1053 */     this.b = new AtomicReference<>();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public l a() {
/*      */     l l;
/* 1063 */     if ((l = this.b.get()) != null) {
/* 1064 */       return l;
/*      */     }
/* 1066 */     return b();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private synchronized l b() {
/*      */     l l;
/* 1073 */     if ((l = this.b.get()) == null) {
/* 1074 */       l = l.a(this.a);
/* 1075 */       this.b.set(l);
/*      */     } 
/* 1077 */     return l;
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
/*      */   public o<Object> b(Class<?> paramClass) {
/* 1096 */     synchronized (this) {
/* 1097 */       return (o<Object>)this.a.a(new n(paramClass, false));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public o<Object> a(j paramj) {
/* 1103 */     synchronized (this) {
/* 1104 */       return (o<Object>)this.a.a(new n(paramj, false));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public o<Object> b(j paramj) {
/* 1110 */     synchronized (this) {
/* 1111 */       return (o<Object>)this.a.a(new n(paramj, true));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public o<Object> c(Class<?> paramClass) {
/* 1117 */     synchronized (this) {
/* 1118 */       return (o<Object>)this.a.a(new n(paramClass, true));
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
/*      */ 
/*      */   
/*      */   public void a(j paramj, o<Object> paramo) {
/* 1135 */     synchronized (this) {
/* 1136 */       if (this.a.a(new n(paramj, true), paramo) == null)
/*      */       {
/* 1138 */         this.b.set(null);
/*      */       }
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(Class<?> paramClass, o<Object> paramo) {
/* 1145 */     synchronized (this) {
/* 1146 */       if (this.a.a(new n(paramClass, true), paramo) == null)
/*      */       {
/* 1148 */         this.b.set(null);
/*      */       }
/*      */       return;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(j paramj, o<Object> paramo, aa paramaa) {
/* 1176 */     synchronized (this) {
/* 1177 */       if (this.a.a(new n(paramj, false), paramo) == null) {
/* 1178 */         this.b.set(null);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1185 */       if (paramo instanceof q) {
/* 1186 */         ((q)paramo).a(paramaa);
/*      */       }
/*      */       return;
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
/*      */   public void a(Class<?> paramClass, j paramj, o<Object> paramo, aa paramaa) {
/* 1202 */     synchronized (this) {
/* 1203 */       Object object1 = this.a.a(new n(paramClass, false), paramo);
/* 1204 */       Object object2 = this.a.a(new n(paramj, false), paramo);
/* 1205 */       if (object1 == null || object2 == null) {
/* 1206 */         this.b.set(null);
/*      */       }
/* 1208 */       if (paramo instanceof q)
/* 1209 */         ((q)paramo).a(paramaa); 
/*      */       return;
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\g\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */