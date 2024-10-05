/*    */ package com.a.a.c.k.b;
/*    */ 
/*    */ import com.a.a.b.f.a;
/*    */ import com.a.a.b.h;
/*    */ import com.a.a.b.o;
/*    */ import com.a.a.c.aa;
/*    */ import com.a.a.c.i.i;
/*    */ import java.net.InetAddress;
/*    */ import java.net.InetSocketAddress;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class r
/*    */   extends an<InetSocketAddress>
/*    */ {
/*    */   public r() {
/* 19 */     super(InetSocketAddress.class);
/*    */   }
/*    */ 
/*    */   
/*    */   private static void a(InetSocketAddress paramInetSocketAddress, h paramh) {
/*    */     InetAddress inetAddress;
/*    */     String str;
/*    */     int i;
/* 27 */     if ((i = (str = ((inetAddress = paramInetSocketAddress.getAddress()) == null) ? paramInetSocketAddress.getHostName() : inetAddress.toString().trim()).indexOf('/')) >= 0) {
/* 28 */       if (i == 0) {
/*    */ 
/*    */         
/* 31 */         str = (inetAddress instanceof java.net.Inet6Address) ? ("[" + str.substring(1) + "]") : str.substring(1);
/*    */       } else {
/*    */         
/* 34 */         str = str.substring(0, i);
/*    */       } 
/*    */     }
/*    */     
/* 38 */     paramh.b(str + ":" + paramInetSocketAddress.getPort());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void a(InetSocketAddress paramInetSocketAddress, h paramh, aa paramaa, i parami) {
/* 46 */     a a = parami.a(paramh, parami
/* 47 */         .a(paramInetSocketAddress, InetSocketAddress.class, o.h));
/* 48 */     a(paramInetSocketAddress, paramh);
/* 49 */     parami.b(paramh, a);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */