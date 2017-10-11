package com.event.bean;

import java.util.List;
import javax.persistence.*;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Event_Id")
	private Long eId;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Event_Id")
	private List<Agenda> agenda;

	public Event() {
		super();
		
	}


	public Long geteId() {
		return eId;
	}

	public void seteId(Long eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAgenda(List<Agenda> agenda) {
		this.agenda = agenda;
	}

	public List<Agenda> getAgenda()
	{
		return agenda;
	}
}
