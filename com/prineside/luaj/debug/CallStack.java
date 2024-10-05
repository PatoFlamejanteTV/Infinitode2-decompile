/*     */ package com.prineside.luaj.debug;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.luaj.LuaClosure;
/*     */ import com.prineside.luaj.LuaFunction;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.Varargs;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class CallStack
/*     */   implements KryoSerializable {
/*  16 */   public static final CallStack DUMMY = new CallStack();
/*     */   
/*  18 */   private static CallFrame[] a = new CallFrame[0];
/*  19 */   private CallFrame[] b = a;
/*  20 */   public int calls = 0;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  24 */     paramKryo.writeObject(paramOutput, this.b);
/*  25 */     paramOutput.writeInt(this.calls);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  30 */     this.b = (CallFrame[])paramKryo.readObject(paramInput, CallFrame[].class);
/*  31 */     this.calls = paramInput.readInt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CallFrame a() {
/*  41 */     if (this.calls >= this.b.length) {
/*     */       int i;
/*  43 */       CallFrame[] arrayOfCallFrame = new CallFrame[i = Math.max(4, this.b.length * 3 / 2)];
/*  44 */       System.arraycopy(this.b, 0, arrayOfCallFrame, 0, this.b.length); int j;
/*  45 */       for (j = this.b.length; j < i; j++)
/*  46 */         arrayOfCallFrame[j] = new CallFrame(); 
/*  47 */       this.b = arrayOfCallFrame;
/*  48 */       for (j = 1; j < i; j++)
/*  49 */         (arrayOfCallFrame[j]).a = arrayOfCallFrame[j - 1]; 
/*     */     } 
/*  51 */     return this.b[this.calls++];
/*     */   }
/*     */   
/*     */   public final void onCall(LuaFunction paramLuaFunction) {
/*  55 */     a().a(paramLuaFunction);
/*     */   }
/*     */   
/*     */   public final void onCall(LuaClosure paramLuaClosure, Varargs paramVarargs, LuaValue[] paramArrayOfLuaValue) {
/*  59 */     a().a(paramLuaClosure, paramVarargs, paramArrayOfLuaValue);
/*     */   }
/*     */   
/*     */   public final void onReturn() {
/*  63 */     if (this.calls > 0)
/*  64 */       this.b[--this.calls].a(); 
/*     */   }
/*     */   
/*     */   public final void onInstruction(int paramInt1, Varargs paramVarargs, int paramInt2) {
/*  68 */     if (this.calls > 0) {
/*  69 */       this.b[this.calls - 1].a(paramInt1, paramVarargs, paramInt2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String traceback(int paramInt) {
/*     */     StringBuffer stringBuffer;
/*  79 */     (stringBuffer = new StringBuffer()).append("stack traceback:"); CallFrame callFrame;
/*  80 */     while ((callFrame = getCallFrame(paramInt++)) != null) {
/*  81 */       stringBuffer.append("\n\t");
/*  82 */       stringBuffer.append(callFrame.shortsource());
/*  83 */       stringBuffer.append(':');
/*  84 */       if (callFrame.currentline() > 0)
/*  85 */         stringBuffer.append(callFrame.currentline() + ":"); 
/*  86 */       stringBuffer.append(" in ");
/*  87 */       DebugInfo debugInfo = a("n", callFrame.f, callFrame);
/*  88 */       if (callFrame.b() == 0) {
/*  89 */         stringBuffer.append("main chunk"); continue;
/*  90 */       }  if (debugInfo.a != null) {
/*  91 */         stringBuffer.append("function '");
/*  92 */         stringBuffer.append(debugInfo.a);
/*  93 */         stringBuffer.append('\''); continue;
/*     */       } 
/*  95 */       stringBuffer.append("function <");
/*  96 */       stringBuffer.append(callFrame.shortsource());
/*  97 */       stringBuffer.append(':');
/*  98 */       stringBuffer.append(callFrame.b());
/*  99 */       stringBuffer.append('>');
/*     */     } 
/*     */     
/* 102 */     stringBuffer.append("\n\t[Java]: in ?");
/* 103 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public final CallFrame getCallFrame(int paramInt) {
/* 107 */     if (paramInt <= 0 || paramInt > this.calls)
/* 108 */       return null; 
/* 109 */     return this.b[this.calls - paramInt];
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
/*     */   private static DebugInfo a(String paramString, LuaFunction paramLuaFunction, CallFrame paramCallFrame) {
/* 121 */     DebugInfo debugInfo = new DebugInfo(); byte b; int i;
/* 122 */     for (b = 0, i = paramString.length(); b < i; b++) {
/* 123 */       NameWhat nameWhat; switch (paramString.charAt(b)) {
/*     */         case 'S':
/* 125 */           debugInfo.funcinfo(paramLuaFunction);
/*     */           break;
/*     */         case 'l':
/* 128 */           if (paramCallFrame != null && paramCallFrame.f.isclosure()) paramCallFrame.currentline(); 
/*     */           break;
/*     */         case 'u':
/* 131 */           if (paramLuaFunction != null && paramLuaFunction.isclosure()) {
/* 132 */             paramLuaFunction.checkclosure();
/*     */           }
/*     */           break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 'n':
/* 147 */           if (paramCallFrame != null && paramCallFrame.a != null && 
/* 148 */             paramCallFrame.a.f.isclosure() && (
/*     */             
/* 150 */             nameWhat = CallFrame.getfuncname(paramCallFrame.a)) != null) {
/* 151 */             debugInfo.a = nameWhat.name;
/* 152 */             debugInfo.b = nameWhat.namewhat;
/*     */           } 
/*     */ 
/*     */           
/* 156 */           if (debugInfo.b == null) {
/* 157 */             debugInfo.b = "";
/* 158 */             debugInfo.a = null;
/*     */           } 
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 169 */     return debugInfo;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\debug\CallStack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */