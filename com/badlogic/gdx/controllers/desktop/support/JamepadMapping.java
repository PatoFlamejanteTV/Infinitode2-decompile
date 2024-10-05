/*    */ package com.badlogic.gdx.controllers.desktop.support;
/*    */ 
/*    */ import com.badlogic.gdx.controllers.ControllerMapping;
/*    */ import com.studiohartman.jamepad.b;
/*    */ import com.studiohartman.jamepad.c;
/*    */ 
/*    */ public class JamepadMapping extends ControllerMapping {
/*    */   private static JamepadMapping instance;
/*    */   
/*    */   JamepadMapping() {
/* 11 */     super(b.a.ordinal(), b.b.ordinal(), b.c
/* 12 */         .ordinal(), b.d.ordinal(), c.a
/* 13 */         .ordinal(), c.b.ordinal(), c.c
/* 14 */         .ordinal(), c.d.ordinal(), c.e
/* 15 */         .ordinal(), c.f.ordinal(), c.i
/* 16 */         .ordinal(), -1, c.j
/* 17 */         .ordinal(), -1, c.g
/* 18 */         .ordinal(), c.h.ordinal(), c.k
/* 19 */         .ordinal(), c.l.ordinal(), c.m
/* 20 */         .ordinal(), c.n.ordinal());
/*    */   }
/*    */   
/*    */   static JamepadMapping getInstance() {
/* 24 */     if (instance == null) {
/* 25 */       instance = new JamepadMapping();
/*    */     }
/* 27 */     return instance;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\controllers\desktop\support\JamepadMapping.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */