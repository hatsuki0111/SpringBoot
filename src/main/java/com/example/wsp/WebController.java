package com.example.wsp;

import com.example.wsp.model.SignService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.wsp.model.RetrospectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;


@Controller
public class WebController {


    @Autowired
    private RetrospectService service;
    @Autowired
    private SignService Signservice;



    @GetMapping("test")
    @ResponseBody
    public String test(Model model) {
        return LocalDateTime.now().toString();
    }

    @GetMapping("GetPost")
    public String get(Model model) {
        return "retrospect";
    }

 /*   @PostMapping("GetPost")
    public String post(String text, Model model) {
        var tmp = "name='text'でPOSTされたデータ:" + text;
        System.out.println(tmp);
        model.addAttribute("message", tmp);
        model.addAttribute("postedAt", LocalDateTime.now());
        return "retrospect";
    }
*/
    @PostMapping("GetPost")
    public String post(String text, Model model){
        var message = service.register(text);
        model.addAttribute("message",message);
        var retrospectives = service.findAll();
        model.addAttribute("retrospectives",retrospectives);
        return "retrospect";
    }

    @GetMapping("SignIn")
    public String signIn(Model model){

        return "signin";
    }

    @PostMapping("Signed")
    public String signed(String userId,String passphrase,Model model){

       if(Signservice.doSignIn(userId, passphrase)){
            model.addAttribute("userId",userId);
            return "signed";
        }else{
           return "signin";
        }

    }

}



