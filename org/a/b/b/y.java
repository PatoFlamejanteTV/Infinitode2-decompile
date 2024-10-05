/*     */ package org.a.b.b;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class y
/*     */ {
/*  30 */   private int a = 0;
/*  31 */   private int b = 0;
/*  32 */   private List<Object> c = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public y(String paramString1, String paramString2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public y(String paramString, int paramInt) {
/*  57 */     String.format(Locale.US, "%04x", new Object[] { Integer.valueOf(paramInt) });
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
/*     */   public final List<Object> a(byte[] paramArrayOfbyte, byte[][] paramArrayOfbyte1, byte[][] paramArrayOfbyte2) {
/*  71 */     return a(paramArrayOfbyte, paramArrayOfbyte1, paramArrayOfbyte2, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private List<Object> a(byte[] paramArrayOfbyte, byte[][] paramArrayOfbyte1, byte[][] paramArrayOfbyte2, boolean paramBoolean) {
/*  76 */     if (paramBoolean) {
/*     */       
/*  78 */       this.a = 0;
/*  79 */       this.b = 0;
/*  80 */       this.c = new ArrayList();
/*     */     } 
/*  82 */     b b = new b(paramArrayOfbyte);
/*  83 */     paramBoolean = (paramArrayOfbyte2 != null && paramArrayOfbyte2.length > 0);
/*  84 */     boolean bool = (paramArrayOfbyte1 != null && paramArrayOfbyte1.length > 0) ? true : false;
/*     */     
/*  86 */     while (b.a()) {
/*     */       byte[] arrayOfByte;
/*     */       int i;
/*  89 */       if ((i = b.d()) == 10 && paramBoolean) {
/*     */         
/*  91 */         Integer integer = (Integer)this.c.remove(this.c.size() - 1);
/*     */ 
/*     */         
/*     */         int k;
/*     */         
/*  96 */         if ((k = paramArrayOfbyte2.length) < 1240) {
/*     */           
/*  98 */           k = 107;
/*     */         }
/* 100 */         else if (k < 33900) {
/*     */           
/* 102 */           k = 1131;
/*     */         }
/*     */         else {
/*     */           
/* 106 */           k = 32768;
/*     */         } 
/*     */         int j;
/* 109 */         if ((j = k + integer.intValue()) < paramArrayOfbyte2.length) {
/*     */           
/* 111 */           arrayOfByte = paramArrayOfbyte2[j];
/* 112 */           a(arrayOfByte, paramArrayOfbyte1, paramArrayOfbyte2, false);
/*     */           
/* 114 */           if (arrayOfByte = (byte[])this.c.get(this.c.size() - 1) instanceof q && ((q)arrayOfByte).a().a()[0] == 11)
/*     */           {
/* 116 */             this.c.remove(this.c.size() - 1);
/*     */           }
/*     */         } 
/*     */         continue;
/*     */       } 
/* 121 */       if (arrayOfByte == 29 && bool) {
/*     */         
/* 123 */         Integer integer = (Integer)this.c.remove(this.c.size() - 1);
/*     */ 
/*     */         
/*     */         int k;
/*     */         
/* 128 */         if ((k = paramArrayOfbyte1.length) < 1240) {
/*     */           
/* 130 */           k = 107;
/*     */         }
/* 132 */         else if (k < 33900) {
/*     */           
/* 134 */           k = 1131;
/*     */         }
/*     */         else {
/*     */           
/* 138 */           k = 32768;
/*     */         } 
/*     */         
/*     */         int j;
/* 142 */         if ((j = k + integer.intValue()) < paramArrayOfbyte1.length) {
/*     */           
/* 144 */           arrayOfByte = paramArrayOfbyte1[j];
/* 145 */           a(arrayOfByte, paramArrayOfbyte1, paramArrayOfbyte2, false);
/*     */           
/* 147 */           if (arrayOfByte = (byte[])this.c.get(this.c.size() - 1) instanceof q && ((q)arrayOfByte).a().a()[0] == 11)
/*     */           {
/* 149 */             this.c.remove(this.c.size() - 1);
/*     */           }
/*     */         } 
/*     */         continue;
/*     */       } 
/* 154 */       if (arrayOfByte >= null && arrayOfByte <= 27) {
/*     */         
/* 156 */         this.c.add(a(arrayOfByte, b)); continue;
/*     */       } 
/* 158 */       if (arrayOfByte == 28) {
/*     */         
/* 160 */         this.c.add(b(arrayOfByte, b)); continue;
/*     */       } 
/* 162 */       if (arrayOfByte >= 29 && arrayOfByte <= 31) {
/*     */         
/* 164 */         this.c.add(a(arrayOfByte, b)); continue;
/*     */       } 
/* 166 */       if (arrayOfByte >= 32 && arrayOfByte <= 'ÿ') {
/*     */         
/* 168 */         this.c.add(b(arrayOfByte, b));
/*     */         
/*     */         continue;
/*     */       } 
/* 172 */       throw new IllegalArgumentException();
/*     */     } 
/*     */     
/* 175 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private q a(int paramInt, b paramb) {
/* 181 */     if (paramInt == 1 || paramInt == 18) {
/*     */       
/* 183 */       this.a += b().size() / 2;
/*     */     }
/* 185 */     else if (paramInt == 3 || paramInt == 19 || paramInt == 20 || paramInt == 23) {
/*     */       
/* 187 */       this.b += b().size() / 2;
/*     */     } 
/*     */     
/* 190 */     if (paramInt == 12) {
/*     */       
/* 192 */       int i = paramb.d();
/*     */       
/* 194 */       return new q(paramInt, i);
/*     */     } 
/* 196 */     if (paramInt == 19 || paramInt == 20) {
/*     */       int[] arrayOfInt;
/*     */       
/* 199 */       (arrayOfInt = new int[1 + a()])[0] = paramInt;
/*     */       
/* 201 */       for (paramInt = 1; paramInt < arrayOfInt.length; paramInt++)
/*     */       {
/* 203 */         arrayOfInt[paramInt] = paramb.d();
/*     */       }
/*     */       
/* 206 */       return new q(arrayOfInt);
/*     */     } 
/*     */     
/* 209 */     return new q(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Number b(int paramInt, b paramb) {
/* 215 */     if (paramInt == 28)
/*     */     {
/* 217 */       return Integer.valueOf(paramb.e());
/*     */     }
/* 219 */     if (paramInt >= 32 && paramInt <= 246)
/*     */     {
/* 221 */       return Integer.valueOf(paramInt - 139);
/*     */     }
/* 223 */     if (paramInt >= 247 && paramInt <= 250) {
/*     */       
/* 225 */       int i = paramb.d();
/*     */       
/* 227 */       return Integer.valueOf((paramInt - 247 << 8) + i + 108);
/*     */     } 
/* 229 */     if (paramInt >= 251 && paramInt <= 254) {
/*     */       
/* 231 */       int i = paramb.d();
/*     */       
/* 233 */       return Integer.valueOf((-(paramInt - 251) << 8) - i - 108);
/*     */     } 
/* 235 */     if (paramInt == 255) {
/*     */       
/* 237 */       short s = paramb.e();
/*     */       
/* 239 */       double d = paramb.f() / 65535.0D;
/* 240 */       return Double.valueOf(s + d);
/*     */     } 
/*     */ 
/*     */     
/* 244 */     throw new IllegalArgumentException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int a() {
/* 251 */     int i, j = (i = this.a + this.b) / 8;
/* 252 */     if (i % 8 > 0)
/*     */     {
/* 254 */       j++;
/*     */     }
/* 256 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   private List<Number> b() {
/* 261 */     ArrayList<Number> arrayList = new ArrayList();
/* 262 */     for (int i = this.c.size() - 1; i >= 0; i--) {
/*     */       Object object;
/*     */ 
/*     */       
/* 266 */       if (!(object = this.c.get(i) instanceof Number))
/*     */       {
/* 268 */         return arrayList;
/*     */       }
/* 270 */       arrayList.add(0, (Number)object);
/*     */     } 
/* 272 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\b\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */