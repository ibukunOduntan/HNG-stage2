package com.Zuri2;

public class ResponseMessage {

        private String message;
        private ZuriDomain updatedDetails;

        public ResponseMessage(String message, ZuriDomain updatedDetails) {
            this.message = message;
            this.updatedDetails = updatedDetails;
        }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ZuriDomain getUpdatedDetails() {
        return updatedDetails;
    }

    public void setUpdatedDetails(ZuriDomain updatedDetails) {
        this.updatedDetails = updatedDetails;
    }
    // getters and setters
    }

