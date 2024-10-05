/*     */ package org.a.c.h.a.b.a;
/*     */ 
/*     */ import java.util.Stack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class j
/*     */ {
/*     */   static class b
/*     */     implements f
/*     */   {
/*     */     public final void a(a param1a) {
/*     */       Stack<Object> stack;
/*  35 */       Object object1 = (stack = param1a.a()).pop();
/*  36 */       Object object2 = stack.pop();
/*  37 */       boolean bool = a(object2, object1);
/*  38 */       stack.push(Boolean.valueOf(bool));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean a(Object param1Object1, Object param1Object2) {
/*     */       // Byte code:
/*     */       //   0: aload_1
/*     */       //   1: instanceof java/lang/Number
/*     */       //   4: ifeq -> 45
/*     */       //   7: aload_2
/*     */       //   8: instanceof java/lang/Number
/*     */       //   11: ifeq -> 45
/*     */       //   14: aload_1
/*     */       //   15: checkcast java/lang/Number
/*     */       //   18: astore_1
/*     */       //   19: aload_2
/*     */       //   20: checkcast java/lang/Number
/*     */       //   23: astore_2
/*     */       //   24: aload_1
/*     */       //   25: invokevirtual floatValue : ()F
/*     */       //   28: aload_2
/*     */       //   29: invokevirtual floatValue : ()F
/*     */       //   32: fcmpl
/*     */       //   33: ifne -> 40
/*     */       //   36: iconst_1
/*     */       //   37: goto -> 41
/*     */       //   40: iconst_0
/*     */       //   41: istore_1
/*     */       //   42: goto -> 51
/*     */       //   45: aload_1
/*     */       //   46: aload_2
/*     */       //   47: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */       //   50: istore_1
/*     */       //   51: iload_1
/*     */       //   52: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #44	-> 0
/*     */       //   #46	-> 14
/*     */       //   #47	-> 19
/*     */       //   #48	-> 24
/*     */       //   #49	-> 42
/*     */       //   #52	-> 45
/*     */       //   #54	-> 51
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static abstract class a
/*     */     implements f
/*     */   {
/*     */     private a() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(a param1a) {
/*     */       Stack<Object> stack;
/*  66 */       Object object1 = (stack = param1a.a()).pop();
/*     */       
/*  68 */       Object object2 = object2 = stack.pop();
/*  69 */       object1 = object1;
/*  70 */       boolean bool = a((Number)object2, (Number)object1);
/*  71 */       stack.push(Boolean.valueOf(bool));
/*     */     }
/*     */     
/*     */     protected abstract boolean a(Number param1Number1, Number param1Number2);
/*     */   }
/*     */   
/*     */   static class c extends a {
/*     */     c() {
/*  79 */       super((byte)0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final boolean a(Number param1Number1, Number param1Number2) {
/*  85 */       return (param1Number1.floatValue() >= param1Number2.floatValue());
/*     */     }
/*     */   }
/*     */   
/*     */   static class d extends a {
/*     */     d() {
/*  91 */       super((byte)0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final boolean a(Number param1Number1, Number param1Number2) {
/*  97 */       return (param1Number1.floatValue() > param1Number2.floatValue());
/*     */     }
/*     */   }
/*     */   
/*     */   static class e extends a {
/*     */     e() {
/* 103 */       super((byte)0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final boolean a(Number param1Number1, Number param1Number2) {
/* 109 */       return (param1Number1.floatValue() <= param1Number2.floatValue());
/*     */     }
/*     */   }
/*     */   
/*     */   static class f extends a {
/*     */     f() {
/* 115 */       super((byte)0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final boolean a(Number param1Number1, Number param1Number2) {
/* 121 */       return (param1Number1.floatValue() < param1Number2.floatValue());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class g
/*     */     extends b
/*     */   {
/*     */     protected final boolean a(Object param1Object1, Object param1Object2) {
/*     */       boolean bool;
/* 134 */       return !(bool = super.a(param1Object1, param1Object2));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\a\b\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */