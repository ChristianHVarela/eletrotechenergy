package br.eletrotech.energia.model;

import java.io.Serializable;

import lombok.Data;

@Data
public abstract class EntityTenant implements Serializable {
	
	private static final long serialVersionUID = -9069214903758745978L;

	public abstract Long getId();

}
