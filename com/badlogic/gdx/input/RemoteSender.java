/*     */ package com.badlogic.gdx.input;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Input;
/*     */ import com.badlogic.gdx.InputProcessor;
/*     */ import java.io.DataOutputStream;
/*     */ import java.net.Socket;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RemoteSender
/*     */   implements InputProcessor
/*     */ {
/*     */   private DataOutputStream out;
/*     */   private boolean connected = false;
/*     */   public static final int KEY_DOWN = 0;
/*     */   public static final int KEY_UP = 1;
/*     */   public static final int KEY_TYPED = 2;
/*     */   public static final int TOUCH_DOWN = 3;
/*     */   public static final int TOUCH_UP = 4;
/*     */   public static final int TOUCH_DRAGGED = 5;
/*     */   public static final int ACCEL = 6;
/*     */   public static final int COMPASS = 7;
/*     */   public static final int SIZE = 8;
/*     */   public static final int GYRO = 9;
/*     */   
/*     */   public RemoteSender(String paramString, int paramInt) {
/*     */     try {
/*     */       Socket socket;
/*  50 */       (socket = new Socket(paramString, paramInt)).setTcpNoDelay(true);
/*  51 */       socket.setSoTimeout(3000);
/*  52 */       this.out = new DataOutputStream(socket.getOutputStream());
/*  53 */       this.out.writeBoolean(Gdx.input.isPeripheralAvailable(Input.Peripheral.MultitouchScreen));
/*  54 */       this.connected = true;
/*  55 */       Gdx.input.setInputProcessor(this); return;
/*  56 */     } catch (Exception exception) {
/*  57 */       Gdx.app.log("RemoteSender", "couldn't connect to " + paramString + ":" + paramInt);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   public void sendUpdate() {
/*  62 */     synchronized (this) {
/*  63 */       if (!this.connected)
/*     */         return; 
/*     */     }  try {
/*  66 */       this.out.writeInt(6);
/*  67 */       this.out.writeFloat(Gdx.input.getAccelerometerX());
/*  68 */       this.out.writeFloat(Gdx.input.getAccelerometerY());
/*  69 */       this.out.writeFloat(Gdx.input.getAccelerometerZ());
/*  70 */       this.out.writeInt(7);
/*  71 */       this.out.writeFloat(Gdx.input.getAzimuth());
/*  72 */       this.out.writeFloat(Gdx.input.getPitch());
/*  73 */       this.out.writeFloat(Gdx.input.getRoll());
/*  74 */       this.out.writeInt(8);
/*  75 */       this.out.writeFloat(Gdx.graphics.getWidth());
/*  76 */       this.out.writeFloat(Gdx.graphics.getHeight());
/*  77 */       this.out.writeInt(9);
/*  78 */       this.out.writeFloat(Gdx.input.getGyroscopeX());
/*  79 */       this.out.writeFloat(Gdx.input.getGyroscopeY());
/*  80 */       this.out.writeFloat(Gdx.input.getGyroscopeZ()); return;
/*  81 */     } catch (Throwable throwable) {
/*  82 */       this.out = null;
/*  83 */       this.connected = false;
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean keyDown(int paramInt) {
/*  89 */     synchronized (this) {
/*  90 */       if (!this.connected) return false;
/*     */     
/*     */     } 
/*     */     try {
/*  94 */       this.out.writeInt(0);
/*  95 */       this.out.writeInt(paramInt);
/*  96 */     } catch (Throwable throwable) {
/*  97 */       synchronized (this) {
/*  98 */         this.connected = false;
/*     */       } 
/*     */     } 
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean keyUp(int paramInt) {
/* 106 */     synchronized (this) {
/* 107 */       if (!this.connected) return false;
/*     */     
/*     */     } 
/*     */     try {
/* 111 */       this.out.writeInt(1);
/* 112 */       this.out.writeInt(paramInt);
/* 113 */     } catch (Throwable throwable) {
/* 114 */       synchronized (this) {
/* 115 */         this.connected = false;
/*     */       } 
/*     */     } 
/* 118 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean keyTyped(char paramChar) {
/* 123 */     synchronized (this) {
/* 124 */       if (!this.connected) return false;
/*     */     
/*     */     } 
/*     */     try {
/* 128 */       this.out.writeInt(2);
/* 129 */       this.out.writeChar(paramChar);
/* 130 */     } catch (Throwable throwable) {
/* 131 */       synchronized (this) {
/* 132 */         this.connected = false;
/*     */       } 
/*     */     } 
/* 135 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean touchDown(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 140 */     synchronized (this) {
/* 141 */       if (!this.connected) return false;
/*     */     
/*     */     } 
/*     */     try {
/* 145 */       this.out.writeInt(3);
/* 146 */       this.out.writeInt(paramInt1);
/* 147 */       this.out.writeInt(paramInt2);
/* 148 */       this.out.writeInt(paramInt3);
/* 149 */     } catch (Throwable throwable) {
/* 150 */       synchronized (this) {
/* 151 */         this.connected = false;
/*     */       } 
/*     */     } 
/* 154 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean touchUp(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 159 */     synchronized (this) {
/* 160 */       if (!this.connected) return false;
/*     */     
/*     */     } 
/*     */     try {
/* 164 */       this.out.writeInt(4);
/* 165 */       this.out.writeInt(paramInt1);
/* 166 */       this.out.writeInt(paramInt2);
/* 167 */       this.out.writeInt(paramInt3);
/* 168 */     } catch (Throwable throwable) {
/* 169 */       synchronized (this) {
/* 170 */         this.connected = false;
/*     */       } 
/*     */     } 
/* 173 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean touchCancelled(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 178 */     return touchUp(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean touchDragged(int paramInt1, int paramInt2, int paramInt3) {
/* 183 */     synchronized (this) {
/* 184 */       if (!this.connected) return false;
/*     */     
/*     */     } 
/*     */     try {
/* 188 */       this.out.writeInt(5);
/* 189 */       this.out.writeInt(paramInt1);
/* 190 */       this.out.writeInt(paramInt2);
/* 191 */       this.out.writeInt(paramInt3);
/* 192 */     } catch (Throwable throwable) {
/* 193 */       synchronized (this) {
/* 194 */         this.connected = false;
/*     */       } 
/*     */     } 
/* 197 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mouseMoved(int paramInt1, int paramInt2) {
/* 202 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean scrolled(float paramFloat1, float paramFloat2) {
/* 207 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isConnected() {
/* 211 */     synchronized (this) {
/* 212 */       return this.connected;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\input\RemoteSender.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */