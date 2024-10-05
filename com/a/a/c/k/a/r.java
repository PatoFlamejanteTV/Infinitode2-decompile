/*    */ package com.a.a.c.k.a;
/*    */ 
/*    */ import com.a.a.b.h;
/*    */ import com.a.a.c.aa;
/*    */ import com.a.a.c.i.i;
/*    */ import com.a.a.c.k.b.ar;
/*    */ import com.a.a.c.m.w;
/*    */ import com.a.a.c.z;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class r
/*    */   extends ar
/*    */ {
/*    */   public r() {
/* 17 */     super(Object.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public r(Class<?> paramClass) {
/* 22 */     super(paramClass);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void a(Object paramObject, h paramh, aa paramaa) {
/* 29 */     if (paramaa.a(z.c)) {
/* 30 */       b(paramaa, paramObject);
/*    */     }
/* 32 */     super.a(paramObject, paramh, paramaa);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void a(Object paramObject, h paramh, aa paramaa, i parami) {
/* 39 */     if (paramaa.a(z.c)) {
/* 40 */       b(paramaa, paramObject);
/*    */     }
/* 42 */     super.a(paramObject, paramh, paramaa, parami);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void b(aa paramaa, Object<?> paramObject) {
/* 48 */     if (w.a((Class)(paramObject = (Object<?>)paramObject.getClass()))) {
/* 49 */       paramaa.a(a(), String.format("No serializer found for class %s and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS). This appears to be a native image, in which case you may need to configure reflection for the class that is to be serialized", new Object[] { paramObject
/*    */               
/* 51 */               .getName() })); return;
/*    */     } 
/* 53 */     paramaa.a(a(), String.format("No serializer found for class %s and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)", new Object[] { paramObject
/*    */             
/* 55 */             .getName() }));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\a\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */