
Ext.define('MyApp.store.MyStore', {
    extend: 'Ext.data.Store',

    model: 'MyApp.model.MyModel',
	storeId: 'MyStore',
	autoLoad:true,
	proxy:{
		type:'ajax',
		url:'/loadAllBusiness',
		reader:{
			type:'json',
			root:'data',
		}
	},
       
});