/*     */ package com.prineside.luaj;
/*     */ 
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.lang.ref.WeakReference;
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
/*     */ @REGS
/*     */ public class WeakTable
/*     */   implements KryoSerializable, Metatable
/*     */ {
/*     */   private boolean a;
/*     */   private boolean b;
/*     */   private LuaValue c;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  51 */     paramOutput.writeBoolean(this.a);
/*  52 */     paramOutput.writeBoolean(this.b);
/*  53 */     paramKryo.writeClassAndObject(paramOutput, this.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  58 */     this.a = paramInput.readBoolean();
/*  59 */     this.b = paramInput.readBoolean();
/*  60 */     this.c = (LuaValue)paramKryo.readClassAndObject(paramInput);
/*     */   }
/*     */   
/*     */   public static LuaTable make(boolean paramBoolean1, boolean paramBoolean2) {
/*     */     LuaString luaString;
/*  65 */     if (paramBoolean1 && paramBoolean2) {
/*  66 */       luaString = LuaString.valueOf("kv");
/*  67 */     } else if (luaString != null) {
/*  68 */       luaString = LuaString.valueOf("k");
/*  69 */     } else if (paramBoolean2) {
/*  70 */       luaString = LuaString.valueOf("v");
/*     */     } else {
/*  72 */       return LuaTable.tableOf();
/*     */     } 
/*  74 */     LuaTable luaTable2 = LuaTable.tableOf();
/*  75 */     LuaTable luaTable1 = LuaTable.tableOf(new LuaValue[] { LuaValue.MODE, luaString });
/*  76 */     luaTable2.setmetatable(luaTable1);
/*  77 */     return luaTable2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WeakTable() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public WeakTable(boolean paramBoolean1, boolean paramBoolean2, LuaValue paramLuaValue) {
/*  88 */     this.a = paramBoolean1;
/*  89 */     this.b = paramBoolean2;
/*  90 */     this.c = paramLuaValue;
/*     */   }
/*     */   
/*     */   public boolean useWeakKeys() {
/*  94 */     return this.a;
/*     */   }
/*     */   
/*     */   public boolean useWeakValues() {
/*  98 */     return this.b;
/*     */   }
/*     */   
/*     */   public LuaValue toLuaValue() {
/* 102 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public LuaTable.Slot entry(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 107 */     if ((paramLuaValue2 = paramLuaValue2.strongvalue()) == null)
/* 108 */       return null; 
/* 109 */     if (this.a && !paramLuaValue1.isnumber() && !paramLuaValue1.isstring() && !paramLuaValue1.isboolean()) {
/* 110 */       if (this.b && !paramLuaValue2.isnumber() && !paramLuaValue2.isstring() && !paramLuaValue2.isboolean()) {
/* 111 */         return new WeakKeyAndValueSlot(paramLuaValue1, paramLuaValue2, null);
/*     */       }
/* 113 */       return new WeakKeySlot(paramLuaValue1, paramLuaValue2, null);
/*     */     } 
/*     */     
/* 116 */     if (this.b && !paramLuaValue2.isnumber() && !paramLuaValue2.isstring() && !paramLuaValue2.isboolean()) {
/* 117 */       return new WeakValueSlot(paramLuaValue1, paramLuaValue2, null);
/*     */     }
/* 119 */     return LuaTable.a(paramLuaValue1, paramLuaValue2);
/*     */   }
/*     */   
/*     */   public static abstract class WeakSlot
/*     */     implements KryoSerializable, LuaTable.Slot {
/*     */     protected Object a;
/*     */     protected Object b;
/*     */     private LuaTable.Slot c;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 129 */       param1Kryo.writeClassAndObject(param1Output, this.a);
/* 130 */       param1Kryo.writeClassAndObject(param1Output, this.b);
/* 131 */       param1Kryo.writeClassAndObject(param1Output, this.c);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 136 */       this.a = param1Kryo.readClassAndObject(param1Input);
/* 137 */       this.b = param1Kryo.readClassAndObject(param1Input);
/* 138 */       this.c = (LuaTable.Slot)param1Kryo.readClassAndObject(param1Input);
/*     */     }
/*     */     
/*     */     protected WeakSlot() {}
/*     */     
/*     */     protected WeakSlot(Object param1Object1, Object param1Object2, LuaTable.Slot param1Slot) {
/* 144 */       this.a = param1Object1;
/* 145 */       this.b = param1Object2;
/* 146 */       this.c = param1Slot;
/*     */     }
/*     */     
/*     */     public abstract int keyindex(int param1Int);
/*     */     
/*     */     public abstract LuaTable.Slot set(LuaValue param1LuaValue);
/*     */     
/*     */     public LuaTable.StrongSlot first() {
/* 154 */       LuaValue luaValue1 = strongkey();
/* 155 */       LuaValue luaValue2 = strongvalue();
/* 156 */       if (luaValue1 != null && luaValue2 != null) {
/* 157 */         return new LuaTable.NormalEntry(luaValue1, luaValue2);
/*     */       }
/* 159 */       this.a = null;
/* 160 */       this.b = null;
/* 161 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public LuaTable.StrongSlot find(LuaValue param1LuaValue) {
/*     */       LuaTable.StrongSlot strongSlot;
/* 167 */       return ((strongSlot = first()) != null) ? strongSlot.find(param1LuaValue) : null;
/*     */     }
/*     */     
/*     */     public boolean keyeq(LuaValue param1LuaValue) {
/*     */       LuaTable.StrongSlot strongSlot;
/* 172 */       if ((strongSlot = first()) != null && strongSlot.keyeq(param1LuaValue)) return true;  return false;
/*     */     }
/*     */     
/*     */     public LuaTable.Slot rest() {
/* 176 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public int arraykey(int param1Int) {
/* 181 */       return 0;
/*     */     }
/*     */     
/*     */     public LuaTable.Slot set(LuaTable.StrongSlot param1StrongSlot, LuaValue param1LuaValue) {
/*     */       LuaValue luaValue;
/* 186 */       if ((luaValue = strongkey()) != null && param1StrongSlot.find(luaValue) != null)
/* 187 */         return set(param1LuaValue); 
/* 188 */       if (luaValue != null) {
/*     */         
/* 190 */         this.c = this.c.set(param1StrongSlot, param1LuaValue);
/* 191 */         return this;
/*     */       } 
/*     */       
/* 194 */       return this.c.set(param1StrongSlot, param1LuaValue);
/*     */     }
/*     */ 
/*     */     
/*     */     public LuaTable.Slot add(LuaTable.Slot param1Slot) {
/* 199 */       this.c = (this.c != null) ? this.c.add(param1Slot) : param1Slot;
/* 200 */       if (strongkey() != null && strongvalue() != null) {
/* 201 */         return this;
/*     */       }
/* 203 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public LuaTable.Slot remove(LuaTable.StrongSlot param1StrongSlot) {
/*     */       LuaValue luaValue;
/* 209 */       if ((luaValue = strongkey()) == null)
/* 210 */         return this.c.remove(param1StrongSlot); 
/* 211 */       if (param1StrongSlot.keyeq(luaValue)) {
/* 212 */         this.b = null;
/* 213 */         return this;
/*     */       } 
/* 215 */       this.c = this.c.remove(param1StrongSlot);
/* 216 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public LuaTable.Slot relink(LuaTable.Slot param1Slot) {
/* 221 */       if (strongkey() != null && strongvalue() != null) {
/* 222 */         if (param1Slot == null && this.c == null) {
/* 223 */           return this;
/*     */         }
/* 225 */         return a(param1Slot);
/*     */       } 
/*     */       
/* 228 */       return param1Slot;
/*     */     }
/*     */ 
/*     */     
/*     */     public LuaValue strongkey() {
/* 233 */       return (LuaValue)this.a;
/*     */     }
/*     */     
/*     */     public LuaValue strongvalue() {
/* 237 */       return (LuaValue)this.b;
/*     */     }
/*     */     
/*     */     protected abstract WeakSlot a(LuaTable.Slot param1Slot);
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class WeakKeySlot
/*     */     extends WeakSlot {
/*     */     private int c;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 249 */       super.write(param1Kryo, param1Output);
/* 250 */       param1Output.writeInt(this.c);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 255 */       super.read(param1Kryo, param1Input);
/* 256 */       this.c = param1Input.readInt();
/*     */     }
/*     */     
/*     */     private WeakKeySlot() {}
/*     */     
/*     */     protected WeakKeySlot(LuaValue param1LuaValue1, LuaValue param1LuaValue2, LuaTable.Slot param1Slot) {
/* 262 */       super(WeakTable.a(param1LuaValue1), param1LuaValue2, param1Slot);
/* 263 */       this.c = param1LuaValue1.hashCode();
/*     */     }
/*     */     
/*     */     private WeakKeySlot(WeakKeySlot param1WeakKeySlot, LuaTable.Slot param1Slot) {
/* 267 */       super(param1WeakKeySlot.a, param1WeakKeySlot.b, param1Slot);
/* 268 */       this.c = param1WeakKeySlot.c;
/*     */     }
/*     */     
/*     */     public final int keyindex(int param1Int) {
/* 272 */       return LuaTable.hashmod(this.c, param1Int);
/*     */     }
/*     */     
/*     */     public final LuaTable.Slot set(LuaValue param1LuaValue) {
/* 276 */       this.b = param1LuaValue;
/* 277 */       return this;
/*     */     }
/*     */     
/*     */     public final LuaValue strongkey() {
/* 281 */       return WeakTable.a(this.a);
/*     */     }
/*     */     
/*     */     protected final WeakTable.WeakSlot a(LuaTable.Slot param1Slot) {
/* 285 */       return new WeakKeySlot(this, param1Slot);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class WeakValueSlot extends WeakSlot {
/*     */     private WeakValueSlot() {}
/*     */     
/*     */     protected WeakValueSlot(LuaValue param1LuaValue1, LuaValue param1LuaValue2, LuaTable.Slot param1Slot) {
/* 294 */       super(param1LuaValue1, WeakTable.a(param1LuaValue2), param1Slot);
/*     */     }
/*     */     
/*     */     private WeakValueSlot(WeakValueSlot param1WeakValueSlot, LuaTable.Slot param1Slot) {
/* 298 */       super(param1WeakValueSlot.a, param1WeakValueSlot.b, param1Slot);
/*     */     }
/*     */     
/*     */     public final int keyindex(int param1Int) {
/* 302 */       return LuaTable.hashSlot(strongkey(), param1Int);
/*     */     }
/*     */     
/*     */     public final LuaTable.Slot set(LuaValue param1LuaValue) {
/* 306 */       this.b = WeakTable.a(param1LuaValue);
/* 307 */       return this;
/*     */     }
/*     */     
/*     */     public final LuaValue strongvalue() {
/* 311 */       return WeakTable.a(this.b);
/*     */     }
/*     */     
/*     */     protected final WeakTable.WeakSlot a(LuaTable.Slot param1Slot) {
/* 315 */       return new WeakValueSlot(this, param1Slot);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class WeakKeyAndValueSlot
/*     */     extends WeakSlot {
/*     */     private int c;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 325 */       super.write(param1Kryo, param1Output);
/* 326 */       param1Output.writeInt(this.c);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 331 */       super.read(param1Kryo, param1Input);
/* 332 */       this.c = param1Input.readInt();
/*     */     }
/*     */     
/*     */     private WeakKeyAndValueSlot() {}
/*     */     
/*     */     protected WeakKeyAndValueSlot(LuaValue param1LuaValue1, LuaValue param1LuaValue2, LuaTable.Slot param1Slot) {
/* 338 */       super(WeakTable.a(param1LuaValue1), WeakTable.a(param1LuaValue2), param1Slot);
/* 339 */       this.c = param1LuaValue1.hashCode();
/*     */     }
/*     */     
/*     */     private WeakKeyAndValueSlot(WeakKeyAndValueSlot param1WeakKeyAndValueSlot, LuaTable.Slot param1Slot) {
/* 343 */       super(param1WeakKeyAndValueSlot.a, param1WeakKeyAndValueSlot.b, param1Slot);
/* 344 */       this.c = param1WeakKeyAndValueSlot.c;
/*     */     }
/*     */     
/*     */     public final int keyindex(int param1Int) {
/* 348 */       return LuaTable.hashmod(this.c, param1Int);
/*     */     }
/*     */     
/*     */     public final LuaTable.Slot set(LuaValue param1LuaValue) {
/* 352 */       this.b = WeakTable.a(param1LuaValue);
/* 353 */       return this;
/*     */     }
/*     */     
/*     */     public final LuaValue strongkey() {
/* 357 */       return WeakTable.a(this.a);
/*     */     }
/*     */     
/*     */     public final LuaValue strongvalue() {
/* 361 */       return WeakTable.a(this.b);
/*     */     }
/*     */     
/*     */     protected final WeakTable.WeakSlot a(LuaTable.Slot param1Slot) {
/* 365 */       return new WeakKeyAndValueSlot(this, param1Slot);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static LuaValue a(LuaValue paramLuaValue) {
/* 375 */     switch (paramLuaValue.type()) {
/*     */       case 5:
/*     */       case 6:
/*     */       case 8:
/* 379 */         return new WeakValue(paramLuaValue);
/*     */       case 7:
/* 381 */         return new WeakUserdata(paramLuaValue, (byte)0);
/*     */     } 
/* 383 */     return paramLuaValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static LuaValue a(Object paramObject) {
/* 394 */     if (paramObject instanceof WeakReference) {
/* 395 */       paramObject = ((WeakReference)paramObject).get();
/*     */     }
/* 397 */     if (paramObject instanceof WeakValue) {
/* 398 */       return ((WeakValue)paramObject).strongvalue();
/*     */     }
/* 400 */     return (LuaValue)paramObject;
/*     */   }
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static class WeakValue
/*     */     extends LuaValue
/*     */     implements KryoSerializable
/*     */   {
/*     */     WeakReference a;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 412 */       param1Kryo.writeClassAndObject(param1Output, this.a.get());
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 417 */       this.a = new WeakReference(param1Kryo.readClassAndObject(param1Input));
/*     */     }
/*     */     
/*     */     private WeakValue() {}
/*     */     
/*     */     protected WeakValue(LuaValue param1LuaValue) {
/* 423 */       this.a = new WeakReference<>(param1LuaValue);
/*     */     }
/*     */     
/*     */     public final int type() {
/* 427 */       a("type", "weak value");
/* 428 */       return 0;
/*     */     }
/*     */     
/*     */     public final String typename() {
/* 432 */       a("typename", "weak value");
/* 433 */       return null;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 437 */       return "weak<" + this.a.get() + ">";
/*     */     }
/*     */     
/*     */     public LuaValue strongvalue() {
/*     */       LuaValue luaValue;
/* 442 */       return (LuaValue)(luaValue = (LuaValue)this.a.get());
/*     */     }
/*     */     
/*     */     public boolean raweq(LuaValue param1LuaValue) {
/*     */       LuaValue luaValue;
/* 447 */       if ((luaValue = (LuaValue)this.a.get()) != null && param1LuaValue.raweq(luaValue)) return true;  return false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static final class WeakUserdata
/*     */     extends WeakValue
/*     */   {
/*     */     private WeakReference b;
/*     */     
/*     */     private LuaValue c;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 461 */       super.write(param1Kryo, param1Output);
/* 462 */       param1Kryo.writeClassAndObject(param1Output, this.b.get());
/* 463 */       param1Kryo.writeClassAndObject(param1Output, this.c);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 468 */       super.read(param1Kryo, param1Input);
/* 469 */       this.b = new WeakReference(param1Kryo.readClassAndObject(param1Input));
/* 470 */       this.c = (LuaValue)param1Kryo.readClassAndObject(param1Input);
/*     */     }
/*     */     private WeakUserdata() {
/* 473 */       super((byte)0);
/*     */     }
/*     */     private WeakUserdata(LuaValue param1LuaValue) {
/* 476 */       super(param1LuaValue);
/* 477 */       this.b = new WeakReference(param1LuaValue.touserdata());
/* 478 */       this.c = param1LuaValue.getmetatable();
/*     */     }
/*     */     
/*     */     public final LuaValue strongvalue() {
/*     */       LuaValue luaValue;
/* 483 */       if ((luaValue = (LuaValue)this.a.get()) != null) {
/* 484 */         return luaValue;
/*     */       }
/* 486 */       if ((luaValue = this.b.get()) != null) {
/* 487 */         luaValue = LuaValue.userdataOf(luaValue, this.c);
/* 488 */         this.a = new WeakReference<>(luaValue);
/* 489 */         return luaValue;
/*     */       } 
/* 491 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public LuaValue wrap(LuaValue paramLuaValue) {
/* 497 */     return this.b ? a(paramLuaValue) : paramLuaValue;
/*     */   }
/*     */   
/*     */   public LuaValue arrayget(LuaValue[] paramArrayOfLuaValue, int paramInt) {
/*     */     LuaValue luaValue;
/* 502 */     if ((luaValue = paramArrayOfLuaValue[paramInt]) != null && (
/*     */       
/* 504 */       luaValue = a(luaValue)) == null) {
/* 505 */       paramArrayOfLuaValue[paramInt] = null;
/*     */     }
/*     */     
/* 508 */     return luaValue;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\WeakTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */