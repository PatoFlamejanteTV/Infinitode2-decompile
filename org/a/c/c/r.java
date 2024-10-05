/*     */ package org.a.c.c;
/*     */ 
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import javax.imageio.stream.MemoryCacheImageInputStream;
/*     */ import javax.imageio.stream.MemoryCacheImageOutputStream;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class r
/*     */   extends l
/*     */ {
/*  46 */   private static final a a = c.a(r.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd, int paramInt) {
/*     */     d d1;
/*     */     int i;
/*  71 */     if ((i = (d1 = a(paramd, paramInt)).b(j.aO, 1)) != 0 && i != 1)
/*     */     {
/*  73 */       i = 1;
/*     */     }
/*     */     
/*  76 */     a(paramInputStream, t.a(paramOutputStream, d1), i);
/*  77 */     return new k(paramd);
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt) {
/*  82 */     ArrayList arrayList = new ArrayList();
/*  83 */     int i = 9;
/*  84 */     MemoryCacheImageInputStream memoryCacheImageInputStream = new MemoryCacheImageInputStream(paramInputStream);
/*     */     
/*  86 */     long l1 = -1L;
/*     */     
/*     */     try {
/*     */       long l2;
/*  90 */       while ((l2 = memoryCacheImageInputStream.readBits(i)) != 257L) {
/*     */         List<byte[]> list; byte[] arrayOfByte;
/*  92 */         if (l2 == 256L) {
/*     */           
/*  94 */           i = 9;
/*  95 */           list = b();
/*  96 */           l1 = -1L;
/*     */           
/*     */           continue;
/*     */         } 
/* 100 */         if (l2 < list.size()) {
/*     */ 
/*     */           
/* 103 */           byte arrayOfByte1[], b = (arrayOfByte1 = list.get((int)l2))[0];
/* 104 */           paramOutputStream.write(arrayOfByte1);
/* 105 */           if (l1 != -1L)
/*     */           {
/* 107 */             a(list, l1, memoryCacheImageInputStream);
/*     */ 
/*     */             
/* 110 */             (arrayOfByte = Arrays.copyOf(arrayOfByte1 = list.get((int)l1), arrayOfByte1.length + 1))[arrayOfByte1.length] = b;
/* 111 */             list.add(arrayOfByte);
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 116 */           a(list, arrayOfByte, memoryCacheImageInputStream);
/*     */           
/*     */           byte[] arrayOfByte1, arrayOfByte2;
/* 119 */           (arrayOfByte2 = Arrays.copyOf(arrayOfByte1 = list.get((int)arrayOfByte), arrayOfByte1.length + 1))[arrayOfByte1.length] = arrayOfByte1[0];
/* 120 */           paramOutputStream.write(arrayOfByte2);
/* 121 */           list.add(arrayOfByte2);
/*     */         } 
/*     */         
/* 124 */         i = a(list.size(), paramInt);
/* 125 */         long l3 = l2;
/*     */       }
/*     */     
/*     */     }
/* 129 */     catch (EOFException eOFException) {}
/*     */ 
/*     */ 
/*     */     
/* 133 */     paramOutputStream.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(List<byte[]> paramList, long paramLong, MemoryCacheImageInputStream paramMemoryCacheImageInputStream) {
/* 139 */     if (paramLong < 0L)
/*     */     {
/* 141 */       throw new IOException("negative array index: " + paramLong + " near offset " + paramMemoryCacheImageInputStream
/* 142 */           .getStreamPosition());
/*     */     }
/* 144 */     if (paramLong >= paramList.size())
/*     */     {
/* 146 */       throw new IOException("array index overflow: " + paramLong + " >= " + paramList
/* 147 */           .size() + " near offset " + paramMemoryCacheImageInputStream
/* 148 */           .getStreamPosition());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd) {
/* 159 */     List<byte[]> list = b();
/*     */ 
/*     */     
/* 162 */     byte[] arrayOfByte = null;
/*     */     MemoryCacheImageOutputStream memoryCacheImageOutputStream;
/* 164 */     (memoryCacheImageOutputStream = new MemoryCacheImageOutputStream(paramOutputStream)).writeBits(256L, 9);
/* 165 */     int j = -1;
/*     */     int i;
/* 167 */     while ((i = paramInputStream.read()) != -1) {
/*     */       
/* 169 */       byte b = (byte)i;
/* 170 */       if (arrayOfByte == null) {
/*     */         
/* 172 */         arrayOfByte = new byte[] { b };
/* 173 */         j = b & 0xFF;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 178 */       (arrayOfByte = Arrays.copyOf(arrayOfByte, arrayOfByte.length + 1))[arrayOfByte.length - 1] = b;
/*     */       
/* 180 */       if ((i = a(list, arrayOfByte)) == -1) {
/*     */ 
/*     */         
/* 183 */         i = a(list.size() - 1, 1);
/* 184 */         memoryCacheImageOutputStream.writeBits(j, i);
/*     */         
/* 186 */         list.add(arrayOfByte);
/*     */         
/* 188 */         if (list.size() == 4096) {
/*     */ 
/*     */           
/* 191 */           memoryCacheImageOutputStream.writeBits(256L, i);
/* 192 */           list = b();
/*     */         } 
/*     */         
/* 195 */         arrayOfByte = new byte[] { b };
/* 196 */         j = b & 0xFF;
/*     */         
/*     */         continue;
/*     */       } 
/* 200 */       j = i;
/*     */     } 
/*     */ 
/*     */     
/* 204 */     if (j != -1) {
/*     */       
/* 206 */       i = a(list.size() - 1, 1);
/* 207 */       memoryCacheImageOutputStream.writeBits(j, i);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 215 */     i = a(list.size(), 1);
/*     */     
/* 217 */     memoryCacheImageOutputStream.writeBits(257L, i);
/*     */ 
/*     */     
/* 220 */     memoryCacheImageOutputStream.writeBits(0L, 7);
/*     */ 
/*     */     
/* 223 */     memoryCacheImageOutputStream.flush();
/* 224 */     memoryCacheImageOutputStream.close();
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
/*     */   private static int a(List<byte[]> paramList, byte[] paramArrayOfbyte) {
/* 237 */     int i = -1;
/* 238 */     int j = 0;
/* 239 */     for (int k = paramList.size() - 1; k >= 0; k--) {
/*     */       
/* 241 */       if (k <= 257L) {
/*     */ 
/*     */         
/* 244 */         if (i != -1)
/*     */         {
/*     */           
/* 247 */           return i;
/*     */         }
/* 249 */         if (paramArrayOfbyte.length > 1)
/*     */         {
/*     */           
/* 252 */           return -1;
/*     */         }
/*     */       } 
/* 255 */       byte[] arrayOfByte = paramList.get(k);
/* 256 */       if ((i != -1 || arrayOfByte.length > j) && Arrays.equals(arrayOfByte, paramArrayOfbyte)) {
/*     */         
/* 258 */         i = k;
/* 259 */         j = arrayOfByte.length;
/*     */       } 
/*     */     } 
/* 262 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<byte[]> b() {
/* 271 */     ArrayList<byte[]> arrayList = new ArrayList(4096);
/* 272 */     for (byte b = 0; b < 'Ā'; b++) {
/*     */       
/* 274 */       arrayList.add(new byte[] { (byte)b });
/*     */     } 
/* 276 */     arrayList.add(null);
/* 277 */     arrayList.add(null);
/* 278 */     return (List<byte[]>)arrayList;
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
/*     */   private static int a(int paramInt1, int paramInt2) {
/* 291 */     if (paramInt1 >= 2048 - paramInt2)
/*     */     {
/* 293 */       return 12;
/*     */     }
/* 295 */     if (paramInt1 >= 1024 - paramInt2)
/*     */     {
/* 297 */       return 11;
/*     */     }
/* 299 */     if (paramInt1 >= 512 - paramInt2)
/*     */     {
/* 301 */       return 10;
/*     */     }
/* 303 */     return 9;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\c\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */