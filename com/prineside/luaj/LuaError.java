/*     */ package com.prineside.luaj;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LuaError
/*     */   extends RuntimeException
/*     */ {
/*     */   protected int a;
/*     */   @Null
/*     */   protected String b;
/*     */   protected String c;
/*     */   private Throwable d;
/*     */   public LuaValue object;
/*     */   @Null
/*     */   public String extraMessage;
/*     */   
/*     */   static {
/*  45 */     TLog.forClass(LuaError.class);
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
/*     */   public String getMessage() {
/*  66 */     if (this.c != null) {
/*  67 */       return this.c;
/*     */     }
/*     */     
/*     */     StringBuilder stringBuilder;
/*  71 */     if ((stringBuilder = new StringBuilder(super.getMessage())).length() == 0) {
/*  72 */       stringBuilder.append(this.extraMessage);
/*     */     }
/*  74 */     else if (this.extraMessage != null) {
/*  75 */       stringBuilder.append("\n").append(this.extraMessage);
/*     */     } 
/*     */ 
/*     */     
/*  79 */     if (this.b != null) {
/*  80 */       if (stringBuilder.length() == 0) {
/*  81 */         stringBuilder.append(this.b);
/*     */       } else {
/*  83 */         stringBuilder.insert(0, this.b + " ");
/*     */       } 
/*     */     }
/*  86 */     Throwable throwable = getCause();
/*  87 */     while (throwable != null) {
/*  88 */       stringBuilder.append("\n    Caused by: ").append(throwable.getMessage()).append(" (").append(throwable.getStackTrace()[0]).append(")");
/*  89 */       throwable = throwable.getCause();
/*     */     } 
/*  91 */     return stringBuilder.toString();
/*     */   }
/*     */   @Null
/*     */   public String getExtraMessage() {
/*  95 */     return this.extraMessage;
/*     */   }
/*     */   
/*     */   public void setExtraMessage(String paramString) {
/*  99 */     this.extraMessage = paramString;
/*     */   }
/*     */   
/*     */   public void appendExtraMessage(String paramString) {
/* 103 */     if (this.extraMessage == null) {
/* 104 */       this.extraMessage = paramString; return;
/*     */     } 
/* 106 */     this.extraMessage += "\n" + paramString;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public String getFileline() {
/* 111 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaValue getMessageObject() {
/* 120 */     if (this.object != null) return this.object; 
/*     */     String str;
/* 122 */     return ((str = getMessage()) != null) ? LuaValue.valueOf(str) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaError(Throwable paramThrowable) {
/* 131 */     super("vm error: " + paramThrowable, paramThrowable);
/* 132 */     this.d = paramThrowable;
/* 133 */     this.a = 1;
/*     */   }
/*     */   
/*     */   public LuaError setCause(Throwable paramThrowable) {
/* 137 */     this.d = paramThrowable;
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaError(String paramString) {
/* 147 */     super(paramString);
/* 148 */     this.a = 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaError(String paramString, int paramInt) {
/* 157 */     super(paramString);
/* 158 */     this.a = paramInt;
/*     */   }
/*     */   
/*     */   public LuaError(String paramString, int paramInt, Throwable paramThrowable) {
/* 162 */     super(paramString, paramThrowable);
/* 163 */     this.a = paramInt;
/* 164 */     this.d = paramThrowable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaError(LuaValue paramLuaValue) {
/* 173 */     super(paramLuaValue.tojstring());
/* 174 */     this.object = paramLuaValue;
/* 175 */     this.a = 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Throwable getCause() {
/* 184 */     return this.d;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\LuaError.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */