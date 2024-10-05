/*    */ package com.a.a.a;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class aq
/*    */   implements an
/*    */ {
/*    */   private Map<al.a, Object> a;
/*    */   
/*    */   public final void a(al.a parama, Object paramObject) {
/* 21 */     if (this.a == null) {
/* 22 */       this.a = new HashMap<al.a, Object>();
/*    */     } else {
/*    */       Object object;
/* 25 */       if ((object = this.a.get(parama)) != null) {
/*    */         
/* 27 */         if (object == paramObject) {
/*    */           return;
/*    */         }
/* 30 */         throw new IllegalStateException("Already had POJO for id (" + parama.a.getClass().getName() + ") [" + parama + "]");
/*    */       } 
/*    */     } 
/*    */     
/* 34 */     this.a.put(parama, paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public final Object a(al.a parama) {
/* 39 */     return (this.a == null) ? null : this.a.get(parama);
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean a(an paraman) {
/* 44 */     return (paraman.getClass() == getClass());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final an a() {
/* 51 */     return new aq();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\a\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */