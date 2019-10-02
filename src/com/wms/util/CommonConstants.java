package com.wms.util;

public class CommonConstants {
	
	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "queryFilePath";

	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "config.properties";

	/** Constant for query tag in EmployeeQuery.xml */
	public static final String TAG_NAME = "query";

	/** Constant for query id in EmployeeQuery.xml */
	public static final String ATTRIB_ID = "id";
	
	/** Constant for employee id prefix */
	public static final String EMPLOYEE_ID_PREFIX = "E300";

	/** Constant for comma */
	public static final String COMMA = ",";

	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";

	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";
	
	/** Constant for query id of drop_table in Query.xml */
	public static final String QUERY_ID_DROP_TABLE_FUNCTION = "drop_table_function";

	/** Constant for query id of drop_table in Query.xml */
	public static final String QUERY_ID_DROP_TABLE = "drop_table";

	/** Constant for query id of create_table in Query.xml */
	public static final String QUERY_ID_CREATE_CUSTOMER_TABLE = "create_customer_table";
	public static final String QUERY_ID_CREATE_GRN_TABLE = "create_GRN_table";
	public static final String QUERY_ID_CREATE_GRN_QTY_TABLE = "create_GRN_Qty_table";
	public static final String QUERY_ID_CREATE_ITEM_TABLE = "create_item_table";
	public static final String QUERY_ID_CREATE_GRN_DELETE_REQUEST_TABLE = "create_grn_delete_req";
	public static final String QUERY_ID_CREATE_ITEM_DELETE_REQUEST_TABLE = "create_item_delete_req";
	public static final String QUERY_ID_CREATE_GDN_TABLE = "create_gdn_table";
	public static final String QUERY_ID_CREATE_GDN_QTY_TABLE = "create_gdn_qty_table";
	public static final String QUERY_ID_CREATE_GDN_DELETE_REQUEST_TABLE = "create_gdn_delete_req";
	
	/** Constant for query id of insert GRN in Query.xml */
	public static final String QUERY_ID_INSERT_GRN = "insert_GRN";
	
	/** Constant for query id of get all GRN in Query.xml */
	public static final String QUERY_ID_ALL_GRN = "all_GRNS";
	
	/** Constant for query id of get specific GRN in Query.xml */
	public static final String QUERY_ID_GET_GRN = "GRN_by_id";
	
	/** Constant for query id of get specific Customer Name in Query.xml */
	public static final String QUERY_ID_GET_CUSTOMER_NAME = "get_Customer_Name";
	
	/** Constant for query id of get specific Customer Name List in Query.xml */
	public static final String QUERY_ID_GET_CUSTOMER_NAME_LIST = "get_Customer_Name_List";
	
	/** Constant for query id of get specific Customer REF in Query.xml */
	public static final String QUERY_ID_GET_CUSTOMER_REF = "get_Customer_REF";
	
	/** Constant for query id of get GRN COUNT in Query.xml */
	public static final String QUERY_ID_GET_GRN_COUNT_BY_ID = "GRN_COUNT_BY_ID";
	
	/** Constant for query id of insert GRN QTY in Query.xml */
	public static final String QUERY_ID_INSERT_GRN_QTY = "insert_GRN_QTY";
	
	/** Constant for query id of get GRN QTY view in Query.xml */
	public static final String QUERY_ID_GET_GRNQTY_VIEW = "get_GRN_View";
	
	/** Constant for query id of get GRN By cusid view in Query.xml */
	public static final String QUERY_ID_GET_GRN_BY_CUSID = "get_GRN_By_cusId";
	
	/** Constant for query id of Update GRN in Query.xml */
	public static final String QUERY_ID_UPDATE_GRN = "update_GRN";
	
	/** Constant for query id of DELETE req GRN in Query.xml */
	public static final String QUERY_ID_REQUEST_DELETE_GRN = "request_delete_GRN";
	
	/** Constant for query id of get GRN in Query.xml */
	public static final String QUERY_ID_GET_GRNQTY_GRNNOANDITEMID = "get_GRN_By_ItemIdAndCusId";
	
	/** Constant for query id of show DELETE req GRN in Query.xml */
	public static final String QUERY_ID_SHOW_REQUEST_DELETE_GRN = "show_request_delete_grn";
	
	/** Constant for query id of show DELETE req GRN in Query.xml */
	public static final String QUERY_ID_DELETE_GRN_DEL_REQ = "delete_grn_del_req";
	
	/** Constant for query id of show DELETE req GRN in Query.xml */
	public static final String QUERY_ID_DELETE_GRN = "delete_grn";
	
	/** Constant for query id of insert Item in Query.xml */
	public static final String QUERY_ID_INSERT_ITEM = "insert_ITEM";
	
	/** Constant for query id of get item code in Query.xml */
	public static final String QUERY_ID_GET_ITEM_CODE = "get_Item_Code";
	
	/** Constant for query id of get Item name in Query.xml */
	public static final String QUERY_ID_GET_ITEM_NAME = "GET_ITEM_NAME";
	
	/** Constant for query id of get Item List in Query.xml */
	public static final String QUERY_ID_GET_ITEM_LIST = "GET_ITEM_LIST";
	
	/** Constant for query id of Update Item in Query.xml */
	public static final String QUERY_ID_UPDATE_ITEM = "GET_ITEM_UPDATE";

	/** Constant for query id of Update Item in Query.xml */
	public static final String QUERY_ID_GET_ITEM_BY_ID = "GET_ITEM_BY_ID";
	
	/** Constant for query id of DELETE req Item in Query.xml */
	public static final String QUERY_ID_REQUEST_DELETE_ITEM = "request_delete_ITEM";
	
	/** Constant for query id of Update Item in Query.xml */
	public static final String QUERY_ID_CONFIRM_ITEM = "Confirm_item";
	
	/** Constant for query id of get GRN COUNT in Query.xml */
	public static final String QUERY_ID_GET_GDN_COUNT_BY_ID = "GDN_COUNT_BY_ID";
	
	/** Constant for query id of insert GDN in Query.xml */
	public static final String QUERY_ID_INSERT_GDN = "insert_GDN";
	
	/** Constant for query id of insert GDN in Query.xml */
	public static final String QUERY_ID_INSERT_GDN_QTY = "insert_GDN_QTY";
	
	/** Constant for query id of get all GDN in Query.xml */
	public static final String QUERY_ID_ALL_GDN = "all_GDNS";
	
	/** Constant for query id of get GDN in Query.xml */
	public static final String QUERY_ID_GET_GDNQTY_BY_GDNNO = "get_GDNQTY_BY_GDNNO";
	
	/** Constant for query id of Update GDN in Query.xml */
	public static final String QUERY_ID_UPDATE_GDN = "update_GDN";
	
	/** Constant for query id of get GDN by id in Query.xml */
	public static final String QUERY_ID_GET_GDN_BY_GDNNO = "get_GDN_BYID";
	
	/** Constant for query id of DELETE req GDN in Query.xml */
	public static final String QUERY_ID_REQUEST_DELETE_GDN = "request_delete_gdn";
	
	/** Constant for query id of show DELETE req GDN in Query.xml */
	public static final String QUERY_ID_SHOW_REQUEST_DELETE_GDN = "show_request_delete_gdn";
	
	/** Constant for query id of show DELETE req GRN in Query.xml */
	public static final String QUERY_ID_DELETE_GDN_DEL_REQ = "delete_gdn_del_req";
	
	/** Constant for query id of show DELETE req GRN in Query.xml */
	public static final String QUERY_ID_DELETE_GDN = "delete_gdn";
	
	/** Constant for Column index one */
	public static final int COLUMN_INDEX_ONE = 1;
	
	/** Constant for Column index two */
	public static final int COLUMN_INDEX_TWO = 2;
	
	/** Constant for Column index three */
	public static final int COLUMN_INDEX_THREE = 3;
	
	/** Constant for Column index four */
	public static final int COLUMN_INDEX_FOUR = 4;
	
	/** Constant for Column index five */
	public static final int COLUMN_INDEX_FIVE = 5;
	
	/** Constant for Column index six */
	public static final int COLUMN_INDEX_SIX = 6;
	
	/** Constant for Column index seven */
	public static final int COLUMN_INDEX_SEVEN = 7;
	
	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_EIGHT = 8;
	
	/** Constant for Column index nine */
	public static final int COLUMN_INDEX_NINE = 9;
	
	/** Constant for Column index ten */
	public static final int COLUMN_INDEX_TEN = 10;
	
	/** Constant for Column index eleven */
	public static final int COLUMN_INDEX_ELEVEN = 11;
	

	/**
	 * @Student_ID : IT18178678
	 * @Name : S.M.A.S.Senevirathne
	 */
	
	/** Constant for Column index nine */
	public static  int COUNT_FOR_EDIT_PO = 0;
	/** Constant for prefix of INventory table primary key */
	public static final String INVENRTORY_PREFIX = "ITM-0";

	/** Constant for prefix of Purchase Order table primary key */
	public static final String PURCHASE_ORDER_PREFIX = "PO-0";

	/** Constant for prefix of Purchase Order details table primary key */
	public static final String PURCHASE_ORDER_DETAILS_PREFIX = "POD-0";
	
	/** Constant for prefix of Purchase Order details table primary key */
	public static final String QUOTATION_PREFIX = "QO-0";
	
	/** Constant for prefix of Purchase Order details table primary key */
	public static final String QUOTATION_DETAILS_PREFIX = "QOD-0";

	/** Constant for query id of get_inventory_table_entry_count in Query.xml */
	public static final String QUERY_ID_GET_INVENTORY_TABLE_ENTRY_COUNT = "get_inventory_table_entry_count";

	/** Constant for query id of get_inventory_items_by_type in Query.xml */
	public static final String QUERY_ID_GET_INVENTORY_ITM_BY_TYPE = "get_inventory_items_by_type";

	/** Constant for query id of add_inventory_table in Query.xml */
	public static final String QUERY_ID_ADD_INVENTORY_TABLE = "add_inventory_table";

	/** Constant for query id of delete_all_items in Query.xml */
	public static final String QUERY_ID_DELETE_ALL_ITEMS = "delete_all_items";

	/** Constant for query id of delete_item_by_id in Query.xml */
	public static final String QUERY_ID_DELETE_FROM_INVENTORY = "delete_item_by_id";

	/** Constant for query id of get_total_days in Query.xml */
	public static final String QUERY_ID_GET_TOTAL_DAYS = "get_total_days";

	/** Constant for query id of get_remaing_days in Query.xml */
	public static final String QUERY_ID_GET_REMAING_DAYS = "get_remaing_days";

	/** Constant for query id of update_inventory_item in Query.xml */
	public static final String QUERY_ID_UPDATE_INVENTORY_ITEM = "update_inventory_item";

	/**
	 * Constant for query id of get_purchase_order_table_entry_count in Query.xml
	 */
	public static final String QUERY_ID_GET_PURCHASE_ORDER_TABLE_ENTRY_COUNT = "get_purchase_order_table_entry_count";

	/** Constant for query id of add_purchase_order_table in Query.xml */
	public static final String QUERY_ID_ADD_PURCHASE_ORDER_TABLE = "add_purchase_order_table";

	/** Constant for query id of get_purchase_order_details_table in Query.xml */
	public static final String QUERY_ID_GET_PURCHASER_ORDER_DETAILS_BY_ID = "get_purchase_order_details_table";

	/**
	 * Constant for query id of get_purchase_order_details_table_entry_count in
	 * Query.xml
	 */
	public static final String QUERY_ID_GET_PURCHASE_ORDER_DETAILS_TABLE_ENTRY_COUNT = "get_purchase_order_details_table_entry_count";

	/** Constant for query id of add_purchase_order_details_table in Query.xml */
	public static final String QUERY_ID_ADD_PURCHASE_ORDER_DETAILS = "add_purchase_order_details_table";

