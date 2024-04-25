package com.example.demo;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.DataProcRequirement;
import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.SciencePlan.STATUS;
import edu.gemini.app.ocs.model.SciencePlan.TELESCOPELOC;
import edu.gemini.app.ocs.model.StarSystem.CONSTELLATIONS;
import edu.gemini.app.ocs.model.StarSystem;

import org.h2.store.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class DemoController {

    @CrossOrigin
    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    // get all science plans
    // @CrossOrigin
    // @GetMapping("/scienceplans")
    // public ArrayList<SciencePlan> gettAllSciencePlans() {
    //     OCS o = new OCS();
    //     System.out.println(o.getAllSciencePlans());
    //     return o.getAllSciencePlans();
    // }

    @CrossOrigin
    @GetMapping("/scienceplans")
    public ArrayList<SciencePlan> gettAllSciencePlans() {
        MyOCS o = new MyOCS();
        System.out.println(o.getAllSciencePlans());
        return o.getAllSciencePlans();
    }

    @CrossOrigin
    @GetMapping("/testsubmit")
    public String submitSciencePlan() {
        OCS o = new OCS();
        SciencePlan sp = new SciencePlan();
        ArrayList<SciencePlan> sciencePlans = o.getAllSciencePlans();
        for (SciencePlan s : sciencePlans) {
            if (s.getPlanNo() == 1) {
                sp = s;
            }
        }
        System.out.println(o.testSciencePlan(sp));
        return "Science Plan Submitted";
    }


    // example of how to get a science plan by id
    @CrossOrigin
    @PostMapping("/getscienceplan")
    public SciencePlan test(@RequestParam int id) {
        OCS o = new OCS();
        return o.getSciencePlanByNo(id);
    }

    
    // test science plan
    @CrossOrigin
    @PostMapping("/testscienceplan")
    public String testSciencePlan(@RequestParam int id) {
        OCS o = new OCS();
        SciencePlan sp = new SciencePlan();
        sp = o.getSciencePlanByNo(id);
        // DataProcRequirement dpr = new DataProcRequirement();
        // ArrayList<DataProcRequirement> dpr_data = sp.getDataProcRequirements();
        // for (DataProcRequirement d : dpr_data) {
        //     dpr = d;
        // }
        // dpr.setContrast(3);
        // sp.setStarSystem(CONSTELLATIONS.Virgo);
        return o.testSciencePlan(sp);
        // return o.submitSciencePlan(sp);
    }

    // submit science plan
    @CrossOrigin
    @PostMapping("/submitscienceplan")
    public String submitSciencePlan(@RequestParam int id) {
        OCS o = new OCS();
        SciencePlan sp = new SciencePlan();
        sp = o.getSciencePlanByNo(id);
        if (sp.getStatus() == STATUS.SUBMITTED) {
            return "Science Plan Already Submitted";
        }
        return o.submitSciencePlan(sp);
    }


    @CrossOrigin
    @PostMapping("/updatescienceplan")
    public String updateSciencePlan(@RequestBody SciencePlan sp) {
        MyOCS o = new MyOCS();
        return o.createSciencePlan(sp);
    }

    // create a new science plan
    @CrossOrigin
    @PostMapping("/createscienceplan")
    public String createscienceplan(@RequestBody SciencePlan sp){
        MyOCS o = new MyOCS();
        return o.createSciencePlan(sp);
    }


    // TODO: install a new configuration
    @CrossOrigin
    @PostMapping("/installconfig")
    public String installConfiguration(@RequestBody ) {
        OCS o = new OCS();
        return o.addConfiguration(dpr);
    }

    // TODO: get all configurations
    @CrossOrigin
    @GetMapping("/getconfig")
    public String getConfigurations() {
        OCS o = new OCS();
        return o.getConfigurations();
    }

    // TODO: Validation

}
