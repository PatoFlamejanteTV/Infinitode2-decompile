/*    */ package com.prineside.tdi2.managers;
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.utils.ObjectMap;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.enums.ResourceType;
/*    */ import com.prineside.tdi2.enums.StatisticsType;
/*    */ import com.prineside.tdi2.utils.MaterialColor;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(serializer = ResourceManager.Serializer.class)
/*    */ public class ResourceManager extends Manager.ManagerAdapter {
/*    */   private static final Color[] a;
/*    */   private static final Color[] b;
/*    */   
/*    */   public static class Serializer extends SingletonSerializer<ResourceManager> {
/*    */     public ResourceManager read() {
/* 17 */       return Game.i.resourceManager;
/*    */     }
/*    */   }
/*    */   
/*    */   static {
/* 22 */     (a = new Color[ResourceType.values.length])[ResourceType.SCALAR.ordinal()] = MaterialColor.GREEN.P500;
/* 23 */     a[ResourceType.VECTOR.ordinal()] = MaterialColor.INDIGO.P400;
/* 24 */     a[ResourceType.MATRIX.ordinal()] = MaterialColor.PURPLE.P400;
/* 25 */     a[ResourceType.TENSOR.ordinal()] = MaterialColor.ORANGE.P500;
/* 26 */     a[ResourceType.INFIAR.ordinal()] = MaterialColor.CYAN.P500;
/*    */ 
/*    */ 
/*    */     
/* 30 */     (b = new Color[ResourceType.values.length])[ResourceType.SCALAR.ordinal()] = MaterialColor.GREEN.P500;
/* 31 */     b[ResourceType.VECTOR.ordinal()] = MaterialColor.INDIGO.P400;
/* 32 */     b[ResourceType.MATRIX.ordinal()] = MaterialColor.PINK.P400.cpy().lerp(0.2F, 0.3F, 0.3F, 1.0F, 0.25F);
/* 33 */     b[ResourceType.TENSOR.ordinal()] = MaterialColor.ORANGE.P500;
/* 34 */     b[ResourceType.INFIAR.ordinal()] = MaterialColor.CYAN.P500;
/*    */   }
/* 36 */   private final StatisticsType[] c = new StatisticsType[ResourceType.values.length];
/* 37 */   private final String[] d = new String[ResourceType.values.length];
/*    */   
/* 39 */   public final ObjectMap<ResourceType, String> SHORT_RESOURCE_ALIASES = new ObjectMap();
/*    */   public ResourceManager() {
/* 41 */     this.SHORT_RESOURCE_ALIASES.put(ResourceType.SCALAR, "S");
/* 42 */     this.SHORT_RESOURCE_ALIASES.put(ResourceType.VECTOR, "V");
/* 43 */     this.SHORT_RESOURCE_ALIASES.put(ResourceType.MATRIX, "M");
/* 44 */     this.SHORT_RESOURCE_ALIASES.put(ResourceType.TENSOR, "T");
/* 45 */     this.SHORT_RESOURCE_ALIASES.put(ResourceType.INFIAR, "I");
/*    */     
/*    */     ResourceType[] arrayOfResourceType;
/*    */     
/*    */     int i;
/*    */     byte b;
/* 51 */     for (i = (arrayOfResourceType = ResourceType.values).length, b = 0; b < i; ) { ResourceType resourceType = arrayOfResourceType[b];
/* 52 */       this.c[resourceType.ordinal()] = StatisticsType.valueOf("RG_" + (String)this.SHORT_RESOURCE_ALIASES.get(resourceType));
/* 53 */       this.d[resourceType.ordinal()] = "resource_name_" + resourceType.name();
/*    */       b++; }
/*    */   
/*    */   }
/*    */   public Color getColor(ResourceType paramResourceType) {
/* 58 */     if (Game.i.settingsManager.cvdFriendlyColors()) {
/* 59 */       return b[paramResourceType.ordinal()];
/*    */     }
/* 61 */     return a[paramResourceType.ordinal()];
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName(ResourceType paramResourceType) {
/* 66 */     int i = paramResourceType.ordinal();
/* 67 */     return Game.i.localeManager.i18n.get(this.d[i]);
/*    */   }
/*    */   
/*    */   public StatisticsType getGainedCountStatistic(ResourceType paramResourceType) {
/* 71 */     return this.c[paramResourceType.ordinal()];
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\ResourceManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */