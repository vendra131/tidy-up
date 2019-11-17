package com.kodekonveyor.work_request.open;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class WorkRequestEntity {

	private String workType;

}
