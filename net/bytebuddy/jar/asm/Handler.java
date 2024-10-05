/*     */ package net.bytebuddy.jar.asm;
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
/*     */ final class Handler
/*     */ {
/*     */   final Label a;
/*     */   final Label b;
/*     */   final Label c;
/*     */   private int f;
/*     */   final String d;
/*     */   Handler e;
/*     */   
/*     */   Handler(Label paramLabel1, Label paramLabel2, Label paramLabel3, int paramInt, String paramString) {
/*  91 */     this.a = paramLabel1;
/*  92 */     this.b = paramLabel2;
/*  93 */     this.c = paramLabel3;
/*  94 */     this.f = paramInt;
/*  95 */     this.d = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Handler(Handler paramHandler, Label paramLabel1, Label paramLabel2) {
/* 106 */     this(paramLabel1, paramLabel2, paramHandler.c, paramHandler.f, paramHandler.d);
/* 107 */     this.e = paramHandler.e;
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
/*     */   static Handler a(Handler paramHandler, Label paramLabel1, Label paramLabel2) {
/* 120 */     if (paramHandler == null) {
/* 121 */       return null;
/*     */     }
/* 123 */     paramHandler.e = a(paramHandler.e, paramLabel1, paramLabel2);
/*     */     
/* 125 */     int i = paramHandler.a.c;
/* 126 */     int j = paramHandler.b.c;
/* 127 */     int k = paramLabel1.c;
/* 128 */     int m = (paramLabel2 == null) ? Integer.MAX_VALUE : paramLabel2.c;
/*     */     
/* 130 */     if (k >= j || m <= i) {
/* 131 */       return paramHandler;
/*     */     }
/* 133 */     if (k <= i) {
/* 134 */       if (m >= j)
/*     */       {
/* 136 */         return paramHandler.e;
/*     */       }
/*     */       
/* 139 */       return new Handler(paramHandler, paramLabel2, paramHandler.b);
/*     */     } 
/* 141 */     if (m >= j)
/*     */     {
/* 143 */       return new Handler(paramHandler, paramHandler.a, paramLabel1);
/*     */     }
/*     */ 
/*     */     
/* 147 */     paramHandler.e = new Handler(paramHandler, paramLabel2, paramHandler.b);
/* 148 */     return new Handler(paramHandler, paramHandler.a, paramLabel1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int b(Handler paramHandler) {
/* 159 */     byte b = 0;
/* 160 */     paramHandler = paramHandler;
/* 161 */     while (paramHandler != null) {
/* 162 */       b++;
/* 163 */       paramHandler = paramHandler.e;
/*     */     } 
/* 165 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int a(Handler paramHandler) {
/* 176 */     return 2 + 8 * b(paramHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void a(Handler paramHandler, ByteVector paramByteVector) {
/* 187 */     paramByteVector.putShort(b(paramHandler));
/* 188 */     paramHandler = paramHandler;
/* 189 */     while (paramHandler != null) {
/* 190 */       paramByteVector
/* 191 */         .putShort(paramHandler.a.c)
/* 192 */         .putShort(paramHandler.b.c)
/* 193 */         .putShort(paramHandler.c.c)
/* 194 */         .putShort(paramHandler.f);
/* 195 */       paramHandler = paramHandler.e;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\jar\asm\Handler.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */