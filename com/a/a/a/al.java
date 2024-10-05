/*     */ package com.a.a.a;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class al<T>
/*     */   implements Serializable
/*     */ {
/*     */   public abstract Class<?> a();
/*     */   
/*     */   public abstract boolean a(al<?> paramal);
/*     */   
/*     */   public abstract al<T> a(Class<?> paramClass);
/*     */   
/*     */   public abstract al<T> b();
/*     */   
/*     */   public abstract a a(Object paramObject);
/*     */   
/*     */   public abstract T b(Object paramObject);
/*     */   
/*     */   public static final class a
/*     */     implements Serializable
/*     */   {
/*     */     private Class<?> b;
/*     */     private Class<?> c;
/*     */     public final Object a;
/*     */     private final int d;
/*     */     
/*     */     public a(Class<?> param1Class1, Class<?> param1Class2, Object param1Object) {
/* 151 */       if (param1Object == null) {
/* 152 */         throw new IllegalArgumentException("Can not construct IdKey for null key");
/*     */       }
/* 154 */       this.b = param1Class1;
/* 155 */       this.c = param1Class2;
/* 156 */       this.a = param1Object;
/*     */       
/* 158 */       int i = param1Object.hashCode() + param1Class1.getName().hashCode();
/* 159 */       if (param1Class2 != null) {
/* 160 */         i ^= param1Class2.getName().hashCode();
/*     */       }
/* 162 */       this.d = i;
/*     */     }
/*     */     
/*     */     public final int hashCode() {
/* 166 */       return this.d;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 171 */       if (param1Object == this) return true; 
/* 172 */       if (param1Object == null) return false; 
/* 173 */       if (param1Object.getClass() != getClass()) return false;
/*     */       
/* 175 */       if (((a)(param1Object = param1Object)).a.equals(this.a) && ((a)param1Object).b == this.b && ((a)param1Object).c == this.c) return true;  return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 180 */       return String.format("[ObjectId: key=%s, type=%s, scope=%s]", new Object[] { this.a, (this.b == null) ? "NONE" : this.b
/* 181 */             .getName(), (this.c == null) ? "NONE" : this.c
/* 182 */             .getName() });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\a\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */