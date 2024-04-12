package com.example.demo;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.DataProcRequirement;
import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.SciencePlan.TELESCOPELOC;
import edu.gemini.app.ocs.model.StarSystem;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @CrossOrigin
    @GetMapping("/scienceplans")
    public ArrayList<SciencePlan> gettAllSciencePlans() {
        OCS o = new OCS();
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
        // System.out.println(sp.getSubmitter());
        // System.out.println(sp.getDataProcRequirements());
        System.out.println(o.testSciencePlan(sp));
        

        // return "Science Plan Submitted";
        return "Science Plan Submitted";
    }

    // example of how to get a science plan by id
    @CrossOrigin
    @PostMapping("/getscienceplan")
    public String test(@RequestParam int id) {
        return "id: " + id;
    }

    @CrossOrigin
    @PostMapping("/testscienceplan")
    public String testSciencePlan(@RequestParam int id) {
        OCS o = new OCS();
        SciencePlan sp = new SciencePlan();
        sp = o.getSciencePlanByNo(id);
        // System.out.println(sp.getSubmitter());
        return o.testSciencePlan(sp);
    }



}
