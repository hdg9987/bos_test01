package com.ying96.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ying96.domain.base.Standard;
import com.ying96.service.StandardService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by dell on 2017/9/14.
 */

@ParentPackage("json-default")
@Namespace("/")
@Controller
@Actions
@Scope("prototype")
public class StandardAction extends ActionSupport implements ModelDriven<Standard>{

    private Standard standard = new Standard();

    @Autowired
    private StandardService standardService ;
    @Override
    public Standard getModel() {
        return standard;
    }

    @Action(value="standard_save",results ={@Result(name = "success",type = "redirect",location = "./pages/base/standard.html")})
    public  String  save(){

        standardService.save(standard);

        return SUCCESS ;
    }


    @Action(value = "standard_validate",results = {@Result(name="success",type ="json")})
    public String validateName(){

        String name = standard.getName() ;
        List<Standard> list = standardService.findByName(name);

        if(list!=null && list.size()==0){
            ServletActionContext.getContext().getValueStack().push(true);
        }else{
            ServletActionContext.getContext().getValueStack().push(false);
        }

        return SUCCESS;
    }


}
