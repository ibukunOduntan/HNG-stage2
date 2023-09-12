package com.Zuri2;

public class DeleteMessage {

        private String message;
        private ZuriDomain deleted_user;

        public DeleteMessage(String message, ZuriDomain deleted_user) {
            this.message = message;
            this.deleted_user = deleted_user;
        }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ZuriDomain getDeleted_user() {
        return deleted_user;
    }

    public void setDeleted_user(ZuriDomain deleted_user) {
        this.deleted_user = deleted_user;
    }
    // getters and setters
    }

