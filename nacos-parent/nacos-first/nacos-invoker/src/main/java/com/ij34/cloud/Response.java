package com.ij34.cloud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description ServerResponse
 * Date 20/4/2022
 * Created by www.ij34.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Integer code;
    private Object data;
    private String msg;
    public static Response success(Object data){
        return new Response(0,data,"ok");
    }

    public static Response error(String msg){
        return new Response(0,null,msg);
    }
}
