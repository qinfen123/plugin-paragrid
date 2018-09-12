package com.fr.plugin.widget.grid;

import com.fr.base.TableData;
import com.fr.data.TableDataSource;
import com.fr.data.impl.NameTableData;
import com.fr.design.data.DesignTableDataManager;
import com.fr.design.gui.icombobox.UIComboBoxRenderer;
import com.fr.design.mainframe.widget.editors.ComboEditor;
import com.fr.file.DatasourceManager;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author richie
 * @date 2015-03-17
 * @since 8.0
 */
public class TableDataEditor extends ComboEditor {


  public TableDataEditor() {
    super();

  }

  /**
   * 获取数据
   *
   * @return 数据集信息
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
   * 格子遍历器
   *
   * @return 格子遍历器
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
  public void setValue(Object value) {
    comboBox.setSelectedItem(value);
  }

  @Override
  public Object getValue() {
    return comboBox.getSelectedItem();
  }
}