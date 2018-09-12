package com.fr.plugin.widget.grid;

import com.fr.design.mainframe.widget.renderer.EncoderCellRenderer;

/**
 * @author richie
 * @date 2015-03-17
 * @since 8.0
 */
public class TableDataRenderer extends EncoderCellRenderer {

  public TableDataRenderer() {
    super(new TableDataWrapper());
  }
}