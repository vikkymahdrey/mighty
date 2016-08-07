package com.team.mighty.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.mighty.constant.MightyAppConstants;

/**
 * 
 * @author Shankara
 *
 */
@Entity
@Table(name = MightyAppConstants.CONSUMER_TABLE)
public class ConsumerInstrument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long consumerId;
}
