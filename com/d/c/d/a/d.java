/*    */ package com.d.c.d.a;
/*    */ 
/*    */ import com.d.c.a.a;
/*    */ import com.d.c.d.b;
/*    */ import com.d.c.d.j;
/*    */ import com.d.i.v;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public final class d
/*    */   extends a
/*    */ {
/* 31 */   private static final a[] a = new a[] { a.j, a.k };
/*    */   
/*    */   public final List a(a parama, List<j> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/*    */     v v1, v2;
/*    */     List<v> list;
/* 36 */     if ((list = a(a, paramList, paramInt, paramBoolean1, paramBoolean2)) != null) {
/* 37 */       return list;
/*    */     }
/*    */     
/* 40 */     a(a.bf, 1, 2, paramList.size());
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 45 */     if (paramList.size() == 1) {
/* 46 */       j j = paramList.get(0);
/* 47 */       j(parama, (com.d.c.d.d)j);
/* 48 */       if (j.f() < 0.0F) {
/* 49 */         throw new b("border-spacing may not be negative", -1);
/*    */       }
/* 51 */       v2 = new v(a.j, (com.d.c.d.d)j, paramBoolean1, paramInt);
/*    */       
/* 53 */       v1 = new v(a.k, (com.d.c.d.d)j, paramBoolean1, paramInt);
/*    */     } else {
/*    */       
/* 56 */       j j2 = paramList.get(0);
/* 57 */       j((a)v1, (com.d.c.d.d)j2);
/* 58 */       if (j2.f() < 0.0F) {
/* 59 */         throw new b("border-spacing may not be negative", -1);
/*    */       }
/* 61 */       v2 = new v(a.j, (com.d.c.d.d)j2, paramBoolean1, paramInt);
/*    */ 
/*    */       
/* 64 */       j j1 = paramList.get(1);
/* 65 */       j((a)v1, (com.d.c.d.d)j1);
/* 66 */       if (j1.f() < 0.0F) {
/* 67 */         throw new b("border-spacing may not be negative", -1);
/*    */       }
/* 69 */       v1 = new v(a.k, (com.d.c.d.d)j1, paramBoolean1, paramInt);
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 74 */     (list = new ArrayList<>(2)).add(v2);
/* 75 */     list.add(v1);
/*    */     
/* 77 */     return list;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */