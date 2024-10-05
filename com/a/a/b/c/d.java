/*     */ package com.a.a.b.c;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Objects;
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
/*     */ public final class d
/*     */   implements Serializable
/*     */ {
/*  35 */   private static d a = new d(false, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient Object b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d(boolean paramBoolean, Object paramObject) {
/*  80 */     this(paramBoolean, paramObject, -1, -1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private d(boolean paramBoolean, Object paramObject, int paramInt1, int paramInt2) {
/*  86 */     this.e = paramBoolean;
/*  87 */     this.b = paramObject;
/*  88 */     this.c = -1;
/*  89 */     this.d = -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static d a() {
/* 100 */     return a;
/*     */   }
/*     */   
/*     */   public static d a(boolean paramBoolean, Object paramObject) {
/* 104 */     return new d(paramBoolean, paramObject);
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
/*     */   private static d b(boolean paramBoolean, Object paramObject) {
/* 128 */     if (paramObject instanceof d) {
/* 129 */       return (d)paramObject;
/*     */     }
/* 131 */     return new d(false, paramObject);
/*     */   }
/*     */   
/*     */   public static d a(Object paramObject) {
/* 135 */     return b(false, paramObject);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b() {
/* 166 */     return this.e;
/*     */   }
/*     */   
/*     */   public final Object c() {
/* 170 */     return this.b;
/*     */   }
/*     */   
/* 173 */   private int e() { return this.c; } private int f() {
/* 174 */     return this.d;
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
/*     */ 
/*     */   
/*     */   public final String d() {
/* 200 */     return a(new StringBuilder(200)).toString();
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
/*     */   private StringBuilder a(StringBuilder paramStringBuilder) {
/*     */     Object object;
/* 215 */     if ((object = c()) == null) {
/* 216 */       paramStringBuilder.append("UNKNOWN");
/* 217 */       return paramStringBuilder;
/*     */     } 
/*     */     
/*     */     Class<?> clazz;
/*     */     
/*     */     String str;
/*     */     
/* 224 */     if ((str = (clazz = (object instanceof Class) ? (Class)object : object.getClass()).getName()).startsWith("java.")) {
/* 225 */       str = clazz.getSimpleName();
/* 226 */     } else if (object instanceof byte[]) {
/* 227 */       str = "byte[]";
/* 228 */     } else if (object instanceof char[]) {
/* 229 */       str = "char[]";
/*     */     } 
/* 231 */     paramStringBuilder.append('(').append(str).append(')');
/*     */ 
/*     */ 
/*     */     
/* 235 */     if (b()) {
/* 236 */       String str1 = " chars";
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 241 */       int[] arrayOfInt = { e(), f() };
/*     */       
/* 243 */       if (object instanceof CharSequence) {
/* 244 */         object = a((CharSequence)object, arrayOfInt, 500);
/* 245 */       } else if (object instanceof char[]) {
/* 246 */         object = a((char[])object, arrayOfInt, 500);
/* 247 */       } else if (object instanceof byte[]) {
/* 248 */         object = a((byte[])object, arrayOfInt, 500);
/* 249 */         str1 = " bytes";
/*     */       } else {
/* 251 */         object = null;
/*     */       } 
/* 253 */       if (object != null) {
/* 254 */         a(paramStringBuilder, (String)object);
/* 255 */         if (arrayOfInt[1] > 500) {
/* 256 */           paramStringBuilder.append("[truncated ").append(arrayOfInt[1] - 500).append(str1).append(']');
/*     */         }
/*     */       }
/*     */     
/*     */     }
/* 261 */     else if (object instanceof byte[]) {
/*     */       int i;
/*     */       
/* 264 */       if ((i = f()) < 0) {
/* 265 */         i = ((byte[])object).length;
/*     */       }
/* 267 */       paramStringBuilder.append('[')
/* 268 */         .append(i)
/* 269 */         .append(" bytes]");
/*     */     } 
/*     */     
/* 272 */     return paramStringBuilder;
/*     */   }
/*     */   
/*     */   private String a(CharSequence paramCharSequence, int[] paramArrayOfint, int paramInt) {
/* 276 */     a(paramArrayOfint, paramCharSequence.length());
/* 277 */     int j = paramArrayOfint[0];
/* 278 */     int i = Math.min(paramArrayOfint[1], paramInt);
/* 279 */     return paramCharSequence.subSequence(j, j + i).toString();
/*     */   }
/*     */   
/*     */   private String a(char[] paramArrayOfchar, int[] paramArrayOfint, int paramInt) {
/* 283 */     a(paramArrayOfint, paramArrayOfchar.length);
/* 284 */     int j = paramArrayOfint[0];
/* 285 */     int i = Math.min(paramArrayOfint[1], paramInt);
/* 286 */     return new String(paramArrayOfchar, j, i);
/*     */   }
/*     */   
/*     */   private String a(byte[] paramArrayOfbyte, int[] paramArrayOfint, int paramInt) {
/* 290 */     a(paramArrayOfint, paramArrayOfbyte.length);
/* 291 */     int j = paramArrayOfint[0];
/* 292 */     int i = Math.min(paramArrayOfint[1], paramInt);
/* 293 */     return new String(paramArrayOfbyte, j, i, Charset.forName("UTF-8"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(int[] paramArrayOfint, int paramInt) {
/*     */     int i;
/* 301 */     if ((i = paramArrayOfint[0]) < 0) {
/* 302 */       i = 0;
/* 303 */     } else if (i >= paramInt) {
/* 304 */       i = paramInt;
/*     */     } 
/* 306 */     paramArrayOfint[0] = i;
/*     */ 
/*     */     
/* 309 */     int j = paramArrayOfint[1];
/* 310 */     paramInt -= i;
/* 311 */     if (j < 0 || j > paramInt) {
/* 312 */       paramArrayOfint[1] = paramInt;
/*     */     }
/*     */   }
/*     */   
/*     */   private int a(StringBuilder paramStringBuilder, String paramString) {
/* 317 */     paramStringBuilder.append('"'); byte b;
/*     */     int i;
/* 319 */     for (b = 0, i = paramString.length(); b < i; b++) {
/*     */       char c;
/*     */ 
/*     */ 
/*     */       
/* 324 */       if (!Character.isISOControl(c = paramString.charAt(b)) || !a(paramStringBuilder, c)) {
/* 325 */         paramStringBuilder.append(c);
/*     */       }
/*     */     } 
/* 328 */     paramStringBuilder.append('"');
/* 329 */     return paramString.length();
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean a(StringBuilder paramStringBuilder, int paramInt) {
/* 334 */     if (paramInt == 13 || paramInt == 10) {
/* 335 */       return false;
/*     */     }
/* 337 */     paramStringBuilder.append('\\');
/* 338 */     paramStringBuilder.append('u');
/* 339 */     paramStringBuilder.append(b.c(paramInt >> 12 & 0xF));
/* 340 */     paramStringBuilder.append(b.c(paramInt >> 8 & 0xF));
/* 341 */     paramStringBuilder.append(b.c(paramInt >> 4 & 0xF));
/* 342 */     paramStringBuilder.append(b.c(paramInt & 0xF));
/* 343 */     return true;
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
/*     */   public final boolean equals(Object paramObject) {
/* 358 */     if (paramObject == this) return true; 
/* 359 */     if (paramObject == null) return false; 
/* 360 */     if (!(paramObject instanceof d)) return false; 
/* 361 */     paramObject = paramObject;
/*     */ 
/*     */     
/* 364 */     if (this.c != ((d)paramObject).c || this.d != ((d)paramObject).d)
/*     */     {
/* 366 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 372 */     Object object = ((d)paramObject).b;
/*     */     
/* 374 */     if (this.b == null)
/* 375 */       return (object == null); 
/* 376 */     if (object == null) {
/* 377 */       return false;
/*     */     }
/*     */     
/* 380 */     if (this.b instanceof java.io.File || this.b instanceof java.net.URL || this.b instanceof java.net.URI)
/*     */     {
/*     */ 
/*     */       
/* 384 */       return this.b.equals(object);
/*     */     }
/* 386 */     return (this.b == ((d)paramObject).b);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 392 */     return Objects.hashCode(this.b);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\c\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */