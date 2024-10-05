/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.util.Arrays;
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
/*     */ public class BinaryHeap<T extends BinaryHeap.Node>
/*     */ {
/*     */   public int size;
/*     */   private Node[] nodes;
/*     */   private final boolean isMaxHeap;
/*     */   
/*     */   public BinaryHeap() {
/*  31 */     this(16, false);
/*     */   }
/*     */   
/*     */   public BinaryHeap(int paramInt, boolean paramBoolean) {
/*  35 */     this.isMaxHeap = paramBoolean;
/*  36 */     this.nodes = new Node[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T add(T paramT) {
/*  43 */     if (this.size == this.nodes.length) {
/*  44 */       Node[] arrayOfNode = new Node[this.size << 1];
/*  45 */       System.arraycopy(this.nodes, 0, arrayOfNode, 0, this.size);
/*  46 */       this.nodes = arrayOfNode;
/*     */     } 
/*     */     
/*  49 */     ((Node)paramT).index = this.size;
/*  50 */     this.nodes[this.size] = (Node)paramT;
/*  51 */     up(this.size++);
/*  52 */     return paramT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T add(T paramT, float paramFloat) {
/*  58 */     ((Node)paramT).value = paramFloat;
/*  59 */     return add(paramT);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(T paramT, boolean paramBoolean) {
/*  65 */     if (paramT == null) throw new IllegalArgumentException("node cannot be null."); 
/*  66 */     if (paramBoolean)
/*  67 */     { Node[] arrayOfNode; int i; byte b; for (i = (arrayOfNode = this.nodes).length, b = 0; b < i; b++) {
/*  68 */         Node node; if ((node = arrayOfNode[b]) == paramT) return true; 
/*     */       }  }
/*  70 */     else { Node[] arrayOfNode; int i; byte b; for (i = (arrayOfNode = this.nodes).length, b = 0; b < i; b++) {
/*  71 */         Node node; if ((node = arrayOfNode[b]).equals(paramT)) return true; 
/*     */       }  }
/*  73 */      return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T peek() {
/*  79 */     if (this.size == 0) throw new IllegalStateException("The heap is empty."); 
/*  80 */     return (T)this.nodes[0];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T pop() {
/*  86 */     Node node = this.nodes[0];
/*  87 */     if (--this.size > 0) {
/*  88 */       this.nodes[0] = this.nodes[this.size];
/*  89 */       this.nodes[this.size] = null;
/*  90 */       down(0);
/*     */     } else {
/*  92 */       this.nodes[0] = null;
/*  93 */     }  return (T)node;
/*     */   }
/*     */ 
/*     */   
/*     */   public T remove(T paramT) {
/*  98 */     if (--this.size > 0)
/*  99 */     { Node node = this.nodes[this.size];
/* 100 */       this.nodes[this.size] = null;
/* 101 */       this.nodes[((Node)paramT).index] = node;
/* 102 */       if ((((node.value < ((Node)paramT).value) ? 1 : 0) ^ this.isMaxHeap) != 0) {
/* 103 */         up(((Node)paramT).index);
/*     */       } else {
/* 105 */         down(((Node)paramT).index);
/*     */       }  }
/* 107 */     else { this.nodes[0] = null; }
/* 108 */      return paramT;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 113 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 118 */     return (this.size == 0);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 122 */     Arrays.fill((Object[])this.nodes, 0, this.size, (Object)null);
/* 123 */     this.size = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValue(T paramT, float paramFloat) {
/* 128 */     float f = ((Node)paramT).value;
/* 129 */     ((Node)paramT).value = paramFloat;
/* 130 */     if ((((paramFloat < f) ? 1 : 0) ^ this.isMaxHeap) != 0) {
/* 131 */       up(((Node)paramT).index); return;
/*     */     } 
/* 133 */     down(((Node)paramT).index);
/*     */   }
/*     */ 
/*     */   
/*     */   private void up(int paramInt) {
/*     */     Node arrayOfNode[], node;
/* 139 */     float f = (node = (arrayOfNode = this.nodes)[paramInt]).value;
/* 140 */     while (paramInt > 0) {
/* 141 */       int i = paramInt - 1 >> 1;
/* 142 */       Node node1 = arrayOfNode[i];
/* 143 */       if ((((f < node1.value) ? 1 : 0) ^ this.isMaxHeap) != 0) {
/* 144 */         arrayOfNode[paramInt] = node1;
/* 145 */         node1.index = paramInt;
/* 146 */         paramInt = i;
/*     */       } 
/*     */     } 
/*     */     
/* 150 */     arrayOfNode[paramInt] = node;
/* 151 */     node.index = paramInt;
/*     */   }
/*     */   
/*     */   private void down(int paramInt) {
/* 155 */     Node[] arrayOfNode = this.nodes;
/* 156 */     int i = this.size;
/*     */     
/*     */     Node node;
/* 159 */     float f = (node = arrayOfNode[paramInt]).value;
/*     */     
/*     */     int j;
/*     */     
/* 163 */     while ((j = 1 + (paramInt << 1)) < i) {
/* 164 */       Node node2; float f2; int k = j + 1;
/*     */       
/*     */       Node node1;
/*     */       
/* 168 */       float f1 = (node1 = arrayOfNode[j]).value;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 173 */       if (k >= i) {
/* 174 */         node2 = null;
/* 175 */         f2 = this.isMaxHeap ? -3.4028235E38F : Float.MAX_VALUE;
/*     */       } else {
/*     */         
/* 178 */         f2 = (node2 = arrayOfNode[k]).value;
/*     */       } 
/*     */ 
/*     */       
/* 182 */       if ((((f1 < f2) ? 1 : 0) ^ this.isMaxHeap) != 0) {
/* 183 */         if (f1 != f && (((f1 > f) ? 1 : 0) ^ this.isMaxHeap) == 0) {
/* 184 */           arrayOfNode[paramInt] = node1;
/* 185 */           node1.index = paramInt;
/* 186 */           paramInt = j; continue;
/*     */         }  break;
/* 188 */       }  if (f2 != f && (((f2 > f) ? 1 : 0) ^ this.isMaxHeap) == 0) {
/* 189 */         arrayOfNode[paramInt] = node2;
/* 190 */         if (node2 != null) node2.index = paramInt; 
/* 191 */         paramInt = k;
/*     */       } 
/*     */     } 
/*     */     
/* 195 */     arrayOfNode[paramInt] = node;
/* 196 */     node.index = paramInt;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 200 */     if (!(paramObject instanceof BinaryHeap)) return false;
/*     */     
/* 202 */     if (((BinaryHeap)(paramObject = paramObject)).size != this.size) return false; 
/* 203 */     Node[] arrayOfNode = this.nodes; paramObject = ((BinaryHeap)paramObject).nodes; byte b; int i;
/* 204 */     for (b = 0, i = this.size; b < i; b++) {
/* 205 */       if ((arrayOfNode[b]).value != ((Node)paramObject[b]).value) return false; 
/* 206 */     }  return true;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 210 */     int i = 1;
/* 211 */     Node[] arrayOfNode = this.nodes; byte b; int j;
/* 212 */     for (b = 0, j = this.size; b < j; b++)
/* 213 */       i = i * 31 + Float.floatToIntBits((arrayOfNode[b]).value); 
/* 214 */     return i;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 218 */     if (this.size == 0) return "[]"; 
/* 219 */     Node[] arrayOfNode = this.nodes;
/*     */     StringBuilder stringBuilder;
/* 221 */     (stringBuilder = new StringBuilder(32)).append('[');
/* 222 */     stringBuilder.append((arrayOfNode[0]).value);
/* 223 */     for (byte b = 1; b < this.size; b++) {
/* 224 */       stringBuilder.append(", ");
/* 225 */       stringBuilder.append((arrayOfNode[b]).value);
/*     */     } 
/* 227 */     stringBuilder.append(']');
/* 228 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Node
/*     */   {
/*     */     float value;
/*     */     
/*     */     int index;
/*     */ 
/*     */     
/*     */     public Node(float param1Float) {
/* 240 */       this.value = param1Float;
/*     */     }
/*     */     
/*     */     public float getValue() {
/* 244 */       return this.value;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 248 */       return Float.toString(this.value);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\BinaryHeap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */