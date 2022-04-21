package com.ij34.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;


@RestController
@Slf4j
public class TitleController {
	@Autowired
	private HttpServletRequest request;


	@RequestMapping(value="/title/{titleID}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Title getTitleByID(@PathVariable("titleID") Integer id){
		if (request.getHeader("token")!=null){
			log.info("token----"+request.getHeader("token"));
		}
		return new Title(id, "标题"+id, "内容...");
	}


	@RequestMapping(value="/title/add/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Mono<ServerResponse> add(@PathVariable("id") Integer id){
		log.info("req"+id);
		return Mono.just(ServerResponse.success(new Title(id, "标题"+id, "内容...")));
	}
}