	/** Constant for query id of get_purchase_order_head in Query.xml */
	public static final String QUERY_ID_GET_PURCHASE_ORDER_HEAD = "get_purchase_order_head";

	/** Constant for query id of delete_purchase_order_details_by_id in Query.xml */
	public static final String QUERY_ID_DELETE_PURCHASE_ORDER_DETAILS_BY_ID = "delete_purchase_order_details_by_id";

	/** Constant for query id of edit_purchase_order_details_by_id in Query.xml */
	public static final String QUERY_ID_EDIT_PURCHASE_ORDER_DETAILS_BY_ID = "edit_purchase_order_details_by_id";

	/**Constant for query id of delete_purchase_order_details_by_po_id in Query.xml*/
	public static final String QUERY_ID_EDIT_PURCHASE_ORDER_DETAILS_BY_PO_ID = "delete_purchase_order_details_by_po_id";

	/** Constant for query id of delete_purchase_order in Query.xml */
	public static final String QUERY_ID_EDIT_PURCHASE_ORDER = "delete_purchase_order";

	/** Constant for query id of get_inventory_item_details_by_id in Query.xml */
	public static final String QUERY_ID_GET_INVENTORY_ITEM_bY_ID = "get_inventory_item_details_by_id";
	
	/** Constant for query id of get_inventory_item_details_by_id in Query.xml */
	public static final String QUERY_ID_GET_QUOTATION_TABLE_ENTRY_COUNT = "get_quotation_table_entry_count";
	
	/** Constant for query id of get_inventory_item_details_by_id in Query.xml */
	public static final String QUERY_ID_ADD_QUOTATION_TABLE = "add_quotation_table";
	
	/** Constant for query id of get_inventory_item_details_by_id in Query.xml */
	public static final String QUERY_ID_GET_QUOTATION_DETAILS_TABLE_ENTRY_COUNT = "get_quotation_details_table_entry_count";
	
	/** Constant for query id of get_inventory_item_details_by_id in Query.xml */
	public static final String QUERY_ID_ADD_QUOTATION_DETAILS_TABLE = "add_quotation_details_table";
	
	/** Constant for query id of get_inventory_item_details_by_id in Query.xml */
	public static final String QUERY_ID_GET_QUOTATION_BY_PO_ID = "get_quotation_by_po_id";
	
	/** Constant for query id of get_inventory_item_details_by_id in Query.xml */
	public static final String QUERY_ID_GET_QUOTATION_BY_QO_ID = "get_quotation_details_by_qo_id";
	
	/** Constant for query id of get_inventory_item_details_by_id in Query.xml */
	public static final String QUERY_ID_GET_QUOTATION_BY_QUOATATION_ID = "get_quotation_by_quoatation_id";
	
	/** Constant for query id of crete_inventory_table in Query.xml */
	public static final String QUERY_ID_CREATE_INVENTORY_TABLE = "crete_inventory_table";
	
	/** Constant for query id of drop_inventory_table in Query.xml */
	public static final String QUERY_ID_DROP_INVENTORY_TABLE = "drop_inventory_table";
	
	/** Constant for query id of crete_purchase_order_table in Query.xml */
	public static final String QUERY_ID_CREATE_PURCHASE_ORDER_TABLE = "crete_purchase_order_table";
	
	/** Constant for query id of crete_purchase_order_details_table in Query.xml */
	public static final String QUERY_ID_CREATE_PURCHASE_ORDER_DETAILS_TABLE = "crete_purchase_order_details_table";
	
	/** Constant for query id of crete_quotatin_table in Query.xml */
	public static final String QUERY_ID_CREATE_QUOTATION_TABLE = "crete_quotatin_table";
	
	/** Constant for query id of crete_quotatin_details_table in Query.xml */
	public static final String QUERY_ID_CREATE_QUOTATION_DETAILS_TABLE = "crete_quotatin_details_table";
	
	/** Constant for query id of drop_inventory_table in Query.xml */
	public static final String QUERY_ID_DROP_PURCHASE_ORDER_TABLE = "drop_purchase_order_table";
	
	/** Constant for query id of drop_inventory_table in Query.xml */
	public static final String QUERY_ID_DROP_PURCHASE_ORDER_DETAILS_TABLE = "drop_purchase_order_details_table";
	
	/** Constant for query id of drop_inventory_table in Query.xml */
	public static final String QUERY_ID_DROP_QUOTATION_TABLE = "drop_quotatin_table";
	
	/** Constant for query id of drop_inventory_table in Query.xml */
	public static final String QUERY_ID_DROP_QUOTATION_DETAILS_TABLE = "drop_quotatin_details_table";
	
	/** Constant for query id of drop_inventory_table in Query.xml */
	public static final String QUERY_ID_CREATE_CREATE_PROCEDURE_TOTAODAY = "create_procedure_totaldays";
	
	/** Constant for query id of create_procedure_get_remaing_days in Query.xml */
	public static final String QUERY_ID_CREATE_CREATE_PROCEDURE_GET_REMAININNG_DAYS = "create_procedure_get_remaing_days";
	
	/** Constant for query id of drop_procedure_totaldays in Query.xml */
	public static final String QUERY_ID_DROP_PROCEDURE_TOTAODAY = "drop_procedure_totaldays";
	
	/** Constant for query id of drop_procedure_get_remaing_days in Query.xml */
	public static final String QUERY_ID_DROP_PROCEDURE_GET_REMAINING_DAYS = "drop_procedure_get_remaing_days";
	
	/** Constant for query id of drop_all_po1 in Query.xml */
	public static final String QUERY_ID_DELETE_ALL_PO1 = "drop_all_po1";
	
	/** Constant for query id of drop_all_po1 in Query.xml */
	public static final String QUERY_ID_DELETE_ALL_PO2 = "drop_all_po2";
	
	/** Constant for query id of drop_all_po1 in Query.xml */
	public static final String QUERY_ID_DELETE_ALL_PO3 = "drop_all_po3";
	
	/** Constant for query id of drop_all_po1 in Query.xml */
	public static final String QUERY_ID_DELETE_ALL_PO4 = "drop_all_po4";
	
	/** Constant for query id of drop_all_po1 in Query.xml */
	public static final String QUERY_ID_DELETE_QUOTATION_BY_ID = "delete_quotation_by_id";
	
	/** Constant for query id of drop_all_po1 in Query.xml */
	public static final String QUERY_ID_DELETE_QUOTATION_DETAIS_BY_ID = "delete_quotation_details_by_id";
	
	
	/** Constant for query id of drop_all_po1 in Query.xml */
	public static final String QUERY_ID_UPDATE_PURCHASE_ORDER_STATUS = "update_purchase_order_status";
	
	/** Constant for query id of drop_all_po1 in Query.xml */
	public static final String QUERY_ID_GET_QUOTATION_COUNT_FOR_PO = "get_quotation_count";
	
	/** Constant for query id of update_quotation_status in Query.xml */
	public static final String QUERY_ID_UPDATE_QUOTATION_STATUS = "update_quotation_status";
	
	/** Constant for query id of get_qutation_by_id_and_status in Query.xml */
	public static final String QUERY_ID_GET_QUOTATION_BY_ID_AND_STATUS = "get_qutation_by_id_and_status";
	
	/** Constant for query id of add_im_notifications in Query.xml */
	public static final String QUERY_ID_ADD_IM_NOTIFICATIONS = "add_im_notifications";
	
	/** Constant for query id of select_all_notifications_of_owner in Query.xml */
	public static final String QUERY_ID_SELECT_ALL_FROM_NOTIFICATION_BY_OWNER = "select_all_notifications_of_owner";
	
	/** Constant for query id of get_count_of_im_nitifications in Query.xml */
	public static final String QUERY_ID_GET_IM_NOTIFICATION_COUNT = "get_count_of_im_nitifications";
	
