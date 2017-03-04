package top.danny.spider.dao.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BankCardDO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-03-04 11:05:00
 */
@Entity
@Table(name="t_bank_card")
public class BankCardDO extends BaseEntity {
    /**卡BIN**/
    @Column(name = "bankBinCode")
    private String bankBinCode;

    /**发卡行**/
    @Column(name = "bankName")
    private String bankName;

    /**卡种名称**/
    @Column(name = "cardTypeName")
    private String cardTypeName;

    public String getBankBinCode() {
        return bankBinCode;
    }

    public BankCardDO setBankBinCode(String bankBinCode) {
        this.bankBinCode = bankBinCode;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public BankCardDO setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public BankCardDO setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
        return this;
    }
}
