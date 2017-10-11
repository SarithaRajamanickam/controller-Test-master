package com.event.bean;

import javax.persistence.*;

@Entity
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;
	
	@Column(name = "postalcode")
	private String postalcode;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)    
	@JoinColumn(name = "Event_Id", updatable = false, insertable = true)
	
	private Event event;

	public Agenda() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity(){
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalcode(){
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	
}
//  public void setEvent(Event event)
//  {
//  	this.event=event;
// }
//  public Event getEvent(){
//  	return event;
// }
/*public String toString(){
	return Id+" "+street+" "+city+" "+postalcode+" "+event;
} */
	}
