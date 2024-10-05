/*    */ package com.esotericsoftware.kryo;
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
/*    */ public class KryoException
/*    */   extends RuntimeException
/*    */ {
/*    */   private StringBuffer trace;
/*    */   
/*    */   public KryoException() {}
/*    */   
/*    */   public KryoException(String paramString, Throwable paramThrowable) {
/* 32 */     super(paramString, paramThrowable);
/*    */   }
/*    */   
/*    */   public KryoException(String paramString) {
/* 36 */     super(paramString);
/*    */   }
/*    */   
/*    */   public KryoException(Throwable paramThrowable) {
/* 40 */     super(paramThrowable);
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 44 */     if (this.trace == null) return super.getMessage(); 
/*    */     StringBuffer stringBuffer;
/* 46 */     (stringBuffer = new StringBuffer(512)).append(super.getMessage());
/* 47 */     if (stringBuffer.length() > 0) stringBuffer.append('\n'); 
/* 48 */     stringBuffer.append("Serialization trace:");
/* 49 */     stringBuffer.append(this.trace);
/* 50 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addTrace(String paramString) {
/* 56 */     if (paramString == null) throw new IllegalArgumentException("info cannot be null."); 
/* 57 */     if (this.trace == null) this.trace = new StringBuffer(512); 
/* 58 */     this.trace.append('\n');
/* 59 */     this.trace.append(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\KryoException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */