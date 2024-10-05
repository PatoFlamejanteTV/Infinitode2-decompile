/*     */ package com.a.a.c.l;
/*     */ 
/*     */ import com.a.a.b.f.a;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.n;
/*     */ import java.lang.reflect.TypeVariable;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class m
/*     */   extends j
/*     */   implements n
/*     */ {
/*  21 */   private static final n e = n.a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final j g;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final j[] h;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final n i;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private volatile transient String f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected m(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj, int paramInt, Object paramObject1, Object paramObject2, boolean paramBoolean) {
/*  49 */     super(paramClass, paramInt, paramObject1, paramObject2, paramBoolean);
/*  50 */     this.i = (paramn == null) ? e : paramn;
/*  51 */     this.g = paramj;
/*  52 */     this.h = paramArrayOfj;
/*     */   }
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
/*     */   public final String G() {
/*     */     String str;
/*  71 */     if ((str = this.f) == null) {
/*  72 */       str = I();
/*     */     }
/*  74 */     return str;
/*     */   }
/*     */   
/*     */   protected String I() {
/*  78 */     return this.a.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public n x() {
/*  89 */     return this.i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int w() {
/*  94 */     return this.i.c();
/*     */   }
/*     */ 
/*     */   
/*     */   public final j a(int paramInt) {
/*  99 */     return this.i.a(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j y() {
/* 110 */     return this.g;
/*     */   }
/*     */ 
/*     */   
/*     */   public final List<j> z() {
/* 115 */     if (this.h == null) {
/* 116 */       return Collections.emptyList();
/*     */     }
/* 118 */     switch (this.h.length) {
/*     */       case 0:
/* 120 */         return Collections.emptyList();
/*     */       case 1:
/* 122 */         return Collections.singletonList(this.h[0]);
/*     */     } 
/* 124 */     return Arrays.asList(this.h);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final j d(Class<?> paramClass) {
/* 130 */     if (paramClass == this.a) {
/* 131 */       return this;
/*     */     }
/*     */     
/* 134 */     if (paramClass.isInterface() && this.h != null) {
/* 135 */       byte b; int i; for (b = 0, i = this.h.length; b < i; b++) {
/*     */         j j2;
/* 137 */         if ((j2 = this.h[b].d(paramClass)) != null) {
/* 138 */           return j2;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     j j1;
/* 143 */     if (this.g != null && (
/*     */       
/* 145 */       j1 = this.g.d(paramClass)) != null) {
/* 146 */       return j1;
/*     */     }
/*     */     
/* 149 */     return null;
/*     */   }
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
/*     */   public final void a(h paramh, aa paramaa, i parami) {
/* 173 */     a a = new a(this, o.h);
/* 174 */     parami.a(paramh, a);
/* 175 */     a(paramh, paramaa);
/* 176 */     parami.b(paramh, a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(h paramh, aa paramaa) {
/* 183 */     paramh.b(G());
/*     */   }
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
/*     */   protected static StringBuilder a(Class<?> paramClass, StringBuilder paramStringBuilder, boolean paramBoolean) {
/* 199 */     if (paramClass.isPrimitive()) {
/* 200 */       if (paramClass == boolean.class) {
/* 201 */         paramStringBuilder.append('Z');
/* 202 */       } else if (paramClass == byte.class) {
/* 203 */         paramStringBuilder.append('B');
/*     */       }
/* 205 */       else if (paramClass == short.class) {
/* 206 */         paramStringBuilder.append('S');
/*     */       }
/* 208 */       else if (paramClass == char.class) {
/* 209 */         paramStringBuilder.append('C');
/*     */       }
/* 211 */       else if (paramClass == int.class) {
/* 212 */         paramStringBuilder.append('I');
/*     */       }
/* 214 */       else if (paramClass == long.class) {
/* 215 */         paramStringBuilder.append('J');
/*     */       }
/* 217 */       else if (paramClass == float.class) {
/* 218 */         paramStringBuilder.append('F');
/*     */       }
/* 220 */       else if (paramClass == double.class) {
/* 221 */         paramStringBuilder.append('D');
/*     */       }
/* 223 */       else if (paramClass == void.class) {
/* 224 */         paramStringBuilder.append('V');
/*     */       } else {
/* 226 */         throw new IllegalStateException("Unrecognized primitive type: " + paramClass.getName());
/*     */       } 
/*     */     } else {
/* 229 */       paramStringBuilder.append('L');
/* 230 */       String str = paramClass.getName(); byte b; int i;
/* 231 */       for (b = 0, i = str.length(); b < i; b++) {
/*     */         char c;
/* 233 */         if ((c = str.charAt(b)) == '.') c = '/'; 
/* 234 */         paramStringBuilder.append(c);
/*     */       } 
/* 236 */       if (paramBoolean) {
/* 237 */         paramStringBuilder.append(';');
/*     */       }
/*     */     } 
/* 240 */     return paramStringBuilder;
/*     */   }
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
/*     */   protected final boolean c(int paramInt) {
/*     */     TypeVariable[] arrayOfTypeVariable;
/* 262 */     return ((arrayOfTypeVariable = this.a.getTypeParameters()).length == paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\l\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */