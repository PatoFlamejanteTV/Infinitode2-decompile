/*     */ package org.a.c.h.f.c;
/*     */ 
/*     */ import com.a.a.a.am;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.List;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.g;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.m;
/*     */ import org.a.c.b.p;
/*     */ import org.a.c.c.k;
/*     */ import org.a.c.h.a.d;
/*     */ import org.a.c.h.a.i;
/*     */ import org.a.c.h.f.a;
/*     */ import org.a.c.h.f.a.f;
/*     */ import org.a.c.h.f.a.i;
/*     */ import org.a.c.h.j;
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
/*     */ public final class b
/*     */   extends a
/*     */   implements d
/*     */ {
/*     */   private f a;
/*     */   private final j b;
/*     */   
/*     */   static {
/*  67 */     c.a(b.class);
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
/*     */   public b(org.a.c.h.b paramb, InputStream paramInputStream, org.a.c.b.b paramb1, int paramInt1, int paramInt2, int paramInt3, f paramf) {
/* 111 */     super(a(paramb, paramInputStream), j.bE);
/* 112 */     b().a(j.aY, paramb1);
/* 113 */     this.b = null;
/* 114 */     this.a = null;
/* 115 */     a(paramInt3);
/* 116 */     c(paramInt1);
/* 117 */     b(paramInt2);
/* 118 */     a(paramf);
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
/*     */   private b(i parami, j paramj) {
/* 132 */     super(parami, j.bE);
/* 133 */     this.b = paramj;
/*     */     List list;
/* 135 */     if ((list = parami.e()) != null && !list.isEmpty() && j.bN.equals(list.get(list.size() - 1))) {
/*     */       g g;
/* 137 */       list = null;
/*     */ 
/*     */       
/*     */       try {
/* 141 */         k k = (g = parami.c()).a();
/* 142 */         parami.a().a(k.a());
/* 143 */         this.a = (f)k.b();
/*     */         
/*     */         return;
/*     */       } finally {
/* 147 */         am.a((Closeable)g);
/*     */       } 
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
/*     */   private static p a(org.a.c.h.b paramb, InputStream paramInputStream) {
/* 171 */     null = paramb.a().a();
/* 172 */     OutputStream outputStream = null;
/*     */     
/*     */     try {
/* 175 */       outputStream = null.m();
/* 176 */       am.a(paramInputStream, outputStream);
/*     */     }
/*     */     finally {
/*     */       
/* 180 */       if (outputStream != null)
/*     */       {
/* 182 */         outputStream.close();
/*     */       }
/*     */     } 
/* 185 */     return (p)paramb;
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
/*     */   public final b a() {
/*     */     p p;
/* 658 */     if ((p = b().e(j.ds)) != null)
/*     */     {
/*     */       
/* 661 */       return new b(new i(p), null);
/*     */     }
/* 663 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int d() {
/* 669 */     if (i())
/*     */     {
/* 671 */       return 1;
/*     */     }
/*     */ 
/*     */     
/* 675 */     return b().c(j.z, j.D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(int paramInt) {
/* 682 */     b().a(j.z, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final f e() {
/* 688 */     if (this.a == null) {
/*     */       org.a.c.b.b b1;
/*     */       
/* 691 */       if ((b1 = b().d(j.ac, j.al)) != null) {
/*     */         
/* 693 */         m m = null;
/* 694 */         if (b1 instanceof m && this.b != null && this.b
/* 695 */           .b() != null) {
/*     */ 
/*     */ 
/*     */           
/* 699 */           m = (m)b1;
/* 700 */           this.a = this.b.b().b(m);
/* 701 */           if (this.a != null)
/*     */           {
/* 703 */             return this.a;
/*     */           }
/*     */         } 
/* 706 */         this.a = f.a(b1, this.b);
/* 707 */         if (m != null)
/*     */         {
/* 709 */           this.b.b().a(m, this.a);
/*     */         }
/*     */       } else {
/* 712 */         if (i())
/*     */         {
/*     */           
/* 715 */           return (f)i.a;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 720 */         throw new IOException("could not determine color space");
/*     */       } 
/*     */     } 
/* 723 */     return this.a;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(f paramf) {
/* 753 */     b().a(j.ac, (paramf != null) ? paramf.f() : null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int g() {
/* 759 */     return b().j(j.bx);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(int paramInt) {
/* 765 */     b().a(j.bx, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int h() {
/* 771 */     return b().j(j.ea);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(int paramInt) {
/* 777 */     b().a(j.ea, paramInt);
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
/*     */   public final void a(boolean paramBoolean) {
/* 789 */     b().a(j.bJ, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(a parama) {
/* 795 */     b().a(j.aq, (org.a.c.b.b)parama);
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
/*     */   private boolean i() {
/* 812 */     return b().b(j.bF, false);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */