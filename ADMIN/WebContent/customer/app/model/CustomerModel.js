Ext.define('app.model.CustomerModel', {
     extend: 'Ext.data.Model',
     fields: [
         {name: 'userId', type: 'int'},
         {name: 'tel',  type: 'string'},
         {name: 'encryptedPassword',  type: 'string'}
     ]
 
 });