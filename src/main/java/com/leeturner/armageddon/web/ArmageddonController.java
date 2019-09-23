package com.leeturner.armageddon.web;

import com.leeturner.armageddon.nasa.apod.ApodApiClient;
import com.leeturner.armageddon.nasa.apod.model.Apod;
import com.leeturner.armageddon.nasa.neo.NeoApiClient;
import com.leeturner.armageddon.nasa.neo.model.Neos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArmageddonController {

    private ApodApiClient apodApiClient;
    private NeoApiClient neoApiClient;

    @Autowired
    public ArmageddonController(ApodApiClient apodApiClient, NeoApiClient neoApiClient) {
        this.apodApiClient = apodApiClient;
        this.neoApiClient = neoApiClient;
    }

    @RequestMapping("/")
    public ModelAndView index() {
        Apod apod = this.apodApiClient.getApod();
        Neos neos = this.neoApiClient.getNeos();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("apod", apod);
        modelAndView.addObject("neos", neos);
        return modelAndView;
    }

}
