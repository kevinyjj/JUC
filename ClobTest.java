package com.example.demo;

import com.hundsun.jres.common.share.dataset.DatasetService;
import com.hundsun.jres.common.share.event.PackService;
import com.hundsun.jres.interfaces.share.dataset.IDataset;
import com.hundsun.jres.interfaces.share.event.IPack;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ClobTest {

    public static void main(String[] str) {
        List<Map<String, String>> param  = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("name","张三");
        map.put("age","10");
        param.add(map);
        IPack pack = PackService.getPacker(IPack.VERSION_2, "GBK");
        IDataset dataset = DatasetService.getInstace().getDataset((List)param);
        pack.addDataset(dataset);
        byte[] buff = pack.Pack();
        System.out.println(buff);
    }






}
