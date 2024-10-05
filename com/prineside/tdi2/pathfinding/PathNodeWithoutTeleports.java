/*    */ package com.prineside.tdi2.pathfinding;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(serializer = PathNodeWithoutTeleports.Serializer.class)
/*    */ public final class PathNodeWithoutTeleports
/*    */   implements PathNode {
/*    */   private final short a;
/*    */   private final short b;
/*    */   
/*    */   public static final class Serializer extends com.esotericsoftware.kryo.Serializer<PathNodeWithoutTeleports> {
/*    */     public final void write(Kryo param1Kryo, Output param1Output, PathNodeWithoutTeleports param1PathNodeWithoutTeleports) {
/* 17 */       param1Output.writeShort(PathNodeWithoutTeleports.a(param1PathNodeWithoutTeleports));
/* 18 */       param1Output.writeShort(PathNodeWithoutTeleports.b(param1PathNodeWithoutTeleports));
/*    */     }
/*    */ 
/*    */     
/*    */     public final PathNodeWithoutTeleports read(Kryo param1Kryo, Input param1Input, Class<? extends PathNodeWithoutTeleports> param1Class) {
/* 23 */       short s1 = param1Input.readShort();
/* 24 */       short s2 = param1Input.readShort();
/* 25 */       return new PathNodeWithoutTeleports(s1, s2);
/*    */     }
/*    */   }
/*    */   
/*    */   public PathNodeWithoutTeleports(short paramShort1, short paramShort2) {
/* 30 */     this.a = paramShort1;
/* 31 */     this.b = paramShort2;
/*    */   }
/*    */ 
/*    */   
/*    */   public final short getX() {
/* 36 */     return this.a;
/*    */   }
/*    */ 
/*    */   
/*    */   public final short getY() {
/* 41 */     return this.b;
/*    */   }
/*    */   
/*    */   @Null
/*    */   public final int[] getTeleports() {
/* 46 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/* 51 */     return this.a * 15331 + this.b;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 56 */     if (!(paramObject instanceof PathNodeWithoutTeleports)) {
/* 57 */       return false;
/*    */     }
/*    */     
/* 60 */     if (((PathNodeWithoutTeleports)(paramObject = paramObject)).a == this.a && ((PathNodeWithoutTeleports)paramObject).b == this.b) return true;  return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\pathfinding\PathNodeWithoutTeleports.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */