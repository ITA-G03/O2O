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





}
