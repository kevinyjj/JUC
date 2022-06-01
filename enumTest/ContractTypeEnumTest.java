package com.example.demo.enumTest;

public class ContractTypeEnumTest {
    public static void main(String[] args) {
        ContractTypeEnum.getValueByName("DS");
    }
}


enum ContractTypeEnum {
    DS("DS", "直销员推销合同"),
    NFT("NFT", "非全日制销售员工劳动合同"),
    FT("FT","非全日制销售员工劳动协议"),
    IM("IM", "经销商合同"),
    /**
     * 晋升NFT
     */
    TO_NFT("TO_NFT","非全日制销售员工劳动合同"),
    TO_FT("TO_FT","非全日制销售员工劳动协议"),
    /**
     * 转签
     */
    CHANGE_FT("CHANGE_FT","非全日制销售员工劳动协议"),
    CHANGE_NFT("CHANGE_NFT","非全日制销售员工劳动合同"),
    DS_TERMINATE("DS_TERMINATE","直销员申请解约"),
    NFT_TERMINATE("NFT_TERMINATE","非全日制销售员工劳动合同申请解约"),
    FT_TERMINATE("FT_TERMINATE","非全日制销售员工劳动协议申请解约"),
    DS_NEW_DS("DS_NEW_DS","直销员推销合同"),
    NFT_NEW_NFT("NFT_NEW_NFT","非全日制销售员工劳动合同"),
    FT_NEW_FT("FT_NEW_FT","非全日制销售员工劳动协议"),
    OTHER("OTHER","其他合同"),
    ;

    private String name;
    private String value;

    ContractTypeEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }


    public static String getValueByName(String name){
        for (ContractTypeEnum contractTypeEnum : ContractTypeEnum.values()) {
            if (contractTypeEnum.getName().equals(name)){
                return contractTypeEnum.getValue();
            }
        }
        return null;
    }

    public static ContractTypeEnum match(String name) {
        for (ContractTypeEnum code : values()) {
            if (code.getName().equalsIgnoreCase(name)) {
                return code;
            }
        }
        return OTHER;
    }

    public  String getName() {
        return name;
    }

    public  String getValue() {
        return value;
    }
}
