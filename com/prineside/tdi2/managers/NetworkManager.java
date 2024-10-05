/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.FloatArray;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.IntFloatMap;
/*     */ import com.badlogic.gdx.utils.IntIntMap;
/*     */ import com.badlogic.gdx.utils.IntMap;
/*     */ import com.badlogic.gdx.utils.IntSet;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.ObjectFloatMap;
/*     */ import com.badlogic.gdx.utils.ObjectIntMap;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.ReferenceResolver;
/*     */ import com.esotericsoftware.kryo.Registration;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.esotericsoftware.kryo.serializers.DefaultArraySerializers;
/*     */ import com.esotericsoftware.kryo.serializers.FieldSerializer;
/*     */ import com.esotericsoftware.kryo.util.MapReferenceResolver;
/*     */ import com.esotericsoftware.kryo.util.Util;
/*     */ import com.esotericsoftware.kryonet.FrameworkMessage;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.actions.BuildMinerAction;
/*     */ import com.prineside.tdi2.actions.BuildModifierAction;
/*     */ import com.prineside.tdi2.actions.BuildTowerAction;
/*     */ import com.prineside.tdi2.actions.CallWaveAction;
/*     */ import com.prineside.tdi2.actions.ChangeTowerAimStrategyAction;
/*     */ import com.prineside.tdi2.actions.CustomTowerButtonAction;
/*     */ import com.prineside.tdi2.actions.GlobalUpgradeMinerAction;
/*     */ import com.prineside.tdi2.actions.GlobalUpgradeTowerAction;
/*     */ import com.prineside.tdi2.actions.RewardingAdAction;
/*     */ import com.prineside.tdi2.actions.SelectGlobalTowerAbilityAction;
/*     */ import com.prineside.tdi2.actions.SelectTowerAbilityAction;
/*     */ import com.prineside.tdi2.actions.SellMinerAction;
/*     */ import com.prineside.tdi2.actions.SellModifierAction;
/*     */ import com.prineside.tdi2.actions.SellTowerAction;
/*     */ import com.prineside.tdi2.actions.UpgradeMinerAction;
/*     */ import com.prineside.tdi2.actions.UpgradeTowerAction;
/*     */ import com.prineside.tdi2.actions.UseAbilityAction;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.MinerType;
/*     */ import com.prineside.tdi2.enums.ModifierType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.serializers.ArraySerializer;
/*     */ import com.prineside.tdi2.serializers.ColorSerializer;
/*     */ import com.prineside.tdi2.serializers.FloatArraySerializer;
/*     */ import com.prineside.tdi2.serializers.GameStateSerializer;
/*     */ import com.prineside.tdi2.serializers.IntArraySerializer;
/*     */ import com.prineside.tdi2.serializers.IntFloatMapSerializer;
/*     */ import com.prineside.tdi2.serializers.IntIntMapSerializer;
/*     */ import com.prineside.tdi2.serializers.IntMapSerializer;
/*     */ import com.prineside.tdi2.serializers.IntSetSerializer;
/*     */ import com.prineside.tdi2.serializers.JsonValueSerializer;
/*     */ import com.prineside.tdi2.serializers.ObjectFloatMapSerializer;
/*     */ import com.prineside.tdi2.serializers.ObjectIntMapSerializer;
/*     */ import com.prineside.tdi2.serializers.ObjectMapSerializer;
/*     */ import com.prineside.tdi2.serializers.ObjectSetSerializer;
/*     */ import com.prineside.tdi2.serializers.ProxySerializer;
/*     */ import com.prineside.tdi2.serializers.RandomXS128Serializer;
/*     */ import com.prineside.tdi2.serializers.RectangleSerializer;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.serializers.Vector2Serializer;
/*     */ import com.prineside.tdi2.serializers.Vector3Serializer;
/*     */ import com.prineside.tdi2.serializers.WeakReferenceSerializer;
/*     */ import com.prineside.tdi2.systems.StateSystem;
/*     */ import com.prineside.tdi2.ui.shared.AbilitySelectionOverlay;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.EnumSet;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ 
/*     */ @REGS(serializer = NetworkManager.Serializer.class)
/*     */ public class NetworkManager
/*     */   extends Manager.ManagerAdapter {
/*  96 */   private static final TLog a = TLog.forClass(NetworkManager.class);
/*     */   private KryoForState b;
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<NetworkManager> { public NetworkManager read() {
/* 100 */       return Game.i.networkManager;
/*     */     } }
/*     */ 
/*     */   
/* 104 */   private final AtomicBoolean c = new AtomicBoolean(false);
/*     */ 
/*     */ 
/*     */   
/* 108 */   public Array<Registration> registeredClasses = new Array(Registration.class);
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
/*     */   public void setup() {
/* 145 */     this.b = new KryoForState(this);
/*     */     
/* 147 */     this.b.setReferenceResolver((ReferenceResolver)new MapReferenceResolver(this)
/*     */         {
/*     */           public Object getReadObject(Class param1Class, int param1Int)
/*     */           {
/*     */             Object object;
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
/* 176 */             if ((object = super.getReadObject(param1Class, param1Int)) == null) {
/* 177 */               NetworkManager.a().e("the object by ref " + param1Int + " of type " + param1Class + " is null", new Object[] { new Throwable() });
/*     */             }
/*     */             
/* 180 */             return object;
/*     */           }
/*     */         });
/*     */     
/* 184 */     Threads.i().runAsync(() -> {
/*     */           try {
/*     */             a(this.b); return;
/* 187 */           } catch (Exception exception) {
/*     */             throw new IllegalStateException("fullKryo failed to init", exception);
/*     */           } 
/*     */         });
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
/*     */   public byte[] objectToBytes(Object paramObject) {
/* 339 */     KryoForState kryoForState = getFullKryo();
/* 340 */     Output output = new Output(8192, -1);
/* 341 */     kryoForState.writeClassAndObject(output, paramObject);
/* 342 */     return output.toBytes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object bytesToObject(byte[] paramArrayOfbyte) {
/* 349 */     KryoForState kryoForState = getFullKryo();
/* 350 */     Input input = new Input(paramArrayOfbyte);
/* 351 */     return kryoForState.readClassAndObject(input);
/*     */   }
/*     */   
/*     */   public void prepareMultiplayerKryo(Kryo paramKryo) {
/* 355 */     paramKryo.setMaxDepth(4);
/* 356 */     paramKryo.setRegistrationRequired(true);
/*     */ 
/*     */     
/* 359 */     paramKryo.register(NetReqConnect.class);
/* 360 */     paramKryo.register(NetRespConnect.class);
/* 361 */     paramKryo.register(NetBundle.class);
/* 362 */     paramKryo.register(Application.ApplicationType.class);
/*     */   }
/*     */   
/*     */   public KryoForState getFullKryo() {
/* 366 */     if (this.c.get()) {
/* 367 */       return this.b;
/*     */     }
/* 369 */     a.i("waiting for fullKryo to load...", new Object[0]);
/* 370 */     long l = Game.getTimestampMillis();
/* 371 */     while (!this.c.get()) {
/*     */       try {
/* 373 */         Thread.sleep(2L);
/* 374 */       } catch (InterruptedException interruptedException) {
/* 375 */         throw new RuntimeException(interruptedException);
/*     */       } 
/* 377 */       if (Game.getTimestampMillis() - interruptedException > 7000L) {
/* 378 */         throw new RuntimeException("Full kryo init takes too long");
/*     */       }
/*     */     } 
/* 381 */     a.d("blocked main thread for " + (Game.getTimestampMillis() - interruptedException) + "ms to wait for a full kryo", new Object[0]);
/* 382 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(KryoForState paramKryoForState) {
/* 391 */     a.i("prepareFullKryo called...", new Object[0]);
/* 392 */     paramKryoForState.setDefaultSerializer(GameStateSerializer.class);
/* 393 */     paramKryoForState.setMaxDepth(2048);
/* 394 */     paramKryoForState.setReferences(true);
/* 395 */     paramKryoForState.setRegistrationRequired(true);
/*     */ 
/*     */     
/* 398 */     paramKryoForState.register(Class.class);
/* 399 */     paramKryoForState.register(Class[].class);
/* 400 */     paramKryoForState.register(float[].class);
/* 401 */     paramKryoForState.register(float[][].class);
/* 402 */     paramKryoForState.register(double[].class);
/* 403 */     paramKryoForState.register(double[][].class);
/* 404 */     paramKryoForState.register(int[].class);
/* 405 */     paramKryoForState.register(int[][].class);
/* 406 */     paramKryoForState.register(boolean[].class);
/* 407 */     paramKryoForState.register(boolean[][].class);
/* 408 */     paramKryoForState.register(byte[].class);
/* 409 */     paramKryoForState.register(byte[][].class);
/* 410 */     paramKryoForState.register(long[].class);
/* 411 */     paramKryoForState.register(long[][].class);
/* 412 */     paramKryoForState.register(short[].class);
/* 413 */     paramKryoForState.register(short[][].class);
/* 414 */     paramKryoForState.register(Object.class, GameStateSerializer.CLASS_ONLY_SERIALIZER);
/* 415 */     paramKryoForState.register(Object[].class);
/* 416 */     paramKryoForState.register(Object[][].class);
/* 417 */     paramKryoForState.register(String[].class);
/* 418 */     paramKryoForState.register(String[][].class);
/*     */ 
/*     */     
/* 421 */     paramKryoForState.register(Array.class, (com.esotericsoftware.kryo.Serializer)new ArraySerializer());
/* 422 */     paramKryoForState.register(IntArray.class, (com.esotericsoftware.kryo.Serializer)new IntArraySerializer());
/* 423 */     paramKryoForState.register(FloatArray.class, (com.esotericsoftware.kryo.Serializer)new FloatArraySerializer());
/* 424 */     paramKryoForState.register(Vector2.class, (com.esotericsoftware.kryo.Serializer)new Vector2Serializer());
/* 425 */     paramKryoForState.register(Vector3.class, (com.esotericsoftware.kryo.Serializer)new Vector3Serializer());
/* 426 */     paramKryoForState.register(Rectangle.class, (com.esotericsoftware.kryo.Serializer)new RectangleSerializer());
/* 427 */     paramKryoForState.register(IntIntMap.class, (com.esotericsoftware.kryo.Serializer)new IntIntMapSerializer());
/* 428 */     paramKryoForState.register(IntFloatMap.class, (com.esotericsoftware.kryo.Serializer)new IntFloatMapSerializer());
/* 429 */     paramKryoForState.register(IntSet.class, (com.esotericsoftware.kryo.Serializer)new IntSetSerializer());
/* 430 */     paramKryoForState.register(ObjectSet.class, (com.esotericsoftware.kryo.Serializer)new ObjectSetSerializer());
/* 431 */     paramKryoForState.register(ObjectMap.class, (com.esotericsoftware.kryo.Serializer)new ObjectMapSerializer());
/* 432 */     paramKryoForState.register(ObjectIntMap.class, (com.esotericsoftware.kryo.Serializer)new ObjectIntMapSerializer());
/* 433 */     paramKryoForState.register(ObjectFloatMap.class, (com.esotericsoftware.kryo.Serializer)new ObjectFloatMapSerializer());
/* 434 */     paramKryoForState.register(IntMap.class, (com.esotericsoftware.kryo.Serializer)new IntMapSerializer());
/* 435 */     paramKryoForState.register(DelayedRemovalArray.class, (com.esotericsoftware.kryo.Serializer)new ArraySerializer());
/* 436 */     paramKryoForState.register(RandomXS128.class, (com.esotericsoftware.kryo.Serializer)new RandomXS128Serializer());
/* 437 */     paramKryoForState.register(DelayedRemovalArray[].class, (com.esotericsoftware.kryo.Serializer)new DefaultArraySerializers.ObjectArraySerializer(paramKryoForState, DelayedRemovalArray[].class));
/* 438 */     paramKryoForState.register(Array[].class, (com.esotericsoftware.kryo.Serializer)new DefaultArraySerializers.ObjectArraySerializer(paramKryoForState, Array[].class));
/* 439 */     paramKryoForState.register(InvocationHandler.class, (com.esotericsoftware.kryo.Serializer)new ProxySerializer());
/* 440 */     paramKryoForState.register(WeakReference.class, (com.esotericsoftware.kryo.Serializer)new WeakReferenceSerializer());
/* 441 */     paramKryoForState.register(Color.class, (com.esotericsoftware.kryo.Serializer)new ColorSerializer());
/* 442 */     paramKryoForState.register(JsonValue.class, (com.esotericsoftware.kryo.Serializer)new JsonValueSerializer());
/*     */ 
/*     */     
/* 445 */     Array array = new Array(Class.class);
/*     */ 
/*     */     
/* 448 */     a.i("reading kryo-registry.txt...", new Object[0]); String str, arrayOfString[];
/*     */     int i;
/*     */     byte b;
/* 451 */     for (i = (arrayOfString = arrayOfString = (str = Gdx.files.internal("res/kryo-registry.txt").readString("UTF-8")).split("\n")).length, b = 0; b < i; b++) {
/* 452 */       String str1; if ((str1 = arrayOfString[b]).length() > 0) {
/*     */         try {
/* 454 */           array.add(Class.forName(str1));
/* 455 */         } catch (ClassNotFoundException classNotFoundException) {
/* 456 */           throw new IllegalStateException("Failed to load class from kryo-registry: " + str1, classNotFoundException);
/*     */         } 
/*     */       }
/*     */     } 
/* 460 */     a.i("found " + ((Array)classNotFoundException).size + " classes in kryo-registry.txt", new Object[0]);
/*     */     
/* 462 */     for (Array.ArrayIterator<Class<?>> arrayIterator = classNotFoundException.iterator(); arrayIterator.hasNext(); ) {
/*     */       Class<?> clazz1;
/*     */       REGS rEGS;
/* 465 */       if ((rEGS = (clazz1 = arrayIterator.next()).<Annotation>getAnnotation(REGS.class)) == null) {
/* 466 */         a.e("REGS not found for " + clazz1, new Object[0]);
/*     */         
/*     */         continue;
/*     */       } 
/* 470 */       boolean bool2 = Modifier.isAbstract(clazz1.getModifiers());
/* 471 */       boolean bool1 = (clazz1.isMemberClass() && !Modifier.isStatic(clazz1.getModifiers())) ? true : false;
/*     */       
/* 473 */       if (bool2 && rEGS.arrayLevels() == 0 && !rEGS.classOnly()) {
/* 474 */         a.e("REGS should not be used on abstract class " + clazz1, new Object[0]);
/*     */         continue;
/*     */       } 
/* 477 */       if (bool1) {
/* 478 */         a.e("REGS should not be used on non-static inner class " + clazz1, new Object[0]);
/*     */         
/*     */         continue;
/*     */       } 
/* 482 */       bool1 = false; Class[] arrayOfClass1; byte b1;
/* 483 */       for (int j = (arrayOfClass1 = clazz1.getInterfaces()).length; b1 < j; b1++) {
/* 484 */         Class<KryoSerializable> clazz; if ((clazz = arrayOfClass1[b1]) == KryoSerializable.class) {
/* 485 */           bool1 = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 490 */       boolean bool3 = false;
/*     */       try {
/* 492 */         clazz1.getDeclaredConstructor(new Class[0]);
/* 493 */         bool3 = true;
/* 494 */       } catch (Exception exception) {}
/*     */       
/* 496 */       boolean bool4 = clazz1.isEnum();
/*     */       
/* 498 */       b1 = 0; Class[] arrayOfClass2; int k, m;
/* 499 */       for (k = (arrayOfClass2 = clazz1.getInterfaces()).length, m = 0; m < k; m++) {
/* 500 */         Class<KryoSerializable> clazz; if ((clazz = arrayOfClass2[m]) == KryoSerializable.class) {
/* 501 */           b1 = 1;
/*     */           break;
/*     */         } 
/*     */       } 
/* 505 */       Class<?> clazz2 = clazz1.getSuperclass();
/* 506 */       label125: while (clazz2 != null && clazz2 != Object.class) {
/*     */         Class[] arrayOfClass; byte b2;
/* 508 */         for (m = (arrayOfClass = clazz2.getInterfaces()).length, b2 = 0; b2 < m; b2++) {
/* 509 */           Class<KryoSerializable> clazz; if ((clazz = arrayOfClass[b2]) == KryoSerializable.class) {
/* 510 */             b1 = 1;
/*     */             
/*     */             break label125;
/*     */           } 
/*     */         } 
/* 515 */         clazz2 = clazz2.getSuperclass();
/*     */       } 
/*     */       
/* 518 */       if (!bool2 || rEGS.classOnly()) {
/* 519 */         Class<GameStateSerializer> clazz = rEGS.serializer();
/*     */         try {
/* 521 */           if (!bool2 && b1 != 0 && rEGS.classOnly()) {
/* 522 */             a.e(clazz1.getName() + " uses class only serializer while extending the serializable class with fields", new Object[0]);
/*     */           }
/*     */           
/* 525 */           if (rEGS.classOnly()) {
/*     */             
/* 527 */             paramKryoForState.register(clazz1, GameStateSerializer.CLASS_ONLY_SERIALIZER);
/* 528 */             if (bool1 && !bool2) {
/* 529 */               a.e(" ^^^ " + clazz1.getName() + " implements KryoSerializable - incorrect REGS configuration?", new Object[0]);
/*     */             }
/*     */           }
/* 532 */           else if (clazz == GameStateSerializer.class) {
/*     */ 
/*     */             
/* 535 */             paramKryoForState.register(clazz1);
/* 536 */             if (!bool3 && !bool4) {
/* 537 */               a.e(" ^^^ " + clazz1.getName() + " has no declared constructor", new Object[0]);
/*     */             }
/*     */           } else {
/* 540 */             com.esotericsoftware.kryo.Serializer serializer = (com.esotericsoftware.kryo.Serializer)clazz.newInstance();
/*     */             
/* 542 */             paramKryoForState.register(clazz1, serializer);
/*     */           }
/*     */         
/* 545 */         } catch (Exception exception) {
/* 546 */           a.e("failed to register class: " + clazz1.getName() + " with serializer: " + clazz.getName(), new Object[] { exception });
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 551 */       for (k = 1, m = rEGS.arrayLevels(); k <= m; k++) {
/* 552 */         StringBuilder stringBuilder = new StringBuilder();
/* 553 */         for (byte b2 = 0; b2 < k; b2++) {
/* 554 */           stringBuilder.append("[");
/*     */         }
/* 556 */         stringBuilder.append("L").append(clazz1.getName()).append(";");
/*     */         
/*     */         try {
/* 559 */           paramKryoForState.register(Class.forName(stringBuilder.toString()));
/*     */         }
/* 561 */         catch (ClassNotFoundException classNotFoundException1) {
/* 562 */           a.e("failed to register class: " + stringBuilder, new Object[] { classNotFoundException1 });
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 569 */       for (byte b1 = 0; b1 < this.registeredClasses.size; b1++) {
/*     */         Registration registration;
/*     */ 
/*     */ 
/*     */         
/* 574 */         if ((registration = ((Registration[])this.registeredClasses.items)[b1]).getSerializer() instanceof com.esotericsoftware.kryo.serializers.DefaultSerializers.KryoSerializableSerializer) {
/*     */           try {
/* 576 */             this.b.newInstance(registration.getType());
/* 577 */           } catch (Exception exception) {
/* 578 */             a.e("failed to create instance of " + registration.getType(), new Object[] { exception });
/*     */           } 
/*     */         }
/*     */       } 
/* 582 */     } catch (Exception exception) {
/* 583 */       a.e("failed to print registered classes", new Object[] { exception });
/*     */     } 
/*     */     
/* 586 */     a.i("kryo registry loaded", new Object[0]);
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
/* 664 */     this.c.set(true);
/*     */   }
/*     */   
/*     */   public static void prepareNetworkKryo(KryoForState paramKryoForState) {
/* 668 */     paramKryoForState.setMaxDepth(8);
/* 669 */     paramKryoForState.setRegistrationRequired(true);
/*     */     
/* 671 */     paramKryoForState.register(IntIntMap.class, (com.esotericsoftware.kryo.Serializer)new IntIntMapSerializer());
/* 672 */     paramKryoForState.register(Array.class, (com.esotericsoftware.kryo.Serializer)new ArraySerializer());
/* 673 */     paramKryoForState.register(AbilitySelectionOverlay.SelectedAbilitiesConfiguration.class);
/* 674 */     paramKryoForState.register(AbilityType.class);
/* 675 */     paramKryoForState.register(TowerType.class);
/* 676 */     paramKryoForState.register(Tower.AimStrategy.class);
/* 677 */     paramKryoForState.register(ModifierType.class);
/* 678 */     paramKryoForState.register(MinerType.class);
/* 679 */     paramKryoForState.register(StateSystem.ActionUpdatePair.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 686 */     paramKryoForState.register(BuildMinerAction.class);
/* 687 */     paramKryoForState.register(BuildModifierAction.class);
/* 688 */     paramKryoForState.register(BuildTowerAction.class);
/* 689 */     paramKryoForState.register(CallWaveAction.class);
/* 690 */     paramKryoForState.register(RewardingAdAction.class);
/* 691 */     paramKryoForState.register(ChangeTowerAimStrategyAction.class);
/* 692 */     paramKryoForState.register(CustomTowerButtonAction.class);
/* 693 */     paramKryoForState.register(GlobalUpgradeMinerAction.class);
/* 694 */     paramKryoForState.register(GlobalUpgradeTowerAction.class);
/*     */     
/* 696 */     paramKryoForState.register(SelectGlobalTowerAbilityAction.class);
/* 697 */     paramKryoForState.register(SelectTowerAbilityAction.class);
/* 698 */     paramKryoForState.register(SellMinerAction.class);
/* 699 */     paramKryoForState.register(SellModifierAction.class);
/* 700 */     paramKryoForState.register(SellTowerAction.class);
/* 701 */     paramKryoForState.register(UpgradeMinerAction.class);
/* 702 */     paramKryoForState.register(UpgradeTowerAction.class);
/* 703 */     paramKryoForState.register(UseAbilityAction.class);
/*     */     
/* 705 */     paramKryoForState.register(FrameworkMessage.RegisterUDP.class, (com.esotericsoftware.kryo.Serializer)new FieldSerializer(paramKryoForState, FrameworkMessage.RegisterUDP.class));
/* 706 */     paramKryoForState.register(FrameworkMessage.DiscoverHost.class, (com.esotericsoftware.kryo.Serializer)new FieldSerializer(paramKryoForState, FrameworkMessage.DiscoverHost.class));
/* 707 */     paramKryoForState.register(FrameworkMessage.KeepAlive.class, (com.esotericsoftware.kryo.Serializer)new FieldSerializer(paramKryoForState, FrameworkMessage.KeepAlive.class));
/* 708 */     paramKryoForState.register(FrameworkMessage.Ping.class, (com.esotericsoftware.kryo.Serializer)new FieldSerializer(paramKryoForState, FrameworkMessage.Ping.class));
/* 709 */     paramKryoForState.register(FrameworkMessage.RegisterTCP.class, (com.esotericsoftware.kryo.Serializer)new FieldSerializer(paramKryoForState, FrameworkMessage.RegisterTCP.class));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {}
/*     */ 
/*     */   
/*     */   public class KryoForState
/*     */     extends Kryo
/*     */   {
/*     */     public KryoForState(NetworkManager this$0) {}
/*     */ 
/*     */     
/*     */     public Registration register(Registration param1Registration) {
/* 724 */       super.register(param1Registration);
/* 725 */       this.a.registeredClasses.add(param1Registration);
/*     */       
/* 727 */       return param1Registration;
/*     */     }
/*     */ 
/*     */     
/*     */     public Registration register(Class param1Class, com.esotericsoftware.kryo.Serializer param1Serializer) {
/* 732 */       Registration registration = super.register(param1Class, param1Serializer);
/* 733 */       this.a.registeredClasses.add(registration);
/*     */       
/* 735 */       return registration;
/*     */     }
/*     */     
/*     */     public boolean hasRegistration(Class<?> param1Class) {
/* 739 */       if (param1Class == null) {
/* 740 */         throw new IllegalArgumentException("type cannot be null.");
/*     */       }
/*     */       Registration registration;
/* 743 */       if ((registration = getClassResolver().getRegistration(param1Class)) == null) {
/* 744 */         if (Proxy.isProxyClass(param1Class)) {
/* 745 */           registration = getRegistration(InvocationHandler.class);
/* 746 */         } else if (!param1Class.isEnum() && Enum.class.isAssignableFrom(param1Class) && !Enum.class.equals(param1Class)) {
/* 747 */           registration = getRegistration(param1Class.getEnclosingClass());
/* 748 */         } else if (EnumSet.class.isAssignableFrom(param1Class)) {
/* 749 */           registration = getClassResolver().getRegistration(EnumSet.class);
/*     */         } 
/*     */       }
/*     */       
/* 753 */       return (registration != null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Registration getRegistration(Class<?> param1Class) {
/* 759 */       if (param1Class == null) {
/* 760 */         throw new IllegalArgumentException("type cannot be null.");
/*     */       }
/*     */       Registration registration;
/* 763 */       if ((registration = getClassResolver().getRegistration(param1Class)) == null) {
/* 764 */         if (Proxy.isProxyClass(param1Class)) {
/* 765 */           registration = getRegistration(InvocationHandler.class);
/* 766 */         } else if (!param1Class.isEnum() && Enum.class.isAssignableFrom(param1Class) && !Enum.class.equals(param1Class)) {
/* 767 */           registration = getRegistration(param1Class.getEnclosingClass());
/* 768 */         } else if (EnumSet.class.isAssignableFrom(param1Class)) {
/* 769 */           registration = getClassResolver().getRegistration(EnumSet.class);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 776 */         if (registration == null) {
/* 777 */           byte b; if (isRegistrationRequired()) {
/*     */             StringBuilder stringBuilder;
/* 779 */             (stringBuilder = new StringBuilder()).append("Class is not registered: ").append(Util.className(param1Class)).append("\n");
/* 780 */             stringBuilder.append("  Registry:\n");
/*     */             
/* 782 */             for (b = 0; b < this.a.registeredClasses.size; b++) {
/* 783 */               Registration registration1 = ((Registration[])this.a.registeredClasses.items)[b];
/* 784 */               stringBuilder.append("  - ").append(registration1.getId()).append(" ").append(registration1.getType().getName()).append(" ").append(registration1.getSerializer().getClass().getSimpleName()).append("\n");
/*     */             } 
/*     */             
/* 787 */             throw new IllegalArgumentException(stringBuilder.toString());
/*     */           } 
/*     */ 
/*     */           
/* 791 */           NetworkManager.a().e("not registered: " + Util.className(b), new Object[0]);
/*     */ 
/*     */ 
/*     */           
/* 795 */           registration = getClassResolver().registerImplicit(b);
/*     */         } 
/*     */       } 
/*     */       
/* 799 */       return registration;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class NetReqConnect
/*     */     implements KryoSerializable
/*     */   {
/*     */     public String userId;
/*     */     public String locale;
/*     */     public Application.ApplicationType applicationType;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 811 */       param1Kryo.writeObject(param1Output, this.userId);
/* 812 */       param1Kryo.writeObject(param1Output, this.locale);
/* 813 */       param1Kryo.writeObject(param1Output, this.applicationType);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 818 */       this.userId = (String)param1Kryo.readObject(param1Input, String.class);
/* 819 */       this.locale = (String)param1Kryo.readObject(param1Input, String.class);
/* 820 */       this.applicationType = (Application.ApplicationType)param1Kryo.readObject(param1Input, Application.ApplicationType.class);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 827 */       return "NetReqConnect (" + this.userId + ", " + this.applicationType.name() + ", " + this.locale + ")";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class NetRespConnect
/*     */     implements KryoSerializable {
/*     */     public String text;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 836 */       param1Kryo.writeObject(param1Output, this.text);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 841 */       this.text = (String)param1Kryo.readObject(param1Input, String.class);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 848 */       return "NetRespConnect (" + this.text + ")";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class NetRespBroadcast
/*     */     implements KryoSerializable {
/*     */     public String text;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 857 */       param1Kryo.writeObject(param1Output, this.text);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 862 */       this.text = (String)param1Kryo.readObject(param1Input, String.class);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 869 */       return "NetRespBroadcast (" + this.text + ")";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class NetBundle
/*     */     implements KryoSerializable
/*     */   {
/*     */     public int id;
/*     */     public String message;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 880 */       param1Output.writeVarInt(this.id, true);
/* 881 */       param1Kryo.writeObject(param1Output, this.message);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 886 */       this.id = param1Input.readVarInt(true);
/* 887 */       this.message = (String)param1Kryo.readObject(param1Input, String.class);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 894 */       return "NetBundle (" + this.id + ", " + this.message + ")";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\NetworkManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */