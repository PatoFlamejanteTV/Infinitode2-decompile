/*     */ package com.esotericsoftware.kryo.serializers;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.util.Util;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*     */ public final class ImmutableCollectionsSerializers
/*     */ {
/*     */   public static void addDefaultSerializers(Kryo paramKryo) {
/*  37 */     if (Util.isClassAvailable("java.util.ImmutableCollections")) {
/*  38 */       JdkImmutableListSerializer.addDefaultSerializers(paramKryo);
/*  39 */       JdkImmutableMapSerializer.addDefaultSerializers(paramKryo);
/*  40 */       JdkImmutableSetSerializer.addDefaultSerializers(paramKryo);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerSerializers(Kryo paramKryo) {
/*  48 */     JdkImmutableListSerializer.registerSerializers(paramKryo);
/*  49 */     JdkImmutableMapSerializer.registerSerializers(paramKryo);
/*  50 */     JdkImmutableSetSerializer.registerSerializers(paramKryo);
/*     */   }
/*     */   
/*     */   public static final class JdkImmutableListSerializer
/*     */     extends CollectionSerializer<List<Object>> {
/*     */     private JdkImmutableListSerializer() {
/*  56 */       setElementsCanBeNull(false);
/*     */     }
/*     */ 
/*     */     
/*     */     protected final List<Object> create(Kryo param1Kryo, Input param1Input, Class<? extends List<Object>> param1Class, int param1Int) {
/*  61 */       return new ArrayList(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     protected final List<Object> createCopy(Kryo param1Kryo, List<Object> param1List) {
/*  66 */       return new ArrayList(param1List.size());
/*     */     }
/*     */ 
/*     */     
/*     */     public final List<Object> read(Kryo param1Kryo, Input param1Input, Class<? extends List<Object>> param1Class) {
/*     */       List list;
/*  72 */       if ((list = super.read(param1Kryo, param1Input, param1Class)) == null) {
/*  73 */         return null;
/*     */       }
/*  75 */       return List.of(list.toArray());
/*     */     }
/*     */ 
/*     */     
/*     */     public final List<Object> copy(Kryo param1Kryo, List<Object> param1List) {
/*     */       List<?> list;
/*  81 */       return List.copyOf(list = super.copy(param1Kryo, param1List));
/*     */     }
/*     */     
/*     */     static void addDefaultSerializers(Kryo param1Kryo) {
/*  85 */       JdkImmutableListSerializer jdkImmutableListSerializer = new JdkImmutableListSerializer();
/*  86 */       param1Kryo.addDefaultSerializer(List.of().getClass(), jdkImmutableListSerializer);
/*  87 */       param1Kryo.addDefaultSerializer(List.<Integer>of(Integer.valueOf(1)).getClass(), jdkImmutableListSerializer);
/*  88 */       param1Kryo.addDefaultSerializer(List.<Integer>of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)).getClass(), jdkImmutableListSerializer);
/*  89 */       param1Kryo.addDefaultSerializer(List.<Integer>of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)).subList(0, 2).getClass(), jdkImmutableListSerializer);
/*     */     }
/*     */     
/*     */     static void registerSerializers(Kryo param1Kryo) {
/*  93 */       JdkImmutableListSerializer jdkImmutableListSerializer = new JdkImmutableListSerializer();
/*  94 */       param1Kryo.register(List.of().getClass(), jdkImmutableListSerializer);
/*  95 */       param1Kryo.register(List.<Integer>of(Integer.valueOf(1)).getClass(), jdkImmutableListSerializer);
/*  96 */       param1Kryo.register(List.<Integer>of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)).getClass(), jdkImmutableListSerializer);
/*  97 */       param1Kryo.register(List.<Integer>of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)).subList(0, 2).getClass(), jdkImmutableListSerializer);
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class JdkImmutableMapSerializer
/*     */     extends MapSerializer<Map<Object, Object>> {
/*     */     private JdkImmutableMapSerializer() {
/* 104 */       setKeysCanBeNull(false);
/* 105 */       setValuesCanBeNull(false);
/*     */     }
/*     */ 
/*     */     
/*     */     protected final Map<Object, Object> create(Kryo param1Kryo, Input param1Input, Class<? extends Map<Object, Object>> param1Class, int param1Int) {
/* 110 */       return new HashMap<>();
/*     */     }
/*     */ 
/*     */     
/*     */     protected final Map<Object, Object> createCopy(Kryo param1Kryo, Map<Object, Object> param1Map) {
/* 115 */       return new HashMap<>();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final Map<Object, Object> read(Kryo param1Kryo, Input param1Input, Class<? extends Map<Object, Object>> param1Class) {
/* 121 */       if ((param1Kryo = (Kryo)super.read(param1Kryo, param1Input, param1Class)) == null) {
/* 122 */         return null;
/*     */       }
/* 124 */       return Map.copyOf((Map<?, ?>)param1Kryo);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final Map<Object, Object> copy(Kryo param1Kryo, Map<Object, Object> param1Map) {
/* 130 */       return Map.copyOf((Map<?, ?>)(param1Kryo = (Kryo)super.copy(param1Kryo, param1Map)));
/*     */     }
/*     */     
/*     */     static void addDefaultSerializers(Kryo param1Kryo) {
/* 134 */       JdkImmutableMapSerializer jdkImmutableMapSerializer = new JdkImmutableMapSerializer();
/* 135 */       param1Kryo.addDefaultSerializer(Map.of().getClass(), jdkImmutableMapSerializer);
/* 136 */       param1Kryo.addDefaultSerializer(Map.<Integer, Integer>of(Integer.valueOf(1), Integer.valueOf(2)).getClass(), jdkImmutableMapSerializer);
/* 137 */       param1Kryo.addDefaultSerializer(Map.<Integer, Integer>of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)).getClass(), jdkImmutableMapSerializer);
/*     */     }
/*     */     
/*     */     static void registerSerializers(Kryo param1Kryo) {
/* 141 */       JdkImmutableMapSerializer jdkImmutableMapSerializer = new JdkImmutableMapSerializer();
/* 142 */       param1Kryo.register(Map.of().getClass(), jdkImmutableMapSerializer);
/* 143 */       param1Kryo.register(Map.<Integer, Integer>of(Integer.valueOf(1), Integer.valueOf(2)).getClass(), jdkImmutableMapSerializer);
/* 144 */       param1Kryo.register(Map.<Integer, Integer>of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)).getClass(), jdkImmutableMapSerializer);
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class JdkImmutableSetSerializer
/*     */     extends CollectionSerializer<Set<Object>> {
/*     */     private JdkImmutableSetSerializer() {
/* 151 */       setElementsCanBeNull(false);
/*     */     }
/*     */ 
/*     */     
/*     */     protected final Set<Object> create(Kryo param1Kryo, Input param1Input, Class<? extends Set<Object>> param1Class, int param1Int) {
/* 156 */       return new HashSet();
/*     */     }
/*     */ 
/*     */     
/*     */     protected final Set<Object> createCopy(Kryo param1Kryo, Set<Object> param1Set) {
/* 161 */       return new HashSet();
/*     */     }
/*     */ 
/*     */     
/*     */     public final Set<Object> read(Kryo param1Kryo, Input param1Input, Class<? extends Set<Object>> param1Class) {
/*     */       Set set;
/* 167 */       if ((set = super.read(param1Kryo, param1Input, param1Class)) == null) {
/* 168 */         return null;
/*     */       }
/* 170 */       return Set.of(set.toArray());
/*     */     }
/*     */ 
/*     */     
/*     */     public final Set<Object> copy(Kryo param1Kryo, Set<Object> param1Set) {
/*     */       Set<?> set;
/* 176 */       return Set.copyOf(set = super.copy(param1Kryo, param1Set));
/*     */     }
/*     */     
/*     */     static void addDefaultSerializers(Kryo param1Kryo) {
/* 180 */       JdkImmutableSetSerializer jdkImmutableSetSerializer = new JdkImmutableSetSerializer();
/* 181 */       param1Kryo.addDefaultSerializer(Set.of().getClass(), jdkImmutableSetSerializer);
/* 182 */       param1Kryo.addDefaultSerializer(Set.<Integer>of(Integer.valueOf(1)).getClass(), jdkImmutableSetSerializer);
/* 183 */       param1Kryo.addDefaultSerializer(Set.<Integer>of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)).getClass(), jdkImmutableSetSerializer);
/*     */     }
/*     */     
/*     */     static void registerSerializers(Kryo param1Kryo) {
/* 187 */       JdkImmutableSetSerializer jdkImmutableSetSerializer = new JdkImmutableSetSerializer();
/* 188 */       param1Kryo.register(Set.of().getClass(), jdkImmutableSetSerializer);
/* 189 */       param1Kryo.register(Set.<Integer>of(Integer.valueOf(1)).getClass(), jdkImmutableSetSerializer);
/* 190 */       param1Kryo.register(Set.<Integer>of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)).getClass(), jdkImmutableSetSerializer);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\serializers\ImmutableCollectionsSerializers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */