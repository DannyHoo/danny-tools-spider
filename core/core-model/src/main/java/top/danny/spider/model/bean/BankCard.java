package top.danny.spider.model.bean;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BankCardDO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-03-04 11:05:00
 */
public class BankCard extends BaseBean {
    /**卡BIN**/
    private String bankBinCode;

    /**发卡行**/
    private String bankName;

    /**卡种名称**/
    private String cardTypeName;

    public String getBankBinCode() {
        return bankBinCode;
    }

    public BankCard setBankBinCode(String bankBinCode) {
        this.bankBinCode = bankBinCode;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public BankCard setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public BankCard setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
        return this;
    }
}
