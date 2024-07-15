package com.vantisspace.sdk.shouqianba.common.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * example:
 * {
 * "request": {
 * "head": {
 * "sign_type": "SHA256",
 * "appid": "test_appid",
 * "request_time": "2019-09-26T19:57:29+08:00",
 * "version": "1.0.0"
 * },
 * "body": {
 * "store_sn": "SHA256",
 * "brand_code": "000000",
 * "check_sn": "000000001",
 * "workstation_sn": "0"
 * }
 * },
 * "signature": "g1FLM8OWt6YS1VQhiaFgt6EmHjV23uItAqSGBftf/fs1wi/Zmr6E5zzKToErYkQjYojHfnAw54IqXctCLWIG+quVlgmkpbxjLAgOhEMFbYYegdyycPVWpKqGYBQ5w+a9qRyJhIbTG49KGI7oNlQK4fzoEqUqWt+N352baqfFULJvYoCcNvalWh7qG81N+LndaThvJyNqGajUuZnRqouKYfzJcsVm7IPfMkSouqVRDlITzoaA9pDx0tNdTaDOIB1mAX5o/UmLrPqMvNsHJO3F5AZ7zPXJ6/AlbLd/34IjKJogYfF5jgtKGXstvYF1RsZtirLzNNWlQ11R8HOjSwQOFg=="
 * }
 */
@Data
public class SQBRequest<T> implements Serializable {
    private Request<T> request;
    private String signature;

    @Data
    public static class Request<T> {
        public Request(String appId, T body) {
            this.head = new Head();
            this.head.setAppid(appId);
            this.body = body;
        }

        private Head head;
        private T body;
    }

    public SQBRequest(Request<T> request, String signature) {
        this.request = request;
        this.signature = signature;
    }
}