	/** Constant for query id of update_im_notification_status in Query.xml */
	public static final String QUERY_ID_UPDATE_IM_NOTIFICATION_STATUS = "update_im_notification_status";
	
	
	/**
	 * @Student_ID : IT18180626
	 * @Name : H.M.A.N.Welagedara
	 */

	/** Constant for prefix of Product table primary key */
	public static final String PRODUCT_PREFIX = "PRO-0";

	/**
	 * Constant for query id of get_SupplerProduct_table_entry_count in Query.xml
	 */
	public static final String QUERY_ID_GET_SUPLIER_PRODUCT_TABLE_ENTRY_COUNT = "get_Supplier_product_table_entry_count";

	/** Constant for query id of add_supplierProduct_table */
	public static final String QUERY_ID_ADD_PRODUCT_TABLE = "add_Supplier_product_table";

	/** Constant for query id of delete_supplierProduct_table */
	public static final String QUERY_ID_DELETE_PRODUCT_BY_SUP_ID = "delete_all_supplier_products";

	/** Constant for query id of get_supplier_products */
	public static final String QUERY_ID_GET_SUPPLIER_PRODUCTS = "get_supplier_products";

	/** Constant for query id of get_supplier_product_by_id */
	public static final String QUERY_ID_DELETE_SUPPLIER_PRODUCT_BY_ID = "get_supplier_product_by_id";

	/** Constant for prefix of Supplier table primary key */

	public static final String SUPPLIER_PREFIX = "SUP-0";
	/** Constant for prefix of Supplier Account table entry count in Query.xml */

	public static final String QUERY_ID_GET_SUPLIER_ACCOUNT_TABLE_ENTRY_COUNT = "get_Supplier_Account_table_entry_count";

	/** Constant for query id of add_suppliers_to_table */
	public static final String QUERY_ID_ADD_SUPPLIERS_TABLE = "add_Suppliers_table";

	/** Constant for query id of get_suppliers_to_table_to_view */
	public static final String QUERY_ID_GET_SUPPLIER_TABLE = "get_Suppliers_table_to_view";
	
	/** Constant for query id of delete_supplier_table */
	public static final String QUERY_ID_DELETE_SUPPLIER_TABLE = "delete_all_supplier_table";
	
	
	/** Constant for query id of get_supplier_account_by_id */
	public static final String QUERY_ID_DELETE_SUPPLIER_ACCOUNTS_BY_ID = "get_supplier_account_by_id";
	
	/** Constant for query id of update_supplier_account */
	public static final String QUERY_ID_UPDATE_SUPPLIER_ACCOUNT = "update_supplier_account";
	
	/** Constant for query id of get_supplier_details_by_ID */
	public static final String QUERY_ID_GET_SUPPLIER_DETAILS_BY_ID = "get_supplier_details_by_ID";
	
	/** Constant for query id of get_supplier_details_by_ID */
	public static final String QUERY_ID_GET_PRODUCT_BY_ID = "get_product_by_ID";
	
	/** Constant for query id of get_supplier_details_by_ID */
	public static final String QUERY_ID_UPDATE_PRODUCT_BY_ID = "update_product_by_ID";
	
	/** Constant for query id of create_supplier_account */
	public static final String QUERY_ID_CREATE_TABLE_SUPPLIER_ACCOUNT = "create_supplier_account";
	
	/** Constant for query id of create_supplier_product */
	public static final String QUERY_ID_CREATE_TABLE_SUPPLIER_PRODUCT = "create_supplier_product";
	
	
	/** Constant for query id of create_supplier_product */
	public static final String QUERY_ID_DROP_TABLE_SUPPLIER_PRODUCT = "drop_supplier_product";
	
	/** Constant for query id of drop_supplier_account */
	public static final String QUERY_ID_DROP_TABLE_SUPPLIER_ACCOUNT = "drop_supplier_account";
	
	/** Constant for query id of get_all_suppliers_products */
	public static final String QUERY_ID_GET_ALL_SUPPLIERS_PRODUCTS = "get_all_suppliers_products";
	
	
	//Location
	
	/** Constant for query id of create_table in Query.xml */
	public static final String QUERY_ID_CREATE_LOC_TRAN_TABLE = "create_loc_tran_table";
	
