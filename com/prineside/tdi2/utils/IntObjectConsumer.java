/*    */ package com.prineside.tdi2.utils;
/*    */ 
/*    */ import java.util.Objects;
/*    */ 
/*    */ @FunctionalInterface
/*    */ public interface IntObjectConsumer<T> {
/*    */   void accept(int paramInt, T paramT);
/*    */   
/*    */   default IntObjectConsumer<T> andThen(IntObjectConsumer<? super T> paramIntObjectConsumer) {
/* 10 */     Objects.requireNonNull(paramIntObjectConsumer);
/* 11 */     return (paramInt, paramObject) -> {
/*    */         accept(paramInt, (T)paramObject);
/*    */         paramIntObjectConsumer.accept(paramInt, paramObject);
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\IntObjectConsumer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */