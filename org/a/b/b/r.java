/*    */ package org.a.b.b;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Stack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class r
/*    */ {
/*    */   public final List<Number> a(List<Object> paramList) {
/* 40 */     Stack<Number> stack = new Stack();
/* 41 */     for (Iterator<Object> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*    */       List<Number> list;
/* 43 */       if (list = (List<Number>)iterator.next() instanceof q) {
/*    */         
/* 45 */         list = a(stack, (q)list);
/* 46 */         stack.clear();
/* 47 */         if (list != null)
/*    */         {
/* 49 */           stack.addAll(list);
/*    */         }
/*    */         
/*    */         continue;
/*    */       } 
/* 54 */       stack.push((Number)list);
/*    */     } 
/*    */     
/* 57 */     return stack;
/*    */   }
/*    */   
/*    */   public abstract List<Number> a(List<Number> paramList, q paramq);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\b\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */