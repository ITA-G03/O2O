/*
 * File: app/store/MyStore.js
 *
 * This file was generated by Sencha Architect version 3.0.4.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.2.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.2.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('MyApp.store.MyStore', {
    extend: 'Ext.data.Store',

    model: 'MyApp.model.MyModel',
	storeId: 'MyStore',
	autoLoad:true,
	proxy:{
		type:'ajax',
		url:'/allApprovingBusinessDetail',
		reader:{
			type:'json',
			root:'data',
		}
	},
       
});