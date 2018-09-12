package com.fr.plugin.widget.grid;

import com.fr.stable.fun.impl.AbstractJavaScriptFileHandler;

/**
 * @author richie
 * @date 2015-03-16
 * @since 8.0
 */
public class JavaScriptFile extends AbstractJavaScriptFileHandler {

  @Override
  public String[] pathsForFiles() {
    return new String[]{
        "/com/fr/plugin/widget/grid/easyui/jquery.easyui.min.js",
        "/com/fr/plugin/widget/grid/web/combogrid.js"
    };
  }
}