	/** Constant for query id of get an location transaction in Query.xml */
	public static final String QUERY_ID_GET_LOCATION_TRANSACTION = "loc_tran_by_id";
	
	/** Constant for Location id prefix */
	public static final int LOCATION_ID_PREFIX = 1111;
	
	
	/** Constant for query id of add location transaction request in Query.xml */
	public static final String QUERY_ID_ADD_LOCATION_TRANS_REQ = "location_transaction_req";
	
	
	/** Constant for query id of get all location_Transaction in Query.xml */
	public static final String QUERY_ID_ALL_location_Transaction = "all_location_Transactions";
	
	/** Constant for query id of get all location_Transaction ids in Query.xml */
	public static final String QUERY_ID_GET_LOCATION_TRANS_IDS = "loc_tran_ids";
	
	
	/** Constant for query id of update a employee in Query.xml */
	public static final String QUERY_ID_UPDATE_LOCATION_TRANS_REQ = "update_location_Transactions_req";
	
	/** Constant for query id of remove a location_Transactions_req in Query.xml */
	public static final String QUERY_ID_REMOVE_LOCATION_TRANS_REQ = "remove_location_Transactions_req";
	
	/** Constant for  admin confirm location transaction request  */
	public static final String QUERY_UPDATE_STATUS_ADMIN_CONFIRM = "update_status_admin_confirm";
	
	/** Constant for  admin confirm location transaction request  */
	public static final String QUERY_UPDATE_STATUS_ADMIN_DELETE = "update_status_admin_delete";
	
	//Customer
	
	public static final String QUERY_ID_SEARCH_TODO_BY_ID = "search_todo_by_id";

	public static final String QUERY_ID_SEARCH_TODO_BY_STATUS = "search_todo_by_status";

	public static final String QUERY_ID_SEARCH_TODO_BY_PRIORITY = "search_todo_by_priority";

	public static final String QUERY_ID_SEARCH_CUSTOMETR_BY_MOBILE = "search_customer_by_mobile";

	public static final String QUERY_ID_SEARCH_CUSTOMETR_BY_EMAIL = "search_customer_by_email";

	public static final String QUERY_ID_SEARCH_CUSTOMETR_BY_TYPE = "search_customer_by_type";

	public static final String QUERY_ID_SEARCH_CUSTOMETR_BY_NAME = "search_customer_by_name";

	public static final String QUERY_ID_SEARCH_CUSTOMETR_BY_ID = "search_customer_by_id";

	public static final String QUERY_ID_ADD_CUSTOMETR_TABLE = "add_customer_table";

	public static final String QUERY_ID_CHECK_CUSTOMETR_AVAILABILITY = "check_customer_availability";

	public static final String QUERY_ID_CHECK_TODO_AVAILABILITY = "check_todo_availability";

	public static final String QUERY_ID_GET_CUSTOMER_TABLE = "get_customer_table";

	public static final String QUERY_ID_DELETE_FROM_CUSTOMER = "delete_customer_table";

	public static final String QUERY_ID_UPDATE_CUSTOMER_ITEM = "update_customer_table";

	public static final String QUERY_ID_ADD_LIST_TABLE = "add_list_table";

	public static final String QUERY_ID_GET_CUSTOMER_ID = "customer_ids";

	public static final String QUERY_ID_GET_TODOLIST_TABLE = "get_todolist_table";

	public static final String QUERY_ID_GET_CUSTOMER_BY_ID = "customer_by_id";

	// CommonConstants.QUERY_ID_DELETE_FROM_TODOLIST

	public static final String QUERY_ID_DELETE_FROM_TODOLIST = "delete_todolist_table";

	public static final String QUERY_ID_GET_TODOLIST_BY_ID = "list_by_id";

	public static final String QUERY_ID_UPDATE_TODOLIST_ITEM_BY_ID = "update_todolist_table";

	// public static final String QUERY_ID_GET_EMPLOYEE_IDS = "employee_ids";
	
}
