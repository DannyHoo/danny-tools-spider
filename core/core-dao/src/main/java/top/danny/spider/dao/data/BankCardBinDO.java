package top.danny.spider.dao.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BankCardBinDO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * CNBankCard 中国各大银行卡号查询 https://my.oschina.net/u/1453975/blog/529521
 * @Company: lxjr.com
 * @Created on 2017-03-04 11:05:00
 */
@Entity
@Table(name="t_bank_card_bin")
public class BankCardBinDO extends BaseEntity {
    /**卡BIN**/
    @Column(name = "cardBin")
    private String cardBin;

    /**发卡行**/
    @Column(name = "bankName")
    private String bankName;

    /**发卡行代码**/
    @Column(name = "bankCode")
    private Integer bankCode;

    /**卡种名称**/
    @Column(name = "cardName")
    private String cardName;

    /**银行卡类型**/
    @Column(name = "cardType")
    private String cardType;

    /**银行卡类型**/
    @Column(name = "binDigits")
    private Integer binDigits;

    /**银行卡类型**/
    @Column(name = "cardDigits")
    private Integer cardDigits;

    public String getCardBin() {
        return cardBin;
    }

    public BankCardBinDO setCardBin(String cardBin) {
        this.cardBin = cardBin;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public BankCardBinDO setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public Integer getBankCode() {
        return bankCode;
    }

    public BankCardBinDO setBankCode(Integer bankCode) {
        this.bankCode = bankCode;
        return this;
    }

    public String getCardName() {
        return cardName;
    }

    public BankCardBinDO setCardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    public String getCardType() {
        return cardType;
    }

    public BankCardBinDO setCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public Integer getBinDigits() {
        return binDigits;
    }

    public BankCardBinDO setBinDigits(Integer binDigits) {
        this.binDigits = binDigits;
        return this;
    }

    public Integer getCardDigits() {
        return cardDigits;
    }

    public BankCardBinDO setCardDigits(Integer cardDigits) {
        this.cardDigits = cardDigits;
        return this;
    }
}
