/*    */ package com.a.a.c.i;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class b
/*    */   implements Serializable
/*    */ {
/*    */   private Class<?> a;
/*    */   private int b;
/*    */   private String c;
/*    */   
/*    */   public b(Class<?> paramClass) {
/* 18 */     this(paramClass, null);
/*    */   }
/*    */   public b(Class<?> paramClass, String paramString) {
/* 21 */     this.a = paramClass;
/* 22 */     this.b = paramClass.getName().hashCode() + ((paramString == null) ? 0 : paramString.hashCode());
/* 23 */     a(paramString);
/*    */   }
/*    */   
/* 26 */   public final Class<?> a() { return this.a; }
/* 27 */   public final String b() { return this.c; } private void a(String paramString) {
/* 28 */     this.c = (paramString == null || paramString.isEmpty()) ? null : paramString;
/*    */   } public final boolean c() {
/* 30 */     return (this.c != null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 37 */     if (paramObject == this) return true; 
/* 38 */     if (paramObject == null) return false; 
/* 39 */     if (paramObject.getClass() != getClass()) return false; 
/* 40 */     paramObject = paramObject;
/* 41 */     if (this.a == ((b)paramObject).a && 
/* 42 */       Objects.equals(this.c, ((b)paramObject).c)) return true; 
/*    */     return false;
/*    */   }
/*    */   public final int hashCode() {
/* 46 */     return this.b;
/*    */   }
/*    */   
/*    */   public final String toString() {
/* 50 */     return "[NamedType, class " + this.a.getName() + ", name: " + ((this.c == null) ? "null" : ("'" + this.c + "'")) + "]";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\i\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */