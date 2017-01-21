package com.example.shayan.database;

/**
 * Created by shayan on 1/21/2017.
 */
public class Products {
    private int _id;
    private String PName;

    public Products(String PName) {
        this.PName = PName;
    }

    public int get_id() {
        return _id;
    }

    public String getPName() {
        return PName;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }
}
