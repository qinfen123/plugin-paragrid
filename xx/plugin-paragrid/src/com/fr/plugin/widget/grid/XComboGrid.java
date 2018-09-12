package com.fr.plugin.widget.grid;

import com.fr.design.designer.creator.CRPropertyDescriptor;
import com.fr.design.designer.creator.XLayoutContainer;
import com.fr.design.designer.creator.XWScaleLayout;
import com.fr.design.designer.creator.XWidgetCreator;
import com.fr.design.designer.creator.XWriteAbleRepeatEditor;
import com.fr.design.form.util.XCreatorConstants;
import com.fr.design.gui.itextfield.UITextField;
import com.fr.design.layout.FRGUIPaneFactory;
import com.fr.design.mainframe.widget.editors.WidgetValueEditor;
import com.fr.general.Inter;
import com.fr.stable.ArrayUtils;

import com.fr.stable.core.PropertyChangeAdapter;
import javax.swing.*;
import java.awt.*;
import java.beans.IntrospectionException;
import javax.swing.table.DefaultTableModel;

/**
 * @author richie
 * @date 2015-03-16
 * @since 8.0
 */
public class XComboGrid extends XWidgetCreator {

  LimpidButton btn;

  public XComboGrid(ComboGrid widget, Dimension initSize) {
    super(widget, initSize);
  }

  /**
   * 重写属性面板
   */
  public CRPropertyDescriptor[] supportedDescriptor() throws IntrospectionException {
    return (CRPropertyDescriptor[]) ArrayUtils
        .addAll(ArrayUtils.remove(super.supportedDescriptor(), 3),
            new CRPropertyDescriptor[]{
                new CRPropertyDescriptor("allowDown", this.data.getClass(), "isAllowDown",
                    "setAllowDown").setI18NName("允许下载").putKeyValue(
                    XCreatorConstants.PROPERTY_CATEGORY, "FR-Designer_Advanced"),
                new CRPropertyDescriptor("waterMark", this.data.getClass())
                    .setI18NName("背景水印").putKeyValue(XCreatorConstants.PROPERTY_CATEGORY,
                    "FR-Designer_Advanced"),
                new CRPropertyDescriptor("docAddress", this.data.getClass(), "getDocAddress",
                    "setDocAddress").setI18NName("文档地址").putKeyValue(
                    XCreatorConstants.PROPERTY_CATEGORY, "FR-Designer_Advanced")
            });
  }

  public ComboGrid toData() {
    return (ComboGrid) this.data;
  }

  public String getIconPath() {
    return "/com/fr/plugin/widget/grid/images/table.png";
  }

  @Override
  protected JComponent initEditor() {

        /*if (editor == null) {
            editor = FRGUIPaneFactory.createBorderLayout_S_Pane();
            UITextField textField = new UITextField(5);
            textField.setOpaque(false);
            editor.add(textField, BorderLayout.CENTER);
            btn = new LimpidButton("", this.getIconPath(), toData().isVisible() ? FULL_OPACITY : HALF_OPACITY);
            btn.setPreferredSize(new Dimension(21, 21));
            btn.setOpaque(true);
            editor.add(btn, BorderLayout.EAST);
            editor.setBackground(Color.WHITE);
        }*/
    return this;
  }

  protected void makeVisible(boolean visible) {
    btn.makeVisible(visible);
  }

  /**
   * 获取当前XCreator的一个封装父容器
   *
   * @param widgetName 当前组件名
   * @return 封装的父容器
   * @date 2014-11-25-下午4:47:23
   */
  protected XLayoutContainer getCreatorWrapper(String widgetName) {
    return new XWScaleLayout();
  }

  /**
   * 将当前对象添加到父容器中
   *
   * @param parentPanel 父容器组件
   * @date 2014-11-25-下午4:57:55
   */
  protected void addToWrapper(XLayoutContainer parentPanel, int width, int minHeight) {
    this.setSize(width, minHeight);
    parentPanel.add(this);
  }

  /**
   * 此控件在自适应布局要保持原样高度
   *
   * @return 是则返回true
   */
  @Override
  public boolean shouldScaleCreator() {
    return true;
  }
}