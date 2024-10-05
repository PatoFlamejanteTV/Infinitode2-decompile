/*    */ package com.prineside.tdi2.systems;
/*    */ 
/*    */ import com.prineside.tdi2.GameSystem;
/*    */ import com.prineside.tdi2.ui.components.DraggingItemHelper;
/*    */ import com.prineside.tdi2.ui.components.MapEditorInventoryMenu;
/*    */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*    */ import com.prineside.tdi2.ui.components.MapEditorUi;
/*    */ import com.prineside.tdi2.ui.components.MapShiftButtons;
/*    */ import com.prineside.tdi2.utils.NAGS;
/*    */ 
/*    */ @NAGS
/*    */ public final class MapEditorUiSystem
/*    */   extends GameSystem {
/*    */   public MapEditorUi mainUi;
/*    */   public MapShiftButtons mapShiftButtons;
/*    */   public DraggingItemHelper draggingItemHelper;
/*    */   public MapEditorInventoryMenu inventoryMenu;
/*    */   public MapEditorItemInfoMenu itemInfoMenu;
/*    */   
/*    */   public final void setup() {
/* 21 */     this.mapShiftButtons = new MapShiftButtons(this.S);
/* 22 */     if (this.S._mapEditor.basicLevelEditor) {
/* 23 */       this.mapShiftButtons.setMapSizeChangesAllowed(true);
/*    */     }
/*    */     
/* 26 */     this.mapShiftButtons.addListener(new MapShiftButtons.MapShiftButtonsListener(this)
/*    */         {
/*    */           public void shifted(MapShiftButtons.Direction param1Direction) {
/* 29 */             MapEditorSystem.HistoryImprint historyImprint = this.a.S._mapEditor.startActionRecord();
/* 30 */             this.a.S._mapEditor.shiftMap(param1Direction);
/* 31 */             this.a.S._mapEditor.finishActionRecord(historyImprint);
/*    */           }
/*    */ 
/*    */           
/*    */           public void expanded(MapShiftButtons.Direction param1Direction) {
/* 36 */             MapEditorSystem.HistoryImprint historyImprint = this.a.S._mapEditor.startActionRecord();
/* 37 */             this.a.S._mapEditor.expandMap(param1Direction);
/* 38 */             this.a.S._mapEditor.finishActionRecord(historyImprint);
/*    */           }
/*    */ 
/*    */           
/*    */           public void reduced(MapShiftButtons.Direction param1Direction) {
/* 43 */             MapEditorSystem.HistoryImprint historyImprint = this.a.S._mapEditor.startActionRecord();
/* 44 */             this.a.S._mapEditor.reduceMap(param1Direction);
/* 45 */             this.a.S._mapEditor.finishActionRecord(historyImprint);
/*    */           }
/*    */         });
/*    */     
/* 49 */     this.mainUi = new MapEditorUi(this.S);
/* 50 */     this.draggingItemHelper = new DraggingItemHelper(this.S);
/* 51 */     this.itemInfoMenu = new MapEditorItemInfoMenu(this.S);
/* 52 */     this.inventoryMenu = new MapEditorInventoryMenu(this.S);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void dispose() {
/* 57 */     this.draggingItemHelper.dispose();
/* 58 */     this.mainUi.dispose();
/* 59 */     this.mapShiftButtons.dispose();
/* 60 */     this.itemInfoMenu.dispose();
/* 61 */     this.inventoryMenu.dispose();
/*    */     
/* 63 */     this.mainUi = null;
/* 64 */     this.mapShiftButtons = null;
/* 65 */     this.draggingItemHelper = null;
/* 66 */     this.inventoryMenu = null;
/* 67 */     this.itemInfoMenu = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean affectsGameState() {
/* 72 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String getSystemName() {
/* 77 */     return "MapEditorUi";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\MapEditorUiSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */