package com.kodekonveyor.work_request;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class WorkRequestDTO {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long workRequestId;
  private String workType;
  private AddressDTO address;
  private String description;
  private WorkRequestStatusEnum status;

}
