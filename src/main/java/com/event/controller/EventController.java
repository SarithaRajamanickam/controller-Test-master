package com.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.UriComponentsBuilder;

import com.event.bean.Event;
import com.event.service.EventService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api//events")

public class EventController {

	@Autowired
	private EventService eventService;
   @GetMapping("/get")
    public ResponseEntity<List<Event>> all() {
      return new ResponseEntity<>(eventService.getAll(), HttpStatus.OK);
   }

	
 @PostMapping("/post")
      public ResponseEntity<?> post(@RequestBody Event event, UriComponentsBuilder ucBuilder) {
       eventService.save(event);
       HttpHeaders headers = new HttpHeaders();
       headers.setLocation(ucBuilder.path("/get/{eId}").buildAndExpand(event.geteId()).toUri());
       return new ResponseEntity<>(headers, HttpStatus.CREATED);

   }
 @GetMapping("/get/{eId}")
   public  ResponseEntity<?> geteId(@PathVariable Long eId) {

       Event event = eventService.find(eId);
       return new ResponseEntity<>(event, HttpStatus.OK);

   }


	 @PutMapping("/put/{eId}")
  public ResponseEntity<?> put(@PathVariable Long eId, @RequestBody Event event) {
      eventService.save(event);
      return new ResponseEntity<>(event, HttpStatus.OK);
  }

@DeleteMapping("/delete/{eId}")
  public ResponseEntity<?> delete(@PathVariable Long eId) {
      //Event currentevent = bookCategoryService.find(eventId);
      eventService.delete(eId);
      return new ResponseEntity<>(HttpStatus.OK);
  }


/*@RequestMapping(method = RequestMethod.GET)
	public List<Event> getAllEvents() {
       //System.out.println("--------------------------------"+eventService.getAll()+"--------------");
		return eventService.getAll();
	}

	// @RequestMapping(method = RequestMethod.POST)
	// public Event Save(@RequestBody Event item) {
	// 	return eventService.save(item);

	// }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Event find(@PathVariable Long id) {
	    return eventService.find(id);
	}*/
	// @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	// public void delete(@PathVariable Long id) {
	// 	eventService.delete(id);
	// }
}
