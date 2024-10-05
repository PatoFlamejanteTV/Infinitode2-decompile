/*    */ package com.badlogic.gdx.utils;
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
/*    */ public class SerializationException
/*    */   extends RuntimeException
/*    */ {
/*    */   private StringBuilder trace;
/*    */   
/*    */   public SerializationException() {}
/*    */   
/*    */   public SerializationException(String paramString, Throwable paramThrowable) {
/* 29 */     super(paramString, paramThrowable);
/*    */   }
/*    */   
/*    */   public SerializationException(String paramString) {
/* 33 */     super(paramString);
/*    */   }
/*    */   
/*    */   public SerializationException(Throwable paramThrowable) {
/* 37 */     super("", paramThrowable);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean causedBy(Class paramClass) {
/* 42 */     return causedBy(this, paramClass);
/*    */   }
/*    */   
/*    */   private boolean causedBy(Throwable paramThrowable, Class paramClass) {
/*    */     Throwable throwable;
/* 47 */     if ((throwable = paramThrowable.getCause()) == null || throwable == paramThrowable) return false; 
/* 48 */     if (paramClass.isAssignableFrom(throwable.getClass())) return true; 
/* 49 */     return causedBy(throwable, paramClass);
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 53 */     if (this.trace == null) return super.getMessage(); 
/*    */     StringBuilder stringBuilder;
/* 55 */     (stringBuilder = new StringBuilder(512)).append(super.getMessage());
/* 56 */     if (stringBuilder.length() > 0) stringBuilder.append('\n'); 
/* 57 */     stringBuilder.append("Serialization trace:");
/* 58 */     stringBuilder.append(this.trace);
/* 59 */     return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addTrace(String paramString) {
/* 65 */     if (paramString == null) throw new IllegalArgumentException("info cannot be null."); 
/* 66 */     if (this.trace == null) this.trace = new StringBuilder(512); 
/* 67 */     this.trace.append('\n');
/* 68 */     this.trace.append(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\SerializationException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */