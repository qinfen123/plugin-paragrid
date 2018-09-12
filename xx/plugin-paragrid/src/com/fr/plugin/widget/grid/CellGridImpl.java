package com.fr.plugin.widget.grid;

import com.fr.design.beans.BasicBeanPane;
import com.fr.design.fun.impl.AbstractCellWidgetOptionProvider;
import com.fr.form.ui.Widget;

public class CellGridImpl extends AbstractCellWidgetOptionProvider {

  @Override
  public Class<? extends Widget> classForWidget() {
    return ComboGrid.class;
  }

  @Override
  public Class<? extends BasicBeanPane<? extends Widget>> appearanceForWidget() {
    return CellGridDefinePane.class;
  }

  @Override
  public String iconPathForWidget() {
    return "/com/fr/plugin/widget/grid/images/table.png";
  }

  @Override
  public String nameForWidget() {
    return "下拉表格";
  }
}