package com.vladsch.flexmark.util.format;

import java.util.ArrayList;

public interface TableRowManipulator {
  public static final int BREAK = -2147483648;
  
  int apply(TableRow paramTableRow, int paramInt1, ArrayList<TableRow> paramArrayList, int paramInt2);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\TableRowManipulator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */