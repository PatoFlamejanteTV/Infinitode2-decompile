/*    */ package com.prineside.tdi2.pathfinding;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(serializer = PathNodeWithTeleports.Serializer.class)
/*    */ public final class PathNodeWithTeleports implements PathNode {
/*    */   private final short a;
/*    */   private final short b;
/* 13 */   private final int[] c = new int[4];
/*    */   
/*    */   public static final class Serializer
/*    */     extends com.esotericsoftware.kryo.Serializer<PathNodeWithTeleports> {
/*    */     public final void write(Kryo param1Kryo, Output param1Output, PathNodeWithTeleports param1PathNodeWithTeleports) {
/* 18 */       param1Output.writeShort(PathNodeWithTeleports.a(param1PathNodeWithTeleports));
/* 19 */       param1Output.writeShort(PathNodeWithTeleports.b(param1PathNodeWithTeleports));
/* 20 */       param1Kryo.writeObject(param1Output, PathNodeWithTeleports.c(param1PathNodeWithTeleports));
/*    */     }
/*    */ 
/*    */     
/*    */     public final PathNodeWithTeleports read(Kryo param1Kryo, Input param1Input, Class<? extends PathNodeWithTeleports> param1Class) {
/* 25 */       short s1 = param1Input.readShort();
/* 26 */       short s2 = param1Input.readShort();
/* 27 */       int[] arrayOfInt = (int[])param1Kryo.readObject(param1Input, int[].class);
/* 28 */       return new PathNodeWithTeleports(s1, s2, arrayOfInt);
/*    */     }
/*    */   }
/*    */   
/*    */   public PathNodeWithTeleports(short paramShort1, short paramShort2, int[] paramArrayOfint) {
/* 33 */     this.a = paramShort1;
/* 34 */     this.b = paramShort2;
/*    */     
/* 36 */     for (paramShort1 = 0; paramShort1 < 4; paramShort1++) {
/* 37 */       this.c[paramShort1] = paramArrayOfint[paramShort1];
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public final short getX() {
/* 43 */     return this.a;
/*    */   }
/*    */ 
/*    */   
/*    */   public final short getY() {
/* 48 */     return this.b;
/*    */   }
/*    */   
/*    */   @Null
/*    */   public final int[] getTeleports() {
/* 53 */     return this.c;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/*    */     int i;
/* 65 */     return i = (i = (i = (i = (i = (i = 31 + this.a) * 31 + this.b) * 31 + this.c[0]) * 31 + this.c[1]) * 31 + this.c[2]) * 31 + this.c[3];
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 70 */     if (!(paramObject instanceof PathNodeWithTeleports)) {
/* 71 */       return false;
/*    */     }
/*    */     
/* 74 */     if (((PathNodeWithTeleports)(paramObject = paramObject)).a != this.a || ((PathNodeWithTeleports)paramObject).b != this.b) {
/* 75 */       return false;
/*    */     }
/* 77 */     for (byte b = 0; b < 4; b++) {
/* 78 */       if (this.c[b] != ((PathNodeWithTeleports)paramObject).c[b]) {
/* 79 */         return false;
/*    */       }
/*    */     } 
/*    */     
/* 83 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\pathfinding\PathNodeWithTeleports.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */