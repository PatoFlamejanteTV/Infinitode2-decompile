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
/*     */ final class b
/*     */ {
/*     */   static abstract class a
/*     */     implements f
/*     */   {
/*     */     private a() {}
/*     */     
/*     */     public final void a(a param1a) {
/*     */       boolean bool1, bool2;
/*     */       Stack<Object> stack;
/*  35 */       Object object1 = (stack = param1a.a()).pop();
/*     */       Object object2;
/*  37 */       if (object2 = stack.pop() instanceof Boolean && object1 instanceof Boolean) {
/*     */         
/*  39 */         bool2 = ((Boolean)object2).booleanValue();
/*  40 */         bool1 = ((Boolean)object1).booleanValue();
/*  41 */         bool1 = a(bool2, bool1);
/*  42 */         stack.push(Boolean.valueOf(bool1)); return;
/*     */       } 
/*  44 */       if (bool2 instanceof Integer && bool1 instanceof Integer) {
/*     */         
/*  46 */         int j = ((Integer)bool2).intValue();
/*  47 */         int i = ((Integer)bool1).intValue();
/*  48 */         i = a(j, i);
/*  49 */         stack.push(Integer.valueOf(i));
/*     */         
/*     */         return;
/*     */       } 
/*  53 */       throw new ClassCastException("Operands must be bool/bool or int/int");
/*     */     }
/*     */     
/*     */     protected abstract boolean a(boolean param1Boolean1, boolean param1Boolean2);
/*     */     
/*     */     protected abstract int a(int param1Int1, int param1Int2);
/*     */   }
/*     */   
/*     */   static class b
/*     */     extends a
/*     */   {
/*     */     b() {
/*  65 */       super((byte)0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final boolean a(boolean param1Boolean1, boolean param1Boolean2) {
/*  71 */       return param1Boolean1 & param1Boolean2;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final int a(int param1Int1, int param1Int2) {
/*  77 */       return param1Int1 & param1Int2;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class c
/*     */     implements f
/*     */   {
/*     */     public final void a(a param1a) {
/*     */       Stack<Object> stack;
/*  88 */       int i = ((Integer)(stack = param1a.a()).pop()).intValue();
/*  89 */       int j = ((Integer)stack.pop()).intValue();
/*  90 */       if (i < 0) {
/*     */         
/*  92 */         i = j >> Math.abs(i);
/*  93 */         stack.push(Integer.valueOf(i));
/*     */         
/*     */         return;
/*     */       } 
/*  97 */       i = j << i;
/*  98 */       stack.push(Integer.valueOf(i));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class d
/*     */     implements f
/*     */   {
/*     */     public final void a(a param1a) {
/*     */       Stack<Object> stack;
/* 111 */       (stack = param1a.a()).push(Boolean.FALSE);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class e
/*     */     implements f
/*     */   {
/*     */     public final void a(a param1a) {
/*     */       boolean bool;
/*     */       Stack<Object> stack;
/*     */       Object object;
/* 124 */       if (object = (stack = param1a.a()).pop() instanceof Boolean) {
/*     */ 
/*     */         
/* 127 */         bool = !(bool = ((Boolean)object).booleanValue());
/* 128 */         stack.push(Boolean.valueOf(bool)); return;
/*     */       } 
/* 130 */       if (bool instanceof Integer) {
/*     */ 
/*     */         
/* 133 */         int i = -(i = ((Integer)bool).intValue());
/* 134 */         stack.push(Integer.valueOf(i));
/*     */         
/*     */         return;
/*     */       } 
/* 138 */       throw new ClassCastException("Operand must be bool or int");
/*     */     }
/*     */   }
/*     */   
/*     */   static class f
/*     */     extends a {
/*     */     f() {
/* 145 */       super((byte)0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final boolean a(boolean param1Boolean1, boolean param1Boolean2) {
/* 151 */       return param1Boolean1 | param1Boolean2;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final int a(int param1Int1, int param1Int2) {
/* 157 */       return param1Int1 | param1Int2;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class g
/*     */     implements f
/*     */   {
/*     */     public final void a(a param1a) {
/*     */       Stack<Object> stack;
/* 169 */       (stack = param1a.a()).push(Boolean.TRUE);
/*     */     }
/*     */   }
/*     */   
/*     */   static class h extends a {
/*     */     h() {
/* 175 */       super((byte)0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final boolean a(boolean param1Boolean1, boolean param1Boolean2) {
/* 181 */       return param1Boolean1 ^ param1Boolean2;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final int a(int param1Int1, int param1Int2) {
/* 187 */       return param1Int1 ^ param1Int2;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\a\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */