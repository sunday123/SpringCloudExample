package com.ij34.cloud;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TitleController {
     @RequestMapping(value="/title/{titleID}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Title getTitleByID(@PathVariable("titleID") Integer id){
		return new Title(id, "标题"+id, "内容...");
	}
}
