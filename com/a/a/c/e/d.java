/*    */ package com.a.a.c.e;
/*    */ 
/*    */ import com.a.a.c.f.b;
/*    */ import com.a.a.c.f.n;
/*    */ import com.a.a.c.f.o;
/*    */ import com.a.a.c.w;
/*    */ import java.beans.ConstructorProperties;
/*    */ import java.beans.Transient;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class d
/*    */   extends c
/*    */ {
/*    */   public d() {
/* 22 */     Transient.class;
/* 23 */     ConstructorProperties.class;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final Boolean a(b paramb) {
/*    */     Transient transient_;
/* 30 */     if ((transient_ = (Transient)paramb.a(Transient.class)) != null) {
/* 31 */       return Boolean.valueOf(transient_.value());
/*    */     }
/* 33 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Boolean b(b paramb) {
/*    */     ConstructorProperties constructorProperties;
/* 41 */     if ((constructorProperties = (ConstructorProperties)paramb.a(ConstructorProperties.class)) != null) {
/* 42 */       return Boolean.TRUE;
/*    */     }
/* 44 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final w a(n paramn) {
/* 54 */     String[] arrayOfString = constructorProperties.value(); int i; ConstructorProperties constructorProperties;
/*    */     o o;
/* 56 */     if ((o = paramn.e()) != null && (constructorProperties = (ConstructorProperties)o.a(ConstructorProperties.class)) != null && (i = paramn.f()) < arrayOfString.length) {
/* 57 */       return w.a(arrayOfString[i]);
/*    */     }
/*    */ 
/*    */     
/* 61 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\e\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */