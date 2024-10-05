/*    */ package org.lwjgl.openal;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.lwjgl.system.MemoryUtil;
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
/*    */ public final class ALUtil
/*    */ {
/*    */   public static List<String> getStringList(long paramLong, int paramInt) {
/*    */     long l;
/* 29 */     if ((l = ALC10.nalcGetString(paramLong, paramInt)) == 0L) {
/* 30 */       return null;
/*    */     }
/*    */     
/* 33 */     ByteBuffer byteBuffer = MemoryUtil.memByteBuffer(l, 2147483647);
/*    */     
/* 35 */     ArrayList<String> arrayList = new ArrayList();
/*    */     
/* 37 */     paramInt = 0;
/*    */     while (true) {
/* 39 */       if (byteBuffer.get() == 0) {
/*    */         int i;
/* 41 */         if ((i = byteBuffer.position() - 1) != paramInt) {
/*    */ 
/*    */ 
/*    */           
/* 45 */           arrayList.add(MemoryUtil.memUTF8(byteBuffer, i - paramInt, paramInt));
/* 46 */           paramInt = byteBuffer.position(); continue;
/*    */         }  break;
/*    */       } 
/*    */     } 
/* 50 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\ALUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */