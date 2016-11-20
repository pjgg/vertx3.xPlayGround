package org.pablo.dto;


import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PlainMessageDto implements Serializable {

    @NotNull
    @NotEmpty
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
}
