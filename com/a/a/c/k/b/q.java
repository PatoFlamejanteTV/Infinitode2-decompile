/*    */ package com.a.a.c.k.b;
/*    */ 
/*    */ import com.a.a.a.l;
/*    */ import com.a.a.b.f.a;
/*    */ import com.a.a.b.h;
/*    */ import com.a.a.b.o;
/*    */ import com.a.a.c.aa;
/*    */ import com.a.a.c.c;
/*    */ import com.a.a.c.i.i;
/*    */ import com.a.a.c.k.k;
/*    */ import com.a.a.c.o;
/*    */ import java.net.InetAddress;
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
/*    */ public final class q
/*    */   extends an<InetAddress>
/*    */   implements k
/*    */ {
/*    */   private boolean a;
/*    */   
/*    */   public q() {
/* 36 */     this(false);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private q(boolean paramBoolean) {
/* 43 */     super(InetAddress.class);
/* 44 */     this.a = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final o<?> a(aa paramaa, c paramc) {
/* 51 */     l.d d = a(paramaa, paramc, 
/* 52 */         a());
/* 53 */     boolean bool = false; l.c c1;
/* 54 */     if (d != null && ((
/*    */       
/* 56 */       c1 = d.c()).a() || c1 == l.c.d)) {
/* 57 */       bool = true;
/*    */     }
/*    */     
/* 60 */     if (bool != this.a) {
/* 61 */       return new q(bool);
/*    */     }
/* 63 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void a(InetAddress paramInetAddress, h paramh) {
/*    */     String str;
/* 71 */     if (this.a) {
/* 72 */       str = paramInetAddress.getHostAddress();
/*    */     } else {
/*    */       int i;
/*    */ 
/*    */       
/* 77 */       if ((i = (str = str.toString().trim()).indexOf('/')) >= 0) {
/* 78 */         if (i == 0) {
/* 79 */           str = str.substring(1);
/*    */         } else {
/* 81 */           str = str.substring(0, i);
/*    */         } 
/*    */       }
/*    */     } 
/* 85 */     paramh.b(str);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void a(InetAddress paramInetAddress, h paramh, aa paramaa, i parami) {
/* 93 */     a a = parami.a(paramh, parami
/* 94 */         .a(paramInetAddress, InetAddress.class, o.h));
/* 95 */     a(paramInetAddress, paramh);
/* 96 */     parami.b(paramh, a);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */