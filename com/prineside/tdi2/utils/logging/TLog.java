/*     */ package com.prineside.tdi2.utils.logging;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS(serializer = TLog.Serializer.class)
/*     */ public final class TLog
/*     */ {
/*     */   private final String a;
/*     */   
/*     */   public static class Serializer
/*     */     extends com.esotericsoftware.kryo.Serializer<TLog>
/*     */   {
/*     */     public void write(Kryo param1Kryo, Output param1Output, TLog param1TLog) {
/*  23 */       param1Output.writeString(TLog.a(param1TLog));
/*     */     }
/*     */ 
/*     */     
/*     */     public TLog read(Kryo param1Kryo, Input param1Input, Class<? extends TLog> param1Class) {
/*  28 */       return new TLog(param1Input.readString(), (byte)0);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TLog forClass(Class<?> paramClass) {
/*  38 */     return new TLog(paramClass.getSimpleName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TLog forTag(String paramString) {
/*  47 */     return new TLog(paramString);
/*     */   }
/*     */   
/*     */   private TLog(String paramString) {
/*  51 */     Preconditions.checkNotNull(paramString, "tag can not be null");
/*     */ 
/*     */     
/*  54 */     if ((paramString = paramString.replaceAll("[^a-zA-Z0-9\\-_./]", "")).length() == 0) {
/*  55 */       paramString = "incorrect-tag";
/*     */     }
/*  57 */     if (paramString.length() > 20) {
/*  58 */       String str; while (paramString.length() > 20 && 
/*     */         
/*  60 */         !(str = StringFormatter.shortenFirstWord(paramString)).equals(paramString))
/*     */       {
/*     */         
/*  63 */         paramString = str;
/*     */       }
/*     */       
/*  66 */       this.a = paramString; return;
/*     */     } 
/*  68 */     this.a = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getTag() {
/*  76 */     return this.a;
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
/*     */   public final void d(String paramString, Object... paramVarArgs) {
/*  88 */     if (LogLevel.isDebug()) {
/*  89 */       Logger.a((byte)0, getTag(), paramString, paramVarArgs);
/*     */     }
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
/*     */   public final void i(String paramString, Object... paramVarArgs) {
/* 102 */     if (LogLevel.isInfo()) {
/* 103 */       Logger.a((byte)1, getTag(), paramString, paramVarArgs);
/*     */     }
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
/*     */   public final void w(String paramString, Object... paramVarArgs) {
/* 116 */     if (LogLevel.isWarning()) {
/* 117 */       Logger.a((byte)2, getTag(), paramString, paramVarArgs);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void e(String paramString, Object... paramVarArgs) {
/* 129 */     Logger.a((byte)3, getTag(), paramString, paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\logging\TLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */