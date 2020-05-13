package com.capgemini.hcm.response;

public class ResponseModel implements Response {
    private String message;
    private Integer status;
    private Object object;

    public ResponseModel(String message, Integer status, Object object) {
        this.message = message;
        this.status = status;
        this.object = object;
    }

    public ResponseModel() {
    }

    public static ResponseModelBuilder builder() {
        return new ResponseModelBuilder();
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getObject() {
        return this.object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String toString() {
        return "ResponseModel(message=" + this.getMessage() + ", status=" + this.getStatus() + ", object=" + this.getObject() + ")";
    }

    public static class ResponseModelBuilder {
        private String message;
        private Integer status;
        private Object object;

        ResponseModelBuilder() {
        }

        public ResponseModel.ResponseModelBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ResponseModel.ResponseModelBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public ResponseModel.ResponseModelBuilder object(Object object) {
            this.object = object;
            return this;
        }

        public ResponseModel build() {
            return new ResponseModel(message, status, object);
        }

        public String toString() {
            return "ResponseModel.ResponseModelBuilder(message=" + this.message + ", status=" + this.status + ", object=" + this.object + ")";
        }
    }
}
