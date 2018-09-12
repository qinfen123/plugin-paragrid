package com.fr.plugin.widget.grid;

import com.fr.stable.fun.impl.AbstractCssFileHandler;

/**
 * @author richie
 * @date 2015-03-16
 * @since 8.0
 */
public class CssFile extends AbstractCssFileHandler {

  @Override
  public String[] pathsForFiles() {
    return new String[]{
        "/com/fr/plugin/widget/grid/easyui/easyui.css",
        "/com/fr/plugin/widget/grid/easyui/icon.css",
    };
  }

}