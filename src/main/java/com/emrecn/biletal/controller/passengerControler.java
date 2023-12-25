package com.emrecn.biletal.controller;
import com.emrecn.biletal.servis.*;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.emrecn.biletal.entity.*;

import java.util.List;

@Controller
@RequestMapping("/Passenger")
public class passengerControler {
    private passengerService passengerService;
    public passengerControler(passengerService passengerService) {
        this.passengerService = passengerService;
    }
    @PostMapping("/save")
    public String saveThePassenger(@ModelAttribute("newPassenger") Passenger theNewPassenger,@RequestParam("busId") int Id){

        passengerService.savePassenger(theNewPassenger,Id);
        return "redirect:/bus/list";
    }
    @GetMapping("/update")
    public String updateThePassenger(@RequestParam("tc") int tc, Model model){
        Passenger passenger = passengerService.findPassBytcNo(tc);
        model.addAttribute("newPassenger",passenger);
        model.addAttribute("tempBus",passenger.getBus());
        return "Form-Add-Passanger";
    }

    @GetMapping("delete")
    public String deleteThePassenger(@RequestParam("tc") int tc){
        Passenger passenger = passengerService.findPassBytcNo(tc);
        passengerService.deleteThePassenger(passenger);
        return "redirect:/bus/list";
    }
}
