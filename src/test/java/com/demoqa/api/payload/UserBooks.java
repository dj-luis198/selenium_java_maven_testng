package com.demoqa.api.payload;

import java.util.ArrayList;

public class UserBooks {

    String userId;
    ArrayList<Isbn> collectionOfIsbns;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<Isbn> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setCollectionOfIsbns(ArrayList<Isbn> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }
}
