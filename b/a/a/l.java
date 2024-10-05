/*     */ package b.a.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class l
/*     */ {
/*     */   private m a;
/*     */   private n b;
/*     */   private n c;
/*     */   private k d;
/*     */   private j e;
/*     */   private i f;
/*     */   private boolean g;
/*     */   
/*     */   public final m a(g paramg, b paramb) {
/*  70 */     if (!this.g) a(paramg);
/*     */     
/*  72 */     int i1 = paramg.b();
/*     */     
/*     */     f f;
/*     */     
/*  76 */     (f = a(paramg, paramb, i1)).a();
/*     */     
/*  78 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(m paramm) {
/*  85 */     this.a = paramm;
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
/*     */   private static e a(int paramInt, Throwable paramThrowable) {
/* 114 */     return new e(513, paramThrowable);
/*     */   } private f a(g paramg, b paramb, int paramInt) {
/*     */     j j1;
/*     */     i i1;
/* 118 */     k k1 = null;
/*     */ 
/*     */ 
/*     */     
/* 122 */     switch (paramInt) {
/*     */       case 3:
/* 124 */         if (this.d == null) {
/* 125 */           this.d = new k(paramb, paramg, this.b, this.c, this.a, 0);
/*     */         }
/* 127 */         k1 = this.d;
/*     */         break;
/*     */       case 2:
/* 130 */         if (this.e == null) {
/* 131 */           this.e = new j();
/* 132 */           this.e.a(paramb, paramg, this.b, this.c, this.a, 0);
/*     */         } 
/* 134 */         j1 = this.e;
/*     */         break;
/*     */       case 1:
/* 137 */         if (this.f == null) {
/* 138 */           this.f = new i();
/* 139 */           this.f.a(paramb, paramg, this.b, this.c, this.a, 0);
/*     */         } 
/* 141 */         i1 = this.f;
/*     */         break;
/*     */     } 
/*     */     
/* 145 */     if (i1 == null) throw a(513, null);
/*     */     
/* 147 */     return i1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(g paramg) {
/* 155 */     int i1 = paramg.f();
/* 156 */     paramg.b();
/* 157 */     i1 = (i1 == 3) ? 1 : 2;
/*     */ 
/*     */     
/* 160 */     if (this.a == null) throw new RuntimeException("Output buffer was not set.");
/*     */     
/* 162 */     this.b = new n(0, 32700.0F);
/*     */ 
/*     */     
/* 165 */     if (i1 == 2) this.c = new n(1, 32700.0F);
/*     */ 
/*     */     
/* 168 */     paramg.e();
/*     */     
/* 170 */     this.g = true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\b\a\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */