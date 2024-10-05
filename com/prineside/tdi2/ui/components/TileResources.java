/*     */ package com.prineside.tdi2.ui.components;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Resource;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.tiles.SourceTile;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ public class TileResources extends Group {
/*     */   private SourceTile k;
/*     */   private float l;
/*     */   private boolean m;
/*     */   
/*     */   public TileResources(float paramFloat) {
/*  24 */     this.l = paramFloat;
/*  25 */     this.m = (paramFloat < 350.0F);
/*     */     
/*  27 */     setTransform(false);
/*  28 */     setSize(paramFloat, 80.0F);
/*  29 */     setTouchable(Touchable.disabled);
/*     */   }
/*     */   
/*     */   public SourceTile getTile() {
/*  33 */     return this.k;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTile(SourceTile paramSourceTile) {
/*     */     String str;
/*  39 */     Label.LabelStyle labelStyle = this.m ? Game.i.assetManager.getLabelStyle(21) : Game.i.assetManager.getLabelStyle(24);
/*  40 */     float f1 = this.m ? 24.0F : 32.0F;
/*     */     
/*  42 */     this.k = paramSourceTile;
/*     */     
/*  44 */     clearChildren();
/*     */     
/*     */     Table table;
/*  47 */     (table = new Table()).setPosition(0.0F, 48.0F);
/*  48 */     table.setSize(this.l, f1);
/*  49 */     addActor((Actor)table);
/*     */     
/*  51 */     int i = 0; ResourceType[] arrayOfResourceType1; int j; byte b1;
/*  52 */     for (j = (arrayOfResourceType1 = ResourceType.values).length, b1 = 0; b1 < j; ) { ResourceType resourceType = arrayOfResourceType1[b1];
/*     */       int m;
/*  54 */       if ((m = paramSourceTile.getResourcesCount(resourceType)) > 0) {
/*  55 */         if (i) {
/*  56 */           table.add().height(f1).width(this.m ? 8.0F : 16.0F);
/*     */         }
/*     */         
/*  59 */         i += m;
/*     */         
/*     */         Image image;
/*  62 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable(Resource.TEXTURE_REGION_NAMES[resourceType.ordinal()]))).setColor(Game.i.resourceManager.getColor(resourceType));
/*  63 */         table.add((Actor)image).size(f1).padRight(4.0F);
/*     */         
/*     */         Label label1;
/*  66 */         (label1 = new Label((CharSequence)StringFormatter.compactNumber(m, false), labelStyle)).setColor(Game.i.resourceManager.getColor(resourceType));
/*  67 */         table.add((Actor)label1).height(f1);
/*     */       } 
/*     */       b1++; }
/*     */     
/*  71 */     TextureRegionDrawable textureRegionDrawable = Game.i.assetManager.getDrawable("blank");
/*  72 */     if (i == 0) {
/*     */       Image image;
/*     */       
/*  75 */       (image = new Image((Drawable)textureRegionDrawable)).setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  76 */       image.setSize(this.l, 8.0F);
/*  77 */       image.setPosition(0.0F, 29.0F);
/*  78 */       addActor((Actor)image);
/*     */       
/*     */       Label label1;
/*  81 */       (label1 = new Label(Game.i.localeManager.i18n.get("no_resources"), labelStyle)).setAlignment(1);
/*  82 */       label1.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  83 */       table.add((Actor)label1).size(this.l, 32.0F);
/*     */       return;
/*     */     } 
/*  86 */     float f2 = 0.0F;
/*  87 */     float f3 = (paramSourceTile.getResourceDensity() > 1.0F) ? (1.0F / paramSourceTile.getResourceDensity()) : 1.0F; ResourceType[] arrayOfResourceType2; int k; byte b2;
/*  88 */     for (k = (arrayOfResourceType2 = ResourceType.values).length, b2 = 0; b2 < k; ) { ResourceType resourceType = arrayOfResourceType2[b2];
/*     */       float f;
/*  90 */       if ((f = paramSourceTile.getResourcesCount(resourceType) * paramSourceTile.getResourceDensity() / i * f3) > 0.0F) {
/*     */         Image image;
/*  92 */         (image = new Image((Drawable)textureRegionDrawable)).setColor(Game.i.resourceManager.getColor(resourceType));
/*  93 */         image.setSize(this.l * f, 8.0F);
/*  94 */         image.setPosition(this.l * f2, 29.0F);
/*  95 */         addActor((Actor)image);
/*     */         
/*  97 */         f2 += f;
/*     */       } 
/*     */       b2++; }
/*     */     
/* 101 */     if (paramSourceTile.getResourceDensity() > 1.0F)
/*     */     {
/* 103 */       for (byte b = 0; b < 10; ) {
/* 104 */         float f6 = this.m ? 8.0F : 14.0F;
/* 105 */         float f7 = this.m ? 2.0F : 4.0F;
/* 106 */         float f8 = (this.m ? false : 40) + b * (f7 + f6);
/* 107 */         float f5 = this.m ? (29.0F - f6 - f7) : 5.0F;
/*     */         
/* 109 */         if (paramSourceTile.getResourceDensity() > b) {
/* 110 */           if (paramSourceTile.getResourceDensity() - b > 1.0F) {
/*     */             Image image;
/*     */             
/* 113 */             (image = new Image((Drawable)textureRegionDrawable)).setSize(f6, f6);
/* 114 */             image.setPosition(f8, f5);
/* 115 */             addActor((Actor)image);
/*     */           } else {
/*     */             Image image;
/*     */             
/* 119 */             (image = new Image((Drawable)textureRegionDrawable)).setSize(f6, f6);
/* 120 */             image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 121 */             image.setPosition(f8, f5);
/* 122 */             addActor((Actor)image);
/*     */ 
/*     */             
/* 125 */             (image = new Image((Drawable)textureRegionDrawable)).setSize(f6 * (paramSourceTile.getResourceDensity() - b), f6);
/* 126 */             image.setPosition(f8, f5);
/* 127 */             addActor((Actor)image);
/*     */           } 
/*     */ 
/*     */           
/*     */           b++;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 136 */     if (f2 < 1.0F) {
/*     */       Image image1;
/*     */       
/* 139 */       (image1 = new Image((Drawable)textureRegionDrawable)).setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 140 */       image1.setSize(this.l * (1.0F - f2), 8.0F);
/* 141 */       image1.setPosition(this.l * f2, 29.0F);
/* 142 */       addActor((Actor)image1);
/*     */       
/*     */       Image image2;
/* 145 */       (image2 = new Image((Drawable)textureRegionDrawable)).setColor(new Color(-1970631937));
/* 146 */       image2.setSize(2.0F, 35.0F);
/* 147 */       image2.setPosition(this.l * f2, 6.0F);
/* 148 */       addActor((Actor)image2);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 153 */     if (this.l < 360.0F) {
/* 154 */       str = (int)(paramSourceTile.getResourceDensity() * 100.0F) + "%";
/*     */     } else {
/* 156 */       str = Game.i.localeManager.i18n.get("resource_density") + ": " + (int)(paramSourceTile.getResourceDensity() * 100.0F) + "%";
/*     */     } 
/*     */     Label label;
/* 159 */     (label = new Label(str, new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(21), Color.WHITE))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 160 */     label.setSize(0.0F, 24.0F);
/* 161 */     addActor((Actor)label);
/*     */     
/* 163 */     if (paramSourceTile.getResourceDensity() > 0.5F) {
/*     */       
/* 165 */       label.setAlignment(16);
/*     */       
/*     */       float f;
/* 168 */       if ((f = this.l * paramSourceTile.getResourceDensity() - 10.0F) > this.l - 40.0F) f = this.l - 40.0F; 
/* 169 */       label.setPosition(f, 0.0F);
/*     */       return;
/*     */     } 
/* 172 */     label.setAlignment(8);
/*     */     
/*     */     float f4;
/* 175 */     if ((f4 = this.l * paramSourceTile.getResourceDensity() + 10.0F) < 40.0F) f4 = 40.0F; 
/* 176 */     label.setPosition(f4, 0.0F);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\TileResources.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */