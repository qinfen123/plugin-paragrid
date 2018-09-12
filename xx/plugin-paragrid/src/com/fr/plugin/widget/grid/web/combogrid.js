(function ($) {
  /**
   * @class FR.ComboGrid
   * @extends FR.TriggerEditor
   */
  FR.ComboGrid = FR.extend(FR.TriggerEditor, {
    _defaultConfig: function () {
      return $.extend(FR.ComboGrid.superclass._defaultConfig.apply(), {
        showWidth: 500,
        showHeight: 280,
        defaultWidth: 80
      });
    },
    _init: function () {
      FR.ComboGrid.superclass._init.apply(this, arguments);
    },

    onTriggerClick: function () {
      debugger;
      var $t = $('<table style="width:700px;height:250px"/>');
      var opt = this.options, self = this;
      if (opt.columns) {
        self._refreshGrid($t, opt.columns, opt.data);
      } else {
        $.ajax({
          url: opt.widgetUrl,
          success: function (res) {
            var data = FR.jsonDecode(res);
            var columnInfo = data[0];
            var columnName = columnInfo["columnNames"];

            var valueInfo = columnInfo["valueInfo"];
            opt.valueColumnName = valueInfo["valueColumnName"];
            opt.textColumnName = valueInfo["textColumnName"];

            var columns = [];
            var columnCount = columnName.length;
            if (columnCount * opt.defaultWidth < opt.showWidth) {
              opt.defaultWidth = opt.showWidth / columnCount;
            }
            for (var i = 0, len = columnCount; i < len; i++) {
              columns.push({
                field: columnName[i],
                title: columnName[i],
                width: opt.defaultWidth,
                sortable: true
              });
            }

            opt.columns = [columns];

            opt.data = data[1];

            self._refreshGrid($t, opt.columns, opt.data);
          }
        });
      }
    },
    _refreshGrid: function ($t, columns, data) {
      var self = this, opt = this.options;
      FR.showDialog({
        title: "下拉表格",
        width: 500,
        height: 280,
        contentHtml: $t
      });
      $t.datagrid({
        singleSelect: true,
        collapsible: true,
        columns: columns,
        data: data,
        onClickRow: function (rowIndex, rowData) {
          self._setTextAndValue(rowData[opt.textColumnName],
              rowData[opt.valueColumnName]);
          FR.destroyDialog();
        }
      });
    },

    _setTextAndValue: function (text, value) {
      this.setText(text);
      this.setValue(value);
    },

    getValue: function () {
      return this.options.value;
    },

    setValue: function (value) {
      this.options.value = value;
    },

    setText: function (text) {
      this.editComp.val(text);
    },
    getText: function () {
      return this.editComp.val();
    }
  });
  $.shortcut('combogrid', FR.ComboGrid);
})(jQuery);