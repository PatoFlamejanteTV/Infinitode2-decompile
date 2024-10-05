/*    */ package com.badlogic.gdx.utils;
/*    */ 
/*    */ import java.util.Comparator;
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
/*    */ 
/*    */ 
/*    */ public class Select
/*    */ {
/*    */   private static Select instance;
/*    */   private QuickSelect quickSelect;
/*    */   
/*    */   public static Select instance() {
/* 39 */     if (instance == null) instance = new Select(); 
/* 40 */     return instance;
/*    */   }
/*    */   
/*    */   public <T> T select(T[] paramArrayOfT, Comparator<T> paramComparator, int paramInt1, int paramInt2) {
/* 44 */     int i = selectIndex(paramArrayOfT, paramComparator, paramInt1, paramInt2);
/* 45 */     return paramArrayOfT[i];
/*    */   }
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
/*    */   public <T> int selectIndex(T[] paramArrayOfT, Comparator<T> paramComparator, int paramInt1, int paramInt2) {
/*    */     // Byte code:
/*    */     //   0: iload #4
/*    */     //   2: ifgt -> 15
/*    */     //   5: new com/badlogic/gdx/utils/GdxRuntimeException
/*    */     //   8: dup
/*    */     //   9: ldc 'cannot select from empty array (size < 1)'
/*    */     //   11: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   14: athrow
/*    */     //   15: iload_3
/*    */     //   16: iload #4
/*    */     //   18: if_icmple -> 55
/*    */     //   21: new com/badlogic/gdx/utils/GdxRuntimeException
/*    */     //   24: dup
/*    */     //   25: new java/lang/StringBuilder
/*    */     //   28: dup
/*    */     //   29: ldc 'Kth rank is larger than size. k: '
/*    */     //   31: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   34: iload_3
/*    */     //   35: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*    */     //   38: ldc ', size: '
/*    */     //   40: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   43: iload #4
/*    */     //   45: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*    */     //   48: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   51: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   54: athrow
/*    */     //   55: iload_3
/*    */     //   56: iconst_1
/*    */     //   57: if_icmpne -> 72
/*    */     //   60: aload_0
/*    */     //   61: aload_1
/*    */     //   62: aload_2
/*    */     //   63: iload #4
/*    */     //   65: invokespecial fastMin : ([Ljava/lang/Object;Ljava/util/Comparator;I)I
/*    */     //   68: istore_1
/*    */     //   69: goto -> 121
/*    */     //   72: iload_3
/*    */     //   73: iload #4
/*    */     //   75: if_icmpne -> 90
/*    */     //   78: aload_0
/*    */     //   79: aload_1
/*    */     //   80: aload_2
/*    */     //   81: iload #4
/*    */     //   83: invokespecial fastMax : ([Ljava/lang/Object;Ljava/util/Comparator;I)I
/*    */     //   86: istore_1
/*    */     //   87: goto -> 121
/*    */     //   90: aload_0
/*    */     //   91: getfield quickSelect : Lcom/badlogic/gdx/utils/QuickSelect;
/*    */     //   94: ifnonnull -> 108
/*    */     //   97: aload_0
/*    */     //   98: new com/badlogic/gdx/utils/QuickSelect
/*    */     //   101: dup
/*    */     //   102: invokespecial <init> : ()V
/*    */     //   105: putfield quickSelect : Lcom/badlogic/gdx/utils/QuickSelect;
/*    */     //   108: aload_0
/*    */     //   109: getfield quickSelect : Lcom/badlogic/gdx/utils/QuickSelect;
/*    */     //   112: aload_1
/*    */     //   113: aload_2
/*    */     //   114: iload_3
/*    */     //   115: iload #4
/*    */     //   117: invokevirtual select : ([Ljava/lang/Object;Ljava/util/Comparator;II)I
/*    */     //   120: istore_1
/*    */     //   121: iload_1
/*    */     //   122: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #49	-> 0
/*    */     //   #50	-> 5
/*    */     //   #51	-> 15
/*    */     //   #52	-> 21
/*    */     //   #56	-> 55
/*    */     //   #58	-> 60
/*    */     //   #59	-> 72
/*    */     //   #61	-> 78
/*    */     //   #64	-> 90
/*    */     //   #65	-> 108
/*    */     //   #67	-> 121
/*    */   }
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
/*    */   private <T> int fastMin(T[] paramArrayOfT, Comparator<T> paramComparator, int paramInt) {
/* 72 */     byte b1 = 0;
/* 73 */     for (byte b2 = 1; b2 < paramInt; b2++) {
/*    */       int i;
/* 75 */       if ((i = paramComparator.compare(paramArrayOfT[b2], paramArrayOfT[b1])) < 0) {
/* 76 */         b1 = b2;
/*    */       }
/*    */     } 
/* 79 */     return b1;
/*    */   }
/*    */ 
/*    */   
/*    */   private <T> int fastMax(T[] paramArrayOfT, Comparator<T> paramComparator, int paramInt) {
/* 84 */     byte b1 = 0;
/* 85 */     for (byte b2 = 1; b2 < paramInt; b2++) {
/*    */       int i;
/* 87 */       if ((i = paramComparator.compare(paramArrayOfT[b2], paramArrayOfT[b1])) > 0) {
/* 88 */         b1 = b2;
/*    */       }
/*    */     } 
/* 91 */     return b1;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\Select.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */