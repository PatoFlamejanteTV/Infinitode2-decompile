/*      */ package com.google.common.base;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @ElementTypesAreNonnullByDefault
/*      */ public final class Preconditions
/*      */ {
/*      */   public static void checkArgument(boolean paramBoolean) {
/*  130 */     if (!paramBoolean) {
/*  131 */       throw new IllegalArgumentException();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, Object paramObject) {
/*  144 */     if (!paramBoolean) {
/*  145 */       throw new IllegalArgumentException(String.valueOf(paramObject));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, Object... paramVarArgs) {
/*  166 */     if (!paramBoolean) {
/*  167 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, paramVarArgs));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, char paramChar) {
/*  179 */     if (!paramBoolean) {
/*  180 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, int paramInt) {
/*  192 */     if (!paramBoolean) {
/*  193 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, long paramLong) {
/*  205 */     if (!paramBoolean) {
/*  206 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, Object paramObject) {
/*  219 */     if (!paramBoolean) {
/*  220 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { paramObject }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, char paramChar1, char paramChar2) {
/*  232 */     if (!paramBoolean) {
/*  233 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar1), Character.valueOf(paramChar2) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, char paramChar, int paramInt) {
/*  245 */     if (!paramBoolean) {
/*  246 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar), Integer.valueOf(paramInt) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, char paramChar, long paramLong) {
/*  258 */     if (!paramBoolean) {
/*  259 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar), Long.valueOf(paramLong) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, char paramChar, Object paramObject) {
/*  272 */     if (!paramBoolean) {
/*  273 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar), paramObject }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, int paramInt, char paramChar) {
/*  285 */     if (!paramBoolean) {
/*  286 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt), Character.valueOf(paramChar) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {
/*  298 */     if (!paramBoolean) {
/*  299 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, int paramInt, long paramLong) {
/*  311 */     if (!paramBoolean) {
/*  312 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, int paramInt, Object paramObject) {
/*  325 */     if (!paramBoolean) {
/*  326 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt), paramObject }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, long paramLong, char paramChar) {
/*  338 */     if (!paramBoolean) {
/*  339 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong), Character.valueOf(paramChar) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, long paramLong, int paramInt) {
/*  351 */     if (!paramBoolean) {
/*  352 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, long paramLong1, long paramLong2) {
/*  364 */     if (!paramBoolean) {
/*  365 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, long paramLong, Object paramObject) {
/*  378 */     if (!paramBoolean) {
/*  379 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong), paramObject }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, Object paramObject, char paramChar) {
/*  392 */     if (!paramBoolean) {
/*  393 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { paramObject, Character.valueOf(paramChar) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, Object paramObject, int paramInt) {
/*  406 */     if (!paramBoolean) {
/*  407 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { paramObject, Integer.valueOf(paramInt) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, Object paramObject, long paramLong) {
/*  420 */     if (!paramBoolean) {
/*  421 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { paramObject, Long.valueOf(paramLong) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2) {
/*  434 */     if (!paramBoolean) {
/*  435 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { paramObject1, paramObject2 }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
/*  452 */     if (!paramBoolean) {
/*  453 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { paramObject1, paramObject2, paramObject3 }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkArgument(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) {
/*  471 */     if (!paramBoolean) {
/*  472 */       throw new IllegalArgumentException(Strings.lenientFormat(paramString, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean) {
/*  485 */     if (!paramBoolean) {
/*  486 */       throw new IllegalStateException();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, Object paramObject) {
/*  501 */     if (!paramBoolean) {
/*  502 */       throw new IllegalStateException(String.valueOf(paramObject));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, Object... paramVarArgs) {
/*  533 */     if (!paramBoolean) {
/*  534 */       throw new IllegalStateException(Strings.lenientFormat(paramString, paramVarArgs));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, char paramChar) {
/*  547 */     if (!paramBoolean) {
/*  548 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, int paramInt) {
/*  561 */     if (!paramBoolean) {
/*  562 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, long paramLong) {
/*  575 */     if (!paramBoolean) {
/*  576 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, Object paramObject) {
/*  589 */     if (!paramBoolean) {
/*  590 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { paramObject }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, char paramChar1, char paramChar2) {
/*  603 */     if (!paramBoolean) {
/*  604 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar1), Character.valueOf(paramChar2) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, char paramChar, int paramInt) {
/*  617 */     if (!paramBoolean) {
/*  618 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar), Integer.valueOf(paramInt) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, char paramChar, long paramLong) {
/*  631 */     if (!paramBoolean) {
/*  632 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar), Long.valueOf(paramLong) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, char paramChar, Object paramObject) {
/*  646 */     if (!paramBoolean) {
/*  647 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar), paramObject }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, int paramInt, char paramChar) {
/*  660 */     if (!paramBoolean) {
/*  661 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt), Character.valueOf(paramChar) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {
/*  674 */     if (!paramBoolean) {
/*  675 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, int paramInt, long paramLong) {
/*  688 */     if (!paramBoolean) {
/*  689 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, int paramInt, Object paramObject) {
/*  703 */     if (!paramBoolean) {
/*  704 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt), paramObject }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, long paramLong, char paramChar) {
/*  717 */     if (!paramBoolean) {
/*  718 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong), Character.valueOf(paramChar) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, long paramLong, int paramInt) {
/*  731 */     if (!paramBoolean) {
/*  732 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, long paramLong1, long paramLong2) {
/*  745 */     if (!paramBoolean) {
/*  746 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, long paramLong, Object paramObject) {
/*  760 */     if (!paramBoolean) {
/*  761 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong), paramObject }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, Object paramObject, char paramChar) {
/*  775 */     if (!paramBoolean) {
/*  776 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { paramObject, Character.valueOf(paramChar) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, Object paramObject, int paramInt) {
/*  790 */     if (!paramBoolean) {
/*  791 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { paramObject, Integer.valueOf(paramInt) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, Object paramObject, long paramLong) {
/*  805 */     if (!paramBoolean) {
/*  806 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { paramObject, Long.valueOf(paramLong) }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2) {
/*  820 */     if (!paramBoolean) {
/*  821 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { paramObject1, paramObject2 }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
/*  839 */     if (!paramBoolean) {
/*  840 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { paramObject1, paramObject2, paramObject3 }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkState(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) {
/*  859 */     if (!paramBoolean) {
/*  860 */       throw new IllegalStateException(Strings.lenientFormat(paramString, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT) {
/*  888 */     if (paramT == null) {
/*  889 */       throw new NullPointerException();
/*      */     }
/*  891 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, Object paramObject) {
/*  906 */     if (paramT == null) {
/*  907 */       throw new NullPointerException(String.valueOf(paramObject));
/*      */     }
/*  909 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, Object... paramVarArgs) {
/*  932 */     if (paramT == null) {
/*  933 */       throw new NullPointerException(Strings.lenientFormat(paramString, paramVarArgs));
/*      */     }
/*  935 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, char paramChar) {
/*  947 */     if (paramT == null) {
/*  948 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar) }));
/*      */     }
/*  950 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, int paramInt) {
/*  962 */     if (paramT == null) {
/*  963 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt) }));
/*      */     }
/*  965 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, long paramLong) {
/*  977 */     if (paramT == null) {
/*  978 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong) }));
/*      */     }
/*  980 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, Object paramObject) {
/*  993 */     if (paramT == null) {
/*  994 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { paramObject }));
/*      */     }
/*  996 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, char paramChar1, char paramChar2) {
/* 1009 */     if (paramT == null) {
/* 1010 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar1), Character.valueOf(paramChar2) }));
/*      */     }
/* 1012 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, char paramChar, int paramInt) {
/* 1025 */     if (paramT == null) {
/* 1026 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar), Integer.valueOf(paramInt) }));
/*      */     }
/* 1028 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, char paramChar, long paramLong) {
/* 1041 */     if (paramT == null) {
/* 1042 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar), Long.valueOf(paramLong) }));
/*      */     }
/* 1044 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, char paramChar, Object paramObject) {
/* 1057 */     if (paramT == null) {
/* 1058 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { Character.valueOf(paramChar), paramObject }));
/*      */     }
/* 1060 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, int paramInt, char paramChar) {
/* 1073 */     if (paramT == null) {
/* 1074 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt), Character.valueOf(paramChar) }));
/*      */     }
/* 1076 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, int paramInt1, int paramInt2) {
/* 1089 */     if (paramT == null) {
/* 1090 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
/*      */     }
/* 1092 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, int paramInt, long paramLong) {
/* 1105 */     if (paramT == null) {
/* 1106 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
/*      */     }
/* 1108 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, int paramInt, Object paramObject) {
/* 1121 */     if (paramT == null) {
/* 1122 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { Integer.valueOf(paramInt), paramObject }));
/*      */     }
/* 1124 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, long paramLong, char paramChar) {
/* 1137 */     if (paramT == null) {
/* 1138 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong), Character.valueOf(paramChar) }));
/*      */     }
/* 1140 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, long paramLong, int paramInt) {
/* 1153 */     if (paramT == null) {
/* 1154 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
/*      */     }
/* 1156 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, long paramLong1, long paramLong2) {
/* 1169 */     if (paramT == null) {
/* 1170 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
/*      */     }
/* 1172 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, long paramLong, Object paramObject) {
/* 1185 */     if (paramT == null) {
/* 1186 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { Long.valueOf(paramLong), paramObject }));
/*      */     }
/* 1188 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, Object paramObject, char paramChar) {
/* 1201 */     if (paramT == null) {
/* 1202 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { paramObject, Character.valueOf(paramChar) }));
/*      */     }
/* 1204 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, Object paramObject, int paramInt) {
/* 1217 */     if (paramT == null) {
/* 1218 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { paramObject, Integer.valueOf(paramInt) }));
/*      */     }
/* 1220 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, Object paramObject, long paramLong) {
/* 1233 */     if (paramT == null) {
/* 1234 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { paramObject, Long.valueOf(paramLong) }));
/*      */     }
/* 1236 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, Object paramObject1, Object paramObject2) {
/* 1252 */     if (paramT == null) {
/* 1253 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { paramObject1, paramObject2 }));
/*      */     }
/* 1255 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
/* 1272 */     if (paramT == null) {
/* 1273 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { paramObject1, paramObject2, paramObject3 }));
/*      */     }
/* 1275 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T checkNotNull(T paramT, String paramString, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) {
/* 1293 */     if (paramT == null) {
/* 1294 */       throw new NullPointerException(Strings.lenientFormat(paramString, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
/*      */     }
/* 1296 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int checkElementIndex(int paramInt1, int paramInt2) {
/* 1337 */     return checkElementIndex(paramInt1, paramInt2, "index");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int checkElementIndex(int paramInt1, int paramInt2, String paramString) {
/* 1354 */     if (paramInt1 < 0 || paramInt1 >= paramInt2) {
/* 1355 */       throw new IndexOutOfBoundsException(badElementIndex(paramInt1, paramInt2, paramString));
/*      */     }
/* 1357 */     return paramInt1;
/*      */   }
/*      */   
/*      */   private static String badElementIndex(int paramInt1, int paramInt2, String paramString) {
/* 1361 */     if (paramInt1 < 0)
/* 1362 */       return Strings.lenientFormat("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) }); 
/* 1363 */     if (paramInt2 < 0) {
/* 1364 */       throw new IllegalArgumentException((new StringBuilder(26)).append("negative size: ").append(paramInt2).toString());
/*      */     }
/* 1366 */     return Strings.lenientFormat("%s (%s) must be less than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int checkPositionIndex(int paramInt1, int paramInt2) {
/* 1382 */     return checkPositionIndex(paramInt1, paramInt2, "index");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int checkPositionIndex(int paramInt1, int paramInt2, String paramString) {
/* 1399 */     if (paramInt1 < 0 || paramInt1 > paramInt2) {
/* 1400 */       throw new IndexOutOfBoundsException(badPositionIndex(paramInt1, paramInt2, paramString));
/*      */     }
/* 1402 */     return paramInt1;
/*      */   }
/*      */   
/*      */   private static String badPositionIndex(int paramInt1, int paramInt2, String paramString) {
/* 1406 */     if (paramInt1 < 0)
/* 1407 */       return Strings.lenientFormat("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) }); 
/* 1408 */     if (paramInt2 < 0) {
/* 1409 */       throw new IllegalArgumentException((new StringBuilder(26)).append("negative size: ").append(paramInt2).toString());
/*      */     }
/* 1411 */     return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkPositionIndexes(int paramInt1, int paramInt2, int paramInt3) {
/* 1429 */     if (paramInt1 < 0 || paramInt2 < paramInt1 || paramInt2 > paramInt3) {
/* 1430 */       throw new IndexOutOfBoundsException(badPositionIndexes(paramInt1, paramInt2, paramInt3));
/*      */     }
/*      */   }
/*      */   
/*      */   private static String badPositionIndexes(int paramInt1, int paramInt2, int paramInt3) {
/* 1435 */     if (paramInt1 < 0 || paramInt1 > paramInt3) {
/* 1436 */       return badPositionIndex(paramInt1, paramInt3, "start index");
/*      */     }
/* 1438 */     if (paramInt2 < 0 || paramInt2 > paramInt3) {
/* 1439 */       return badPositionIndex(paramInt2, paramInt3, "end index");
/*      */     }
/*      */     
/* 1442 */     return Strings.lenientFormat("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Preconditions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */