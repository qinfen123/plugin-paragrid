package com.fr.plugin.widget.grid;

import com.fr.data.impl.NameTableData;
import com.fr.stable.StringUtils;
import com.fr.design.Exception.ValidationException;
import com.fr.design.designer.properties.Decoder;
import com.fr.design.designer.properties.Encoder;

/**
 * 包装下数据字典
 *
 * @version 6.5.3
 */
public class TableDataWrapper implements Encoder, Decoder {

  public TableDataWrapper() {

  }

  @Override
  public Object decode(String txt) {
    return txt;
  }

  @Override
  public String encode(Object v) {
    if (v == null) {
      return StringUtils.EMPTY;
    }
    if (v instanceof NameTableData) {
      return ((NameTableData) v).getName();
    }

    return v.toString();
  }

  @Override
  public void validate(String txt) throws ValidationException {

  }
}