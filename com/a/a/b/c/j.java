/*    */ package com.a.a.b.c;
/*    */ 
/*    */ import com.a.a.b.g.a;
/*    */ import com.a.a.b.g.o;
/*    */ import java.io.Writer;
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
/*    */ public final class j
/*    */   extends Writer
/*    */ {
/*    */   private final o a;
/*    */   
/*    */   public j(a parama) {
/* 22 */     this.a = new o(parama);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Writer append(char paramChar) {
/* 33 */     write(paramChar);
/* 34 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public final Writer append(CharSequence paramCharSequence) {
/* 39 */     paramCharSequence = paramCharSequence.toString();
/* 40 */     this.a.a((String)paramCharSequence, 0, paramCharSequence.length());
/* 41 */     return this;
/*    */   }
/*    */   public final void close() {}
/*    */   
/*    */   public final Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 46 */     paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2).toString();
/* 47 */     this.a.a((String)paramCharSequence, 0, paramCharSequence.length());
/* 48 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void flush() {}
/*    */   
/*    */   public final void write(char[] paramArrayOfchar) {
/* 55 */     this.a.c(paramArrayOfchar, 0, paramArrayOfchar.length);
/*    */   }
/*    */   public final void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 58 */     this.a.c(paramArrayOfchar, paramInt1, paramInt2);
/*    */   }
/*    */   public final void write(int paramInt) {
/* 61 */     this.a.a((char)paramInt);
/*    */   }
/*    */   public final void write(String paramString) {
/* 64 */     this.a.a(paramString, 0, paramString.length());
/*    */   }
/*    */   public final void write(String paramString, int paramInt1, int paramInt2) {
/* 67 */     this.a.a(paramString, paramInt1, paramInt2);
/*    */   }
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
/*    */   public final String a() {
/* 85 */     String str = this.a.e();
/* 86 */     this.a.a();
/* 87 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\c\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */