/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.Registration;
/*     */ import com.esotericsoftware.kryo.Serializer;
/*     */ import com.esotericsoftware.kryo.SerializerFactory;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CollectionSerializer<T extends Collection>
/*     */   extends Serializer<T>
/*     */ {
/*     */   private boolean elementsCanBeNull = true;
/*     */   private Serializer elementSerializer;
/*     */   private Class elementClass;
/*     */   
/*     */   public CollectionSerializer() {
/*  50 */     setAcceptsNull(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setElementsCanBeNull(boolean paramBoolean) {
/*  56 */     this.elementsCanBeNull = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setElementClass(Class paramClass) {
/*  62 */     this.elementClass = paramClass;
/*     */   }
/*     */   
/*     */   public Class getElementClass() {
/*  66 */     return this.elementClass;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setElementClass(Class paramClass, Serializer paramSerializer) {
/*  71 */     this.elementClass = paramClass;
/*  72 */     this.elementSerializer = paramSerializer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setElementSerializer(Serializer paramSerializer) {
/*  78 */     this.elementSerializer = paramSerializer;
/*     */   }
/*     */   
/*     */   public Serializer getElementSerializer() {
/*  82 */     return this.elementSerializer;
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
/*     */   public void write(Kryo paramKryo, Output paramOutput, T paramT) {
/*     */     // Byte code:
/*     */     //   0: aload_3
/*     */     //   1: ifnonnull -> 10
/*     */     //   4: aload_2
/*     */     //   5: iconst_0
/*     */     //   6: invokevirtual writeByte : (B)V
/*     */     //   9: return
/*     */     //   10: aload_3
/*     */     //   11: invokeinterface size : ()I
/*     */     //   16: dup
/*     */     //   17: istore #4
/*     */     //   19: ifne -> 35
/*     */     //   22: aload_2
/*     */     //   23: iconst_1
/*     */     //   24: invokevirtual writeByte : (I)V
/*     */     //   27: aload_0
/*     */     //   28: aload_1
/*     */     //   29: aload_2
/*     */     //   30: aload_3
/*     */     //   31: invokevirtual writeHeader : (Lcom/esotericsoftware/kryo/Kryo;Lcom/esotericsoftware/kryo/io/Output;Ljava/util/Collection;)V
/*     */     //   34: return
/*     */     //   35: aload_0
/*     */     //   36: getfield elementsCanBeNull : Z
/*     */     //   39: istore #5
/*     */     //   41: aload_0
/*     */     //   42: getfield elementSerializer : Lcom/esotericsoftware/kryo/Serializer;
/*     */     //   45: dup
/*     */     //   46: astore #6
/*     */     //   48: ifnonnull -> 83
/*     */     //   51: aload_1
/*     */     //   52: invokevirtual getGenerics : ()Lcom/esotericsoftware/kryo/util/Generics;
/*     */     //   55: invokeinterface nextGenericClass : ()Ljava/lang/Class;
/*     */     //   60: dup
/*     */     //   61: astore #7
/*     */     //   63: ifnull -> 83
/*     */     //   66: aload_1
/*     */     //   67: aload #7
/*     */     //   69: invokevirtual isFinal : (Ljava/lang/Class;)Z
/*     */     //   72: ifeq -> 83
/*     */     //   75: aload_1
/*     */     //   76: aload #7
/*     */     //   78: invokevirtual getSerializer : (Ljava/lang/Class;)Lcom/esotericsoftware/kryo/Serializer;
/*     */     //   81: astore #6
/*     */     //   83: aload #6
/*     */     //   85: ifnull -> 178
/*     */     //   88: iload #5
/*     */     //   90: ifeq -> 158
/*     */     //   93: aload_3
/*     */     //   94: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   99: astore #7
/*     */     //   101: aload #7
/*     */     //   103: invokeinterface hasNext : ()Z
/*     */     //   108: ifeq -> 141
/*     */     //   111: aload #7
/*     */     //   113: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   118: dup
/*     */     //   119: astore #8
/*     */     //   121: ifnonnull -> 138
/*     */     //   124: aload_2
/*     */     //   125: iconst_1
/*     */     //   126: iload #4
/*     */     //   128: iconst_1
/*     */     //   129: iadd
/*     */     //   130: iconst_1
/*     */     //   131: invokevirtual writeVarIntFlag : (ZIZ)I
/*     */     //   134: pop
/*     */     //   135: goto -> 168
/*     */     //   138: goto -> 101
/*     */     //   141: aload_2
/*     */     //   142: iconst_0
/*     */     //   143: iload #4
/*     */     //   145: iconst_1
/*     */     //   146: iadd
/*     */     //   147: iconst_1
/*     */     //   148: invokevirtual writeVarIntFlag : (ZIZ)I
/*     */     //   151: pop
/*     */     //   152: iconst_0
/*     */     //   153: istore #5
/*     */     //   155: goto -> 168
/*     */     //   158: aload_2
/*     */     //   159: iload #4
/*     */     //   161: iconst_1
/*     */     //   162: iadd
/*     */     //   163: iconst_1
/*     */     //   164: invokevirtual writeVarInt : (IZ)I
/*     */     //   167: pop
/*     */     //   168: aload_0
/*     */     //   169: aload_1
/*     */     //   170: aload_2
/*     */     //   171: aload_3
/*     */     //   172: invokevirtual writeHeader : (Lcom/esotericsoftware/kryo/Kryo;Lcom/esotericsoftware/kryo/io/Output;Ljava/util/Collection;)V
/*     */     //   175: goto -> 339
/*     */     //   178: aconst_null
/*     */     //   179: astore #7
/*     */     //   181: iconst_0
/*     */     //   182: istore #8
/*     */     //   184: aload_3
/*     */     //   185: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   190: astore #9
/*     */     //   192: aload #9
/*     */     //   194: invokeinterface hasNext : ()Z
/*     */     //   199: ifeq -> 270
/*     */     //   202: aload #9
/*     */     //   204: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   209: dup
/*     */     //   210: astore #10
/*     */     //   212: ifnonnull -> 221
/*     */     //   215: iconst_1
/*     */     //   216: istore #8
/*     */     //   218: goto -> 192
/*     */     //   221: aload #7
/*     */     //   223: ifnonnull -> 236
/*     */     //   226: aload #10
/*     */     //   228: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   231: astore #7
/*     */     //   233: goto -> 192
/*     */     //   236: aload #10
/*     */     //   238: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   241: aload #7
/*     */     //   243: if_acmpeq -> 267
/*     */     //   246: aload_2
/*     */     //   247: iconst_0
/*     */     //   248: iload #4
/*     */     //   250: iconst_1
/*     */     //   251: iadd
/*     */     //   252: iconst_1
/*     */     //   253: invokevirtual writeVarIntFlag : (ZIZ)I
/*     */     //   256: pop
/*     */     //   257: aload_0
/*     */     //   258: aload_1
/*     */     //   259: aload_2
/*     */     //   260: aload_3
/*     */     //   261: invokevirtual writeHeader : (Lcom/esotericsoftware/kryo/Kryo;Lcom/esotericsoftware/kryo/io/Output;Ljava/util/Collection;)V
/*     */     //   264: goto -> 339
/*     */     //   267: goto -> 192
/*     */     //   270: aload_2
/*     */     //   271: iconst_1
/*     */     //   272: iload #4
/*     */     //   274: iconst_1
/*     */     //   275: iadd
/*     */     //   276: iconst_1
/*     */     //   277: invokevirtual writeVarIntFlag : (ZIZ)I
/*     */     //   280: pop
/*     */     //   281: aload_0
/*     */     //   282: aload_1
/*     */     //   283: aload_2
/*     */     //   284: aload_3
/*     */     //   285: invokevirtual writeHeader : (Lcom/esotericsoftware/kryo/Kryo;Lcom/esotericsoftware/kryo/io/Output;Ljava/util/Collection;)V
/*     */     //   288: aload #7
/*     */     //   290: ifnonnull -> 308
/*     */     //   293: aload_2
/*     */     //   294: iconst_0
/*     */     //   295: invokevirtual writeByte : (B)V
/*     */     //   298: aload_1
/*     */     //   299: invokevirtual getGenerics : ()Lcom/esotericsoftware/kryo/util/Generics;
/*     */     //   302: invokeinterface popGenericType : ()V
/*     */     //   307: return
/*     */     //   308: aload_1
/*     */     //   309: aload_2
/*     */     //   310: aload #7
/*     */     //   312: invokevirtual writeClass : (Lcom/esotericsoftware/kryo/io/Output;Ljava/lang/Class;)Lcom/esotericsoftware/kryo/Registration;
/*     */     //   315: pop
/*     */     //   316: aload_1
/*     */     //   317: aload #7
/*     */     //   319: invokevirtual getSerializer : (Ljava/lang/Class;)Lcom/esotericsoftware/kryo/Serializer;
/*     */     //   322: astore #6
/*     */     //   324: iload #5
/*     */     //   326: ifeq -> 339
/*     */     //   329: aload_2
/*     */     //   330: iload #8
/*     */     //   332: invokevirtual writeBoolean : (Z)V
/*     */     //   335: iload #8
/*     */     //   337: istore #5
/*     */     //   339: aload #6
/*     */     //   341: ifnull -> 433
/*     */     //   344: iload #5
/*     */     //   346: ifeq -> 391
/*     */     //   349: aload_3
/*     */     //   350: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   355: astore #7
/*     */     //   357: aload #7
/*     */     //   359: invokeinterface hasNext : ()Z
/*     */     //   364: ifeq -> 388
/*     */     //   367: aload #7
/*     */     //   369: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   374: astore #8
/*     */     //   376: aload_1
/*     */     //   377: aload_2
/*     */     //   378: aload #8
/*     */     //   380: aload #6
/*     */     //   382: invokevirtual writeObjectOrNull : (Lcom/esotericsoftware/kryo/io/Output;Ljava/lang/Object;Lcom/esotericsoftware/kryo/Serializer;)V
/*     */     //   385: goto -> 357
/*     */     //   388: goto -> 470
/*     */     //   391: aload_3
/*     */     //   392: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   397: astore #7
/*     */     //   399: aload #7
/*     */     //   401: invokeinterface hasNext : ()Z
/*     */     //   406: ifeq -> 430
/*     */     //   409: aload #7
/*     */     //   411: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   416: astore #8
/*     */     //   418: aload_1
/*     */     //   419: aload_2
/*     */     //   420: aload #8
/*     */     //   422: aload #6
/*     */     //   424: invokevirtual writeObject : (Lcom/esotericsoftware/kryo/io/Output;Ljava/lang/Object;Lcom/esotericsoftware/kryo/Serializer;)V
/*     */     //   427: goto -> 399
/*     */     //   430: goto -> 470
/*     */     //   433: aload_3
/*     */     //   434: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   439: astore #7
/*     */     //   441: aload #7
/*     */     //   443: invokeinterface hasNext : ()Z
/*     */     //   448: ifeq -> 470
/*     */     //   451: aload #7
/*     */     //   453: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   458: astore #8
/*     */     //   460: aload_1
/*     */     //   461: aload_2
/*     */     //   462: aload #8
/*     */     //   464: invokevirtual writeClassAndObject : (Lcom/esotericsoftware/kryo/io/Output;Ljava/lang/Object;)V
/*     */     //   467: goto -> 441
/*     */     //   470: aload_1
/*     */     //   471: invokevirtual getGenerics : ()Lcom/esotericsoftware/kryo/util/Generics;
/*     */     //   474: invokeinterface popGenericType : ()V
/*     */     //   479: return
/*     */     //   480: astore_2
/*     */     //   481: aload_1
/*     */     //   482: invokevirtual getGenerics : ()Lcom/esotericsoftware/kryo/util/Generics;
/*     */     //   485: invokeinterface popGenericType : ()V
/*     */     //   490: aload_2
/*     */     //   491: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #86	-> 0
/*     */     //   #87	-> 4
/*     */     //   #88	-> 9
/*     */     //   #91	-> 10
/*     */     //   #92	-> 17
/*     */     //   #93	-> 22
/*     */     //   #94	-> 27
/*     */     //   #95	-> 34
/*     */     //   #98	-> 35
/*     */     //   #99	-> 41
/*     */     //   #100	-> 46
/*     */     //   #101	-> 51
/*     */     //   #102	-> 61
/*     */     //   #106	-> 83
/*     */     //   #108	-> 88
/*     */     //   #109	-> 93
/*     */     //   #110	-> 119
/*     */     //   #111	-> 124
/*     */     //   #112	-> 135
/*     */     //   #114	-> 138
/*     */     //   #115	-> 141
/*     */     //   #116	-> 152
/*     */     //   #118	-> 158
/*     */     //   #119	-> 168
/*     */     //   #121	-> 178
/*     */     //   #122	-> 181
/*     */     //   #123	-> 184
/*     */     //   #124	-> 210
/*     */     //   #125	-> 215
/*     */     //   #126	-> 221
/*     */     //   #127	-> 226
/*     */     //   #128	-> 236
/*     */     //   #129	-> 246
/*     */     //   #130	-> 257
/*     */     //   #131	-> 264
/*     */     //   #133	-> 267
/*     */     //   #134	-> 270
/*     */     //   #135	-> 281
/*     */     //   #136	-> 288
/*     */     //   #137	-> 293
/*     */     //   #162	-> 298
/*     */     //   #138	-> 307
/*     */     //   #141	-> 308
/*     */     //   #142	-> 316
/*     */     //   #143	-> 324
/*     */     //   #144	-> 329
/*     */     //   #145	-> 335
/*     */     //   #149	-> 339
/*     */     //   #150	-> 344
/*     */     //   #151	-> 349
/*     */     //   #152	-> 376
/*     */     //   #154	-> 391
/*     */     //   #155	-> 418
/*     */     //   #158	-> 433
/*     */     //   #159	-> 460
/*     */     //   #162	-> 470
/*     */     //   #163	-> 479
/*     */     //   #162	-> 480
/*     */     //   #163	-> 490
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   83	298	480	finally
/*     */     //   308	470	480	finally
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
/*     */   protected void writeHeader(Kryo paramKryo, Output paramOutput, T paramT) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected T create(Kryo paramKryo, Input paramInput, Class<? extends T> paramClass, int paramInt) {
/* 175 */     if (paramClass == ArrayList.class) return (T)new ArrayList(paramInt); 
/* 176 */     if (paramClass == HashSet.class) return (T)new HashSet(Math.max((int)(paramInt / 0.75F) + 1, 16)); 
/*     */     Collection collection;
/* 178 */     if (collection = (Collection)paramKryo.newInstance(paramClass) instanceof ArrayList) ((ArrayList)collection).ensureCapacity(paramInt); 
/* 179 */     return (T)collection;
/*     */   }
/*     */   
/*     */   public T read(Kryo paramKryo, Input paramInput, Class<? extends T> paramClass) {
/* 183 */     Class<? extends T> clazz1 = this.elementClass; Serializer serializer;
/*     */     Class<? extends T> clazz2;
/* 185 */     if ((serializer = this.elementSerializer) == null && (
/*     */       
/* 187 */       clazz2 = paramKryo.getGenerics().nextGenericClass()) != null && paramKryo.isFinal(clazz2)) {
/* 188 */       serializer = paramKryo.getSerializer(clazz2);
/* 189 */       clazz1 = clazz2;
/*     */     } 
/*     */     
/*     */     try {
/*     */       Class<? extends T> clazz;
/*     */       
/*     */       int i;
/* 196 */       boolean bool = this.elementsCanBeNull;
/* 197 */       if (serializer != null) {
/* 198 */         if (bool) {
/* 199 */           bool = paramInput.readVarIntFlag();
/* 200 */           i = paramInput.readVarIntFlag(true);
/*     */         } else {
/* 202 */           i = paramInput.readVarInt(true);
/* 203 */         }  if (i == 0) return null;
/*     */         
/* 205 */         i--;
/* 206 */         clazz2 = (Class<? extends T>)create(paramKryo, paramInput, paramClass, i);
/* 207 */         paramKryo.reference(clazz2);
/*     */         
/* 209 */         if (i == 0) return (T)clazz2; 
/*     */       } else {
/* 211 */         boolean bool1 = paramInput.readVarIntFlag();
/*     */         
/* 213 */         if ((i = paramInput.readVarIntFlag(true)) == 0) { paramClass = null; return (T)paramClass; }
/*     */         
/* 215 */         i--;
/* 216 */         clazz2 = (Class<? extends T>)create(paramKryo, paramInput, paramClass, i);
/* 217 */         paramKryo.reference(clazz2);
/*     */         
/* 219 */         if (i == 0) { paramClass = clazz2; return (T)paramClass; }
/*     */         
/* 221 */         if (bool1) {
/*     */           Registration registration;
/* 223 */           if ((registration = paramKryo.readClass(paramInput)) == null) {
/* 224 */             for (byte b = 0; b < i; b++)
/* 225 */               clazz2.add(null); 
/* 226 */             paramKryo.getGenerics().popGenericType();
/* 227 */             clazz = clazz2; return (T)clazz;
/*     */           } 
/* 229 */           clazz1 = registration.getType();
/* 230 */           serializer = paramKryo.getSerializer(clazz1);
/* 231 */           if (bool) bool = clazz.readBoolean();
/*     */         
/*     */         } 
/*     */       } 
/* 235 */       if (serializer != null) {
/* 236 */         if (bool) {
/* 237 */           for (byte b = 0; b < i; b++)
/* 238 */             clazz2.add((T)paramKryo.readObjectOrNull((Input)clazz, clazz1, serializer)); 
/*     */         } else {
/* 240 */           for (byte b = 0; b < i; b++)
/* 241 */             clazz2.add((T)paramKryo.readObject((Input)clazz, clazz1, serializer)); 
/*     */         } 
/*     */       } else {
/* 244 */         for (byte b = 0; b < i; b++)
/* 245 */           clazz2.add((T)paramKryo.readClassAndObject((Input)clazz)); 
/*     */       } 
/* 247 */       return (T)clazz2;
/*     */     } finally {
/* 249 */       paramKryo.getGenerics().popGenericType();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected T createCopy(Kryo paramKryo, T paramT) {
/* 256 */     return (T)paramKryo.newInstance(paramT.getClass());
/*     */   }
/*     */   
/*     */   public T copy(Kryo paramKryo, T paramT) {
/* 260 */     T t = createCopy(paramKryo, paramT);
/* 261 */     paramKryo.reference(t);
/* 262 */     for (Object object : paramT)
/* 263 */       t.add(paramKryo.copy(object)); 
/* 264 */     return t;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   @Target({ElementType.FIELD})
/*     */   public static @interface BindCollection {
/*     */     Class elementClass() default Object.class;
/*     */     
/*     */     Class<? extends Serializer> elementSerializer() default Serializer.class;
/*     */     
/*     */     Class<? extends SerializerFactory> elementSerializerFactory() default SerializerFactory.class;
/*     */     
/*     */     boolean elementsCanBeNull() default true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\CollectionSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */