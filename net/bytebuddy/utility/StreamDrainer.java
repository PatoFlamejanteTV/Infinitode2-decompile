/*    */ package net.bytebuddy.utility;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;
/*    */ import net.bytebuddy.utility.nullability.MaybeNull;
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
/*    */ @Enhance
/*    */ public class StreamDrainer
/*    */ {
/*    */   public static final int DEFAULT_BUFFER_SIZE = 1024;
/* 39 */   public static final StreamDrainer DEFAULT = new StreamDrainer();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static final int END_OF_STREAM = -1;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static final int FROM_BEGINNING = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final int bufferSize;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public StreamDrainer() {
/* 60 */     this(1024);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public StreamDrainer(int paramInt) {
/* 69 */     this.bufferSize = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte[] drain(InputStream paramInputStream) {
/* 80 */     ArrayList<byte[]> arrayList = new ArrayList();
/* 81 */     byte[] arrayOfByte = new byte[this.bufferSize];
/* 82 */     int i = 0;
/*    */     
/*    */     while (true) {
/* 85 */       int j = paramInputStream.read(arrayOfByte, i, this.bufferSize - i);
/*    */       
/* 87 */       if ((i = i + Math.max(j, 0)) == this.bufferSize) {
/* 88 */         arrayList.add(arrayOfByte);
/* 89 */         arrayOfByte = new byte[this.bufferSize];
/* 90 */         i = 0;
/*    */       } 
/* 92 */       if (j == -1) {
/* 93 */         byte[] arrayOfByte1 = new byte[arrayList.size() * this.bufferSize + i];
/* 94 */         j = 0;
/* 95 */         for (Iterator<byte> iterator = arrayList.iterator(); iterator.hasNext();) {
/* 96 */           System.arraycopy(arrayOfByte2 = (byte[])iterator.next(), 0, arrayOfByte1, j++ * this.bufferSize, this.bufferSize);
/*    */         }
/* 98 */         System.arraycopy(arrayOfByte, 0, arrayOfByte1, j * this.bufferSize, i);
/* 99 */         return arrayOfByte1;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean equals(@MaybeNull Object paramObject) {
/*    */     return (this == paramObject) ? true : ((paramObject == null) ? false : ((getClass() != paramObject.getClass()) ? false : (!(this.bufferSize != ((StreamDrainer)paramObject).bufferSize))));
/*    */   }
/*    */   
/*    */   public int hashCode() {
/*    */     return getClass().hashCode() * 31 + this.bufferSize;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebudd\\utility\StreamDrainer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */