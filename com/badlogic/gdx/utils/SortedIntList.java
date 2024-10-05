/*     */ package com.badlogic.gdx.utils;
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
/*     */ public class SortedIntList<E>
/*     */   implements Iterable<SortedIntList.Node<E>>
/*     */ {
/*  23 */   private NodePool<E> nodePool = new NodePool<>();
/*     */   private transient Iterator iterator;
/*  25 */   int size = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Node<E> first;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public E insert(int paramInt, E paramE) {
/*     */     Node<E> node;
/*  39 */     if (this.first != null) {
/*  40 */       Node<E> node1 = this.first;
/*     */       
/*  42 */       while (node1.n != null && node1.n.index <= paramInt) {
/*  43 */         node1 = node1.n;
/*     */       }
/*     */       
/*  46 */       if (paramInt > node1.index) {
/*  47 */         node1.n = this.nodePool.obtain(node1, node1.n, paramE, paramInt);
/*  48 */         if (node1.n.n != null) {
/*  49 */           node1.n.n.p = node1.n;
/*     */         }
/*  51 */         this.size++;
/*     */       
/*     */       }
/*  54 */       else if (paramInt < node1.index) {
/*  55 */         node = this.nodePool.obtain(null, this.first, paramE, paramInt);
/*  56 */         this.first.p = node;
/*  57 */         this.first = node;
/*  58 */         this.size++;
/*     */       }
/*     */       else {
/*     */         
/*  62 */         node1.value = paramE;
/*     */       } 
/*     */     } else {
/*  65 */       this.first = this.nodePool.obtain(null, null, paramE, node);
/*  66 */       this.size++;
/*     */     } 
/*  68 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E get(int paramInt) {
/*     */     E e;
/*  76 */     Object object = null;
/*  77 */     if (this.first != null) {
/*  78 */       Node<E> node = this.first;
/*  79 */       while (node.n != null && node.index < paramInt) {
/*  80 */         node = node.n;
/*     */       }
/*  82 */       if (node.index == paramInt) {
/*  83 */         e = node.value;
/*     */       }
/*     */     } 
/*  86 */     return e;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  91 */     for (; this.first != null; this.first = this.first.n) {
/*  92 */       this.nodePool.free(this.first);
/*     */     }
/*  94 */     this.size = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  99 */     return this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean notEmpty() {
/* 104 */     return (this.size > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 109 */     return (this.size == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public java.util.Iterator<Node<E>> iterator() {
/* 117 */     if (Collections.allocateIterators) return new Iterator(); 
/* 118 */     if (this.iterator == null) return this.iterator = new Iterator(); 
/* 119 */     return this.iterator.reset();
/*     */   }
/*     */   
/*     */   public class Iterator implements java.util.Iterator<Node<E>> {
/*     */     private SortedIntList.Node<E> position;
/*     */     private SortedIntList.Node<E> previousPosition;
/*     */     
/*     */     public Iterator() {
/* 127 */       reset();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 132 */       return (this.position != null);
/*     */     }
/*     */ 
/*     */     
/*     */     public SortedIntList.Node<E> next() {
/* 137 */       this.previousPosition = this.position;
/* 138 */       this.position = this.position.n;
/* 139 */       return this.previousPosition;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void remove() {
/* 145 */       if (this.previousPosition != null) {
/*     */         
/* 147 */         if (this.previousPosition == SortedIntList.this.first) {
/* 148 */           SortedIntList.this.first = this.position;
/*     */         }
/*     */         else {
/*     */           
/* 152 */           this.previousPosition.p.n = this.position;
/* 153 */           if (this.position != null) {
/* 154 */             this.position.p = this.previousPosition.p;
/*     */           }
/*     */         } 
/* 157 */         SortedIntList.this.size--;
/*     */       } 
/*     */     }
/*     */     
/*     */     public Iterator reset() {
/* 162 */       this.position = SortedIntList.this.first;
/* 163 */       this.previousPosition = null;
/* 164 */       return this;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Node<E>
/*     */   {
/*     */     protected Node<E> p;
/*     */     
/*     */     protected Node<E> n;
/*     */     public E value;
/*     */     public int index;
/*     */   }
/*     */   
/*     */   static class NodePool<E>
/*     */     extends Pool<Node<E>>
/*     */   {
/*     */     protected SortedIntList.Node<E> newObject() {
/* 182 */       return new SortedIntList.Node<>();
/*     */     }
/*     */     
/*     */     public SortedIntList.Node<E> obtain(SortedIntList.Node<E> param1Node1, SortedIntList.Node<E> param1Node2, E param1E, int param1Int) {
/*     */       SortedIntList.Node<E> node;
/* 187 */       (node = (SortedIntList.Node)obtain()).p = param1Node1;
/* 188 */       node.n = param1Node2;
/* 189 */       node.value = param1E;
/* 190 */       node.index = param1Int;
/* 191 */       return node;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\SortedIntList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */