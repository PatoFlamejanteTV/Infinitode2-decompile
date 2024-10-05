/*     */ package com.badlogic.gdx.scenes.scene2d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.OrderedSet;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Selection<T>
/*     */   implements Disableable, Iterable<T>
/*     */ {
/*     */   @Null
/*     */   private Actor actor;
/*  18 */   final OrderedSet<T> selected = new OrderedSet();
/*  19 */   private final OrderedSet<T> old = new OrderedSet();
/*     */   boolean isDisabled;
/*     */   private boolean toggle;
/*     */   boolean multiple;
/*     */   boolean required;
/*     */   private boolean programmaticChangeEvents = true;
/*     */   @Null
/*     */   T lastSelected;
/*     */   
/*     */   public void setActor(@Null Actor paramActor) {
/*  29 */     this.actor = paramActor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void choose(T paramT) {
/*  35 */     if (paramT == null) throw new IllegalArgumentException("item cannot be null."); 
/*  36 */     if (this.isDisabled)
/*  37 */       return;  snapshot();
/*     */     
/*  39 */     try { if ((this.toggle || UIUtils.ctrl()) && this.selected.contains(paramT)) {
/*  40 */         if (this.required && this.selected.size == 1)
/*  41 */           return;  this.selected.remove(paramT);
/*  42 */         this.lastSelected = null;
/*     */       } else {
/*  44 */         boolean bool = false;
/*  45 */         if (!this.multiple || (!this.toggle && !UIUtils.ctrl())) {
/*  46 */           if (this.selected.size == 1 && this.selected.contains(paramT))
/*  47 */             return;  bool = (this.selected.size > 0) ? true : false;
/*  48 */           this.selected.clear(8);
/*     */         } 
/*  50 */         if (!this.selected.add(paramT) && !bool)
/*  51 */           return;  this.lastSelected = paramT;
/*     */       } 
/*  53 */       if (fireChangeEvent()) {
/*  54 */         revert();
/*     */       } else {
/*  56 */         changed();
/*     */       }  return; }
/*  58 */     finally { cleanup(); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public boolean hasItems() {
/*  65 */     return (this.selected.size > 0);
/*     */   }
/*     */   
/*     */   public boolean notEmpty() {
/*  69 */     return (this.selected.size > 0);
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  73 */     return (this.selected.size == 0);
/*     */   }
/*     */   
/*     */   public int size() {
/*  77 */     return this.selected.size;
/*     */   }
/*     */   
/*     */   public OrderedSet<T> items() {
/*  81 */     return this.selected;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public T first() {
/*  86 */     return (T)((this.selected.size == 0) ? null : this.selected.first());
/*     */   }
/*     */   
/*     */   void snapshot() {
/*  90 */     this.old.clear(this.selected.size);
/*  91 */     this.old.addAll(this.selected);
/*     */   }
/*     */   
/*     */   void revert() {
/*  95 */     this.selected.clear(this.old.size);
/*  96 */     this.selected.addAll(this.old);
/*     */   }
/*     */   
/*     */   void cleanup() {
/* 100 */     this.old.clear(32);
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(T paramT) {
/* 105 */     if (paramT == null) throw new IllegalArgumentException("item cannot be null."); 
/* 106 */     if (this.selected.size == 1 && this.selected.first() == paramT)
/* 107 */       return;  snapshot();
/* 108 */     this.selected.clear(8);
/* 109 */     this.selected.add(paramT);
/* 110 */     if (this.programmaticChangeEvents && fireChangeEvent()) {
/* 111 */       revert();
/*     */     } else {
/* 113 */       this.lastSelected = paramT;
/* 114 */       changed();
/*     */     } 
/* 116 */     cleanup();
/*     */   }
/*     */   
/*     */   public void setAll(Array<T> paramArray) {
/* 120 */     boolean bool = false;
/* 121 */     snapshot();
/* 122 */     this.lastSelected = null;
/* 123 */     this.selected.clear(paramArray.size); byte b; int i;
/* 124 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       Object object;
/* 126 */       if ((object = paramArray.get(b)) == null) throw new IllegalArgumentException("item cannot be null."); 
/* 127 */       if (this.selected.add(object)) bool = true; 
/*     */     } 
/* 129 */     if (bool) {
/* 130 */       if (this.programmaticChangeEvents && fireChangeEvent()) {
/* 131 */         revert();
/* 132 */       } else if (paramArray.size > 0) {
/* 133 */         this.lastSelected = (T)paramArray.peek();
/* 134 */         changed();
/*     */       } 
/*     */     }
/* 137 */     cleanup();
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(T paramT) {
/* 142 */     if (paramT == null) throw new IllegalArgumentException("item cannot be null."); 
/* 143 */     if (!this.selected.add(paramT))
/* 144 */       return;  if (this.programmaticChangeEvents && fireChangeEvent()) {
/* 145 */       this.selected.remove(paramT); return;
/*     */     } 
/* 147 */     this.lastSelected = paramT;
/* 148 */     changed();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addAll(Array<T> paramArray) {
/* 153 */     boolean bool = false;
/* 154 */     snapshot(); byte b; int i;
/* 155 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       Object object;
/* 157 */       if ((object = paramArray.get(b)) == null) throw new IllegalArgumentException("item cannot be null."); 
/* 158 */       if (this.selected.add(object)) bool = true; 
/*     */     } 
/* 160 */     if (bool) {
/* 161 */       if (this.programmaticChangeEvents && fireChangeEvent()) {
/* 162 */         revert();
/*     */       } else {
/* 164 */         this.lastSelected = (T)paramArray.peek();
/* 165 */         changed();
/*     */       } 
/*     */     }
/* 168 */     cleanup();
/*     */   }
/*     */   
/*     */   public void remove(T paramT) {
/* 172 */     if (paramT == null) throw new IllegalArgumentException("item cannot be null."); 
/* 173 */     if (!this.selected.remove(paramT))
/* 174 */       return;  if (this.programmaticChangeEvents && fireChangeEvent()) {
/* 175 */       this.selected.add(paramT); return;
/*     */     } 
/* 177 */     this.lastSelected = null;
/* 178 */     changed();
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeAll(Array<T> paramArray) {
/* 183 */     boolean bool = false;
/* 184 */     snapshot(); byte b; int i;
/* 185 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       Object object;
/* 187 */       if ((object = paramArray.get(b)) == null) throw new IllegalArgumentException("item cannot be null."); 
/* 188 */       if (this.selected.remove(object)) bool = true; 
/*     */     } 
/* 190 */     if (bool) {
/* 191 */       if (this.programmaticChangeEvents && fireChangeEvent()) {
/* 192 */         revert();
/*     */       } else {
/* 194 */         this.lastSelected = null;
/* 195 */         changed();
/*     */       } 
/*     */     }
/* 198 */     cleanup();
/*     */   }
/*     */   
/*     */   public void clear() {
/* 202 */     if (this.selected.size == 0) {
/* 203 */       this.lastSelected = null;
/*     */       return;
/*     */     } 
/* 206 */     snapshot();
/* 207 */     this.selected.clear(8);
/* 208 */     if (this.programmaticChangeEvents && fireChangeEvent()) {
/* 209 */       revert();
/*     */     } else {
/* 211 */       this.lastSelected = null;
/* 212 */       changed();
/*     */     } 
/* 214 */     cleanup();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void changed() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fireChangeEvent() {
/* 225 */     if (this.actor == null) return false; 
/* 226 */     ChangeListener.ChangeEvent changeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
/*     */     try {
/* 228 */       return this.actor.fire(changeEvent);
/*     */     } finally {
/* 230 */       Pools.free(changeEvent);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(@Null T paramT) {
/* 236 */     if (paramT == null) return false; 
/* 237 */     return this.selected.contains(paramT);
/*     */   }
/*     */   
/*     */   @Null
/*     */   public T getLastSelected() {
/* 242 */     if (this.lastSelected != null)
/* 243 */       return this.lastSelected; 
/* 244 */     if (this.selected.size > 0) {
/* 245 */       return (T)this.selected.first();
/*     */     }
/* 247 */     return null;
/*     */   }
/*     */   
/*     */   public Iterator<T> iterator() {
/* 251 */     return (Iterator<T>)this.selected.iterator();
/*     */   }
/*     */   
/*     */   public Array<T> toArray() {
/* 255 */     return this.selected.iterator().toArray();
/*     */   }
/*     */   
/*     */   public Array<T> toArray(Array<T> paramArray) {
/* 259 */     return this.selected.iterator().toArray(paramArray);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDisabled(boolean paramBoolean) {
/* 264 */     this.isDisabled = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isDisabled() {
/* 268 */     return this.isDisabled;
/*     */   }
/*     */   
/*     */   public boolean getToggle() {
/* 272 */     return this.toggle;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setToggle(boolean paramBoolean) {
/* 277 */     this.toggle = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean getMultiple() {
/* 281 */     return this.multiple;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMultiple(boolean paramBoolean) {
/* 286 */     this.multiple = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean getRequired() {
/* 290 */     return this.required;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRequired(boolean paramBoolean) {
/* 295 */     this.required = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setProgrammaticChangeEvents(boolean paramBoolean) {
/* 300 */     this.programmaticChangeEvents = paramBoolean;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 304 */     return this.selected.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\utils\Selection.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */