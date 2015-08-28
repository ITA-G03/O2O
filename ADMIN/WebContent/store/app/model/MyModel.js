Ext.define('MyApp.model.MyModel', {
    extend: 'Ext.data.Model',

    fields: [
        { name: 'businessId',type:'int'  },
        { name: 'realName', type: 'string'},
        { name: 'idCardId', type: 'int'},
		{ name: 'licenseId', type: 'int'},
		{ name: 'statusName', type: 'String'}
    ]
});