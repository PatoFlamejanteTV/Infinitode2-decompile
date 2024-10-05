/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Input;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public class HotKeyHintLabel
/*     */   extends Group
/*     */ {
/*  23 */   private static final TLog k = TLog.forClass(HotKeyHintLabel.class);
/*     */   
/*  25 */   private int[] l = new int[0];
/*  26 */   private final Array<int[]> m = new Array(true, 8, int[].class);
/*     */   
/*  28 */   private static final StringBuilder n = new StringBuilder();
/*  29 */   private static final StringBuilder o = new StringBuilder();
/*  30 */   private static final Vector2 p = new Vector2();
/*     */   
/*     */   private Label q;
/*     */   
/*     */   private Label r;
/*     */   public boolean debug = false;
/*  36 */   private int s = -1;
/*     */ 
/*     */ 
/*     */   
/*     */   private HotKeyHintLabel(float paramFloat1, float paramFloat2) {
/*  41 */     this.q = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  42 */     this.q.setAlignment(1);
/*  43 */     this.q.setSize(1.0F, 1.0F);
/*  44 */     this.q.setColor(0.0F, 0.0F, 0.0F, 0.0F);
/*  45 */     this.q.setPosition(1.5F, -1.5F);
/*  46 */     addActor((Actor)this.q);
/*     */     
/*  48 */     this.r = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  49 */     this.r.setAlignment(1);
/*  50 */     this.r.setSize(1.0F, 1.0F);
/*  51 */     this.r.setColor(1.0F, 1.0F, 1.0F, 0.0F);
/*  52 */     addActor((Actor)this.r);
/*     */     
/*  54 */     setTransform(false);
/*  55 */     setSize(1.0F, 1.0F);
/*  56 */     setPosition(paramFloat1, paramFloat2 + 8.0F);
/*     */   }
/*     */   
/*     */   public HotKeyHintLabel(int[] paramArrayOfint, float paramFloat1, float paramFloat2) {
/*  60 */     this(paramFloat1, paramFloat2);
/*     */     
/*  62 */     this.l = paramArrayOfint;
/*  63 */     d();
/*     */   }
/*     */   
/*     */   public HotKeyHintLabel(int[] paramArrayOfint, float paramFloat1, float paramFloat2, int paramInt) {
/*  67 */     this(paramFloat1, paramFloat2);
/*     */     
/*  69 */     this.q.setAlignment(paramInt);
/*  70 */     this.r.setAlignment(paramInt);
/*     */     
/*  72 */     this.l = paramArrayOfint;
/*  73 */     d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*  78 */     super.draw(paramBatch, paramFloat);
/*     */     
/*  80 */     d();
/*     */ 
/*     */     
/*  83 */     float f1 = Game.i.uiManager.getScreenHeight();
/*  84 */     p.set(Vector2.Zero);
/*  85 */     localToStageCoordinates(p);
/*     */     
/*  87 */     paramFloat = Game.i.settingsManager.getScaledViewportHeight() / f1;
/*  88 */     float f2 = Gdx.input.getX() * paramFloat;
/*  89 */     f1 = (f1 - Gdx.input.getY()) * paramFloat;
/*     */     
/*  91 */     paramFloat = PMath.getDistanceBetweenPoints(p.x, p.y, f2, f1);
/*     */     
/*  93 */     float f3 = MathUtils.clamp(1.0F - paramFloat / 480.0F, 0.0F, 1.0F);
/*  94 */     this.q.setColor(0.0F, 0.0F, 0.0F, 0.09F + 0.35F * f3);
/*  95 */     this.r.setColor(1.0F, 1.0F, 1.0F, 0.16F + 0.65F * f3);
/*     */     
/*  97 */     if (this.debug) {
/*  98 */       k.i((int)paramFloat + " / " + (int)p.x + ":" + (int)p.y + " / " + (int)f2 + ":" + (int)f1, new Object[0]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addVariant(int[] paramArrayOfint) {
/* 108 */     this.m.add(paramArrayOfint);
/* 109 */     this.s = -1;
/* 110 */     d();
/*     */   }
/*     */ 
/*     */   
/*     */   private void d() {
/* 115 */     int i = 1;
/* 116 */     if (this.m.size != 0) {
/*     */       
/* 118 */       IntArray intArray = Game.i.settingsManager.getHoldingHotKeys();
/* 119 */       int[] arrayOfInt = null;
/* 120 */       for (Array.ArrayIterator<int[]> arrayIterator = this.m.iterator(); arrayIterator.hasNext();) {
/* 121 */         for (j = (arrayOfInt2 = arrayOfInt1 = arrayIterator.next()).length, b = 0; b < j; ) { int k = arrayOfInt2[b];
/* 122 */           if (intArray.contains(k)) {
/*     */             
/* 124 */             arrayOfInt = arrayOfInt1; break;
/*     */           } 
/*     */           b++; }
/*     */       
/*     */       } 
/* 129 */       if (arrayOfInt != null) {
/*     */         int[] arrayOfInt1; int j; byte b;
/* 131 */         for (j = (arrayOfInt1 = arrayOfInt).length, b = 0; b < j; ) { int k = arrayOfInt1[b];
/* 132 */           i = i * 31 + k;
/*     */           b++; }
/*     */       
/*     */       } else {
/* 136 */         i = 9032;
/*     */       } 
/*     */     } 
/*     */     
/* 140 */     if (this.s != i) {
/*     */       
/* 142 */       this.s = i;
/*     */       
/* 144 */       if (this.m.size != 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 150 */         IntArray intArray = Game.i.settingsManager.getHoldingHotKeys();
/*     */         
/* 152 */         int[] arrayOfInt = null;
/* 153 */         for (Array.ArrayIterator<int[]> arrayIterator1 = this.m.iterator(); arrayIterator1.hasNext();) {
/* 154 */           for (j = (arrayOfInt2 = arrayOfInt1 = arrayIterator1.next()).length, b = 0; b < j; ) { int k = arrayOfInt2[b];
/* 155 */             if (intArray.contains(k)) {
/*     */               
/* 157 */               arrayOfInt = arrayOfInt1; break;
/*     */             } 
/*     */             b++; }
/*     */         
/*     */         } 
/* 162 */         if (arrayOfInt != null) {
/*     */           
/* 164 */           this.r.setText(generateHotKeysLabelText(arrayOfInt));
/* 165 */           this.q.setText((CharSequence)this.r.getText());
/*     */           return;
/*     */         } 
/* 168 */         boolean bool = false; Array.ArrayIterator<int[]> arrayIterator2;
/* 169 */         for (arrayIterator2 = this.m.iterator(); arrayIterator2.hasNext();) {
/* 170 */           if ((arrayOfInt1 = arrayIterator2.next()).length == 1) {
/* 171 */             bool = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 176 */         if (bool) {
/* 177 */           o.setLength(0);
/* 178 */           o.append(generateHotKeysLabelText(this.l));
/*     */           
/* 180 */           for (arrayIterator2 = this.m.iterator(); arrayIterator2.hasNext();) {
/* 181 */             if ((arrayOfInt1 = arrayIterator2.next()).length == 1) {
/* 182 */               o.append("[#888888] / []");
/* 183 */               o.append(generateHotKeysLabelText(arrayOfInt1));
/*     */             } 
/*     */           } 
/* 186 */           this.r.setText((CharSequence)o);
/* 187 */           this.q.setText((CharSequence)this.r.getText()); return;
/*     */         } 
/* 189 */       }  this.r.setText(generateHotKeysLabelText(this.l));
/* 190 */       this.q.setText((CharSequence)this.r.getText());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isAvailable() {
/* 198 */     return (Gdx.app.getType() == Application.ApplicationType.Desktop);
/*     */   }
/*     */   
/*     */   public static boolean isEnabled() {
/* 202 */     return (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.UI_HOT_KEY_HINTS) != 0.0D && isAvailable());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CharSequence generateHotKeysLabelText(int[] paramArrayOfint) {
/* 209 */     n.setLength(0); int i;
/*     */     byte b;
/* 211 */     for (i = (paramArrayOfint = paramArrayOfint).length, b = 0; b < i; ) { int j = paramArrayOfint[b];
/* 212 */       if (n.length != 0) {
/* 213 */         n.append("[#AAAAAA] + []");
/*     */       }
/* 215 */       if (j == 71) {
/* 216 */         n.append("[[");
/* 217 */       } else if (j == 129) {
/* 218 */         n.append("Ctrl");
/* 219 */       } else if (j == 59) {
/* 220 */         n.append("Shift");
/* 221 */       } else if (j == 57) {
/* 222 */         n.append("Alt");
/* 223 */       } else if (j == 144) {
/* 224 */         n.append("Nm 0");
/* 225 */       } else if (j == 145) {
/* 226 */         n.append("Nm 1");
/* 227 */       } else if (j == 146) {
/* 228 */         n.append("Nm 2");
/* 229 */       } else if (j == 147) {
/* 230 */         n.append("Nm 3");
/* 231 */       } else if (j == 148) {
/* 232 */         n.append("Nm 4");
/* 233 */       } else if (j == 149) {
/* 234 */         n.append("Nm 5");
/* 235 */       } else if (j == 150) {
/* 236 */         n.append("Nm 6");
/* 237 */       } else if (j == 151) {
/* 238 */         n.append("Nm 7");
/* 239 */       } else if (j == 152) {
/* 240 */         n.append("Nm 8");
/* 241 */       } else if (j == 153) {
/* 242 */         n.append("Nm 9");
/*     */       } else {
/* 244 */         n.append(Input.Keys.toString(j).toUpperCase(Locale.US));
/*     */       } 
/*     */       b++; }
/*     */     
/* 248 */     return (CharSequence)n;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\HotKeyHintLabel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */