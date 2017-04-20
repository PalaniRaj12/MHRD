package service;

import bean.Adminallschemeviewbean;
import bean.Adminloginbean;
import bean.SchemeCreationbean;
import dao.Logindao;
import java.util.ArrayList;

public class Loginadmin {

    Logindao ldao=new Logindao();
    public Adminloginbean selectuseradmin(String un, String pw) {
        
        
        return ldao.adminselect(un,pw);
    }	

    public ArrayList<Adminallschemeviewbean> allschemeview() {
      return ldao.allschemeview();
    }
}
