package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
  
public class UploadExcelController {
	@RequestMapping(value = { "/upload" }, method = RequestMethod.GET)
    public String index() {
        return "uploadPage";
    }


	
}
