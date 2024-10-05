/*     */ package com.badlogic.gdx.graphics.g3d.particles;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.reflect.ArrayReflection;
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
/*     */ public class ParallelArray
/*     */ {
/*     */   Array<Channel> arrays;
/*     */   public int capacity;
/*     */   public int size;
/*     */   
/*     */   public static class ChannelDescriptor
/*     */   {
/*     */     public int id;
/*     */     public Class<?> type;
/*     */     public int count;
/*     */     
/*     */     public ChannelDescriptor(int param1Int1, Class<?> param1Class, int param1Int2) {
/*  37 */       this.id = param1Int1;
/*  38 */       this.type = param1Class;
/*  39 */       this.count = param1Int2;
/*     */     }
/*     */   }
/*     */   
/*     */   public abstract class Channel
/*     */   {
/*     */     public int id;
/*     */     public Object data;
/*     */     public int strideSize;
/*     */     
/*     */     public Channel(int param1Int1, Object param1Object, int param1Int2) {
/*  50 */       this.id = param1Int1;
/*  51 */       this.strideSize = param1Int2;
/*  52 */       this.data = param1Object;
/*     */     }
/*     */ 
/*     */     
/*     */     public abstract void add(int param1Int, Object... param1VarArgs);
/*     */ 
/*     */     
/*     */     public abstract void swap(int param1Int1, int param1Int2);
/*     */ 
/*     */     
/*     */     protected abstract void setCapacity(int param1Int);
/*     */   }
/*     */   
/*     */   public class FloatChannel
/*     */     extends Channel
/*     */   {
/*     */     public float[] data;
/*     */     
/*     */     public FloatChannel(int param1Int1, int param1Int2, int param1Int3) {
/*  71 */       super(param1Int1, new float[param1Int3 * param1Int2], param1Int2);
/*  72 */       this.data = (float[])super.data;
/*     */     }
/*     */     public void add(int param1Int, Object... param1VarArgs) {
/*     */       int i;
/*     */       byte b;
/*  77 */       for (i = (param1Int = this.strideSize * ParallelArray.this.size) + this.strideSize, b = 0; param1Int < i; param1Int++, b++) {
/*  78 */         this.data[param1Int] = ((Float)param1VarArgs[b]).floatValue();
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void swap(int param1Int1, int param1Int2) {
/*  85 */       param1Int1 = this.strideSize * param1Int1;
/*  86 */       param1Int2 = this.strideSize * param1Int2;
/*  87 */       for (int i = param1Int1 + this.strideSize; param1Int1 < i; param1Int1++, param1Int2++) {
/*  88 */         float f = this.data[param1Int1];
/*  89 */         this.data[param1Int1] = this.data[param1Int2];
/*  90 */         this.data[param1Int2] = f;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void setCapacity(int param1Int) {
/*  96 */       float[] arrayOfFloat = new float[this.strideSize * param1Int];
/*  97 */       System.arraycopy(this.data, 0, arrayOfFloat, 0, Math.min(this.data.length, arrayOfFloat.length));
/*  98 */       this.data = arrayOfFloat;
/*     */     }
/*     */   }
/*     */   
/*     */   public class IntChannel extends Channel {
/*     */     public int[] data;
/*     */     
/*     */     public IntChannel(int param1Int1, int param1Int2, int param1Int3) {
/* 106 */       super(param1Int1, new int[param1Int3 * param1Int2], param1Int2);
/* 107 */       this.data = (int[])super.data;
/*     */     }
/*     */     public void add(int param1Int, Object... param1VarArgs) {
/*     */       int i;
/*     */       byte b;
/* 112 */       for (i = (param1Int = this.strideSize * ParallelArray.this.size) + this.strideSize, b = 0; param1Int < i; param1Int++, b++) {
/* 113 */         this.data[param1Int] = ((Integer)param1VarArgs[b]).intValue();
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void swap(int param1Int1, int param1Int2) {
/* 120 */       param1Int1 = this.strideSize * param1Int1;
/* 121 */       param1Int2 = this.strideSize * param1Int2;
/* 122 */       for (int i = param1Int1 + this.strideSize; param1Int1 < i; param1Int1++, param1Int2++) {
/* 123 */         int j = this.data[param1Int1];
/* 124 */         this.data[param1Int1] = this.data[param1Int2];
/* 125 */         this.data[param1Int2] = j;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void setCapacity(int param1Int) {
/* 131 */       int[] arrayOfInt = new int[this.strideSize * param1Int];
/* 132 */       System.arraycopy(this.data, 0, arrayOfInt, 0, Math.min(this.data.length, arrayOfInt.length));
/* 133 */       this.data = arrayOfInt;
/*     */     }
/*     */   }
/*     */   
/*     */   public class ObjectChannel<T>
/*     */     extends Channel {
/*     */     Class<T> componentType;
/*     */     public T[] data;
/*     */     
/*     */     public ObjectChannel(int param1Int1, int param1Int2, int param1Int3, Class<T> param1Class) {
/* 143 */       super(param1Int1, ArrayReflection.newInstance(param1Class, param1Int3 * param1Int2), param1Int2);
/* 144 */       this.componentType = param1Class;
/* 145 */       this.data = (T[])super.data;
/*     */     }
/*     */     public void add(int param1Int, Object... param1VarArgs) {
/*     */       int i;
/*     */       byte b;
/* 150 */       for (i = (param1Int = this.strideSize * ParallelArray.this.size) + this.strideSize, b = 0; param1Int < i; param1Int++, b++) {
/* 151 */         this.data[param1Int] = (T)param1VarArgs[b];
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void swap(int param1Int1, int param1Int2) {
/* 158 */       param1Int1 = this.strideSize * param1Int1;
/* 159 */       param1Int2 = this.strideSize * param1Int2;
/* 160 */       for (int i = param1Int1 + this.strideSize; param1Int1 < i; param1Int1++, param1Int2++) {
/* 161 */         T t = this.data[param1Int1];
/* 162 */         this.data[param1Int1] = this.data[param1Int2];
/* 163 */         this.data[param1Int2] = t;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void setCapacity(int param1Int) {
/* 169 */       Object[] arrayOfObject = (Object[])ArrayReflection.newInstance(this.componentType, this.strideSize * param1Int);
/* 170 */       System.arraycopy(this.data, 0, arrayOfObject, 0, Math.min(this.data.length, arrayOfObject.length));
/* 171 */       this.data = (T[])arrayOfObject;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ParallelArray(int paramInt) {
/* 183 */     this.arrays = new Array(false, 2, Channel.class);
/* 184 */     this.capacity = paramInt;
/* 185 */     this.size = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends Channel> T addChannel(ChannelDescriptor paramChannelDescriptor) {
/* 191 */     return addChannel(paramChannelDescriptor, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends Channel> T addChannel(ChannelDescriptor paramChannelDescriptor, ChannelInitializer<T> paramChannelInitializer) {
/*     */     T t;
/* 199 */     if ((t = getChannel(paramChannelDescriptor)) == null) {
/* 200 */       t = allocateChannel(paramChannelDescriptor);
/* 201 */       if (paramChannelInitializer != null) paramChannelInitializer.init(t); 
/* 202 */       this.arrays.add(t);
/*     */     } 
/* 204 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   private <T extends Channel> T allocateChannel(ChannelDescriptor paramChannelDescriptor) {
/* 209 */     if (paramChannelDescriptor.type == float.class)
/* 210 */       return (T)new FloatChannel(paramChannelDescriptor.id, paramChannelDescriptor.count, this.capacity); 
/* 211 */     if (paramChannelDescriptor.type == int.class) {
/* 212 */       return (T)new IntChannel(paramChannelDescriptor.id, paramChannelDescriptor.count, this.capacity);
/*     */     }
/* 214 */     return (T)new ObjectChannel(paramChannelDescriptor.id, paramChannelDescriptor.count, this.capacity, paramChannelDescriptor.type);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> void removeArray(int paramInt) {
/* 220 */     this.arrays.removeIndex(findIndex(paramInt));
/*     */   }
/*     */   
/*     */   private int findIndex(int paramInt) {
/* 224 */     for (byte b = 0; b < this.arrays.size; b++) {
/*     */       Channel channel;
/* 226 */       if ((channel = ((Channel[])this.arrays.items)[b]).id == paramInt) return b; 
/*     */     } 
/* 228 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addElement(Object... paramVarArgs) {
/* 235 */     if (this.size == this.capacity) throw new GdxRuntimeException("Capacity reached, cannot add other elements");
/*     */     
/* 237 */     int i = 0;
/* 238 */     for (Array.ArrayIterator<Channel> arrayIterator = this.arrays.iterator(); arrayIterator.hasNext(); ) {
/* 239 */       Channel channel; (channel = arrayIterator.next()).add(i, paramVarArgs);
/* 240 */       i += channel.strideSize;
/*     */     } 
/* 242 */     this.size++;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeElement(int paramInt) {
/* 247 */     int i = this.size - 1;
/*     */     
/* 249 */     for (Array.ArrayIterator<Channel> arrayIterator = this.arrays.iterator(); arrayIterator.hasNext();) {
/* 250 */       (channel = arrayIterator.next()).swap(paramInt, i);
/*     */     }
/* 252 */     this.size = i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends Channel> T getChannel(ChannelDescriptor paramChannelDescriptor) {
/* 258 */     for (Array.ArrayIterator<Channel> arrayIterator = this.arrays.iterator(); arrayIterator.hasNext();) {
/* 259 */       if ((channel = arrayIterator.next()).id == paramChannelDescriptor.id) return (T)channel; 
/*     */     } 
/* 261 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 266 */     this.arrays.clear();
/* 267 */     this.size = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCapacity(int paramInt) {
/* 273 */     if (this.capacity != paramInt) {
/* 274 */       for (Array.ArrayIterator<Channel> arrayIterator = this.arrays.iterator(); arrayIterator.hasNext();) {
/* 275 */         (channel = arrayIterator.next()).setCapacity(paramInt);
/*     */       }
/* 277 */       this.capacity = paramInt;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static interface ChannelInitializer<T extends Channel> {
/*     */     void init(T param1T);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\ParallelArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */