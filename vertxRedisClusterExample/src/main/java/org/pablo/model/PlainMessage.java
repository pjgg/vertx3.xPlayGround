package org.pablo.model;


import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

import java.io.Serializable;

public class PlainMessage implements Serializable {

    private String msg;

    private Long createdAt;

    private Long updatedAt;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String toJson(){
       return new JsonObject(Json.encode(this)).encode();
    }

    public static PlainMessage fromJson(String json){
        return Json.decodeValue(json, PlainMessage.class);
    }
}
