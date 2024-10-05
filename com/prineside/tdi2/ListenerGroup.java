/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS(serializer = ListenerGroup.Serializer.class)
/*     */ public final class ListenerGroup<T extends GameListener> {
/*  18 */   private static final TLog a = TLog.forClass(ListenerGroup.class);
/*     */   private final Class b;
/*     */   private DelayedRemovalArray<T> c;
/*     */   @NAGS
/*     */   private final DelayedRemovalArray<T> d;
/*  23 */   private ObjectSet<T> e = new ObjectSet();
/*     */   private Array<T> f;
/*     */   @NAGS
/*  26 */   private int g = 0;
/*     */   @NAGS
/*     */   private String h;
/*     */   
/*     */   public static class Serializer extends com.esotericsoftware.kryo.Serializer<ListenerGroup> {
/*     */     public void write(Kryo param1Kryo, Output param1Output, ListenerGroup param1ListenerGroup) {
/*  32 */       param1Kryo.writeClass(param1Output, ListenerGroup.a(param1ListenerGroup));
/*  33 */       param1Kryo.writeClassAndObject(param1Output, ListenerGroup.b(param1ListenerGroup));
/*  34 */       param1Kryo.writeObject(param1Output, ListenerGroup.c(param1ListenerGroup));
/*  35 */       param1Kryo.writeObject(param1Output, ListenerGroup.d(param1ListenerGroup));
/*     */     }
/*     */ 
/*     */     
/*     */     public ListenerGroup read(Kryo param1Kryo, Input param1Input, Class<? extends ListenerGroup> param1Class) {
/*  40 */       param1Class = param1Kryo.readClass(param1Input).getType();
/*     */       ListenerGroup<GameListener> listenerGroup;
/*  42 */       ListenerGroup.a(listenerGroup = new ListenerGroup<>(param1Class), (DelayedRemovalArray)param1Kryo.readClassAndObject(param1Input));
/*  43 */       ListenerGroup.a(listenerGroup, (ObjectSet)param1Kryo.readObject(param1Input, ObjectSet.class));
/*  44 */       ListenerGroup.a(listenerGroup, (Array)param1Kryo.readObject(param1Input, Array.class));
/*     */       
/*  46 */       return listenerGroup;
/*     */     }
/*     */ 
/*     */     
/*     */     public ListenerGroup copy(Kryo param1Kryo, ListenerGroup param1ListenerGroup) {
/*     */       ListenerGroup<GameListener> listenerGroup;
/*  52 */       ListenerGroup.a(listenerGroup = new ListenerGroup<>(ListenerGroup.a(param1ListenerGroup)), (DelayedRemovalArray)param1Kryo.getSerializer(DelayedRemovalArray.class).copy(param1Kryo, ListenerGroup.b(param1ListenerGroup)));
/*  53 */       ListenerGroup.a(listenerGroup, (ObjectSet)param1Kryo.getSerializer(ObjectSet.class).copy(param1Kryo, ListenerGroup.c(param1ListenerGroup)));
/*  54 */       ListenerGroup.a(listenerGroup, (Array)param1Kryo.getSerializer(Array.class).copy(param1Kryo, ListenerGroup.d(param1ListenerGroup)));
/*  55 */       return listenerGroup;
/*     */     }
/*     */   }
/*     */   
/*  59 */   public static DeepClassComparator<ListenerGroup> CLASS_COMPARATOR = new DeepClassComparator<ListenerGroup>() {
/*     */       public Class<ListenerGroup> forClass() {
/*  61 */         return ListenerGroup.class;
/*     */       }
/*     */       
/*     */       public void compare(ListenerGroup param1ListenerGroup1, ListenerGroup param1ListenerGroup2, DeepClassComparisonConfig param1DeepClassComparisonConfig) {
/*  65 */         param1DeepClassComparisonConfig.addPrefix(new String[] { ".stateAffectingListeners" });
/*  66 */         SyncChecker.compareObjects(ListenerGroup.b(param1ListenerGroup1), ListenerGroup.b(param1ListenerGroup2), param1DeepClassComparisonConfig);
/*  67 */         param1DeepClassComparisonConfig.popPrefix(1);
/*     */         
/*  69 */         param1DeepClassComparisonConfig.addPrefix(new String[] { ".removing" });
/*  70 */         SyncChecker.compareObjects(ListenerGroup.c(param1ListenerGroup1), ListenerGroup.c(param1ListenerGroup2), param1DeepClassComparisonConfig);
/*  71 */         param1DeepClassComparisonConfig.popPrefix(1);
/*     */         
/*  73 */         param1DeepClassComparisonConfig.addPrefix(new String[] { ".adding" });
/*  74 */         SyncChecker.compareObjects(ListenerGroup.d(param1ListenerGroup1), ListenerGroup.d(param1ListenerGroup2), param1DeepClassComparisonConfig);
/*  75 */         param1DeepClassComparisonConfig.popPrefix(1);
/*     */       }
/*     */     };
/*     */   static {
/*  79 */     SyncChecker.CLASS_COMPARATORS.add(CLASS_COMPARATOR);
/*     */   }
/*     */   
/*     */   public ListenerGroup(Class paramClass) {
/*  83 */     this.b = paramClass;
/*  84 */     this.c = new DelayedRemovalArray(true, 1, paramClass);
/*  85 */     this.d = new DelayedRemovalArray(true, 1, paramClass);
/*  86 */     this.f = new Array(true, 1, paramClass);
/*     */   }
/*     */   
/*     */   public ListenerGroup(Class paramClass, String paramString) {
/*  90 */     this(paramClass);
/*     */     
/*  92 */     this.h = paramString;
/*     */   }
/*     */   
/*     */   public final boolean contains(T paramT) {
/*     */     DelayedRemovalArray<T> delayedRemovalArray;
/*  97 */     return (delayedRemovalArray = paramT.affectsGameState() ? this.c : this.d).contains(paramT, true);
/*     */   }
/*     */   
/*     */   public final int getStateHash() {
/* 101 */     int i = 0;
/* 102 */     for (byte b = 0; b < this.c.size; b++) {
/* 103 */       i = i * 31 + ((GameListener[])this.c.items)[b].getConstantId();
/*     */     }
/*     */     
/* 106 */     return i;
/*     */   }
/*     */   
/*     */   public final boolean add(T paramT) {
/* 110 */     if (paramT == null) throw new IllegalArgumentException("listener is null"); 
/* 111 */     if (this.h != null) a.i(this.h + " add " + paramT.getClass().getName() + " (" + (paramT.affectsGameState() ? "true" : "false") + ")", new Object[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     if (this.g == 0) {
/*     */       
/* 120 */       DelayedRemovalArray<T> delayedRemovalArray = paramT.affectsGameState() ? this.c : this.d;
/* 121 */       for (byte b1 = 0; b1 < delayedRemovalArray.size; b1++) {
/* 122 */         if (((GameListener[])delayedRemovalArray.items)[b1] == paramT)
/*     */         {
/*     */ 
/*     */           
/* 126 */           return false;
/*     */         }
/*     */       } 
/*     */       
/* 130 */       delayedRemovalArray.add(paramT);
/*     */       
/* 132 */       return true;
/*     */     } 
/*     */     
/* 135 */     if (!paramT.affectsGameState()) throw new IllegalStateException("listener not affects game state, should not be added inside other listener"); 
/*     */     byte b;
/* 137 */     for (b = 0; b < this.f.size; b++) {
/* 138 */       if (((GameListener[])this.f.items)[b] == paramT)
/*     */       {
/*     */ 
/*     */         
/* 142 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 147 */     b = 0;
/* 148 */     for (int i = this.c.size - 1; i >= 0; i--) {
/* 149 */       if (((GameListener[])this.c.items)[i] == paramT) {
/* 150 */         b = 1;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 155 */     if (b != 0) {
/*     */       
/* 157 */       if (this.e.contains(paramT)) {
/*     */         
/* 159 */         this.e.remove(paramT);
/* 160 */         this.c.add(paramT);
/*     */         
/* 162 */         return true;
/*     */       } 
/*     */ 
/*     */       
/* 166 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 170 */     this.f.add(paramT);
/*     */     
/* 172 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean remove(T paramT) {
/* 178 */     if (paramT == null) throw new IllegalArgumentException("listener is null"); 
/* 179 */     if (this.h != null) a.i(this.h + " remove " + paramT.getClass().getName() + " (" + (paramT.affectsGameState() ? "true" : "false") + ")", new Object[0]);
/*     */     
/* 181 */     if (this.g != 0) {
/*     */       
/* 183 */       if (!paramT.affectsGameState()) throw new IllegalStateException("listener not affects game state, should not be removed inside other listener"); 
/* 184 */       if (this.e.contains(paramT))
/*     */       {
/*     */         
/* 187 */         return false;
/*     */       }
/*     */       
/* 190 */       if (this.c.contains(paramT, true)) {
/*     */         
/* 192 */         this.e.add(paramT);
/*     */         
/* 194 */         return this.c.removeValue(paramT, true);
/*     */       } 
/*     */       
/* 197 */       if (this.f.contains(paramT, true))
/*     */       {
/* 199 */         return this.f.removeValue(paramT, true);
/*     */       }
/*     */       
/* 202 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 210 */     return this.c.removeValue(paramT, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void begin() {
/* 215 */     this.c.begin();
/* 216 */     this.d.begin();
/* 217 */     this.g++;
/*     */   }
/*     */   
/*     */   public final void end() {
/* 221 */     this.c.end();
/* 222 */     this.d.end();
/* 223 */     this.g--;
/*     */     
/* 225 */     if (this.g < 0)
/* 226 */       throw new IllegalStateException("begin() called more times than end()"); 
/* 227 */     if (this.g == 0) {
/*     */       
/* 229 */       this.c.addAll(this.f);
/* 230 */       this.f.clear();
/* 231 */       this.e.clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   public final int size() {
/* 236 */     return this.c.size + this.d.size;
/*     */   }
/*     */   
/*     */   public final T get(int paramInt) {
/* 240 */     if (this.g == 0) throw new IllegalStateException("begin() must be called first");
/*     */     
/* 242 */     if (paramInt < this.c.size) {
/* 243 */       return (T)((GameListener[])this.c.items)[paramInt];
/*     */     }
/* 245 */     return (T)((GameListener[])this.d.items)[paramInt - this.c.size];
/*     */   }
/*     */ 
/*     */   
/*     */   public final void clear() {
/* 250 */     if (this.g != 0) throw new IllegalStateException("some loops still running");
/*     */     
/* 252 */     this.c.clear();
/* 253 */     this.d.clear();
/* 254 */     this.e.clear();
/* 255 */     this.f.clear();
/*     */   }
/*     */   
/*     */   public final void describe() {
/* 259 */     a.i("loops: " + this.g, new Object[0]);
/* 260 */     a.i("state affecting: " + this.c.size, new Object[0]); byte b2;
/* 261 */     for (b2 = 0; b2 < this.c.size; b2++) {
/* 262 */       a.i("  " + b2 + " " + String.valueOf(((GameListener[])this.c.items)[b2]), new Object[0]);
/*     */     }
/* 264 */     a.i("non intrusive: " + this.d.size, new Object[0]);
/* 265 */     for (b2 = 0; b2 < this.d.size; b2++) {
/* 266 */       a.i("  " + b2 + " " + String.valueOf(((GameListener[])this.d.items)[b2]), new Object[0]);
/*     */     }
/* 268 */     a.i("removing: " + this.e.size, new Object[0]);
/* 269 */     for (ObjectSet.ObjectSetIterator<GameListener> objectSetIterator = this.e.iterator(); objectSetIterator.hasNext(); ) { GameListener gameListener = objectSetIterator.next();
/* 270 */       a.i("  " + String.valueOf(gameListener), new Object[0]); }
/*     */     
/* 272 */     a.i("adding: " + this.f.size, new Object[0]);
/* 273 */     for (byte b1 = 0; b1 < this.f.size; b1++)
/* 274 */       a.i("  " + b1 + " " + String.valueOf(((GameListener[])this.f.items)[b1]), new Object[0]); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ListenerGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */