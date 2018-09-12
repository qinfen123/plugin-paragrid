package com.fr.plugin.widget.grid;

import com.fr.base.TableData;
import com.fr.data.impl.NameTableData;
import com.fr.form.ui.DataControl;
import com.fr.form.ui.DirectWriteEditor;
import com.fr.form.ui.WidgetValue;
import com.fr.form.ui.WriteAbleRepeatEditor;
import com.fr.general.data.DataModel;
import com.fr.json.JSONArray;
import com.fr.json.JSONObject;
import com.fr.script.Calculator;
import com.fr.stable.StringUtils;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;
import com.fr.web.core.SessionIDInfor;

import javax.servlet.http.HttpServletRequest;

/**
 * @author richie
 * @date 2015-03-16
 * @since 8.0
 */
public class ComboGrid extends DirectWriteEditor implements DataControl {

  private boolean allowDown;
  private String docAddress;


  public ComboGrid() {

  }

  public boolean isAllowDown() {
    return allowDown;
  }

  public void setAllowDown(boolean allowDown) {
    this.allowDown = allowDown;
  }

  public String getDocAddress() {
    return docAddress;
  }

  public void setDocAddress(String docAddress) {
    this.docAddress = docAddress;
  }

  /**
   * 控件xType,每个控件的特有标记和控件一一对应
   */
  public String getXType() {
    return "pdf";
  }

  /**
   * 读取一个XML文件
   */
  public void readXML(XMLableReader reader) {
    super.readXML(reader);
    if (reader.isChildNode()) {
      if (reader.getTagName().equals("allowDown")) {
        this.allowDown = false;
      }
      if (reader.getTagName().equals("docAddress")) {
        this.setDocAddress(reader.getElementValue());
      }
    }
  }

  /**
   * 创建一个XML文件
   */
  public void writeXML(XMLPrintWriter writer) {
    //存放allowDown =false
    if (!this.allowDown) {
      writer.startTAG("allowDown").textNode(String.valueOf(this.allowDown)).end();
    }
    if (StringUtils.isNotBlank(docAddress)) {
      writer.startTAG("docAddress").textNode(this.docAddress).end();
    }
    //如果widgetName和waterMark有值，默认已经写入到xml中
    super.writeXML(writer);
  }

  @Override
  public int[] getValueType() {
    return new int[]{TYPE_STRING, TYPE_FORMULA};
  }

  /**
   * 设置控件值
   */
  @Override
  public void setWidgetValue(WidgetValue widgetValue) {

  }

  /**
   * 获取控制值
   */
  @Override
  public WidgetValue getWidgetValue() {
    return null;
  }


  /**
   * 生成控件值信息，并放到widgetResult中
   *
   * @param widget 当前控件
   * @param widgetCalculator 当前算子
   * @param widgetResult 控件输出json结果
   * @param attrSourceCache 处理过程中创建的dataModel缓存起来
   */
  @Override
  public void createValueResult(DataControl widget, Calculator widgetCalculator,
      JSONObject widgetResult, JSONObject attrSourceCache) {

  }

  @Override
  public String getFormatText() {
    return null;
  }

  @Override
  public String getDataBindDefaultValue(Calculator calculator) {
    return null;
  }
}