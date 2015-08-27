package ita.o2o.constants;

/**
 * @author Aquariuslt
 * @version 15-08-23
 */
public class O2OConstants {
    public static final String EMPTY="";

    public static final String SUCCESS="success";
    public static final String FAILURE="failure";

    public static final int BUSINESS_STATUS_PENDING = 1;
    public static final int BUSINESS_STATUS_APPROVE = 2;
    public static final int BUSINESS_STATUS_REJECT = 3;
    public static final int BUSINESS_STATUS_HOT = 4;
    public static final String BUSINESS_DELIVERY_TIME = "30";

    //角色
    public static final int ROLE_ADMINISTRATOR=1;
    public static final int ROLE_BUSINESS=2;
    public static final int ROLE_CUSTOMER=3;


    //各种状态
    public static final int STATUS_APPROVING=1;
    public static final int STATUS_DELETED=2;
    public static final int STATUS_REJECTED=3;
    public static final int STATUS_ACCEPTED=4;
    public static final int STATUS_HOT=5;


    //各种状态之~订单状态
    //新下订单  NEW_ORDER
    //商家接收  BUSINESS_ACCEPTED
    //正在配送  FOOD_SENT_OUT
    //已经完成  FINISHED
    public static final int STATUS_NEW_ORDER=10;
    public static final int STATUS_BUSINESS_ACCEPTED=11;
    public static final int STATUS_FOOD_SENT_OUT=12;
    public static final int STATUS_FINISHED=13;

    //商家状态
    public static final int WORK_STATUS_WORKING=1;
    public static final int WORK_STATUS_CLOSE=2;



    /*常见返回值定义*/
    public static final int UPLOAD_FAILURE=-1;

    public static final int LOGIN_SUCCESS=1;
    public static final int LOGIN_USER_NOT_EXIST = 2;
    public static final int LOGIN_PASSWORD_WRONG=3;
    public static final int LOGIN_USER_APPROVING=4;



    public static final int DEFAULT_FAILURE_RESULT=0;
    public static final int DEFAULT_FAILURE_CODE=-1;


    //用户更新Password操作返回值
    public static final int USER_UPDATE_OLD_PASSWORD_WRONG = 0;
    public static final int USER_UPDATE_SUCCESS = 1;
}
