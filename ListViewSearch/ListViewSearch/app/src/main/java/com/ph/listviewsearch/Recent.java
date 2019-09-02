package com.ph.listviewsearch;

/**
 * Created by phkim on 2017-01-17.
 */

public class Recent {
    private String address;
    private String link;

    public Recent(String _address,String _link){
        address = _address;
        link= _link;
    }

    public String getAddress() {
        return address;
    }

    public String getLink() {
        return link;
    }
}
