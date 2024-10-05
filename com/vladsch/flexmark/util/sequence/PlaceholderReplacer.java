package com.vladsch.flexmark.util.sequence;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class PlaceholderReplacer {
  public static <T> void replaceAll(Collection<T> paramCollection, Function<String, String> paramFunction, char paramChar1, char paramChar2, Function<T, String> paramFunction1, BiConsumer<T, String> paramBiConsumer) {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface isEmpty : ()Z
    //   6: ifeq -> 10
    //   9: return
    //   10: aconst_null
    //   11: astore #6
    //   13: aload_0
    //   14: invokeinterface iterator : ()Ljava/util/Iterator;
    //   19: astore_0
    //   20: aload_0
    //   21: invokeinterface hasNext : ()Z
    //   26: ifeq -> 383
    //   29: aload_0
    //   30: invokeinterface next : ()Ljava/lang/Object;
    //   35: astore #7
    //   37: aload #4
    //   39: aload #7
    //   41: invokeinterface apply : (Ljava/lang/Object;)Ljava/lang/Object;
    //   46: checkcast java/lang/String
    //   49: dup
    //   50: astore #8
    //   52: invokevirtual length : ()I
    //   55: istore #9
    //   57: iconst_0
    //   58: istore #10
    //   60: aconst_null
    //   61: astore #11
    //   63: iload #10
    //   65: iload #9
    //   67: if_icmpge -> 361
    //   70: aload #6
    //   72: ifnonnull -> 211
    //   75: aload #8
    //   77: iload_2
    //   78: iload #10
    //   80: invokevirtual indexOf : (II)I
    //   83: dup
    //   84: istore #12
    //   86: iconst_m1
    //   87: if_icmpne -> 135
    //   90: iload #10
    //   92: ifle -> 361
    //   95: aload #11
    //   97: ifnull -> 116
    //   100: aload #11
    //   102: aload #8
    //   104: iload #10
    //   106: invokevirtual substring : (I)Ljava/lang/String;
    //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: goto -> 361
    //   116: aload #5
    //   118: aload #7
    //   120: aload #8
    //   122: iload #10
    //   124: invokevirtual substring : (I)Ljava/lang/String;
    //   127: invokeinterface accept : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   132: goto -> 361
    //   135: new java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial <init> : ()V
    //   142: astore #6
    //   144: iload #10
    //   146: iload #12
    //   148: if_icmpge -> 180
    //   151: aload #11
    //   153: ifnonnull -> 165
    //   156: new java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial <init> : ()V
    //   163: astore #11
    //   165: aload #11
    //   167: aload #8
    //   169: iload #10
    //   171: iload #12
    //   173: invokevirtual substring : (II)Ljava/lang/String;
    //   176: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: iload #12
    //   182: iconst_1
    //   183: iadd
    //   184: dup
    //   185: istore #10
    //   187: iload #9
    //   189: if_icmplt -> 208
    //   192: aload #11
    //   194: ifnonnull -> 208
    //   197: aload #5
    //   199: aload #7
    //   201: ldc ''
    //   203: invokeinterface accept : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   208: goto -> 63
    //   211: aload #8
    //   213: iload_3
    //   214: iload #10
    //   216: invokevirtual indexOf : (II)I
    //   219: dup
    //   220: istore #12
    //   222: iconst_m1
    //   223: if_icmpne -> 262
    //   226: aload #6
    //   228: aload #8
    //   230: iload #10
    //   232: invokevirtual substring : (I)Ljava/lang/String;
    //   235: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload #11
    //   241: ifnonnull -> 255
    //   244: aload #5
    //   246: aload #7
    //   248: ldc ''
    //   250: invokeinterface accept : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   255: iload #9
    //   257: istore #10
    //   259: goto -> 63
    //   262: aload #6
    //   264: aload #8
    //   266: iload #10
    //   268: iload #12
    //   270: invokevirtual substring : (II)Ljava/lang/String;
    //   273: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: iload #12
    //   279: iconst_1
    //   280: iadd
    //   281: istore #10
    //   283: aload #6
    //   285: invokevirtual toString : ()Ljava/lang/String;
    //   288: astore #12
    //   290: aload_1
    //   291: aload #12
    //   293: invokeinterface apply : (Ljava/lang/Object;)Ljava/lang/Object;
    //   298: checkcast java/lang/String
    //   301: astore #13
    //   303: aconst_null
    //   304: astore #6
    //   306: aload #13
    //   308: ifnonnull -> 336
    //   311: new java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial <init> : ()V
    //   318: iload_2
    //   319: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   322: aload #12
    //   324: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: iload_3
    //   328: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   331: invokevirtual toString : ()Ljava/lang/String;
    //   334: astore #13
    //   336: aload #11
    //   338: ifnonnull -> 350
    //   341: new java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial <init> : ()V
    //   348: astore #11
    //   350: aload #11
    //   352: aload #13
    //   354: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: goto -> 63
    //   361: aload #11
    //   363: ifnull -> 380
    //   366: aload #5
    //   368: aload #7
    //   370: aload #11
    //   372: invokevirtual toString : ()Ljava/lang/String;
    //   375: invokeinterface accept : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   380: goto -> 20
    //   383: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #14	-> 0
    //   #15	-> 10
    //   #18	-> 13
    //   #19	-> 37
    //   #21	-> 50
    //   #22	-> 57
    //   #23	-> 60
    //   #25	-> 63
    //   #26	-> 70
    //   #27	-> 75
    //   #28	-> 84
    //   #30	-> 90
    //   #32	-> 95
    //   #33	-> 116
    //   #37	-> 135
    //   #38	-> 144
    //   #40	-> 151
    //   #41	-> 165
    //   #43	-> 180
    //   #44	-> 185
    //   #46	-> 208
    //   #47	-> 211
    //   #49	-> 220
    //   #50	-> 226
    //   #51	-> 239
    //   #52	-> 255
    //   #55	-> 262
    //   #56	-> 277
    //   #58	-> 283
    //   #59	-> 290
    //   #60	-> 303
    //   #62	-> 306
    //   #63	-> 311
    //   #66	-> 336
    //   #67	-> 350
    //   #69	-> 358
    //   #72	-> 361
    //   #74	-> 366
    //   #76	-> 380
    //   #77	-> 383
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\PlaceholderReplacer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */