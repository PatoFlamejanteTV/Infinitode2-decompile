/*     */ package com.prineside.luaj.lib.jse;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.luaj.Varargs;
/*     */ import com.prineside.luaj.lib.VarArgFunction;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.lang.reflect.Array;
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
/*     */ public abstract class JavaMember
/*     */   extends VarArgFunction
/*     */ {
/*     */   private CoerceLuaToJava.Coercion[] a;
/*     */   @Null
/*     */   private CoerceLuaToJava.ArrayCoercion b;
/*     */   
/*     */   static {
/*  46 */     TLog.forClass(JavaMember.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected JavaMember(Class<?>[] paramArrayOfClass, int paramInt) {
/*  57 */     paramInt = ((paramInt & 0x80) != 0) ? 1 : 0;
/*  58 */     this.a = new CoerceLuaToJava.Coercion[(paramInt != 0) ? (paramArrayOfClass.length - 1) : paramArrayOfClass.length];
/*  59 */     for (byte b = 0; b < this.a.length; b++) {
/*  60 */       this.a[b] = CoerceLuaToJava.a(paramArrayOfClass[b]);
/*     */     }
/*  62 */     if (paramInt != 0) {
/*     */       Class<?> clazz;
/*  64 */       if ((clazz = paramArrayOfClass[paramArrayOfClass.length - 1]).isArray()) {
/*  65 */         this.b = new CoerceLuaToJava.ArrayCoercion(clazz.getComponentType());
/*     */       } else {
/*  67 */         throw new IllegalArgumentException("Last parameter '" + clazz + "' is not an array in a vararg member");
/*     */       } 
/*     */     } else {
/*  70 */       this.b = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   final long a(Varargs paramVarargs) {
/*     */     long l;
/*     */     int i;
/*  78 */     if ((i = paramVarargs.narg()) == 0 && this.a.length == 0 && this.b == null)
/*     */     {
/*     */       
/*  81 */       return 0L;
/*     */     }
/*     */ 
/*     */     
/*  85 */     if (i > this.a.length) {
/*  86 */       l = CoerceLuaToJava.b * (i - this.a.length);
/*     */     } else {
/*     */       
/*  89 */       l = 0L;
/*     */     } 
/*     */ 
/*     */     
/*  93 */     if (i == 0 && this.b != null)
/*     */     {
/*  95 */       l++;
/*     */     }
/*     */ 
/*     */     
/*  99 */     if (i < this.a.length) {
/* 100 */       l += (this.a.length - i) * CoerceLuaToJava.d;
/*     */     }
/*     */     
/*     */     int j;
/* 104 */     for (j = 0; j < this.a.length; j++) {
/* 105 */       int k = this.a[j].score(paramVarargs.arg(j + 1));
/* 106 */       l += k;
/*     */     } 
/*     */ 
/*     */     
/* 110 */     if (this.b != null) {
/* 111 */       for (j = this.a.length; j < i; j++) {
/* 112 */         int k = this.b.score(paramVarargs.arg(j + 1));
/* 113 */         l += k;
/*     */       } 
/*     */     }
/*     */     
/* 117 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final Object[] b(Varargs paramVarargs) {
/*     */     Object[] arrayOfObject;
/* 123 */     if (this.b == null) {
/*     */       
/* 125 */       arrayOfObject = new Object[this.a.length];
/* 126 */       for (byte b = 0; b < arrayOfObject.length; b++) {
/* 127 */         arrayOfObject[b] = this.a[b].coerce(paramVarargs.arg(b + 1));
/*     */       }
/*     */     } else {
/* 130 */       int i = Math.max(this.a.length, paramVarargs.narg());
/* 131 */       arrayOfObject = new Object[this.a.length + 1];
/* 132 */       for (byte b1 = 0; b1 < this.a.length; b1++) {
/* 133 */         arrayOfObject[b1] = this.a[b1].coerce(paramVarargs.arg(b1 + 1));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 138 */       Object object = Array.newInstance(this.b.a, i - this.a.length);
/* 139 */       arrayOfObject[arrayOfObject.length - 1] = object;
/*     */       
/* 141 */       byte b2 = 0;
/* 142 */       for (int j = this.a.length; j < i; j++) {
/*     */         
/* 144 */         Object object1 = this.b.b.coerce(paramVarargs.arg(j + 1));
/* 145 */         Array.set(object, b2, object1);
/*     */         
/* 147 */         b2++;
/*     */       } 
/*     */     } 
/* 150 */     return arrayOfObject;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\jse\JavaMember.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */