/*     */ package org.a.c.h.a.b.a;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
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
/*     */ final class k
/*     */ {
/*     */   static class a
/*     */     implements f
/*     */   {
/*     */     public final void a(a param1a) {
/*     */       Stack<Object> stack;
/*     */       int i;
/*  38 */       if ((i = ((Number)(stack = param1a.a()).pop()).intValue()) > 0) {
/*     */         
/*  40 */         int j = stack.size();
/*     */ 
/*     */         
/*  43 */         ArrayList<?> arrayList = new ArrayList(stack.subList(j - i, j));
/*  44 */         stack.addAll(arrayList);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class b
/*     */     implements f
/*     */   {
/*     */     public final void a(a param1a) {
/*     */       Stack<Object> stack;
/*  57 */       (stack = param1a.a()).push(stack.peek());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class c
/*     */     implements f
/*     */   {
/*     */     public final void a(a param1a) {
/*     */       Stack<Object> stack;
/*  69 */       Object object1 = (stack = param1a.a()).pop();
/*  70 */       Object object2 = stack.pop();
/*  71 */       stack.push(object1);
/*  72 */       stack.push(object2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class d
/*     */     implements f
/*     */   {
/*     */     public final void a(a param1a) {
/*     */       Stack<Object> stack;
/*     */       int i;
/*  85 */       if ((i = ((Number)(stack = param1a.a()).pop()).intValue()) < 0)
/*     */       {
/*  87 */         throw new IllegalArgumentException("rangecheck: " + i);
/*     */       }
/*  89 */       int j = stack.size();
/*  90 */       stack.push(stack.get(j - i - 1));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class e
/*     */     implements f
/*     */   {
/*     */     public final void a(a param1a) {
/*     */       Stack<Object> stack;
/* 102 */       (stack = param1a.a()).pop();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class f
/*     */     implements f
/*     */   {
/*     */     public final void a(a param1a) {
/*     */       Stack<Object> stack;
/* 114 */       int i = ((Number)(stack = param1a.a()).pop()).intValue();
/* 115 */       int j = ((Number)stack.pop()).intValue();
/* 116 */       if (i == 0) {
/*     */         return;
/*     */       }
/*     */       
/* 120 */       if (j < 0)
/*     */       {
/* 122 */         throw new IllegalArgumentException("rangecheck: " + j);
/*     */       }
/*     */       
/* 125 */       LinkedList<?> linkedList1 = new LinkedList();
/* 126 */       LinkedList<?> linkedList2 = new LinkedList();
/* 127 */       if (i < 0) {
/*     */ 
/*     */         
/* 130 */         j += i; int m;
/* 131 */         for (m = 0; m < j; m++)
/*     */         {
/* 133 */           linkedList2.addFirst(stack.pop());
/*     */         }
/* 135 */         for (m = i; m < 0; m++)
/*     */         {
/* 137 */           linkedList1.addFirst(stack.pop());
/*     */         }
/* 139 */         stack.addAll(linkedList2);
/* 140 */         stack.addAll(linkedList1);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 145 */       j -= i; int k;
/* 146 */       for (k = i; k > 0; k--)
/*     */       {
/* 148 */         linkedList1.addFirst(stack.pop());
/*     */       }
/* 150 */       for (k = 0; k < j; k++)
/*     */       {
/* 152 */         linkedList2.addFirst(stack.pop());
/*     */       }
/* 154 */       stack.addAll(linkedList1);
/* 155 */       stack.addAll(linkedList2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\a\b\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */