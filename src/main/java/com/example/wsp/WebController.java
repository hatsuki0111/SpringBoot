package com.example.wsp;

import com.example.wsp.model.Authn;
import com.example.wsp.model.SignService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.wsp.model.RetrospectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;


@Controller
public class WebController {


    @Autowired
    private RetrospectService service;
    @Autowired
    private SignService Signservice;

    @Autowired
    private HttpSession httpSession;


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
    public String signed(String userId, String passphrase,String userName,String userRole, Model model){

       if(Signservice.doSignIn(userId, passphrase)){
            model.addAttribute("userId",userId);

           System.out.println("利用中のブラウザ識別番号:"+httpSession.getId());
           httpSession.setAttribute("userId",userId);
            return "signed";
        }else{
           return "signin";
        }

    }

    @GetMapping("Profile")
    public String profile(Model model){
        System.out.println("利用中のブラウザ識別番号:"+httpSession.getId());
        var userId = (String) httpSession.getAttribute("userId");
        model.addAttribute("userId",userId);

        //userIdを元にデータとる
        var authn = Signservice.getAuthn(userId);
        model.addAttribute("userName",authn.getUserName());
        model.addAttribute("userRole",authn.getUserRole());
        return "profile";
    }

    @GetMapping("Signed")
    public String signed(Model model){
        System.out.println("利用中のブラウザ識別番号:"+httpSession.getId());
        var userId = (String) httpSession.getAttribute("userId");
        model.addAttribute("userId",userId);
        return "signed";
    }

    @GetMapping("SignOut")
    public String signout(Model model){
        httpSession.invalidate();
        return "signin";
    }
}



