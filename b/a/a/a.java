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
/*     */ final class a
/*     */ {
/*     */   private int a;
/*     */   private int b;
/*     */   private int c;
/*  48 */   private final int[] d = new int[32768];
/*     */ 
/*     */   
/*     */   a() {
/*  52 */     this.a = 0;
/*  53 */     this.b = 0;
/*  54 */     this.c = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a() {
/*  61 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(int paramInt) {
/*  69 */     this.b += paramInt;
/*     */     
/*  71 */     int i = 0;
/*     */     
/*     */     int j;
/*  74 */     if ((j = this.c) + paramInt < 32768) {
/*  75 */       while (paramInt-- > 0)
/*     */       {
/*  77 */         i = (i = i << 1) | ((this.d[j++] != 0) ? 1 : 0);
/*     */       }
/*     */     } else {
/*  80 */       while (paramInt-- > 0) {
/*     */         
/*  82 */         i = (i = i << 1) | ((this.d[j] != 0) ? 1 : 0);
/*  83 */         j = j + 1 & 0x7FFF;
/*     */       } 
/*  85 */     }  this.c = j;
/*  86 */     return i;
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
/*     */   public final int b() {
/* 102 */     this.b++;
/* 103 */     int i = this.d[this.c];
/* 104 */     this.c = this.c + 1 & 0x7FFF;
/* 105 */     return i;
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
/*     */   public final void b(int paramInt) {
/* 130 */     int i = this.a;
/* 131 */     this.d[i++] = paramInt & 0x80;
/* 132 */     this.d[i++] = paramInt & 0x40;
/* 133 */     this.d[i++] = paramInt & 0x20;
/* 134 */     this.d[i++] = paramInt & 0x10;
/* 135 */     this.d[i++] = paramInt & 0x8;
/* 136 */     this.d[i++] = paramInt & 0x4;
/* 137 */     this.d[i++] = paramInt & 0x2;
/* 138 */     this.d[i++] = paramInt & 0x1;
/*     */     
/* 140 */     if (i == 32768) {
/* 141 */       this.a = 0; return;
/*     */     } 
/* 143 */     this.a = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void c(int paramInt) {
/* 151 */     this.b -= paramInt;
/* 152 */     this.c -= paramInt;
/* 153 */     if (this.c < 0) this.c += 32768;
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void d(int paramInt) {
/* 161 */     this.b -= 32768;
/* 162 */     this.c -= 32768;
/* 163 */     if (this.c < 0) this.c += 32768; 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\b\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */