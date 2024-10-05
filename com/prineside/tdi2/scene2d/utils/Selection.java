/*     */ package com.prineside.tdi2.scene2d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.OrderedSet;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Selection<T>
/*     */   implements Disableable, Iterable<T>
/*     */ {
/*     */   @Null
/*     */   private Actor e;
/*  18 */   final OrderedSet<T> a = new OrderedSet();
/*  19 */   private final OrderedSet<T> f = new OrderedSet();
/*     */   boolean b;
/*     */   private boolean g;
/*     */   boolean c;
/*     */   boolean d;
/*     */   private boolean h = true;
/*     */   @Null
/*     */   private T i;
/*     */   
/*     */   public void setActor(@Null Actor paramActor) {
/*  29 */     this.e = paramActor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void choose(T paramT) {
/*  35 */     if (paramT == null) throw new IllegalArgumentException("item cannot be null."); 
/*  36 */     if (this.b)
/*  37 */       return;  b();
/*     */     
/*  39 */     try { if ((this.g || UIUtils.ctrl()) && this.a.contains(paramT)) {
/*  40 */         if (this.d && this.a.size == 1)
/*  41 */           return;  this.a.remove(paramT);
/*  42 */         this.i = null;
/*     */       } else {
/*  44 */         boolean bool = false;
/*  45 */         if (!this.c || (!this.g && !UIUtils.ctrl())) {
/*  46 */           if (this.a.size == 1 && this.a.contains(paramT))
/*  47 */             return;  bool = (this.a.size > 0) ? true : false;
/*  48 */           this.a.clear(8);
/*     */         } 
/*  50 */         if (!this.a.add(paramT) && !bool)
/*  51 */           return;  this.i = paramT;
/*     */       } 
/*  53 */       if (fireChangeEvent()) {
/*  54 */         c();
/*     */       } else {
/*  56 */         a();
/*     */       }  return; }
/*  58 */     finally { d(); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public boolean hasItems() {
/*  65 */     return (this.a.size > 0);
/*     */   }
/*     */   
/*     */   public boolean notEmpty() {
/*  69 */     return (this.a.size > 0);
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  73 */     return (this.a.size == 0);
/*     */   }
/*     */   
/*     */   public int size() {
/*  77 */     return this.a.size;
/*     */   }
/*     */   
/*     */   public OrderedSet<T> items() {
/*  81 */     return this.a;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public T first() {
/*  86 */     return (T)((this.a.size == 0) ? null : this.a.first());
/*     */   }
/*     */   
/*     */   final void b() {
/*  90 */     this.f.clear(this.a.size);
/*  91 */     this.f.addAll(this.a);
/*     */   }
/*     */   
/*     */   final void c() {
/*  95 */     this.a.clear(this.f.size);
/*  96 */     this.a.addAll(this.f);
/*     */   }
/*     */   
/*     */   final void d() {
/* 100 */     this.f.clear(32);
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(T paramT) {
/* 105 */     if (paramT == null) throw new IllegalArgumentException("item cannot be null."); 
/* 106 */     if (this.a.size == 1 && this.a.first() == paramT)
/* 107 */       return;  b();
/* 108 */     this.a.clear(8);
/* 109 */     this.a.add(paramT);
/* 110 */     if (this.h && fireChangeEvent()) {
/* 111 */       c();
/*     */     } else {
/* 113 */       this.i = paramT;
/* 114 */       a();
/*     */     } 
/* 116 */     d();
/*     */   }
/*     */   
/*     */   public void setAll(Array<T> paramArray) {
/* 120 */     boolean bool = false;
/* 121 */     b();
/* 122 */     this.i = null;
/* 123 */     this.a.clear(paramArray.size); byte b; int i;
/* 124 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       Object object;
/* 126 */       if ((object = paramArray.get(b)) == null) throw new IllegalArgumentException("item cannot be null."); 
/* 127 */       if (this.a.add(object)) bool = true; 
/*     */     } 
/* 129 */     if (bool) {
/* 130 */       if (this.h && fireChangeEvent()) {
/* 131 */         c();
/* 132 */       } else if (paramArray.size > 0) {
/* 133 */         this.i = (T)paramArray.peek();
/* 134 */         a();
/*     */       } 
/*     */     }
/* 137 */     d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(T paramT) {
/* 142 */     if (paramT == null) throw new IllegalArgumentException("item cannot be null."); 
/* 143 */     if (!this.a.add(paramT))
/* 144 */       return;  if (this.h && fireChangeEvent()) {
/* 145 */       this.a.remove(paramT); return;
/*     */     } 
/* 147 */     this.i = paramT;
/* 148 */     a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addAll(Array<T> paramArray) {
/* 153 */     boolean bool = false;
/* 154 */     b(); byte b; int i;
/* 155 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       Object object;
/* 157 */       if ((object = paramArray.get(b)) == null) throw new IllegalArgumentException("item cannot be null."); 
/* 158 */       if (this.a.add(object)) bool = true; 
/*     */     } 
/* 160 */     if (bool) {
/* 161 */       if (this.h && fireChangeEvent()) {
/* 162 */         c();
/*     */       } else {
/* 164 */         this.i = (T)paramArray.peek();
/* 165 */         a();
/*     */       } 
/*     */     }
/* 168 */     d();
/*     */   }
/*     */   
/*     */   public void remove(T paramT) {
/* 172 */     if (paramT == null) throw new IllegalArgumentException("item cannot be null."); 
/* 173 */     if (!this.a.remove(paramT))
/* 174 */       return;  if (this.h && fireChangeEvent()) {
/* 175 */       this.a.add(paramT); return;
/*     */     } 
/* 177 */     this.i = null;
/* 178 */     a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeAll(Array<T> paramArray) {
/* 183 */     boolean bool = false;
/* 184 */     b(); byte b; int i;
/* 185 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       Object object;
/* 187 */       if ((object = paramArray.get(b)) == null) throw new IllegalArgumentException("item cannot be null."); 
/* 188 */       if (this.a.remove(object)) bool = true; 
/*     */     } 
/* 190 */     if (bool) {
/* 191 */       if (this.h && fireChangeEvent()) {
/* 192 */         c();
/*     */       } else {
/* 194 */         this.i = null;
/* 195 */         a();
/*     */       } 
/*     */     }
/* 198 */     d();
/*     */   }
/*     */   
/*     */   public void clear() {
/* 202 */     if (this.a.size == 0) {
/* 203 */       this.i = null;
/*     */       return;
/*     */     } 
/* 206 */     b();
/* 207 */     this.a.clear(8);
/* 208 */     if (this.h && fireChangeEvent()) {
/* 209 */       c();
/*     */     } else {
/* 211 */       this.i = null;
/* 212 */       a();
/*     */     } 
/* 214 */     d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fireChangeEvent() {
/* 225 */     if (this.e == null) return false; 
/* 226 */     ChangeListener.ChangeEvent changeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
/*     */     try {
/* 228 */       return this.e.fire(changeEvent);
/*     */     } finally {
/* 230 */       Pools.free(changeEvent);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(@Null T paramT) {
/* 236 */     if (paramT == null) return false; 
/* 237 */     return this.a.contains(paramT);
/*     */   }
/*     */   
/*     */   @Null
/*     */   public T getLastSelected() {
/* 242 */     if (this.i != null)
/* 243 */       return this.i; 
/* 244 */     if (this.a.size > 0) {
/* 245 */       return (T)this.a.first();
/*     */     }
/* 247 */     return null;
/*     */   }
/*     */   
/*     */   public Iterator<T> iterator() {
/* 251 */     return (Iterator<T>)this.a.iterator();
/*     */   }
/*     */   
/*     */   public Array<T> toArray() {
/* 255 */     return this.a.iterator().toArray();
/*     */   }
/*     */   
/*     */   public Array<T> toArray(Array<T> paramArray) {
/* 259 */     return this.a.iterator().toArray(paramArray);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDisabled(boolean paramBoolean) {
/* 264 */     this.b = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isDisabled() {
/* 268 */     return this.b;
/*     */   }
/*     */   
/*     */   public boolean getToggle() {
/* 272 */     return this.g;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setToggle(boolean paramBoolean) {
/* 277 */     this.g = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean getMultiple() {
/* 281 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMultiple(boolean paramBoolean) {
/* 286 */     this.c = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean getRequired() {
/* 290 */     return this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRequired(boolean paramBoolean) {
/* 295 */     this.d = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setProgrammaticChangeEvents(boolean paramBoolean) {
/* 300 */     this.h = paramBoolean;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 304 */     return this.a.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\utils\Selection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */