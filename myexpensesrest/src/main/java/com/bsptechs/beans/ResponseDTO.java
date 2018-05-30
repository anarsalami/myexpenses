/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.beans;

import lombok.Data;

/**
 *
 * @author sarkhanrasullu
 */
@Data
public class ResponseDTO {
    private int code;
    private String message;
    private Object data;

    public ResponseDTO() {
    }

    public ResponseDTO(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    
    public static ResponseDTO successResp(Object data){
        return new ResponseDTO(200, null, data);
    }
    
    public static ResponseDTO successResp(){
        return new ResponseDTO(200, null, null);
    }
    
}
