/*    */ package com.badlogic.gdx.backends.lwjgl3;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.utils.Clipboard;
/*    */ import org.lwjgl.glfw.GLFW;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Lwjgl3Clipboard
/*    */   implements Clipboard
/*    */ {
/*    */   public boolean hasContents() {
/*    */     String str;
/* 30 */     if ((str = getContents()) != null && !str.isEmpty()) return true;  return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getContents() {
/* 35 */     return GLFW.glfwGetClipboardString(((Lwjgl3Graphics)Gdx.graphics).getWindow().getWindowHandle());
/*    */   }
/*    */ 
/*    */   
/*    */   public void setContents(String paramString) {
/* 40 */     GLFW.glfwSetClipboardString(((Lwjgl3Graphics)Gdx.graphics).getWindow().getWindowHandle(), paramString);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3Clipboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */