/*    */ package com.prineside.tdi2.desktop;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.utils.FileChooser;
/*    */ import org.lwjgl.PointerBuffer;
/*    */ import org.lwjgl.system.CustomBuffer;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.util.nfd.NativeFileDialog;
/*    */ 
/*    */ public class DesktopFileChooser
/*    */   implements FileChooser {
/*    */   public void choose(FileChooser.Configuration paramConfiguration, FileChooser.Callback paramCallback) {
/* 15 */     Preconditions.checkNotNull(paramConfiguration, "configuration can not be null");
/* 16 */     Preconditions.checkNotNull(paramCallback, "callback can not be null");
/*    */     
/* 18 */     PointerBuffer pointerBuffer = MemoryUtil.memAllocPointer(1);
/*    */     try {
/*    */       int i;
/*    */       FileHandle fileHandle;
/* 22 */       if (paramConfiguration.intent == FileChooser.FileChooseIntent.SAVE) {
/* 23 */         i = NativeFileDialog.NFD_SaveDialog(pointerBuffer, null, (paramConfiguration.directory == null) ? Gdx.files.external("/").file().getPath() : paramConfiguration.directory.file().getPath(), null);
/*    */       } else {
/*    */         
/* 26 */         i = NativeFileDialog.NFD_OpenDialog(pointerBuffer, null, (i.directory == null) ? Gdx.files.external("/").file().getPath() : i.directory.file().getPath());
/*    */       } 
/*    */ 
/*    */       
/* 30 */       switch (i) {
/*    */         case 1:
/* 32 */           fileHandle = new FileHandle(pointerBuffer.getStringUTF8(0));
/* 33 */           paramCallback.onFileChoose(fileHandle);
/* 34 */           NativeFileDialog.nNFD_FreePath(pointerBuffer.get(0));
/*    */           break;
/*    */         case 2:
/* 37 */           paramCallback.onCancel();
/*    */           break;
/*    */         case 0:
/* 40 */           paramCallback.onError(new Exception(NativeFileDialog.NFD_GetError())); break;
/*    */       } 
/*    */       return;
/* 43 */     } catch (Exception exception) {
/* 44 */       paramCallback.onError(exception); return;
/*    */     } finally {
/* 46 */       MemoryUtil.memFree((CustomBuffer)pointerBuffer);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean intentSupported(FileChooser.FileChooseIntent paramFileChooseIntent) {
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\desktop\DesktopFileChooser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */