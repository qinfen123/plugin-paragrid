package com.fr.plugin.widget.grid;

import com.fr.base.TableData;
import com.fr.data.TableDataSource;
import com.fr.data.impl.NameTableData;
import com.fr.design.beans.BasicBeanPane;
import com.fr.design.data.DesignTableDataManager;
import com.fr.design.gui.frpane.TreeSettingPane;
import com.fr.design.gui.icombobox.UIComboBox;
import com.fr.design.gui.icombobox.UIComboBoxRenderer;
import com.fr.design.gui.ilable.UILabel;
import com.fr.design.gui.itextfield.UINumberField;
import com.fr.design.layout.TableLayout;
import com.fr.design.layout.TableLayoutHelper;
import com.fr.design.present.dict.DictionaryPane;
import com.fr.design.widget.DataModify;
import com.fr.design.widget.ui.AbstractDataModify;
import com.fr.file.DatasourceManager;
import com.fr.third.org.apache.poi.hssf.record.formula.functions.Abs;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

public class CellGridDefinePane extends AbstractDataModify<ComboGrid> {

  private ComboBoxModel model;
  private UINumberField real;
  private UINumberField display;

  public CellGridDefinePane() {
    initComponents();
  }

  private void initComponents() {
    setLayout(new BorderLayout());
    model = model();
    UIComboBox comboBox = new UIComboBox();
    comboBox.setRenderer(renderer());
    comboBox.setPreferredSize(new Dimension(240, 24));

    double p = TableLayout.PREFERRED;
    double f = TableLayout.FILL;

    double[] rowSize = new double[]{p, p, p};
    double[] columnSize = new double[]{p, f};

    real = new UINumberField();
    real.setInteger(true);
    real.setValue(0);

    display = new UINumberField();
    display.setInteger(true);
    display.setValue(0);

    JPanel panel = TableLayoutHelper.createTableLayoutPane(new Component[][]{
        {new UILabel("TableData:"), comboBox},
        {new UILabel("Value:"), real},
        {new UILabel("ShowValue:"), display},
    }, rowSize, columnSize);
    add(panel, BorderLayout.CENTER);
  }

  /**
   * 数据源
   *
   * @return 数据源
   */
  public ComboBoxModel model() {
    Vector<TableData> tableDatas = new Vector<TableData>();
    TableDataSource tableDataSource = DesignTableDataManager.getEditingTableDataSource();
    if (tableDataSource != null) {
      Iterator it = tableDataSource.getTableDataNameIterator();
      while (it.hasNext()) {
        String name = (String) it.next();
        tableDatas.add(new NameTableData(name));
      }
    }
    Iterator nameIt = DatasourceManager.getProviderInstance().getTableDataNameIterator();
    while (nameIt.hasNext()) {
      tableDatas.add(new NameTableData((String) nameIt.next()));
    }
    return new DefaultComboBoxModel(tableDatas);
  }

  /**
   * 遍历器
   *
   * @return 遍历器
   */
  public ListCellRenderer renderer() {
    return new UIComboBoxRenderer() {
      @Override
      public Component getListCellRendererComponent(JList jList, Object o, int i, boolean b,
          boolean b1) {
        if (o instanceof NameTableData) {
          setText(((NameTableData) o).getName());
        }
        return this;
      }
    };
  }

  @Override
  public void populateBean(ComboGrid ob) {
       /* model.setSelectedItem(ob.getTableData());
        real.setValue(ob.getKeyIndex());
        display.setValue(ob.getValueIndex());*/
  }

  @Override
  public ComboGrid updateBean() {
    ComboGrid grid = new ComboGrid();
       /* grid.setTableData((TableData) model.getSelectedItem());
        grid.setKeyIndex((int) real.getValue());
        grid.setValueIndex((int) display.getValue());*/
    return grid;
  }

  @Override
  protected String title4PopupWindow() {
    return "grid";
  }
}