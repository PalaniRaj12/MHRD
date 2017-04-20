/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Vignesh
 */
public class Eligible_list_bean {
 
    private String scheme_name;
    private String scheme_code;
    private String scheme_link;
    private int uage;

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }
    

    
    public String getScheme_link() {
        return scheme_link;
    }

    public void setScheme_link(String scheme_link) {
        this.scheme_link = scheme_link;
    }

    public String getScheme_name() {
        return scheme_name;
    }

    public void setScheme_name(String scheme_name) {
        this.scheme_name = scheme_name;
    }

    public String getScheme_code() {
        return scheme_code;
    }

    public void setScheme_code(String scheme_code) {
        this.scheme_code = scheme_code;
    }
}
