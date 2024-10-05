/*    */ package com.a.a.c.a;
/*    */ 
/*    */ import java.lang.annotation.ElementType;
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
/*    */ import java.lang.annotation.Target;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
/*    */ @Retention(RetentionPolicy.RUNTIME)
/*    */ public @interface e
/*    */ {
/*    */   String a() default "build";
/*    */   
/*    */   String b() default "with";
/*    */   
/*    */   public static class a
/*    */   {
/*    */     public final String a;
/*    */     public final String b;
/*    */     
/*    */     public a(e param1e) {
/* 87 */       this(param1e.a(), param1e.b());
/*    */     }
/*    */ 
/*    */     
/*    */     private a(String param1String1, String param1String2) {
/* 92 */       this.a = param1String1;
/* 93 */       this.b = param1String2;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */