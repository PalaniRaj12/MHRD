package service;

import bean.SchemeCreationbean;
import dao.SchemeCreationdao;
import java.util.ArrayList;
import util.DataException;

public class SchemeCreationadmin {

	SchemeCreationdao rdao=new SchemeCreationdao();
	
	public String insertdata(SchemeCreationbean lb) throws DataException {
		
		String res="";		
		res=rdao.reginsert(lb);		
		return res;
	}

    public String updatedata(SchemeCreationbean lb) {
        return rdao.updatescheme(lb);
    }

    public String deletedata(String scode) {
        return rdao.deletescheme(scode);
    }

    public SchemeCreationbean viewdata(String scode) {
        return rdao.viewscheme(scode);
    }

    public ArrayList<SchemeCreationbean> allschemefetch() {
        return rdao.allscheme();
    }

    public int usercheck(String scode) {
        return rdao.scodecheck(scode);
    }

	

}
