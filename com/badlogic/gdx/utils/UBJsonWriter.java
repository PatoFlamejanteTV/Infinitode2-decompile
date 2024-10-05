/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
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
/*     */ public class UBJsonWriter
/*     */   implements Closeable
/*     */ {
/*     */   final DataOutputStream out;
/*     */   private JsonObject current;
/*     */   private boolean named;
/*  32 */   private final Array<JsonObject> stack = new Array<>();
/*     */   
/*     */   public UBJsonWriter(OutputStream paramOutputStream) {
/*  35 */     if (!(paramOutputStream instanceof DataOutputStream)) paramOutputStream = new DataOutputStream(paramOutputStream); 
/*  36 */     this.out = (DataOutputStream)paramOutputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter object() {
/*  42 */     if (this.current != null && 
/*  43 */       !this.current.array) {
/*  44 */       if (!this.named) throw new IllegalStateException("Name must be set."); 
/*  45 */       this.named = false;
/*     */     } 
/*     */     
/*  48 */     this.stack.add(this.current = new JsonObject(false));
/*  49 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter object(String paramString) {
/*  55 */     name(paramString).object();
/*  56 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter array() {
/*  62 */     if (this.current != null && 
/*  63 */       !this.current.array) {
/*  64 */       if (!this.named) throw new IllegalStateException("Name must be set."); 
/*  65 */       this.named = false;
/*     */     } 
/*     */     
/*  68 */     this.stack.add(this.current = new JsonObject(true));
/*  69 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter array(String paramString) {
/*  75 */     name(paramString).array();
/*  76 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter name(String paramString) {
/*  82 */     if (this.current == null || this.current.array) throw new IllegalStateException("Current item must be an object."); 
/*     */     byte[] arrayOfByte;
/*  84 */     if ((arrayOfByte = paramString.getBytes("UTF-8")).length <= 127) {
/*  85 */       this.out.writeByte(105);
/*  86 */       this.out.writeByte(arrayOfByte.length);
/*  87 */     } else if (arrayOfByte.length <= 32767) {
/*  88 */       this.out.writeByte(73);
/*  89 */       this.out.writeShort(arrayOfByte.length);
/*     */     } else {
/*  91 */       this.out.writeByte(108);
/*  92 */       this.out.writeInt(arrayOfByte.length);
/*     */     } 
/*  94 */     this.out.write(arrayOfByte);
/*  95 */     this.named = true;
/*  96 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(byte paramByte) {
/* 102 */     checkName();
/* 103 */     this.out.writeByte(105);
/* 104 */     this.out.writeByte(paramByte);
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(short paramShort) {
/* 111 */     checkName();
/* 112 */     this.out.writeByte(73);
/* 113 */     this.out.writeShort(paramShort);
/* 114 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(int paramInt) {
/* 120 */     checkName();
/* 121 */     this.out.writeByte(108);
/* 122 */     this.out.writeInt(paramInt);
/* 123 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(long paramLong) {
/* 129 */     checkName();
/* 130 */     this.out.writeByte(76);
/* 131 */     this.out.writeLong(paramLong);
/* 132 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(float paramFloat) {
/* 139 */     checkName();
/* 140 */     this.out.writeByte(100);
/* 141 */     this.out.writeFloat(paramFloat);
/* 142 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(double paramDouble) {
/* 149 */     checkName();
/* 150 */     this.out.writeByte(68);
/* 151 */     this.out.writeDouble(paramDouble);
/* 152 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(boolean paramBoolean) {
/* 159 */     checkName();
/* 160 */     this.out.writeByte(paramBoolean ? 84 : 70);
/* 161 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(char paramChar) {
/* 168 */     checkName();
/* 169 */     this.out.writeByte(73);
/* 170 */     this.out.writeChar(paramChar);
/* 171 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(String paramString) {
/* 178 */     checkName();
/* 179 */     byte[] arrayOfByte = paramString.getBytes("UTF-8");
/* 180 */     this.out.writeByte(83);
/* 181 */     if (arrayOfByte.length <= 127) {
/* 182 */       this.out.writeByte(105);
/* 183 */       this.out.writeByte(arrayOfByte.length);
/* 184 */     } else if (arrayOfByte.length <= 32767) {
/* 185 */       this.out.writeByte(73);
/* 186 */       this.out.writeShort(arrayOfByte.length);
/*     */     } else {
/* 188 */       this.out.writeByte(108);
/* 189 */       this.out.writeInt(arrayOfByte.length);
/*     */     } 
/* 191 */     this.out.write(arrayOfByte);
/* 192 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(byte[] paramArrayOfbyte) {
/* 199 */     array();
/* 200 */     this.out.writeByte(36);
/* 201 */     this.out.writeByte(105);
/* 202 */     this.out.writeByte(35);
/* 203 */     value(paramArrayOfbyte.length); byte b; int i;
/* 204 */     for (b = 0, i = paramArrayOfbyte.length; b < i; b++) {
/* 205 */       this.out.writeByte(paramArrayOfbyte[b]);
/*     */     }
/* 207 */     pop(true);
/* 208 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(short[] paramArrayOfshort) {
/* 215 */     array();
/* 216 */     this.out.writeByte(36);
/* 217 */     this.out.writeByte(73);
/* 218 */     this.out.writeByte(35);
/* 219 */     value(paramArrayOfshort.length); byte b; int i;
/* 220 */     for (b = 0, i = paramArrayOfshort.length; b < i; b++) {
/* 221 */       this.out.writeShort(paramArrayOfshort[b]);
/*     */     }
/* 223 */     pop(true);
/* 224 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(int[] paramArrayOfint) {
/* 231 */     array();
/* 232 */     this.out.writeByte(36);
/* 233 */     this.out.writeByte(108);
/* 234 */     this.out.writeByte(35);
/* 235 */     value(paramArrayOfint.length); byte b; int i;
/* 236 */     for (b = 0, i = paramArrayOfint.length; b < i; b++) {
/* 237 */       this.out.writeInt(paramArrayOfint[b]);
/*     */     }
/* 239 */     pop(true);
/* 240 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(long[] paramArrayOflong) {
/* 247 */     array();
/* 248 */     this.out.writeByte(36);
/* 249 */     this.out.writeByte(76);
/* 250 */     this.out.writeByte(35);
/* 251 */     value(paramArrayOflong.length); byte b; int i;
/* 252 */     for (b = 0, i = paramArrayOflong.length; b < i; b++) {
/* 253 */       this.out.writeLong(paramArrayOflong[b]);
/*     */     }
/* 255 */     pop(true);
/* 256 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(float[] paramArrayOffloat) {
/* 263 */     array();
/* 264 */     this.out.writeByte(36);
/* 265 */     this.out.writeByte(100);
/* 266 */     this.out.writeByte(35);
/* 267 */     value(paramArrayOffloat.length); byte b; int i;
/* 268 */     for (b = 0, i = paramArrayOffloat.length; b < i; b++) {
/* 269 */       this.out.writeFloat(paramArrayOffloat[b]);
/*     */     }
/* 271 */     pop(true);
/* 272 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(double[] paramArrayOfdouble) {
/* 280 */     array();
/* 281 */     this.out.writeByte(36);
/* 282 */     this.out.writeByte(68);
/* 283 */     this.out.writeByte(35);
/* 284 */     value(paramArrayOfdouble.length); byte b; int i;
/* 285 */     for (b = 0, i = paramArrayOfdouble.length; b < i; b++) {
/* 286 */       this.out.writeDouble(paramArrayOfdouble[b]);
/*     */     }
/* 288 */     pop(true);
/* 289 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(boolean[] paramArrayOfboolean) {
/* 295 */     array(); byte b; int i;
/* 296 */     for (b = 0, i = paramArrayOfboolean.length; b < i; b++) {
/* 297 */       this.out.writeByte(paramArrayOfboolean[b] ? 84 : 70);
/*     */     }
/* 299 */     pop();
/* 300 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(char[] paramArrayOfchar) {
/* 307 */     array();
/* 308 */     this.out.writeByte(36);
/* 309 */     this.out.writeByte(67);
/* 310 */     this.out.writeByte(35);
/* 311 */     value(paramArrayOfchar.length); byte b; int i;
/* 312 */     for (b = 0, i = paramArrayOfchar.length; b < i; b++) {
/* 313 */       this.out.writeChar(paramArrayOfchar[b]);
/*     */     }
/* 315 */     pop(true);
/* 316 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(String[] paramArrayOfString) {
/* 323 */     array();
/* 324 */     this.out.writeByte(36);
/* 325 */     this.out.writeByte(83);
/* 326 */     this.out.writeByte(35);
/* 327 */     value(paramArrayOfString.length); byte b; int i;
/* 328 */     for (b = 0, i = paramArrayOfString.length; b < i; b++) {
/*     */       byte[] arrayOfByte;
/* 330 */       if ((arrayOfByte = paramArrayOfString[b].getBytes("UTF-8")).length <= 127) {
/* 331 */         this.out.writeByte(105);
/* 332 */         this.out.writeByte(arrayOfByte.length);
/* 333 */       } else if (arrayOfByte.length <= 32767) {
/* 334 */         this.out.writeByte(73);
/* 335 */         this.out.writeShort(arrayOfByte.length);
/*     */       } else {
/* 337 */         this.out.writeByte(108);
/* 338 */         this.out.writeInt(arrayOfByte.length);
/*     */       } 
/* 340 */       this.out.write(arrayOfByte);
/*     */     } 
/* 342 */     pop(true);
/* 343 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(JsonValue paramJsonValue) {
/* 349 */     if (paramJsonValue.isObject()) {
/* 350 */       if (paramJsonValue.name != null) {
/* 351 */         object(paramJsonValue.name);
/*     */       } else {
/* 353 */         object();
/* 354 */       }  for (paramJsonValue = paramJsonValue.child; paramJsonValue != null; paramJsonValue = paramJsonValue.next)
/* 355 */         value(paramJsonValue); 
/* 356 */       pop();
/* 357 */     } else if (paramJsonValue.isArray()) {
/* 358 */       if (paramJsonValue.name != null) {
/* 359 */         array(paramJsonValue.name);
/*     */       } else {
/* 361 */         array();
/* 362 */       }  for (paramJsonValue = paramJsonValue.child; paramJsonValue != null; paramJsonValue = paramJsonValue.next)
/* 363 */         value(paramJsonValue); 
/* 364 */       pop();
/* 365 */     } else if (paramJsonValue.isBoolean()) {
/* 366 */       if (paramJsonValue.name != null) name(paramJsonValue.name); 
/* 367 */       value(paramJsonValue.asBoolean());
/* 368 */     } else if (paramJsonValue.isDouble()) {
/* 369 */       if (paramJsonValue.name != null) name(paramJsonValue.name); 
/* 370 */       value(paramJsonValue.asDouble());
/* 371 */     } else if (paramJsonValue.isLong()) {
/* 372 */       if (paramJsonValue.name != null) name(paramJsonValue.name); 
/* 373 */       value(paramJsonValue.asLong());
/* 374 */     } else if (paramJsonValue.isString()) {
/* 375 */       if (paramJsonValue.name != null) name(paramJsonValue.name); 
/* 376 */       value(paramJsonValue.asString());
/* 377 */     } else if (paramJsonValue.isNull()) {
/* 378 */       if (paramJsonValue.name != null) name(paramJsonValue.name); 
/* 379 */       value();
/*     */     } else {
/* 381 */       throw new IOException("Unhandled JsonValue type");
/*     */     } 
/* 383 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value(Object paramObject) {
/* 390 */     if (paramObject == null)
/* 391 */       return value(); 
/* 392 */     if (paramObject instanceof Number)
/* 393 */     { Number number = (Number)paramObject;
/* 394 */       if (paramObject instanceof Byte) return value(number.byteValue()); 
/* 395 */       if (paramObject instanceof Short) return value(number.shortValue()); 
/* 396 */       if (paramObject instanceof Integer) return value(number.intValue()); 
/* 397 */       if (paramObject instanceof Long) return value(number.longValue()); 
/* 398 */       if (paramObject instanceof Float) return value(number.floatValue()); 
/* 399 */       if (paramObject instanceof Double) return value(number.doubleValue());  }
/* 400 */     else { if (paramObject instanceof Character)
/* 401 */         return value(((Character)paramObject).charValue()); 
/* 402 */       if (paramObject instanceof CharSequence) {
/* 403 */         return value(paramObject.toString());
/*     */       }
/* 405 */       throw new IOException("Unknown object type."); }
/*     */     
/* 407 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter value() {
/* 413 */     checkName();
/* 414 */     this.out.writeByte(90);
/* 415 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, byte paramByte) {
/* 421 */     return name(paramString).value(paramByte);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, short paramShort) {
/* 427 */     return name(paramString).value(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, int paramInt) {
/* 433 */     return name(paramString).value(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, long paramLong) {
/* 439 */     return name(paramString).value(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, float paramFloat) {
/* 445 */     return name(paramString).value(paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, double paramDouble) {
/* 451 */     return name(paramString).value(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, boolean paramBoolean) {
/* 457 */     return name(paramString).value(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, char paramChar) {
/* 463 */     return name(paramString).value(paramChar);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString1, String paramString2) {
/* 469 */     return name(paramString1).value(paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, byte[] paramArrayOfbyte) {
/* 475 */     return name(paramString).value(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, short[] paramArrayOfshort) {
/* 481 */     return name(paramString).value(paramArrayOfshort);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, int[] paramArrayOfint) {
/* 487 */     return name(paramString).value(paramArrayOfint);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, long[] paramArrayOflong) {
/* 493 */     return name(paramString).value(paramArrayOflong);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, float[] paramArrayOffloat) {
/* 499 */     return name(paramString).value(paramArrayOffloat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, double[] paramArrayOfdouble) {
/* 505 */     return name(paramString).value(paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, boolean[] paramArrayOfboolean) {
/* 511 */     return name(paramString).value(paramArrayOfboolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, char[] paramArrayOfchar) {
/* 517 */     return name(paramString).value(paramArrayOfchar);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString, String[] paramArrayOfString) {
/* 523 */     return name(paramString).value(paramArrayOfString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter set(String paramString) {
/* 529 */     return name(paramString).value();
/*     */   }
/*     */   
/*     */   private void checkName() {
/* 533 */     if (this.current != null && 
/* 534 */       !this.current.array) {
/* 535 */       if (!this.named) throw new IllegalStateException("Name must be set."); 
/* 536 */       this.named = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UBJsonWriter pop() {
/* 544 */     return pop(false);
/*     */   }
/*     */   
/*     */   protected UBJsonWriter pop(boolean paramBoolean) {
/* 548 */     if (this.named) throw new IllegalStateException("Expected an object, array, or value since a name was set."); 
/* 549 */     if (paramBoolean) {
/* 550 */       this.stack.pop();
/*     */     } else {
/* 552 */       ((JsonObject)this.stack.pop()).close();
/* 553 */     }  this.current = (this.stack.size == 0) ? null : this.stack.peek();
/* 554 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() {
/* 559 */     this.out.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 564 */     while (this.stack.size > 0)
/* 565 */       pop(); 
/* 566 */     this.out.close();
/*     */   }
/*     */   
/*     */   private class JsonObject {
/*     */     final boolean array;
/*     */     
/*     */     JsonObject(boolean param1Boolean) {
/* 573 */       this.array = param1Boolean;
/* 574 */       UBJsonWriter.this.out.writeByte(param1Boolean ? 91 : 123);
/*     */     }
/*     */     
/*     */     void close() {
/* 578 */       UBJsonWriter.this.out.writeByte(this.array ? 93 : 125);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\UBJsonWriter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */