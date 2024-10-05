/*     */ package com.prineside.tdi2.events;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.ReflectionUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ import java.util.Comparator;
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
/*     */ @REGS(serializer = EventListeners.Serializer.class, arrayLevels = 1)
/*     */ public final class EventListeners<T extends Event>
/*     */ {
/*     */   public static final byte FLAG_AUTO_PRIORITY = 1;
/*     */   public static final byte FLAG_AFFECTS_STATE = 2;
/*     */   public static final byte FLAG_PERSISTENT = 4;
/*     */   public static final int PRIORITY_STEP = 10;
/*     */   public static final int PRIORITY_HIGHEST = 3000;
/*     */   public static final int PRIORITY_VERY_HIGH = 2000;
/*     */   public static final int PRIORITY_HIGH = 1000;
/*     */   public static final int PRIORITY_DEFAULT = 0;
/*     */   public static final int PRIORITY_LOW = -1000;
/*     */   public static final int PRIORITY_VERY_LOW = -2000;
/*     */   public static final int PRIORITY_LOWEST = -3000;
/*     */   
/*     */   static {
/*  59 */     TLog.forClass(EventListeners.class);
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
/*  80 */   public static final DeepClassComparator<EventListeners> CLASS_COMPARATOR = new EventListenersDeepClassComparator();
/*     */   static {
/*  82 */     SyncChecker.CLASS_COMPARATORS.add(CLASS_COMPARATOR);
/*     */   }
/*     */   
/*  85 */   private Entry<T>[] a = (Entry<T>[])new Entry[2];
/*     */   
/*     */   private int b;
/*     */   @Null
/*     */   private Class<?> c;
/*     */   @NAGS
/*  91 */   private short d = 0;
/*     */   @NAGS
/*     */   private int e;
/*     */   @NAGS
/*     */   private int f;
/*     */   private boolean g;
/*     */   
/*     */   public static class Serializer
/*     */     extends com.esotericsoftware.kryo.Serializer<EventListeners> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, EventListeners param1EventListeners) {
/* 101 */       param1Output.writeString((EventListeners.a(param1EventListeners) == null) ? null : EventListeners.a(param1EventListeners).getName());
/*     */       
/* 103 */       byte b1 = 0; byte b2;
/* 104 */       for (b2 = 0; b2 < param1EventListeners.size(); b2++) {
/* 105 */         if (EventListeners.b(param1EventListeners)[b2] != null && EventListeners.b(param1EventListeners)[b2].isStateAffecting()) b1++; 
/*     */       } 
/* 107 */       param1Output.writeVarInt(b1, true);
/* 108 */       for (b2 = 0; b2 < param1EventListeners.size(); b2++) {
/*     */         EventListeners.Entry entry;
/* 110 */         if ((entry = EventListeners.b(param1EventListeners)[b2]) != null && entry.isStateAffecting()) {
/* 111 */           param1Kryo.writeClassAndObject(param1Output, entry);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public EventListeners read(Kryo param1Kryo, Input param1Input, Class<? extends EventListeners> param1Class) {
/* 119 */       EventListeners<Event> eventListeners = new EventListeners<>((byte)0);
/* 120 */       param1Kryo.reference(eventListeners);
/*     */       
/*     */       try {
/*     */         String str;
/* 124 */         if ((str = param1Input.readString()) != null) {
/* 125 */           EventListeners.a(eventListeners, ReflectionUtils.getClassByName(str));
/*     */         }
/* 127 */       } catch (IllegalArgumentException illegalArgumentException2) {
/* 128 */         IllegalArgumentException illegalArgumentException1; (illegalArgumentException1 = null).printStackTrace();
/*     */       } 
/*     */       
/* 131 */       int i = param1Input.readVarInt(true);
/* 132 */       EventListeners.a(eventListeners, i);
/* 133 */       EventListeners.b(eventListeners, i);
/* 134 */       for (byte b = 0; b < i; b++) {
/* 135 */         EventListeners.b(eventListeners)[b] = (EventListeners.Entry)param1Kryo.readClassAndObject(param1Input);
/*     */       }
/*     */       
/* 138 */       return eventListeners;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EventListeners(Class<?> paramClass) {
/* 146 */     this.c = paramClass;
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
/*     */   public final Entry<T>[] getEntriesBackingArray() {
/* 160 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   private Entry<T> a(Listener<T> paramListener) {
/* 165 */     for (byte b = 0; b < this.b; b++) {
/* 166 */       if (this.a[b] != null && Entry.a(this.a[b]) == paramListener) {
/* 167 */         return this.a[b];
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 172 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(int paramInt) {
/* 177 */     if (this.a.length < paramInt) {
/*     */       
/* 179 */       Entry[] arrayOfEntry = new Entry[MathUtils.ceil(paramInt * 1.2F)];
/* 180 */       System.arraycopy(this.a, 0, arrayOfEntry, 0, this.a.length);
/* 181 */       this.a = (Entry<T>[])arrayOfEntry;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a() {
/* 188 */     if (this.g && this.d == 0) {
/*     */       
/* 190 */       byte b1 = 0;
/* 191 */       for (byte b2 = 0; b2 < this.b; b2++) {
/* 192 */         if (this.a[b2] == null) {
/* 193 */           b1++;
/* 194 */         } else if (b1 != 0) {
/* 195 */           this.a[b2 - b1] = this.a[b2];
/* 196 */           this.a[b2] = null;
/*     */         } 
/*     */       } 
/* 199 */       this.b -= b1;
/*     */       
/* 201 */       Threads.sortArraySlice((Object[])this.a, 0, this.b, Entry.COMPARATOR);
/* 202 */       this.g = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void trigger(T paramT) {
/* 212 */     a();
/* 213 */     if (size() == 0) {
/* 214 */       this.e++;
/*     */       
/*     */       return;
/*     */     } 
/* 218 */     this.d = (short)(this.d + 1);
/* 219 */     this.e++; byte b; int i;
/* 220 */     for (b = 0, i = size(); b < i; b++) {
/*     */       Entry<T> entry;
/* 222 */       if ((entry = this.a[b]) != null) {
/* 223 */         Entry.a(entry).handleEvent(paramT);
/* 224 */         if (paramT.isStopped()) {
/* 225 */           this.f++;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 230 */     this.d = (short)(this.d - 1);
/* 231 */     a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<?> getEventClass() {
/* 238 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean contains(Listener<T> paramListener) {
/* 247 */     return (a(paramListener) != null);
/*     */   }
/*     */   
/*     */   public final int getStateHash() {
/* 251 */     int i = 0; byte b;
/*     */     int j;
/* 253 */     for (b = 0, j = size(); b < j; b++) {
/*     */       Entry<T> entry;
/* 255 */       if ((entry = this.a[b]) != null && entry.isStateAffecting()) {
/* 256 */         i = i * 31 + Entry.b(this.a[b]);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 261 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getStateAffectingEntriesCount() {
/* 268 */     byte b1 = 0; byte b2;
/*     */     int i;
/* 270 */     for (b2 = 0, i = size(); b2 < i; b2++) {
/*     */       Entry<T> entry;
/* 272 */       if ((entry = this.a[b2]) != null && entry.isStateAffecting()) {
/* 273 */         b1++;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 278 */     return b1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getNonStateAffectingEntriesCount() {
/* 285 */     return size() - getStateAffectingEntriesCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getLoops() {
/* 295 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Entry<T> add(Listener<T> paramListener) {
/* 305 */     return addWithFlags(paramListener, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Entry<T> addWithPriority(Listener<T> paramListener, int paramInt) {
/* 315 */     return addWithFlagsAndPriority(paramListener, 0, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Entry<T> addStateAffectingWithPriority(Listener<T> paramListener, int paramInt) {
/* 324 */     return addWithFlagsAndPriority(paramListener, 2, paramInt);
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
/*     */   public final Entry<T> addWithFlags(Listener<T> paramListener, int paramInt) {
/* 337 */     boolean bool = ((paramInt & 0x2) != 0);
/*     */     
/* 339 */     int i = 0;
/*     */     
/* 341 */     for (byte b = 0; b < this.b; b++) {
/*     */       Entry<T> entry1;
/* 343 */       if ((entry1 = this.a[b]) != null && entry1.isAutoPriority() && entry1.isStateAffecting() == bool && Entry.b(entry1) <= i) {
/* 344 */         i = Entry.b(entry1) - 10;
/*     */       }
/*     */     } 
/* 347 */     paramInt |= 0x1;
/*     */     
/*     */     Entry<T> entry;
/* 350 */     Entry.c(entry = addWithFlagsAndPriority(paramListener, paramInt, i));
/*     */     
/* 352 */     return entry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Entry<T> addStateAffecting(Listener<T> paramListener) {
/* 361 */     return addWithFlags(paramListener, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Entry<T> addWithFlagsAndPriority(Listener<T> paramListener, int paramInt1, int paramInt2) {
/* 369 */     if (paramListener == null) throw new IllegalArgumentException("listener is null");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 375 */     if (this.d == 0) {
/*     */       Entry<T> entry1;
/*     */       
/* 378 */       if ((entry1 = a(paramListener)) == null) {
/*     */ 
/*     */         
/* 381 */         entry1 = new Entry<>();
/* 382 */         a(this.b + 1);
/* 383 */         this.a[this.b++] = entry1;
/*     */       } 
/*     */       
/* 386 */       Entry.a(entry1, paramListener, paramInt2, this, paramInt1);
/* 387 */       this.g = true;
/*     */       
/* 389 */       return entry1;
/*     */     } 
/*     */ 
/*     */     
/*     */     Entry<T> entry;
/*     */     
/* 395 */     if ((entry = a(paramListener)) != null) {
/*     */       
/* 397 */       entry.reset();
/* 398 */       Entry.a(entry, paramListener, paramInt2, this, paramInt1);
/* 399 */       this.g = true;
/*     */       
/* 401 */       return entry;
/*     */     } 
/*     */ 
/*     */     
/* 405 */     Entry.a(entry = new Entry<>(), paramListener, paramInt2, this, paramInt1);
/* 406 */     a(this.b + 1);
/* 407 */     this.a[this.b++] = entry;
/*     */     
/* 409 */     this.g = true;
/* 410 */     return entry;
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
/*     */   public final boolean remove(Listener<T> paramListener) {
/* 457 */     if (paramListener == null) throw new IllegalArgumentException("listener is null");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 464 */     for (byte b = 0; b < this.b; b++) {
/*     */       Entry<T> entry;
/* 466 */       if ((entry = this.a[b]) != null && Entry.a(entry) == paramListener) {
/* 467 */         this.a[b] = null;
/* 468 */         this.g = true;
/* 469 */         return true;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 474 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getEventsTriggered() {
/* 481 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getEventsStopped() {
/* 488 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int size() {
/* 495 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void clear() {
/* 504 */     if (this.d != 0) throw new IllegalStateException("some loops still running");
/*     */ 
/*     */     
/* 507 */     this.a = (Entry<T>[])new Entry[2];
/* 508 */     this.b = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final StringBuilder describe() {
/*     */     StringBuilder stringBuilder;
/* 517 */     (stringBuilder = new StringBuilder()).append("listeners of ").append(String.valueOf(this.c)).append(", loops: ").append(String.valueOf(this.d)).append("\n");
/* 518 */     stringBuilder.append("entries: ").append(String.valueOf(this.b)).append("\n");
/* 519 */     for (byte b = 0; b < this.b; b++) {
/* 520 */       stringBuilder.append("  ").append(String.valueOf(b)).append(" ").append(String.valueOf(this.a[b])).append("\n");
/*     */     }
/* 522 */     return stringBuilder;
/*     */   }
/*     */   
/*     */   private static String b(byte paramByte) {
/* 526 */     return String.format("%8s", new Object[] { Integer.toBinaryString(paramByte) }).replace(' ', '0');
/*     */   }
/*     */   
/*     */   private EventListeners() {}
/*     */   
/*     */   @REGS
/*     */   public static final class Entry<T extends Event> implements Pool.Poolable, KryoSerializable { public static final Comparator<Entry<?>> COMPARATOR;
/*     */     private EntryMetaData<T> a;
/*     */     private Listener<T> b;
/*     */     
/*     */     static {
/* 537 */       COMPARATOR = ((param1Entry1, param1Entry2) -> Integer.compare(param1Entry2.c, param1Entry1.c));
/*     */     }
/*     */ 
/*     */     
/* 541 */     private int c = 0;
/*     */ 
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 545 */       if (!isStateAffecting()) {
/* 546 */         throw new IllegalStateException("Can not write non-state-affecting listener");
/*     */       }
/* 548 */       param1Kryo.writeObject(param1Output, this.a);
/* 549 */       param1Kryo.writeClassAndObject(param1Output, this.b);
/* 550 */       param1Output.writeVarInt(this.c, true);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 555 */       this.a = (EntryMetaData<T>)param1Kryo.readObject(param1Input, EntryMetaData.class);
/* 556 */       this.b = (Listener<T>)param1Kryo.readClassAndObject(param1Input);
/* 557 */       this.c = param1Input.readVarInt(true);
/*     */     }
/*     */     
/*     */     public Entry() {
/* 561 */       this.a = new EntryMetaData<>();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final EntryMetaData<T> getMetaData() {
/* 568 */       return this.a;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Entry<T> setName(String param1String) {
/* 578 */       EntryMetaData.a(this.a, param1String);
/* 579 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String getName() {
/* 586 */       if (EntryMetaData.a(this.a) == null)
/*     */       {
/* 588 */         EntryMetaData.a(this.a, this.b.getClass().getSimpleName().split("\\$")[0]);
/*     */       }
/* 590 */       return EntryMetaData.a(this.a);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Entry<T> setDescription(@Null String param1String) {
/* 600 */       EntryMetaData.b(this.a, param1String);
/* 601 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @Null
/*     */     public final String getDescription() {
/* 608 */       return EntryMetaData.b(this.a);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int getPriority() {
/* 615 */       return this.c;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Listener<T> getListener() {
/* 622 */       return this.b;
/*     */     }
/*     */     
/*     */     private Entry<T> a(Listener<T> param1Listener, int param1Int1, EventListeners<T> param1EventListeners, int param1Int2) {
/* 626 */       this.b = param1Listener;
/* 627 */       this.c = param1Int1;
/* 628 */       EntryMetaData.a(this.a, param1EventListeners);
/* 629 */       EntryMetaData.a(this.a, (byte)param1Int2);
/*     */       
/* 631 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void reset() {
/* 640 */       this.b = null;
/* 641 */       this.c = 0;
/* 642 */       EntryMetaData.c(this.a);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void remove() {
/* 650 */       EntryMetaData.d(this.a).remove(this.b);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isStateAffecting() {
/* 659 */       return this.a.flagsMatch((byte)2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isAutoPriority() {
/* 667 */       return this.a.flagsMatch((byte)1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean isPersistent() {
/* 675 */       return this.a.flagsMatch((byte)4);
/*     */     }
/*     */     
/*     */     private void a() {
/* 679 */       this.a.setFlag((byte)1, true);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Entry<T> setPersistentToTrue() {
/* 687 */       return setPersistent(true);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Entry<T> setPersistent(boolean param1Boolean) {
/* 696 */       this.a.setFlag((byte)4, param1Boolean);
/* 697 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 702 */       return super.toString() + " (listener: " + this.b + ", flags: " + EventListeners.a(EntryMetaData.e(this.a)) + ", affectsState: " + isStateAffecting() + ", autoPriority: " + isAutoPriority() + ", priority: " + this.c + ")";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @REGS
/*     */     public static final class EntryMetaData<T extends Event>
/*     */       implements KryoSerializable
/*     */     {
/* 711 */       private String a = null;
/*     */       
/*     */       private String b;
/*     */       private EventListeners<T> c;
/*     */       private byte d;
/*     */       
/*     */       public final void write(Kryo param2Kryo, Output param2Output) {
/* 718 */         param2Output.writeString(this.a);
/* 719 */         param2Output.writeString(this.b);
/* 720 */         param2Kryo.writeClassAndObject(param2Output, this.c);
/* 721 */         param2Output.writeByte(this.d);
/*     */       }
/*     */ 
/*     */       
/*     */       public final void read(Kryo param2Kryo, Input param2Input) {
/* 726 */         this.a = param2Input.readString();
/* 727 */         this.b = param2Input.readString();
/* 728 */         this.c = (EventListeners<T>)param2Kryo.readClassAndObject(param2Input);
/* 729 */         this.d = param2Input.readByte();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final boolean flagsMatch(byte param2Byte) {
/* 737 */         return ((this.d & param2Byte) == param2Byte);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final void setFlag(byte param2Byte, boolean param2Boolean) {
/* 746 */         if (param2Boolean) {
/* 747 */           this.d = (byte)(this.d | param2Byte); return;
/*     */         } 
/* 749 */         this.d = (byte)(this.d & (param2Byte ^ 0xFFFFFFFF));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public final byte getFlags() {
/* 757 */         return this.d;
/*     */       }
/*     */       
/*     */       private void a() {
/* 761 */         this.a = null;
/* 762 */         this.b = null;
/* 763 */         this.c = null;
/* 764 */         this.d = 0;
/*     */       }
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\EventListeners.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */