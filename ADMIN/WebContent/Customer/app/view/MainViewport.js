/*
 * File: app/view/MainViewport.js
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

Ext.define('app.view.MainViewport', {
    extend: 'Ext.container.Viewport',
    alias: 'widget.mainviewport',

    requires: [
        'Ext.toolbar.Toolbar',
        'Ext.form.field.Text',
        'Ext.grid.Panel',
        'Ext.grid.column.Number',
        'Ext.grid.View',
        'Ext.form.Label',
        'Ext.button.Cycle',
        'Ext.menu.Menu',
        'Ext.menu.CheckItem'
    ],

    layout: 'fit',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    layout: 'card',
                    header: false,
                    manageHeight: false,
                    title: 'Customer Message',
                    items: [
                        {
                            xtype: 'container',
                            html: {
                                
                            },
                            width: 700,
                            items: [
                                {
                                    xtype: 'container',
                                    layout: {
                                        type: 'hbox',
                                        align: 'middle',
                                        pack: 'center'
                                    }
                                },
                                {
                                    xtype: 'toolbar',
                                    items: [
                                        {
                                            xtype: 'textfield',
                                            fieldLabel: 'Tel:',
                                            id:'telValue',
                                            itemId:'telValue',
                                        },
                                        {
                                            xtype: 'button',
                                            text: 'reset',
                                            id:'resetPassword',
        									itemId:'resetPassword',
                                        }
                                    ]
                                },
                                {
                                    xtype: 'gridpanel',
                                    header: false,
                                    title: 'My Grid Panel',
                                    store:Ext.create('app.store.customerStore'),
                                    columns: [
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'userId',
                                            text: 'CustomerId'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'tel',
                                            text: 'Tel'
                                        }
                                    ]
                                },
                               
                            ]
                        }
                    ],
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            dock: 'top',
                            height: 48,
                            items: [
                                {
                                    xtype: 'label',
                                    text: 'ADMIN',
									id:'returnHome',
									itemId:'returnHome',
									listeners:{
										click:function(){
											window.location.href='/home/index.html';
										}
									}
                                },
                                {
                                    xtype: 'cycle',
                                    text: 'Customer',
                                    menu: {
                                        xtype: 'menu',
                                        width: 120,
                                        items: [
                                            {
                                                xtype: 'menucheckitem',
                                                text: 'Password',
												id:'customer',
												itemId:'customer',
												listeners:{
													click:function(){
														window.location.href='/Customer/customer.html';
													}
												}
                                            }
                                        ]
                                    }
                                },
                                {
                                    xtype: 'cycle',
                                    text: 'Business',
                                    menu: {
                                        xtype: 'menu',
                                        width: 120,
                                        items: [
                                            {
                                                xtype: 'menucheckitem',
                                                text: 'Register',
												id :'register',
												itemId:'register',
												listeners:{
													click:function(){
														window.location.href='/business/business.html';
													}
												}
                                            },
                                            {
                                                xtype: 'menucheckitem',
                                                text: 'Store',
												id:'store',
												itemId:'store',
												listeners:{
													click:function(){
														window.location.href='/Store/store.html';
													}
												}
                                            }
                                        ]
                                    }
                                },
                                {
                                    xtype: 'cycle',
                                    text: 'System',
                                    menu: {
                                        xtype: 'menu',
                                        width: 120,
                                        items: [
                                            {
                                                xtype: 'menucheckitem',
                                                text: 'Setting',
												id : 'system',
												itemId:'system',
												listeners:{
													click:function(){
														window.location.href='/setting/setting.html';
													}
												}
                                            }
                                        ]
                                    }
                                },
                                {
                                    xtype: 'label',
                                    text: 'Welcome：'
                                },
                                {
                                    xtype: 'label',
                                    text: 'admin',
									id:'welcome',
									itemId:'welcome',								
								
                                }
                            ]
                        },
                        {
                            xtype: 'toolbar',
                            dock: 'top',
                            items: [
                                {
                                    xtype: 'label',
                                    text: 'Home  /'
                                },
                                {
                                    xtype: 'label',
                                    text: 'Customer /'
                                },
                                {
                                    xtype: 'label',
                                    text: 'Password'
                                },
                                {
                                    xtype: 'toolbar'
                                }
                            ]
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});
Ext.create('app.view.MainViewport');