package com.prineside.tdi2;

import com.badlogic.gdx.utils.Null;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoSerializable;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.prineside.tdi2.enums.DifficultyMode;
import com.prineside.tdi2.systems.GameStateSystem;
import com.prineside.tdi2.ui.shared.AbilitySelectionOverlay;
import com.prineside.tdi2.utils.REGS;

@REGS
public final class GameState implements KryoSerializable {
  public DifficultyMode difficultyMode;
  
  public long seed;
  
  public int modeDifficultyMultiplier;
  
  public GameStateSystem.GameMode gameMode;
  
  @Null
  public AbilitySelectionOverlay.SelectedAbilitiesConfiguration startingAbilitiesConfiguration;
  
  public boolean canLootCases;
  
  public int encryptedChestsInInventory;
  
  public boolean lootBoostEnabled;
  
  public final void write(Kryo paramKryo, Output paramOutput) {}
  
  public final void read(Kryo paramKryo, Input paramInput) {}
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\GameState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */