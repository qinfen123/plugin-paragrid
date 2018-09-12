package com.fr.plugin.widget.grid;

import com.fr.design.fun.ParameterWidgetOptionProvider;
import com.fr.design.fun.impl.AbstractFormWidgetOptionProvider;
import com.fr.form.ui.Widget;

/**
 * @author richie
 * @date 2015-03-16
 * @since 8.0
 */
public class GridImpl extends AbstractFormWidgetOptionProvider implements
    ParameterWidgetOptionProvider {

  @Override
  public int currentAPILevel() {
    return CURRENT_LEVEL;
  }

  @Override
  public Class<? extends Widget> classForWidget() {
    return ComboGrid.class;
  }

  @Override
  public Class<?> appearanceForWidget() {
    return XComboGrid.class;
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