/*    */ package com.d.c.d.a;
/*    */ 
/*    */ import com.d.c.a.a;
/*    */ import com.d.c.a.c;
/*    */ import com.d.c.d.b;
/*    */ import com.d.c.d.d;
/*    */ import com.d.c.d.j;
/*    */ import com.d.i.v;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
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
/*    */ 
/*    */ 
/*    */ public final class n
/*    */   extends a
/*    */ {
/*    */   public final List a(a parama, List<j> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 38 */     if (paramList.size() == 1) {
/*    */       j j;
/* 40 */       if ((j = paramList.get(0)).e() == 0)
/* 41 */         return Collections.EMPTY_LIST;  c c;
/* 42 */       if (j.a() == 21 && (
/*    */         
/* 44 */         c = b((d)j)) == c.ap) {
/* 45 */         return Collections.singletonList(new v(a.ai, (d)j, paramBoolean1, paramInt));
/*    */       }
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 51 */     if (paramList.size() % 2 == 1) {
/* 52 */       throw new b("Mismatched quotes " + paramList, -1);
/*    */     }
/*    */ 
/*    */     
/* 56 */     ArrayList<j> arrayList = new ArrayList();
/* 57 */     for (Iterator<j> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*    */       j j;
/* 59 */       if ((j = iterator.next()).j() != null) {
/* 60 */         throw new b("Found unexpected operator, " + j
/* 61 */             .j().b(), -1);
/*    */       }
/*    */       
/*    */       short s;
/* 65 */       if ((s = j.a()) == 19) {
/* 66 */         arrayList.add(j); continue;
/* 67 */       }  if (s == 20) {
/* 68 */         throw new b("URI is not allowed here", -1);
/*    */       }
/* 70 */       if (j.i() == 7)
/* 71 */         throw new b("Function " + j
/* 72 */             .n().a() + " is not allowed here", -1); 
/* 73 */       if (s == 21) {
/* 74 */         throw new b("Identifier is not a valid value for the quotes property", -1);
/*    */       }
/*    */       
/* 77 */       throw new b(j
/* 78 */           .d() + " is not a value value for the quotes property", -1);
/*    */     } 
/*    */ 
/*    */     
/* 82 */     if (arrayList.size() > 0) {
/* 83 */       return Collections.singletonList(new v(a.ai, (d)new j(arrayList), paramBoolean1, paramInt));
/*    */     }
/*    */     
/* 86 */     return Collections.EMPTY_LIST;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\d\a\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */