/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Eligible_list_bean;
import bean.Userbean;
import dao.Eligibledao;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vignesh
 */
public class Eligibleadmin {

    Eligibledao edao=new Eligibledao();
    public ArrayList<Eligible_list_bean> selecteligibleschemes(HttpSession session ,int age) {
        
        return edao.filtereligiblescheme(session,age);
    }

   /* public ArrayList<Eligible_list_bean> agescheme(int age) {
        return edao.schemeage(age);
    }*/

    public void apply(HttpSession session,ArrayList<Eligible_list_bean> al, String aadhar) {
        
        edao.uapply(session,al,aadhar);
    }
    
}
