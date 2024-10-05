/*     */ package com.prineside.tdi2.events;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ObjectIntMap;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class EventDispatcher
/*     */   implements KryoSerializable
/*     */ {
/*  25 */   private static final TLog b = TLog.forClass(EventDispatcher.class);
/*     */   
/*  27 */   public static DeepClassComparator<EventDispatcher> CLASS_COMPARATOR = new DeepClassComparator<EventDispatcher>() {
/*     */       public Class<EventDispatcher> forClass() {
/*  29 */         return EventDispatcher.class;
/*     */       }
/*     */       
/*     */       public void compare(EventDispatcher param1EventDispatcher1, EventDispatcher param1EventDispatcher2, DeepClassComparisonConfig param1DeepClassComparisonConfig) {
/*  33 */         param1DeepClassComparisonConfig.addPrefix(new String[] { ".listenerGroups" });
/*  34 */         for (byte b = 0; b < param1EventDispatcher1.a.size; b++) {
/*  35 */           param1DeepClassComparisonConfig.addPrefix(new String[] { "[" + b + "]" });
/*  36 */           for (byte b1 = 0; b1 < param1EventDispatcher1.a.size; b1++) {
/*  37 */             EventListeners eventListeners = (EventListeners)param1EventDispatcher1.a.get(b1);
/*  38 */             for (byte b2 = 0; b2 < param1EventDispatcher2.a.size; b2++) {
/*     */               EventListeners<Event> eventListeners1;
/*  40 */               if ((eventListeners1 = (EventListeners<Event>)param1EventDispatcher2.a.get(b2)).getEventClass() == eventListeners.getEventClass()) {
/*  41 */                 SyncChecker.compareObjects(eventListeners, eventListeners1, param1DeepClassComparisonConfig);
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/*  46 */           param1DeepClassComparisonConfig.popPrefix(1);
/*     */         } 
/*  48 */         param1DeepClassComparisonConfig.popPrefix(1);
/*     */       }
/*     */     };
/*     */   static {
/*  52 */     SyncChecker.CLASS_COMPARATORS.add(CLASS_COMPARATOR);
/*     */   }
/*     */   @NAGS
/*  55 */   private ObjectIntMap<Class<? extends Event>> c = new ObjectIntMap();
/*  56 */   protected Array<EventListeners<?>> a = new Array(true, 1, EventListeners.class);
/*  57 */   private Array<Event> d = new Array();
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  61 */     paramKryo.writeObject(paramOutput, this.c);
/*  62 */     paramKryo.writeObject(paramOutput, this.a);
/*  63 */     paramKryo.writeObject(paramOutput, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  69 */     this.c = (ObjectIntMap<Class<? extends Event>>)paramKryo.readObject(paramInput, ObjectIntMap.class);
/*  70 */     this.a = (Array<EventListeners<?>>)paramKryo.readObject(paramInput, Array.class);
/*  71 */     this.d = (Array<Event>)paramKryo.readObject(paramInput, Array.class);
/*     */   }
/*     */   
/*     */   private int a(Class<? extends Event> paramClass) {
/*  75 */     Preconditions.checkNotNull(paramClass, "Event class can not be null");
/*     */     
/*     */     int i;
/*  78 */     if ((i = this.c.get(paramClass, -1)) != -1) {
/*  79 */       throw new IllegalArgumentException("Event class " + paramClass + " is already registered");
/*     */     }
/*     */     
/*  82 */     i = this.a.size;
/*  83 */     this.a.add(new EventListeners<>(paramClass));
/*  84 */     this.c.put(paramClass, i);
/*     */ 
/*     */ 
/*     */     
/*  88 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends Event> EventListeners<T> getListeners(Class<T> paramClass) {
/*     */     int i;
/*  99 */     if ((i = this.c.get(paramClass, -1)) == -1) {
/* 100 */       i = a(paramClass);
/*     */     }
/*     */     
/* 103 */     return ((EventListeners[])this.a.items)[i];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends Event> void queue(T paramT) {
/* 112 */     this.d.add(paramT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasQueuedEvents() {
/* 119 */     return (this.d.size != 0);
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
/*     */   public <T extends Event> T trigger(T paramT) {
/* 138 */     getListeners((Class)paramT.getClass()).trigger(paramT);
/* 139 */     return paramT;
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
/*     */   public ObjectIntMap<Class<? extends Event>> getClassToId() {
/* 157 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<EventListeners<?>> getListenerGroups() {
/* 165 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<Event> getQueuedEvents() {
/* 173 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset(boolean paramBoolean) {
/* 183 */     if (paramBoolean) {
/* 184 */       this.c.clear();
/* 185 */       this.a.clear();
/*     */       return;
/*     */     } 
/* 188 */     for (paramBoolean = false; paramBoolean < this.a.size; paramBoolean++) {
/*     */       EventListeners<Event> eventListeners;
/* 190 */       EventListeners.Entry[] arrayOfEntry = (EventListeners.Entry[])(eventListeners = ((EventListeners[])this.a.items)[paramBoolean]).getEntriesBackingArray();
/* 191 */       for (byte b = 0; b < eventListeners.size(); b++) {
/*     */         EventListeners.Entry entry;
/* 193 */         if ((entry = arrayOfEntry[b]) != null && !entry.isPersistent()) {
/* 194 */           b.i("Removing non-persistent listener " + entry, new Object[0]);
/* 195 */           entry.remove();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringBuilder describe() {
/*     */     StringBuilder stringBuilder;
/* 208 */     (stringBuilder = new StringBuilder()).append("event types: ").append(String.valueOf(this.a.size));
/* 209 */     for (byte b = 0; b < this.a.size; b++) {
/* 210 */       EventListeners eventListeners = ((EventListeners[])this.a.items)[b];
/* 211 */       stringBuilder.append(eventListeners.describe());
/*     */     } 
/* 213 */     return stringBuilder;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\EventDispatcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */