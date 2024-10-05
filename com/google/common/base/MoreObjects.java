/*     */ package com.google.common.base;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
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
/*     */ @ElementTypesAreNonnullByDefault
/*     */ public final class MoreObjects
/*     */ {
/*     */   public static <T> T firstNonNull(T paramT1, T paramT2) {
/*  79 */     if (paramT1 != null) {
/*  80 */       return paramT1;
/*     */     }
/*  82 */     if (paramT2 != null) {
/*  83 */       return paramT2;
/*     */     }
/*  85 */     throw new NullPointerException("Both parameters are null");
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
/*     */   public static ToStringHelper toStringHelper(Object paramObject) {
/* 129 */     return new ToStringHelper(paramObject.getClass().getSimpleName());
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
/*     */   public static ToStringHelper toStringHelper(Class<?> paramClass) {
/* 143 */     return new ToStringHelper(paramClass.getSimpleName());
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
/*     */   public static ToStringHelper toStringHelper(String paramString) {
/* 155 */     return new ToStringHelper(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class ToStringHelper
/*     */   {
/*     */     private final String className;
/*     */ 
/*     */     
/* 166 */     private final ValueHolder holderHead = new ValueHolder();
/* 167 */     private ValueHolder holderTail = this.holderHead;
/*     */     
/*     */     private boolean omitNullValues = false;
/*     */     private boolean omitEmptyValues = false;
/*     */     
/*     */     private ToStringHelper(String param1String) {
/* 173 */       this.className = Preconditions.<String>checkNotNull(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ToStringHelper omitNullValues() {
/* 185 */       this.omitNullValues = true;
/* 186 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ToStringHelper add(String param1String, Object param1Object) {
/* 196 */       return addHolder(param1String, param1Object);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ToStringHelper add(String param1String, boolean param1Boolean) {
/* 206 */       return addUnconditionalHolder(param1String, String.valueOf(param1Boolean));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ToStringHelper add(String param1String, char param1Char) {
/* 216 */       return addUnconditionalHolder(param1String, String.valueOf(param1Char));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ToStringHelper add(String param1String, double param1Double) {
/* 226 */       return addUnconditionalHolder(param1String, String.valueOf(param1Double));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ToStringHelper add(String param1String, float param1Float) {
/* 236 */       return addUnconditionalHolder(param1String, String.valueOf(param1Float));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ToStringHelper add(String param1String, int param1Int) {
/* 246 */       return addUnconditionalHolder(param1String, String.valueOf(param1Int));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ToStringHelper add(String param1String, long param1Long) {
/* 256 */       return addUnconditionalHolder(param1String, String.valueOf(param1Long));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ToStringHelper addValue(Object param1Object) {
/* 267 */       return addHolder(param1Object);
/*     */     }
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
/*     */     public final ToStringHelper addValue(boolean param1Boolean) {
/* 280 */       return addUnconditionalHolder(String.valueOf(param1Boolean));
/*     */     }
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
/*     */     public final ToStringHelper addValue(char param1Char) {
/* 293 */       return addUnconditionalHolder(String.valueOf(param1Char));
/*     */     }
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
/*     */     public final ToStringHelper addValue(double param1Double) {
/* 306 */       return addUnconditionalHolder(String.valueOf(param1Double));
/*     */     }
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
/*     */     public final ToStringHelper addValue(float param1Float) {
/* 319 */       return addUnconditionalHolder(String.valueOf(param1Float));
/*     */     }
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
/*     */     public final ToStringHelper addValue(int param1Int) {
/* 332 */       return addUnconditionalHolder(String.valueOf(param1Int));
/*     */     }
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
/*     */     public final ToStringHelper addValue(long param1Long) {
/* 345 */       return addUnconditionalHolder(String.valueOf(param1Long));
/*     */     }
/*     */ 
/*     */     
/*     */     private static boolean isEmpty(Object param1Object) {
/* 350 */       if (param1Object instanceof CharSequence)
/* 351 */         return (((CharSequence)param1Object).length() == 0); 
/* 352 */       if (param1Object instanceof Collection)
/* 353 */         return ((Collection)param1Object).isEmpty(); 
/* 354 */       if (param1Object instanceof Map)
/* 355 */         return ((Map)param1Object).isEmpty(); 
/* 356 */       if (param1Object instanceof Optional)
/* 357 */         return !((Optional)param1Object).isPresent(); 
/* 358 */       if (param1Object.getClass().isArray()) {
/* 359 */         return (Array.getLength(param1Object) == 0);
/*     */       }
/* 361 */       return false;
/*     */     }
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
/*     */     public final String toString() {
/* 375 */       boolean bool1 = this.omitNullValues;
/* 376 */       boolean bool2 = this.omitEmptyValues;
/* 377 */       String str = "";
/* 378 */       StringBuilder stringBuilder = (new StringBuilder(32)).append(this.className).append('{');
/* 379 */       ValueHolder valueHolder = this.holderHead.next;
/* 380 */       for (; valueHolder != null; 
/* 381 */         valueHolder = valueHolder.next) {
/* 382 */         Object object = valueHolder.value;
/* 383 */         if (valueHolder instanceof UnconditionalValueHolder || ((object == null) ? !bool1 : (!bool2 || 
/*     */ 
/*     */           
/* 386 */           !isEmpty(object)))) {
/* 387 */           stringBuilder.append(str);
/* 388 */           str = ", ";
/*     */           
/* 390 */           if (valueHolder.name != null) {
/* 391 */             stringBuilder.append(valueHolder.name).append('=');
/*     */           }
/* 393 */           if (object != null && object.getClass().isArray()) {
/*     */             
/* 395 */             object = Arrays.deepToString((Object[])(object = new Object[] { object }));
/* 396 */             stringBuilder.append((CharSequence)object, 1, object.length() - 1);
/*     */           } else {
/* 398 */             stringBuilder.append(object);
/*     */           } 
/*     */         } 
/*     */       } 
/* 402 */       return stringBuilder.append('}').toString();
/*     */     }
/*     */     
/*     */     private ValueHolder addHolder() {
/* 406 */       ValueHolder valueHolder = new ValueHolder();
/* 407 */       this.holderTail = this.holderTail.next = valueHolder;
/* 408 */       return valueHolder;
/*     */     }
/*     */     
/*     */     private ToStringHelper addHolder(Object param1Object) {
/*     */       ValueHolder valueHolder;
/* 413 */       (valueHolder = addHolder()).value = param1Object;
/* 414 */       return this;
/*     */     }
/*     */     
/*     */     private ToStringHelper addHolder(String param1String, Object param1Object) {
/*     */       ValueHolder valueHolder;
/* 419 */       (valueHolder = addHolder()).value = param1Object;
/* 420 */       valueHolder.name = Preconditions.<String>checkNotNull(param1String);
/* 421 */       return this;
/*     */     }
/*     */     
/*     */     private UnconditionalValueHolder addUnconditionalHolder() {
/* 425 */       UnconditionalValueHolder unconditionalValueHolder = new UnconditionalValueHolder();
/* 426 */       this.holderTail = this.holderTail.next = unconditionalValueHolder;
/* 427 */       return unconditionalValueHolder;
/*     */     }
/*     */     
/*     */     private ToStringHelper addUnconditionalHolder(Object param1Object) {
/*     */       UnconditionalValueHolder unconditionalValueHolder;
/* 432 */       (unconditionalValueHolder = addUnconditionalHolder()).value = param1Object;
/* 433 */       return this;
/*     */     }
/*     */     
/*     */     private ToStringHelper addUnconditionalHolder(String param1String, Object param1Object) {
/*     */       UnconditionalValueHolder unconditionalValueHolder;
/* 438 */       (unconditionalValueHolder = addUnconditionalHolder()).value = param1Object;
/* 439 */       unconditionalValueHolder.name = Preconditions.<String>checkNotNull(param1String);
/* 440 */       return this;
/*     */     }
/*     */     
/*     */     private static class ValueHolder {
/*     */       String name;
/*     */       Object value;
/*     */       ValueHolder next;
/*     */       
/*     */       private ValueHolder() {}
/*     */     }
/*     */     
/*     */     private static final class UnconditionalValueHolder extends ValueHolder {
/*     */       private UnconditionalValueHolder() {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\MoreObjects.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */