package com.emrecn.biletal.controller;
import com.emrecn.biletal.entity.Bus;
import com.emrecn.biletal.entity.Passenger;
import com.emrecn.biletal.servis.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/bus")
public class busController {

    private busService busServis;

    public busController(busService busServis) {
        this.busServis = busServis;
    }


    @GetMapping("/list")
    public String showBuses(Model model){
        List<Bus> theBuses = busServis.getAllbuses();

        model.addAttribute("buses",theBuses);

        return "bus-list";
    }

    @GetMapping("/busdetail")
    public String showTheBus(Model model, @RequestParam("busId") int Id){
        Bus  theBus = busServis.getbusById(Id);
        List<Passenger> passengers = theBus.getPassengers();
        model.addAttribute("passenger" , passengers);
        return "get-bus-detail";
    }


    @GetMapping("/formForAdd")
    public String showFormForAdd(Model model){

        Bus tempBus = new Bus();

        model.addAttribute("newBus",tempBus);

        return "Form-Add";
    }

    @PostMapping("/save")
    public String saveTheBus(@ModelAttribute("newBus") Bus theNewBus){
        busServis.saveBus(theNewBus);
        return "redirect:/bus/list";
    }

    @GetMapping("/formForPassengerAdd")
    public String showFormForAddPassenger(Model model,@RequestParam("busId") int Id){
        Bus tempBus = busServis.getbusById(Id);
        Passenger tempPassanger = new Passenger();
        model.addAttribute("newPassenger",tempPassanger);
        model.addAttribute("tempBus",tempBus);
        return "Form-Add-Passanger";
    }

    @GetMapping("/update")
    public String updateTheBus(Model model,@RequestParam("busId") int Id){
        Bus tempbus =  busServis.getbusById(Id);
        model.addAttribute("newBus",tempbus);
        return "Form-Add";
    }

    @GetMapping("/delete")
    public String deleteTheBus(@RequestParam("busId") int Id){
        busServis.deletebusById((long) Id);
        return "redirect:/bus/list";
    }
}