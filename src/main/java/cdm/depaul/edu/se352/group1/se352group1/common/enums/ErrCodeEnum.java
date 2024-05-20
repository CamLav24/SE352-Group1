package cdm.depaul.edu.se352.group1.se352group1.common.enums;

import lombok.Getter;

@Getter
public enum ErrCodeEnum {

    SUCCESS("BM00001", "success"),
    FAIL("BM00002", "fail"),
    USER_NOT_EXIST("BM00003", "user not exist"),
    PARAM_ERROR("BM00005", "param error"),
    SEND_CODE_FAIL("BM00006", "send code error"),
    REFERRAL_CODE_NOT_EXIST("BM00007", "referral code does not exist"),
    VERIFY_CODE_NOT_EXIST("BM00008", "verify code does not exist"),
    INTERNAL_SERVER_ERROR("BM00009", "Internal error occurred. Please try again later."),
    EMAIL_TEMPLATE_EXIST("BM00010", "Email template already exists"),
    PRODUCT_NOT_EXIST("BM00011", "Product does not exist"),
    TOKEN_EXPIRED("BM00013", "please authorize again!"),
    NO_AUTHORIZATION("BM00014", "not permitted"),
    EMAIL_TIMES_OUT_LIMIT("BM00014", "emails out of limit"),
    OUT_OF_QUOTE("BM00015", "too many emails to send"),
    NO_DEFAULT_EMAIL_TEMPLATE("BM00016", "no default email template"),
    NETWORK_ERROR("BM99999", "Network error, please try again later.");



    private final String code;

    private final String desc;

    ErrCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
