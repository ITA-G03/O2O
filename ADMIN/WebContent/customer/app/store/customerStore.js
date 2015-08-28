Ext.define('app.store.customerStore', {
    extend: 'Ext.data.Store',

    model: 'app.model.CustomerModel',
	storeId: 'customerStore',
	autoLoad:true,
	proxy: {
         type: 'ajax',
         url: '/queryAllValue',
         reader: {
             type: 'json',
             root: 'data'
         }
     },
});