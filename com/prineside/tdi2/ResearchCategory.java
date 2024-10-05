/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.a.a.b.l;
/*    */ import com.a.a.b.o;
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.prineside.tdi2.enums.GameValueType;
/*    */ import com.prineside.tdi2.enums.ResearchCategoryType;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ 
/*    */ 
/*    */ public class ResearchCategory
/*    */ {
/* 14 */   private static final TLog a = TLog.forClass(ResearchCategory.class);
/*    */   public final ResearchCategoryType alias;
/*    */   public final String titleAlias;
/*    */   public final String descriptionAlias;
/*    */   private final String b;
/*    */   private Drawable c;
/*    */   
/*    */   public ResearchCategory(ResearchCategoryType paramResearchCategoryType, String paramString1, String paramString2, String paramString3) {
/* 22 */     this.alias = paramResearchCategoryType;
/* 23 */     this.titleAlias = paramString1;
/* 24 */     this.descriptionAlias = paramString2;
/* 25 */     this.b = paramString3;
/*    */   }
/*    */   
/*    */   public String getIconString() {
/* 29 */     return this.b;
/*    */   }
/*    */   
/*    */   public static ResearchCategory fromJson(l paraml) {
/* 33 */     String str1 = null;
/* 34 */     String str2 = null;
/*    */     
/* 36 */     while (paraml.g() != o.c) {
/*    */       String str;
/* 38 */       switch (str = paraml.u()) {
/*    */         case "alias":
/* 40 */           str1 = paraml.i();
/*    */           continue;
/*    */         
/*    */         case "icon":
/* 44 */           str2 = paraml.i();
/*    */           continue;
/*    */       } 
/*    */       
/* 48 */       a.i("skip " + str, new Object[0]);
/* 49 */       paraml.g();
/* 50 */       paraml.j();
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 55 */     if (str1 != null && str2 != null) {
/* 56 */       String str3 = "research_title_" + str1;
/* 57 */       String str4 = "research_description_" + str1;
/* 58 */       ResearchCategoryType researchCategoryType = ResearchCategoryType.valueOf(str1);
/* 59 */       return new ResearchCategory(researchCategoryType, str3, str4, str2);
/*    */     } 
/* 61 */     throw new IllegalArgumentException("Alias or icon not defined by json: " + str1 + ", " + str2);
/*    */   }
/*    */ 
/*    */   
/*    */   public Drawable getIcon() {
/* 66 */     if (this.c == null && 
/* 67 */       Game.i.assetManager != null) {
/* 68 */       if (this.b.startsWith("@gv:")) {
/*    */         
/*    */         try {
/* 71 */           GameValueType gameValueType = GameValueType.valueOf(this.b.substring(4));
/* 72 */           this.c = (Drawable)Game.i.gameValueManager.getStockValueConfig(gameValueType).createIconForBackground(Color.BLACK);
/* 73 */         } catch (Exception exception) {
/* 74 */           a.e("failed to read icon GV for " + this.alias, new Object[] { exception });
/*    */         } 
/*    */       } else {
/*    */         
/* 78 */         this.c = (Drawable)Game.i.assetManager.getDrawable(this.b);
/*    */       } 
/*    */     }
/*    */ 
/*    */     
/* 83 */     return this.c;
/*    */   }
/*    */   
/*    */   public String getTitle() {
/* 87 */     return Game.i.localeManager.i18n.get(this.titleAlias);
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 91 */     return Game.i.localeManager.i18n.get(this.descriptionAlias);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\ResearchCategory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */