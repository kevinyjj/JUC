package com.example.demo.enumTest;

public enum DayEnum {
    MONDAY("星期一","第一天上班"),
    TUESDAY("星期二","第二天上班"),
    WEDNESDAY("星期三","第三天上班"),
    THURSDAY("星期四","第四天上班"),
    FRIDAY("星期五","第五天上班"),
    SATURDAY("星期六","第一天休息"),
    SUNDAY("星期日","第二天休息");//记住要用分号结束

    private String name;//中文描述
    private String value;

    /**
     * 私有构造,防止被外部调用
     * @param name
     */
    private DayEnum(String name,String value){
        this.name=name;
        this.value=value;
    }

    /**
     * 定义方法,返回描述,跟常规类的定义没区别
     * @return
     */
    public String getName(){
        return name;
    }

    public String getValue(){
        return value;
    }

    public static void main(String[] args){
        for (DayEnum day:DayEnum.values()) {
            System.out.println("name:"+day.name()+
                    ",value:"+day.getValue());
        }
    }

    /**
     输出结果:
     name:MONDAY,desc:星期一
     name:TUESDAY,desc:星期二
     name:WEDNESDAY,desc:星期三
     name:THURSDAY,desc:星期四
     name:FRIDAY,desc:星期五
     name:SATURDAY,desc:星期六
     name:SUNDAY,desc:星期日
     */
}
