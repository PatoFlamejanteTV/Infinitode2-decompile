/*      */ package org.a.c.h.a.b.a;
/*      */ 
/*      */ import java.util.Stack;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class a
/*      */ {
/*      */   private final g a;
/*      */   
/*      */   static class a
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*      */       Number number;
/*   35 */       if (number = param1a.c() instanceof Integer) {
/*      */         
/*   37 */         param1a.a().push(Integer.valueOf(Math.abs(number.intValue())));
/*      */         
/*      */         return;
/*      */       } 
/*   41 */       param1a.a().push(Float.valueOf(Math.abs(number.floatValue())));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class b
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*   53 */       Number number1 = param1a.c();
/*      */       Number number2;
/*   55 */       if (number2 = param1a.c() instanceof Integer && number1 instanceof Integer) {
/*      */         long l;
/*      */         
/*   58 */         if ((l = number2.longValue() + number1.longValue()) < -2147483648L || l > 2147483647L) {
/*      */           
/*   60 */           param1a.a().push(Float.valueOf((float)l));
/*      */         }
/*      */         else {
/*      */           
/*   64 */           param1a.a().push(Integer.valueOf((int)l));
/*      */           
/*      */           return;
/*      */         } 
/*      */       } else {
/*   69 */         float f1 = number2.floatValue() + number1.floatValue();
/*   70 */         param1a.a().push(Float.valueOf(f1));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class c
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*   82 */       float f1 = param1a.e();
/*      */       
/*      */       float f2;
/*      */       
/*   86 */       if ((f1 = (float)Math.toDegrees((f1 = (float)Math.atan2((f2 = param1a.e()), f1))) % 360.0F) < 0.0F)
/*      */       {
/*   88 */         f1 += 360.0F;
/*      */       }
/*   90 */       param1a.a().push(Float.valueOf(f1));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class d
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*      */       Number number;
/*  102 */       if (number = param1a.c() instanceof Integer) {
/*      */         
/*  104 */         param1a.a().push(number);
/*      */         
/*      */         return;
/*      */       } 
/*  108 */       param1a.a().push(Float.valueOf((float)Math.ceil(number.doubleValue())));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class e
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*  121 */       float f1 = (float)Math.cos(Math.toRadians((f1 = param1a.e())));
/*  122 */       param1a.a().push(Float.valueOf(f1));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class f
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*  133 */       Number number = param1a.c();
/*  134 */       param1a.a().push(Integer.valueOf(number.intValue()));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class g
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*  145 */       Number number = param1a.c();
/*  146 */       param1a.a().push(Float.valueOf(number.floatValue()));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class h
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*  157 */       Number number1 = param1a.c();
/*  158 */       Number number2 = param1a.c();
/*  159 */       param1a.a().push(Float.valueOf(number2.floatValue() / number1.floatValue()));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class i
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*  170 */       Number number1 = param1a.c();
/*      */       Number number2;
/*  172 */       double d = Math.pow((number2 = param1a.c()).doubleValue(), number1.doubleValue());
/*  173 */       param1a.a().push(Float.valueOf((float)d));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class j
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*      */       Number number;
/*  185 */       if (number = param1a.c() instanceof Integer) {
/*      */         
/*  187 */         param1a.a().push(number);
/*      */         
/*      */         return;
/*      */       } 
/*  191 */       param1a.a().push(Float.valueOf((float)Math.floor(number.doubleValue())));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class k
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*  203 */       int i = param1a.d();
/*  204 */       int j = param1a.d();
/*  205 */       param1a.a().push(Integer.valueOf(j / i));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class l
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*  216 */       Number number = param1a.c();
/*  217 */       param1a.a().push(Float.valueOf((float)Math.log(number.doubleValue())));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class m
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*  228 */       Number number = param1a.c();
/*  229 */       param1a.a().push(Float.valueOf((float)Math.log10(number.doubleValue())));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class n
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*  240 */       int i = param1a.d();
/*  241 */       int j = param1a.d();
/*  242 */       param1a.a().push(Integer.valueOf(j % i));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class o
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*  253 */       Number number1 = param1a.c();
/*      */       Number number2;
/*  255 */       if (number2 = param1a.c() instanceof Integer && number1 instanceof Integer) {
/*      */         long l;
/*      */         
/*  258 */         if ((l = number2.longValue() * number1.longValue()) >= -2147483648L && l <= 2147483647L) {
/*      */           
/*  260 */           param1a.a().push(Integer.valueOf((int)l));
/*      */         }
/*      */         else {
/*      */           
/*  264 */           param1a.a().push(Float.valueOf((float)l));
/*      */           
/*      */           return;
/*      */         } 
/*      */       } else {
/*  269 */         double d = number2.doubleValue() * number1.doubleValue();
/*  270 */         param1a.a().push(Float.valueOf((float)d));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class p
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*      */       Number number;
/*  283 */       if (number = param1a.c() instanceof Integer) {
/*      */         int i;
/*      */         
/*  286 */         if ((i = number.intValue()) == Integer.MIN_VALUE) {
/*      */           
/*  288 */           param1a.a().push(Float.valueOf(-number.floatValue()));
/*      */         }
/*      */         else {
/*      */           
/*  292 */           param1a.a().push(Integer.valueOf(-number.intValue()));
/*      */           
/*      */           return;
/*      */         } 
/*      */       } else {
/*  297 */         param1a.a().push(Float.valueOf(-number.floatValue()));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class q
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*      */       Number number;
/*  310 */       if (number = param1a.c() instanceof Integer) {
/*      */         
/*  312 */         param1a.a().push(Integer.valueOf(number.intValue()));
/*      */         
/*      */         return;
/*      */       } 
/*  316 */       param1a.a().push(Float.valueOf((float)Math.round(number.doubleValue())));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class r
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*  329 */       float f1 = (float)Math.sin(Math.toRadians((f1 = param1a.e())));
/*  330 */       param1a.a().push(Float.valueOf(f1));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class s
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*      */       float f1;
/*  342 */       if ((f1 = param1a.e()) < 0.0F)
/*      */       {
/*  344 */         throw new IllegalArgumentException("argument must be nonnegative");
/*      */       }
/*  346 */       param1a.a().push(Float.valueOf((float)Math.sqrt(f1)));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class t
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*  357 */       Stack<Object> stack = param1a.a();
/*  358 */       Number number2 = param1a.c();
/*      */       Number number1;
/*  360 */       if (number1 = param1a.c() instanceof Integer && number2 instanceof Integer) {
/*      */         long l;
/*      */         
/*  363 */         if ((l = number1.longValue() - number2.longValue()) < -2147483648L || l > 2147483647L) {
/*      */           
/*  365 */           stack.push(Float.valueOf((float)l));
/*      */         }
/*      */         else {
/*      */           
/*  369 */           stack.push(Integer.valueOf((int)l));
/*      */           
/*      */           return;
/*      */         } 
/*      */       } else {
/*  374 */         float f1 = number1.floatValue() - number2.floatValue();
/*  375 */         stack.push(Float.valueOf(f1));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class u
/*      */     implements f
/*      */   {
/*      */     public final void a(a param1a) {
/*      */       Number number;
/*  388 */       if (number = param1a.c() instanceof Integer) {
/*      */         
/*  390 */         param1a.a().push(Integer.valueOf(number.intValue()));
/*      */         
/*      */         return;
/*      */       } 
/*  394 */       param1a.a().push(Float.valueOf((int)number.floatValue()));
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
/* 1029 */   private final Stack<Object> b = new Stack();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public a(g paramg) {
/* 1037 */     this.a = paramg;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Stack<Object> a() {
/* 1046 */     return this.b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public g b() {
/* 1055 */     return this.a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Number c() {
/* 1065 */     return (Number)this.b.pop();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int d() {
/* 1075 */     return ((Integer)this.b.pop()).intValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float e() {
/* 1085 */     return ((Number)this.b.pop()).floatValue();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\a\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */