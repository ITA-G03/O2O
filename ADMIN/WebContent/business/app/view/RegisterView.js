/*
 * File: app/view/MainView.js
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

Ext.define('MyApp.view.RegisterView', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.toolbar.Toolbar',
        'Ext.form.Label',
        'Ext.button.Cycle',
        'Ext.menu.Menu',
        'Ext.menu.CheckItem',
        'Ext.grid.Panel',
        'Ext.grid.column.Number',
        'Ext.grid.column.Date',
        'Ext.grid.column.Boolean',
        'Ext.grid.View'
    ],
	id:'RegisterView',
    itemId: 'RegisterView',
    layout: 'border',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    region: 'north',
                    height: 100,
                    itemId: 'headerPanel',
                    header: false,
                    title: 'Header',
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            dock: 'top',
                            items: [
                                {
                                    xtype: 'label',
                                    text: 'ADMIN',
									id:'returnHome',
									itemId:'returnHome',
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
                                            },
                                            {
                                                xtype: 'menucheckitem',
                                                text: 'Store',
												id:'store',
												itemId:'store',
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
                                            }
                                        ]
                                    }
                                },
								{
                                    xtype: 'label',
                                    text: 'Welcome'
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
                                    text: 'Home /'
                                },
                                {
                                    xtype: 'label',
                                    text: 'Business /'
                                },
                                {
                                    xtype: 'label',
                                    text: 'Register'
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'panel',
                    region: 'center',
                    itemId: 'contentPanel',
                    bodyPadding: 10,
                    header: false,
                    title: 'Verify Register Message',
                    items: [
                        {
                            xtype: 'gridpanel',
                            title: 'Business Register Message',
							store:Ext.create('MyApp.model.MyModel'),
                            columns: [
                                {
                                    xtype: 'gridcolumn',
                                    dataIndex: 'string',
                                    text: 'Id'
                                },
                                {
                                    xtype: 'numbercolumn',
                                    dataIndex: 'number',
                                    text: 'Name'
                                },
                                {
                                    xtype: 'datecolumn',
                                    dataIndex: 'date',
                                    text: 'ID Card'
                                },
								{
                                    xtype: 'numbercolumn',
                                    dataIndex: 'number',
                                    text: 'License'
                                },
                                {
                                    xtype: 'booleancolumn',
                                    dataIndex: 'bool',
                                    text: 'Tel'
                                },
                                {
                                    xtype: 'gridcolumn',
                                    text: 'Status'
                                }
                            ],
                            dockedItems: [
                                {
                                    xtype: 'toolbar',
                                    dock: 'top',
                                    items: [
                                        {
                                            xtype: 'button',
                                            text: 'update',
											id:'update',
											itemId:'update',
                                        },
                                        {
                                            xtype: 'button',
                                            text: 'delete',
											id:'delete',
											itemId:'delete',
                                        }
                                    ]
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