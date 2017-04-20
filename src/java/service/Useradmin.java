/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Userbean;
import dao.Userdao;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Vignesh
 */
public class Useradmin {

    public String selectuser(HttpServletRequest request,String aadhar, String pin) {
        
            Userdao udao=new Userdao();
            return udao.userloginselect(request,aadhar,pin);
    }
    
}
