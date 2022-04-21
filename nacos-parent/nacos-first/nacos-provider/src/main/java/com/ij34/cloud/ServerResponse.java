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
public class ServerResponse {
    private Integer code;
    private Object data;
    private String msg;
    public static ServerResponse success(Object data){
        return new ServerResponse(0,data,"ok");
    }
}
